/*☺☺
Author: Shazeb Suhail
Date:   5-26-21
Time:   N/a
 */

// import libraries
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.lang.String;
import java.util.List;


public class WeightGainLinkList
{
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


    // Create a Scanner object.
    Scanner in = new Scanner(System.in);


    // Global Constants,
    static double initialWeight = 141.20; // lbs
    static double initialWeightInKG = initialWeight / 2.205;
    static double endGoalWeight = 150.00; // lbs
    static double endGoalWeightinKG = endGoalWeight / 2.205;


    ///////////////////////////////////////////////////////////////////////////////////////////
    // Main Method ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////

    // Start of Main Method.
    public static void main(String[] args) {

        // Print Initial Weight Details
        System.out.print(blue + "Welcome to Shazeb's 'Weight_Gain_Linked_List.java' Program!" );
        System.out.println("\n------------------------------------------------------------");
        System.out.print(green + "Gameplan:"+ reset);
        printWeightDetails();
        System.out.println(blue + "------------------------------------------------------------" + reset);

        // Display Daily Weight Updates.
        System.out.println(green + "Notifications:" + reset);
        System.out.println(cyan + "Daily Weight Updates (in lbs):" + reset);
        DataNode h1_head = printDailyWeightUpdates();
        printLinkList(h1_head);

        // Display Progress on Weight Gain.
        DataNode h1_tail = getTail(h1_head);
        displayProgress(h1_tail);


        // Exit Program.
        System.out.println(blue + "------------------------------------------------------------" + reset);
        System.out.print(yellow + "The program executed perfectly." + reset);
        // Get local date and time
        System.out.print(" <");
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d, YYYY h:mm a");
        System.out.print(dtf.format(localDate));
        System.out.println(">");
        System.exit(999);

    } // End of Main Method.


    //////////////////////////////////////////////////////////////////////////////////////
    // Functions List ////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////

    // printDailyWeightUpdates() function implementation
    public static DataNode printDailyWeightUpdates()
    {
        // DataNode Version 1
        DataNode head1 = new DataNode("5-26-21", 141.2);
        // Now update regularly.
        addNode(head1,createNode("5-28-21", 142.6));
        addNode(head1,createNode("5-30-21", 143.8));
        addNode(head1,createNode("5-31-21", 145.0));
        addNode(head1,createNode("6-2-21", 147.6));
        addNode(head1,createNode("6-3-21", 143.2));
        addNode(head1,createNode("6-8-21", 142.0));
        addNode(head1,createNode("6-14-21", 141.8));

        // Return the head of the list.
        return head1;
    }




    // newline
    public static void newline(){System.out.println();}
    public static void newline(int n){for (int i = 0; i < n; i++) newline();}

    // display progress
    public static void displayProgress(DataNode tail) {
        // Do some calculations.
        if (tail.data >= endGoalWeight)
        {
            System.out.print(green);
            System.out.printf(
                    "You are %.2f lbs above to %.2f lbs.\n",
                    (tail.data - endGoalWeight), endGoalWeight);
            System.out.print(reset);
        }
        else {
            System.out.print(red);
            System.out.printf(
                    "You are %.2f lbs below %.2f\n",
                    (endGoalWeight - tail.data), endGoalWeight);
            System.out.print(reset);
        }
    }

    // get tail
    public static DataNode getTail(DataNode listHead) {
        DataNode iterator = listHead;
        while(iterator != null){
            if(iterator.nodePtr == null){
                return iterator;
            } else {
                iterator = iterator.nodePtr;
            }
        }
        return null;
    }

    // print initial weight details
    public static void printWeightDetails()
    {
        // Display initial weight in lbs and kg
        System.out.println(cyan + "\nInitial Weight:" + reset);
        System.out.printf("%-6.2f lbs\n", initialWeight);
        System.out.printf("%-6.2f kg\n", initialWeightInKG);

        // Display end weight in lbs and kg
        System.out.println(cyan + "End Weight Goals:" + reset);
        System.out.printf("%-6.2f lbs\n", endGoalWeight);
        System.out.printf("%-6.2f kg\n", endGoalWeightinKG);

        // Display the difference between the weights.
        System.out.println(cyan + "Amount of weight I want to gain:" + reset);
        System.out.printf("%-6.2f lbs \n%-6.2f kg\n",
                endGoalWeight - initialWeight,
                endGoalWeightinKG - initialWeightInKG);
    }

    // return a newly created DataNode
    public static DataNode createNode(String date, double data) {
        DataNode newNode = new DataNode(date, data);
        return newNode;
    }

    // add to an existing DataNode
    public static void addNode(DataNode listHead, DataNode newNode) {
        DataNode temp = listHead;
        while(temp.nodePtr != null)
            temp = temp.nodePtr;
        temp.nodePtr = newNode;
    }

    // add to an existing LinkNode
    public static void addNode(LinkNode listHead, LinkNode newNode) {
        LinkNode temp = listHead;
        while(temp.nodePtr != null)
            temp = temp.nodePtr;
        // End of list has been reached, insert node.
        temp.nodePtr = newNode;
    }

    // return a newly created LinkNode
    public static LinkNode createNode(String data) {
        LinkNode temp = new LinkNode(data);
        return temp;
    }

    // print LinkNode list
    public static void printLinkList(LinkNode link1) {
        // Display the LinkList.
        LinkNode temp = link1;
        while(temp != null) {
            System.out.println(temp.data + " lbs");
            temp = temp.nodePtr;
        }
        System.out.println();
    }

    // print DataNode list
    public static void printLinkList(DataNode link1) {

        // Display the List.
        DataNode iterator = link1;

        while(iterator != null) {

            System.out.printf("%-10s: %.2f\n", iterator.name, iterator.data);
            iterator = iterator.nodePtr;

        }
    }

    /*
    // printColoredLinkList() function implementation
    public static void printColoredLinkList(LinkNode link1) {
        // Display the LinkList.
        LinkNode temp = link1;
        while(temp != null) {
            System.out.println(temp.data + " lbs");
            temp = temp.nodePtr;
        }
        System.out.println();
    } */

} // End of WeightGainLinkList.java



//////////////////////////////////////////////////////////////////////////////////////
// Project Classes ///////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////

// CLASS: DataNode
class DataNode {
    String name;
    double data;
    DataNode nodePtr;

    // Constructor
    DataNode() { nodePtr = null; }

    // Constructor passing 'String' only
    DataNode(String name) {
        this.name = name;
        nodePtr = null;
    }

    // Constructor passing a 'double' only
    DataNode(double data) {
        this.data = data;
        nodePtr = null;
    }

    // Constructor passing a 'String' and 'double'
    DataNode(String name, double data){
        this.name = name;
        this.data = data;
        nodePtr = null;
    }

    // LinkNode operations.
    // ...

} // End of DataNode class.
