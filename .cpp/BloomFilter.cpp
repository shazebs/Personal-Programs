// Author: Shazeb Suhail
// Date:   5-16-21
// Time:   9:19 PM (start)
// Time of Assignment Completion: 5-17-21 at 9:15 PM (end)

// Bloom Filter Assignment.

#include <iostream>
#include <vector>
#include <string>
#include <set>
#include <iomanip>
using namespace std;



// Original Structure.
class IntLink
{
public:
    struct IntNode { // Singly-List
        int data;
        IntNode *forward;

        // Constructor.
        IntNode(int x) {
            this->data = x;
            forward = nullptr;
        }
    };

    IntNode *head = nullptr;
    IntNode *tail = nullptr;
    
    ~IntLink() 
    {
        IntNode *next = head; 
        while (next) 
        {
            IntNode *temp = next; 
            next = next->forward;
            delete temp;
        }
        delete next;
    }

    // IntLink Operations.

    // create an int node.
    IntNode *createNode(int value) {
        IntNode *node = new IntNode(value);
        return node;
    }

    // Set head of the int list.
    void setHead(IntNode *node) {
        if (!head) {
            head = node;
            head->forward = nullptr;
        }
    }

    // Add a node to the int list.
    void pushBack(IntNode *node) {
        IntNode *iterator = head;

        if (iterator) {
            // Loop to the end of the list.
            while(iterator->forward != nullptr)
                iterator = iterator->forward;
            iterator->forward = node;
            tail = node;
            tail->forward = nullptr;
        }
        else
            cout << "The list is empty.\n";
    }

    // create a list with 3 nodes.
    void createList(int x, int y, int z)
    {
        // Create the int nodes.
        IntNode *node1 = new IntNode(x);
        IntNode *node2 = new IntNode(y);
        IntNode *node3 = new IntNode(z);

        // Chain the int linked list.
        node1->forward = node2;
        node2->forward = node3;
        node3->forward = nullptr;

        head = node1;
    }

    void displayList(IntNode *head)
    {
        IntNode *it = head;
        while(it) {
            cout << it->data << " ";
            it = it->forward;
        } cout<<endl;
    }
};



// Function Prototypes.
void displaySet(set<string>);
void tripleHash(string);
void hashName(string,int &,int &,int &);



// Global Variables.
vector<int> bitVector;
vector<int>::iterator v_it;



// Start of Main Method.
int main()
{
    // Local variables.
    string name;

    // Create a pre-determined list.
    cout<<"Pre-existing list values:\n";
    set<string> list = {"Sora", "Goku", "Saitama", "Itachi"};
    displaySet(list); cout<<endl;


    // Hash all the Names in the List.
    cout<<"This Bloom Filter uses 3 hash functions for 'k'\n";
    tripleHash("Sora");
    tripleHash("Goku");
    tripleHash("Saitama");
    tripleHash("Itachi");


    // Get a name from the user.
    int hash1, hash2, hash3;
    cout << "\nEnter a name to check if it exists in the list: ";
    cin >> name;
    hashName(name,hash1,hash2,hash3);
    cout << name << "'s hash values: ";
    cout << hash1 <<" "<< hash2 <<" "<< hash3<<endl;

    // Output results of hash search.
    cout << "Does the name '"<< name << "' exist in the list: ";

    // Search a vector list's hash values to see if name exists in the list.
    int count = 0;
    for (int i=0; i < bitVector.size(); i++) {
        if (bitVector[i] == hash1) {
            count++;
        } else if (bitVector[i] == hash2) {
            count++;
        }
        else if (bitVector[i] == hash3) {
            count++;
        }
        if (count == 3)
            break;
    }


    // Display name existence message.
    if (count < 3){
        cout << "no.\n";
    } else if (count == 3) {
        cout << "maybe!\n";
    } else
        cout<<"error!\n";


    // Display the bitVector list.
    cout<<endl;
    cout<<"Hash value elements in the bitVector list:\n";
    if (bitVector.empty())
        cout << "The bitVector list is empty.\n";
    else { // Display the elements of the bitVector list.
        for (v_it = bitVector.begin(); v_it != bitVector.end(); v_it++) {
            cout << *v_it << " ";
        } cout << endl;
    }
    
    
    // Clean up memory.


    // Display end program message.
    cout << "\nEnd Program.";
    return 999;
}
// End of Main Method.



// Function Implementations.

// Display the items in the set.
void displaySet(set<string> list)
{
    // Function variables.
    int count = 0;
    set<string>::iterator it = list.begin();

    while (it != list.end()) {
        cout << *(it) << endl;
        it++;
    }
}

// Triple Hash Function.
void tripleHash(string name)
{
    // Function variables.
    hash<string> hasher;

    // Hash name three different ways.
    size_t hash1 = hasher(name);
    uint8_t hash2 = hasher(name);
    uint16_t hash3 = hasher(name);

    // Modulo Hashes.
    int x, y, z;
    x = hash1 % 100;
    y = hash2 % 100;
    z = hash3 % 100;

    // Link Hash values together via Linked List.
    IntLink tempList;
    tempList.createList(x,y,z);

    cout<<left<<setw(23)<<name+"'s hash values: ";
    tempList.displayList(tempList.head);

    bitVector.push_back(x);
    bitVector.push_back(y);
    bitVector.push_back(z);
}

// Hash name.
void hashName(string name,int &h1,int &h2,int &h3)
{
    // Function variables.
    hash<string> hasher;

    // Hash name three different ways.
    size_t hash1 = hasher(name);
    uint8_t hash2 = hasher(name);
    uint16_t hash3 = hasher(name);

    // Modulo Hashes
    int x, y, z;
    x = hash1 % 100;
    y = hash2 % 100;
    z = hash3 % 100;

    h1 = x; h2 = y; h3 = z;
}
