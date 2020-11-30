// Author: SHAZEB SUHAIL
/*
(Craps Game Modification)
Modify the craps program of Fig. 5.8 to allow wagering. Initialize variable bankBalance to 1000 dollars. Prompt the
player to enter a wager. Check that wager is less than or equal to bankBalance, and if it's not, have the user reenter
wager until a valid wager is entered. Then, run one game of craps. If the player wins, increase bankBalance by wager
and display the new bankBalance. If the player loses, decrease bankBalance by wager, display the new bankBalance, check
whether bankBalance has become zero and, if so, display the message "Sorry. You busted!" As the game progresses, display
various messages to create some "chatter," such as "Oh, you're going for broke, huh?" or "Aw c'mon, take a chance!" or
"You're up big. Now's the time to cash in your chips!". Implement the "chatter" as a separate method that randomly
chooses the string to display.
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.security.SecureRandom;

public class Craps_Modification {
    // Create Random number generator
    private static final SecureRandom randomNumbers = new SecureRandom();

    // enum type with constants that represent the game status
    private enum Status {CONTINUE, WON, LOST};

    // constants that represent common rolls of the dice
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    public static void main(String[] args) {
        // Create Scanner
        Scanner input = new Scanner(System.in);

        // Variables
        double bankBalance = 1000.00;
        double wager;
        int chatVal;    // temporary value to call chatter method.

        // Display beginning bankBalance.
        System.out.printf("Beginning Bank Balance: $%.2f%n", bankBalance);

        // Start of Do while -----------------------------------------------------------------------------------------------
        do {
            // Enter first wager.
            System.out.print("Enter an amount to Bet (or enter 0 to cash out): $");
            wager = input.nextDouble();
            if (wager == 0) {
                break;
            }

            // Wager Input validation
            //---------------------------------------------------------------------------------------
            while (wager > bankBalance | wager < 0) {
                while (wager > bankBalance) {   // If player enters a wager that exceeds bankBalance.
                    System.out.println("ERROR! You do not have enough funds to wage that!");
                    System.out.print("Enter a new bet: $");
                    wager = input.nextDouble();
                }
                while (wager < 0) { // If player enters a negative wager amount.
                    System.out.println("ERROR! You cannot wage a negative amount!");
                    System.out.print("Enter a new bet: $");
                    wager = input.nextDouble();
                }
            }
            //---------------------------------------------------------------------------------------


            // Run a game of Craps.
            int myPoint = 0;    // point if no win or loss on first roll.
            Craps_Modification.Status gameStatus;  // can contain CONTINUE, WON, OR LOST.

            chatter(wager,bankBalance); // Make some chatter.

            int sumOfDice = rollDice(); // Method "Function" Call to return dice roll sum.

            // Determine game status and point based on first roll.
            switch (sumOfDice) { //--------------------------------
                case SEVEN:
                case YO_LEVEN:
                    gameStatus = Craps_Modification.Status.WON;
                    break;
                case SNAKE_EYES:
                case TREY:
                case BOX_CARS:
                    gameStatus = Craps_Modification.Status.LOST;
                    break;
                default:
                    gameStatus = Craps_Modification.Status.CONTINUE;
                    myPoint = sumOfDice;
                    System.out.printf("Point is %d%n", myPoint);
                    break;
            } //----------------------------------------------------

            // while game is not complete
            while (gameStatus == Craps_Modification.Status.CONTINUE) {
                sumOfDice = rollDice();

                // determine game status
                if (sumOfDice == myPoint) {
                    gameStatus = Craps_Modification.Status.WON;
                } else {
                    if (sumOfDice == SEVEN) {
                        gameStatus = Craps_Modification.Status.LOST;
                    }
                }
            }

            // display won or lost message.
            if (gameStatus == Craps_Modification.Status.WON) {
                System.out.println("Player Wins");
                bankBalance += wager;
                chatVal = 1;
                chatter(chatVal);
            } else {
                System.out.println("Player loses");
                bankBalance -= wager;
            }

            // Display new bankBalance.
            System.out.printf("\nNew Bank Balance: $%.2f%n", (double) bankBalance);

        } while (bankBalance != 0 ); // End of Do While ---------------------------------------------------------------------

        // If player's bankBalance reaches $0.00
        if (bankBalance == 0) {
            System.out.println("Sorry. You Busted!");
        }
        else {
            if (wager == 0) {
                System.out.printf("\nCongrats! You Cashed Out with $%.2f%n", bankBalance);
            }
        }

        // End Code Prompts.
        //==================================================================================
        System.out.printf("\nThank you for using the Casino application.\n"); //
        System.out.printf("Time of calculation is <");                                    //
        // Get Local Date and Time.                                                       //
        LocalDateTime localDate = LocalDateTime.now();                                    //
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, YYYY h:mm a");       //
        System.out.print(dtf.format(localDate));                                          //
        System.out.println(">");                                                          //
        //==================================================================================

        // Last Statement of the Program.
        System.exit(0);
    }

    //----------------------------------------------------------------------------------------------------------------------
// Roll dice, calculate sum and display results
    public static int rollDice() {
        // Pick random die values
        int die1 = 1 + randomNumbers.nextInt(6);
        int die2 = 1 + randomNumbers.nextInt(6);

        int sum = die1 + die2;
        System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);

        // Return the sum
        return sum;
    }

    //----------------------------------------------------------------------------------------------------------------------
    public static void chatter(double bet, double bal) {
        // Chatter for betting full amount of bankBalance.
        if (bet == bal) {
            // Pick a random value.
            int chatter = 1 + randomNumbers.nextInt(3);
            switch (chatter) {
                case 1:
                    System.out.printf("%n%s%n", "Going for broke, huh?");
                    break;
                case 2:
                    System.out.printf("%n%s%n", "Player is going ALL IN!");
                    break;
                case 3:
                    System.out.printf("%n%s%n", "May the luck of chance be with you.");
                    break;
            }
        }
    }

    public static void chatter(int chat) {
        // Method variables.
        int chatter;

        // Display some chatter if player wins.
        if (chat == 1) {
            // Pick a random value.
            chatter = 1 + randomNumbers.nextInt(3);
            switch (chatter) {
                case 1:
                    System.out.printf("%n%s", "Now's the time to Cash Out!");
                    break;
                case 2:
                    System.out.printf("%n%s", "You're up BIG now!");
                    break;
                case 3:
                    System.out.printf("%s%n", "You're on a HOT streak!");
                    break;
            }
        }
    }

} // End of Class.
