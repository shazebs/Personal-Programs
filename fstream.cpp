/*
 * This program is used to hold all fstream example programs for quick 
 * reference and code templates/examples. 
 */

/* 
 * File:   fstream.cpp
 * Author: Shazeb Suhail (Sapherons)
 * Created on September 27, 2019, 12:16 AM
 */

#include <cstdlib>
#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>
#include <cctype>   // needed for toupper function member
using namespace std;

// FUNCTION PROTOTYPES
void menu();
void program1();
void program2();
void program3();
void program4();
void program5();
void program6();
void program7();
void program8();
void program9();
void program10();
void program11();
void program12();
void program13();
void program14();
void program15();
// supplemental functions for program 15
bool openFileIn(fstream &, string);
void showContents(fstream &);
void program16();
// supplemental function for program 16
void showState(fstream &);
void program17();
void program18();
void program19();
void program20();
void program21();
void program22();
void program23();
void program24();
void program25();
// supplemental structure for program 25
const int NAME_SIZE = 51, ADDR_SIZE = 51, PHONE_SIZE = 14;
struct Info
{
    char name[NAME_SIZE];
    int age;
    char address1[ADDR_SIZE];
    char address2[ADDR_SIZE];
    char phone[PHONE_SIZE];
};
void program26();
void program27();
void program28();
// supplemental functions for program 28
long byteNum(int);
void showRec(Info);
void program29();
void program30();
// supplemental code for program 30
const int DESC_SIZE = 31;   // description size
const int NUM_RECORDS = 5;  // number of records
struct InventoryItem
{
    char desc[DESC_SIZE];
    int qty;
    double price;
};
void program31();
void program32();


//------------------------------------------------------------------------------
//                            Main Functions Begins
//------------------------------------------------------------------------------
int main(int argc, char** argv) {
    
    // VARIABLE DECLRATION
    int decision;
    
    // FUNCTION CALL 
    menu();
    cout << "\nEnter a selection: ";
    cin >> decision;
    
    if (decision == 1)
        program1();
    else if (decision == 2)
        program2();
    else if (decision == 3)
        program3();
    else if (decision == 4)
        program4();
    else if (decision == 5)
        program5();
    else if (decision == 6)
        program6();
    else if (decision == 7)
        program7();
    else if (decision == 8)
        program8();
    else if (decision == 9)
        program9();
    else if (decision == 10)
        program10();
    else if (decision == 11)
        program11();
    else if (decision == 12)
        program12();
    else if (decision == 13)
        program13();
    else if (decision == 14)
        program14();
    else if (decision == 15)
        program15();
    else if (decision == 16)
        program16();
    else if (decision == 17)
        program17();
    else if (decision == 18)
        program18();
    else if (decision == 19)
        program19();
    else if (decision == 20)
        program20();
    else if (decision == 21)
        program21();
    else if (decision == 22)
        program22();
    else if (decision == 23)
        program23();
    else if (decision == 24)
        program24();
    else if (decision == 25)
        program25();
    else if (decision == 26)
        program26();
    else if (decision == 27)
        program27();
    else if (decision == 28)
        program28();
    else if (decision == 29)
        program29();
    else if (decision == 30)
        program30();
    else if (decision == 31)
        program31();
    else if (decision == 32)
        program32();
    
    // END PROGRAM
    cout << "\nProgram Ended Successfully";
    return 0;
}
// MENU FUNCTION
void menu()
{
    cout << "                      BASIC FILE OPERATIONS:\n";
    cout << "------------------------------------------------------------------\n";
    cout << "(1) Program 5-15\n";
    cout << "    -This program writes data to a file.\n";
    cout << "(2) Program 5-16\n";
    cout << "    -This program writes data to a single line in a file.\n";
    cout << "(3) Program 5-17\n";
    cout << "    -This Program writes numbers to a file.\n";
    cout << "(4) Program 5-18\n";
    cout << "    -This Program writes friend names to a file.\n";
    cout << "(5) Program 5-19\n";
    cout << "    -This Program reads data from Friends.txt.\n";
    cout << "(6) Program 5-20\n";
    cout << "    -This Program reads numbers from a file and calculates sum.\n";
    cout << "(7) Program 5-21\n";
    cout << "    -This Program stores day sales to a file.\n";
    cout << "(8) Program 5-22\n";
    cout << "    -This Program reads data till the file ends.\n";
    cout << "(9) Program 5-23\n";
    cout << "    -This Program tests for file open errors.\n";
    cout << "(10) Program 5-24\n";
    cout << "    -This Program lets the user enter a filename.\n\n";
    cout << "                    ADVANCED FILE OPERATIONS:\n";
    cout << "------------------------------------------------------------------\n";
    cout << "(11) Program 12-1\n";
    cout << "     -This Program uses an fstream object to write data to a file.\n";
    cout << "(12) Program 12-2\n";
    cout << "     -This Program writes data to a file, closes the file, then appends more data.\n";
    cout << "(13) Program 12-3\n";
    cout << "     - This Program uses setprecision to format file output\n";
    cout << "(14) Program 12-4\n";
    cout << "     -This Program writes three rows of numbers to a file.\n";
    cout << "(15) Program 12-5\n";
    cout << "     -This Program passes file stream objects by reference to functions.\n";
    cout << "(16) Program 12-6\n";
    cout << "     -This Program demonstrates return value of the stream object error testing member functions.\n";
    cout << "(17) Program 12-7\n";
    cout << "     -This Program demonstrates how the >> operator should not be used to read data that contain whitespace characters from a file.\n";
    cout << "(18) Program 12-8\n";
    cout << "     -This Program uses the getline function to read a line of data from the file.\n";
    cout << "(19) Program 12-9\n";
    cout << "     -This Program demonstrates the getline function with a specified delimeter($).\n";
    cout << "(20) Program 12-10\n";
    cout << "     -This Program asks the user for a file name. File is opened and its contents are displayed on the screen.\n";
    cout << "(21) Program 12-11\n";
    cout << "     -This Program demonstrates the put member function.\n";
    cout << "(22) Program 12-12\n";
    cout << "     -This Program demonstrates reading from one file and writing to a second file.\n";
    cout << "(23) Program 12-13\n";
    cout << "     -This Program uses the write and read functions with characters.\n";
    cout << "(24) Program 12-14\n";
    cout << "     -This Program used the write and read functions with numbers.\n";
    cout << "(25) Program 12-15\n";
    cout << "     -This Program uses a structure variable to STORE a record to a file.\n";
    cout << "(26) Program 12-16\n";
    cout << "     -This Program uses a structure variable to READ a record from a file.\n";
    cout << "(27) Program 12-17\n";
    cout << "     -This Program demonstrates the 'seekg' function.\n";
    cout << "(28) Program 12-18\n";
    cout << "     -This Program demonstrates the 'seekg' function.\n";
    cout << "(29) Program 12-19\n";
    cout << "     -This Program demonstrates the 'tellg' function.\n";
    cout << "(30) Program 12-20\n";
    cout << "     -This Program sets up a file of blank inventory records.\n";
    cout << "(31) Program 12-21\n";
    cout << "     -This Program displays the contents of the inventory item.\n";
    cout << "(32) Program 12-21\n";
    cout << "     -This Program allows the user to edit a specific record.\n";
}

