// Author: Shazeb Suhail
// Date:   12/4/20
// Time:   1:29 PM

// Last Updated: 12/26/20 @ 4:33 PM

// import libraries
import java.util.InputMismatchException;
import java.util.Scanner;

public class CoinCalculator {

    // create constants
    final static double QUARTER = 0.25;
    final static double    DIME = 0.10;
    final static double  NICKEL = 0.05;
    final static double   PENNY = 0.01;

    public static void main(String[] args) {
        // Create  a Scanner
        Scanner input = new Scanner(System.in);

        // Create a Cash and Coin object
        String previousDate = "12/16/20";
        double previousTotal = 223.58;
        Cash currentCash = new Cash(51.14,48.15,8.00); // 12-5-20
        Coins currentCoin = new Coins(51,42,32,237); // 12-4-20

        System.out.println("\nAuthor@ Shazeb");
        System.out.println("\t'Piggy-Bank'");
        System.out.print(currentCash); // prints 'Checkings', 'Savings', and 'Cash'
        System.out.print(currentCoin); // prints 'TOTAL'

        // print 'Total Money = $' and 'Previous Total = $'
        double totalMoney = currentCash.getTotal() + currentCoin.getTotal();
        //
        System.out.println("\nPrevious Total: $ " + previousTotal);
        System.out.printf("Current Total: %s%,.2f\n", " $ ", totalMoney);


        if (previousTotal > totalMoney) {
            System.out.printf("(-$%,.2f since %s)\n", (previousTotal- totalMoney), previousDate);
        }
        else if (previousTotal < totalMoney) {
            System.out.printf("(+$%,.2f since %s)\n", (totalMoney - previousTotal), previousDate);
        }

        try {
            System.out.println();
            System.out.println("> loop method below (must finish) < ");
            System.out.println("------------------------------------");

            // Get user inputs
            System.out.print("> How many quarters do you have: ");
            int quarters = input.nextInt();
            calcQuarters(quarters);
            //
            System.out.print("\n> How many dimes: ");
            int dimes = input.nextInt();
            calcDimes(dimes);
            //
            System.out.print("\n> How many nickels: ");
            int nickels = input.nextInt();
            calcNickels(nickels);
            //
            System.out.print("\n> How many pennies: ");
            int pennies = input.nextInt();
            calcPennies(pennies);

            // Print total money
            calcTotal(quarters, dimes, nickels, pennies);
        }
        catch (InputMismatchException e) {
            System.err.println("You have to enter an integer value.\nProgram Terminated.");
        }

        System.err.println("Program has successfully ended.");

    } // End of Main Method



    // Start of Main class static methods
    // calculate quarters method
    public static void calcQuarters(int quarters) {
        // local variables
        double total = QUARTER * quarters;
        System.out.printf("Total Quarters = $%,.2f\n", total);

        int rolls = 0;
        while ( (total - 10.00) >= 0 ) {
            rolls += 1;
            total -= 10.00;
        }
        if (rolls > 0) {
            System.out.println("\\\\");
            System.out.printf("(%d rolls of $10.00 quarters,\n", rolls);
            System.out.printf("with %.2f left in loose coins)\n", total);
        }
    }



    // calculate dimes method
    public static void calcDimes(int dimes) {
        // local variables
        double total = DIME * dimes;
        System.out.printf("Total Dimes = $%,.2f\n", total);

        int rolls = 0;
        while ( (total - 5.00) >= 0 ) {
            rolls += 1;
            total -= 5.00;
        }
        if (rolls > 0) {
            System.out.println("\\\\");
            System.out.printf("(You can make %d rolls of $5.00 dimes,\n", rolls);
            System.out.printf("with %.2f left in loose coins)\n", total);
        }
    }



    // calculate nickels method
    public static void calcNickels(int nickels) {
        // local variables
        double total = NICKEL * nickels;
        System.out.printf("Total Nickels = $%,.2f\n", total);

        int rolls = 0;
        while ( (total - 2.00) >= 0 ) {
            rolls += 1;
            total -= 2.00;
        }
        if (rolls > 0) {
            System.out.println("\\\\");
            System.out.printf("(You can make %d rolls of $2.00 nickels,\n", rolls);
            System.out.printf("with %.2f left in loose coin\n", total);
        }
    }



    // calculate pennies method
    public static void calcPennies(int pennies) {
        // local variables
        double total = PENNY * pennies;
        System.out.printf("Total Pennies = $%,.2f\n", total);

        int rolls = 0;
        while ( (total - 0.50) >= 0 ) {
            rolls += 1;
            total -= 0.50;
        }
        if (rolls > 0) {
            System.out.println("\\\\");
            System.out.printf("(You can make %d rolls of $0.50 pennies,\n", rolls);
            System.out.printf("with %.2f left in loose coins)\n", total);
        }
    }



    public static void calcTotal(int quarters, int dimes, int nickels, int pennies) {
        // local variables
        double total = (QUARTER * quarters) + (DIME * dimes) +  (NICKEL * nickels) + (PENNY * pennies);
        System.out.printf("\nTOTAL Coins = $%,.2f\n", total);
    }



    // End of Main class static methods

} // End of class CoinCalculator



class Coins {
    // instance variables
    private double quarters, dimes, nickels, pennies;

    // constructor for coin statements
    public Coins(int quarters, int dimes, int nickels, int pennies) {
        this.quarters = (0.25 * quarters);
        this.dimes = (0.10 * dimes);
        this.nickels = (0.05 * nickels);
        this.pennies = (0.01 * pennies);
    }

    // method total
    public double getTotal() {
        return (quarters + dimes + nickels + pennies);
    }

    // toString
    public String toString() {
        return String.format("%s:%7s$%,.2f\n",
                "TOTAL", " $ ", (quarters + dimes + nickels + pennies));
    }
}

class Cash {
    // instance variables
    private double checkings, savings, cash;

    // constructor
    public Cash(double checkings, double savings, double cash) {
        this.checkings = checkings;
        this.savings = savings;
        this.cash = cash;
    }

    // method total
    public double getTotal() {
        return (checkings + savings + cash);
    }

    // toString
    public String toString() {
        return String.format("%s:%3s%,.2f\n%s:%5s%,.2f\n%s:%8s%,.2f\n",
                "Checkings", " $ ", checkings,
                "Savings", " $ ", savings,
                "Cash", " $ ", cash);
    }
}