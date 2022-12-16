#include "cell.hpp"

const std::string Cell::MINE = "*";
const std::string Cell::FLAG = "!";
const std::string Cell::NO_ADJACENT_MINES = "_";

Cell::Cell() {
	this->flip = false;
	this->mine = false;
	this->flag = false;
	this->adjacentMines = 0;
}

Cell::Cell(bool mine) {
	this->flip = false;
	this->mine = mine;
	this->flag = false;
	this->adjacentMines = 0;
}

std::ostream& operator<< (std::ostream& out, const Cell& rhs) {

	if (rhs.flag) {
		out << rhs.FLAG;//U+1F6Ax [9]
	}

	else if (rhs.flip == false) {//U+2B1x [B]
		out << " ";
	}

	else if (rhs.mine) {
		out << rhs.MINE;//U+1F4Ax [3]
	}

	else if (rhs.adjacentMines == 0) {
		out << rhs.NO_ADJACENT_MINES;
	}
	else {
		out << rhs.adjacentMines;//U+2B1X [C]
	}
	return out;
}

bool Cell::IsMine() {
	return mine;
}
void Cell::setMine(bool mine) {
	this->mine = mine;
}

bool Cell::getFlipStatus() {
	return flip;
}
bool Cell::getFlagStatus() {
	return flag;
}

void Cell::ToggleFlag() {
	if (flag) {
		flag = false;
	}
	else {
		flag = true;
	}
}

bool Cell::Click() {
	if (!flag and !flip) {
		flip = true;
		return true;
	}
	return false;
}
void Cell::Unearth() {
	if (!flip) {
		flip = true;
	}
}

int Cell::GetAdjacentMineCount() {
	return adjacentMines;
}
void Cell::SetAdjacentMineCount(int num) {
	adjacentMines = num;
}



