#include <iostream>
#include <string>
#include <fstream>
#include <iomanip>
using namespace std;

int main()
{
    //                         Variable Declaration
    //--------------------------------------------------------------------------
    fstream file;           // file object
    int again;
    string fileData;
    
    
    // Open a file in output mode
    file.open("DemoFile.txt", ios::out);
    
    cout << "*******************************************************************\n";
    cout << "*                     ---------------------                       *\n";
    cout << "*                     CURRENT STOCK REPORTS                       *\n";
    cout << "*                     ---------------------                       *\n";
    cout << "*******************************************************************\n";
    cout << left << setw(30) << "* Item Name";
    cout << left << setw(13) << "Price";
    cout << left << setw(15) << "Quantity";
    cout << left << setw(10) << "Profit  *";
    cout << "\n*******************************************************************\n";
    file.close();
    
    // Print out all data from the file 
    file.open("DemoFile.txt", ios::in);
    if (file)
    {
        // read the contents
        while (file >> fileData);
        {
            cout << fileData;
        }
        cout << endl;
        file.close();
    }
    else 
    {
        cout << "ERROR: Cannot Open File.\n";
    }

    // End Program
    cout << "\nProgram Successfully Ended.";
    return 0;
}
