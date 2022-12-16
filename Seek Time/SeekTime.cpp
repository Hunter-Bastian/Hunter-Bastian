//Author:		Hunter Bastian
//Program:		Project 4 Seek Time Optimization Algorithms for HDD Access
//Version:		1.0
//Description:	SeekTime is the main file and falcilitates menu input. 
//				This input is then passed into a controller and handled seperately.
//Last Edited:	13:01 22 April, 2022 

#include <iostream>
#include <string>
#include <sstream>
#include <vector>

#include "scheduler.hpp"

int main() {
	int armStart;
	int selectionBuffer;
	std::string cylinderList;
	std::string cylinderListBuffer;
	int cylinderBuffer;		
	std::stringstream ss;

	Scheduler scheduler;

	std::cout << "This disk scheduler tries to optimize on disk accesses.\n\n";

input:
	std::cout << "Please enter the current location of the arm: ";

	std::cin >> armStart;
	if (!std::cin.good()) {
		std::cout << "\nInvalid input, please enter an integer.\n\n";
		std::cin.clear();
		std::cin.ignore(1, '\n');

		goto input;
	}
	scheduler.addStart(armStart);
	std::cin.ignore(1, '\n');

input2:
	std::cin.clear();

	cylinderList.clear();
	cylinderListBuffer.clear();

	ss.clear();
	ss.str(std::string());

	std::cout << "\nPlease enter the list of cylinder numbers for the file. Input ends on newline: ";
	std::getline(std::cin, cylinderList);
	for (int i = 0; i < cylinderList.size(); i++) {
		if (cylinderList[i] == ' ') {
			ss << cylinderListBuffer;
			if (ss >> cylinderBuffer) {
				scheduler.addLocation(cylinderBuffer);
				ss.clear();
				cylinderListBuffer.clear();
			}
			else {
				std::cout << "\nInvalid input, please enter a series of integers.\n";
				scheduler.clear();
				goto input2;
			}
		}
		if (i == cylinderList.size() - 1){
			cylinderListBuffer += cylinderList[i];
			ss << cylinderListBuffer;
			if (ss >> cylinderBuffer) {
				scheduler.addLocation(cylinderBuffer);
				ss.clear();
				cylinderListBuffer.clear();
			}
			else {
				std::cout << "\nInvalid input, please enter a series of integers.\n";
				scheduler.clear();
				goto input2;
			}
		}
		cylinderListBuffer += cylinderList[i];
	}

menu:
	std::cout << "Please select a seek algorithm:   1. FCFS     2. SSTF     3. QUIT     | >";
	std::cin >> selectionBuffer;
	if (!std::cin.good()) {
		std::cout << "\nInvalid input, please enter an integer ranging from 1 - 3\n\n";
		goto menu;
	}
	if (selectionBuffer < 1 || selectionBuffer > 3) {
		std::cout << "\nInvalid input, please enter an integer ranging from 1 - 3\n\n";
		goto menu;
	}
	switch (selectionBuffer) {
	case 1:
	{
		scheduler.fcfs();
		break;
	}
	case 2: {
		scheduler.sstf();
		break;
	}
	case 3: {
		exit(0);
	}
	default:
	{
		std::cout << "\nInvalid input, please enter an integer ranging from 1 - 3\n\n";
		goto menu;
	}
	}

	goto menu;
}