// PROGRAM EXAMPLE 1
void program1()
{
    //
    // This program writes data to a file
    //
    ofstream outputFile;
    outputFile.open("demofile1.txt");
    
    cout << "\nProgram Example 1:\n";
    cout << "Now writing data to the file.\n";
    
    // Write four names to the file
    outputFile << "Bach\n";
    outputFile << "Beethoven\n";
    outputFile << "Mozart\n";
    outputFile << "Schubert\n";
    
    // Close the file
    outputFile.close();
    cout << "Done.\n";
}

// PROGRAM EXAMPLE 2
void program2()
{
    //
    // This program writes data to a single line in a file
    //
    
    // Variable Declaration
    ofstream outputFile;
    outputFile.open("demofile2.txt");
    
    cout << "\nProgram Example 2:\n";
    cout << "Now writing data to the file.\n";
    
    // Write four names to the file
    outputFile << "Bach";
    outputFile << "Beethoven";
    outputFile << "Mozart";
    outputFile << "Schubert";
    
    // close the file
    outputFile.close();
    cout << "Done.\n";
    
}

// PROGRAM EXAMPLE 3
void program3()
{
    // This Program writes user input to a file
    
    // variable declaration
    ofstream outputFile;
    int num1,num2,num3;
    
    // Open an output file
    outputFile.open("Numbers.txt");
    
    // Get three numbers from the user
    cout << "\nProgram Example 3:\n";
    cout << "Enter a number: ";
    cin >> num1;
    cout << "Enter another number: ";
    cin >> num2;
    cout << "Enter one more number: ";
    cin >> num3;
    
    // Write the numbers to the file
    outputFile << num1 << endl;
    outputFile << num2 << endl;
    outputFile << num3 << endl;
    cout << "The numbers were saved to a file.\n";
    
    // close the file
    outputFile.close();
    cout << "Done.\n";
    
}

