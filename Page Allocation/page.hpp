//page class is a container for base and limit register values
#ifndef PAGE_HPP
#define PAGE_HPP

#include <iostream>
#include <string>

class Page {
private:
	int baseRegister;
	int limitRegister;
	std::string name;

public:
	Page();			//default constructor
	Page(int baseRegister, int limitRegister);		//paramaterized constructor
	Page& operator= (const Page& copiedPage); //assignment operator override
	Page(const Page& other); //copy constructor

	//mutator functions
	void setBase(int baseRegister);		
	void setLimit(int limitRegister);
	void setName(int pgNo);

	//getter functions
	int getBase();
	int getLimit();
	std::string getName();
};	
#endif
