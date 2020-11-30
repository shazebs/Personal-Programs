// Author: SHAZEB SUHAIL | Date: 9/18/20
/*
(Calculating Sales) - Assignment #3
An online retailer sells five products whose retail prices are as follows:
    Product 1, $2.98
    Product 2, $4.50
    Product 3, $9.98
    Product 4, $4.49
    Product 5, $6.87
Write an application that reads a series of pairs of numbers as follows:
    a) product number
    b) quantity sold
Your program should use a switch statement to determine the retail price for each product.
It should calculate and display the total retail value of all products sold. Use a
sentinel-controlled loop to determine when the program should stop looping and
display the final results.
 */
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Calculating_Sales {
    public static void main(String [] args) {
        // Scanner declared.
        Scanner input = new Scanner(System.in);

        // variable declarations
        int product_number, quantity_sold;
        double caseTotal, productPrice;     // Used within the switch case
        double mainTotal = 0.0;             // To hold total for all products.
        int incrementCounter = 0;


        // Display Product number and prices.
        System.out.printf("%n%s%n%s%n %s%n %s%n %s%n %s%n %s%n",
                "Product Catalog",
                "---------------",
                "1) $2.98",
                "2) $4.50",
                "3) $9.98",
                "4) $4.49",
                "5) $6.87");
        System.out.println("-------------------------------------------");

        //--------------------------------------------------------------------------------------------------------------
        // Begin do...while loop.
        //--------------------------------------------------------------------------------------------------------------
        do {
            // Get product_number input from user.
            System.out.print("(Enter 0 to see Total) or Enter Product (1-5): ");
            product_number = input.nextInt();

            // Input validation
            while (product_number < 0 | product_number > 5) {
                System.out.print("ERROR: (Enter 0 to see Total) or Enter Product (1-5): ");
                product_number = input.nextInt();
            }

            //----------------------------------------------------------------------------------------------------------
            // Begin Switch.
            switch(product_number) {
                //------------------------------------------------------------------------------------------------------
                case 1:
                    System.out.print("Enter quantity sold: ");
                    quantity_sold = input.nextInt();

                    // Input Validation if user enters a negative int input.
                    while (quantity_sold < 0) {
                        System.out.print("ERROR: Quantity sold cannot be less than 0! Enter quantity sold: ");
                        quantity_sold = input.nextInt();
                    }

                    // Calculate
                    productPrice = 2.98;     // Price of product 1
                    caseTotal = (double) productPrice * quantity_sold;
                    mainTotal += caseTotal;
                    incrementCounter++;
                    break;
                //------------------------------------------------------------------------------------------------------
                case 2:
                    System.out.print("Enter quantity sold: ");
                    quantity_sold = input.nextInt();

                    // Input Validation if user enters a negative int input.
                    while (quantity_sold < 0) {
                        System.out.print("ERROR: Quantity sold cannot be less than 0! Enter quantity sold: ");
                        quantity_sold = input.nextInt();
                    }

                    // Calculate
                    productPrice = 4.50;     // Price of product 1
                    caseTotal = (double) productPrice * quantity_sold;
                    mainTotal += caseTotal;
                    incrementCounter++;
                    break;
                //------------------------------------------------------------------------------------------------------
                case 3:
                    System.out.print("Enter quantity sold: ");
                    quantity_sold = input.nextInt();

                    // Input Validation if user enters a negative int input.
                    while (quantity_sold < 0) {
                        System.out.print("ERROR: Quantity sold cannot be less than 0! Enter quantity sold: ");
                        quantity_sold = input.nextInt();
                    }

                    // Calculate
                    productPrice = 9.98;     // Price of product 1
                    caseTotal = (double) productPrice * quantity_sold;
                    mainTotal += caseTotal;
                    incrementCounter++;
                    break;
                //------------------------------------------------------------------------------------------------------
                case 4:
                    System.out.print("Enter quantity sold: ");
                    quantity_sold = input.nextInt();

                    // Input Validation if user enters a negative int input.
                    while (quantity_sold < 0) {
                        System.out.print("ERROR: Quantity sold cannot be less than 0! Enter quantity sold: ");
                        quantity_sold = input.nextInt();
                    }

                    // Calculate
                    productPrice = 4.49;     // Price of product 1
                    caseTotal = (double) productPrice * quantity_sold;
                    mainTotal += caseTotal;
                    incrementCounter++;
                    break;
                //------------------------------------------------------------------------------------------------------
                case 5:
                    System.out.print("Enter quantity sold: ");
                    quantity_sold = input.nextInt();

                    // Input Validation if user enters a negative int input.
                    while (quantity_sold < 0) {
                        System.out.print("ERROR: Quantity sold cannot be less than 0! Enter quantity sold: ");
                        quantity_sold = input.nextInt();
                    }

                    // Calculate
                    productPrice = 6.87;     // Price of product 1
                    caseTotal = (double) productPrice * quantity_sold;
                    mainTotal += caseTotal;
                    incrementCounter++;
                    break;
            }

        } while (product_number != 0);
        //--------------------------------------------------------------------------------------------------------------


        // Run this code if user did not enter any products.
        if (incrementCounter == 0) {
            System.out.println("You did not enter any products.");
        }
        else {
            System.out.printf("\nTotal Sales for all products sold: $%,.2f%n", mainTotal);
        }

        //--------------------------------------------------------------------------------------------------------------
        // End Code.
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(".\n.\n.\nThank you for using the Calculating Sales application.");
        System.out.print("Time of calculation is <");
        // Get Local Date and Time.
        LocalDateTime localDate = LocalDateTime.now();
        // Format the localDate output.
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d, YYYY h:mm a");
        // Print the formatted Date and Time.
        System.out.print(dtf.format(localDate));
        System.out.println(">");
        System.exit(0);
        //--------------------------------------------------------------------------------------------------------------
    }
}