// PROGRAM EXAMPLE 4
void program4()
{
    // This program writes user input to a file
    
    // variable declration
    ofstream outputFile;
    string name1,name2,name3;
    
    // open output file
    outputFile.open("Friends.txt");
    
    // get the names of three friends
    cout << "\nProgram Example 4:\n";
    cout << "Enter the names of three friends.\n";
    cout << "Friend #1: ";
    cin >> name1;
    cout << "Friend #2: ";
    cin >> name2;
    cout << "Friend #3: ";
    cin >> name3;
    
    // write the names to the file
    outputFile << name1 << endl;
    outputFile << name2 << endl;
    outputFile << name3 << endl;
    
    // close the file
    outputFile.close();
    
}

// PROGRAM EXAMPLE 5
void program5()
{
    // This program reads data from a file
    
    // variable declaration
    ifstream inputFile;
    string name;
    
    inputFile.open("Friends.txt");
    cout << "\nProgram Example 5:\n";
    cout << "Reading data from the file.\n";
    
    inputFile >> name;      // read name 1 from the file
    cout << name << endl;   // display name 1
    
    inputFile >> name;      // read name 2 from the file
    cout << name << endl;   // display name 2
    
    inputFile >> name;      // read name 3 from the file
    cout << name << endl;   // display name 3
    
    // close the file
    inputFile.close();
}

// PROGRAM EXAMPLE 6
void program6()
{
    // This program reads numbers from a file
    // variable declaration
    ifstream inFile;
    int value1, value2, value3, sum;
    
    // open the file
    inFile.open("NumericData.txt");
    
    // Read the three numbers from the file
    inFile >> value1;
    inFile >> value2;
    inFile >> value3;
    
    // close the file
    inFile.close();
    
    // Calculate the sum of the numbers
    sum = value1 + value2 + value3;
    
    // Display the three numbers
    cout << "\nProgram Example 6:\n";
    cout << "Here are the numbers:\n";
    cout << value1 << " " << value2 << " " << value3 << endl;
    
    // display the sum of the numbers
    cout << "Their sum is: " << sum << endl;
      
}

// PROGRAM EXAMPLE 7
void program7()
{
    // This program reads data from file
    
    // variable declaration
    ofstream outputFile;
    int numDays;
    double sales;
    char val;
    
    // get the number of days
    cout << "\nProgram Example 7:\n";
    cout << "For how how many days do you have sales: ";
    cin >> numDays;
    
    // open a file named Sales.txt
    outputFile.open("Sales.txt");
    
    // get the sales for each day and write to file
    for (int i=0; i<numDays; i++)
    {
        // get the sales of the day
        cout << "Enter the sales for day " << i+1 << ": ";
        cin >> sales;
        
        // write the sale to the file
        outputFile << sales << endl;
    }
    
    // close the file
    outputFile.close();
    cout << "Data written to Sales.txt\n";
    cout << "\nWant to display file's contents?(y/n): ";
    cin >> val;
    
    if (val == 'y')
    {
        // create array for file contents
        double salesData[numDays];
        ifstream inputFile;
        
        // open the file again
        inputFile.open("Sales.txt");
        
        for (int i=0; i<numDays; i++)
        {
            // read in numbers one at a time
            inputFile >> salesData[i];
        }
        
        // display file contents
        cout << "File Contents:\n";
        for (int i=0; i<numDays; i++)
        {
            cout << salesData[i] << " ";
        }
        cout << "\nEnd of File.\n";
    }
    else if (val == 'n')
            cout << "You have chosen not to view file's contents.\n";
}

// PROGRAM EXAMPLE 8
void program8()
{
    // variable declration
    ifstream inputFile;
    int number;
    
    // open the file
    inputFile.open("ListOfNumbers.txt");
    
    // read the numbers from the file and display them
    cout << "\nProgram Example 8:\n";
    while (inputFile >> number)
    {
        cout << number << endl;
    }
    
    // close the file
    inputFile.close();
}

// PROGRAM EXAMPLE 9
void program9()
{
    // this program checks for file opening errors
    // variable declration
    ifstream inputFile;
    int number;
    
    // open the file
    inputFile.open("BadListOfNumbers.txt");
    
    cout << "\nProgram Example 9:\n";
    // if the file successfully opened, process it
    if (inputFile)
    {
        // read the numbers from the file and display them
        cout << "File opened successfully.\n";
        while (inputFile >> number)
        {
            cout << number << endl;
        }
        
        // close the file
        inputFile.close();
    }
    else 
    {
        // display an error message
        cout << "Error opening the file.\n";
    }
}

