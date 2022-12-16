//Author:		Hunter Bastian
//Program:		Project 4 Seek Time Optimization Algorithms for HDD Access
//Version:		1.0
//Description:	scheduluer is the controller and handles the storage of and computation of data. 
//Last Edited:	13:01 22 April, 2022 

#include "scheduler.hpp"

Scheduler::Scheduler() {
	this->sorted = false;
	this->start = 0;
	this->cylinderLocations.clear();
	this->travelTime = 0;

	this->big = 0;
	this->small = 0;

	this->swapBuffer = 0;
	this->travelBuffer = 0;
}
Scheduler::Scheduler(int start) {
	this->sorted = false;
	this->start = start;
	this->cylinderLocations.clear();
	this->travelTime = 0;

	this->big = 0;
	this->small = 0;

	this->swapBuffer = 0;
	this->travelBuffer = 0;
}

void Scheduler::addLocation(int location) {
	this->cylinderLocations.push_back(location);
	this->sorted = false;
}

void Scheduler::clear() {
	this->cylinderLocations.clear();
}

void Scheduler::addStart(int start) {
	this->start = start;
	this->sorted = false;
}

int Scheduler::getStart() {
	return start;
}

void Scheduler::sort() {
	sortedCylinderLocations = cylinderLocations;

	//sort in relation to start
	for (int i = 1; i < sortedCylinderLocations.size(); i++) {
		if (abs(start - sortedCylinderLocations.at(0)) > abs(start - sortedCylinderLocations.at(i))) {
			//if a faster seek time from start is found, move that cylinder to the front of queue
			swapBuffer = sortedCylinderLocations.at(0);
			sortedCylinderLocations.at(0) = sortedCylinderLocations.at(i);
			sortedCylinderLocations.at(i) = swapBuffer;
		}
	}
	//sort the remainder of the queue
	for (int i = 0; i < sortedCylinderLocations.size()-1; i++) {
		travelBuffer = abs(sortedCylinderLocations.at(i) - sortedCylinderLocations.at(i + 1));

		for (int j = i + 2; j < sortedCylinderLocations.size(); j++) {
			if ( travelBuffer > abs(sortedCylinderLocations.at(i) - sortedCylinderLocations.at(j)) ) {
				
				swapBuffer = sortedCylinderLocations.at(i+1);
				sortedCylinderLocations.at(i+1) = sortedCylinderLocations.at(j);
				sortedCylinderLocations.at(j) = swapBuffer;
				travelBuffer = abs(sortedCylinderLocations.at(i) - sortedCylinderLocations.at(i + 1));
		}
		}
	}

	sorted = true;
}

void Scheduler::fcfs() {
	this->travelTime = 0;
	std::cout << "Running the FCFS algorithm now..\n\n";
	std::cout << "The sequence of visits to the cylinders:\n";

	std::cout << std::setfill(' ') << std::setw(8);
	std::cout << start;
	std::cout << ' ';

	if (start > cylinderLocations.at(0)) {
		big = start;
		small = cylinderLocations.at(0);
	}
	else {
		big = cylinderLocations.at(0);
		small = start;
	}
	travelTime += (big - small);
	
	std::cout << std::setfill(' ') << std::setw(8);
	std::cout << cylinderLocations.at(0);
	std::cout << ' ';
	
	for (int i = 1; i < cylinderLocations.size(); i++) {
		if (cylinderLocations.at(i - 1) > cylinderLocations.at(i) ){
			big = cylinderLocations.at(i - 1);
			small = cylinderLocations.at(i);
		}
		else {
			big = cylinderLocations.at(i);
			small = cylinderLocations.at(i - 1);
		}
		travelTime += (big - small);
		std::cout << std::setfill(' ') << std::setw(8);
		std::cout << cylinderLocations.at(i);
		std::cout << ' ';
	}

	std::cout << "\nTotal cylinder travel for FCFS: " << travelTime << ".\n\n";
}

void Scheduler::sstf() {
	if (!sorted) {
		sort();
	}
	this->travelTime = 0;
	std::cout << "Running the SSTF algorithm now..\n\n";
	std::cout << "The sequence of visits to the cylinders:\n";

	std::cout << std::setfill(' ') << std::setw(8);
	std::cout << start;
	std::cout << ' ';

	if (start > sortedCylinderLocations.at(0)) {
		big = start;
		small = sortedCylinderLocations.at(0);
	}
	else {
		big = sortedCylinderLocations.at(0);
		small = start;
	}
	travelTime += (big - small);

	std::cout << std::setfill(' ') << std::setw(8);
	std::cout << sortedCylinderLocations.at(0);
	std::cout << ' ';

	for (int i = 1; i < sortedCylinderLocations.size(); i++) {
		if (sortedCylinderLocations.at(i - 1) > sortedCylinderLocations.at(i)) {
			big = sortedCylinderLocations.at(i - 1);
			small = sortedCylinderLocations.at(i);
		}
		else {
			big = sortedCylinderLocations.at(i);
			small = sortedCylinderLocations.at(i - 1);
		}
		travelTime += (big - small);
		std::cout << std::setfill(' ') << std::setw(8);
		std::cout << sortedCylinderLocations.at(i);
		std::cout << ' ';
	}

	std::cout << "\nTotal cylinder travel for SSTF: " << travelTime << ".\n\n";
}

