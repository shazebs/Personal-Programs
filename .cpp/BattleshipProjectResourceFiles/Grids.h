//
// Created by shazebs on 4/16/2021.
//

#ifndef PROJECT_1_GRIDS_H
#define PROJECT_1_GRIDS_H

#include "Ships.h"
#include <iostream>
using namespace std;

// Public Resources.
// 2D Array Grid
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
// The Grid Map.
/*
static map<string, *string[][]> realMap =
        {
                {"A1", sampleGrid[1][1]}, {"A2", sampleGrid[1][2]}, {"A3", sampleGrid[1][3]}, {"A4", sampleGrid[1][4]}, {"A5", sampleGrid[1][5]}, {"A6", sampleGrid[1][6]}, {"A7", sampleGrid[1][7]}, {"A8", sampleGrid[1][8]}, {"A9", sampleGrid[1][9]}, {"A10", sampleGrid[1][10]},
                {"B1", sampleGrid[1][1]}, {"B2", sampleGrid[1][2]}, {"B3", sampleGrid[1][3]}, {"B4", sampleGrid[1][4]}, {"B5", sampleGrid[1][5]}, {"B6", sampleGrid[1][6]}, {"B7", sampleGrid[1][7]}, {"B8", sampleGrid[1][8]}, {"B9", sampleGrid[1][9]}, {"B10", sampleGrid[1][10]},
                {"C1", sampleGrid[1][1]}, {"C2", sampleGrid[1][2]}, {"C3", sampleGrid[1][3]}, {"C4", sampleGrid[1][4]}, {"C5", sampleGrid[1][5]}, {"C6", sampleGrid[1][6]}, {"C7", sampleGrid[1][7]}, {"C8", sampleGrid[1][8]}, {"C9", sampleGrid[1][9]}, {"C10", sampleGrid[1][10]},
                {"D1", sampleGrid[1][1]}, {"D2", sampleGrid[1][2]}, {"D3", sampleGrid[1][3]}, {"D4", sampleGrid[1][4]}, {"D5", sampleGrid[1][5]}, {"D6", sampleGrid[1][6]}, {"D7", sampleGrid[1][7]}, {"D8", sampleGrid[1][8]}, {"D9", sampleGrid[1][9]}, {"D10", sampleGrid[1][10]},
                {"E1", sampleGrid[1][1]}, {"E2", sampleGrid[1][2]}, {"E3", sampleGrid[1][3]}, {"E4", sampleGrid[1][4]}, {"E5", sampleGrid[1][5]}, {"E6", sampleGrid[1][6]}, {"E7", sampleGrid[1][7]}, {"E8", sampleGrid[1][8]}, {"E9", sampleGrid[1][9]}, {"E10", sampleGrid[1][10]},
                {"F1", sampleGrid[1][1]}, {"F2", sampleGrid[1][2]}, {"F3", sampleGrid[1][3]}, {"F4", sampleGrid[1][4]}, {"F5", sampleGrid[1][5]}, {"F6", sampleGrid[1][6]}, {"F7", sampleGrid[1][7]}, {"F8", sampleGrid[1][8]}, {"F9", sampleGrid[1][9]}, {"F10", sampleGrid[1][10]},
                {"G1", sampleGrid[1][1]}, {"G2", sampleGrid[1][2]}, {"G3", sampleGrid[1][3]}, {"G4", sampleGrid[1][4]}, {"G5", sampleGrid[1][5]}, {"G6", sampleGrid[1][6]}, {"G7", sampleGrid[1][7]}, {"G8", sampleGrid[1][8]}, {"G9", sampleGrid[1][9]}, {"G10", sampleGrid[1][10]},
                {"H1", sampleGrid[1][1]}, {"H2", sampleGrid[1][2]}, {"H3", sampleGrid[1][3}, {"H4", sampleGrid[1][4]}, {"H5", sampleGrid[1][5]}, {"H6", sampleGrid[1][6]}, {"H7", sampleGrid[1][7]}, {"H8", sampleGrid[1][8]}, {"H9", sampleGrid[1][9]}, {"H10", sampleGrid[1][10]},
                {"I1", sampleGrid[1][1]}, {"I2", sampleGrid[1][2]}, {"I3", sampleGrid[1][3]}, {"I4", sampleGrid[1][4]}, {"I5", sampleGrid[1][5]}, {"I6", sampleGrid[1][6]}, {"I7", sampleGrid[1][7]}, {"I8", sampleGrid[1][8]}, {"I9", sampleGrid[1][9]}, {"I10", sampleGrid[1][10]},
                {"J1", sampleGrid[1][1]}, {"J2", sampleGrid[1][2]}, {"J3", sampleGrid[1][1]}, {"J4", sampleGrid[1][4]}, {"J5", sampleGrid[1][5]}, {"J6", sampleGrid[1][6]}, {"J7", sampleGrid[1][7]}, {"J8", sampleGrid[1][8]}, {"J9", sampleGrid[1][9]}, {"J10", sampleGrid[1][10]}
        }; */
// create an iterator.
map<string, string>::iterator iterate;

// Global Constants
static string shipSymbol = "<>";
static string enemySymbol = "/\\";
static string hitSymbol = "X";
static string missSymbol = "O";


// Grid Operations Functions List.

// clearGrid
void clearEnemyGrid()
{
    for (int i=1; i<11; i++) {
        for (int j=1; j<11; j++) {
            if (egrid[i][j] != "-")
                egrid[i][j] = "-";
        }
    }
}

// clearGrid
void clearPlayerGrid()
{
    for (int i=1; i<11; i++) {
        for (int j=1; j<11; j++) {
            if (grid[i][j] != "-")
                grid[i][j] = "-";
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

// newline function.
void newline(int n) { for(int i=0;i<n;i++) cout<<endl; }

// Display Grid Function Declaration.
void displayGrid() { print2dArray(grid); }
void displayEnemyGrid() { print2dArray(egrid); }
void displayEHitGrid() { print2dArray(ehitgrid); }

#endif //PROJECT_1_GRIDS_H
