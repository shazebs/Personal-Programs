//
// Created by shazebs on 4/13/2021.
//

#ifndef PROJECT_1_PLAYERDETAILS_H
#define PROJECT_1_PLAYERDETAILS_H

#include "Grids.h"
#include "Pins.h"
#include "Ships.h"

// Create Player Function Declaration.
void createPlayer()
{
    string name;
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
                    cout << "~Does Pin exist: " << doesPinExist(pin1) << endl;

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
                            cout << "~Does Pin exist: " << doesPinExist(pin2) << endl;
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
                                        cout << "The pins are in the same row.\n";
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
                                        cout << "The pins are in the same column.\n";
                                        // if col2 is larger.
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
                                            // if col is larger.
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
                    cout << "~Does Pin exist: " << doesPinExist(pin1) << endl;

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
                            cout << "~Does Pin exist: " << doesPinExist(pin2) << endl;
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
                                        cout << "The pins are in the same row.\n";
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
                                        cout << "The pins are in the same column.\n";
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
                                            // if row is larger than row2
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
                    cout << "~Does Pin exist: " << doesPinExist(pin1) << endl;

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
                            cout << "~Does Pin exist: " << doesPinExist(pin2) << endl;
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
                                        cout << "The pins are in the same row.\n";
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
                                        // Else if Same Column.
                                    else if (col == col2)
                                    {
                                        cout << "The pins are in the same column.\n";
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
                                                    initPinCoordinates(row-1,col, shipSymbol);
                                                    initPinCoordinates(row2, col2, shipSymbol);

                                                    // Print text art boat.
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
                            cout << "~Does Pin exist: " << doesPinExist(pin2) << endl;
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
                                        cout << "The pins are in the same row.\n";
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
                                        cout << "The pins are in the same column.\n";
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
        displayGrid(); newline(1);
    }
}


#endif //PROJECT_1_PLAYERDETAILS_H


