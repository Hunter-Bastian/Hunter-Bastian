#ifndef CELL_HPP
#define CELL_HPP

#include <iostream>


class Cell {
private:
	bool flip;
	bool mine;
	bool flag;
	int adjacentMines;

public:

	static const std::string FLAG;
	static const std::string MINE;
	static const std::string NO_ADJACENT_MINES;


	Cell();
	Cell(bool mine);

	friend std::ostream& operator<< (std::ostream& out, const Cell& objectToDisplay);

	void setMine(bool mine);
	bool IsMine();

	bool getFlipStatus();
	bool getFlagStatus();

	void ToggleFlag();

	bool Click();
	void Unearth();

	int GetAdjacentMineCount();
	void SetAdjacentMineCount(int num);

};
#endif

