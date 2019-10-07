/* 
 * File:   StockStruct.cpp
 * Author: Shazeb
 * Created on October 1, 2019, 2:13 AM
 * 
 *                                    Q&A's
 * -----------------------------------------------------------------------------
 * Q: So am I trying to use .txt files or .dat files to store information about
 * inventory items?
 * A: Which ever, go based off efficiency. When I get deeper into the development
 * of this Program I might end up having to use both. 
 * 
 * Q: In what sequence of steps do I have to take to get to the completion of
 * Phase 1 of this Program? What is Phase 1?
 * A: Phase 1 is when the Program effectively pulls up an updated Stock Report.
 * Then based off that, I can go in and change records of inventory. I should
 * directly add in the sales reports w/ the stock results in order to make this
 * Program that much effective.
 * 
 * Q: What is Phase 2?
 * A: Phase 2 is when I add in an ebay fees, auction pricing, and template 
 * description box sections.
 * 
 * Q: Phase 3? 
 * A: Phase 3 is when I just make minor tweaks and format debugs and use this 
 * Program to generate a Second Stream of Income
 * 
 * Q: Possibility of a Phase 4?
 * A: Perhaps, I will have to go based off the needs of the business. 
 -----------------------------------------------------------------------------
 */

#include <cstdlib>
#include <iostream>
#include <string>
#include <iomanip>
#include <fstream>
using namespace std;

//*******************
// Global Constants *
//*******************
const double ebayFee;
const double paypalFee;
const double ShipFee;
const double TAX = 7.75;

//*************************
// Structures Declaration *
//*************************
struct InventoryItem
{
    string name;
    double price;
    int qty;
};

//**********************
// Function Prototypes *
//**********************
void displayChartResults();


int main(int argc, char** argv) 
{
    // Variable Declaration
    int numItems;      // number of stock items
    int recNum;        // record number 
    fstream datFile;   // file object 
    
    // Get number of items to set up arrays
    cout << "How many items will be included in the Stock Report: ";
    cin >> numItems;
    
    // Array Declaration
    InventoryItem item[numItems];
    
    // Open a file to be written to. 
    datFile.open("TestInventory.dat", ios::out|ios::binary);
    
    //                  Get record information for all items
    //--------------------------------------------------------------------------
    for (int i=0; i<numItems; i++)
    {
        cout << "\nEnter the following for Item #" << i+1 << endl;
        cout << "Name: ";
        cin.ignore();
        getline(cin, item[i].name);
        cout << "Price: $ ";
        cin >> item[i].price;
        cout << "Quantity: ";
        cin >> item[i].qty;
        datFile.write(reinterpret_cast<char *>(&item), sizeof(item));
    }
    // close the file
    datFile.close();
    
    //                          Read back the records
    //--------------------------------------------------------------------------
    // open the file in read mode
    datFile.open("TestInventory.dat", ios::in|ios::binary);
    
    datFile.read(reinterpret_cast<char *>(&item), sizeof(item));
    
    cout << "\n-----------------------------------";
    cout << "\nReading Back From the File:\n";
    cout << "-----------------------------------\n";
    for (int i = 0; i < numItems; i++)
    {
        cout << "(RECORD " << i << ")\n";
        cout << "Name: " << item[i].name << endl;
        cout << "Price: $ " << item[i].price << endl;
        cout << "Quantity: " << item[i].qty << endl;
        cout << "-----------------------------------\n";
        datFile.read(reinterpret_cast<char *>(&item), sizeof(item));
    }
    // close the file
    datFile.close();
    
    //                          Option to Edit these Records
    //--------------------------------------------------------------------------
    // Open file for input and output
    datFile.open("TestInventory.dat", ios::in|ios::out|ios::binary);
 
    // Get the record number of the desired record
    cout << "\nWhich record do you want to edit?: ";
    cin >> recNum;
 
    // Move to the record number of the desired record
    datFile.seekg(recNum * sizeof(record), ios::beg);
    datFile.read(reinterpret_cast<char *>(&item), sizeof(item));
 
    // Display the record contents
    cout << "Name: " << item.name << endl;
    cout << "Price: $ " << item.price << endl;
    cout << "Quantity: " << item.qty << endl;
 
    // Get the new record data
    cout << "Enter the new data:\n";
    cout << "Name: ";
    cin.ignore();
    getline(cin, item.name);
    cout << "Price: $ ";
    cin >> item.price;
    cout << "Quantity: ";
    cin >> item.qty;
 
    // Move back to the beginning of this record's position
    datFile.seekp(recNum * sizeof(item), ios::beg);
 
    // write the new record over the current record
    datFile.write(reinterpret_cast<char *>(&item), sizeof(item));
 
    // Close the file again
    datFile.close();
    
    //                          Format records into a Chart 
    //--------------------------------------------------------------------------
 
    
    //                           
    //--------------------------------------------------------------------------


    // End Program
    return 0;
}
//                                Function Prototypes
//------------------------------------------------------------------------------
// Function Display Chart Results
void displayChartResults()
{
   cout << "Function call displayChartResults() has been successfully accessed.\n";
}

