//
// Created by shazebs on 4/23/2021.
//

#ifndef PROJECT_1_PINS_H
#define PROJECT_1_PINS_H

#include "Grids.h"
#include "PlayerDetails.h"
#include "Ships.h"
#include "StringLink.h"
using namespace std;

// Global Constants.
// set<string> pCarrier, pBattleship, pCruiser, pSubmarine, pDestroyer; // player's ships.
set<string> eCarrier, eBattleship, eCruiser, eSubmarine, eDestroyer; // enemy's ships.
set<string>::iterator setPtr; // iterator.

set<int> colIndexes = {0,1,2,3,4,5,6,7,8,9,10};
set<int> rowIndexes = {0,1,2,3,4,5,6,7,8,9,10};
set<int>::iterator intSetPtr;


array<string, 5> pCarrier;
array<string, 4> pBattleship;
array<string, 3> pCruiser;
array<string, 3> pSubmarine;
array<string, 2> pDestroyer;


// dummy value for pop up computations.
string pinName;


///////////////////////////////////////////////////////////////////////////////////////////////
// Pins Operations Functions //////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////

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

// initialize enemy fleet using templates.
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

// Input Validation Function. Declaration.
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

// displayExistingPins
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

#endif //PROJECT_1_PINS_H
