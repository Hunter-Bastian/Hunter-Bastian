#include "ui.hpp"

UI::UI() {
	promptSelection[0] = "Please enter a file name with the minefield information: ";
	promptSelection[1] = "Choose your next move(c or f) and cell, e.g. c 0 3 to click row zero column 3: ";
	promptSelection[2] = "Invalid move. Please enter your next move: ";
	promptSelection[3] = "Game Over!";

	prompt = promptSelection[0];
	gameOver = false;
}

bool UI::SetFileName(std::string file) {
	if (b.internals(file)) {
		b.createString();
		prompt = b.getString();
		prompt.append(promptSelection[1]);
		return true;
	}
	return false;
}

bool UI::Move(char action, int row, int column) {
	invalidInputFlag = false;
	if (action == 'f' || action == 'F' || action == 'c' || action == 'C') {
		if (column < 0 || column > b.getYbounds() - 1) {
			invalidInputFlag = true;
		}
		if (row < 0 || row > b.getXbounds() - 1) {
			prompt = promptSelection[2];
			invalidInputFlag = true;
		}
		if (invalidInputFlag == false) {
			switch (action) {
			case 'f': {
				if (b.Flag(row, column)) {
					break;
				}
				else {
					invalidInputFlag = true;
					break;
				}
			}
			case 'F': {
				if (b.Flag(row, column)) {
					break;
				}
				else {
					invalidInputFlag = true;
					break;
				}
			}
			case 'c': {
				if (b.Click(row, column)) {
					break;
				}
				else {
					invalidInputFlag = true;
					break;
				}
			}
			case 'C': {
				if (b.Click(row, column)) {
					break;
				}
				else {
					invalidInputFlag = true;
					break;
				}
			}
					//this should never happen. But just in case.
			default: {
				invalidInputFlag = true;
				break;
			}

			}
		}
		
		if (invalidInputFlag == false) {
			b.createString();
			prompt = b.getString();
			if (b.GetCellsToWin() > 0) {
				prompt.append(promptSelection[1]);
			}
			return true;
		}
		else {
			prompt = promptSelection[2];
			return false;
		}
	}
	prompt = promptSelection[2];
	return false;
}

std::string UI::GetPrompt() {
	return prompt;
}

bool UI::IsGameOver() {
	if (b.GetCellsToWin() < 0 || b.GetCellsToWin() == 0) {
		gameOver = true;
	}
	return gameOver;
}