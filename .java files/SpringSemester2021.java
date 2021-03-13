// Author: @shazebs
// Date:   2.16.21
// Time:   12:54 am

// import libraries
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

public class SpringSemester2021 {

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

    // text wrap color
    public static final String blackback = "\u001B[40m";
    public static final String redback = "\u001B[41m";
    public static final String greenback = "\u001B[42m";
    public static final String yellowback = "\u001B[43m";
    public static final String blueback = "\u001B[44m";
    public static final String purpleback = "\u001B[45m";
    public static final String cyanback = "\u001B[46m";
    public static final String whiteback = "\u001B[47m";



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // data structures - assignments
        String[][] CSC_17C_HW = {
                // {"Triangular Matrix (DUE: Wed. February 24th)", "INCOMPLETE"},
                {"2/17/21 Wednesday Word of the Day", "COMPLETE"},
                {"2/22/21 Monday Word of the Day", "COMPLETE"},
                {"2/24/21 Wednesday Word of the Day", "INCOMPLETE"},
                {"3/01/21 Monday Word of the Day", "PENDING"},
                {"3/03/21 Wednesday Word of the Day", "COMPLETE"},
                {"3/08/21 Monday Word of the Day", "PENDING"},
                {"Triangular Matrix (DUE: Mon. March 8th)", "COMPLETE"},
                {"Homework Review 1 Dynamic Objects (DUE: Wed. March 3rd)", "INCOMPLETE"},
                {"Homework Review 2 Dynamic Objects (DUE: Tue. March 9th)", "INCOMPLETE"},
                {"Lab 3 SimpleVector (DUE: Wed. March 10th)", "INCOMPLETE"},
                {"Lab 4 Linked List and Simple Vector (DUE: Wed. March 17th)", "INCOMPLETE"},
                {"Assignment Permutation and Combination Comparison (DUE: Thu. March 18th)", "INCOMPLETE"},
                {"Homework Review 3 Templates (DUE: Fri. March 19th)", "INCOMPLETE"},
                {"Linked Lists (DUE: Wed. March 24th)", "INCOMPLETE"},
                {"Lab 5 -> STL review for Project 1 (DUE: Fri. March 26th)", "INCOMPLETE"},
                {"Lab Binomial Theorem (DUE: Wed. March 31st)", "INCOMPLETE"},
                {"Hashing (DUE: Fri. April 2nd)", "INCOMPLETE"},
                {"Project 1 (DUE: Sun. April 4th)", "INCOMPLETE"},
                {"Bloom Fitler (DUE: Fri. April 16th)", "INCOMPLETE"},
                {"Midterm (DUE: Wed. April 21st)", "INCOMPLETE"},
                {"ICPC 2018 Volunteer Credit (DUE: Mon. May 3rd)", "INCOMPLETE"},
                {"Sorts (DUE: Mon. May 10th)", "INCOMPLETE"},
                {"Everything Trees (DUE: Wed. May 19th)", "INCOMPLETE"},
                {"Project 2 (DUE: Mon. May 24th)", "INCOMPLETE"},
                {"Final Attendance (DUE: Wed. May 26th)", "INCOMPLETE"},
                {"Final (DUE: Thu. May 27th)", "INCOMPLETE"}
        };
        String[][] CSC_17C_READINGS = {
                {"Chapter 9 Pointers (p.503-556)", "PENDING"},
                {"Chapter 11 Structured Data (p.613-664)", "PENDING"},
                {"Chapter 13 Classes Part I (p.719-816)", "INCOMPLETE"},
                {"Chapter 15 Classes Inheritance, Polymorphism, and Virtual Functions (p.907-988)", "INCOMPLETE"},
                {"Chapter 14 Classes Part II (817-906)", "INCOMPLETE"},
                {"Chapter 16 Exceptions and Templates (p.989-1028)", "INCOMPLETE"}
        };
        String[][] CSC_11_HW = {
                {"Introduction due feb 28", "COMPLETE"},
                {"Acquire Raspberry Pi", "COMPLETE"},
                {"Architecture Powerpoint", "PENDING"},
                {"Architecture Questions #1-3", "PENDING"},
                {"Architecture Assignment", "PENDING"}
        };
        String[][] CSC_7_HW = {
                {"2/17/21 Wednesday Word of the Day", "COMPLETE"},
                {"Install Netbeans due feb 22", "COMPLETE"},
                {"2/23/21 Monday Word of the Day", "COMPLETE"},
                {"2/24/21 Wednesday Word of the Day", "INCOMPLETE"},
                {"3/08/21 Monday Word of the Day", "PENDING"},
                {"Homework Chapter 1 due mar 2", "COMPLETE"},
                {"Quiz 1 due mar 2", "INCOMPLETE"},
                {"Lab Luhn Algorithm 1 due mar 2", "COMPLETE"},
                {"Homework Chapter 2 due mar 15", "PENDING"},
                {"Quiz 2 due mar 4", "INCOMPLETE"},
                {"Lab Truth Tables due mar 10", "PENDING"},
                {"Quiz 3 due mar 9", "INCOMPLETE"},
                {"Homework Chapter 3 due mar 16", "INCOMPLETE"},
                {"Quiz 4 due mar 16", "INCOMPLETE"},
                {"Lab Luhn Algorithm 2 due mar 18", "PENDING"},
                {"Lab Luhn Algorithm 3 due mar 23", "INCOMPLETE"},
                {"Homework Assignment 4 due mar 25", "INCOMPLETE"},
                {"Quiz 5 due mar 25", "INCOMPLETE"},
                {"Quiz 6 due apr 1", "INCOMPLETE"},
                {"Homework Assignment 5 due apr 5", "INCOMPLETE"},
                {"Lab Project 1 Mastermind due apr 5", "INCOMPLETE"},
                {"Quiz 7 due apr 8", "INCOMPLETE"},
                {"Lab Hashing due apr 11", "INCOMPLETE"},
                {"Homework Assignment 6 due apr 13", "INCOMPLETE"},
                {"Quiz 8 due apr 15", "INCOMPLETE"},
                {"Lab Bloom filter due apr 22", "INCOMPLETE"},
                {"Homework Assignment 7 due apr 27", "INCOMPLETE"},
                {"Quiz 9 due apr 27", "INCOMPLETE"},
                {"Lab Project 1a Mastermind due may 6", "INCOMPLETE"},
                {"Lab Hours due may 23", "INCOMPLETE"},
                {"Homework Assignment 8 due may 24", "INCOMPLETE"},
                {"Quiz 10 due may 25", "INCOMPLETE"},
                {"Final 8am Roll Call due may 27", "INCOMPLETE"},
                {"Final due may 27", "INCOMPLETE"},
                {"Lab Project 2 Mastermind AI due may 30", "INCOMPLETE"}
        };
        String[][] CSC_7_READINGS = {
                {"Chapter 1 Slides", "PENDING"},
                {"Discreet Mathematics Chapter 1 Reading", "PENDING"}
        };
        String[][] MAT_1B_HW = {
                {"HW #01: (5.3) Fundamental Theorem of Calculus due feb 22", "#'s: 2,8,11,17,22,29,35,43,55,62,63,68,69", "COMPLETE"},
                {"HW #02: (5.4) Indefinite Integrals and the Net Change Theorem due feb 22", "#'s: 2,10,12,16,18,27,35,38,40,46,60,61", "COMPLETE"},
                {"HW #03: (5.5) The Substitution Rule due feb 22", "#'s: 7,10,11,17,21,23,40,42,48,60,65,70,88,89","COMPLETE"},
                {"HW #04: (7.1) Integration by Parts", "#'s: 3,7,10,12,16,21,27,32,36,38,40,42,57,58", "COMPLETE"},
                {"HW #05: (7.2) Trigonometric Integrals", "#'s:3,6,10,14,17,20,23,26,31,33,36,40,44,48", "COMPLETE"},
                {"HW #06: (7.3) Trigonometric Substitution", "#'s: 4,7,12,16,19,23,26,30", "COMPLETE"},
                {"HW #07: (7.4) Integration of Rational Functions by Partial Fractions", "#'s: 12,16,20,34,40,47", "COMPLETE"},
                {"HW #08: (7.5) Strategy for Integration", "#'s: 1,7,14,22,31,32,39,45,52,57,65,67,74,80", "PENDING"},
                {"HW #09: (7.8) Improper Integrals", "#'s: 1,9,10,13,16,21,24,26,29,33,36,40,50,52,54", "PENDING"},
                {"HW #10: (7.6) Integration Using Tables", "#'s: 3,7,9,11,14,17,20,24,26,30", "PENDING"},
                {"HW #11: (7.7) Approximate Integration", "#'s: 10,11,15,18", "PENDING"},
                //
                {"Exam #1", "", "COMPLETE"},
                //
                {"HW #12: (6.1) Area Between Curves", "#'s: 1,4,11,12,19,25,26,29,31,50,53, & Sec 7.1 #57,58", "PENDING"},
                {"HW #13: (6.2) Volumes (Part I and Part II)", "1,6,9,13,15,18,21,25,28,42,48,54,55", "PENDING"},
                {"HW #14: (6.3) Volumes by Cylindrical Shells", "#'s: 2,4-6,9,10,12,13,15,16,18,19,25,31,38,42, & Sec 7.1 #61-64", "PENDING"},
                {"HW #15: (6.4) Work", "#'s: 3,5,7,9,13,15,21,22,23", "INCOMPLETE"},
                {"HW #16: (6.5) Average Value of a Function", "#'s: 1,3,6,9,13,15,21", "PENDING"},
                {"HW #17: (8.1) Arc Length", "#'s: 2,7,10,13,16,17", "INCOMPLETE"},
                {"HW #18: (8.2) Area of a Surface of Revolution", "#'s: 5,7,9,12,14,15,16,26,28", "INCOMPLETE"},
                {"HW #19: (8.3) Application to Physics and Engineering Part I", "#'s: 3-11,14,15", "INCOMPLETE"},
                {"HW #20: (8.3) Application to Physics and Engineering Part II", "#'s: 21,24,25,27,29,31", "INCOMPLETE"},
                {"HW #21: (9.3) Seperable Equations", "3,8,10,11,15-18,20,21", "INCOMPLETE"},
                //
                {"Exam #2", "", "INCOMPLETE"},
                //
                {"HW #22: (10.1) Curves Defined by Parametric Equations", "#'s: 4,7,9,13,15,17,20,22", "INCOMPLETE"},
                {"HW #23: (10.2) Calculus with Parametric Curves", "#'s: 2,4,6,8,14,16,25,29,31,33,34,37,39,41,44,48,61,63,66", "INCOMPLETE"},
                {"HW #24: (10.3) Polar Coordinates", "#'s: 30,32,33,36,38,40,42,46,56-64even", "INCOMPLETE"},
                {"HW #25: (10.4) Areas and Lengths in Polar Coordinates", "#'s: 2-12 even, 18-42even, 46, 48", "INCOMPLETE"},
                //
                {"Exam #3", "", "INCOMPLETE"},
                //
                {"HW #26: (11.1) Sequences", "#'s: 4-52 eoe, 72-79 (eoe = every other even)", "INCOMPLETE"},
                {"HW #27: (11.2) Series", "#'s: 6,8,15,18-48even,52", "INCOMPLETE"},
                {"HW #28: (11.3) The Integral Test and Estimate of Sums", "#'s: 4-32even", "INCOMPLETE"},
                {"HW #29: (11.4) The Comparison Tests", "#'s: 4-32even", "INCOMPLETE"},
                {"HW #30: (11.5) Alternating Series", "#'s: 2-20,34", "INCOMPLETE"},
                {"HW #31: (11.6) Absolute Convergence and the Ratio and Root Test", "#'s: 2-38even,43", "INCOMPLETE"},
                {"HW #32: (11.7) Strategy for Testing Series", "#'s: 2-38even", "INCOMPLETE"},
                {"HW #33: (11.8) Power Series", "#'s: 2-28even", "INCOMPLETE"},
                {"HW #34: (11.9) Representation of Functions as Power Series", "#'s: 4,6,8,12,16,18,20,26,28", "INCOMPLETE"},
                {"HW #35: (11.10) Taylor and Maclaurin Series", "#'s: 5,8,12,16,22,32,36-42even,43,56,61-65,74-80even", "INCOMPLETE"},
                //
                {"Exam #4", "", "INCOMPLETE"}
        };
        String[][] MAT_1B_RECORDINGS = {
                {"(5.3) Lecture", "COMPLETE"},
                {"(5.4) Lecture", "COMPLETE"},
                {"(5.5) Lecture", "COMPLETE"},
                {"(7.1) Lecture", "COMPLETE"},
                {"(7.2) Lecture", "COMPLETE"},
                {"(7.3) Lecture", "COMPLETE"},
                {"(7.4) Lecture", "COMPLETE"},
                {"(7.5) Lecture", "COMPLETE"},
                {"(7.6) Lecture", "INCOMPLETE"},
                {"(7.6) Text Reading", "PENDING"},
                {"(7.7) Lecture", "INCOMPLETE"},
                {"(7.7) Text Reading", "PENDING"},
                {"(7.8) Lecture", "PENDING"}
        };
        String[][] CIS_830_HW = {
                {"Attendance 02/23/21", "COMPLETE"},
                {"Attendance 02/25/21", "COMPLETE"},
                {"In-class Exercise 02/25/21", "COMPLETE"},
                {"Homework Assignment 01", "COMPLETE"},
                {"Attendance 03/02/21", "COMPLETE"},
                {"In-class Exercise 03/02/21", "COMPLETE"},
                {"Attendance 03/04/21", "PENDING"},
                {"Attendance 03/09/21", "PENDING"},
                {"In-class Exercise 03/09/21", "PENDING"},
                {"Attendance 03/11/21", "PENDING"},
                {"In-class Exercise 03/11/21", "PENDING"},
                {"Homework Assignment 02", "PENDING"}

        };
        //
        //
        //
        // local variables
        boolean loopCondition = true;


