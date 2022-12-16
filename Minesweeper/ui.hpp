#ifndef UI_HPP
#define UI_HPP

#include "cell.hpp"
#include "board.hpp"

#include <iostream>

class UI {
private:
	bool gameOver;
	bool invalidInputFlag;
	std::string promptSelection [4];
	std::string prompt;
	std::string fileName;
	Board b;


public:
	UI();

	std::string GetPrompt();

	bool SetFileName(std::string file);

	bool Move(char action, int row, int column);

	bool IsGameOver();
};
#endif
