//
// Created by shazebs on 4/13/2021.
//

#ifndef PROJECT_1_SHIPS_H
#define PROJECT_1_SHIPS_H
#include "Pins.h"
#include "Grids.h"
#include "StringLink.h"
#include <sstream>
using namespace std;


// Ship Info.
int carrier = 5;
int battleship = 4;
int cruiser = 3;
int submarine = 3;
int destroyer = 2;


// Ship Operations Functions List.

// Print Text Art Boat Function Declaration.
void printTextArtBoat(stack<string> boat)
{
    if (boat.top() == "'Carrier'")
    {
        cout << "Your " << boat.top() << " is now initialized.\n\n";
        cout << "  )__                     (__   ____)\n"
             << "    _ )_                      (____)\n"
             << "  __    )__            |>>>\n"
             << "     ______)          /|             ___\n"
             << "  _____)             / |\\        ___(   )__\n"
             << "                    /  | \\      (_       __)\n"
             << "                   /   |  \\       (_  ___)\n"
             << "                  /    |   \\       (___)\n"
             << "                 /     |    \\\n"
             << "                /______|_____\\\n"
             << "                    ___|__\n"
             << "            _______/ooo__\\\\______/~\n"
             << "            \\       Carrier     |]\n"
             << "  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
             << "   ~~~~         ~~~~~~ ~~~  ~~~  ~~~~~\n"
             << "    ~~~~~  ~~~   ~~~   ___  ~~~ ~~~~~   ~~~~\n";
    }
    else if (boat.top() == "'Battleship'")
    {
        cout << "Your " << boat.top() << " is now initialized.\n\n";
        cout << "  )__                     (__   ____)\n"
             << "    _ )_                      (____)\n"
             << "  __    )__            |>>>\n"
             << "     ______)          /|             ___\n"
             << "  _____)             / |\\        ___(   )__\n"
             << "                    /  | \\      (_       __)\n"
             << "                   /   |  \\       (_  ___)\n"
             << "                  /    |   \\       (___)\n"
             << "                 /     |    \\\n"
             << "                /______|_____\\\n"
             << "                    ___|__\n"
             << "            _______/ooo__\\\\______/~\n"
             << "            \\     Battleship    |]\n"
             << "  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
             << "   ~~~~         ~~~~~~ ~~~  ~~~  ~~~~~\n"
             << "    ~~~~~  ~~~   ~~~   ___  ~~~ ~~~~~   ~~~~\n";
    }
    else if (boat.top() == "'Cruiser'" || boat.top() == "'Submarine'")
    {
        cout << "Your " << boat.top() << " is now initialized.\n";
        cout << "  )__                     (__   ____)\n"
             << "    _ )_                      (____)\n"
             << "  __    )__            |>>>\n"
             << "     ______)          /|             ___\n"
             << "  _____)             / |\\        ___(   )__\n"
             << "                    /  | \\      (_       __)\n"
             << "                   /   |  \\       (_  ___)\n"
             << "                  /    |   \\       (___)\n"
             << "                 /     |    \\\n"
             << "                /______|_____\\\n"
             << "                    ___|__\n"
             << "            _______/ooo__\\\\______/~\n"
             << "            \\     " << boat.top() << "      |]\n"
             << "  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
             << "   ~~~~         ~~~~~~ ~~~  ~~~  ~~~~~\n"
             << "    ~~~~~  ~~~   ~~~   ___  ~~~ ~~~~~   ~~~~\n";
    }
    else if (boat.top() == "'Destroyer'")
    {
        cout << "Your " << boat.top() << " is now initialized.\n";
        cout << "  )__                     (__   ____)\n"
             << "    _ )_                      (____)\n"
             << "  __    )__            |>>>\n"
             << "     ______)          /|             ___\n"
             << "  _____)             / |\\        ___(   )__\n"
             << "                    /  | \\      (_       __)\n"
             << "                   /   |  \\       (_  ___)\n"
             << "                  /    |   \\       (___)\n"
             << "                 /     |    \\\n"
             << "                /______|_____\\\n"
             << "                    ___|__\n"
             << "            _______/ooo__\\\\______/~\n"
             << "            \\      Destroyer    |]\n"
             << "  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
             << "   ~~~~         ~~~~~~ ~~~  ~~~  ~~~~~\n"
             << "    ~~~~~  ~~~   ~~~   ___  ~~~ ~~~~~   ~~~~\n";
    }
    else
    {
        cout << "Error Code: ~456 has occured.Check your code.\n";
    }
}

#endif //PROJECT_1_SHIPS_H




