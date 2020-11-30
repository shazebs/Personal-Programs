// Author: SHAZEB SUHAIL | Date Created: 9/9/20

/*                    Program Two: Problem #3.17 on pg. 106
______________________________________________________________________________________
                                  (Gas Mileage)                                      |
-------------------------------------------------------------------------------------|
- Drivers are concerned with the mileage their automobiles get. One driver has kept  |
track of several trips by recording the miles driven and gallons used for each       |
tankful. Develop a Java application that will input the miles driven and gallons     |
used (both as integers) for each trip.                                               |
                                                                                     |
- The program should calculate and display the miles per gallon obtained for each    |
trip and print the combined miles per gallon obtained for all trips up to this       |
point. All averaging calculations should produce floating-point results. Use class   |
Scanner and sentinel-controlled iteration to obtain the data from the user.          |
_____________________________________________________________________________________|
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Gas {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        /* Variable Declarations.*/
        int miles_driven = 0,   // total miles entered
                gallons_used = 0,   // total gallons entered
                tripCounter = 0;    // increment variable


        // Beginning Prompts.
        //-------------------
        // Obtain miles driven and gallons used for the first trip.
        System.out.println("------------------------------------------------");
        System.out.printf("Enter miles driven for Trip [%d] (or -1 to quit): ", tripCounter+1);
        int miles = input.nextInt();


        // While Loop
        //--------------------------------------------------------------------------------------------------------------
        while (miles != -1) {                                                                                         //
            ++tripCounter;                                                                                            //
            // Get the gallons used for the trip.                                                                     //
            System.out.printf("Enter gallons used during Trip [%d]: ", tripCounter);                                  //
            int gallons = input.nextInt();                                                                            //
            //
            // Calculate the MPG.                                                                                     //
            double mpg = (double) miles / gallons;                                                                    //
            //
            // Display the trip's MPG.                                                                                //
            System.out.printf("MPG for Trip [%d]: %,.2f%n", tripCounter, mpg);                                        //
            System.out.println("------------------------------------------------");                                   //
            //
            // Running Totals for total miles_driven and total gallons_used.                                          //
            miles_driven += miles;                                                                                    //
            gallons_used += gallons;                                                                                  //
            //
            // Get miles_driven for the next trip or exit the while loop.                                             //
            System.out.printf("Enter miles driven for Trip [%d] (or -1 to quit): ", tripCounter+1);                   //
            miles = input.nextInt();                                                                                  //
        }                                                                                                             //
        //--------------------------------------------------------------------------------------------------------------


        // Display prompt for when user decides to quit the program.
        //----------------------------------------------------------
        if (miles == -1)
        { System.out.println("You decided to quit the program."); }


        // Display running totals and total MPG for all trips
        //---------------------------------------------------
        System.out.printf(".\n.\n.\nTotal Miles Driven: %d%n", miles_driven);
        System.out.printf("Total Gallons Used: %d%n", gallons_used);
        // Calculate total MPG for all trips
        double total_MPG = (double) miles_driven / gallons_used;
        System.out.printf("Total MPG for all Trips: %,.2f%n", total_MPG);


// End Code Prompts.
//==================================================================================
        System.out.printf(".\n.\n.\nThank you for using the Gas Mileage application.\n"); //
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
                }
