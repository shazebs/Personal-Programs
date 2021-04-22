/*
 * File:   main.cpp
 * Author: shazebs
 *
 * Created on April 19, 2021, 2:15 PM
 */

#include <iostream>
#include <sstream>
using namespace std;

// Public Structures.
struct strLinkNode
{
    string data;
    int index;
    strLinkNode *nodePtr;

    // Constructor.
    strLinkNode(string d) {data = d; nodePtr = nullptr;}

    ~strLinkNode() {delete nodePtr;}
};


// Function Prototypes.
void printListIndexes();
void printListValues();
void fillList(int);
int findCurrentValues(int);
void fillEntireListWithNums(int);
string getIndexAt(int);
void setIndexAt(int,string);
void configMemory();
void setTail();
void doubleMemorySize();


// Global Constants
strLinkNode *head = nullptr;
strLinkNode *tail = nullptr;
int listSize = 50; // initially set to 50.
int values;


// Start of Main.
int main(int argc, char** argv)
{
    cout << endl;
    // GAMEPLAN (Steps 1-4).

    // 1) Fill a random linked list with a specific number of elements.
    // Create a user-sized list.
    cout << "Initial list size will be = " << listSize << endl;
    fillList(listSize); // fill list
    printListIndexes(); // print list
    printListValues();
    cout << "This list will be our starting memory size.\n";
    cout << "From here on out, we will adjust memory size statically as the list grows or shrinks in values.\n\n";
    cout << "Current Memory size = " << listSize << endl;
    cout << "Current Values = " << findCurrentValues(listSize) << endl << endl;
    cout << "(The list that has been created has been implemented as a Singularly linked list.)\n\n";


    // 2) Add to the list a value, then double the size of the list.
    cout << "The linked list has no values, we will randomly initialize all its elements...done.\n\n";
    fillEntireListWithNums(listSize);
    printListValues();
    cout << "Current Memory size = " << listSize << endl;
    cout << "Current Values = " << findCurrentValues(listSize) << endl << endl;
    cout << "Now the list is completely full of values and has reached its initial size.\n";
    cout << "So now, any time our list is full, we will double its size in memory.\n";
    setTail();
    configMemory(); cout << endl;
    printListIndexes();
    printListValues();
    cout << "Current Memory size = " << listSize << endl;
    cout << "Current Values = " << findCurrentValues(listSize) << endl << endl;


    // 3) Now null 1/4th of the list's elements.
    cout << "We will start by manually nulling 3/4ths of the list so that only 25% of the list is full so that we can half the overall memory, as indicated in the assignment details.\n";
    //
    setIndexAt(49, "_");
    setIndexAt(48, "_");
    setIndexAt(47, "_");
    setIndexAt(46, "_");
    setIndexAt(45, "_");
    setIndexAt(44, "_");
    setIndexAt(43, "_");
    setIndexAt(42, "_");
    setIndexAt(41, "_");
    setIndexAt(40, "_");
    setIndexAt(39, "_");
    setIndexAt(38, "_");
    setIndexAt(37, "_");
    setIndexAt(36, "_");
    setIndexAt(35, "_");
    setIndexAt(34, "_");
    setIndexAt(33, "_");
    setIndexAt(32, "_");
    setIndexAt(31, "_");
    setIndexAt(30, "_");
    setIndexAt(29, "_");
    setIndexAt(28, "_");
    setIndexAt(27, "_");
    setIndexAt(26, "_");
    setIndexAt(25, "_");
    //
    values = findCurrentValues(listSize);
    printListValues();
    cout << "Current Memory size = " << listSize << endl;
    cout << "Current Values = " << findCurrentValues(listSize) << endl << endl;


    // 4) Once element values have been nulled, half the size of the original list.
    cout << "Now since only 25% of the entire list's elements are initialized, we will half the overall list size by\n"
         << "running the same configMemory function we ran from earlier.\n\n";
    configMemory();
    printListValues();
    cout << "Current Memory size = " << listSize << endl;
    cout << "Current Values = " << findCurrentValues(listSize) << endl << endl;


    // End Program.
    cout << "\nEnd Program.";
    return 0;
}
// End of Main.


// Function Definitions.

// DoubleMemorySize
void doubleMemorySize()
{
    strLinkNode *iterator = tail;
    int count = 0;
    int doubledSize = (listSize * 2);

    if (!iterator)
        cout << "The list appears to be empty.\n";
    else
    {
        for (int i=listSize; i < doubledSize; i++)
        {
            strLinkNode *newLink = new strLinkNode("_");
            newLink->index = i;
            iterator->nodePtr = newLink;
            iterator = iterator->nodePtr;

            // Check for end of list.
            if (i == doubledSize-1)
            {
                tail = iterator;
                break;
            }
        }
        listSize = doubledSize;
    }
}

// SetTail
void setTail()
{
    strLinkNode *iterator = head;
    int count = 0;

    if(!head)
        cout << "The list is empty.\n";
    else
    {
        // Traverse the list.
        while(iterator)
        {
            count++;
            if(iterator->nodePtr == nullptr) {
                tail = iterator;
                break;
            }
            else
                iterator = iterator->nodePtr;
        }
        // cout << "List size = " << count << endl;
    }
}

