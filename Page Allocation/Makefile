CXX = g++

# compiler flags:
#  -g    adds debugging information to the executable file
#  -Wall turns on most, but not all, compiler warnings
#  -Werror=* turns those warnings into errors.
#     This makes it harder to ignore warnings that are likely to be failures on a basic Linux machine
CXXFLAGS = -g -std=c++11 -Wall -Werror=return-type  -Werror=uninitialized

main: baseLimit.o page.o pageAllocator.o
	g++ baseLimit.o page.o pageAllocator.o -o main

baseLimit.o: baseLimit.cpp
	g++ -c baseLimit.cpp

page.o: page.cpp page.hpp
	g++ -c page.cpp page.hpp

pageAllocator.o: pageAllocator.cpp pageAllocator.hpp
	g++ -c pageAllocator.cpp pageAllocator.hpp