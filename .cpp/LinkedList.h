//
// Created by shazebs on 3/29/2021.
//

#ifndef UNTITLED2_LINKEDLIST_H
#define UNTITLED2_LINKEDLIST_H

class LinkedList
{
private :
    // Declare a structure for the list
    struct ListNode
    {
    double value;           // value in this node
    struct ListNode *next; // ptr to next node
    };

    ListNode *head;         // list head ptr

public :
    // Constructor
    LinkedList()
        { head = nullptr; }

    // Destructor
    ~LinkedList();

    // Linked list operations
    void appendNode(double num)
    {
        ListNode *newNode; // to point to a new node
        ListNode *nodePtr; // to move throught the list

        // Allocate a new node and store num there.
        newNode = new ListNode;
        newNode->value = num;
        newNode->next = nullptr;

        // If there are no nodes in the list
        // make newNode the first node.
        if (!head) // if head is not true
            head = newNode;
        else { // Otherwise, insert newNode at end.
            // Initialize nodePtr to head of list
            nodePtr = head;

            // Find the last node in the list.
            while (nodePtr->next)
                nodePtr = nodePtr->next;

            // Insert newNode as the last node.
            nodePtr->next = newNode;
            }
    }

    void insertNode(double num)
    {
        ListNode *newNode;                  // a new node
        ListNode *nodePtr;                  // to traverse the list
        ListNode *previousNode = nullptr;   // the previous node

        // Allocate a new node and store num there.
        newNode = new ListNode;
        newNode->value = num;

        // If there are no nodes in the list
        // make newNode the first node.
        if (!head) {
            head = newNode;
            newNode->next = nullptr;
        }
        else // Otherwise, insert newNode
        {
            // Position nodePtr at the head of list.
            nodePtr = head;

            // Initialize previousNode to nullptr.
            previousNode = nullptr;

            // Skip all nodes whose value is less than num.
            while (nodePtr != nullptr && nodePtr->value < num)
            {
                previousNode = nodePtr;
                nodePtr = nodePtr->next;
            }

            // If the new node is to be the 1st in the list,
            // insert it before all other nodes
            if (previousNode == nullptr) {
                head = newNode;
                newNode->next = nodePtr;
            }
            else // Otherwise insert after the previous node.
            {
                previousNode->next = newNode;
                newNode->next = nodePtr;
            }
        }
    }

    void deleteNode(double num)
    {
        ListNode *nodePtr;      // To traverse the list
        ListNode *previousNode; // To point to the previous node

        // If the list is empty, do nothing.
        if (!head)
            return;
        // Determine if the first node is the one.
        if (head->value == num) {
            nodePtr = head->next;
            delete head;
            head = nodePtr;
        }
        else
        {
            // Initialize nodePtr to head of the list
            nodePtr = head;

            // Skip all nodes whose value is not
            // equal to num.
            // (Traverse List)
            while (nodePtr != nullptr && nodePtr->value != num)
            {
                // initialize previousNode to current node
                previousNode = nodePtr;
                // initialize nodePtr to next node
                nodePtr = nodePtr->next;
            }

            // If nodePtr is not at the end of the list,
            // link the previous node to the node after
            // nodePtr (aka nullptr), then delete nodePtr.
            if (nodePtr)
            {
                previousNode->next = nodePtr->next;
                delete nodePtr;
            }
        }
    }

    void displayList() const
    {
        ListNode *nodePtr; // To move through the list

        // Position nodePtr at the head of the list.
        nodePtr = head;

        // While nodePtr points to a node, traverse the list.
        while(nodePtr)
        {
            // Display the value in this node.
            std::cout << nodePtr->value << std::endl;

            // Move to the next node.
            nodePtr = nodePtr->next;
        }
    }
};

LinkedList::~LinkedList() 
{
    ListNode *nodePtr;  // to traverse the list
    ListNode *nextNode; // to point to the next node

    // Position nodePtr at the head of the list.
    nodePtr = head;

    // While nodePtr is not at the end of the list...
    while (nodePtr != nullptr)
    {
        // Save a pointer to the next node.
        nextNode = nodePtr->next;

        // delete the current node.
        delete nodePtr;

        // position nodePtr at the next node.
        nodePtr = nextNode;
    }
}

#endif //UNTITLED2_NUMBERLIST_H
