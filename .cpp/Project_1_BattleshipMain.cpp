// Author: Shazeb Suhail 
// Date:   4/13/21
// Time:   3:00 PM 

#include <iostream>
#include <list>
#include <stack>
#include <queue>
#include <deque>
#include <map>
#include <set>
#include <ctime>
#include <iomanip>
#include <string>
using namespace std;


// User's Libraries.
#include "PlayerDetails.h"
#include "Ships.h"
#include "StringLink.h"

//
// Function Prototypes.
//
void newline(int n) {for(int i=0;i<n;i++)cout<<endl;}
void MainMenu();
void StartNewGame();
void displayGrid();
void print2dArray(string [][11]);
void createPlayer();

// Global Constants.
StringLink *strFrontLink = nullptr;


// Start of Main Method.
int main()
{
    // Title.
    cout << "Welcome to Battleship!" << endl;


    // MainMenu();
    // displayGrid();
    createPlayer();


    // End Program.
    cout << "\n\nGame Over.";
    return 0;
}


//
// Function Declarations
// 


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
            cout << "Starting New Game.\n\n";
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


// Start New Game Function. 
void StartNewGame()
{
    // Function Variables.

    displayGrid();
}



// Display the Grid Function. 
void displayGrid()
{
    string grid[11][11] =
            {
                    {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                    {"A", "X", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                    {"B", "-", "X", "-", "-", "-", "-", "-", "-", "-", "-"},
                    {"C", "-", "-", "X", "-", "-", "-", "-", "O", "-", "-"},
                    {"D", "-", "-", "-", "X", "-", "-", "-", "O", "-", "-"},
                    {"E", "-", "-", "-", "-", "X", "-", "-", "O", "-", "-"},
                    {"F", "-", "-", "-", "-", "-", "-", "-", "O", "-", "-"},
                    {"G", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                    {"H", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                    {"I", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                    {"J", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}
            };
    // Print the Grid.
    print2dArray(grid);
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




// Create Player Function Declaration.
void createPlayer()
{
    string name;
    int input;

    cout << "Enter Name for Player 1: ";
    getline(cin, name);
    cout << "Player 1 = " << name << ".\n";
    cout << "If '" << name << "' is correct, enter 1: ";
    cin >> input;

    if (input != 1)
    {
        cout << "You entered something else besides 1. Create Player cancelled.\n";
    }
    else
    {
        // ** UTILIZATION OF STACKS **
        stack<string> ships;
        ships.push("'Destroyer'");
        ships.push("'Submarine'");
        ships.push("'Cruiser'");
        ships.push("'Battleship'");
        ships.push("'Carrier'");


        // Initialize ships popped off shipsStack.
        cout << "\nIt is now time to initialize your "
             << ships.top() << " " << name << ".\n\n";
        ships.pop();

        // Display Grid.
        displayGrid(); newline(1);

        // Initialize Battleship.
        for (int i = 0; i < 5; i++)
        {
            string pin;
            cout << "(" << 5-i << " spots remaining) : "; 
            cout << "\nEnter Position " << i+1 << ": ";
            cin.ignore();
            getline(cin,pin);
            newline(1);
            
            if (i == 0)
            {
                cout << "(" << 5-i << " spot remaining) : Current Coordinates = None initialized.\n";
                cout << "Enter Position " << i+1 << ": "; 
                cin.ignore(); 
                getline(cin,pin);
                newline(1); 
            }
            else 
            {
                cout << "(" << 5-i << " spots remaining) : Current Coordinates = "
                     << 
            }
            

            // Display Grid.
            displayGrid();
        }

        cout << "\nThe coordinates have been initialized!\n\n";
    }
}

