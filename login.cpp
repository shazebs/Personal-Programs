#include <iostream>
#include <cstdlib>
using namespace std;

// CONSTANT VARIABLES
const string USER1 = "shazebs";
const string USER1_PASSWORD = "barfbarf8";

// Function Prototypes.
void Login();

int main() {

	// variable declaration
	string username;

	
	// Login Screen.
	Login();
	

	// end program.
	cout << "\nProgram has ended. Goodbye!\n";
	return 0;

}

void Login() {
	// variable declaration
	string username, password;
	char choice; // y or n


	// Prompt user to enter a username.
	cout << "Enter username: "; 
	cin >> username;


// RUN THIS CODE IF USER'S LOGIN INFO DOES NOT EXIST.
	if (username != USER1) {
		// prompt user that their username is not in the database.
		cout << "Sorry. That username does not exist.\n"
		     << "Would you like to create an account? (y/n): ";
		cin >> choice;
		
		// *input validation* 
		while (choice != 'y' && choice != 'Y' && choice != 'n' && choice != 'N') {
			cout << "ERROR, invalid input!\n" 
			     << "Would you like to create an account? (y/n): ";
			cin >> choice; 
		}

		// if statement if user does not want to create a username.
		if (choice == 'n' || choice == 'N') {
			cout << "You decided NOT to create a username.";
		}

		// if statement if user wants to create a username.
		else if (choice == 'y' || choice == 'Y') {

			// get user to input desired username.
			cout << "Enter a username without spaces: ";
			cin >> username;
			
			// get user to input a password now. 
			cout << "Enter a password without spaces: ";
			cin >> password; 

			// Output user's desired login credentials.
			cout << endl;
			cout << "Your desired login credentials:\n";
			cout << "Username: " << username << endl;
			cout << "Password: " << password << endl;
		}
	}


// RUN THIS CODE IF USER'S LOGIN INFO DOES EXIST.
	else if (username == USER1) {
		// Output a welcome back prompt.
		cout << "Welcome Back, " << username << "!\n";
	}
}

/* ADDITIONAL NOTES
Q: So what is this program? 
A: This program is being created so that it can be a database for workout logs. 
 


*/
