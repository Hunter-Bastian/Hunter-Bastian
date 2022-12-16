
#include <iostream>
#include "cell.hpp"
#include "board.hpp"
#include "ui.hpp"
#include <string>

int main()
{
    std::string file;

    bool flag1 = false;
    bool flag2 = false;
    char buffer;

    char action;
    int columnPos;
    int rowPos;
    UI ui;
    do {
        std::cout << ui.GetPrompt() << '\n';
        std::cin >> file;
        flag1 = ui.SetFileName(file);
    } while (!flag1);

    do {
        std::cout << ui.GetPrompt() << '\n';

        std::cin >> action;
        std::cin >> rowPos;
        std::cin >> columnPos;

        ui.Move(action, rowPos, columnPos);

    } while (!ui.IsGameOver());
    std::cout << ui.GetPrompt();

}