// ConfigMemory
void configMemory()
{
    // Function Variables.
    strLinkNode *iterator = head; // to traverse.
    int count = 0;

    if(!head)
        cout << "The list is empty.\n";
    else if (head)
    {
        // Check to see if the list is full.
        if (values == listSize) {
            cout << "The list is full. Doubling Memory...\n";
            doubleMemorySize();
            cout << "...done.\n";
        }
        // Else see if values is less than listSize.
        else if (values < listSize)
        {
            double percent = static_cast<double>(values)/static_cast<double>(listSize);
            // Display number of values in the list.
            if (percent == 0.25)
            {
                // half the memory starting by deleting from the back.
                listSize = listSize/2; // set new list size.
                strLinkNode *iterator = head;

                // Traverse the list.
                while (iterator)
                {
                    count+=1; // increment number of elements.
                    if (iterator->index == listSize-1)
                    {
                        tail = iterator;
                        iterator = iterator->nodePtr;
                        tail->nodePtr = nullptr;
                        break;
                    }
                    else
                        iterator = iterator->nodePtr;
                }

                // delete everything after tail.
                /*
                while(iterator != nullptr)
                {
                    strLinkNode *temp = iterator;
                    iterator = iterator->nodePtr;
                    delete temp;
                    if (iterator == nullptr)
                        cout << "Memory has been halved.\n";
                } */
            }
            else
                cout << "Memory size does not meet requirements to be configured.\n";
        }
    }
    else
        cout << "Some error has occurred.\n";
}

// SetIndexAt
void setIndexAt(int i, string newData)
{
    strLinkNode *iterator = head;
    int count = 0;

    if (!iterator)
        cout << "The list is empty.\n";
    else
    {
        // Traverse the list.
        while(iterator)
        {
            // Scan the link index.
            if (iterator->index == i)
            {
                iterator->data = newData;
                break;
            }
            else
                iterator = iterator->nodePtr;
        }
    }
}

// GetIndexAt
string getIndexAt(int i)
{
    strLinkNode *iterator = head;
    int count = 0;

    if (!head)
        return "The list is empty.\n";
    else
    {
        // Traverse the list looking for the index.
        while (iterator != nullptr)
        {
            count+=1;
            // Scan the iterator's index.
            if (iterator->index == i)
                return iterator->data;
            else
                iterator = iterator->nodePtr;
        }
    }
    // Else
    return "~Error";
}

// Fill the List with random values.
void fillEntireListWithNums(int size)
{
    // Create a linked list iterator.
    strLinkNode *iterator = head;
    int count = 0;

    if (size > 0)
    {
        // loop and initialize the list.
        for (int i=1; i<=size; i++)
        {
            count++;
            stringstream ss;
            string s;
            ss << i; // make ss hold an int.
            ss >> s;  // now convert the int.
            iterator->data = s;
            // If end of list has been reached.
            if (iterator->nodePtr == nullptr)
            {
                ss << i+1;
                ss >> s;
                iterator->data = s;
                break;
            }
            else
                iterator = iterator->nodePtr;
        }
        values = count;
    }
    else
        cout << "Something went wrong!\n";
}

// Find the number of values in the list.
int findCurrentValues(int size)
{
    int values = 0;
    int elements = size;
    strLinkNode *iterator = head;

    if (iterator == nullptr) {
        cout << "The list is empty." << endl;
        return values;
    }
    else
    {
        // Loop through the list.
        while (iterator != nullptr)
        {
            // Scan iterator's data.
            if (iterator->data != "_")
            {
                values += 1; // increment # of values.
                iterator = iterator->nodePtr;
            }
            else
                iterator = iterator->nodePtr;
        }
        return values;
    }
}

// Print the list's values.
void printListValues()
{
    cout << "Printing List Values...\n";
    strLinkNode *temp = head;
    int count = 0;
    while (temp != nullptr)
    {
        count++;
        cout << temp->data;
        temp = temp->nodePtr;
        if (temp == nullptr)
            cout << ".\n";
        else
            cout << ", ";
    }
    cout << "Size of list = " << count << endl;
    listSize = count;
    cout << endl;
}

// Print the list's indexes.
void printListIndexes()
{
    cout << "Printing List Indexes...\n";
    strLinkNode *temp = head;
    int count = 0;
    while (temp != nullptr)
    {
        count++;
        cout << "[" << temp->index;
        temp = temp->nodePtr;
        if (temp == nullptr)
            cout << "].\n";
        else
            cout << "], ";
    }
    cout << "Size of list = " << count << endl;
    listSize = count;
    cout << endl;
}

// Fill the list to a user-specified length.
void fillList(int size)
{
    // Create the head of the linked list.
    strLinkNode *newHead = new strLinkNode("_"); // head of list
    newHead->index = 0;
    int count = 0;

    strLinkNode *newTemp = newHead; // to traverse the list.
    // loop and set links.
    for (int i=1; i < size; i++)
    {
        count += 1;
        strLinkNode *nextLink = new strLinkNode("_");
        nextLink->index = i;
        newTemp->nodePtr = nextLink;
        newTemp = nextLink;

        // Set tail.
        if (i+1 == size) tail = newTemp;
    }
    head = newHead; // set head.
}