// PROGRAM EXAMPLE 10   
void program10()
{
    // variable declaration
    ifstream inputFile;
    string filename;    // use filename: ListOfNumbers.txt
    int number;
    
    // get the filename from the user
    cout << "\nProgram Example 10:\n";
    cout << "Existing files: (ListOfNumbers.txt)\n";
    cout << "Enter the filename: ";
    cin >> filename;
    
    // open the file
    inputFile.open(filename);
    
    // if the file successfully opens, process it.
    if (inputFile)
    {
        // read and display file contents
        while (inputFile >> number)
        {
            cout << number << endl;
        }
        
        // close the file
        inputFile.close();
    }
    else 
    {
        // display an error message
        cout << "Error opening the file.\n";
    }
}

// PROGRAM EXAMPLE 11
void program11()
{
    // variable declaration
    fstream dataFile;
    
    cout << "\nProgram Example 11:\n";
    cout << "Opening file...\n";
    dataFile.open("demofile_12.1.txt", ios::out);   // open for output
    
    cout << "Now writing data to the file.\n";
    dataFile << "Jones\n";
    dataFile << "Smith\n";
    dataFile << "Willis\n";
    dataFile << "Davis\n";
    
    dataFile.close();
    cout << "Done.\n";
    
    // Read names from the file
    string name1,name2,name3,name4;
    
    ifstream inputFile;
    inputFile.open("demofile_12.1.txt", ios::in);
    
    cout << "\nFile Contents:\n";
    inputFile >> name1;
    cout << name1 << endl;
    inputFile >> name2;
    cout << name2 << endl;
    inputFile >> name3;
    cout << name3 << endl;
    inputFile >> name4;
    cout << name4 << endl;
    
}

// PROGRAM EXAMPLE 12
void program12()
{
    // variable declaration
    ofstream dataFile;
    
    cout << "\nProgram Example 12:\n";
    cout << "Opening file...\n";
    
    // open the file in output mode
    dataFile.open("demofile_12.2.txt", ios::out);
    
    cout << "Now writing data to the file.\n";
    dataFile << "Jones\n";
    dataFile << "Smith\n";
    cout << "Now closing the file.\n";
    dataFile.close();
    
    // open the file again in append mode
    cout << "Opening the file again...\n";
    dataFile.open("demofile_12.2.txt", ios::out|ios::app);
    
    cout << "Writing more data to the file.\n";
    dataFile << "Willis\n";
    dataFile << "Davis\n";
    cout << "Now closing the file again.\n";
    dataFile.close();
    cout << "Done.\n";
    
    // display file contents
    cout << "\nDisplaying File Contents:\n";
    string name1,name2,name3,name4;
    
    ifstream inputFile;
    inputFile.open("demofile_12.2.txt", ios::in);
    
    inputFile >> name1;
    cout << name1 << endl;
    inputFile >> name2;
    cout << name2 << endl;
    inputFile >> name3;
    cout << name3 << endl;
    inputFile >> name4;
    cout << name4 << endl;
    
}

// PROGRAM EXAMPLE 13
void program13()
{
    // variable declaration
    fstream dataFile;
    double num = 17.816392;
    
    dataFile.open("demofile_12.3.txt", ios::out);
    
    dataFile << fixed;
    dataFile << num << endl;
    
    dataFile << setprecision(4);
    dataFile << num << endl;
    
    dataFile << setprecision(3);
    dataFile << num << endl;
    
    dataFile << setprecision(2);
    dataFile << num << endl;
    
    dataFile << setprecision(1);
    dataFile << num << endl;
    
    // close the file
    dataFile.close();
    
    cout << "\nProgram Example 13:\n";
    cout << "Writing data to a file.\n";
    cout << "Done.\n";
    cout << "File Contents:\n";
    
    // display the file's contents
    dataFile.open("demofile_12.3.txt", ios::in);
    
    float num1,num2,num3,num4,num5;
    
    // cout file contents
    dataFile >> num1;
    cout << num1 << endl;
    dataFile >> num2;
    cout << num2 << endl;
    dataFile >> num3;
    cout << num3 << endl;
    dataFile >> num4;
    cout << num4 << endl;
    dataFile >> num5;
    cout << num5 << endl;
    
    // close datafile again
    dataFile.close();
}

