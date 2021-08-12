/*
Author: Shazeb Suhail
Date:   8/7/21
Time:   7:45 PM
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class DaysBetweenDates {

    // COlORS
    //
    // text color
    public static final String reset = "\u001B[0m";
    public static final String black = "\u001B[30m";
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";
    public static final String purple = "\u001B[35m";
    public static final String cyan = "\u001B[36m";
    public static final String white = "\u001B[37m";


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Variables.
        int month1, day1, year1;
        int month2, day2, year2;

        // Month
        int[] monthDays = {
            31, // Jan
            28, // Feb
            31, // Mar
            30, // Apr
            31, // May
            30, // Jun
            31, // Jul
            31, // Aug
            30, // Sep
            31, // Oct
            30, // Nov
            31  // Dec
        };

        // Print some stuff to the screen.
        try {

            // get input for 'month1'
            System.out.print("Enter a month (1-12): ");
            month1 = in.nextInt();
            // input validation.
            while (month1 > 12 || month1 < 1) {
                System.out.print("Error! Enter a month from (1-12): ");
                month1 = in.nextInt();
            }

            // get input for 'day1'
            System.out.print("Enter the day of the month (1-"
                    + monthDays[month1-1] + "): ");
            day1 = in.nextInt();
            // input validation.
            while (day1 < 1 || day1 > monthDays[month1-1]) {
                System.out.print("Error! Enter the day of the month from (1-"
                    + monthDays[month1-1] + "): ");
                day1 = in.nextInt();
            }

            // get input for 'year1'
            System.out.print("Enter the year: ");
            year1 = in.nextInt();



            // get input for 'month2'
            System.out.print("Enter another month (1-12): ");
            month2 = in.nextInt();
            // input validation.
            while (month2 > 12 || month2 < 1) {
                System.out.print("Error! Enter a month from (1-12): ");
                month2 = in.nextInt();
            }

            // get input for 'day2'
            System.out.print("Enter the day of the month (1-"
                    + monthDays[month2-1] + "): ");
            day2 = in.nextInt();
            // input validation.
            while (day2 < 1 || day2 > monthDays[month2-1]) {
                System.out.print("Error! Enter the day of the month from (1-"
                        + monthDays[month2-1] + "): ");
                day2 = in.nextInt();
            }

            // get input for 'year2'
            System.out.print("Enter the year: ");
            year2 = in.nextInt();



            // Print the input back to the user.
            System.out.printf("%nYou entered the dates:%n%d/%d/%d %s%n",
                    month1, day1, year1, green + "[start]" + reset);
            // Print the input back to the user.
            System.out.printf("%d/%d/%d %s%n%n",
                    month2, day2, year2, red + "[end]" + reset);


            // mini-calculations. 
            int temp1 = calcDayOf365(month1, day1, year1, monthDays);
            int temp2 = calcDayOf365(month2, day2, year2, monthDays);
            System.out.println();

            // Print number of days between dates.
            System.out.print("Days Between Dates = " + yellow +
                    DaysBetweenDates(temp1,temp2,year1,year2) + reset);

        }
        // exception handler.
        catch (InputMismatchException e) {
            System.err.print("An error occurred. Try again.");
        }

        // End Program.
        System.exit(999);
    }

    // Functions List.
    public static int DaysBetweenDates(
            int day1, int day2, int year1, int year2) {
        // if same year
        if (year1 == year2) {
            return (day2-day1);
        }
        // if year1 is less than year2
        else if (year1 < year2) {
            // temp variable.
            int numYears = year2 - year1;
            if (numYears == 1) {
                return (365 - day1) + day2;
            }
            else {
                return (365-day1)+((numYears-1)*365)+day2;
            }
        }
        // if year1 is greater than year2
        else { // if (year1 > year2)
            // temp variable.
            int numYears = (year1-year2);
            if (numYears == 1) {
                return (365-day2)+day1;
            }
            else {
                return ((365-day2)+((numYears-1)*365)+day1)*-1;
            }
        }
    }

    public static int calcDayOf365(int month, int day, int year, int[] arr){
        int m = month,
            d = day,
            y = year;
        int[] monthDays = arr;
        int dayCount = 0;

        for (int i=0; i<month-1; i++) {
            dayCount += monthDays[i];
        }
        dayCount += d;
        System.out.printf("%d/365, %d%n", dayCount, y);
        return dayCount;
    }
}
