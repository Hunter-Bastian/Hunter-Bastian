#ifndef BOARD_HPP
#define BOARD_HPP

#include "cell.hpp"
#include <iostream>
#include <fstream>
#include <string>
#include <sstream>

class Board {

private:
	Cell** cells;
	int xLim;
	int yLim;

	std::ifstream in;
	int rowBuffer;
	int columnBuffer;
	std::string strBuffer;
	char charBuffer;

	std::ostringstream cellBuffer;
	std::string board;
	
	int cellsToWin;

public:
	Board();
	Board(std::string file);

	~Board();
	//Board(const Board& rhs);
	//Board& operator=(const Board& rhs);

	friend std::ostream& operator<< (std::ostream& out, Board& rhs);


	bool internals(std::string file);
	bool fileHandling(std::string file);
	void mineWriting();
	void adjacentMineWriting();

	int getXbounds();
	int getYbounds();

	bool Flag(int row, int column);
	bool Click(int row, int column);

	bool validate(int row, int column);
	bool recursiveFlip(int row, int column);
	bool recursionBreak;

	void print();
	
	void createString();
	std::string getString();

	int GetCellsToWin();
	void Unearth();
};
#endif
