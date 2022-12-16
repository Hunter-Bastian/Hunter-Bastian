// Hunter Bastian
// COP4610
// 
// baseLimit.cpp provides a means to calculate memory allocation
// based upon an input including: memory size, base registers, 
// and limit registers.

// Edited 2/9/2022

#include <iostream>
#include <string>
#include "page.hpp"
#include "pageAllocator.hpp"

int main()
{

    bool flag = true;
    int baseBuffer = 0;
    int limitBuffer = 0;
    PageAllocator memory;
    //menu

    std::cout << "Welcome to the memory map generator!\n";

    while (flag) {
        std::cout << "Please enter a base value: ";
        std::cin >> baseBuffer;
        if (!std::cin.fail()) {
            std::cout << "Please enter a limit value: ";
            std::cin >> limitBuffer;
            if (!std::cin.fail()) {
                if (memory.addPage(baseBuffer, limitBuffer)) {
                    memory.printMemoryMap();
                    std::cout << '\n';
                }
                else {
                    std::cout << "Invalid input detected. Terminating program." << std::endl;
                    break;
                }
            }
            else {
                std::cout << "Invalid input detected. Terminating program." << std::endl;
                break;
            }
        }
        else {
            std::cout << "Invalid input detected. Terminating program." << std::endl;
            break;
        }
    }
    return 0;
}
