/*
 * This program is used to hold all fstream example programs for quick 
 * reference and code translations. 
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
    cout << "     -This program writes three rows of numbers to a file.\n";
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