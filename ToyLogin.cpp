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
void OutputDetails(string, string, string, string, string, string, string, string);


int main(int argc, char** argv) {

    // Main Method's Local Variables
    string sessionTitle = "null";    // workout session title
    string exerciseName = "null";    // name of exercise
    string reps = "null";   // number of reps
    string sets = "null";   // number of sets
    string lbs = "null";    // value of lbs lifted
    string grade = "null"; // grade given to exercise session
    string date = "null";  // date of workout session
    string hours = "null"; // to hold time length of workout session in hours


    // Get user inputs for 1 workout session
    cout << "Enter name for workout: ";
    getline(cin, sessionTitle);
    cout << "Enter workout date: ";
   getline(cin, date);
    cout << "Enter exercise name: ";
    getline(cin, exerciseName);
    cout << "Enter max lbs lifted: ";
    getline(cin, lbs);
    cout << "Enter number of sets: ";
    getline(cin, sets);
    cout << "Enter numbe" << "of reps:  ";
    getline(cin, reps);
    cout << "Enter grade given to workout: ";
    getline(cin, grade);
    cout << "Enter session time length in hours: ";
    getline(cin, hours);


    // OutputDetails: Method Call
    OutputDetails(sessionTitle,exerciseName,reps,sets,lbs,grade,date,hours);

    // End Program.
    cout << "\nThank You 4 Checking Out This Toy Program.\n\nAuthor: Shazeb Suhail\nContact:909-747-4865\nBeaumont, California" << endl;
    return 0;
}
// End of Main Method.
// ...now moving onto: 
// Function Declarations

void OutputDetails(string title, string exercise, string reps, string sets, string lbs,
                   string grade, string date, string hours) {

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
    cout << "Time:  " << hours << endl;

}
