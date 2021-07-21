/*
Author: Shazeb Suhail
Date:   7-20-21
Time:   11:00 PM
 */
import java.util.Scanner;

public class Random2 {

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


    // Main method.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // local variables
        boolean check = true;

        do {
            System.out.println(yellow + "Store Menu" + reset);
            displayMenu();

            System.out.print("Pick a store: ");
            String storeNum = input.nextLine();

            // switch menu
            switch (storeNum) {
                case "1":
                    System.out.println("You chose " +
                            green + "Aldi's" + reset + "!");
                    break;
                case "2":
                    System.out.println("You chose " +
                            green + "Albertsons" + reset + "!");
                    break;
                case "3":
                    System.out.println("You chose " +
                            green + "Rio Ranch Market" + reset + "!");
                    break;
                default:
                    System.out.println(yellow + "Incorrect input! " +
                            "Menu is now closed." + reset);
                    check = false;
                    break;
            }
            newline();
        } while (check != false);


        // End Program Tag.
        System.out.print(red + "Program has ended." + reset);
        System.exit(999);
    }

    // Function List

    // display menu function
    public static void displayMenu() {
        System.out.print(cyan);
        System.out.println("1. Aldis");
        System.out.println("2. Albertsons");
        System.out.println("3. Rio Ranch Market");
        System.out.print(reset);
    }

    // newline function
    public static void newline() {System.out.println();}
    public static void newline(int n) { for(int i=0;i<n;i++)newline();}
}
