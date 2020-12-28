// Author:  @shazebs
// Date:    12/17/20
// Time:    10:26 PM

// Last update: 12/26/20 @ 3:39 PM

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Additional Notes:
/*

Main Bills
--------------------------------------
2083.68 - Flagstar Bank (2382734984)
409.49 - Camry Bill
354.06 - Verizon Wireless
340.33 - Metlife Insurance
145.05 - Frontier Bill (168-033-6693)
//
243.62 - So Cal Edison (495-124-0335)
142.43 - Water Bill (951-845-9581)
71.47 - So Cal Gas
49.98 - Waste Bill (866-834-2080)
//
42.99 - Alarm Center LLC (866-484-4800)
75.00 - Orkin Bug Spray (877-620-8282)
----------------------------------------
    - Utilities $-507.50
    - Luxuries  $-1248.93
    - Mortgage  $-2083.68
    - Subscriptions $-117.99
 =
$-3958.10 - Total
----------------------------------------


// Bot's Finanaces
//-------------------------------------------
$1,651.86  - AVG Money Bot makes per month
    - Utilities $-507.50
    - Camry Bill $-409.49
    - Credit Cards $-125.00
 =
$ 609.87 - AVG Money Bot has extra per month
----------------------------------------------

 */

class WorldBank {
    // Instance Variables

    // Mom
    double Chiria_Checking = 21256.79;
    double Chiria_Saving = 16014.16;
    double Chiria_ChaseCard = 2564.61;
    //
    double Chiria_Total = Chiria_Checking + Chiria_Saving;
    //
    double Chiria_JanuaryBills2020 = 4439.92;
    double Chiria_FebruaryBills2020 = 3925.09;
    double Chiria_MarchBills2020 = 4966.05;
    double Chiria_AprilBills2020 = 8043.17;
    double Chiria_MayBills2020 = 4434.32;
    double Chiria_JuneBills2020 = 5399.80;
    double Chiria_JulyBills2020 = 3628.87;
    double Chiria_AugustBills2020 = 4538.37;
    double Chiria_SeptemberBills2020 = 3877.27;
    double Chiria_OctoberBills2020 = 3877.27;
    double Chiria_NovemberBills2020 = 4190.39;
    double Chiria_DecemberBills2020; // Pending
    //
    double[] Chiria_MonthlyBills2020 = {
            Chiria_JanuaryBills2020,
            Chiria_FebruaryBills2020,
            Chiria_MarchBills2020,
            Chiria_AprilBills2020,
            Chiria_MayBills2020,
            Chiria_JuneBills2020,
            Chiria_JulyBills2020,
            Chiria_AugustBills2020,
            Chiria_SeptemberBills2020,
            Chiria_OctoberBills2020,
            Chiria_NovemberBills2020 };
    //
    double Chiria_JanuaryDeposits2020 = 8562.82;
    double Chiria_FebruaryDeposits2020 = 9146.68;
    double Chiria_MarchDeposits2020 = 6151.73;
    double Chiria_AprilDeposits2020 = 6150.63;
    double Chiria_MayDeposits2020 = 7338.60;
    double Chiria_JuneDeposits2020 = 9867.86;
    double Chiria_JulyDeposits2020 = 6870.24;
    double Chiria_AugustDeposits2020 = 9250.26;
    double Chiria_SeptemberDeposits2020 = 6416.09;
    double Chiria_OctoberDeposits2020 = 6723.13;
    double Chiria_NovemberDeposits2020 = 14085.79;
    double Chiria_DecemberDeposits2020; // Pending + $5970.86
    //
    double[] Chiria_MonthlyDeposits2020 = {
            Chiria_JanuaryDeposits2020,
            Chiria_FebruaryDeposits2020,
            Chiria_MarchDeposits2020,
            Chiria_AprilDeposits2020,
            Chiria_MayDeposits2020,
            Chiria_JuneDeposits2020,
            Chiria_JulyDeposits2020,
            Chiria_AugustDeposits2020,
            Chiria_SeptemberDeposits2020,
            Chiria_OctoberDeposits2020,
            Chiria_NovemberDeposits2020 };
    //
    double Chiria_JanuaryWithdrawals2020 = 5866.57;
    double Chiria_FebruaryWithdrawals2020 = 6527.42;
    double Chiria_MarchWithdrawals2020 = 6693.92;
    double Chiria_AprilWithdrawals2020 = 8888.45;
    double Chiria_MayWithdrawals2020 = 6401.91;
    double Chiria_JuneWithdrawals2020 = 6974.54;
    double Chiria_JulyWithdrawals2020 = 5623.41;
    double Chiria_AugustWithdrawals2020 = 7722.21;
    double Chiria_SeptemberWithdrawals2020 = 6945.51;
    double Chiria_OctoberWithdrawals2020 = 5686.38;
    double Chiria_NovemberWithdrawals2020 = 5288.21;
    double Chiria_DecemberWithdrawals2020; // Pending
    //
    double[] Chiria_MonthlyWithdrawals2020 = {
            Chiria_JanuaryWithdrawals2020,
            Chiria_FebruaryWithdrawals2020,
            Chiria_MarchWithdrawals2020,
            Chiria_AprilWithdrawals2020,
            Chiria_MayWithdrawals2020,
            Chiria_JuneWithdrawals2020,
            Chiria_JulyWithdrawals2020,
            Chiria_AugustWithdrawals2020,
            Chiria_SeptemberWithdrawals2020,
            Chiria_OctoberWithdrawals2020,
            Chiria_NovemberWithdrawals2020 };



