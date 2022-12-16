//Page Allocator class creates and handles
//objects of Page class for calculation

#include <iostream>
#include <iomanip>
#include <string>
#include <vector>
#include <type_traits>
#include "page.hpp"


#ifndef PAGE_ALLOCATOR
#define PAGE_ALLOCATOR

class PageAllocator {
private:
	int baseBuffer;
	int limitBuffer;

	int index;

	int memorySize;
	int allocatedMemory;
	int freeMemory;

	std::vector <Page> pages;
public:
	PageAllocator();
	PageAllocator(int memorySize);
	
	bool addPage(int baseRegister, int limitRegister);
	bool verifyInput(int base, int limit);

	void sort();

	std::string calculateFreeMemory();
	//std::string calculateAllocatedMemory();

	std::string printMemoryMap();
};
#endif


