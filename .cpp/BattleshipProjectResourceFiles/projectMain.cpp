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
void startTurnsQueue();
string tryForHit(string);
void getPinCoordinates(string,int &, int &);


// Global Constants.
StringLink *strFrontLink = nullptr;
Queue *front;
Queue *back;


// Start of Main Method.
int main()
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
string tryForHit(string pin)
{
    // Function Variables.
    int x,y;
    bool hit = false;
    string temp = "";

    // Find pin's grid coordinates. (at this point we already know pin exists).
    // Look through egrid for pin.
    getPinCoordinates(pin,x,y);

    // Display Coordinates.
    // cout << "[ " << x << " , " << y << " ]" << endl;

    // Hit Block.
    if (egrid[x][y] == enemySymbol)
    {
        if (ehitgrid[x][y] == hitSymbol)
        {
            cout << "This location was already hit!\n";
            return "error";
        }
        else {
            ehitgrid[x][y] = hitSymbol;
            return "true";
        }
    }
        // Miss Block.
    else if (egrid[x][y] != enemySymbol)
    {
        ehitgrid[x][y] = missSymbol;
        return "false";
    }
    return "false";
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


            if (doesPinExist(pin) == "true") // if pin's existence equals true.
            {
                string hit = tryForHit(pin);

                if (hit == "true")
                {
                    cout << front->data << " landed a HIT! Switch Turns.\n";
                    switchTurns();
                    userScore++;
                    if (userScore == 17)
                        break;
                }
                else if (hit == "error") {
                    cout << front->data << " must try again.\n";
                }
                else if (hit == "false")
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



            // Enemy's Turn to Fire Missiles.
        else if (front->data == enemyName) {

            // Display code block's instruction.A4

            cout << front->data << " will now take aim.\n";

            // Fire at a random player grid coordinate.
            int x, y;
            x = (rand()%10)+1;
            y = (rand()%10)+1;

            // ** Test Output **
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
                /*
                cout << front->data
                     << " already fired a missile at this pin. "
                     << "Opponent will try again.\n"; */
                continue;

            }
            else if (grid[x][y] == "-") {

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


// Start New Game Function Declaration.
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

// Where i left off on.
void startTurnsQueue()
{
    Queue *link1 = new Queue(name);
    Queue *link2 = new Queue(enemyName);

    link2->nodePtr = link1;
    front = link1;
    back = link2;
}



/*
 *
 */
