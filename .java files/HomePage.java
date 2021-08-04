/*
Author: Shazeb Suhail
Date:   7/30/21
Time:   11:42 PM
 */

// Import Libraries
import java.util.Scanner;

public class HomePage {

    // Colors
    public static final String reset = "\u001B[0m";
    public static final String black = "\u001B[30m";
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";
    public static final String purple = "\u001B[35m";
    public static final String cyan = "\u001B[36m";
    public static final String white = "\u001B[37m";

    // Global Variables.
    static LinkNode head = null;

// Start of Main Method. 
    public static void main(String[] args) {
        // Create Scanner object
        Scanner in = new Scanner(System.in);


        boolean loopCondition = true;
        do {
            try {
                System.out.println("\n" + yellow + "Main Menu:" + reset);
                System.out.println("1. Calendar");          // My schedule
                System.out.println("2. Coin Calculator");   // Finances
                System.out.println("3. Workout Logs");      // "Exercising Journey"
                System.out.println("4. Macronutrients");    // Nutrition
                System.out.println("5. Blog Posts");        // Social Media / Online Journal
                System.out.println("6. Contact List");     // Telephone & Address Book
                System.out.println("7. " + green + "Sleep Schedule" + reset);    // Sleep Schedule
                System.out.print(yellow + "Make a selection: " + reset);
                String select = in.nextLine();

                switch(select) {
                    case "1":
                        calendar();
                        break;
                    case "2":
                        coinCalculator();
                        break;
                    case "3":
                        workoutLogs();
                        break;
                    case "4":
                        macronutrients();
                        break;
                    case "5":
                        blogPosts();
                        break;
                    case "6":
                        contactList();
                        break;
                    case "7":
                        sleepSchedule();
                        break;
                    default:
                        System.out.println(red + "Program does not understand user's input. Good-bye." + reset);
                        loopCondition = false;
                        break;
                }
            }
            catch (Exception e) {
                System.err.println("Some error occurred!");
                loopCondition = false;
            }
        } while (loopCondition != false);

        System.exit(999);

    } // End of main method.

    // Utility Functions.

    // 'Print link list' function.
    public static void printList() {
        LinkNode next = head;
        int count=1;
        while(next != null) {
            System.out.print(yellow + count++ +". ");
            System.out.println(next.data + reset);
            next = next.nodePtr;
        }
    }
    // Add node to a link list function.
    public static void addNode(LinkNode head, LinkNode newNode) {
        LinkNode next = head;
        while(next.nodePtr != null)
            next = next.nodePtr;
        // End of list has been reached, insert node.
        next.nodePtr = newNode;
    }
    // Return a newly created node.
    public static LinkNode createNode(String data) {
        LinkNode temp = new LinkNode(data);
        return temp;
    }



    // Switch Menu Functions.

    // 1. Calendar (function)
    public static void calendar() {
        System.out.println("\nYou are now in the Calendar Tab.");
        System.out.println("You are now exiting Calendar Tab, good-bye.");
    }
    // 2.
    public static void coinCalculator() {
        System.out.println("\nYou are now in the Coin Calculator Tab.");
        System.out.println("You are now exiting Coin Calculator Tab, good-bye.");
    }
    // 3.
    public static void workoutLogs() {
        System.out.println("\nYou are now in the Workout Logs Tab.");
        System.out.println("You are now exiting Workout Logs Tab, good-bye.");
    }
    // 4.
    public static void macronutrients() {
        System.out.println("\nYou are now in the Macronutrients Tab.");
        System.out.println("You are now exiting Macronutrients Tab, good-bye.");
    }
    // 5.
    public static void blogPosts() {
        System.out.println("\nYou are now in the Blog Posts Tab.");
        System.out.println("You are now exiting Blog Posts Tab, good-bye.");
    }
    // 6.
    public static void contactList() {
        System.out.println("\nYou are now in the Contact List Tab.");
        System.out.println("You are now exiting Contact List Tab, good-bye.");
    }
    // 7. Sleep Schedule (function)
    public static void sleepSchedule() {
        // Entry message.
        System.out.println("\nYou are now in the Sleep Schedule Tab.");

        LinkNode node1 = new LinkNode(); // create the first node.
        node1.data = "08/01/2021: 02:11 PM - Sunday"; // initialize the first node.
        head = node1; // set head node of the list.
        // Now add nodes.
        // Week 1.
        addNode(head, createNode("08/02/2021: 06:00 AM - Monday"));
        addNode(head, createNode("08/03/2021: 06:01 AM - Tuesday"));
        addNode(head, createNode("08/04/2021: 06:01 AM - Wednesday"));
        addNode(head, createNode("08/05/2021: 06:02 AM - Thursday"));
        addNode(head, createNode("08/06/2021: 06:03 AM - Friday"));
        addNode(head, createNode("08/07/2021: 06:04 AM - Saturday"));
        addNode(head, createNode("08/08/2021: 06:04 AM - Sunday"));
        // Week 2.
        addNode(head, createNode("08/09/2021: 06:05 AM - Monday"));
        addNode(head, createNode("08/10/2021: 06:06 AM - Tuesday"));
        addNode(head, createNode("08/11/2021: 06:07 AM - Wednesday"));
        addNode(head, createNode("08/12/2021: 06:07 AM - Thursday"));
        addNode(head, createNode("08/13/2021: 06:08 AM - Friday"));
        addNode(head, createNode("08/14/2021: 06:09 AM - Saturday"));
        addNode(head, createNode("08/15/2021: 06:09 AM - Sunday"));
        // Week 3.
        addNode(head, createNode("08/16/2021: 06:10 AM - Monday"));
        addNode(head, createNode("08/17/2021: 06:11 AM - Tuesday"));
        addNode(head, createNode("08/18/2021: 06:12 AM - Wednesday"));
        addNode(head, createNode("08/19/2021: 06:12 AM - Thursday"));
        addNode(head, createNode("08/20/2021: 06:13 AM - Friday"));
        addNode(head, createNode("08/21/2021: 06:14 AM - Saturday"));
        addNode(head, createNode("08/22/2021: 06:14 AM - Sunday"));
        // Week 4.
        addNode(head, createNode("08/23/2021: 06:15 AM - Monday"));
        addNode(head, createNode("08/24/2021: 06:16 AM - Tuesday"));
        addNode(head, createNode("08/25/2021: 06:16 AM - Wednesday"));
        addNode(head, createNode("08/26/2021: 06:17 AM - Thursday"));
        addNode(head, createNode("08/27/2021: 06:18 AM - Friday"));
        addNode(head, createNode("08/28/2021: 06:19 AM - Saturday"));
        addNode(head, createNode("08/29/2021: 06:19 AM - Sunday"));
        // Week 5.
        addNode(head, createNode("08/30/2021: 06:20 AM - Monday"));
        addNode(head, createNode("08/31/2021: 06:21 AM - Tuesday"));


        // Print the list.
        printList();

        // Goodbye.
        System.out.println("You are now leaving the Sleep Schedule Tab. Goodbye!");
    }

}


