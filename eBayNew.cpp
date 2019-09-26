/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   eBayNew.cpp
 * Author: shaze
 *
 * Created on September 26, 2019, 3:54 PM
 */

#include <cstdlib>
#include <iostream>
#include <fstream>
#include <iomanip>
#include <cmath>
using namespace std;

// CONSTANT VARIABLES

// FUNCTION PROTOTYPES
void StockReport();


int main(int argc, char** argv) {
    
    // VARIABLES DECLARATION
    int reportChoice;
    
    cout << "STOCK REPORT (1)" << endl;
    cout << "SALES REPORT (2)" << endl;
    cout << "Enter: ";
    cin >> reportChoice;
    
    if (reportChoice == 1)
        StockReport(); // first function call
    
    
    // CALCULATIONS
    
    
    // TEST OUTPUT
    
    
    //
    
    
    // END PROGRAM
    return 0;
}

// STOCK REPORT FUNCTION
void StockReport()
{
    // open file 
    fstream stockFile;
    stockFile.open("StockReport.txt", ios::in | ios :: out);
    
    if (stockFile)
    {
        cout << "File opened successfully!\n";
    }
    else 
        cout << "File failed to open!\n";
}