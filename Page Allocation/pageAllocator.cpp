#include "pageAllocator.hpp"

PageAllocator::PageAllocator() {
	this->baseBuffer = 0;
	this->limitBuffer = 0;
	this->index = 0;
	this->memorySize = 16000;
	this->allocatedMemory = 0;
	freeMemory = 16000;
}
PageAllocator::PageAllocator(int memorySize) {
	this->baseBuffer = 0;
	this->limitBuffer = 0;
	this->index = 0;
	this->memorySize = memorySize;
	this->allocatedMemory = 0;
	freeMemory = 16000;
}


bool PageAllocator::addPage(int baseRegister, int limitRegister) {
	if (verifyInput(baseRegister, limitRegister)) {
		Page newPage(baseRegister, limitRegister);
		pages.push_back(newPage);
		pages.back().setName(pages.size() - 1);
		sort();
		return true;
	}
	else {
		return false;
	}
}
bool PageAllocator::verifyInput(int base, int limit) {
	if (base >= 0 and base < 16000) {
		if (limit > 0 and (limit+base) < 16000) {
			for (int i = 0; i < pages.size(); i++) {
				if (base >= pages.at(i).getBase() and
					base <= (pages.at(i).getLimit() + pages.at(i).getBase())) {
					return false;
				}
				else if ((limit + base) >= pages.at(i).getBase() and
					(limit + base) <= (pages.at(i).getLimit() + pages.at(i).getBase()) ){
					return false;
				}
			}
			return true;
		}
	}
	return false;
}

void PageAllocator::sort() {
	for (int i = 0; i < pages.size()-1; i++) {
		if (pages.at(i).getBase() > pages.at(i + 1).getBase()) {
			Page buffer(pages.at(i + 1));
			pages.at(i + 1) = pages.at(i);
			pages.at(i) = buffer;
		}
	}
}

std::string PageAllocator::calculateFreeMemory() {
	allocatedMemory = 0;
	for (int i = 0; i < pages.size(); i++) {
		allocatedMemory = allocatedMemory + pages.at(i).getLimit();
	}
	// calculates total amount of allocated memory 

	//calculates total amount of free memory
	freeMemory = 16000 - allocatedMemory;

	return "nope";
}

std::string PageAllocator::printMemoryMap() {

	//sort()

	std::string output = " ";
	//if first page does not begin at 0
	if (pages.at(0).getBase() > 0) {
		std::cout << "\n_______________\n|             |\n|";
		std::cout << " UNALLOCATED |" << pages.at(0).getBase();
		std::cout <<"\n|_____________|";
	}
	for (int i = 0; i < pages.size(); i++) {

		//print allocated page
		std::cout << "\n|_____base____|" << pages.at(i).getBase();
		std::cout << "\n| ";
		std::cout << std::setfill(' ') << std::setw(10);
		std::cout << pages.at(i).getName();
		std::cout << "  |\n|    ";
		std::cout << std::setfill('0') << std::setw(5);
		std::cout << pages.at(i).getLimit();
		std::cout << "    |\n|_____________|\n|____limit____|"
			<< (pages.at(i).getBase() + pages.at(i).getLimit() - 1);

		//print unallocated space
		if (i < pages.size() - 1) {
			if ((pages.at(i).getBase() + pages.at(i).getLimit()) <
				pages.at(i + 1).getBase()) {

				std::cout << "\n|             |\n";

				std::cout << "| UNALLOCATED |";

				std::cout << (pages.at(i + 1).getBase()) - (pages.at(i).getBase() + pages.at(i).getLimit());
				std::cout << "\n|_____________|";
			}
		}
		else if ( (pages.at(i).getBase() + pages.at(i).getLimit()) < 16000) {
			std::cout << "\n|             |\n";

			std::cout << "| UNALLOCATED |";
			std::cout << (16000 - (pages.at(i).getBase() + pages.at(i).getLimit()) );
			std::cout << "\n|_____________|";
		}

	}

	return output;
}

