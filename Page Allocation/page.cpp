//implementation of the page class.
//container for base and limit register values.
#include "page.hpp"

Page::Page() {
	this->baseRegister = 0;
	this->limitRegister = 0;
	this->name = "Page ";
}

Page::Page(int baseRegister, int limitRegister) {
		setBase(baseRegister);
		setLimit(limitRegister);
		this->name = "Page ";
	} 

Page& Page::operator=(const Page& copiedPage) {
	if (this != &copiedPage) {
		setBase(copiedPage.baseRegister);
		setLimit(copiedPage.limitRegister);
		this->name = (copiedPage.name);
	}
	return *this;
	}

Page::Page(const Page& other) {
	this->baseRegister = other.baseRegister;
	this->limitRegister = other.limitRegister;
	this->name = other.name;
}

void Page::setBase(int baseRegister) {
		this->baseRegister = baseRegister;
	}

void Page::setLimit(int limitRegister) {
		this->limitRegister = limitRegister;
	}

void Page::setName(int pgNo) {
	this->name += std::to_string(pgNo);
}

int Page::getBase() {
		return this->baseRegister;
	}

int Page::getLimit() {
		return this->limitRegister;
	}

std::string Page::getName() {
	return this->name;
}
