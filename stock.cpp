/* 
 * File:   StockStruct.cpp
 * Author: Shazeb
 *
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
 */

#include <cstdlib>
#include <iostream>
#include <string>
#include <iomanip>
#include <fstream>
using namespace std;

// Global Constants 

// Struct - InventoryItem
struct InventoryItem
{
    string name;
    double price;
    int qty;
    
    
};
int main(int argc, char** argv) 
{
    // Variable Declaration
    int numItems;
    fstream datFile;
    
    // Get number of items to set up arrays
    cout << "How many items will be included in the Stock Report: ";
    cin >> numItems;
    
    // Array Declaration
    InventoryItem item[numItems];
    
    // Get record information for all items
    for (int i=0; i<numItems; i++)
    {
        cout << "Enter the following for Item #" << i+1 << endl;
        cout << "Name: ";
        cin.ignore();
        getline(cin, item[i].name);
        cout << "Price: $ ";
        cin >> item[i].price;
        cout << "Quantity: ";
        cin >> item[i].qty;
        cout << endl;
    }
    
    // Open a file to be written to. 
    datFile.open("TestInventory.dat", ios::out|ios::binary);
    
    // Write the records.
    for (int i = 0; i < numItems; i++)
    {
        cout << "Now writing record " << i << endl;
        datFile.write(reinterpret_cast<char *>(&item), sizeof(item));
    }
    
    // End Program
    return 0;
}