    // Son
    double Bot_Total = 202.64;
    double Bot_Checking = 51.14;
    double Bot_Saving = 48.15;
    double Bot_CitiCard = 1917.41;  // available credit $282.00 -- $51.17 due 1/7/21
    double Bot_MartCard = 221.30;   // available credit $978.70 -- $28.00 due 1/5/21
    double Bot_TireCard = 390.83;   // available credit $809.00 -- $27.00 due 1/1/21
    double Bot_BankCard = 398.69;   // available credit $2,101.31 -- $35.00 due 1/11/21
    // Total Debt........$2,928.23
    //
    double Bot_Debt = (Bot_CitiCard + Bot_MartCard + Bot_TireCard + Bot_BankCard);
    //
    double Bot_MayPaychecks2020 = 1156.71;
    double Bot_JunePaychecks2020 = 1884.60;
    double Bot_JulyPaychecks2020 = 3294.65;
    double Bot_AugustPaychecks2020 = 271.49;
    //
    double[] Bot_MonthlyPaychecks2020 = {
            Bot_MayPaychecks2020,
            Bot_JunePaychecks2020,
            Bot_JulyPaychecks2020,
            Bot_AugustPaychecks2020 };
    //
    double Bot_AugustWithdrawals2020 = 643.11;
    double Bot_SeptemberWithdrawals2020 = 416.42;
    double Bot_OctoberWithdrawals2020 = 378.40;
    double Bot_NovemberWithdrawals2020 = 775.75;
    double Bot_DecemberWithdrawals2020 = 440.41;
    //
    double[] Bot_MonthlyWithdrawals2020 = {
            Bot_AugustWithdrawals2020,
            Bot_SeptemberWithdrawals2020,
            Bot_OctoberWithdrawals2020,
            Bot_NovemberWithdrawals2020,
            Bot_DecemberWithdrawals2020 };



    // Bro
    double Binty_Checking = 621.26;


    // Dad
    double Dad_Checking = 0.0;


    // Family
    double allMoney = Chiria_Total + Bot_Total + Binty_Checking + Dad_Checking;


}

// Main Method
public class Household extends WorldBank {

    // Create a Scanner
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // Create a WorldBank object
        WorldBank Suhail = new WorldBank();
        String output;

