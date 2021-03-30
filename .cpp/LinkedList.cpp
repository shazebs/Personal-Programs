#include <iostream>
#include <cstdlib>
#include "LinkedList.h"
using namespace std;

int main()
{
    // Define a NumberList object
    LinkedList list;

    // Append some values to the list.
    list.appendNode(2.5);
    list.appendNode(7.9);
    list.appendNode(12.6);

    // Display the list.
    cout << "\nHere are the initial values:\n";
    list.displayList();
    cout << endl;

    // Delete the middle node.
    cout << "Now deleting the node in the middle.\n";
    list.deleteNode(7.9);

    // Display the list.
    cout << "Here are the nodes left.\n";
    list.displayList();
    cout << endl;

    // Delete the last node.
    cout << "Now deleting the last node.\n";
    list.deleteNode(12.6);

    // Display the list
    cout << "Here are the nodes left.\n";
    list.displayList();
    cout << endl;

    // Delete the only node left in the list.
    cout << "Now deleting the only remaining node.\n";
    list.deleteNode(2.5);

    // Display the list.
    cout << "Here are the nodes left.\n";
    list.displayList();

    // End Program
    cout << "\nEnd Program.";

    // ** All Methods have been implemented **
    /*
     LinkedList.append(Object x)
     LinkedList.insert(Object x)
     LinkedList.display()           // type: void
     LinkedList.delete(Object x)
     */

    return 0;
}
