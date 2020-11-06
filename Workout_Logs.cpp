/* 
 * File:   workout_logs.cpp
 * Author: Shazeb Suhail
 *
 * Created on November 5, 2020, 3:11 PM
 */

#include <cstdlib>
#include <iostream>
using namespace std;

// Function Prototypes
void OutputDetails(string, string, int, int, int, char, string, double);


int main(int argc, char** argv) {
    
    // Main Method's Local Variables
    string sessionTitle = "null";    // workout session title
    string exerciseName = "null";    // name of exercise
    int reps = 0;   // number of reps
    int sets = 0;   // number of sets
    int lbs = 0;    // value of lbs lifted
    char grade = '0'; // grade given to exercise session
    string date = "null"; // date of workout session
    double hours = 0.0; // to hold time length of workout session in hours
    
    
    // Get user inputs for 1 workout session
    cout << "Enter name for workout: ";
    getline(cin, sessionTitle);
    cout << "Enter workout date: "; 
    cin >> date;
    cout << "Enter exercise name: ";
    cin.ignore();
    getline(cin, exerciseName);
    cout << "Enter max lbs lifted: ";
    cin >> lbs;
    cout << "Enter number of sets: ";
    cin >> sets;
    cout << "Enter number of reps: ";
    cin >> reps;
    cout << "Enter grade given to workout: ";
    cin >> grade;
    cout << "Enter session time length in hours: ";
    cin >> hours;
    
    
    // OutputDetails: Method Call
    OutputDetails(sessionTitle,exerciseName,reps,sets,lbs,grade,date,hours);
    
    
    // End Program.
    return 0;
}
// End of Main Method.
// ...now moving onto: 
// Function Declarations

void OutputDetails(string title, string exercise, int reps, int sets, int lbs,
                   char grade, string date, double hours) {
    
    // Local variables
    // ...none so far.
    
    // Output results
    cout << endl;
    cout << "Title: " << title << endl;
    cout << "Date:  " << date << endl;
    cout << "Lift:  " << exercise << endl;
    cout << "LBS:   " << lbs << endl;
    cout << "Sets:  " << sets << endl;
    cout << "Reps:  " << reps << endl;
    cout << "Grade: " << grade << endl;
    cout << "Time:  " << hours << " hours" << endl;
    
}
