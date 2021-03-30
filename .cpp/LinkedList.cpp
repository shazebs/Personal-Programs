#include <iostream>
#include <cstdlib>
#include "NumberList.h"
using namespace std;

int main()
{
    // Define a NumberList object
    NumberList list;

    // Append some values to the list.
    list.appendNode(2.5);
    list.appendNode(7.9);
    list.appendNode(12.6);

    // Display the values in the list.
    cout << endl;
    cout << "Linked List Contents:\n";
    list.displayList();

    // Insert a node in the middle of the list.
    // .insertNode(double num) execution
    list.insertNode(10.5);

    // .displayList() execution
    cout << endl;
    cout << "Linked List Contents (version 2):\n";
    list.displayList();

    // .deleteNode(double num) execution
    list.deleteNode(7.9);
    list.deleteNode(5.5);

    // .displayList() execution
    cout << endl;
    cout << "Linked List Contents (version 3):\n";
    list.displayList();

    // ** All Methods have been implemented **
    /*
     LinkedList.append(Object x)
     LinkedList.insert(Object x)
     LinkedList.display()           // type: void
     LinkedList.delete(Object x)


     */

    // End Program
    return 0;
}
