// Author: Shazeb Suhail
// Date:   1/2/21
// Time:   2:04 PM
// Last update: 2/9/21 @ 4:05 am
// MATH CALCULATOR


// import libraries
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;


// start of main
public class SteveMadden {


    // Global Constants
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

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



    // Start of main method
    public static void main(String[] args) {
        System.out.println(); // newline
        displayProgramTitle();
        newLine();

        // Create Scanner.
        Scanner input = new Scanner(System.in);

        // local variables
        double totalPay;


        // Data Structures
        ArrayList<Paycheck> workDays = new ArrayList<Paycheck>();
        double[] checksCashed = {
                41.47,
                270.79,
                413.84,
                362.16,
                421.62,
                312.77,
                428.90,
                515.21
        };


        // Main DATA
        // get user inputs for 1 day
        Paycheck Day_1 = new Paycheck("1/7/21", 3.25, "Thursday"); // 11-2
        workDays.add(Day_1);
        // $41.47 for 3.25 hours
        //
        //------------------------------------------------------------------------------
        // (1) Weeks 1/11/21 -> 1/24/21
        //
        Paycheck Day_2 = new Paycheck("1/13/21", 4.03, "Wednesday"); // 2-6
        workDays.add(Day_2);
        //
        Paycheck Day_3 = new Paycheck("1/16/21", 3.70, "Saturday"); // 4:30-8:30
        workDays.add(Day_3);
        //
        Paycheck Day_4 = new Paycheck("1/17/21", 5.29, "Sunday"); // 12-5:30
        workDays.add(Day_4);
        // $166.16 for 13.02 hours
        //
        //
        Paycheck Day_5 = new Paycheck("1/20/21", 3.73, "Wednesday"); // 2-6
        workDays.add(Day_5);
        //
        Paycheck Day_6 = new Paycheck("1/23/21", 3.05, "Saturday"); // 11-2
        workDays.add(Day_6);
        //
        Paycheck misc1 = new Paycheck("1/24/21", 1.42, "Sunday"); // HRS MISC
        workDays.add(misc1);
        // $104.64 for 8.2 hours
        //
        //--------------------------------------------------------------------------------
        // (2) Weeks 1/25/21 -> 2/7/21
        //
        Paycheck Day_7 = new Paycheck("1/27/21", 4.20, "Wednesday"); // 2-6:30
        workDays.add(Day_7);
        //
        Paycheck Day_8 = new Paycheck("1/28/21", 4.02, "Thursday"); // 12-4
        workDays.add(Day_8);
        //
        Paycheck Day_9 = new Paycheck("1/29/21", 4.07, "Friday"); // 1-5
        workDays.add(Day_9);
        //
        Paycheck Day_10 = new Paycheck("1/30/21", 3.15, "Saturday"); // 4:30-8:30
        workDays.add(Day_10);
        // $196.78 for 15.42 hours
        //
        //
        Paycheck Day_11 = new Paycheck("2/4/21", 5.48, "Thursday"); // 1-7 (extended 2 hrs)
        workDays.add(Day_11);
        //
        Paycheck Day_12 = new Paycheck("2/5/21", 5.02, "Friday"); // 12-5
        workDays.add(Day_12);
        //
        Paycheck Day_13 = new Paycheck("2/6/21", 4.92, "Saturday"); // 11-4
        workDays.add(Day_13);
        //
        Paycheck misc2 = new Paycheck("2/7/21", 1.58, "Sunday");
        workDays.add(misc2);
        // $196.77 for 15.42 hours
        //
        //-----------------------------------------------------------------------------------
        // (3) Weeks 2/8/21 -> 2/21/21
        //
        Paycheck Day_14 = new Paycheck("2/11/21", 4.08, "Thursday"); // 11-3
        workDays.add(Day_14);
        //
        Paycheck Day_15 = new Paycheck("2/12/21", 4.02, "Friday"); // 12-4
        workDays.add(Day_15);
        //
        Paycheck Day_16 = new Paycheck("2/13/21", 3.98, "Saturday"); // 10-2
        workDays.add(Day_16);
        //
        Paycheck Day_17 = new Paycheck("2/14/21", 3.97, "Sunday"); // 1-5
        workDays.add(Day_17);
        // $... for 16 hours
        //
        //
        Paycheck Day_18 = new Paycheck("2/18/21", 4, "Thursday"); // 11-3
        workDays.add(Day_18);
        //
        Paycheck Day_19 = new Paycheck("2/19/21", 4, "Friday"); // 12-4
        workDays.add(Day_19);
        //
        Paycheck Day_20 = new Paycheck("2/20/21", 3.75, "Saturday"); // 4:30-8:30
        workDays.add(Day_20);
        //
        Paycheck misc3 = new Paycheck("2/21/21", 0.58, "Sunday");
        workDays.add(misc3);
        // $... for 12 hours
        //
        //-------------------------------------------------------------------------------------
        // (4) Weeks 2/22/21 -> 2/28/21
        //
        Paycheck Day_21 = new Paycheck("2/25/21", 4, "Thursday"); // 12-4
        workDays.add(Day_21);
        //
        Paycheck Day_22 = new Paycheck("2/26/21", 4, "Friday"); // 12-4
        workDays.add(Day_22);
        //
        Paycheck Day_23 = new Paycheck("2/27/21", 4, "Saturday"); // 10-2
        workDays.add(Day_23);
        //
        Paycheck Day_24 = new Paycheck("2/28/21", 4, "Sunday"); // 1-5
        workDays.add(Day_24);
        // $204.16 for 16 hours
        //
        //
        Paycheck Day_25 = new Paycheck("3/4/21", 4 , "Thursday"); // 12-4
        workDays.add(Day_25);
        //
        Paycheck Day_26 = new Paycheck("3/5/21", 3.97, "Friday"); // 12-4
        workDays.add(Day_26);
        //
        Paycheck Day_27 = new Paycheck("3/6/21", 4.40, "Saturday"); // 10-2:30
        workDays.add(Day_27);
        //
        Paycheck Day_28 = new Paycheck("3/7/21", 4.67, "Sunday"); // 12-4
        workDays.add(Day_28);
        // $217.43 for 17.04 hours
        //
        //-------------------------------------------------------------------------------------
        // (5) Weeks 3/8/21 -> 3/21/21
        //
        Paycheck Day_29 = new Paycheck("3/11/21", 0 , "Thursday"); // 12-4
        workDays.add(Day_29);
        //
        Paycheck Day_30 = new Paycheck("3/12/21", 4.02, "Friday"); // 1-5
        workDays.add(Day_30);
        //
        Paycheck Day_31 = new Paycheck("3/13/21", 3.93, "Saturday"); // 4:30-8:30
        workDays.add(Day_31);
        // $101.44 for 7.95 hours
        //
        //
        Paycheck Day_32 = new Paycheck("3/18/21", 4.00, "Thursday"); // 11-3
        workDays.add(Day_32);
        //
        Paycheck Day_33 = new Paycheck("3/19/21", 3.98, "Friday"); // 1-5
        workDays.add(Day_33);
        //
        Paycheck Day_34 = new Paycheck("3/20/21", 4.00, "Saturday"); // 4:30-8:30
        workDays.add(Day_34);
        //
        Paycheck Day_35 = new Paycheck("3/21/21", 4.58, "Sunday"); // 1-5
        workDays.add(Day_35);
        // $... for ... hours
        //
        //-------------------------------------------------------------------------------------
        // (6) Weeks 3/22/21 -> 4/4/21
        //
        Paycheck Day_36 = new Paycheck("3/22/21", 4.07, "Monday"); // 3:30-7:30
        workDays.add(Day_36);
        //
        Paycheck Day_37 = new Paycheck("3/25/21", 5.00, "Thursday"); // 12-5
        workDays.add(Day_37);
        //
        Paycheck Day_38 = new Paycheck("3/26/21", 4.95, "Friday"); // 3:30-8:30
        workDays.add(Day_38);
        //
        Paycheck Day_39 = new Paycheck("3/27/21", 5.00, "Saturday"); // 2-7
        workDays.add(Day_39);
        // $ 242.87 for 19.02 hours
        //
        //
        Paycheck Day_40 = new Paycheck("4/2/21", 4.93, "Friday"); // 3:30-8:30
        workDays.add(Day_40);
        //
        Paycheck Day_41 = new Paycheck("4/3/21", 5.00, "Saturday"); // 1-6
        workDays.add(Day_41);
        //
        Paycheck Day_42 = new Paycheck("4/4/21", 4.67, "Sunday"); // 1-6
        workDays.add(Day_42);
        // $ 191.42 for 15 hours
        // [ $ 434.29 for 34.02 ]
        //
        //-------------------------------------------------------------------------------------
        // (7) Weeks 4/5/21 -> 4/18/21
        //
        Paycheck Day_43 = new Paycheck("4/5/21", 5, "Monday"); // 12-5
        workDays.add(Day_43);
        //
        Paycheck Day_44 = new Paycheck("4/8/21", 5, "Thursday"); // 12-5
        workDays.add(Day_44);
        //
        Paycheck Day_45 = new Paycheck("4/10/21", 4.98, "Saturday"); // 3-8
        workDays.add(Day_45);
        // $191.42 for 15 hours
        //
        //
        Paycheck Day_46 = new Paycheck("4/12/21", 4, "Monday"); // 3-7
        workDays.add(Day_46);
        //
        Paycheck Day_47 = new Paycheck("4/14/21", 5, "Wednesday"); // 12-5
        workDays.add(Day_47);
        //
        Paycheck Day_48 = new Paycheck("4/15/21", 4.02, "Thursday"); // 1-5
        workDays.add(Day_48);
        //
        Paycheck Day_49 = new Paycheck("4/17/21", 5, "Saturday"); // 2-7
        workDays.add(Day_49);
        //
        Paycheck Day_50 = new Paycheck("4/18/21", 4.60, "Sunday"); // 2-6
        workDays.add(Day_50);
        // $288.66 for 22.62 hours
        // [ $ 472.16 for 37 hours ]
        //
        //------------------------------------------------------------------------------------
        // Last Day of Work at Steve Madden, Cabazon.
        Paycheck Day_51 = new Paycheck("4/19/21", 3.5, "Monday"); // 4-7:30
        workDays.add(Day_51);
        //
        //



        // display output
        totalPay = getPayPerDay(workDays);
        //
        System.out.print(ANSI_BLACK);
        System.out.print(ANSI_WHITE_BACKGROUND + ANSI_RESET);

        // *display* total pay and total hours
        System.out.printf("%s%s %s$%,.2f%s", (ANSI_GREEN + " TOTAL"),
                (ANSI_YELLOW + " ->"),
                ANSI_GREEN, totalPay,
                ANSI_WHITE_BACKGROUND + ANSI_RESET);
        System.out.printf("%s%.2f hours\n",
                (ANSI_YELLOW + " <- " + ANSI_GREEN),
                getTotalHours(workDays));
        System.out.print(ANSI_RESET);


        // actual hourly pay minus taxes
        displayActualHourly$(totalPay, getTotalHours(workDays));


        // display amount received so far
        // double amount = receivedAmount(input, totalPay);
        double amount = doublesArray(checksCashed);

        // System.out.print("(" + ANSI_GREEN + "$" + amount + ANSI_RESET + "/" + ANSI_YELLOW + "$");
        //
        System.out.print("\n(delivered/in-transit) : ");
        System.out.print("(" + ANSI_CYAN + "$");
        System.out.printf("%,.2f", amount);
        System.out.print(ANSI_RESET + "/" + ANSI_GREEN + "$");
        //
        System.out.printf("%,.2f%s\n", totalPay - amount, ANSI_RESET + ")");




    /*
        // New output 3/30/21
        double[] avgWeeklyHours = {
                doublesArray(Day_2.getShiftHours(), Day_3.getShiftHours(), Day_4.getShiftHours()),
                doublesArray(Day_5.getShiftHours(), Day_6.getShiftHours()),
                doublesArray(Day_7.getShiftHours(), Day_8.getShiftHours(), Day_9.getShiftHours(), Day_10.getShiftHours()),
                doublesArray(Day_11.getShiftHours(), Day_12.getShiftHours(), Day_13.getShiftHours()),
                doublesArray(Day_14.getShiftHours(), Day_15.getShiftHours(), Day_16.getShiftHours(), Day_17.getShiftHours()),
                doublesArray(Day_18.getShiftHours(), Day_19.getShiftHours(), Day_20.getShiftHours()),
                doublesArray(Day_21.getShiftHours(), Day_22.getShiftHours(), Day_23.getShiftHours(), Day_24.getShiftHours()),
                doublesArray(Day_25.getShiftHours(), Day_26.getShiftHours(), Day_27.getShiftHours(), Day_28.getShiftHours()),
                doublesArray(Day_30.getShiftHours(), Day_31.getShiftHours()),
                doublesArray(Day_32.getShiftHours(), Day_33.getShiftHours(), Day_34.getShiftHours(), Day_35.getShiftHours()),
                doublesArray(Day_36.getShiftHours(), Day_37.getShiftHours(), Day_38.getShiftHours(), Day_39.getShiftHours())
                // doublesArray(Day_40.getShiftHours(), Day_41.getShiftHours(), Day_42.getShiftHours())
        };

        newline();
        System.out.println(green + ((((doublesArray(avgWeeklyHours)/avgWeeklyHours.length) * 48.2857143) * 14) * 0.91151) + reset );
    */


/*
        //                                      Run a while loop.
        //--------------------------------------------------------------------------------------------------------------
        int select = -1;

        do {
            System.out.print("")
            try {

            }
            catch {

            }
        } while ()
*/





        //------------------------------------------
        // Last statement of main method
        System.err.print("\nProgram is completed.");
        System.exit(1);


    } // end of main method.

