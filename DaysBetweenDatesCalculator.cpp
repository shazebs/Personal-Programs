/* 
 * File:   z_test_1.cpp
 * Author: Shazeb
 *
 * Created on August 31, 2020, 1:19 AM
 */

#include <cstdlib>
#include <iostream>
using namespace std;

// Function Prototypes
int Day_Of_Year(int, int);
int Number_Of_Days_Between_Dates(int, int, int, int);


int main(int argc, char** argv) {
    
    // variables
    int first_month, second_month;
    int day_one, day_two;
    int year_one, year_two;
    int day_of_year_one, day_of_year_two;
    
    // get user input for Date 1
    cout << "Enter First Month (1-12): ";
    cin >> first_month;
    // input validation to make sure month is between 1 and 12.
    while (first_month < 1 || first_month > 12) {
        cout << "Error: Re-enter a correct month (1-12): ";
        cin >> first_month;
    }
    
    if (first_month == 1 || 
        first_month == 3 || 
        first_month == 5 || 
        first_month == 7 || 
        first_month == 8 || 
        first_month == 10 || 
        first_month == 12 ) {
        cout << "Enter Day (1-31): ";
        cin >> day_one;
        // input validation to make sure day is between 1 and 30.
        while (day_one < 1 || day_one > 31) {
            cout << "Error: Re-enter a correct day (1-31): ";
            cin >> day_one;
        }
    }
    else if (first_month == 2) {
        cout << "Enter Day (1-28): ";
        cin >> day_one;
        // input validation to make sure day is between 1 and 30.
        while (day_one < 1 || day_one > 28) {
            cout << "Error: Re-enter a correct day (1-28): ";
            cin >> day_one;
        }
    }
    else 
    {
        cout << "Enter Day (1-30): ";
        cin >> day_one;
        // input validation to make sure day is between 1 and 30.
        while (day_one < 1 || day_one > 30) {
            cout << "Error: Re-enter a correct day (1-30): ";
            cin >> day_one;
        }
    }
    cout << "Enter Year: ";
    cin >> year_one;
    
    
    // Get user input for Date 2
    cout << "Enter Second Month (1-12): ";
    cin >> second_month;
    // input validation to make sure month is between 1 and 12.
    while (second_month < 1 || second_month > 12) {
        cout << "Error: Re-enter a correct month (1-12): ";
        cin >> second_month;
    }
    
    if (second_month == 1 || 
        second_month == 3 || 
        second_month == 5 || 
        second_month == 7 || 
        second_month == 8 || 
        second_month == 10 || 
        second_month == 12 ) 
    {
        cout << "Enter Day (1-31): ";
        cin >> day_two;
        // input validation to make sure day is between 1 and 30.
        while (day_two < 1 || day_two > 31) {
            cout << "Error: Re-enter a correct day (1-31): ";
            cin >> day_two;
        }
    }
    else if (first_month == 2) {
        cout << "Enter Day (1-28): ";
        cin >> day_two;
        // input validation to make sure day is between 1 and 30.
        while (day_two < 1 || day_one > 28) {
            cout << "Error: Re-enter a correct day (1-28): ";
            cin >> day_two;
        }
    }
    else 
    {
        cout << "Enter Day (1-30): ";
        cin >> day_two;
        // input validation to make sure day is between 1 and 30.
        while (day_two < 1 || day_two > 30) {
            cout << "Error: Re-enter a correct day (1-30): ";
            cin >> day_one;
        }
    }
    cout << "Enter Year: ";
    cin >> year_two;    
    
    // find what day out of 365 
    day_of_year_one = Day_Of_Year(first_month, day_one);    // Function 1 Call
    day_of_year_two = Day_Of_Year(second_month, day_two);   // Function 1 Call
    
    int days_between_dates;
    days_between_dates = Number_Of_Days_Between_Dates(year_one, day_of_year_one, year_two, day_of_year_two);
    
    // Output Results
    cout << endl;
    cout << "[" << first_month << "/" << day_one << "/" << year_one <<  "]->["
         << second_month << "/" << day_two << "/" << year_two << "] = "
         << days_between_dates << " Days\n";
    
    // 
    cout << endl;
    cout << "Date One: " << day_of_year_one << "/365 Days\n";
    cout << "Date Two: " << day_of_year_two << "/365 Days\n";
    
    
    

    

    // End Program.
    return 0;
}

// FUNCTION 1
int Day_Of_Year(int month, int day) {
    
    if (month == 1) // January
    {
        return day;
    }
    else if (month == 2) // February 
        {
            return day += 31;
        }
            else if (month == 3) // March 
            {
                return day += (31+28);
            }
                else if (month == 4) // April
                {
                    return day += (31+28+31);
                }
                    else if (month == 5) // May
                    {
                        return day += (31+28+31+30);
                    }
                        else if (month == 6) // June 
                        {
                            return day += (31+28+31+30+31);
                        }
                            else if (month == 7) // July 
                            {
                                return day += (31+28+31+30+31+30);
                            }
                                else if (month == 8) // August 
                                {
                                    return day += (31+28+31+30+31+30+31);
                                }
                                    else if (month == 9) // September 
                                    {
                                        return day += (31+28+31+30+31+30+31+31);
                                    }
                                else if (month == 10) // October
                                {
                                    return day += (31+28+31+30+31+30+31+31+30);
                                }
                            else if (month == 11) // November 
                            {
                                return day += (31+28+31+30+31+30+31+31+30+31);

                            }
                        else if (month == 12) // December 
                        {
                            return day += (31+28+31+30+31+30+31+31+30+31+30);
                        }    
}

// FUNCTION 2 
int Number_Of_Days_Between_Dates(int year1, int day1, int year2, int day2) {
    
    // function variables
    int days; // number of days to return from function.
    
    
    
    // If both dates have the same year, run this code.
    if (year1 == year2) {
        // subtract days to find number of days between dates.
        days = day2 - day1;
        
        // *Input Validation*
        // if number of days is negative, turn it positive.
        if (days < 0) {
            int positive_value;
            positive_value = days - (days*2);
            days = positive_value;
            return days;
        }
        else {  // return the positive value of days between dates.
            return days;
        }
          
        
    } // Run this code if year 1 is before year 2
    else if (year1 < year2) {
        // find out how many days are left in year 1
        int days_left_in_year1 = (365 - day1);
        // subtract year 1 from year 2
        int num_years_between_dates = year2 - year1;
        
        // run this code if only 1 year has passed between the two dates.
            if (num_years_between_dates == 1) {
                return days = days_left_in_year1 + day2;
            }
        // run this code if more than 1 year has passed between the two dates.
            else if (num_years_between_dates > 1) {
                --num_years_between_dates *= 365; 
                return days = (   num_years_between_dates
                                + days_left_in_year1
                                + day2 + 1                ); 
                
            }
    }
    
   
    else if (year1 > year2) {
        // find out how many days are left in year 2
        days += (365 - day2); 
        // now add the number of days year 1
        days += day1;
        
        // now subtract the number of year between year 1 and year 2
        int num_years_between_dates = year1 - year2;
        
        // if statement if number of years between year 1 and year 2 is 1
        if (num_years_between_dates == 1) {
            return days;
        }
        // if statement if number of years between year1 and year2 is > 1
        else if (num_years_between_dates > 1) {
            days += (num_years_between_dates-1)*365;
            return days;
        }
                
    }
}
