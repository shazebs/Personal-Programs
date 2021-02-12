// Author: Shazeb Suhail
// Date:   1/2/21
// Time:   2:04 PM
// Last update: 2/9/21 @ 4:05 am
// MATH CALCULATOR


// import libraries
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


        // Main DATA
        // get user inputs for 1 day
        Paycheck Day_1 = new Paycheck("1/7/21", 3.25, "Thursday"); // 11-2
        workDays.add(Day_1);
        // $41.47 for 3.25 hours
        //
        //------------------------------------------------------------------------------
        // Week 1/11/21 -> 1/24/21
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
        Paycheck misc = new Paycheck("1/24/21", 1.42, "Sunday"); // HRS MISC
        workDays.add(misc);
        // $104.64 for 8.2 hours
        //
        //--------------------------------------------------------------------------------
        // Week 1/25/21 -> 2/7/21
        //
        Paycheck Day_7 = new Paycheck("1/27/21", 4.20, "Wednesday"); // 2-6:30
        workDays.add(Day_7);
        //
        Paycheck Day_8 = new Paycheck("1/28/21", 4, "Thursday"); // 12-4
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
        // $196.77 for 15.42 hours
        //
        //-----------------------------------------------------------------------------------
        // Week 2/8/21 -> 2/21/21
        /*
        Paycheck Day_14 = new Paycheck("2/11/21", 4, "Thursday"); // 11-3
        workDays.add(Day_14);
        //
        Paycheck Day_15 = new Paycheck("2/12/21", 4, "Friday"); // 12-4
        workDays.add(Day_15);
        //
        Paycheck Day_16 = new Paycheck("2/13/21", 4, "Saturday"); // 10-2
        workDays.add(Day_16);
        //
        Paycheck Day_17 = new Paycheck("2/14/21", 4, "Sunday"); // 1-5
        // $... for 16 hours
        //
        //
        Paycheck Day_18 = new Paycheck("2/18/21", 4, "Thursday"); // 11-3
        workDays.add(Day_18);
        //
        Paycheck Day_19 = new Paycheck("2/19/21", 4, "Friday"); // 12-4
        workDays.add(Day_19);
        //
        Paycheck Day_20 = new Paycheck("2/20/21", 4, "Saturday"); // 4:30-8:30
        workDays.add(Day_20);
        // $... for 12 hours
        */
        //-------------------------------------------------------------------------------------




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
        double amount = receivedAmount(input, totalPay);

        // System.out.print("(" + ANSI_GREEN + "$" + amount + ANSI_RESET + "/" + ANSI_YELLOW + "$");
        //
        System.out.print("(delivered/in-transit) : ");
        System.out.print("(" + ANSI_CYAN + "$");
        System.out.printf("%,.2f", amount);
        System.out.print(ANSI_RESET + "/" + ANSI_GREEN + "$");
        //
        System.out.printf("%,.2f%s\n", totalPay - amount, ANSI_RESET + ")");




        //------------------------------------------
        // Last statement of main method
        System.err.print("\nProgram is completed.");
        System.exit(1);


    } // end of main method.



    // output workDays Array
    public static double getPayPerDay(ArrayList<Paycheck> array) {
        // local variables
        double runningTotal = 0.0;
        int numericalIncrement = 1;

        // start of enhanced for loop
        for (int i = 0; i < array.size(); i++) {

            // if index equals 'misc' ArrayList index
            if (i == 6) {
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
2)

*/