        // BEGIN A LOOP MENU
        do {
            System.out.printf(
                    "%s",
                    black + whiteback + "\tMENU:\n" + reset
                    + green + "[1] : " + reset + "Homework\n"
                    + green + "[2] : " + reset + "Contacts\n"
                    + red + "[0] :" + reset + " Exit Program\n"
            );
            try {
                int selection = in.nextInt();

                switch(selection) {
                    case 0 :
                        System.out.print(green + "\nYou chose to end the program.\n\n" + reset);
                        loopCondition = false;
                        break;

                        // [1] All Things Homework
                    case 1 :
                        // Print Homework assignments from each class
                        int menuOption;

                        do {
                        // Menu Format
                        System.out.printf("%s \n%s \n%s \n%s \n%s \n%s \n%s %n",
                            (green + "[1] : " + reset + "ALL ASSIGNMENTS"),
                            (green + "[2] : " + reset + "CSC-17C Assignments (C++ Data Structures)"),
                            (green + "[3] : " + reset + "CSC-11 Assignments (Computer Architecture and Organization: Assembly)"),
                            (green + "[4] : " + reset + "CSC-7 Assignments (Discrete Mathematics)"),
                            (green + "[5] : " + reset + "MAT-1B Assignments (Calculus II)"),
                            (green + "[6] : " + reset + "CIS-830 Assignments (Introduction Python)"),
                            (red + "[0] : " + reset + "GO BACK")
                         );

                         // get a menu option from user
                            menuOption = in.nextInt();
                            //
                            try {
                                switch (menuOption) {
                                    case 1:
                                        printHW(CSC_17C_HW, "CSC-17C Assignments");
                                        printHW(CSC_17C_READINGS, "CSC-17C Text Readings");
                                        printHW(CSC_11_HW, "CSC-11 Assignments");
                                        printHW(CSC_7_HW, "CSC-7 Assignments");
                                        printHW(CSC_7_READINGS, "CSC-7 Text Readings");
                                        printNewHW(MAT_1B_HW, "MAT-1B Assignments");
                                        printHW(MAT_1B_RECORDINGS, "MAT-1B Lecture Recordings");
                                        printHW(CIS_830_HW, "CIS_830 Assignments");
                                        break;
                                    case 2:
                                        printHW(CSC_17C_HW, "CSC-17C Assignments");
                                        printHW(CSC_17C_READINGS, "CSC-17C Text Readings");
                                        break;
                                    case 3:
                                        printHW(CSC_11_HW, "CSC-11 Assignments");
                                        break;
                                    case 4:
                                        printHW(CSC_7_HW, "CSC-7 Assignments");
                                        printHW(CSC_7_READINGS, "CSC-7 Text Readings");
                                        break;
                                    case 5:
                                        printNewHW(MAT_1B_HW, "MAT-1B Assignments");
                                        printHW(MAT_1B_RECORDINGS, "MAT-1B Lecture Recordings");
                                        break;
                                    case 6:
                                        printHW(CIS_830_HW, "CIS_830 Assignments");
                                        break;
                                    case 0:
                                        break;
                                }
                            } catch (Exception e) {
                                System.out.println(red + "The system encountered an error!" + reset);
                                e.printStackTrace();
                            }
                        } while (menuOption != 0);

                        newline();
                        break;

                        // [2] All Things Contacts
                    case 2:

                        try  {
                            // variables
                            String[][] Professor_Info = {
                                    {"Mark E. Lehr", "CSC-17C", "CSC-7", "CIS-830", "EMAIL"},
                                    {"Paul Conrad", "CSC-11", "EMAIL"},
                                    {"Veasna Chiek", "MAT-1B", "EMAIL"},
                                    {"Paul Dalba", "CIS-830", "pdalba@ucr.edu"},
                                    {"Jessica Hutchison", "Network Kinection", "jessica@mynetkinect.com", "(714)644-1127"}
                            };

                            // Display professor information
                            System.out.print(yellow + "\nProfessors:\n" + reset);
                            int flag = 1;
                            for (int i = 0; i < Professor_Info.length; i++) {
                                System.out.print(cyan + (flag++) + ". " + reset);
                                for (int j = 0; j < Professor_Info[i].length; j++) {
                                    System.out.print(Professor_Info[i][j] + " || ");
                                }
                                newline();
                            }
                            newline();
                        }
                        catch (Exception e)
                        {
                            System.err.println("Something went wrong! Programs crashed.");
                            // e.printStackTrace();
                        }

                        break; // from Switch case 2

                    // Last Switch Option
                    default:
                        System.out.println("The system does not understand what you typed in.");
                        loopCondition = false;

                }
            }
            catch (Exception e) {
                System.out.println(red + "This program has unexpectedly crashed! Start again." + reset);
                break;
            }

        } while (loopCondition);