// PROGRAM EXAMPLE 14
void program14()
{
    const int ROWS = 3;
    const int COLS = 3;
    int nums[ROWS][COLS] = { 2897, 5, 837,
                            34, 7, 1623,
                            390, 3456, 12 };
    fstream outFile("table.txt", ios::out);
    
    // write the three rows of numbers with each number in a field of 8 character spaces
    for (int row = 0; row < ROWS; row++)
    {
        for (int col = 0; col < COLS; col++)
        {
            outFile << setw(8) << nums[row][col];
        }
        outFile << endl;
    }
    outFile.close();
    cout << "\nProgram Example 14:\n";
    cout << "Writing rows and columns to a file.\n";
    cout << "Done\n";
    
    // display file contents
    cout << "File Contents:\n";
     
    // new variable declaration
    fstream inFile;
    int number;
    
    // open file in read mode 
    inFile.open("table.txt", ios::in);
    
    while (inFile)
    {
        inFile >> number;
        cout << number << endl;
    }
    
    // close the file again
    inFile.close();
}

// PROGRAM EXAMPLE 15
void program15()
{
    // variable declaration
    fstream dataFile;

    cout << "\nProgram Example 15:\n";
    if (openFileIn(dataFile, "demofile.txt"))
    {
        cout << "File opened successfully.\n";
        cout << "Now reading data from the file.\n\n";
        showContents(dataFile);
        dataFile.close();
        cout << "\nDone.\n";
    }
    else 
        cout << "File open error!" << endl;
}
// PROGRAM EXAMPLE 15 SUPPLEMENTAL FUNCTIONS
bool openFileIn(fstream &file, string name)
{
    file.open(name, ios::in);
    if (file.fail())
        return false;
    else 
        return true;
}
void showContents(fstream &file)
{
    string line;
    
    while (file >> line)
    {
        cout << line << endl;
    }
}

// PROGRAM EXAMPLE 16
void program16()
{
    // variable declaration
    int num = 10;
    
    // open the file for output
    fstream testFile("stuff.dat", ios::out);
    
    cout << "\nProgram Example 16:\n";
    if (testFile.fail())
    {
        cout << "ERROR: Cannot open the file.\n";
    }
    
    // Write a value to the file
    cout << "Writing the value " << num << " to the file.\n";
    testFile << num;
    
    // show the bit states
    showState(testFile);
    
    // close the file 
    testFile.close();
    
    // reopen the file for input
    testFile.open("stuff.dat", ios::in);
    if (testFile.fail())
    {
        cout << "ERROR: Cannot open the file.\n";
    }
    
    // Read the only value from the file
    cout << "Reading from the file.\n";
    testFile >> num;
    cout << "The value " << num << " was read.\n";
    
    // show the bit states
    showState(testFile);
    
    // no more data in the file, but for an invalid read operation
    cout << "Forcing a bad read operation.\n";
    testFile >> num;
    
    // show the bit states 
    showState(testFile);
    
    // close the file 
    testFile.close();
}
// PROGRAM EXAMPLE 16 SUPPLEMENTAL FUNCTIONS
void showState(fstream &file)
{
    cout << "File Status:\n";
    cout << " eof bit: " << file.eof() << endl;
    cout << " fail bit: " << file.fail() << endl;
    cout << " bad bit: " << file.bad() << endl;
    cout << " good bit: " << file.good() << endl;
    file.clear();   // clear any bad bits
}
    
// PROGRAM EXAMPLE 17
void program17()
{
    // variable declaration
    string input;       // To hold file input
    fstream nameFile;   // File stream object
    
    // open the file in input mode
    nameFile.open("murphy.txt", ios::in);
    
    cout << "\nProgram Example 17:\n";
    // if the file successfully opens, continue.
    if (nameFile)
    {
        // read the contents
        while (nameFile >> input)
        {
            cout << input;
        }
        cout << endl;
        // close the file
        nameFile.close();
    }
    else 
    {
        cout << "ERROR: Cannot open file.\n";
    }
}

// PROGRAM EXAMPLE 18 
void program18()
{
    // variable declaration
    string input;       // to hold file input
    fstream nameFile;   // File stream object
    
    // open the file in input mode
    nameFile.open("murphy.txt", ios::in);
    
    // if the file was successfully opened, continue.
    cout << "\nProgram Example 18:\n";
    if (nameFile)
    {
        // read a line from the file
        getline(nameFile,input);
        
        // while last read operation is a success, continue. 
        while (nameFile)
        {
            // display the last item read
            cout << input << endl;
            
            // read the next item
            getline(nameFile,input);
        }
        // close the file
        nameFile.close();
    }
    else
    {
        cout << "ERROR: Cannot open file.\n";
    }
}

