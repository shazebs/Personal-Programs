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
string doesPinExist(string);
void switchTurns();


// Global Constants.
StringLink *strFrontLink = nullptr;


// Start of Main Method.
int main()
{
    // Title.
    cout << "Welcome to Battleship!" << endl;

    // Create a random number generator.
    srand(static_cast<unsigned int>(time(0)));

    /*
    string str;
    // Pre-cursor text calls.
    do {
        initEnemyFleet();
        displayEnemyGrid();
        cout << "Try again? (y/n): ";
        getline(cin, str);
        if (str == "y" || str == "Y")
            clearEnemyGrid();
    } while (str == "y" || str == "Y");*/

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
    // createPlayer();

    cout << "Searching for opponent...done.\n";
    initEnemyFleet(); newline(1);
    displayGrid();
    switchTurns();

}

// Where i left off on.
void switchTurns()
{
    QueueLink *player1 = new QueueLink("Shazbot");
    QueueLink *player2 = new QueueLink(enemyName);

    player1->addToBack(player2);

    cout << "It is " << getQueueData(player1) << "'s turn.\n";
    player1->removeFromFront();
    player2->addToBack(player1);
    cout << "It is now " << getQueueData(player2) << "'s turn.\n";
}










