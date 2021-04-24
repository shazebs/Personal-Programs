// Author: Shazeb Suhail
// Date:   4/13/21
// Time:   3:00 PM

#include <iostream>
#include <cstdlib>
#include <ctime>
#include <list>
#include <stack>
#include <queue>
#include <map>
#include <set>
#include <ctime>
#include <iomanip>
#include <string>
using namespace std;


// User's Libraries.
#include "Pins.h"
#include "PlayerDetails.h"
#include "Ships.h"
#include "StringLink.h"
#include "Grids.h"
#include "StringQueue.h"

//
// Function Prototypes.
//
void MainMenu();
void StartNewGame();
void displayGrid();
void print2dArray(string [][11]);
void createPlayer();
bool initializePin(string);
void initGridPin(string, string);
bool inputValidation(int, int);
void printTextArtBoat(stack<string>);
int initializeNewPin(string, int &, int &);
void initEnemyFleet();
void initRowStringLinks();
void initColStringLinks();
int shipPinsInfo(stack<string>);
string doesPinExist(string);


// Global Constants.
StringLink *strFrontLink = nullptr;


// Start of Main Method.
int main()
{
    // Title.
    cout << "Welcome to Battleship!" << endl;

    // Create a random number generator.
    srand(static_cast<unsigned int>(time(0)));

    // Pre-cursor text calls.

    // Method Calls.
    MainMenu();

    // End Program.
    cout << "\nGame Over.";
    return 999;
}
// End of Main Method.

//
// Function Declarations.
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

// Start New Game Function Declaration.
void StartNewGame()
{
    createPlayer();
    initEnemyFleet();

    // Display some output.
    cout << "Player's Grid:\n"; displayGrid(); newline(2);
    cout << "Enemy's Grid:\n"; displayEnemyGrid(); newline(2);
}

// initEnemyPins
void initEnemyPins(set<string> ship, string enemyIcon)
{
    for (int row=0; row<11; row++)
    {
        for (int col=0; col<11; col++)
        {
            // check to see if egrid index matches an enemy coordinate.
            set<string>::iterator iter;
            for (iter = ship.begin(); iter != ship.end(); iter++)
            {
                if (*iter == sampleGrid[row][col])
                    egrid[row][col] = enemyIcon;
            }
        }
    }
}

void initEnemyFleet()
{
    // int r = rand()%20;
    int r = 0;

    // Select a random template for enemy ships to be set as.
    if (r == 0) {
        set<string> eCarrier = {"A10", "B10", "C10", "D10", "E10"};
        set<string> eBattleship = {"C3", "C4", "C5", "C6"};
        set<string> eCruiser = {"G1", "H1", "I1"};
        set<string> eSubmarine = {"J5", "I5", "H5"};
        set<string> eDestroyer = {"A1", "A2"};

        // Initialize Enemy Pins.
        initEnemyPins(eCarrier, "/\\");
        initEnemyPins(eBattleship, "/\\");
        initEnemyPins(eCruiser, "/\\");
        initEnemyPins(eSubmarine, "/\\");
        initEnemyPins(eDestroyer, "/\\");
    }
    else if (r == 1) {
        cout << "template" << r << endl;
    }
    else if (r == 2) {
        cout << "template" << r << endl;
    }
    else if (r == 3) {
        cout << "template" << r << endl;
    }
    else if (r == 4) {
        cout << "template" << r << endl;
    }
    else if (r == 5) {
        cout << "template" << r << endl;
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








