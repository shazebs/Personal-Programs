
/* 
 * File:   main.cpp
 * Author: shazebs
 *
 * Created on April 3, 2021, 12:09 AM
 */

#include <cstdlib>
#include <iostream>
using namespace std;

// User's Libraries
#include "Link.h"

//
// Structure
//

template <class T>
struct LinkNode
{        
    T value;
    LinkNode<T> *nodePtr; 
    
    
    // Constructor
    LinkNode() {}
    
    LinkNode(int data) 
    {
        value = data;
        nodePtr = nullptr;
    }
};

//
// Function Prototypes
//

Link *fillList(int); // pass back the ptr
void printList(Link *); 
void destroyList(Link *); 
//
// Functions to Create for Homework Lab 4.
Link *createLink(int); 
void pushFront(Link *); 
void pushBack(Link *); 
Link *popFront(); 
Link *popBack(); 
//
// Shazeb's Personal Functions
void newline(int n) { for(int i=0; i<n; i++) cout << endl; }
int displayMenu(); 



//
// Global Values
// 

static Link *frontLink = nullptr;
static Link *lastLink = nullptr;

// 
// Main Method.
// 

int main(int argc, char** argv) 
{
    // Local Variables
    // Link *front = nullptr; 
    
    
    // Create a Link Node
    Link *link1 = new Link;
    Link *link2 = new Link;
    Link *link3 = new Link;
    Link *link4 = new Link;
    Link *link5 = new Link;
    
    // Fill the Structures with Data
    link1->data = 1; 
    link2->data = 2;
    link3->data = 3;
    link4->data = 4; 
    link5->data = 5; 
    
    // Initialize the Link ptrs
    link1->nodePtr = link2;
    link2->nodePtr = link3;
    link3->nodePtr = link4;
    link4->nodePtr = link5; 
    link5->nodePtr = nullptr;
    
    // frontLink = link3; 
    
    /*
    // Set the front of the link
    frontLink = link1;
    
    
    // Print the list
    printList(frontLink); 
    
    
    // Destroy the list 
    destroyList(frontLink); 
    
    
    // Create a New List with FillList Function.
    cout << "\nA new list has now been created:\n";
    frontLink = fillList(10); 
    printList(frontLink); 
    
    
    // Method Call to Create Link Function.
    Link *createdLink = createLink(999); 
    cout << "\nCreated Link Data = " << createdLink->data << endl; 
    
    
    // Try the PushFront Function.
    pushFront(createdLink); newline(1); 
    printList(frontLink); 
    
    
    // Try the PushBack Function.
    Link *createdLink2 = createLink(1010); 
    pushBack(createdLink2); newline(1);
    printList(frontLink); 
    
    
    // Try the Pop Front Function.
    newline(1); 
    Link *popped = popFront(); 
    cout << "You popped " << popped->data << " from the front of the list.\n";
    cout << "The list is now:\n"; 
    printList(frontLink); 
    
    
    // Try the Pop Back Function.
    newline(1);
    Link *popped2 = popBack(); 
    cout << "You popped " << popped2->data << " from the back of the list.\n";
    printList(frontLink); 
    
    
    // Try to Pop Another Link from the back.
    popped2 = popBack();
    cout << "You popped " << popped2->data << " from the back of the list.\n";
    printList(frontLink); 
    
    
    
    // Destroy the List. 
    newline(1);     
    
    // Try to Print the List.
    printList(frontLink); 
    
    
    // Create a New List.
    newline(1); 
    Link *newList = fillList(3); 
    frontLink = newList;     
    printList(link1); 
    */
    
    int choice = -1; 
    Link *pop = new Link; 
    
    
    // Display the Program Title.
    cout << "WELCOME TO SHAZEB SUHAIL'S LINKED LIST PROGRAM ASSIGNMENT" << endl;
    cout << "---------------------------------------------------------" << endl; 
    cout << "***WARNING***\n(Only Enter Integer Values or Code Will Break.)\n\n"; 
    do 
    {
        choice = displayMenu(); 
        
        switch (choice)
        {
            case 1:        
                newline(1); 
                
                // Case Variables
                int listSize;  // initialized by user.
                int menuChoice; 
                
                // Check to see if a Linked List already exists. 
                if (frontLink)
                    cout << "(A Linked List exists!)\n";
                else 
                {
                    cout << "(No Linked List exists.)\n"; 
                    
                    // Create a New List since no Lists exist.
                    cout << "How many elements should the list be?\n"
                     << "(1-100): "; 
                    cin >> listSize; 

                    // Input Validation. 
                    while (listSize < 1 || listSize > 100)
                    {
                        cout << "Error! List size must be between (1-100): "; 
                        cin >> listSize; 
                    }

                    // Create the List and initialize the front of the list. 
                    frontLink = fillList(listSize);
                } 
                 
                // Enter a new do...while loop for Linked List Menu.
                do 
                {
                    newline(1); 
                    cout << "What would you like to do now?\n"
                         << "[1] : printList()\n"
                         << "[2] : popFront()\n"
                         << "[3] : popBack()\n"
                         << "[4] : pushFront()\n"   
                         << "[5] : pushBack()\n"
                         << "[6] : destroyList()\n"
                         << "[7] : <- Go Back to Main Menu.\n"
                         << "(Make a Selection): "; 
                    cin >> menuChoice; 

                    // Input Validation.
                    while (menuChoice < 1 || menuChoice > 7)
                    {
                        cout << "Error! Enter a valid menu option: ";
                        cin >> menuChoice; 
                    }
                    
                    // Break out of loop if User chooses to go back to Main Menu.
                    if (menuChoice == 7) break; 

                    newline(1); 
                    switch(menuChoice) 
                    {
                        // Print List Switch Case.
                        case 1:  
                            printList(frontLink); 
                            break;
                        
                        // Pop Front Switch Case. 
                        case 2: 
                            if (!frontLink) 
                            {
                                cout << "The List is Empty. No Link can be Popped.\n"; 
                            }
                            else 
                            {
                                pop = popFront(); 
                                cout << "You Popped \'" << pop->data << "\' from the Front of the List.\n";
                            }       
                             
                            break;
                        
                        // Pop Back Switch Case.
                        case 3:  
                            if (!frontLink)
                            {
                                cout << "The List is empty. No Link can be Popped.\n"; 
                            }
                            else if (frontLink->nodePtr == nullptr)
                            {
                                pop = popFront(); 
                                cout << "You Popped \'" << pop->data << "\' from the Front of the List.\n"; 
                            }
                            else 
                            {
                                pop = popBack(); 
                            }
                            
                            
                            break; 

                        case 4: 
                            cout << "You chose to Push a New Link to the Front of the List\n"; 
                            break; 

                        case 5: 
                            cout << "You chose to Push a New Link to the Back of the List\n"; 
                            break; 

                        case 6: 
                            cout << "You chose to destroy the list.\n"; 
                            break; 

                        case 7: 
                            cout << "You chose to go back to the Main Menu.\n"; 
                            break; 

                        default: 
                            cout << "Something went wrong! x_X" << endl; 
                    } 
                    
                    
                } while (menuChoice != 7 || menuChoice != 6); 
                
                
                newline(1); 
                break;
                
            case 2: 
                cout << "\nYou chose to End the Program.\n"; 
                break;
                
            default:
                cout << "Something went wrong! x_X\n"; 
            
        }
         
        
        newline(1); 
        
    } while (choice != 2); 
    
    // End. 
    cout << "\nEnd Program."; 
    return 0;
}

