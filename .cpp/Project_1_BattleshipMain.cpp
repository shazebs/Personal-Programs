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


// Structures.
// SHIP STRUCTURES.
struct CarrierShip
{   int carrier = 5; }; // occupies 5 spots
struct BattleShip
{   int battleship = 4; };  // occupies 4 spots
struct CruiserShip
{   int cruiser = 3; }; // occupies 3 spots
struct SubmarineShip
{   int submarine = 3; };   // occupies 3 spots
struct DestroyerShip
{   int destroyer = 2; };   // occupies 2 spots


//
// Function Prototypes.
//
void newline(int n) {for(int i=0;i<n;i++)cout<<endl;}
void MainMenu();
void StartNewGame();
void displayGrid();
void print2dArray(string [][11]);
void createPlayer();


struct StringLink
{
    string data;
    StringLink *forward;
    StringLink *backward;

    // Default Constructor.
    StringLink()
    {
        forward = nullptr;
        backward = nullptr;
    }
    // Constructor 2.
    StringLink(string value)
    {
        data = value;
        forward = nullptr;
        backward = nullptr;
    }
    // Destructor
    ~StringLink()
    {
        delete &data;
        delete forward;
        delete backward;
    }
};


// Function Prototypes.


// Global Constants.
StringLink *strFrontLink = nullptr;


// Start of Main Method.
int main()
{
    // Title.
    cout << "Welcome to Battleship!" << endl;

    // Local Variables.


    // Work With Input
    // MainMenu();
    // displayGrid();
    createPlayer();

    // Display Output


    // End Program.
    cout << "\n\nGame Over.";
    return 0;
}

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


void StartNewGame()
{
    // Function Variables.

    displayGrid();
}


// Display Grid Function Declaration.
void displayGrid()
{
    string grid[11][11] =
            {

            {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
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
    // Print Grid.
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


        // Display Directions.
        cout << "\nIt is now time to initialize your "
             << ships.top() << "..." << endl << endl;
        ships.pop();

        // Display Grid.
        displayGrid(); newline(1);

        // Initialize Battleship.
        for (int i = 0; i < 5; i++)
        {
            string pin;
            cout << "\nEnter Position " << i+1 << ": ";
            cin >> pin;
            newline(1);
            
            // Display Grid. 
            displayGrid(); 
        }
        
        cout << "\nThe coordinates have been initialized!\n\n";
    }
}
