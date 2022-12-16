CXX = g++

# compiler flags:
#  -g    adds debugging information to the executable file
#  -Wall turns on most, but not all, compiler warnings
#  -Werror=* turns those warnings into errors.
#     This makes it harder to ignore warnings that are likely to be failures on a basic Linux machine
CXXFLAGS = -g -std=c++11 -Wall -Werror=return-type  -Werror=uninitialized

main: SeekTime.o scheduler.o
	g++ SeekTime.o scheduler.o -o main

SeekTime.o: SeekTime.cpp
	g++ -c SeekTime.cpp

scheduler.o: scheduler.cpp scheduler.hpp
	g++ -c scheduler.cpp scheduler.hpp