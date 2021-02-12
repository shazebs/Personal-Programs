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
void EbayProfitCalc();
void ZadigEtVoltaire();


int main(int argc, char** argv) {
    
    // VARIABLES DECLARATION
    int reportChoice;
    string fileContents;
    
    cout << "(1) STOCK REPORT" << endl;
    cout << "(2) SALES REPORT" << endl;
    cout << "(3) EBAY PROFIT CALCULATOR" << endl;
    cout << "(4) ZADIG-ET-VOLTAIRE CALCULATOR" << endl;
    cout << "Enter: ";
    cin >> reportChoice;
    
    if (reportChoice == 1)
        StockReport(fileContents); // first function call
    else if (reportChoice == 2)
        SalesReport(fileContents); // second function call
    
    // BACK FROM STATISTICAL REPORT FUNCTIONS
    if (reportChoice == 3)
        EbayProfitCalc();
    else if (reportChoice == 4)
        ZadigEtVoltaire();
    
    
    // TEST OUTPUT
    cout << "\n\nThank You 4 Using This Toy Program!\n\n\nAuthor:  Shazeb Suhail\nContact:  909-747-4865\nBeaumont, California";
    
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
        cout << "\nFile's Contents:\n";
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

// EBAY PROFIT CALCULATOR FUNCTION
void EbayProfitCalc()
{
    // variable declaration
    const float ebayFee = 0.1125;
    const int shipFee = 15;
    double price;
    
    cout << "Enter the price of an item: $";
    cin >> price;
    
}

// ZADIG-ET-VOLTAIRE CALCULATOR
void ZadigEtVoltaire()
{
    // variable declaration
    
    // beginning prompts
    
    cout << "\n--------------------------------------\n";
    cout << "Zadig-et-Voltaire Ebay Selling Section\n";
    cout << "--------------------------------------\n";
}