//
// End of Main Method.
//


//
// Function Declarations
//

int displayMenu()
{
    // Function Variables.
    int choice; 
    
    cout << "\tMAIN MENU\n"
         << "[1] : Create a Linked List.\n"
         << "[2] : Quit Program\n"
         << "(Make a Selection): ";   
    cin >> choice; 
    
    while (choice < 0 || choice > 2)
    {
        cout << "Error! Enter a valid menu option: "; 
        cin >> choice; 
    } 
    
    return choice; 
   
}






// Push Front Overloaded Function. 
void pushFront(Link *newFront)
{
    newFront->nodePtr = frontLink; 
    frontLink = newFront; 
}





// Push Back Function. 
void pushBack(Link *link)
{
    // Function Variables
    Link *next = frontLink; // Ptr to Traverse the Linked List.
    
    if (!next)
    {
        cout << "The list is empty.\n"; 
    }
    else 
    {
        while(next) // While Next Node Link is True, Traverse the List.
        {
            if (next->nodePtr == nullptr)
                break; 
            else
                next = next->nodePtr; 
        } 

        next->nodePtr = link;
        link->nodePtr = nullptr; // Set Last Link's nodePtr to nullptr.
    }
}





// Pop the First Link in the List.
Link *popFront()
{
    // Function Variables.
    Link *poppedLink = new Link; 
    
    poppedLink = frontLink; // Link to be Popped Off Front. 
    
    frontLink = frontLink->nodePtr; 
    
    poppedLink->nodePtr = nullptr;
    
    return poppedLink; 
} 




