
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
// #include "Link.h"

//
// Structure
//

struct Link 
{
    int data;
    Link *nodePtr; 
};


// 
// Classes
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
static Link *tempLink = nullptr; 

// 
// Main Method.
// 

int main(int argc, char** argv) 
{        
    // Local Variables
    int choice = -1; 
    int value; // To Hold Random Values. 
    int temp;  // To Hold Random Values. 
    Link *pop = new Link; 
    Link *add = new Link; 
    
    
    
    // Display the Program Title.
    cout << "WELCOME TO SHAZEB SUHAIL'S LINKED LIST PROGRAM ASSIGNMENT" << endl;
    cout << "---------------------------------------------------------" << endl; 
    cout << "***WARNING***\n(Only Enter Integer Values or Code Will Break.)\n\n"; 
    
    // Start the MENU LOOPING. 
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
                         << "[6] : createLink()\n"   
                         << "[7] : destroyList()\n"
                         << "[8] : <- Go Back to Main Menu.\n"
                         << "(Make a Selection): "; 
                    cin >> menuChoice; 

                    // Input Validation.
                    while (menuChoice < 1 || menuChoice > 8)
                    {
                        cout << "Error! Enter a valid menu option: ";
                        cin >> menuChoice; 
                    }
                    
                    // Break out of loop if User chooses to go back to Main Menu.
                    if (menuChoice == 8) break; 

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
                                cout << "The List is Empty. No Link can be Popped from the Front.\n"; 
                            }
                            else 
                            {
                                pop = popFront(); 
                                cout << "You Popped \'" << pop->data << "\' from the Front of the List.\n";
                            }       
                             
                            break;
                        
                        // Pop Back Switch Case.
                        case 3:  
                            if (!frontLink) // If frontLink Does Not Exist,
                            {
                                // Display an Error Message.
                                cout << "The List is Empty. No Link can be Popped from the Back.\n"; 
                            }
                            // Otherwise, if frontLink isn't Pointing to a Null Link, 
                            else if (frontLink->nodePtr == nullptr)
                            {
                                // Pop the Only Link Left on the List. 
                                pop = popFront(); 
                                // Display the Popped Link's Data. 
                                cout << "You Popped \'" << pop->data << "\' from the Back of the List.\n"; 
                            }
                            // Else if, List has More Than 1 Link, 
                            else 
                            {
                                // Begin the Function. 
                                pop = popBack(); 
                                cout << "You Popped \'" << pop->data << "\' from the Back of the List.\n"; 
                            }
                            
                            
                            break; 

                        // PushFront Function Switch Case.    
                        case 4: 
                            cout << "Enter a Value to Add to the Front of the List: "; 
                            cin >> value; 
                            
                            // Create the New Link then Push it to the Front of the List. 
                            pushFront(createLink(value));    
                            cout << "The Link has been Added to the Front of the List.\n"; 
                            
                            break; 
                        
                            
                        // PushBack Function Switch Case. 
                        case 5: 
                            cout << "Enter a Value to Add to the Back of the List: "; 
                            cin >> value;
                            
                             
                            // If No Link Exists in the List. Set frontLink to New Link. 
                            if (frontLink == nullptr)
                            {
                                frontLink = createLink(value); 
                            }
                            else  
                            { // At this point, a frontLink Exists.
                                pushBack(createLink(value)); // Create a New Link. 
                            }
                            
                            break; 
                        
                            
                        // CreateLink Function Switch Case.     
                        case 6: 
                            cout << "Enter an Int Value for the New Link: "; 
                            cin >> value; 
                            
                            pop = createLink(value); 
                            
                            cout << "link value = " << pop->data << endl;  
                            cout << "\nChoose What to do with the Link.\n"
                                 << "[1] : pushFront()\n"
                                 << "[2] : pushBack()\n"
                                 << "[3] : Cancel CreateLink()\n"
                                 << "(Make a Selection): "; 
                            cin >> temp; 
                            
                            // Input Validation.
                            while (temp < 1 || temp > 3)
                            {
                                cout << "Error! Enter a valid menu option: ";
                                cin >> temp; 
                            }
                            
                            switch (temp)
                            {
                                case 1: 
                                    pushFront(createLink(value)); 
                                    break; 
                                    
                                case 2: 
                                    pushBack(createLink(value)); 
                                    break; 
                                    
                                default: 
                                    cout << "Something went wrong! x_X\n"; 
                            }
                            
                            break; 
                        
                        // DestroyList Function Switch Case.
                        case 7: 
                            destroyList(frontLink); 
                            frontLink = nullptr; 
                            lastLink = nullptr; 
                            
                            break; 

                        case 8: 
                            cout << "You chose to go back to the Main Menu.\n"; 
                            break; 

                        default: 
                            cout << "Something went wrong! x_X" << endl; 
                    } 
                    
                    
                } while (menuChoice != 8); 
                
                
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




// Create a Link.
Link *createLink(int data)
{
    // Create a New Link.
    Link *newLink = new Link; 
    newLink->data = data; 
    newLink->nodePtr = nullptr;
    
    return newLink; 
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
    // lastLink->nodePtr = link; 
    // lastLink = lastLink->nodePtr; 
    
    // Traverse the List to the End. 
    Link *next = frontLink; 
    Link *temp = link; 
    
    if (!frontLink)
    {
        frontLink = link;
    }
    else if (frontLink)
    {
        while (next)
        {
            if ( next->nodePtr == nullptr)
            {
                next->nodePtr = temp; 
                break;
            }

            next = next->nodePtr; 
        }
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




// Pop the Last Link in the List. 
Link *popBack() 
{
    Link *nextLink = frontLink; // create a Temporary Link and Assign it to the frontLink.
    Link *poppedLink = new Link; // To Hold the Popped Link.
    
    // Traverse the List. 
    while (nextLink->nodePtr)
    {
        // Try to Pop a Link from the Back of the List. 
        if ( (nextLink->nodePtr)->nodePtr == nullptr )
        {
            // Initialize Last Link in the List.
            poppedLink = nextLink->nodePtr; 

            // Stop Pointing to the Last Link on the List. 
            nextLink->nodePtr = nullptr; 
            
            // Initialize Last Link.
            lastLink = nextLink; 

            // return the popped Link
            return poppedLink;  
        }   
        // Otherwise, Move to the Next Link. 
        else
            nextLink = nextLink->nodePtr;        
    }
    
    // return back a poppedLink. 
    return poppedLink;
}





// Fill the List.
Link *fillList(int n)
{
    // Initially create the front ptr
    Link *next = new Link; 
    next->data = 1; 
    next->nodePtr = nullptr; 
    
    // If n > 1, then fill with data
    Link *temp = next; 
    
    for (int i=1; i < n; i++)
    {
        Link *newLink = new Link; 
        newLink->data = i+1; 
        newLink->nodePtr = nullptr; 
        next->nodePtr = newLink; 
        next = newLink; 
        
    }
    // Initialize lastLink. 
    lastLink = next; 
    
    // Return the correct frontLink. 
    return next = temp; 
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
        cout << "The List has been Deleted From Memory.\n"; 
}