        System.out.println("\nTOTALS:");
        System.out.println("//");
        //
        System.out.printf("$ %,.2f %26s\n", Suhail.Bot_Debt, " - Bot's Credit Card Debt");
        System.out.printf("$ %,.2f %23s\n", Suhail.Bot_Total, " - Bot's Total Money");
        System.out.printf("$ %,.2f %25s\n", Suhail.Binty_Checking, " - Binty's Total Money");
        System.out.printf("$ %,.2f %10s\n", Suhail.Chiria_Total, " - Chiria's Total Money");
        System.out.printf("$ %,.2f %23s\n", Suhail.allMoney, " - Household Total Money");

        //
        System.out.println("//");
        //
        System.out.printf("$ %,.2f %s\n", whileLoop(Suhail.Chiria_MonthlyDeposits2020),
                " - Money Chiria made in 2020");
        System.out.printf("$ %,.2f %s\n", whileLoop(Suhail.Chiria_MonthlyBills2020),
                " - Money Chiria spent on Bills in 2020");
        System.out.printf("$ %,.2f %s\n", whileLoop(Suhail.Chiria_MonthlyWithdrawals2020),
                " - Money Chiria spent in total in 2020");
        System.out.printf("$ %,.2f %s\n",
                whileLoop(Suhail.Chiria_MonthlyDeposits2020) - whileLoop(Suhail.Chiria_MonthlyWithdrawals2020),
                " - Money Chiria should have after taxes 2020");
        //
        System.out.println("//");
        //
        System.out.printf("$ %,.2f %s\n",
                whileLoop(Suhail.Chiria_MonthlyDeposits2020)/Suhail.Chiria_MonthlyDeposits2020.length,
                "  - AVG Money Chiria makes per month");
        System.out.printf("$ %,.2f %s\n",
                whileLoop(Suhail.Chiria_MonthlyBills2020)/Suhail.Chiria_MonthlyBills2020.length,
                "  - AVG Money Chiria spends on bills per month");
        System.out.printf("$ %,.2f %s\n",
                whileLoop(Suhail.Chiria_MonthlyWithdrawals2020)/Suhail.Chiria_MonthlyWithdrawals2020.length,
                "  - AVG Money Chiria spends on all expenses per month");
        System.out.printf("$ %,.2f %s\n",
                whileLoop(Suhail.Chiria_MonthlyDeposits2020)/Suhail.Chiria_MonthlyDeposits2020.length -
                        whileLoop(Suhail.Chiria_MonthlyWithdrawals2020)/Suhail.Chiria_MonthlyWithdrawals2020.length,
                "  - AVG Money Chiria has extra per month");
        //
        System.out.println("//");
        //
        System.out.printf("$ %,.2f %33s\n", whileLoop(Suhail.Bot_MonthlyPaychecks2020)/Suhail.Bot_MonthlyPaychecks2020.length,
                "- AVG Money Bot makes per month");
        System.out.printf("$ %,.2f %36s\n", whileLoop(Suhail.Bot_MonthlyWithdrawals2020)/Suhail.Bot_MonthlyWithdrawals2020.length,
                " - AVG Money Bot spends per month");

        // Run a while loop.
        System.out.print("\nEnter 0 to stop loop");
        System.out.printf("$%,.2f %s\n", whileLoop(), " - Total");

    }

    // returns a sum of double inputs
    public static double whileLoop() {
        // Function Variables
        double x = 0.0;
        double total = 0.0;

        System.out.println();
        // Get inputs
        do {
            try {
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


    // returns the sum of a double array
    public static double whileLoop(double[] array) {
        // Function variables
        double total = 0.0;

        for (double x : array) {
            total += x;
        }

        // return a double.
        return total;
    }


    // returns a double
    public static double doublesWhileLoop(double...args) {
        // Function variables
        double total = 0.0;

        for (double x : args) {
            total += x;
        }

        // return a double.
        return total;
    }

}


