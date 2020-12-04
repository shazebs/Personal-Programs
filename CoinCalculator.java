// Author: Shazeb Suhail
// Date:   12/4/20
// Time:   1:29 PM

// import libraries
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

        // Create a Coin object
        Coins current = new Coins(49,41,31,237); // 12/4/20
        System.out.print(current);

        // Get user inputs
        System.out.print("\nHow many quarters do you have: ");
        int quarters = input.nextInt();
        calcQuarters(quarters);
        //
        System.out.print("How many dimes: ");
        int dimes = input.nextInt();
        calcDimes(dimes);
        //
        System.out.print("How many nickels: ");
        int nickels = input.nextInt();
        calcNickels(nickels);
        //
        System.out.print("How many pennies: ");
        int pennies = input.nextInt();
        calcPennies(pennies);

        // Print total money
        calcTotal(quarters,dimes,nickels,pennies);

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
            System.out.printf("You can make %d rolls of $10.00 quarters\n", rolls);
            System.out.printf("With %.2f left in free coins\n", total);
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
            System.out.printf("You can make %d rolls of $5.00 dimes\n", rolls);
            System.out.printf("With %.2f left in free coins\n", total);
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
            System.out.printf("You can make %d rolls of $2.00 nickels\n", rolls);
            System.out.printf("With %.2f left in free coins\n", total);
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
            System.out.printf("You can make %d rolls of $0.50 pennies\n", rolls);
            System.out.printf("With %.2f left in free coins\n", total);
        }
    }

    public static void calcTotal(int quarters, int dimes, int nickels, int pennies) {
        // local variables
        double total = (QUARTER * quarters) + (DIME * dimes) +  (NICKEL * nickels) + (PENNY * pennies);
        System.out.printf("Total Coins = $%,.2f\n", total);
    }
    // End of Main class static methods

} // End of class CoinCalculator

class Coins {
    // instance variables
    private double quarters, dimes, nickels, pennies;

    // constructor
    public Coins(int quarters, int dimes, int nickels, int pennies) {
        this.quarters = (0.25 * quarters);
        this.dimes = (0.10 * dimes);
        this.nickels = (0.05 * nickels);
        this.pennies = (0.01 * pennies);
    }

    // toString
    public String toString() {
        return String.format("Total = $%,.2f\n",(quarters + dimes + nickels + pennies));
    }
}