// PROGRAM EXAMPLE 19
void program19()
{
    // variable declaration
    string input;   // to hold file input
    
    // open the file for input
    fstream dataFile("names2.txt", ios::in);
    
    // if the file was successfully opened, continue.
    if (dataFile)
    {
        // read an item using '$' as a delimeter.
        getline(dataFile, input, '$');
        
        // while last operation was a success, continue
        while (dataFile)
        {
            // display last item read
            cout << input << endl;
            
            // read another item
            getline(dataFile, input, '$');
        }
        
        // close the file
        dataFile.close();
    }
    else 
    {
        cout << "ERROR: Cannot open file.\n";
    }
}

// PROGRAM EXAMPLE 20
void program20()
{
    // variable declaration
    string fileName;    // to hold the file name
    char ch;            // to hold a character
    fstream file;       // file stream object
    
    // get the file name
    cout << "\nProgram Example 20:\n";
    cout << "Enter a file name: ";
    //cin >> fileName   // This only reads up till whitespace
    cin.ignore();
    getline(cin,fileName);  // This processes whitespaces too
    
    
    // open the file
    file.open(fileName, ios::in);
    
    // open the file
    file.open(fileName, ios::in);
    
    // if the file was successfully opened, continue.
    if (file)
    {
        // get a character from the file
        file.get(ch);
        
        // while last read operation is successful, continue.
        while (file)
        {
            // display last character read
            cout << ch;
            
            // read the next character
            file.get(ch);
        }
        // close the file
        file.close();
    }
    else 
    {
        cout << fileName << " could not be opened.\n";
    }
}

// PROGRAM EXAMPLE 21
void program21()
{
    // variable declaration
    char ch;    // to hold a character
    
    // open the file for output
    fstream dataFile("sentence.txt", ios::out);
    
    cout << "\nProgram Example 21:\n";
    cout << "Type a sentence and be sure to end it with a period.\n";
    
    // get a sentence from the user one character at a time and write
    // each character to the file.
    cin.get(ch);
    while (ch != '.')
    {
        dataFile.put(ch);
        cin.get(ch);
    }
    
    dataFile.put(ch);   // write the period
    
    // close the file
    cout << "(Sentence has been written to a file.)\n";
    dataFile.close();
}

// PROGRAM EXAMPLE 22
void program22()
{
    // variable declaration
    string fileName;    // to hold the file name
    char ch;            // to hold a character
    ifstream inFile;    // input file
    
    // open a file for output
    ofstream outFile("out.txt");
    
    // get the input file name
    cout << "Enter a file name: ";
    cin.ignore();
    getline(cin,fileName);
    
    // open the file for input
    inFile.open(fileName);
    
    // if the input file opened successfully, continue.
    if (inFile)
    {
        // read a char from file 1
        inFile.get(ch);
        
        // while last read operation is a success, continue.
        while (inFile)
        {
            // write Upper char to file 2
            outFile.put(toupper(ch));
            
            // read another char from file 1
            inFile.get(ch);
        }
        
        // close the two files
        inFile.close();
        outFile.close();
        cout << "File conversion done.\n";
    }
    else
        cout << "Cannot open " << fileName << endl;
}

// PROGRAM EXAMPLE 23
void program23()
{
    // Perhaps can be used for array file storages
    // variable declaration
    const int size = 4;
    char data[size] = {'A', 'B', 'C', 'D'};
    fstream file;
    
    // open the file for output in binary mode
    file.open("test.dat", ios::out|ios::binary);
    
    // write the contents of the array to the file
    cout << "\nProgram Example 23:\n";
    cout << "Writing the characters to the file.\n";
    file.write(data, sizeof(data));
    
    // close the file
    file.close();
    
    // open the file for input in binary mode
    file.open("test.dat", ios::in|ios::binary);
    
    // read the contents of the file into the array
    cout << "Now reading the data back into memory.\n";
    file.read(data,sizeof(data));
    
    // display the contents of the array
    for (int i = 0; i < size; i++)
    {
        cout << data[i] << " ";
    }
    cout << endl;
    
    // close the file
    file.close();
}

// PROGRAM EXAMPLE 24
void program24()
{
    // variable declarations
    const int size = 10;
    fstream file;
    int numbers[size] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    
    // open the file for output in binary mode
    file.open("numbers.dat", ios::out|ios::binary);
    
    // write the contents of the array to the file
    cout << "\nProgram Example 24:\n";
    cout << "Writing the data to the file.\n";
    file.write(reinterpret_cast<char *>(numbers), sizeof(numbers));
    
    // close the file
    file.close();
    
    // open the file for input in binary mode
    file.open("numbers.dat", ios::in|ios::binary);
    
    // read the contents of the file back into a new array
    int displayNumbers[size];
    
    cout << "Now reading back the data back in memory.\n";
    file.read(reinterpret_cast<char *>(displayNumbers), sizeof(displayNumbers));
    
    // display the contents of the array
    for (int i = 0; i < size; i++)
    {
        cout << displayNumbers[i] << " ";
    }
    cout << endl;
    
    // close the file again
    file.close();
}