    // FUNCTIONS LIST
    public static void newline() {System.out.println();}
    public static void newline(int n) {for (int i = 0; i < n; i++) newline();}

    // return the total of a doubles array
    public static double doublesArray(double...numbers) {
        double total = 0.0;
        for (double num : numbers) {
            total += num;
        }
        return total;
    }



    // output workDays Array
    public static double getPayPerDay(ArrayList<Paycheck> array) {
        // local variables
        double runningTotal = 0.0;
        int numericalIncrement = 1;

        // start of enhanced for loop
        for (int i = 0; i < array.size(); i++) {

            // if index equals 'misc' ArrayList index
            if (i == 6 || i == 14 || i == 22) {
                runningTotal += array.get(i).getPay();
            }
            //
            else // not a 'misc' index
                {
                // numerical formatting
                if (numericalIncrement < 10) {
                    System.out.print(numericalIncrement++ + ".  ");
                }
                else {
                    System.out.print(numericalIncrement++ + ". ");
                }

                // display date, pay, and shift hours
                System.out.printf("%-8s: %s$%,-6.2f%s -- %-10s (%.2f hrs)\n",
                        array.get(i).getDate(),
                        ANSI_GREEN, array.get(i).getPay(), ANSI_RESET,
                        array.get(i).getDay(),
                        array.get(i).getShiftHours());
                runningTotal += array.get(i).getPay();
            }
        }
        // display line break
        newLine();

        // display runningTotal
        return runningTotal;
    }