        // End Program.
        System.exit(999);
    }

    // FUNCTIONS LIST

    // newline()
    public static void newline() {System.out.println();}
    // newline(int)
    public static void newline(int lines) {
        for (int i = 0; i < lines; i++)
            System.out.println();
    }

    // print Homework version 1 - 1 DIMENSIONAL ARRAY
    private static void printHW(String[] array, String arrayName) {
        newline();

        System.out.println(yellow + arrayName + reset);

        // loop and display String array
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d%s%s%n%n", i+1, ". ", array[i]);
        }
    }

    // print Homework version 2 - 2 DIMENSIONAL ARRAY
    private static void printHW(String[][] array, String arrayName) {
        newline();

        System.out.println(yellow + arrayName + reset);

        // loop and display 2D String array
        for (int row = 0; row < array.length; row++) {
            // color formatting for assignment names
            if (arrayName == "CSC-17C Text Readings" ||
                    arrayName == "CSC-7 Text Readings") {
                System.out.printf("%d%s%s", row + 1, ". ", (blue + array[row][0] + reset));
            }
            else
                System.out.printf("%d%s%s", row+1, ". ", array[row][0]);

            // Homework completion status
            if (array[row][1] == "COMPLETE") {
                System.out.print(" " + green + array[row][1] + reset);
            }
            else if (array[row][1] == "INCOMPLETE") {
                System.out.print(" " + red + array[row][1] + reset);
            }
            else if (array[row][1] == "PENDING") {
                System.out.print(" " + yellow + array[row][1] + reset);
            }

            // line breaks
            newline(2);
        }
    }

    // print a 3 DIMENSIONAL ARRAY
    private static void printNewHW(String[][] array, String arrayName) {
        newline();

        System.out.println(yellow + arrayName + reset);

        // loop and display 3D String array
        for (int row = 0; row < array.length; row++) {

            System.out.printf("%d. %s ", row+1, array[row][0]);
            System.out.printf("%s ", blue + array[row][1] + reset);

            // Homework completion status
            if (array[row][2] == "COMPLETE")
                System.out.printf("%s", green + array[row][2] + reset);
            else if (array[row][2] == "INCOMPLETE")
                System.out.printf("%s", red + array[row][2] + reset);
            else if (array[row][2] == "PENDING")
                System.out.printf("%s", yellow + array[row][2] + reset);

            // line breaks
            newline(2);
        }
    }

    // output rows and columns of a two-dimensional array
    private static void outputArray(String[][] array) { // (String version)
        // loop through array's rows.
        for (int row = 0; row < array.length; row++) {
            // loop through columns of current row.
            for (int column = 0; column < array[row].length; column++) {
                System.out.printf("%d  ", array[row][column]);
            }
            newline();
        }
    }

} // end of main class.


// CSC-17C NOTES
/*
When selecting a data structure to solve a problem, you should follow these steps.

    1. Analyze your problem to determine the basic operations that must be supported.
    Examples of basic operations include inserting a data item into the data structure,
    deleting a data item from the data structure, and finding a specified data item.

    2. Quantify the resource constraints for each operation.

    3. Select the data structure that best meets these requirements.

 */
