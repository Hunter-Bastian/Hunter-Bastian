Simple game of minesweeper.

Commands:
	The game accepts input from a single row of 3 input value separated by a space

	Value 1: 'c' for capture 'f' for flag.
	Value 2: the ROW number you wish to specify
	Value 3: the COLUMN number you wish to specify.
	
	Sample input: c 0 3 -> means capture the space on row 0 column 3

Files:
	The game creates a board by reading in a txt file with a specific format.
	The number of characters present (whitespace for empty, * for mine) will dictate the size of the rows and columns.
	It should go without saying that these should be uniform.

Have Fun