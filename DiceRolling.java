// Author: SHAZEB SUHAIL
/*
(Dice Rolling) Write an application to stimulate the rolling of two dice. The application should use an object of class
Random once to roll the first die and again to roll the second die. The sum of the two values should then be
calculated. Each die can show an integer value from 1 to 6, so the sum of the values will vary from 2 to 12, with 7
being the most frequent sum, and 2 and 12 lest frequent. Figure 6.18 shows the 36 possible combinations of the two
dice. Your application should roll the dice 36,000,000 times. Use a one-dimensional array to tally the number of times
each possible sum appears. Display the results in tabular format.
 */
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DiceRolling {
    // create random number generator for use in method rollDice.
    private static final Random randomNumbers = new Random();

    // Main Method.
    public static void main(String[] args) {
        // Variable Declaration.
        int diceSum;
        //
        // Create an array to hold sum of dice frequency
        int[] array = new int[13];

        // for loop 36,000,000 times
        for (int count = 0; count < 36_000_000; count++) {
            // Return sum of two random dice values from method call.
            diceSum = rollDice();

            // Increment the correct array element equal to the dice sum.
            ++array[diceSum];
        }

        // Output the results in Tabular form.
        System.out.printf("%n%3s%10s%n", "Sum ", "Frequency");
        for (int count = 2; count < array.length; count++) {
            System.out.printf("%3d%11d%n", count, array[count]);
        }
32
        // Output End Prompts with Local Date/Time
        System.out.printf("\nThank You for using the Dice Rolling Application.\n");
        System.out.printf("Time of Calculation is <");

        // Get local date and time
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d, YYYY h:mm a");
        System.out.print(dtf.format(localDate));
        System.out.println(">");

        // Last Statement of the Program.
        System.exit(0);
    }

    // Method 1
    public static int rollDice() {
        // pick random die values.
        int die1 = 1 + randomNumbers.nextInt(6);    // first die roll
        int die2 = 1 + randomNumbers.nextInt(6);    // second die roll

        int sum = die1 + die2;  // sum of die values

        return sum;
    }
}
