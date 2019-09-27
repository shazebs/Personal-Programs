/* 
 * File:   eBayNew.cpp
 * Author: Shazeb
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
void StockReport(string);
void SalesReport(string);


int main(int argc, char** argv) {
    
    // VARIABLES DECLARATION
    int reportChoice;
    string fileContents;
    
    cout << "STOCK REPORT (1)" << endl;
    cout << "SALES REPORT (2)" << endl;
    cout << "Enter: ";
    cin >> reportChoice;
    
    if (reportChoice == 1)
        StockReport(fileContents); // first function call
    else if (reportChoice == 2)
        SalesReport(fileContents); // second function call
    
    // CALCULATIONS
    
    
    // TEST OUTPUT
    
    
    //
    
    
    // END PROGRAM
    return 0;
}

// STOCK REPORT FUNCTION
void StockReport(string variable)
{
    // variable declaration
    string stockReport = variable; 
    
    // open file 
    fstream stockFile;
    stockFile.open("StockReport.txt", ios::out | ios::in);
    
    if (stockFile)
    {
        cout << "File opened successfully!\n";
        cout << "File's Contents:\n\n";
        while (!stockFile.eof())
        {
            stockFile >> stockReport;
            cout << stockReport << endl;
        }
        cout << "(End of Report)" << endl;  
    }
    else 
    {
        cout << "File failed to open!\n";
    }
}

// SALES REPORT FUNCTION
void SalesReport(string variable)
{
    // variable declaration
    string salesReport = variable; 
    string date;
    
    // open file 
    fstream stockFile;
    stockFile.open("SalesReport.txt", ios::out|ios::in);
    
    if (stockFile)
    {
        cout << "File opened successfully!\n";
        cout << "Enter Date(MM/DD/YY): ";
        cin >> date;
        
        // print today's date to file before displaying file's contents
        //-------------------------------------------------------------
        stockFile << date;
        stockFile.close();
        stockFile.open("SalesReport.txt", ios::out|ios::in);
        
        //-------------------------------------------------------------
        
        // display file contents
        cout << "\nFile's Contents:\n";
        while (!stockFile.eof())
        {
            stockFile >> salesReport;
            cout << salesReport << endl;
        }
        cout << "(End of Report)" << endl;
    }
    else 
    {
        cout << "File failed to open!\n";
    }
}