// PROGRAM EXAMPLE 25
void program25()
{
    // variable declaration
    Info person;    // to hold info aobut a person
    char again;     // to hold Y or N
    
    // open a file for binary output
    fstream people("people.dat", ios::out|ios::binary);
    
    cout << "\nProgram Example 25:\n";
    cout << "Enter the following data about a person:\n";
    cin.ignore();
    do 
    {
        // get data about a person
        cout << "Name: ";
        cin.getline(person.name, NAME_SIZE);
        cout << "Age: ";
        cin >> person.age;
        cin.ignore();       // skip over remaining newline
        cout << "Address line 1: ";
        cin.getline(person.address1, ADDR_SIZE);
        cout << "Address line 2: ";
        cin.getline(person.address2, ADDR_SIZE);
        cout << "Phone: ";
        cin.getline(person.phone, PHONE_SIZE);
        
        // write the contents of the person structure to the file
        people.write(reinterpret_cast<char *>(&person), sizeof(person));
        
        // determine whether the user wants to write another record
        cout << "Do you want to enter another record?(y/n): ";
        cin >> again;
        cin.ignore();
    } while (again == 'Y' || again == 'y');
    
    // close the file
    people.close();
}

// PROGRAM EXAMPLE 26
void program26()
{
    // variable declaration
    Info person;
    // char ch;
    fstream people;     // file stream object
    
    // open the file for input in binary mode
    people.open("people.dat", ios::in|ios::binary);
    
    // test for errors
    cout << "\nProgram Example 26:\n";
    if (!people)
    {
        cout << "Error opening file. Program aborting.\n";
    }
    
    cout << "Here are the people in the file:\n";
    cout << "--------------------------------\n";
    // read the first record from the file
    people.read(reinterpret_cast<char *>(&person), sizeof(person));
    
    // while not at the end of the file, display the records
    while (!people.eof())
    {
        // display the record
        cout << "Name: " << person.name << endl;
        cout << "Age: " << person.age << endl;
        cout << "Address Line 1: " << person.address1 << endl;
        cout << "Address Line 2: " << person.address2 << endl;
        cout << "Phone: " << person.phone << endl;
        cout << "--------------------------------\n";
        /*
        // wait for user to press the enter key
        cout << "\nPress the Enter key to see the next record.\n";
        cin.get(ch);
        */
        
        // read the next record from the file
        people.read(reinterpret_cast<char *>(&person), sizeof(person));
    }
    
    cout << "(That's all the data in the file!)\n";
    people.close();
}

// PROGRAM EXAMPLE (27) 12-17
void program27()
{
    cout << "\nProgram Example 27:\n";
    
    // variable declaration
    char ch;    // to hold a character
    
    // open the file for input
    fstream file ("letters.txt", ios::in);
    
    // move to the byte 5 from the beginning of the file
    // (the 6th byte) and read the character there.
    file.seekg(5L, ios::beg);
    file.get(ch);
    cout << "Byte 5 from beginning: " << ch << endl;
    
    // move to the 10th byte from the end of the file and read the character there.
    file.seekg(-10L,ios::end);
    file.get(ch);
    cout << "10th byte from end: " << ch << endl;
    
    // move to byte 3 from the current position 
    // (the 4th byte) and read the character there
    file.seekg(3L, ios::cur);
    file.get(ch);
    cout << "Byte 3 from current: " << ch << endl;
    
    file.close();    
}

// PROGRAM EXAMPLE 28
void program28()
{    
    // variable declaration
    Info person;    // to hold info about a person
    fstream people; // File stream object
    
    // open the file for input in binary mode
    people.open("people.dat", ios::in|ios::binary);
    
    cout << "\nProgram Example 28:\n";
    // test for errors
    if (!people)
    {
        cout << "Error opening file. Program aborting.\n";
    }
    
    // read and display record 1 (the second record)
    cout << "\nHere is record 1:\n";
    people.seekg(byteNum(1), ios::beg);
    people.read(reinterpret_cast<char *>(&person), sizeof(person));
    showRec(person);
    
    // read and display record 0 (the first record)
    cout << "\nHere is record 0:\n";
    people.seekg(byteNum(0), ios::beg);
    people.read(reinterpret_cast<char *>(&person), sizeof(person));
    showRec(person);
    
    // close the file
    people.close();
}
// SUPPLEMENTAL FUNCTIONS FOR PROGRAM 28