    // output total hours
    public static double getTotalHours(ArrayList<Paycheck> array) {
        // local variables
        double runningTotal = 0.0;

        for (Paycheck day : array) {
            runningTotal += day.getShiftHours();
        }

        return runningTotal;
    }


    // display actual hourly pay
    public static void displayActualHourly$(double total, double hours) {
        //
        double actualHourly$ = (total / hours);
        System.out.printf("%s%11s%,.2f %s%s\n", ANSI_YELLOW,
                "$", actualHourly$, ANSI_RED,
                " <- actual hourly minus taxes" + ANSI_RESET);
    }



    // display program title
    public static void displayProgramTitle() {
        System.out.print(ANSI_BLACK);
        System.out.print(ANSI_WHITE_BACKGROUND);
        System.out.println("STEVE MADDEN PAY CALCULATOR");
        System.out.print(ANSI_RESET);
    }



    // new line
    public static void newLine() {
        // display line break
        System.out.println("----------------------------------------------");
    }


    // receivedPay();
    public static double receivedAmount(Scanner in, double total) {
        // function variables
        double amount = -1;
        double runningTotal = 0.0;

        double[] cashedChecks = {
                41.47,
                270.79,
                413.84
        };

        System.out.println();

        while (amount != 0) {
            System.out.print(ANSI_GREEN + "$" + ANSI_RESET + "receivedAmount() = " + ANSI_GREEN + "$" + ANSI_RESET);
            amount = in.nextDouble();

            // input validation
            while (amount > total) {
                System.out.print(ANSI_RED +
                        "You can't enter an amount greater than your total!\n"
                        + ANSI_GREEN + "$" + ANSI_RESET + "receievedAmount() = " + ANSI_GREEN + "$" + ANSI_RESET);
                amount = in.nextDouble();
            }

            // accumulate total
            runningTotal += amount;
        }

        // return double
        return runningTotal;
    }

