package app;

// library imports
import java.util.Scanner;
import java.util.ArrayList;

public class Main 
{
	// COlORS (not working ?)
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
    
    
    // main method
    public static void main(String[] args)
    {
        // Scanner object
        Scanner in = new Scanner(System.in);
        
        // local variables 
        String userChoice = ""; 
        
        // arrays 
        ArrayList<SalableProduct> products = new ArrayList<>(); 
        ArrayList<SalableProduct> shoppingCart = new ArrayList<>(); 
        // 
        ArrayList<Weapon> weapons = new ArrayList<>(); 
        ArrayList<Armor> armors = new ArrayList<>(); 
        ArrayList<Health> healths = new ArrayList<>(); 
 
        // display welcome message
        System.out.println("\nWelcome to the World of Warcraft (WoW) Armory store!");
        
        do 
        { 
        	newline(); 
        	printMenu(); 
        	try
        	{
        		userChoice = in.nextLine(); newline(); 
        		switch( userChoice.trim() )
        		{
        			case "1":
        				viewInventory(); 
        				break;
        				
        			case "2": 
        				manageInventory(); 
        				break;
        				
        			case "3": 
        				viewCart(); 
        				break;
        				
        			case "4": 
        				System.out.println("You are now exiting the program...Good-bye!"); 
        				System.exit(0);
        				
        			case "":
        				System.out.println("Input cannot be blank! Try again."); 
        				break;
        				
        			default:
        				System.out.println("Something invalid was entered, try again!"); 
        				break; 
        		}
        	}
        	catch (Exception e)
        	{
        		System.out.println("You entered something invalid, try again."); 
        		in.next();
        	} 
        	
        } while ( userChoice != "4" ); 
        

        /*
        
        // Instantiate some objects
        Weapon weapon1 = new Weapon();
        weapon1.setName("Recruit's Decapitator of the Quickblade");
        weapon1.setDescription("Soulbound Two-Handed Axe dealing 53-111 damage with an iLvl 120.");
        weapon1.setPrice(8757.50);
        weapon1.setQuantity(5);
        //
        Armor armor1 = new Armor();
        armor1.setName("Ceremonious Helm");
        armor1.setDescription("Plate armor, worn on head, soulbound with iLvl 117.");
        armor1.setPrice(3861.80);
        armor1.setQuantity(1);
        //
        Health health1 = new Health();
        health1.setName("Spiritual Healing Potion");
        health1.setDescription("Restores 10,000 health. (5 Min Cooldown)");
        health1.setPrice(75.00);
        health1.setQuantity(3);

        // print some output
        System.out.printf("%s%n%s%n%s%n", weapon1, armor1, health1);
        
        */

    } // end of main 
    
	
    /* functions */ 
    
    // utility functions 
    public static void newline() {System.out.println();}
    public static void newline(int x) { for(int i=0;i<x;i++) newline(); }
    
    // print menu function 
    public static void printMenu()
    {
    	System.out.println("Make a selection:\n" +
    						"(1) : View Store Inventory\n" +
    						"(2) : Manage Store Inventory\n" +
    						"(3) : View Shopping Cart\n" + 
    						"(4) : Exit"); 
    }
    
    // view store inventory function 
    public static void viewInventory()
    {
    	System.out.println("You chose to 'view' store inventory!"); 
    }
    
    // manage store inventory function 
    public static void manageInventory()
    {
		System.out.println("You chose to 'manage' store inventory!"); 
    }
    
    // view shopping cart function 
    public static void viewCart()
    {
		System.out.println("You chose to 'view' shopping cart!");
    }
}


/* +-----------------------+
 * | Project Requirements: |
 * +-----------------------+
 * 
 * 
 * 1 -- Console Store Front application features.
 * 
 * 2 -- Inventory Manager application features. 
 * 
 * 3 -- Weapon, Armor, and Health will be derived classes from superclass SalableProduct. 
 * 
 * 4 -- Create an initial inventory of SalableProducts that includes 2 different kinds of Weapons, 2 different kinds of armor, and Health.
 * 
 * 5 -- Update the methods used to support the purchasing and canceling of a Salable Product as necessary.
 * 
 * 6 -- Draw a flow chart of the logic of a Game User interacting with the Store Front.
 * 
 * 7 -- The Store Front application features must: 
 * 		a) Display the name of the Store Front & a Welcome Message to the console.
 * 		b) Display a list of actions for the User to interact with the Store Front.
 * 		c) Execute a desired Store Front action based on keyboard entry from the User.
 * 		d) Display appropriate detailed feedback & error messages to User through the console.
 * 
 * 8 -- Implement the code for all UML class diagrams. 
 * 
 * 9 -- Document all code using JavaDoc documentation standards and generate the JavaDoc files.
 * 
 * 10 -- Create a screencast video 8–10 minutes long.
 * 
 * 
 */