//********************************************************************************************
// Definition of function byteNum. Accepts an integer as its argument.                       *
// Returns the byte number in the file of the record whose number is passed as the argument. *
//********************************************************************************************
long byteNum(int recNum)
{
    return sizeof(Info) * recNum;
}

//********************************************************************************************
// Definition of function showRec. Accepts an Info structure as its argument, and displays   *
// the structure's contents.                                                                 *
//********************************************************************************************
void showRec(Info record)
{
    cout << "Name: " << record.name << endl;
    cout << "Age: " << record.age << endl;
    cout << "Address Line 1: " << record.address1 << endl;
    cout << "Address Line 2: " << record.address2 << endl;
    cout << "Phone: " << record.phone << endl;
}

// PROGRAM EXAMPLE 29
void program29()
{
    cout << "\nProgram Example 29:\n";
    
    // variable declaration
    long offset;
    long numBytes;
    char ch;
    char again;
    
    // open the file for input
    fstream file("letters.txt", ios::in);
    
    // determine the number of bytes in the file
    file.seekg(0L, ios::end);
    numBytes = file.tellg();
    cout << "The file has " << numBytes << " bytes.\n";
    
    // go back to the beginning of the file
    file.seekg(0L, ios::beg);
    
    // let the user move around within the file
    do 
    {
        // display the current read position
        cout << "Currently at position " << file.tellg() << endl;
        
        // get a byte number from the user
        cout << "Enter an offset from the beginning of the file: ";
        cin >> offset;
        
        // move the read position to that byte, read the character there, and display it
        if (offset >= numBytes)     // past the end of the file?
            cout << "Cannot read past the end of the file.\n";
        else 
        {
            file.seekg(offset, ios::beg);
            file.get(ch);
            cout << "Character read: " << ch << endl;
        }
        
        // Does the user want to try this again?
        cout << "Do it again?(y/n): ";
        cin >> again;
    } while (again == 'Y' || again == 'y');
    
    // close the file 
    file.close();
}

// PROGRAM EXAMPLE (30) 12-20
void program30()
{
    cout << "\nProgram Example 30:\n";
    
    // variable declaration
    InventoryItem record = { "", 0, 0.0 };
    
    // open the file for binary output
    fstream inventory("Inventory.dat", ios::out|ios::binary);
    
    // write the blank records
    for (int i = 0; i < NUM_RECORDS; i++)
    {
        cout << "Now writing record " << i << endl;
        inventory.write(reinterpret_cast<char *>(&record), sizeof(record));
    }
    // close the file
    inventory.close();
}

// PROGRAM EXAMPLE (31) 12-21
void program31()
{
    cout << "\nProgram Example 31:\n";
    
    // variable declaration
    InventoryItem record;
    
    // open the file for binary input
    fstream inventory("Inventory.dat", ios::in|ios::binary);
    
    // now read and display the records
    inventory.read(reinterpret_cast<char *>(&record), sizeof(record));
    
    while ( !inventory.eof())
    {
        cout << "Description: " << record.desc << endl;
        cout << "Quantity: " << record.qty << endl;
        cout << "Price: $" << record.price << endl << endl;
        inventory.read(reinterpret_cast<char *>(&record), sizeof(record));
    }
    // close the file
    inventory.close();                   
}

// PROGRAM EXAMPLE (32) 12-22
void program32()
{
    cout << "\nProgram Example 32:\n";
    
    // variable declaration
    InventoryItem record;   // to hold an inventory record
    long recNum;            // to hold a record number
    
    // open the file in binary mode for input and output
    fstream inventory("Inventory.dat", ios::in|ios::out|ios::binary);
    
    // get the record number of the desired record
    cout << "Which record do you want to edit?: ";
    cin >> recNum;
    
    // move to the record number of the desired record
    inventory.seekg(recNum * sizeof(record), ios::beg);
    inventory.read(reinterpret_cast<char *>(&record), sizeof(record));
    
    // display the record contents
    cout << "Description: " << record.desc << endl;
    cout << "Quantity: " << record.qty << endl;
    cout << "Price: $" << record.price << endl;
    
    // get the new record data
    cout << "Enter the new data:\n";
    cout << "Description: ";
    cin.ignore();
    cin.getline(record.desc, DESC_SIZE);
    cout << "Quantity: ";
    cin >> record.qty;
    cout << "Price: $";
    cin >> record.price;
    
    // move back to the beginning of this record's position
    inventory.seekp(recNum * sizeof(record), ios::beg);
    
    // write the new record over the current record 
    inventory.write(reinterpret_cast<char *>(&record), sizeof(record));
    
    // close the file
    inventory.close();  
}

