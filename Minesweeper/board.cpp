#include "board.hpp"

Board::Board() {
	//safegaurd to make sure IsGameOver() in the UI class doesnt return false before file reading
	cellsToWin = 1;
	xLim = 0;
	yLim = 0;
	charBuffer =  ' ';
	strBuffer = "";
	recursionBreak = false;
	rowBuffer = 0;
	columnBuffer = 0;


};


Board::Board(std::string file) {
	//IsGameOver() safe guard
	cellsToWin = 1;
	if (fileHandling(file)) {
	
		cells = new Cell* [xLim];
		for (int i = 0; i < xLim; i++) {
			cells[i] = new Cell[yLim];
		}

		strBuffer.empty();
		in.clear();
		in.seekg(0, std::ios::beg);

		mineWriting();

		in.close();

		adjacentMineWriting();
		recursionBreak = false;
	}
}

std::ostream& operator<< (std::ostream& out,  Board& rhs) {
	rhs.createString();
	out << rhs.getString();
	return out;

}

bool Board::internals(std::string file) {
	if (fileHandling(file)) {

		cells = new Cell * [xLim];
		for (int i = 0; i < xLim; i++) {
			cells[i] = new Cell[yLim];
		}

		strBuffer.empty();
		in.clear();
		in.seekg(0, std::ios::beg);

		mineWriting();

		in.close();

		adjacentMineWriting();


		print();
		return true;
	}
	return false;
}

bool Board::fileHandling(std::string file) {
	rowBuffer = 0;
	columnBuffer = 0;
	in.open(file);
	if (in.is_open()) {
		//retrieve board dimensions

		//testrun!
		while (!in.eof()) {
			strBuffer.empty();
			std::getline(in, strBuffer);
	
			//safeguard against an empty file
			if (in.eof()) {
	
				break;
			}
			columnBuffer++;
		}
		//safeguard against an empty file
		if (columnBuffer > 0) {
			columnBuffer++;
		}
		xLim = strBuffer.length();
		yLim = columnBuffer;
		cellsToWin = xLim * yLim;

		return true;
	}
	std::cout << "File failed to open.\n";
	return false;
}

Board::~Board() {
	std::cout << "\nScope exited: freeing memory\n";
	for (int i = 0; i < xLim; i++) {
		delete[] cells[i];
	}
	delete[] cells;
}

void Board::mineWriting() {
	for (int j = 0; j < yLim; j++) {
		strBuffer.empty();
		std::getline(in, strBuffer);
		for (int i = 0; i < xLim; i++) {
			if (strBuffer[i] != ' ') {
				cells[i][j].setMine(true);
				cellsToWin--;
			}
		}
	}
}

void Board::adjacentMineWriting() {
for (int i = 0; i < xLim; i++) {
	for (int j = 0; j < yLim; j++) {
		if (cells[i][j].IsMine()) {

			//write adjacent mines for row above the mine

		//above tile
			if (j > 0) {
				cells[i][j - 1].SetAdjacentMineCount(cells[i][j - 1].GetAdjacentMineCount() + 1);
			}

			//above and to the left of the tile
			if (i > 0 and j > 0) {
				cells[i - 1][j - 1].SetAdjacentMineCount(cells[i - 1][j - 1].GetAdjacentMineCount() + 1);
			}

			//above and to the right of the tile
			if (i < (xLim - 1) and j > 0) {
				cells[i + 1][j - 1].SetAdjacentMineCount(cells[i + 1][j - 1].GetAdjacentMineCount() + 1);
			}

			//write adjacent mines for row below mine

		//below tile
			if (j < (yLim - 1)) {
				cells[i][j + 1].SetAdjacentMineCount(cells[i][j + 1].GetAdjacentMineCount() + 1);
			}

			//below and to the left of the tile
			if (i > 0 and j < (yLim - 1)) {
				cells[i - 1][j + 1].SetAdjacentMineCount(cells[i - 1][j + 1].GetAdjacentMineCount() + 1);
			}

			//below and to the right of the tile
			if (i < (xLim - 1) and j < (yLim - 1)) {
				cells[i + 1][j + 1].SetAdjacentMineCount(cells[i + 1][j + 1].GetAdjacentMineCount() + 1);
			}

			//write adjacent mine to the sides of the tile

		//left of tile
			if (i > 0) {
				cells[i - 1][j].SetAdjacentMineCount(cells[i - 1][j].GetAdjacentMineCount() + 1);
			}

			//right of tile
			if (i < (xLim - 1)) {
				cells[i + 1][j].SetAdjacentMineCount(cells[i + 1][j].GetAdjacentMineCount() + 1);
			}
		}
	}
}
}

int Board::getXbounds() {
	return xLim;
}
int Board::getYbounds() {
	return yLim;
}

bool Board::Flag(int row, int column) {
	if (validate(row, column)) {
		if (!cells[column][row].getFlipStatus()) {
			cells[column][row].ToggleFlag();
			return true;
		}
	}
	return false;
}