/*
// Pop the Last Link in the list.
Link *popBack()
{
    Link *nextLink = frontLink;
    Link *poppedLink = new Link;
    poppedLink->nodePtr = nullptr;
    
    // If Only One Link Exists in the List.
    if (frontLink->nodePtr == nullptr)
    {
        // The frontLink appears to be the Only Link. So Pop the Front Link. 
        poppedLink->data = frontLink->data; 
        poppedLink->nodePtr = nullptr; 
        frontLink = nullptr; 
    }
    // If more than One Link Exists in the List. 
    else 
    {
        cout << "exectute b" << endl; 
        // Traverse the List.
        while (nextLink)
        {
            nextLink = nextLink->nodePtr;
        }

        poppedLink->data = nextLink->data; // Initialize poppedLink->data

        // Traverse the List Again and Remove nodePtr to Popped Link. 
        Link *temp = frontLink; 
        
        while(temp)
        {
            if (temp->nodePtr->nodePtr == nullptr) 
            {
                temp->nodePtr = nullptr;
                break;
            } 
            else
            {
                temp = temp->nodePtr;
            }
        }
    }
    
    return poppedLink; 
} */


Link *popBack() 
{
    Link *nextLink = frontLink; // create a Temporary Link and Assign it to the frontLink.
    
    if (nextLink) // If now, new temp = true, aim its ptr to the nearest null ptr. 
    {
        // while (nextLink ) // While nextLink 
    }
    else if (!nextLink)
        cout << "frontLink does not exist." << endl;
    
    
    // Loop to the End of the List. 
   //  while (nextLink != )
    
    
    
    
    
    // display frontLink data; 
    cout << "frontLink->data = " << nextLink->data << endl;
    
    // return back a poppedLink. 
    return nextLink; 
}






// Create a Link.
Link *createLink(int data)
{
    // Create a New Link.
    Link *newLink = new Link; 
    newLink->data = data; 
    newLink->nodePtr = nullptr;
    
    return newLink; 
}





// Fill the List.
Link *fillList(int n)
{
    // Initially create the front ptr
    Link *front = new Link; 
    front->data = 1; 
    front->nodePtr = nullptr; 
    
    // If n > 1, then fill with data
    Link *temp = front; 
    
    for (int i=1; i < n; i++)
    {
        Link *newLink = new Link; 
        newLink->data = i+1; 
        newLink->nodePtr = nullptr; 
        front->nodePtr = newLink; 
        front = newLink; 
        
    }
    // Initialize lastLink. 
    lastLink = front; 
    
    // Return the correct frontLink. 
    return front = temp; 
}






// Print the List.
void printList(Link *link) 
{    
    //Function Variables.
    int i = 1; // Temporary Value
    
    // Check to see if the List is Empty.
    if (!frontLink)
        cout << "The List is empty.\n"; 
    else 
    {
        // Print the Elements of the Linked List. 
    while (link != nullptr)
    {
        if (i >= 1) 
            cout << "link" << i << "= "; i++; 
        cout << link->data << endl; // Print the Node's Data. 
        link = link->nodePtr; // Set Next Equal To Next Node on the Linked List.
    }
    if (link == nullptr)
        newline(1); 
        cout << "The end of the list has been reached.\n";
    }   
}







// Destroy the List.
void destroyList(Link *link)
{    
    // Traverse the List and Destroy the Link Nodes.
    while (link != nullptr)
    {
        Link *front = link; 
        link = link->nodePtr;
        delete front;
    }
    delete link; 
    
    if (link == nullptr)
        cout << "The list has been deleted from memory.\n"; 
}



// Push a Link to the Front of a Linked List. 
/*
void pushFront(Link *front)
{
    // Function Variables.
    int value;
    
    cout << "Enter an Int Value to be pushed to the front of the linked list: ";
    cin >> value; 
    
    // Create a New Link.
    Link *newLink = new Link; 
    newLink->data = value; 
    newLink->nodePtr = front; 
    front = newLink; 
} */
