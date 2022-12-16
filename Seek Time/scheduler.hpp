//Author:		Hunter Bastian
//Program:		Project 4 Seek Time Optimization Algorithms for HDD Access
//Version:		1.0
//Description:	scheduluer is the controller and handles the storage of and computation of data. 
//Last Edited:	13:01 22 April, 2022 

#ifndef SCHEDULER_HPP
#define SCHEDULER_HPP
#include <iostream>
#include <iomanip>
#include <string>
#include <vector>
#include <cmath>


class Scheduler {
private:
	bool sorted;
	std::vector<int> cylinderLocations;
	std::vector<int> sortedCylinderLocations;
	int start;
	int travelTime;

	int big;
	int small;

	int swapBuffer;
	int travelBuffer;

public:
	Scheduler();
	Scheduler(int start);

	void addLocation(int location);
	void clear();
	void addStart(int start);
	int getStart();
	void sort();
	void fcfs();
	void sstf();
};
#endif
