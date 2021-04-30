/* 
 * File:   BattleshipGame.cpp
 * Author: Shazeb Suhail
 *
 * Created on April 29, 2021, 6:51 PM
 */

#include <iostream>
#include <cstdlib>
#include <ctime>
#include <list>
#include <stack>
#include <queue>
#include <map>
#include <set>
#include <iomanip>
#include <string>
using namespace std;


//
// Structures
//
struct Queue
{
    string data;
    Queue *nodePtr;

    Queue() {nodePtr = nullptr;}

    Queue(string val) {
        data = val;
        nodePtr = nullptr;
    }
};


//
// Program Grids. 
// 

// Player 1's Grid. 
static string grid[11][11] =
        {
                {"",  "1", "2", "3", "4", "5", "6", "7", "8", "9","10"}, // 0
                {"A", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, // 1
                {"B", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, // 2
                {"C", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, // 3
                {"D", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, // 4
                {"E", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, // 5
                {"F", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, // 6
                {"G", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, // 7
                {"H", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, // 8
                {"I", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, // 9
                {"J", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"} // 10
        };

// Player 2's Grid. 
static string egrid[11][11] =
        {
                {"",  "1",   "2",  "3",  "4",  "5",  "6",  "7",  "8",  "9",  "10"},
                {"A", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"B", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"C", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"D", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"E", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"F", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"G", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"H", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"I", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"J", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
        };

// Player 2's hit grid. 
static string ehitgrid[11][11] =
        {
                {"",  "1",   "2",  "3",  "4",  "5",  "6",  "7",  "8",  "9",  "10"},
                {"A", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"B", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"C", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"D", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"E", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"F", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"G", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"H", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"I", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"J", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
        };

// sample grid
static string sampleGrid[11][11] =
        {
                {"",   "1",  "2",  "3",  "4",  "5", "6",  "7",  "8",  "9",   "10"}, // 0
                {"A", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10"}, // 1
                {"B", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10"}, // 2
                {"C", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10"}, // 3
                {"D", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10"}, // 4
                {"E", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "E10"}, // 5
                {"F", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10"}, // 6
                {"G", "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "G10"}, // 7
                {"H", "H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10"}, // 8
                {"I", "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10"}, // 9
                {"J", "J1", "J2", "J3", "J4", "J5", "J6", "J7", "J8", "J9", "J10"} // 10
        };

// The Grid Map.
static map<string, string> gridMap =
        {
                {"A1", "-"}, {"A2", "-"}, {"A3", "-"}, {"A4", "-"}, {"A5", "-"}, {"A6", "-"}, {"A7", "-"}, {"A8", "-"}, {"A9", "-"}, {"A10", "-"},
                {"B1", "-"}, {"B2", "-"}, {"B3", "-"}, {"B4", "-"}, {"B5", "-"}, {"B6", "-"}, {"B7", "-"}, {"B8", "-"}, {"B9", "-"}, {"B10", "-"},
                {"C1", "-"}, {"C2", "-"}, {"C3", "-"}, {"C4", "-"}, {"C5", "-"}, {"C6", "-"}, {"C7", "-"}, {"C8", "-"}, {"C9", "-"}, {"C10", "-"},
                {"D1", "-"}, {"D2", "-"}, {"D3", "-"}, {"D4", "-"}, {"D5", "-"}, {"D6", "-"}, {"D7", "-"}, {"D8", "-"}, {"D9", "-"}, {"D10", "-"},
                {"E1", "-"}, {"E2", "-"}, {"E3", "-"}, {"E4", "-"}, {"E5", "-"}, {"E6", "-"}, {"E7", "-"}, {"E8", "-"}, {"E9", "-"}, {"E10", "-"},
                {"F1", "-"}, {"F2", "-"}, {"F3", "-"}, {"F4", "-"}, {"F5", "-"}, {"F6", "-"}, {"F7", "-"}, {"F8", "-"}, {"F9", "-"}, {"F10", "-"},
                {"G1", "-"}, {"G2", "-"}, {"G3", "_"}, {"G4", "_"}, {"G5", "-"}, {"G6", "-"}, {"G7", "-"}, {"G8", "-"}, {"G9", "-"}, {"G10", "-"},
                {"H1", "-"}, {"H2", "-"}, {"H3", "-"}, {"H4", "-"}, {"H5", "-"}, {"H6", "-"}, {"H7", "-"}, {"H8", "-"}, {"H9", "-"}, {"H10", "-"},
                {"I1", "-"}, {"I2", "-"}, {"I3", "-"}, {"I4", "-"}, {"I5", "-"}, {"I6", "-"}, {"I7", "-"}, {"I8", "-"}, {"I9", "-"}, {"I10", "-"},
                {"J1", "-"}, {"J2", "-"}, {"J3", "-"}, {"J4", "-"}, {"J5", "-"}, {"J6", "-"}, {"J7", "-"}, {"J8", "-"}, {"J9", "-"}, {"J10", "-"}
        };
// create an iterator.
map<string, string>::iterator iterate;


//
// Global Constants. 
//
static string shipSymbol = "<>";
static string enemySymbol = "/\\";
static string hitSymbol = "X";
static string missSymbol = "O";
static string enemyName = "player2";
static string name = "player1";
int carrier = 5;
int battleship = 4;
int cruiser = 3;
int submarine = 3;
int destroyer = 2;
Queue *front;
Queue *back;


// 
// Function Prototypes. 
// 
void newline(int n) {for(int i=0;i<n;i++) cout<<endl;}
void MainMenu(); 
void StartNewGame(); 
void clearPlayerGrid(); 
void clearEnemyGrid(); 
void print2dArray(string [][11]); 
int shipPinsInfo(stack<string>); // utilizes a stack. 
string doesPinExist(string); 
void returnPinCoordinates(string,int &,int &); 
void initPinCoordinates(int,int,string); 
void initEnemyPins(set<string>,string); // utilizes a set. 
void initEnemyFleet(); 
bool inputValidation(int,int); 
void displayExistingPins();
int initializeNewPin(string,int &,int &); 
void printTextArtBoat(stack<string>); // utilizes a stack. 
void startTurnsQueue(); // utilizes a queue. 
void switchTurns(); // utilizes a queue. 
void getPinCoordinates(string,int &,int &); 
bool tryForHit(string); 
void TakeTurnsFiringMissiles(); 
void displayGrid(); 
void displayEnemyGrid(); 
void displayEHitGrid(); 
void createPlayer(); 
void initGridPin(string,string,int &,int &, bool); 


// Start of Main Method. 
int main(int argc, char** argv) 
{
    // Title.
    cout << "Welcome to Battleship!" << endl;

    // Create a random number generator.
    srand(static_cast<unsigned int>(time(0)));

    // Method Calls.
    MainMenu();

    // End Program.
    cout << "\nGame Over.";
    return 999;
}
// End of Main Method. 


//
// Function Definitions. 
//

// Main Menu Function Declaration.
void MainMenu() {
    // Function Variables.
    int userChoice;

    // Display Main Menu Prompts
    cout << "\tMAIN MENU:\n"
         << "[1] : New Game\n"
         << "[2] : Scoreboard\n"
         << "[3] : Quit Game\n";
    cin >> userChoice;
    newline(1);

    // Execute User's Selection.
    switch (userChoice)
    {
        case 1:
            cout << "Starting New Game.\n";
            cin.ignore();
            StartNewGame();
            break;

        case 2:
            cout << "You chose to view the scoreboard.\n";
            break;

        case 3:
            cout << "You chose to quit the game.\n";
            break;

        default:
            cout << "You must have entered some invalid input!\n";
    }
}

// Start a New Game. 
void StartNewGame()
{
    // Initialize player 1's ships.
    createPlayer();

    // Quick Prompt.
    cout << "Searching for opponent...done.\n";
    initEnemyFleet();

    // Function Calls.
    startTurnsQueue();
    TakeTurnsFiringMissiles();
}

// Player's grid. 
void clearPlayerGrid()
{
    for (int i=1; i<11; i++) {
        for (int j=1; j<11; j++) {
            if (grid[i][j] != "-")
                grid[i][j] = "-";
        }
    }
}

// Clear enemy's grid. 
void clearEnemyGrid()
{
    for (int i=1; i<11; i++) {
        for (int j=1; j<11; j++) {
            if (egrid[i][j] != "-")
                egrid[i][j] = "-";
        }
    }
}

// Print 2D Array Function Declaration.
void print2dArray(string array[][11])
{
    // Display the Menu.
    for (int i = 0; i < 11; i++)
    {
        for (int x = 0; x < 11; x++)
        {
            cout << setw(5) << array[i][x];
        }
        cout << endl;
    }
}

// Return the number of pins in the ship.  
int shipPinsInfo(stack<string> ship)
{
    if (ship.top() == "'Carrier'")
        return 5;
    else if (ship.top() == "'Battleship'")
        return 4;
    else if (ship.top() == "'Cruiser'")
        return 3;
    else if (ship.top() == "'Submarine'")
        return 3;
    else if (ship.top() == "'Destroyer'")
        return 2;
    else
        return 0;
}

// Check if Pin exists. (Loops through a Map)
string doesPinExist(string pin)
{
    // Loop through the GridMap.
    for (iterate = gridMap.begin(); iterate != gridMap.end(); iterate++)
    {
        if (iterate->first == pin)
            return "true";
    }
    // Else
    return "false";
}

// Return Pin Coordinates. 
void returnPinCoordinates(string pin, int &row, int &col)
{
    for (int i=0; i<11; i++)
    {
        for (int j=0; j<11; j++)
        {
            if (sampleGrid[i][j] == pin && grid[i][j] != shipSymbol) {
                row = i;
                col = j;
            }
            else if (sampleGrid[i][j] == pin && grid[i][j] == shipSymbol)
                row = 99;
        }
    }
}

// initPinCoordinates
void initPinCoordinates(int row, int col, string symbol)
{
    grid[row][col] = symbol;
}

// Reset Grid Pin to "-" (Loops through a Map)
void resetGridPin(int x, int y, string pin)
{
    grid[x][y] = "-";
    for (iterate = gridMap.begin(); iterate != gridMap.end(); iterate++)
    {
        if (iterate->first == pin)
            iterate->second = "-";
    }
}

// Initialize Enemy Pins. 
void initEnemyPins(set<string> ship, string enemyIcon)
{
    // Loop thru rows
    for (int row=0; row<11; row++)
    { // Loop thru cols
        for (int col=0; col<11; col++)
        {
            // check to see if egrid index matches an enemy coordinate.
            set<string>::iterator iter;
            // Loop thru set container.
            for (iter = ship.begin(); iter != ship.end(); iter++)
            {
                // if an item from set element matches array item, initialize that item to something.
                if (*iter == sampleGrid[row][col])
                    egrid[row][col] = enemyIcon;
            }
        }
    }
}

// intiEnemyFleet
void initEnemyFleet()
{
    int r = rand()%6;
    // int r = rand()%20;

    // Select a random template for enemy ships to be set as.
    // Bot
    if (r == 0)
    {
        cout << "The enemy team will be led by Bot.\n";
        enemyName = "Bot";

        set<string> eCarrier = {"A10", "B10", "C10", "D10", "E10"};
        set<string> eBattleship = {"C3", "C4", "C5", "C6"};
        set<string> eCruiser = {"G1", "H1", "I1"};
        set<string> eSubmarine = {"J5", "I5", "H5"};
        set<string> eDestroyer = {"A1", "A2"};

        // Initialize Enemy Pins.
        initEnemyPins(eCarrier, enemySymbol);
        initEnemyPins(eBattleship, enemySymbol);
        initEnemyPins(eCruiser, enemySymbol);
        initEnemyPins(eSubmarine, enemySymbol);
        initEnemyPins(eDestroyer, enemySymbol);
    }
        // Somi
    else if (r == 1)
    {
        cout << "The enemy team will be led by Somi.\n";
        enemyName = "Somi";

        set<string> eCarrier = {"B3", "C3", "D3", "E3", "F3"};
        set<string> eBattleship = {"G6", "G7", "G8", "G9"};
        set<string> eCruiser = {"A10", "B10", "C10"};
        set<string> eSubmarine = {"F1", "G1", "H1"};
        set<string> eDestroyer = {"J4", "J5"};

        // Initialize Enemy Pins.
        initEnemyPins(eCarrier, enemySymbol);
        initEnemyPins(eBattleship, enemySymbol);
        initEnemyPins(eCruiser, enemySymbol);
        initEnemyPins(eSubmarine, enemySymbol);
        initEnemyPins(eDestroyer, enemySymbol);
    }
        //
    else if (r == 2)
    {
        cout << "The enemy team will be led by Teddy.\n";
        enemyName = "Teddy";

        set<string> eCarrier = {"I10", "H10", "G10", "F10", "E10"};
        set<string> eBattleship = {"B5", "C5", "D5", "E5"};
        set<string> eCruiser = {"A8", "B8", "C8"};
        set<string> eSubmarine = {"A1", "A2", "A3"};
        set<string> eDestroyer = {"J2", "J3"};

        // Initialize Enemy Pins.
        initEnemyPins(eCarrier, enemySymbol);
        initEnemyPins(eBattleship, enemySymbol);
        initEnemyPins(eCruiser, enemySymbol);
        initEnemyPins(eSubmarine, enemySymbol);
        initEnemyPins(eDestroyer, enemySymbol);
    }
    else if (r == 3)
    {
        cout << "The enemy team will be led by Googoo.\n";
        enemyName = "Googoo";

        set<string> eCarrier = {"A4", "B4", "C4", "D4", "E4"};
        set<string> eBattleship = {"E6", "E7", "E8", "E9"};
        set<string> eCruiser = {"J8", "J9", "J10"};
        set<string> eSubmarine = {"I2", "I3", "I4"};
        set<string> eDestroyer = {"I1", "J1"};

        // Initialize Enemy Pins.
        initEnemyPins(eCarrier, enemySymbol);
        initEnemyPins(eBattleship, enemySymbol);
        initEnemyPins(eCruiser, enemySymbol);
        initEnemyPins(eSubmarine, enemySymbol);
        initEnemyPins(eDestroyer, enemySymbol);
    }
    else if (r == 4) {
        cout << "The enemy team will be led by Zoya.\n";
        enemyName = "Zoya";

        set<string> eCarrier = {"B2", "C2", "D2", "E2", "F2"};
        set<string> eBattleship = {"B1", "C1", "D1", "E1"};
        set<string> eCruiser = {"H2", "H3", "H4"};
        set<string> eSubmarine = {"A7", "B7", "C7"};
        set<string> eDestroyer = {"H7", "H8"};

        // Initialize Enemy Pins.
        initEnemyPins(eCarrier, enemySymbol);
        initEnemyPins(eBattleship, enemySymbol);
        initEnemyPins(eCruiser, enemySymbol);
        initEnemyPins(eSubmarine, enemySymbol);
        initEnemyPins(eDestroyer, enemySymbol);
    }
    else if (r == 5) {
        cout << "The enemy team will be led by Binty.\n";
        enemyName = "Binty";

        set<string> eCarrier = {"I5", "I6", "I7", "I8", "I9"};
        set<string> eBattleship = {"A6", "B6", "C6", "D6"};
        set<string> eCruiser = {"F5", "G5", "H5"};
        set<string> eSubmarine = {"A9", "B9", "C9"};
        set<string> eDestroyer = {"F4", "G4"};

        // Initialize Enemy Pins.
        initEnemyPins(eCarrier, enemySymbol);
        initEnemyPins(eBattleship, enemySymbol);
        initEnemyPins(eCruiser, enemySymbol);
        initEnemyPins(eSubmarine, enemySymbol);
        initEnemyPins(eDestroyer, enemySymbol);
    }
    else if (r == 6) {
        cout << "template" << r << endl;
    }
    else if (r == 7) {
        cout << "template" << r << endl;
    }
    else if (r == 8) {
        cout << "template" << r << endl;
    }
    else if (r == 9) {
        cout << "template" << r << endl;
    }
    else if (r == 10) {
        cout << "template" << r << endl;
    }
    else if (r == 11) {
        cout << "template" << r << endl;
    }
    else if (r == 12) {
        cout << "template" << r << endl;
    }
    else if (r == 13) {
        cout << "template" << r << endl;
    }
    else if (r == 14) {
        cout << "template" << r << endl;
    }
    else if (r == 15) {
        cout << "template" << r << endl;
    }
    else if (r == 16) {
        cout << "template" << r << endl;
    }
    else if (r == 17) {
        cout << "template" << r << endl;
    }
    else if (r == 18) {
        cout << "template" << r << endl;
    }
    else if (r == 19) {
        cout << "template" << r << endl;
    }
}

// Check to see if pin has already been initialized. Initialize if not set.
bool inputValidation(int row, int col)
{
    if (grid[row][col] == shipSymbol)
    {
        cout << "This pin has already been set to a ship symbol.\n";
        return false;
    }
    else
    {
        grid[row][col] = shipSymbol;
        iterate->second = shipSymbol;
        return true;
    }
}

// Display Existing Pins. 
void displayExistingPins()
{
    for (int i=0; i<11; i++)
    {
        for (int j=0; j<11; j++)
        {
            if (grid[i][j] == shipSymbol)
                cout << i << "," << j << "\n";
        }
    }
}

// Initialize New Pin Function Declaration.
int initializeNewPin(string pin, int &x, int &y)
{
    // First See if it exists on the map.
    for (iterate = gridMap.begin(); iterate != gridMap.end(); iterate++)
    {
        // Run this code if the map index is found.
        if (iterate->first == pin)
        {
            // cout << "The Pin has been found at map index: " << iterate->first; newline(1);

            // Check to see if that pin has already been initialized to a ship symbol.
            if ((gridMap[pin]) == shipSymbol)
            {
                cout << "This pin has already been initialized!\n";
                return 0; // return false
            }
                // Else if map index is not initialized, initialize it to ship symbol.
            else if ((gridMap[pin]) != shipSymbol)
            {
                // Initialize the pin.
                gridMap[pin] = shipSymbol;
                initGridPin(iterate->first, shipSymbol, x, y, false);
                return 1; // return true
            }
        }
    }
    // else return -1
    return -1;
}

// Print a text art boat. 
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
             << "            \\     " << boat.top() << "  |]\n"
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
        cout << "Error Code: ~456 has occurred.Check your code.\n";
    }
}

// Start up Queue for taking turns. 
void startTurnsQueue()
{
    Queue *link1 = new Queue(name);
    Queue *link2 = new Queue(enemyName);

    link2->nodePtr = link1;
    front = link1;
    back = link2;
}

// Move front of queue to back of the line in queue.
void switchTurns()
{
    back->nodePtr = nullptr;
    front->nodePtr = back;
    back = front;
    front = front->nodePtr;
}

// Get Pin Coordinates.
void getPinCoordinates(string pin, int &x, int &y)
{
    for (int row=1;row<11;row++) {
        for(int col=1;col<11;col++) {
            if (sampleGrid[row][col] == pin) {
                x = row;
                y = col;
                break;
            }
        }
    }
}

// Try for a hit or miss.
bool tryForHit(string pin)
{
    // Function Variables.
    int x,y;
    bool hit = false;

    // Find pin's grid coordinates. (at this point we already know pin exists).
    // Look through egrid for pin.
    getPinCoordinates(pin,x,y);

    // Display Coordinates.
    // cout << "[ " << x << " , " << y << " ]" << endl;

    // Initialize hit. 
    if (egrid[x][y] == enemySymbol)
    {
        ehitgrid[x][y] = hitSymbol;
        return (hit = true);
    }
    // initialize miss. 
    else if (egrid[x][y] != enemySymbol)
    {
        ehitgrid[x][y] = missSymbol;
        return hit;
    }
    return NULL;
}

// take turns firing missiles.
void TakeTurnsFiringMissiles()
{
    // Function Variables.
    int userScore = 0;
    int enemyScore = 0;
    int pinx = 0, piny = 0; // to hold coordinate pairs.

    do {
        cout << "\nScore: (17 Points to Win)\n"
             << name << " = " << userScore << endl
             << enemyName << " = " << enemyScore << endl;
        newline(1);

        // PLAYER FIRES MISSILES>
        if (front->data == name)
        {
            // Display Grids.
            cout << name << "'s Grid:\n";
            displayGrid(); newline(1);
            cout << enemyName << "'s Grid:\n";
            displayEHitGrid();
            newline(1);

            string pin;
            cout << front->data << ", please enter a coordinate to fire at.\n:";
            getline(cin, pin); // get input.
            if (doesPinExist(pin) == "true") // if pin exists...
            {
                bool hit = tryForHit(pin);
                if (hit)
                {
                    cout << front->data << " landed a HIT! Switch Turns.\n";
                    switchTurns();
                    userScore++;
                    if (userScore == 17)
                        break;
                }
                else
                {
                    cout << front->data << " MISSED! Switch Turns...\n";
                    switchTurns();
                    continue;
                }
            }
            else if (doesPinExist(pin) == "false") // else if pin does not exist...try again.
            {
                cout <<"The pin does not exist. Try again.\n";
                continue;
            }
        }

        // ENEMY FIRES MISSILES>
        else if (front->data == enemyName)
        {
            cout << front->data << " will now take aim.\n";
            // Fire at a random player grid coordinate.
            int x, y;
            x = (rand()%10)+1;
            y = (rand()%10)+1;

            cout << "ROW = " << x << " and COL = " << y << endl;

            if (grid[x][y] == shipSymbol)
            {
                cout << front->data << " landed a HIT! Switch Turns.\n";
                grid[x][y] = hitSymbol;
                switchTurns();
                enemyScore++;
                if (enemyScore == 17)
                    break;
            }
            else if (grid[x][y] == hitSymbol || grid[x][y] == missSymbol)
            {
                // Try again.
                cout << front->data << " already fired a missile at this pin. Opponent will try again.\n";
                continue;
            }
            else if (grid[x][y] == "-")
            {
                cout << front->data << " MISSED! Switch Turns...\n";
                grid[x][y] = missSymbol;
                switchTurns();
                continue;
            }
        }

    } //WHILE LOOP CONDITIONS
    while (userScore != 17 | enemyScore != 17);
    newline(1);

    // Print Out Winning Result.
    if (userScore == 17)
    {
        // Display Grids.
        cout << name << "'s Grid:\n";
        displayGrid(); newline(1);
        cout << enemyName << "'s Grid:\n";
        displayEHitGrid();
        newline(1);

        cout << name << " has WON!!!\n"
             << "FINAL SCORE:\n"
             << name << " = " << userScore << endl
             << enemyName << " = " << enemyScore << endl;
    }
    else if (enemyScore == 17)
    {
        // Display Grids.
        cout << name << "'s Grid:\n";
        displayGrid(); newline(1);
        cout << enemyName << "'s Grid:\n";
        displayEHitGrid();
        newline(1);

        cout << enemyName << " has WON!!!\n"
             << "FINAL SCORE:\n"
             << name << " = " << userScore << endl
             << enemyName << " = " << enemyScore << endl;
    }
}

// Display Player's Grid. 
void displayGrid() 
{
    print2dArray(grid);
}

// Display Enemy's Grid()
void displayEnemyGrid() 
{
    print2dArray(egrid);
}

// Display Enemy's Hit Grid. 
void displayEHitGrid() 
{
    print2dArray(ehitgrid);
}

// Create Player Function Declaration.
void createPlayer()
{
    int input;

    cout << "Enter Name for Player 1:\n";
    getline(cin, name);
    cout << "Player 1 = " << name << ".\n";
    cout << "If '" << name << "' is correct, enter 1: ";
    cin >> input;

    if (input != 1)
        cout << "You entered something else besides 1. Create Player cancelled.\n";
    else
    {
        // ** UTILIZATION OF STACKS **
        stack<string> ships;
        ships.push("'Destroyer'");
        ships.push("'Submarine'");
        ships.push("'Cruiser'");
        ships.push("'Battleship'");
        ships.push("'Carrier'");


        // Local Variables
        string pin1, pin2; // to temporarily hold grid pin information.
        string gridPins[5][2]; // to hold grid coordinates for all battleships.
        int index = 0; // To iterate through a list.
        newline(1); cin.ignore();

        // Get grid pin coordinates for all ships.
        while (!ships.empty())
        {
            cout << "(Warning: Read directions carefully.)" << endl;
            // Display which ship will be pinned.
            cout << "It is now time to initialize your "
                 << ships.top() << " " << name << ".\n\n";
            displayGrid(); newline(1);

            // INITIALIZE 'CARRIER'.
            //----------------------------------------
            if (ships.top() == "'Carrier'")
            {
                string pin1, pin2;
                cout << "To initialize your " << ships.top() << " properly,\n"
                     << "Enter your starting coordinate first,\nthen enter the last coordinate the ship's length will span across to.\n"
                     << "(In the case of your " << ships.top() << ", your ship must span '" << shipPinsInfo(ships)
                     << "'\npins without encountering other ship pins in between and without going off the grid.)\n";

                bool flag = false;
                do
                {
                    int row=-1, col=-1;
                    int row2=-1, col2=-1;
                    string pin1, pin2;
                    // displayExistingPins();

                    cout << ":";
                    getline(cin, pin1);
                    // cout << "~Does Pin exist: " << doesPinExist(pin1) << endl;

                    if (doesPinExist(pin1) == "true") {
                        returnPinCoordinates(pin1, row, col);

                        // If row and cols are real coordinates.
                        if (row == 99)
                        {
                            cout << "The pin is already initialized. Try again.\n";
                            displayGrid(); newline(1);
                            flag = false;
                        }
                        else if (row != -1 && col != -1)
                        {
                            // Initialize last coordinate.
                            cout << "Enter last coordinate "<< shipPinsInfo(ships)-1 << " spaces away:";
                            getline(cin, pin2);
                            // cout << "~Does Pin exist: " << doesPinExist(pin2) << endl;
                            if (doesPinExist(pin2) == "true")
                            {
                                returnPinCoordinates(pin2, row2, col2);

                                if (row2 == 99)
                                {
                                    cout << "The pin is already initialized. Try again.\n";
                                    displayGrid(); newline(1);
                                    flag = false;
                                }
                                    // All pins are initialized in this block.
                                else if (row2 != -1 && col2 != -1)
                                {
                                    int spaces = 0;

                                    // If Same Row.
                                    if (row == row2)
                                    {
                                        // cout << "The pins are in the same row.\n";

                                        // set pins not in reverse.
                                        if (col2 > col)
                                        {
                                            spaces = col2 - col;
                                            if (spaces != shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing between the two coordinates is invalid. Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                            else if (spaces == shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing is valid.\n";
                                                // Check if a ship already exists in the space between.
                                                if (grid[row][col+1] == shipSymbol || grid[row][col+2] == shipSymbol
                                                    || grid[row][col+3] == shipSymbol)
                                                {
                                                    cout << "Error. Cannot initialize over another ship. Try again.\n";
                                                    displayGrid(); newline(1);
                                                    flag = false;
                                                }
                                                else // Initialize grid.
                                                {
                                                    initPinCoordinates(row, col, shipSymbol);
                                                    initPinCoordinates(row,col+1, shipSymbol);
                                                    initPinCoordinates(row, col+2, shipSymbol);
                                                    initPinCoordinates(row, col+3, shipSymbol);
                                                    initPinCoordinates(row2, col2, shipSymbol);

                                                    // Print text art boat.
                                                    newline(1);
                                                    printTextArtBoat(ships); newline(1);
                                                    flag = true;
                                                }
                                            }
                                            else
                                            {
                                                cout << "An error occurred.\n Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                        }
                                        // set pins in reverse.
                                        else if (col > col2)
                                        {
                                            spaces = col - col2;

                                            if (spaces != shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing between the two coordinates is invalid. Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                            else if (spaces == shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing is valid.\n";
                                                // Check if a ship already exists in the space between.
                                                if (grid[row][col-1] == shipSymbol || grid[row][col-2] == shipSymbol
                                                    || grid[row][col-3] == shipSymbol)
                                                {
                                                    cout << "Error. Cannot initialize over another ship. Try again.\n";
                                                    displayGrid(); newline(1);
                                                    flag = false;
                                                }
                                                else // Initialize grid.
                                                {
                                                    initPinCoordinates(row, col, shipSymbol);
                                                    initPinCoordinates(row,col-1, shipSymbol);
                                                    initPinCoordinates(row, col-2, shipSymbol);
                                                    initPinCoordinates(row, col-3, shipSymbol);
                                                    initPinCoordinates(row2, col2, shipSymbol);

                                                    // Print text art boat.
                                                    newline(1);
                                                    printTextArtBoat(ships); newline(1);
                                                    flag = true;
                                                }
                                            }
                                            else
                                            {
                                                cout << "An error occurred.\n Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                        }
                                    }
                                    // If Same Column.
                                    else if (col == col2)
                                    {
                                        // cout << "The pins are in the same column.\n";

                                        // set pins not in reverse.
                                        if (row2 > row)
                                        {
                                            spaces = row2 - row;
                                            if (spaces != shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing between the two coordinates is invalid. Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                            else if (spaces == shipPinsInfo(ships)-1)
                                            {
                                                // Check if a ship already exists in the space between.
                                                if (grid[row+1][col] == shipSymbol || grid[row+2][col] == shipSymbol
                                                    || grid[row+3][col] == shipSymbol)
                                                {
                                                    cout << "Error. Cannot initialize over another ship. Try again.\n";
                                                    displayGrid(); newline(1);
                                                    flag = false;
                                                }
                                                else // Initialize grid.
                                                {
                                                    initPinCoordinates(row, col, shipSymbol);
                                                    initPinCoordinates(row+1,col, shipSymbol);
                                                    initPinCoordinates(row+2, col, shipSymbol);
                                                    initPinCoordinates(row+3, col, shipSymbol);
                                                    initPinCoordinates(row2, col2, shipSymbol);

                                                    // Print text art boat.
                                                    newline(1);
                                                    printTextArtBoat(ships); newline(1);
                                                    flag = true;
                                                }
                                            }
                                            else
                                            {
                                                cout << "An error occurred.\n Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                        }
                                        // set pins in reverse.
                                        else if (col > col2)
                                        {
                                            spaces = col - col2;
                                            if (spaces != shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing between the two coordinates is invalid. Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                            else if (spaces == shipPinsInfo(ships)-1)
                                            {
                                                // Check if a ship already exists in the space between.
                                                if (grid[row-1][col] == shipSymbol || grid[row-2][col] == shipSymbol
                                                    || grid[row-3][col] == shipSymbol)
                                                {
                                                    cout << "Error. Cannot initialize over another ship. Try again.\n";
                                                    displayGrid(); newline(1);
                                                    flag = false;
                                                }
                                                else // Initialize grid.
                                                {
                                                    initPinCoordinates(row, col, shipSymbol);
                                                    initPinCoordinates(row-1,col, shipSymbol);
                                                    initPinCoordinates(row-2, col, shipSymbol);
                                                    initPinCoordinates(row-3, col, shipSymbol);
                                                    initPinCoordinates(row2, col2, shipSymbol);

                                                    // Print text art boat.
                                                    newline(1);
                                                    printTextArtBoat(ships); newline(1);
                                                    flag = true;
                                                }
                                            }
                                            else
                                            {
                                                cout << "An error occurred.\n Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                        }
                                    }
                                    else if (row != row2 && col != col2)
                                    {
                                        cout << "Pin initialization was invalid. Try again.\n";
                                        displayGrid(); newline(1);
                                        flag = false;
                                    }
                                }
                                else
                                {
                                    cout << "The second pin was already initialized. Try again.\n";
                                    displayGrid(); newline(1);
                                    flag = false;
                                }
                            }
                            else
                            {
                                cout << "The pin doesn't exist. Try again.\n";
                                displayGrid(); newline(1);
                                flag = false;
                            }
                        }
                        else // print an error. Run loop again.
                        {
                            cout << "The pins could not be initialized properly. Try again.\n";
                            displayGrid(); newline(1);
                            flag = false;
                        }
                    }
                    else {
                        cout << "The pin does not exist! Try again.\n";
                        displayGrid(); newline(1);
                        flag = false;
                    }

                } while (flag != true);
            }
                // INITIALIZE 'BATTLESHIP'.
                // ----------------------------------------------
            else if (ships.top() == "'Battleship'")
            {
                string pin1, pin2;
                cout << "To initialize your " << ships.top() << " properly,\n"
                     << "Enter your starting coordinate first,\nthen enter the last coordinate the ship's length will span across to.\n"
                     << "(In the case of your " << ships.top() << ", your ship must span '" << shipPinsInfo(ships)
                     << "'\npins without encountering other ship pins in between and without going off the grid.)\n";

                bool flag = false;
                do
                {
                    int row=-1, col=-1;
                    int row2=-1, col2=-1;
                    string pin1, pin2;
                    // displayExistingPins();

                    cout << ":";
                    getline(cin, pin1);
                    // cout << "~Does Pin exist: " << doesPinExist(pin1) << endl;

                    if (doesPinExist(pin1) == "true") {
                        returnPinCoordinates(pin1, row, col);

                        // If row and cols are real coordinates.
                        if (row == 99)
                        {
                            cout << "The pin is already initialized. Try again.\n";
                            displayGrid(); newline(1);
                            flag = false;
                        }
                        else if (row != -1 && col != -1)
                        {
                            // Initialize last coordinate.
                            cout << "Enter last coordinate "<< shipPinsInfo(ships)-1 << " spaces away:";
                            getline(cin, pin2);
                            // cout << "~Does Pin exist: " << doesPinExist(pin2) << endl;
                            if (doesPinExist(pin2) == "true")
                            {
                                returnPinCoordinates(pin2, row2, col2);

                                if (row2 == 99)
                                {
                                    cout << "The pin is already initialized. Try again.\n";
                                    displayGrid(); newline(1);
                                    flag = false;
                                }
                                    // All pins are initialized in this block.
                                else if (row2 != -1 && col2 != -1)
                                {
                                    int spaces = 0;

                                    // If Same Row.
                                    if (row == row2)
                                    {
                                        // cout << "The pins are in the same row.\n";

                                        // set pins not in reverse.
                                        if (col2 > col)
                                        {
                                            spaces = col2 - col;
                                            if (spaces != shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing between the two coordinates is invalid. Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                            else if (spaces == shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing is valid.\n";
                                                // Check if a ship already exists in the space between.
                                                if (grid[row][col+1] == shipSymbol || grid[row][col+2] == shipSymbol)
                                                {
                                                    cout << "Error. Cannot initialize over another ship. Try again.\n";
                                                    displayGrid(); newline(1);
                                                    flag = false;
                                                }
                                                else // Initialize grid.
                                                {
                                                    initPinCoordinates(row, col, shipSymbol);
                                                    initPinCoordinates(row,col+1, shipSymbol);
                                                    initPinCoordinates(row, col+2, shipSymbol);
                                                    initPinCoordinates(row2, col2, shipSymbol);

                                                    // Print text art boat.
                                                    newline(1);
                                                    printTextArtBoat(ships); newline(1);
                                                    flag = true;
                                                }
                                            }
                                            else
                                            {
                                                cout << "An error occurred.\n Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                        }
                                        // set pins in reverse.
                                        else if (col > col2)
                                        {
                                            spaces = col - col2;

                                            if (spaces != shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing between the two coordinates is invalid. Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                            else if (spaces == shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing is valid.\n";
                                                // Check if a ship already exists in the space between.
                                                if (grid[row][col-1] == shipSymbol || grid[row][col-2] == shipSymbol)
                                                {
                                                    cout << "Error. Cannot initialize over another ship. Try again.\n";
                                                    displayGrid(); newline(1);
                                                    flag = false;
                                                }
                                                else // Initialize grid.
                                                {
                                                    initPinCoordinates(row, col, shipSymbol);
                                                    initPinCoordinates(row,col-1, shipSymbol);
                                                    initPinCoordinates(row, col-2, shipSymbol);
                                                    initPinCoordinates(row2, col2, shipSymbol);

                                                    // Print text art boat.
                                                    newline(1);
                                                    printTextArtBoat(ships); newline(1);
                                                    flag = true;
                                                }
                                            }
                                            else
                                            {
                                                cout << "An error occurred.\n Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                        }
                                    }
                                    // Else if Same Column.
                                    else if (col == col2)
                                    {
                                        // cout << "The pins are in the same column.\n";
                                        // set pins not in reverse.
                                        if (row2 > row)
                                        {
                                            spaces = row2 - row;
                                            if (spaces != shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing between the two coordinates is invalid. Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                            else if (spaces == shipPinsInfo(ships)-1)
                                            {
                                                // Check if a ship already exists in the space between.
                                                if (grid[row+1][col] == shipSymbol || grid[row+2][col] == shipSymbol)
                                                {
                                                    cout << "Error. Cannot initialize over another ship. Try again.\n";
                                                    displayGrid(); newline(1);
                                                    flag = false;
                                                }
                                                else // Initialize grid.
                                                {
                                                    initPinCoordinates(row, col, shipSymbol);
                                                    initPinCoordinates(row+1,col, shipSymbol);
                                                    initPinCoordinates(row+2, col, shipSymbol);
                                                    initPinCoordinates(row2, col2, shipSymbol);

                                                    // Print text art boat.
                                                    newline(1);
                                                    printTextArtBoat(ships); newline(1);
                                                    flag = true;
                                                }
                                            }
                                            else
                                            {
                                                cout << "An error occurred.\n Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                        }
                                        // set pins in reverse.
                                        else if (row > row2)
                                        {
                                            spaces = row - row2;
                                            if (spaces != shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing between the two coordinates is invalid. Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                            else if (spaces == shipPinsInfo(ships)-1)
                                            {
                                                // Check if a ship already exists in the space between.
                                                if (grid[row-1][col] == shipSymbol || grid[row-2][col] == shipSymbol)
                                                {
                                                    cout << "Error. Cannot initialize over another ship. Try again.\n";
                                                    displayGrid(); newline(1);
                                                    flag = false;
                                                }
                                                else // Initialize grid.
                                                {
                                                    initPinCoordinates(row, col, shipSymbol);
                                                    initPinCoordinates(row-1,col, shipSymbol);
                                                    initPinCoordinates(row-2, col, shipSymbol);
                                                    initPinCoordinates(row2, col2, shipSymbol);

                                                    // Print text art boat.
                                                    newline(1);
                                                    printTextArtBoat(ships); newline(1);
                                                    flag = true;
                                                }
                                            }
                                            else
                                            {
                                                cout << "An error occurred.\n Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                        }
                                        else
                                        {
                                            cout << "Pin initialization was invalid. Try again.\n";
                                            displayGrid(); newline(1);
                                            flag = false;
                                        }
                                    }
                                    else if (row != row2 && col != col2)
                                    {
                                        cout << "Pin initialization was invalid. Try again.\n";
                                        displayGrid(); newline(1);
                                        flag = false;
                                    }
                                }
                                else
                                {
                                    cout << "The second pin was already initialized. Try again.\n";
                                    displayGrid(); newline(1);
                                    flag = false;
                                }
                            }
                            else
                            {
                                cout << "The pin doesn't exist. Try again.\n";
                                displayGrid(); newline(1);
                                flag = false;
                            }
                        }
                        else // print an error. Run loop again.
                        {
                            cout << "The pins could not be initialized properly. Try again.\n";
                            displayGrid(); newline(1);
                            flag = false;
                        }
                    }
                    else {
                        cout << "The pin does not exist! Try again.\n";
                        displayGrid(); newline(1);
                        flag = false;
                    }

                } while (flag != true);
            }
                // INITIALIZE 'CRUISER' & 'SUBMARINE'
                // -----------------------------------------------------------------
            else if (ships.top() == "'Cruiser'" || ships.top() == "'Submarine'")
            {
                string pin1, pin2;
                cout << "To initialize your " << ships.top() << " properly,\n"
                     << "Enter your starting coordinate first,\nthen enter the last coordinate the ship's length will span across to.\n"
                     << "(In the case of your " << ships.top() << ", your ship must span '" << shipPinsInfo(ships)
                     << "'\npins without encountering other ship pins in between and without going off the grid.)\n";

                bool flag = false;
                do
                {
                    int row=-1, col=-1;
                    int row2=-1, col2=-1;
                    string pin1, pin2;
                    // displayExistingPins();

                    cout << ":";
                    getline(cin, pin1);
                    // cout << "~Does Pin exist: " << doesPinExist(pin1) << endl;

                    if (doesPinExist(pin1) == "true") {
                        returnPinCoordinates(pin1, row, col);

                        // If row and cols are real coordinates.
                        if (row == 99)
                        {
                            cout << "The pin is already initialized. Try again.\n";
                            displayGrid(); newline(1);
                            flag = false;
                        }
                        else if (row != -1 && col != -1)
                        {
                            // Initialize last coordinate.
                            cout << "Enter last coordinate "<< shipPinsInfo(ships)-1 << " spaces away:";
                            getline(cin, pin2);
                            // cout << "~Does Pin exist: " << doesPinExist(pin2) << endl;
                            if (doesPinExist(pin2) == "true")
                            {
                                returnPinCoordinates(pin2, row2, col2);

                                if (row2 == 99)
                                {
                                    cout << "The pin is already initialized. Try again.\n";
                                    displayGrid(); newline(1);
                                    flag = false;
                                }
                                    // All pins are initialized in this block.
                                else if (row2 != -1 && col2 != -1)
                                {
                                    int spaces = 0;

                                    // If Same Row.
                                    if (row == row2)
                                    {
                                        // cout << "The pins are in the same row.\n";
                                        // set pins not in reverse.
                                        if (col2 > col)
                                        {
                                            spaces = col2 - col;
                                            if (spaces != shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing between the two coordinates is invalid. Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                            else if (spaces == shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing is valid.\n";
                                                // Check if a ship already exists in the space between.
                                                if (grid[row][col+1] == shipSymbol)
                                                {
                                                    cout << "Error. Cannot initialize over another ship. Try again.\n";
                                                    displayGrid(); newline(1);
                                                    flag = false;
                                                }
                                                else // Initialize grid.
                                                {
                                                    initPinCoordinates(row, col, shipSymbol);
                                                    initPinCoordinates(row,col+1, shipSymbol);
                                                    initPinCoordinates(row2, col2, shipSymbol);

                                                    // Print text art boat.
                                                    newline(1);
                                                    printTextArtBoat(ships); newline(1);
                                                    flag = true;
                                                }
                                            }
                                            else
                                            {
                                                cout << "An error occurred.\n Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                        }
                                        // set pins in reverse.
                                        else if (col > col2)
                                        {
                                            spaces = col - col2;

                                            if (spaces != shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing between the two coordinates is invalid. Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                            else if (spaces == shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing is valid.\n";
                                                // Check if a ship already exists in the space between.
                                                if (grid[row][col-1] == shipSymbol)
                                                {
                                                    cout << "Error. Cannot initialize over another ship. Try again.\n";
                                                    displayGrid(); newline(1);
                                                    flag = false;
                                                }
                                                else // Initialize grid.
                                                {
                                                    initPinCoordinates(row, col, shipSymbol);
                                                    initPinCoordinates(row,col-1, shipSymbol);
                                                    initPinCoordinates(row2, col2, shipSymbol);

                                                    // Print text art boat.
                                                    newline(1);
                                                    printTextArtBoat(ships); newline(1);
                                                    flag = true;
                                                }
                                            }
                                            else
                                            {
                                                cout << "An error occurred.\n Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                        }
                                        else
                                        {
                                            cout << "An error occurred.\n Try again.\n";
                                            displayGrid(); newline(1);
                                            flag = false;
                                        }
                                    }
                                    // If Same Column.
                                    else if (col == col2)
                                    {
                                        // cout << "The pins are in the same column.\n";
                                        // Initialize pin in forwardly.
                                        if (row2 > row)
                                        {
                                            spaces = row2 - row;
                                            if (spaces != shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing between the two coordinates is invalid. Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                            else if (spaces == shipPinsInfo(ships)-1)
                                            {
                                                // Check if a ship already exists in the space between.
                                                if (grid[row+1][col] == shipSymbol)
                                                {
                                                    cout << "Error. Cannot initialize over another ship. Try again.\n";
                                                    displayGrid(); newline(1);
                                                    flag = false;
                                                }
                                                else // Initialize grid.
                                                {
                                                    initPinCoordinates(row, col, shipSymbol);
                                                    initPinCoordinates(row+1,col, shipSymbol);
                                                    initPinCoordinates(row2, col2, shipSymbol);

                                                    // Print text art boat.
                                                    newline(1);
                                                    printTextArtBoat(ships); newline(1);
                                                    flag = true;
                                                }
                                            }
                                            else
                                            {
                                                cout << "An error occurred.\n Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                        }
                                        // initialize pins in reverse.
                                        else if (row > row2)
                                        {
                                            spaces = row - row2;
                                            if (spaces != shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing between the two coordinates is invalid. Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                            else if (spaces == shipPinsInfo(ships)-1)
                                            {
                                                // Check if a ship already exists in the space between.
                                                if (grid[row-1][col] == shipSymbol)
                                                {
                                                    cout << "Error. Cannot initialize over another ship. Try again.\n";
                                                    displayGrid(); newline(1);
                                                    flag = false;
                                                }
                                                else // Initialize grid.
                                                {
                                                    initPinCoordinates(row, col, shipSymbol);
                                                    initPinCoordinates(row-1,col, shipSymbol);
                                                    initPinCoordinates(row2, col2, shipSymbol);

                                                    // Print text art boat.
                                                    newline(1);
                                                    printTextArtBoat(ships); newline(1);
                                                    flag = true;
                                                }
                                            }
                                            else
                                            {
                                                cout << "An error occurred.\n Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                        }
                                        else
                                        {
                                            cout << "An error occurred.\n Try again.\n";
                                            displayGrid(); newline(1);
                                            flag = false;
                                        }
                                    }
                                    else if (row != row2 && col != col2)
                                    {
                                        cout << "Pin initialization was invalid. Try again.\n";
                                        displayGrid(); newline(1);
                                        flag = false;
                                    }
                                }
                                else
                                {
                                    cout << "The second pin was already initialized. Try again.\n";
                                    displayGrid(); newline(1);
                                    flag = false;
                                }
                            }
                            else
                            {
                                cout << "The pin doesn't exist. Try again.\n";
                                displayGrid(); newline(1);
                                flag = false;
                            }
                        }
                        else // print an error. Run loop again.
                        {
                            cout << "The pins could not be initialized properly. Try again.\n";
                            displayGrid(); newline(1);
                            flag = false;
                        }
                    }
                    else {
                        cout << "The pin does not exist! Try again.\n";
                        displayGrid(); newline(1);
                        flag = false;
                    }

                } while (flag != true);
            }
                // INITIALIZE 'DESTROYER'
                //--------------------------------------
            else if (ships.top() == "'Destroyer'")
            {
                string pin1, pin2;
                cout << "To initialize your " << ships.top() << " properly,\n"
                     << "Enter your starting coordinate first,\nthen enter the last coordinate the ship's length will span across to.\n"
                     << "(In the case of your " << ships.top() << ", your ship must span '" << shipPinsInfo(ships)
                     << "'\npins without encountering other ship pins in between and without going off the grid.)\n";

                bool flag = false;
                do
                {
                    int row=-1, col=-1;
                    int row2=-1, col2=-1;
                    string pin1, pin2;
                    // displayExistingPins();

                    cout << ":";
                    getline(cin, pin1);
                    cout << "~Does Pin exist: " << doesPinExist(pin1) << endl;

                    if (doesPinExist(pin1) == "true")
                    {
                        returnPinCoordinates(pin1, row, col);

                        // If row and cols are real coordinates.
                        if (row == 99)
                        {
                            cout << "The pin is already initialized. Try again.\n";
                            displayGrid(); newline(1);
                            flag = false;
                        }
                        else if (row != -1 && col != -1)
                        {
                            // Initialize last coordinate.
                            cout << "Enter last coordinate "<< shipPinsInfo(ships)-1 << " spaces away:";
                            getline(cin, pin2);
                            // cout << "~Does Pin exist: " << doesPinExist(pin2) << endl;
                            if (doesPinExist(pin2) == "true")
                            {
                                returnPinCoordinates(pin2, row2, col2);

                                if (row2 == 99)
                                {
                                    cout << "The pin is already initialized. Try again.\n";
                                    displayGrid(); newline(1);
                                    flag = false;
                                }
                                    // All pins are initialized in this block.
                                else if (row2 != -1 && col2 != -1)
                                {
                                    int spaces = 0;

                                    // If Same Row.
                                    if (row == row2)
                                    {
                                        // cout << "The pins are in the same row.\n";
                                        if (col2 > col)
                                        {
                                            spaces = col2 - col;
                                            if (spaces != shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing between the two coordinates is invalid. Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                            else if (spaces == shipPinsInfo(ships)-1)
                                            {
                                                initPinCoordinates(row, col, shipSymbol);
                                                initPinCoordinates(row2, col2, shipSymbol);

                                                // Print text art boat.
                                                newline(1);
                                                printTextArtBoat(ships); newline(1);
                                                flag = true;
                                            }
                                            else
                                            {
                                                cout << "An error occurred.\n Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                        }
                                        else if (col > col2)
                                        {
                                            spaces = col - col2;

                                            if (spaces != shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing between the two coordinates is invalid. Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                            else if (spaces == shipPinsInfo(ships)-1)
                                            {
                                                initPinCoordinates(row, col, shipSymbol);
                                                initPinCoordinates(row2, col2, shipSymbol);

                                                // Print text art boat.
                                                newline(1);
                                                printTextArtBoat(ships); newline(1);
                                                flag = true;
                                            }
                                            else
                                            {
                                                cout << "An error occurred.\n Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                        }
                                        else
                                        {
                                            cout << "An error occurred.\n Try again.\n";
                                            displayGrid(); newline(1);
                                            flag = false;
                                        }
                                    }
                                        // Else if Same Column.
                                    else if (col == col2)
                                    {
                                        int spaces = 0;
                                        // cout << "The pins are in the same column.\n";
                                        if (row2 > row)
                                        {
                                            spaces = row2 - row;
                                            if (spaces != shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing between the two coordinates is invalid. Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                            else if (spaces == shipPinsInfo(ships)-1)
                                            {
                                                // Check if a ship already exists in the space between.
                                                if (grid[row+1][col] == shipSymbol)
                                                {
                                                    cout << "Error. Cannot initialize over another ship. Try again.\n";
                                                    displayGrid(); newline(1);
                                                    flag = false;
                                                }
                                                else // Initialize grid.
                                                {
                                                    initPinCoordinates(row, col, shipSymbol);
                                                    initPinCoordinates(row2, col2, shipSymbol);

                                                    // Print text art boat.
                                                    newline(1);
                                                    printTextArtBoat(ships); newline(1);
                                                    flag = true;
                                                }
                                            }
                                            else
                                            {
                                                cout << "An error occurred.\n Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                        }
                                        else if (row > row2)
                                        {
                                            spaces = row - row2;
                                            if (spaces != shipPinsInfo(ships)-1)
                                            {
                                                cout << "The spacing between the two coordinates is invalid. Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                            else if (spaces == shipPinsInfo(ships)-1)
                                            {
                                                // Check if a ship already exists in the space between.
                                                if (grid[row-1][col] == shipSymbol)
                                                {
                                                    cout << "Error. Cannot initialize over another ship. Try again.\n";
                                                    displayGrid(); newline(1);
                                                    flag = false;
                                                }
                                                else // Initialize grid.
                                                {
                                                    initPinCoordinates(row, col, shipSymbol);
                                                    initPinCoordinates(row2, col2, shipSymbol);

                                                    // Print text art boat.
                                                    newline(1);
                                                    printTextArtBoat(ships); newline(1);
                                                    flag = true;
                                                }
                                            }
                                            else
                                            {
                                                cout << "An error occurred.\n Try again.\n";
                                                displayGrid(); newline(1);
                                                flag = false;
                                            }
                                        }
                                        else
                                        {
                                            cout << "An error occurred.\n Try again.\n";
                                            displayGrid(); newline(1);
                                            flag = false;
                                        }
                                    }
                                    else if (row != row2 && col != col2)
                                    {
                                        cout << "Pin initialization was invalid. Try again.\n";
                                        displayGrid(); newline(1);
                                        flag = false;
                                    }
                                }
                                else
                                {
                                    cout << "The second pin was already initialized. Try again.\n";
                                    displayGrid(); newline(1);
                                    flag = false;
                                }
                            }
                            else
                            {
                                cout << "The pin doesn't exist. Try again.\n";
                                displayGrid(); newline(1);
                                flag = false;
                            }
                        }
                        else // print an error. Run loop again.
                        {
                            cout << "The pins could not be initialized properly. Try again.\n";
                            displayGrid(); newline(1);
                            flag = false;
                        }
                    }
                    else
                    {
                        cout << "The pin does not exist! Try again.\n";
                        displayGrid(); newline(1);
                        flag = false;
                    }
                } while (flag != true);
            }
                // Else Print out an Error Message.
            else
            {
                cout << "Either the ships stack is now empty or an error occurred.\n";
            }
            // Move to the next item on the stack.
            ships.pop(); // Pop the top of the ships stack.
        }

        // Display Prompt if all coordinates are successfully initialized.
        // displayGrid(); newline(1);
        cout << "End of player's ship initialization."; newline(2);
    }
}

// Set Grid Pin Function Declaration.
void initGridPin(string i, string shipIcon, int &x, int &y, bool reset)
{
    // Row A
    //--------------------------------------
    if (i == "A1")
    {
        if (reset == true)
            resetGridPin(1,1,i);
        else if (inputValidation(1,1) != true)
            cout << "The pin encountered an error.\n";
        else
            x=1;y=1;;
    }
    else if (i == "A2")
    {
        if (reset == true)
            resetGridPin(1,2,i);
        else if (inputValidation(1,2) != true)
            cout << "The pin encountered an error.\n";
        else
            x=1;y=2;
    }
    else if (i == "A3")
    {
        if (reset == true)
            resetGridPin(1,3,i);
        else if (inputValidation(1,3) != true)
            cout << "The pin encountered an error.\n";
        else
            x=1;y=3;

    }
    else if (i == "A4")
    {
        if (reset == true)
            resetGridPin(1,4,i);
        else if (inputValidation(1,4) != true)
            cout << "The pin encountered an error.\n";
        else
            x=1;y=4;
    }
    else if (i == "A5")
    {
        if (reset == true)
            resetGridPin(1,5,i);
        else if (inputValidation(1,5) != true)
            cout << "The pin encountered an error.\n";
        else
            x=1;y=5;
    }
    else if (i == "A6")
    {
        if (reset == true)
            resetGridPin(1,6,i);
        else if (inputValidation(1,6) != true)
            cout << "The pin encountered an error.\n";
        else
            x=1;y=6;
    }
    else if (i == "A7")
    {
        if (reset == true)
            resetGridPin(1,7,i);
        else if (inputValidation(1,7) != true)
            cout << "The pin encountered an error.\n";
        else
            x=1;y=7;
    }
    else if (i == "A8")
    {
        if (reset == true)
            resetGridPin(1,8,i);
        else if (inputValidation(1,8) != true)
            cout << "The pin encountered an error.\n";
        else
            x=1;y=8;
    }
    else if (i == "A9")
    {
        if (reset == true)
            resetGridPin(1,9,i);
        else if (inputValidation(1,9) != true)
            cout << "The pin encountered an error.\n";
        else
            x=1;y=9;
    }
    else if (i == "A10")
    {
        if (reset == true)
            resetGridPin(1,10,i);
        else if (inputValidation(1,10) != true)
            cout << "The pin encountered an error.\n";
        else
            x=1;y=10;
    }
        //----------------------------------------
        //
        // Row B
        //------------------------------------------
    else if (i == "B1")
    {
        if (reset == true)
            resetGridPin(2,1,i);
        else if (inputValidation(2,1) != true)
            cout << "The pin encountered an error.\n";
        else
            x=2;y=1;
    }
    else if (i == "B2")
    {
        if (reset == true)
            resetGridPin(2,2,i);
        else if (inputValidation(2,2) != true)
            cout << "The pin encountered an error.\n";
        else
            x=2;y=2;
    }
    else if (i == "B3")
    {
        if (reset == true)
            resetGridPin(2,3,i);
        else if (inputValidation(2,3) != true)
            cout << "The pin encountered an error.\n";
        else
            x=2;y=3;
    }
    else if (i == "B4")
    {
        if (reset == true)
            resetGridPin(2,4,i);
        else if (inputValidation(2,4) != true)
            cout << "The pin encountered an error.\n";
        else
            x=2;y=4;
    }
    else if (i == "B5")
    {
        if (reset == true)
            resetGridPin(2,5,i);
        else if (inputValidation(2,5) != true)
            cout << "The pin encountered an error.\n";
        else
            x=2;y=5;
    }
    else if (i == "B6")
    {
        if (reset == true)
            resetGridPin(2,6,i);
        else if (inputValidation(2,6) != true)
            cout << "The pin encountered an error.\n";
        else
            x=2;y=6;
    }
    else if (i == "B7")
    {
        if (reset == true)
            resetGridPin(2,7,i);
        else if (inputValidation(2,7) != true)
            cout << "The pin encountered an error.\n";
        else
            x=2;y=7;
    }
    else if (i == "B8")
    {
        if (reset == true)
            resetGridPin(2,8,i);
        else if (inputValidation(2,8) != true)
            cout << "The pin encountered an error.\n";
        else
            x=2;y=8;
    }
    else if (i == "B9")
    {
        if (reset == true)
            resetGridPin(2,9,i);
        else if (inputValidation(2,9) != true)
            cout << "The pin encountered an error.\n";
        else
            x=2;y=9;
    }
    else if (i == "B10")
    {
        if (reset == true)
            resetGridPin(2,10,i);
        else if (inputValidation(2,10) != true)
            cout << "The pin encountered an error.\n";
        else
            x=2;y=10;
    }
        //-----------------------------------------
        //
        // Row C
        //-----------------------------------------
    else if (i == "C1")
    {
        if (reset == true)
            resetGridPin(3,1,i);
        else if (inputValidation(3,1) != true)
            cout << "The pin encountered an error.\n";
        else
            x=3;y=1;
    }
    else if (i == "C2")
    {
        if (reset == true)
            resetGridPin(3,2,i);
        else if (inputValidation(3,2) != true)
            cout << "The pin encountered an error.\n";
        else
            x=3;y=2;
    }
    else if (i == "C3")
    {
        if (reset == true)
            resetGridPin(3,3,i);
        else if (inputValidation(3,3) != true)
            cout << "The pin encountered an error.\n";
        else
            x=3;y=3;
    }
    else if (i == "C4")
    {
        if (reset == true)
            resetGridPin(3,4,i);
        else if (inputValidation(3,4) != true)
            cout << "The pin encountered an error.\n";
        else
            x=3;y=4;
    }
    else if (i == "C5")
    {
        if (reset == true)
            resetGridPin(3,5,i);
        else if (inputValidation(3,5) != true)
            cout << "The pin encountered an error.\n";
        else
            x=3;y=5;
    }
    else if (i == "C6")
    {
        if (reset == true)
            resetGridPin(3,6,i);
        else if (inputValidation(3,6) != true)
            cout << "The pin encountered an error.\n";
        else
            x=3;y=6;
    }
    else if (i == "C7")
    {
        if (reset == true)
            resetGridPin(3,7,i);
        else if (inputValidation(3,7) != true)
            cout << "The pin encountered an error.\n";
        else
            x=3;y=7;
    }
    else if (i == "C8")
    {
        if (reset == true)
            resetGridPin(3,8,i);
        else if (inputValidation(3,8) != true)
            cout << "The pin encountered an error.\n";
        else
            x=3;y=8;
    }
    else if (i == "C9")
    {
        if (reset == true)
            resetGridPin(3,9,i);
        else if (inputValidation(3,9) != true)
            cout << "The pin encountered an error.\n";
        else
            x=3;y=9;
    }
    else if (i == "C10")
    {
        if (reset == true)
            resetGridPin(3,10,i);
        else if (inputValidation(3,10) != true)
            cout << "The pin encountered an error.\n";
        else
            x=3;y=10;
    }
        //------------------------------------------
        //
        // Row D
        //------------------------------------------
    else if (i == "D1")
    {
        if (reset == true)
            resetGridPin(4,1,i);
        else if (inputValidation(4,1) != true)
            cout << "The pin encountered an error.\n";
        else
            x=4;y=1;
    }
    else if (i == "D2")
    {
        if (reset == true)
            resetGridPin(4,2,i);
        else if (inputValidation(4,2) != true)
            cout << "The pin encountered an error.\n";
        else
            x=4;y=2;
    }
    else if (i == "D3")
    {
        if (reset == true)
            resetGridPin(4,3,i);
        else if (inputValidation(4,3) != true)
            cout << "The pin encountered an error.\n";
        else
            x=4;y=3;
    }
    else if (i == "D4")
    {
        if (reset == true)
            resetGridPin(4,4,i);
        else if(inputValidation(4,4) != true)
            cout << "The pin encountered an error.\n";
        else
            x=4;y=4;
    }
    else if (i == "D5")
    {
        if (reset == true)
            resetGridPin(4,5,i);
        else if (inputValidation(4,5) != true)
            cout << "The pin encountered an error.\n";
        else
            x=4;y=5;
    }
    else if (i == "D6")
    {
        if (reset == true)
            resetGridPin(4,6,i);
        else if (inputValidation(4,6) != true)
            cout << "The pin encountered an error.\n";
        else
            x=4;y=6;
    }
    else if (i == "D7")
    {
        if (reset == true)
            resetGridPin(4,7,i);
        else if (inputValidation(4,7) != true)
            cout << "The pin encountered an error.\n";
        else
            x=4;y=7;
    }
    else if (i == "D8")
    {
        if (reset == true)
            resetGridPin(4,8,i);
        else if (inputValidation(4,8) != true)
            cout << "The pin encountered an error.\n";
        else
            x=4;y=8;
    }
    else if (i == "D9")
    {
        if (reset == true)
            resetGridPin(4,9,i);
        else if (inputValidation(4,9) != true)
            cout << "The pin encountered an error.\n";
        else
            x=4;y=9;
    }
    else if (i == "D10")
    {
        if (reset == true)
            resetGridPin(4,10,i);
        else if (inputValidation(4,10) != true)
            cout << "The pin encountered an error.\n";
        else
            x=4;y=10;
    }
        //----------------------------------------
        //
        // Row E
        //------------------------------------------
    else if (i == "E1")
    {
        if (reset == true)
            resetGridPin(5,1,i);
        else if (inputValidation(5,1) != true)
            cout << "The pin encountered an error.\n";
        else
            x=5;y=1;
    }
    else if (i == "E2")
    {
        if (reset == true)
            resetGridPin(5,2,i);
        else if (inputValidation(5,2) != true)
            cout << "The pin encountered an error.\n";
        else
            x=5;y=2;
    }
    else if (i == "E3")
    {
        if (reset == true)
            resetGridPin(5,3,i);
        else if (inputValidation(5,3) != true)
            cout << "The pin encountered an error.\n";
        else
            x=5;y=3;
    }
    else if (i == "E4")
    {
        if (reset == true)
            resetGridPin(5,4,i);
        else if (inputValidation(5,4) != true)
            cout << "The pin encountered an error.\n";
        else
            x=5;y=4;
    }
    else if (i == "E5")
    {
        if (reset == true)
            resetGridPin(5,5,i);
        else if (inputValidation(5,5) != true)
            cout << "The pin encountered an error.\n";
        else
            x=5;y=5;
    }
    else if (i == "E6")
    {
        if (reset == true)
            resetGridPin(5,6,i);
        else if (inputValidation(5,6) != true)
            cout << "The pin encountered an error.\n";
        else
            x=5;y=6;
    }
    else if (i == "E7")
    {
        if (reset == true)
            resetGridPin(5,7,i);
        else if (inputValidation(5,7) != true)
            cout << "The pin encountered an error.\n";
        else
            x=5;y=7;
    }
    else if (i == "E8")
    {
        if (reset == true)
            resetGridPin(5,8,i);
        else if (inputValidation(5,8) != true)
            cout << "The pin encountered an error.\n";
        else
            x=5;y=8;
    }
    else if (i == "E9")
    {
        if (reset == true)
            resetGridPin(5,9,i);
        else if (inputValidation(5,9) != true)
            cout << "The pin encountered an error.\n";
        else
            x=5;y=9;
    }
    else if (i == "E10")
    {
        if (reset == true)
            resetGridPin(5,10,i);
        else if (inputValidation(5,10) != true)
            cout << "The pin encountered an error.\n";
        else
            x=5;y=10;
    }
        //-----------------------------------------
        //
        // Row F
        //------------------------------------------
    else if (i == "F1")
    {
        if (reset == true)
            resetGridPin(6,1,i);
        else if (inputValidation(6,1) != true)
            cout << "The pin encountered an error.\n";
        else
            x=6;y=1;
    }
    else if (i == "F2")
    {
        if (reset == true)
            resetGridPin(6,2,i);
        else if (inputValidation(6,2) != true)
            cout << "The pin encountered an error.\n";
        else
            x=6;y=2;
    }
    else if (i == "F3")
    {
        if (reset == true)
            resetGridPin(6,3,i);
        else if (inputValidation(6,3) != true)
            cout << "The pin encountered an error.\n";
        else
            x=6;y=3;
    }
    else if (i == "F4")
    {
        if (reset == true)
            resetGridPin(6,4,i);
        else if (inputValidation(6,4) != true)
            cout << "The pin encountered an error.\n";
        else
            x=6;y=4;
    }
    else if (i == "F5")
    {
        if (reset == true)
            resetGridPin(6,5,i);
        else if (inputValidation(6,5) != true)
            cout << "The pin encountered an error.\n";
        else
            x=6;y=5;
    }
    else if (i == "F6")
    {
        if (reset == true)
            resetGridPin(6,6,i);
        else if (inputValidation(6,6) != true)
            cout << "The pin encountered an error.\n";
        else
            x=6;y=6;
    }
    else if (i == "F7")
    {
        if (reset == true)
            resetGridPin(6,7,i);
        else if (inputValidation(6,7) != true)
            cout << "The pin encountered an error.\n";
        else
            x=6;y=7;
    }
    else if (i == "F8")
    {
        if (reset == true)
            resetGridPin(6,8,i);
        else if (inputValidation(6,8) != true)
            cout << "The pin encountered an error.\n";
        else
            x=6;y=8;
    }
    else if (i == "F9")
    {
        if (reset == true)
            resetGridPin(6,9,i);
        else if (inputValidation(6,9) != true)
            cout << "The pin encountered an error.\n";
        else
            x=6;y=9;
    }
    else if (i == "F10")
    {
        if (reset == true)
            resetGridPin(6,10,i);
        else if (inputValidation(6,10) != true)
            cout << "The pin encountered an error.\n";
        else
            x=6;y=10;
    }
        //
        // Row G
    else if (i == "G1")
    {
        if (reset == true)
            resetGridPin(7,1,i);
        else if (inputValidation(7,1) != true)
            cout << "The pin encountered an error.\n";
        else
            x=7;y=1;
    }
    else if (i == "G2")
    {
        if (reset == true)
            resetGridPin(7,2,i);
        else if (inputValidation(7,2) != true)
            cout << "The pin encountered an error.\n";
        else
            x=7;y=2;
    }
    else if (i == "G3")
    {
        if (reset == true)
            resetGridPin(7,3,i);
        else if (inputValidation(7,3) != true)
            cout << "The pin encountered an error.\n";
        else
            x=7;y=3;
    }
    else if (i == "G4")
    {
        if (reset == true)
            resetGridPin(7,4,i);
        else if (inputValidation(7,4) != true)
            cout << "The pin encountered an error.\n";
        else
            x=7;y=4;
    }
    else if (i == "G5")
    {
        if (reset == true)
            resetGridPin(7,5,i);
        else if (inputValidation(7,5) != true)
            cout << "The pin encountered an error.\n";
        else
            x=7;y=5;
    }
    else if (i == "G6")
    {
        if (reset == true)
            resetGridPin(7,6,i);
        else if (inputValidation(7,6) != true)
            cout << "The pin encountered an error.\n";
        else
            x=7;y=6;
    }
    else if (i == "G7")
    {
        if (reset == true)
            resetGridPin(7,7,i);
        else if (inputValidation(7,7) != true)
            cout << "The pin encountered an error.\n";
        else
            x=7;y=7;
    }
    else if (i == "G8")
    {
        if (reset == true)
            resetGridPin(7,8,i);
        else if (inputValidation(7,8) != true)
            cout << "The pin encountered an error.\n";
        else
            x=7;y=8;
    }
    else if (i == "G9")
    {
        if (reset == true)
            resetGridPin(7,9,i);
        else if (inputValidation(7,9) != true)
            cout << "The pin encountered an error.\n";
        else
            x=7;y=9;
    }
    else if (i == "G10")
    {
        if (reset == true)
            resetGridPin(7,10,i);
        else if (inputValidation(7,10) != true)
            cout << "The pin encountered an error.\n";
        else
            x=7;y=10;
    }
        //
        // Row H
    else if (i == "H1")
    {
        if (reset == true)
            resetGridPin(8,1,i);
        else if (inputValidation(8,1) != true)
            cout << "The pin encountered an error.\n";
        else
            x=8;y=1;
    }
    else if (i == "H2")
    {
        if (reset == true)
            resetGridPin(8,2,i);
        else if (inputValidation(8,2) != true)
            cout << "The pin encountered an error.\n";
        else
            x=8;y=2;
    }
    else if (i == "H3")
    {
        if (reset == true)
            resetGridPin(8,3,i);
        else if (inputValidation(8,3) != true)
            cout << "The pin encountered an error.\n";
        else
            x=8;y=3;
    }
    else if (i == "H4")
    {
        if (reset == true)
            resetGridPin(8,4,i);
        else if (inputValidation(8,4) != true)
            cout << "The pin encountered an error.\n";
        else
            x=8;y=4;
    }
    else if (i == "H5")
    {
        if (reset == true)
            resetGridPin(8,5,i);
        else if (inputValidation(8,5) != true)
            cout << "The pin encountered an error.\n";
        else
            x=8;y=5;
    }
    else if (i == "H6")
    {
        if (reset == true)
            resetGridPin(8,6,i);
        else if (inputValidation(8,6) != true)
            cout << "The pin encountered an error.\n";
        else
            x=8;y=6;
    }
    else if (i == "H7")
    {
        if (reset == true)
            resetGridPin(8,7,i);
        else if (inputValidation(8,7) != true)
            cout << "The pin encountered an error.\n";
        else
            x=8;y=7;
    }
    else if (i == "H8")
    {
        if (reset == true)
            resetGridPin(8,8,i);
        else if (inputValidation(8,8) != true)
            cout << "The pin encountered an error.\n";
        else
            x=8;y=8;
    }
    else if (i == "H9")
    {
        if (reset == true)
            resetGridPin(8,9,i);
        else if (inputValidation(8,9) != true)
            cout << "The pin encountered an error.\n";
        else
            x=8;y=9;
    }
    else if (i == "H10")
    {
        if (reset == true)
            resetGridPin(8,10,i);
        else if (inputValidation(8,10) != true)
            cout << "The pin encountered an error.\n";
        else
            x=8;y=10;
    }
        //
        // Row I
    else if (i == "I1")
    {
        if (reset == true)
            resetGridPin(9,1,i);
        else if (inputValidation(9,1) != true)
            cout << "The pin encountered an error.\n";
        else
            x=9;y=1;
    }
    else if (i == "I2")
    {
        if (reset == true)
            resetGridPin(9,2,i);
        else if (inputValidation(9,2) != true)
            cout << "The pin encountered an error.\n";
        else
            x=9;y=2;
    }
    else if (i == "I3")
    {
        if (reset == true)
            resetGridPin(9,3,i);
        else if (inputValidation(9,3) != true)
            cout << "The pin encountered an error.\n";
        else
            x=9;y=3;
    }
    else if (i == "I4")
    {
        if (reset == true)
            resetGridPin(9,4,i);
        else if (inputValidation(9,4) != true)
            cout << "The pin encountered an error.\n";
        else
            x=9;y=4;
    }
    else if (i == "I5")
    {
        if (reset == true)
            resetGridPin(9,5,i);
        else if (inputValidation(9,5) != true)
            cout << "The pin encountered an error.\n";
        else
            x=9;y=5;
    }
    else if (i == "I6")
    {
        if (reset == true)
            resetGridPin(9,6,i);
        else if (inputValidation(9,6) != true)
            cout << "The pin encountered an error.\n";
        else
            x=9;y=6;
    }
    else if (i == "I7")
    {
        if (reset == true)
            resetGridPin(9,7,i);
        else if (inputValidation(9,7) != true)
            cout << "The pin encountered an error.\n";
        else
            x=9;y=7;
    }
    else if (i == "I8")
    {
        if (reset == true)
            resetGridPin(9,8,i);
        else if (inputValidation(9,8) != true)
            cout << "The pin encountered an error.\n";
        else
            x=9;y=8;
    }
    else if (i == "I9")
    {
        if (reset == true)
            resetGridPin(9,9,i);
        else if (inputValidation(9,9) != true)
            cout << "The pin encountered an error.\n";
        else
            x=9;y=9;
    }
    else if (i == "I10")
    {
        if (reset == true)
            resetGridPin(9,10,i);
        else if (inputValidation(9,10) != true)
            cout << "The pin encountered an error.\n";
        else
            x=9;y=10;
    }
        //
        // Row J
    else if (i == "J1")
    {
        if (reset == true)
            resetGridPin(10,1,i);
        else if (inputValidation(10,1) != true)
            cout << "The pin encountered an error.\n";
        else
            x=10;y=1;
    }
    else if (i == "J2")
    {
        if (reset == true)
            resetGridPin(10,2,i);
        else if (inputValidation(10,2) != true)
            cout << "The pin encountered an error.\n";
        else
            x=10;y=2;
    }
    else if (i == "J3")
    {
        if (reset == true)
            resetGridPin(10,3,i);
        else if (inputValidation(10,3) != true)
            cout << "The pin encountered an error.\n";
        else
            x=10;y=3;
    }
    else if (i == "J4")
    {
        if (reset == true)
            resetGridPin(10,4,i);
        else if (inputValidation(10,4) != true)
            cout << "The pin encountered an error.\n";
        else
            x=10;y=4;
    }
    else if (i == "J5")
    {
        if (reset == true)
            resetGridPin(10,5,i);
        else if (inputValidation(10,5) != true)
            cout << "The pin encountered an error.\n";
        else
            x=10;y=5;
    }
    else if (i == "J6")
    {
        if (reset == true)
            resetGridPin(10,6,i);
        else if (inputValidation(10,6) != true)
            cout << "The pin encountered an error.\n";
        else
            x=10;y=6;
    }
    else if (i == "J7")
    {
        if (reset == true)
            resetGridPin(10,7,i);
        else if (inputValidation(10,7) != true)
            cout << "The pin encountered an error.\n";
        else
            x=10;y=7;
    }
    else if (i == "J8")
    {
        if (reset == true)
            resetGridPin(10,8,i);
        else if (inputValidation(10,8) != true)
            cout << "The pin encountered an error.\n";
        else
            x=10;y=8;
    }
    else if (i == "J9")
    {
        if (reset == true)
            resetGridPin(10,9,i);
        else if (inputValidation(10,9) != true)
            cout << "The pin encountered an error.\n";
        else
            x=10;y=9;
    }
    else if (i == "J10")
    {
        if (reset == true)
            resetGridPin(10,10,i);
        else if (inputValidation(10,10) != true)
            cout << "The pin encountered an error.\n";
        else
            x=10;y=10;
    }
}
