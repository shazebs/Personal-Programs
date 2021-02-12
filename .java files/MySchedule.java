// Author: @shazebs
// Date:   1/24/21
// Time:   12:50 AM

// <import libraries>
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;


public class MySchedule {

    // <global constants>
    public static String
            mon = "Monday",
            tue = "Tuesday",
            wed = "Wednesday",
            thu = "Thursday",
            fri = "Friday",
            sat = "Saturday",
            sun = "Sunday";

    // COlORS
    //
    // text color
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String BLACKTEXT = "\u001B[30m";
    public static final String REDTEXT = "\u001B[31m";
    public static final String GREENTEXT = "\u001B[32m";
    public static final String YELLOWTEXT = "\u001B[33m";
    public static final String BLUETEXT = "\u001B[34m";
    public static final String PURPLETEXT = "\u001B[35m";
    public static final String CYANTEXT = "\u001B[36m";
    public static final String WHITETEXT = "\u001B[37m";

    // text wrap color
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


    // Start of main method.
    public static void main(String[] args) {
        // create Scanner
        Scanner input = new Scanner(System.in);
        System.out.println(); // new line

        // <local variables>
        // array
        String[] weekdays = setWeekdays();
        Day[] sleepSchedule = setSleepSchedule();


        notifications(weekdays, sleepSchedule);
        // -----------------------------------

        // ** Test Output **
        getMenuOption(input, weekdays, sleepSchedule);




        // Exit program.
        System.out.println("\n\nProgram ended successfully.");
        System.exit(0);


    } // end of main method.

    // <Functions List>
    //
    // display Notifications
    public static void notifications(String[] weekdays,
                                     Day[] sleepSchedule) {
        displaySleepSchedule(weekdays, sleepSchedule);
        displayWakeupTimes();
    }


    // get menu option
    public static void getMenuOption(Scanner in, String[] weekdays, Day[] sleepSchedule) {
        // function prototypes
        int select = 0;


        // get user's choice
         do {
             // enter a menu option
             System.out.printf(
                     "\n%s \n%s \n%s \n",

                     // [1] Notifications
                     // [2] daysBetweenDates.java
                     // [3] <--GO:BACK

                     "[1] Notifications",
                     "[2] daysBetweenDates.java",
                     "[3] <-QUIT"
             );

             // try block
             try
             {
                 select = in.nextInt();

                 // SWITCH
                 switch (select) {
                     case 1:
                         System.out.println();
                         notifications(weekdays, sleepSchedule);
                         break;

                     case 2:
                         System.out.println(
                                 "'daysBetweenDates()' opened successfully.");
                         break;

                     case 3:
                         System.exit(99);
                         break;

                     default:
                         break;

                 }

             }
             catch (InputMismatchException e) {

                 System.err.println(
                         "Input not recognized. Program crashed (x_x)");

             }

         } while (select == 1 || select == 2 );

    }



    // Set reveille time and bed time for each day.
    public static Day[] setSleepSchedule() {
        Day monday = new Day("5am", "9:30pm");
        Day tuesday = new Day("5am", "9:30pm");
        Day wednesday = new Day("5am", "9:30pm");
        Day thursday = new Day("5am", "9:30pm");
        Day friday = new Day("5am", "9:30pm");
        //
        Day saturday = new Day("5am", "9:30pm");
        Day sunday = new Day("5am", "9:30pm");

        Day[] week = {monday, tuesday, wednesday,
        thursday, friday, saturday, sunday};

        // return array
        return week;
    }
    //
    // set weekdays
    public static String[] setWeekdays() {
        // array
        String[] array = {
                mon, tue, wed, thu,
                fri, sat, sun };

        return array;

    }
    //
    // *display* sleep sleep schedule
    public static void displaySleepSchedule(String[] strArray, Day[] objArray) {
        //
        System.out.println(YELLOWTEXT + "Sleep Schedule" + COLOR_RESET);
        for (int i = 0; i < strArray.length; i++) {
            System.out.printf(
                    "%-10s wakeup: %s%s%s | bedtime: %s%s%s\n",
                    strArray[i],
                    GREENTEXT,
                    objArray[i].getReveille(),
                    COLOR_RESET,
                    GREENTEXT,
                    objArray[i].getBedtime(),
                    COLOR_RESET);
        }
    }
    //
    // *display* wakeup times
    public static void displayWakeupTimes() {
        System.out.println(); // new line
        // array
        String[] array = {
                "1/23/21: 10:07 am",
                "1/24/21: 11:30 am",
                "1/25/21: 10:50 am",
                "1/26/21:  9:54 am",
                "1/27/21: 12:00 pm",
                "1/28/21:  9:27 am",
                "1/29/21:  6:59 am",
                "1/30/21: 11:17 am",
                "1/31/21: 10:34 am",
                "2/1/21:   5:00 am",
                "2/2/21:  11:52 am",
                "2/3/21:   6:55 am",
                "2/4/21:  10:11 am",
                "2/5/21:  10:37 am",
                "2/6/21:  10:02 am"
        };
        // enhanced for loop to print array index values
        for (String i : array) {
            System.out.println(i);
        }

        System.out.println(); // new line
    }
    //
    // *display* daysBetweenDates()
    public static int daysBetweenDates(Scanner in)
    {
        // function variables
        int days = 0;
        String string; // any line text

        // *doorway<- to main code
        System.out.print(
                /* Execute: daysBetweenDates()
                   (y/n)                    */
                "\nExecute: 'daysBetweenDates()'" +
                "\n(" + GREENTEXT + "y " + COLOR_RESET + "/" +
                "n" + COLOR_RESET + ")" );


        // get first date
        System.out.print("\nInput: MM DD YY ");
        int month = in.nextInt();
        int day = in.nextInt();
        int year = in.nextInt();




        return days;
    } // *end* daysBetweenDates();



} // end of MySchedule.java










// Day class
class Day {
    // <instance variables>
    private String reveille; // wake-up time
    private String bedtime;  // go-to-sleep time

    // <constructors>
    Day(String t1, String t2)  {
        reveille = t1;
        bedtime = t2;
    }


    // <get methods>
    // get reveille
    public String getReveille() {return reveille;}
    // get bedtime
    public String getBedtime() {return bedtime;}

}

/*
Additional Notes:

Q_1: What does the user want from this program?
     ------------------------------------------
1. To create a consistent weekly schedule.
    a. (CODE a set time to go to sleep and wake up) ☑
    b. (Create time blocks of activities for mornings)□


 */