    // returns a sum of double inputs
    public static double whileLoop() {
        // Function Variables
        double x = 0.0;
        double total = 0.0;

        System.out.println();
        // Get inputs
        do {
            try (Scanner input = new Scanner(System.in);) {
                System.out.print("Enter amount: $ ");
                x = input.nextDouble();
                if (x == 0.0) {
                    break;
                }
                total += x;
            }
            catch (InputMismatchException e) {
                System.err.println("Values entered other than a double");
            }

        } while (x != 0);

        // return a double.
        return total;
    }

} // end of SteveMadden.java






// Date: 1/2/21
// Time: 2:20 PM
//
// first class created
class Paycheck extends Object {


    // instance variables
    private String date = "";
    private String day;
    private double shiftHours = 0.0;
    private double hourlyPay = 14.00; // minimum wage
    private double taxes = 0.91151;



    // Constructor(s)
    Paycheck() {} // no-argument

    // constructor 2
    Paycheck(String date) {
        this.date = date;
    }

    // constructor 3
    Paycheck(String date, double hours, String day) {
        this.date = date;
        shiftHours = hours;
        this.day = day;
    }



    // set methods
    // set date
    public void setDate(String date) {
        this.date = date;
    }

    // set shiftHours
    public void setShiftHours(double hours) {
        shiftHours = hours;
    }

    // set day of week
    public void setDay(String day) {
        this.day = day;
    }



    // get methods
    // get date
    public String getDate() {return date;}

    // get shiftHours
    public double getShiftHours() {return shiftHours;}

    // get day
    public String getDay() {return day;}



    // calculations
    // get pay
    public double getPay() {
        return (shiftHours * hourlyPay) * taxes;
    }

}


/*

Additional Notes:

1) This program will track all the money
   I will be making at 'Steve Madden'
2) Somehow get promos involved with this?

*/