bool Board::Click(int row, int column) {
	if (validate(row, column)) {
		if (!cells[column][row].getFlipStatus() and !cells[column][row].getFlagStatus()) {
			cells[column][row].Click();
			if (cells[column][row].IsMine()) {
				cellsToWin = -1;
				Unearth();
				return true;
			}
			else {
				cellsToWin--;
				if (cells[column][row].GetAdjacentMineCount() == 0) {
					if (recursionBreak == false) {
						recursionBreak = recursiveFlip(row, column);
					}
				}
				return true;
			}
		}
	}
	return false;
}

bool Board::validate(int row, int column) {
	if (row >= 0 and row < yLim) {
		if (column >= 0 and column < xLim) {
			return true;
		}
	}
	return false;
}

bool Board::recursiveFlip(int row, int column) {
	recursionBreak = true;
	//top left
	if (validate(row - 1, column - 1)) {
		if (!cells[column - 1][row - 1].IsMine()) {
			if (Click(row - 1, column - 1)) {
				if (cells[column - 1][row - 1].GetAdjacentMineCount() == 0) {
					recursiveFlip(row - 1, column - 1);
				}
			}
		}
	}
	//top middle
		if (validate(row - 1, column)) {
			if (!cells[column][row - 1].IsMine()) {
				if (Click(row - 1, column)) {
					if (cells[column][row - 1].GetAdjacentMineCount() == 0) {
						recursiveFlip(row - 1, column);
					}
				}
			}
		}
	//top right
	if (validate(row - 1, column + 1)) {
		if (!cells[column + 1][row - 1].IsMine()) {
			if (Click(row - 1, column + 1)) {
				if (cells[column + 1][row - 1].GetAdjacentMineCount() == 0) {
					recursiveFlip(row - 1, column + 1);
				}
			}
		}
	}
	//middle left
	if (validate(row, column - 1)) {
		if (!cells[column - 1][row].IsMine()) {
			if (Click(row, column - 1)) {
				if (cells[column - 1][row].GetAdjacentMineCount() == 0) {
					recursiveFlip(row, column - 1);
				}
			}
		}
	}
	//middle right
	if (validate(row, column + 1)) {
		if (!cells[column + 1][row].IsMine()) {
			if (Click(row, column + 1)) {
				if (cells[column + 1][row].GetAdjacentMineCount() == 0) {
					recursiveFlip(row, column + 1);
				}
			}
		}
	}
	//bottom left
	if (validate(row + 1, column - 1)) {
		if (!cells[column - 1][row + 1].IsMine()) {
			if (Click(row + 1, column - 1)) {
				if (cells[column - 1][row + 1].GetAdjacentMineCount() == 0) {
					recursiveFlip(row + 1, column - 1);
				}
			}
		}
	}
	//bottom middle
	if (validate(row + 1, column)) {
		if (!cells[column][row + 1].IsMine()) {
			if (Click(row + 1, column)) {
				if (cells[column][row + 1].GetAdjacentMineCount() == 0) {
					recursiveFlip(row + 1, column);
				}
			}
		}
	}//bottom right
	if (validate(row + 1, column + 1)) {
		if (!cells[column + 1][row + 1].IsMine()) {
			if (Click(row + 1, column + 1)) {
				if (cells[column + 1][row + 1].GetAdjacentMineCount() == 0) {
					recursiveFlip(row + 1, column + 1);
				}
			}
		}
	}
	return false;
}


void Board::print() {
	createString();
	std::cout << board;
}

void Board::createString() {
	//print the first row
	board = "   ";
	for (int i = 0; i < xLim; i++) {
		board.append("   ");
		board.append(std::to_string(i));
	}
	board.append(" \n");

	//print all other rows
	int rowIdBuffer = 0;
	for (int i = 0; i < ((yLim * 2) + 1) ; i++){
		
		if (i != 0 and i % 2 != 0) {
			board.append("  ");
			board.append(std::to_string(rowIdBuffer));
			board.append(" ");
			for (int ii = 0; ii < xLim; ii++) {
				board.append("| ");
				cellBuffer << cells[ii][rowIdBuffer];
				board.append(cellBuffer.str());
				cellBuffer.str("");
				cellBuffer.clear();
				board.append(" ");
			}
			board.append("|\n");
			rowIdBuffer++;
		}
		else {
			board.append("    ");
			for (int ii = 0; ii < xLim; ii++) {
				board.append("+---");
			}
			board.append("+\n");
		}
}
	if (cellsToWin <= 0) {
		board.append("Game Over!");
	}
}

std::string Board::getString() {
	return board;
}

int Board::GetCellsToWin() {
	return cellsToWin;
}

void Board::Unearth() {
	for (int i = 0; i < xLim; i++) {
		for (int j = 0; j < yLim; j++) {
			if (cells[i][j].IsMine()) {
				cells[i][j].Unearth();
			}
		}
	}
}