#include <iostream>
#include <string>
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
void StockReports(struct);
void SalesReports(struct);

// int main
int main()
{
    // variable declaration
    InventoryItem item;     // structure object
    int selection;          // menu decision
    
    
    cout << "Welcome to Shazeb's Inventory Stock Program!\n";
    menu();
    cout << "Enter a Selection: ";
    cin >> selection;
    
    if (selection == 1)
    {
        StockReports(item);
    }
    else if (selection == 2)
    {
        SalesReports(item);
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
void StockReports(struct record)
{
    cout << "\nWelcome to the Stock Reports";
    cout << "\n-----------------------------\n";
    
    // variable declaration
    fstream file;
    char ch;
    
    // Open a file named (StockReports.txt) --> later on i will implement .dat files
    file.open("StockReports.txt", ios::out);
    
    // Write a template item entry into the file
    cout << "We are going to create a new Stock Report." << endl;
    cout << "Enter the following information about 1 item in inventory:\n";
    cout << "Enter the name of an item: ";
    cin.ignore();
    getline(cin, record.name);
    cout << "Enter Price: $ ";
    cin >> record.price;
    cout << "Enter Item Color: ";
    cin.ignore();
    getline(cin, record.color);
    cout << "Enter Item Quantity: ";
    cin >> record.qty;
    
    cout << "\nIs this a Zadig & Voltaire Handbag?(y/n): ";
    cin >> ch;
    if (ch == 'Y' || ch == 'y')
    {
        cout << "Enter the following about the bag:\n";
        cout << "Width: ";
        cin >> record.width;
        cout << "Height: ";
        cin >> record.height;
        cout << "Depth: ";
        cin >> record.depth;
        cout << "Strap Drop: ";
        cin >> record.strap;
    }
    
    
}

// Sales Reports Function
void SalesReports(struct record)
{
    cout << endl << "Welcome to the Sales Reports";
    cout << "\n-----------------------------\n";
}
