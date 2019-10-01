#include <iostream>
#include <string>
#include <fstream>
using namespace std;

// structure for items
struct InventoryItem
{
    // Basic Measurements
    string name;
    double price;
    string color;
    int qty;
    
    // Z&V Bag Measurements 
    double width;
    double height;
    double depth;
    double strap;
};

// Function Prototypes
void menu();
void StockReports();
void SalesReports();

// int main
int main()
{
    // variable declaration
    int selection;          // menu decision
    
    
    cout << "Welcome to Shazeb's Inventory Stock Program!\n";
    menu();
    cout << "Enter a Selection: ";
    cin >> selection;
    
    if (selection == 1)
    {
        StockReports();
    }
    else if (selection == 2)
    {
        SalesReports();
    }
    else if (selection == 0)
    {
        cout << "You have chosen to End the Program." << endl;
    }
    
    // end program
    cout << "\nProgram has successfully ended.";
    return 0;
}

// FUNCTION DECLARATIONS
//----------------------
// Menu Function
void menu()
{
    cout << "       MENU        " << endl;
    cout << "-------------------" << endl;
    cout << "(1) Stock Reports" << endl;
    cout << "(2) Sales Reports" << endl;
    cout << "(0) End Program" << endl; 
}

// Stock Reports Function
void StockReports()
{
    cout << "\nWelcome to the Stock Reports";
    cout << "\n-----------------------------\n";
    
    // variable declaration
    InventoryItem item;     // structure object
    fstream file;
    char ch;
    
    // Open a file named (StockReports.txt) --> later on i will implement .dat files
    file.open("StockReports.txt", ios::out);
    
    // Write a template item entry into the file
    cout << "We are going to create a new Stock Report." << endl;
    cout << "Enter the following information about 1 item in inventory:\n";
    cout << "Enter the name of an item: ";
    cin.ignore();
    getline(cin, item.name);
    file << item.name << endl;
    cout << "Enter Price: $ ";
    cin >> item.price;
    file << item.price << endl;
    cout << "Enter Item Color: ";
    cin.ignore();
    getline(cin, item.color);
    file << item.color << endl;
    cout << "Enter Item Quantity: ";
    cin >> item.qty;
    file << item.qty << endl;
    
    cout << "Is this a Zadig & Voltaire Handbag?(y/n): ";
    cin >> ch;
    if (ch == 'Y' || ch == 'y')
    {
        cout << "Enter the following about the bag in inches:\n";
        cout << "Width: ";
        cin >> item.width;
        file << item.width << endl;
        cout << "Height: ";
        cin >> item.height;
        file << item.height << endl;
        cout << "Depth: ";
        cin >> item.depth;
        file << item.depth << endl;
        cout << "Strap Drop: ";
        cin >> item.strap;
        file << item.strap << endl;
    }    
    
    // read back the contents of the file
    string text;
    file.close();
    file.open("SalesReports.txt", ios::in);
    
    file.read(reinterpret_cast<char *>(&item), sizeof(item));
    
    
    
}

// Sales Reports Function
void SalesReports()
{
    cout << endl << "Welcome to the Sales Reports";
    cout << "\n-----------------------------\n";
}
