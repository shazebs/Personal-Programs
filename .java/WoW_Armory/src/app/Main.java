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
    
    
    // arrays 
    static ArrayList<SalableProduct> products = new ArrayList<>(); 
    static ArrayList<SalableProduct> shoppingCart = new ArrayList<>(); 
    // 
    static ArrayList<Weapon> weapons = new ArrayList<>(); 
    static ArrayList<Armor> armors = new ArrayList<>(); 
    static ArrayList<Health> healths = new ArrayList<>(); 
    
    // Scanner object
    static Scanner in = new Scanner(System.in);
    
    
    // main method
    public static void main(String[] args)
    {
        // local variables 
        String userChoice = ""; 
         
        // display welcome message
        System.out.println("----------------------------------------------------------"); 
        System.out.println("-- Welcome to the World of Warcraft (WoW) Armory store! --");
        System.out.println("----------------------------------------------------------"); 
        
        // initialize starting inventory
        initializeInventory(); 
        
        do 
        { 
        	newline(); 
        	printMenu(); 
        	try
        	{
        		// for Scanner input errors
        		if (in.hasNext())
        			in.reset(); 
        		
        		// read a menu input from user 
        		userChoice = in.next(); 
        		newline(); 
        		switch( userChoice )
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
        				System.out.println("You have exited the WoW Armory store...good-bye!"); 
        				System.exit(0);
        				break;
        				
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

    } // end of main 
    
	
    /* functions */ 
    
    // utility functions 
    public static void newline() {System.out.println();}
    public static void newline(int x) { for(int i=0;i<x;i++) newline(); }
    
    // print menu function 
    public static void printMenu()
    {
    	System.out.println("-- MAIN MENU --\nMake a selection:\n" +
    						"(1) : View Store Inventory\n" +
    						"(2) : Manage Store Inventory\n" +
    						"(3) : View Shopping Cart\n" + 
    						"(4) : Exit"); 
    }
    
    
    // view store inventory function 
    public static void viewInventory()
    {
    	// local function variables
    	int inventoryItems = products.size(); 
    	char userChoice = '0'; 
    	
    	// display number of items in the inventory
    	if (inventoryItems == 0)
    		System.out.println("Inventory is empty."); 
    	else 
    		System.out.println("Here are all " + inventoryItems + " items in the inventory:");
    	
    	
        System.out.println("----------------------------------------------------------"); 
        // loop and display all items in inventory 
    	int count = 0; 
    	for (SalableProduct item : products)
    	{
    		count++; 
    		System.out.printf("-- Item #%d --\n%s%n", count, item); 
    	}
    	System.out.println("----------------------------------------------------------"); 
    	
    	
    	// try adding items from inventory into shopping cart 
    	try 
    	{
    		System.out.println("Would you like to purchase an item (y/n): ");
        	userChoice = in.next().charAt(0);
        	
        	// keep looping if user wants to add more items to shopping cart 
        	while (userChoice == 'y')
        	{
        		System.out.println("Enter the Item # you want to purchase:"); 
        		int itemChosen = in.nextInt();
        		
        		shoppingCart.add(products.get(itemChosen-1)); 
        		
        		System.out.println("You added Item #" + itemChosen + " to your cart. Add another? (y/n):");
        		userChoice = in.next().charAt(0);
        	} 
        	
        	// end of purchasing items message
        	if (userChoice != 'y' && shoppingCart.size() > 0)
        		System.out.println("You chose not to buy anything else. Proceed to shopping cart if you wish to purchase your items.");
        	else if (userChoice != 'y')
        		System.out.println("You chose not to buy anything.");
        	
    	}
    	catch (Exception e) {
    		System.err.println("You entered something invalid, back to main menu you go."); 
    	}
    	
    	in.nextLine(); // fix any scanner input errors 
    }
    
    
    // view shopping cart function 
    public static void viewCart()
    {
    	// local function variables
    	int cartItems = shoppingCart.size(); 
    	int userChoice = -1;
    	
    	// display number of items in shopping cart message 
    	if (cartItems == 0)
    		System.out.println("Your shopping cart is empty."); 
    	else 
    		System.out.println("Your shopping cart has " + cartItems + " items.");
    	

        System.out.println("----------------------------------------------------------"); 
        // loop and display shopping cart items
        int count = 0; 
    	for (SalableProduct item : shoppingCart) {
    		count++; 
    		System.out.printf("-- Item #%d --\n%s%n", count, item); 
    	}
    	System.out.println("----------------------------------------------------------"); 
    	
    	
    	// See if user wants to purchase items or remove items
    	if (cartItems != 0) 
    	{
	    	try 
	    	{
	    		System.out.println("-- SHOPPING CART MENU --\nMake a selection:\n(a) Purchase all items\n(b) Remove an item from cart\n(c) Clear entire cart\n(d) Cancel\n"); 
	    		userChoice = in.next().charAt(0);
	    		
	    	} catch (Exception e) {
	    		System.err.println("You entered something invalid, back to main menu you go.");
	    	}
	    		
    		switch(userChoice)
    		{
    		
	    		case 'a': 
	    			System.out.println("You chose to purchase all items!"); 
	    			
	    			// sum up total for shopping cart 
	    			double total = 0.00; 
	    			for (SalableProduct item : shoppingCart) {
	    				total = total + item.getPrice(); 
	    			}
	    			System.out.printf("You spent $%,.2f at the WoW Armory. Thank You, please come again!%n", total); 
	    			
	    			// remove all items from shopping cart 
	    			shoppingCart.clear();
	    			break;
	    			
	    			
	    		case 'b':
	    			System.out.println("You chose to remove an item from cart."); 
	    			
	    			// try removing items from shopping cart 
	    	    	try 
	    	    	{
	    	    		while(shoppingCart.size() != 0)
	    	    		{
	    	    			System.out.println("Enter the Item # you want to remove: ");
	    	    			int removeItem = in.nextInt(); 		    	    			
	    	    			shoppingCart.remove(removeItem-1); 
	    	    			System.out.println("You removed Item #" + removeItem + " from shopping cart."); 
	    	    			
	    	    			System.out.println("Want to remove another item? (y/n): "); 
	    	    			char decision = in.next().charAt(0); 
	    	    			if (decision != 'y') break; 
	    	    		}
	    	        	
	    	        	// end of purchasing items message
	    	        	if (shoppingCart.size() == 0)
	    	        		System.out.println("Your shopping cart is now empty.");		
	    	        	else 
	    	        		System.out.println("Returning to Main Menu. Please re-view your shopping cart to see your updated cart items."); 
	    	    	}
	    	    	catch (Exception e) {
	    	    		System.err.println("You entered something invalid, back to main menu you go."); 
	    	    	}
	    			break;
	    			
	    			
	    		case 'c':
	    			System.out.println("You chose to clear entire cart."); 
	    			shoppingCart.clear(); 
	    			
	    			break;
	    			
	    			
	    		case 'd':
	    			System.out.println("You chose to do nothing."); 
	    			break;
	    			
	    			
	    		default:
	    			System.out.println("You entered something invalid, back to main menu you go.");
	    			break; 
    		}	    	
    	}
    	
    	in.nextLine(); // fix any scanner input errors 
    }
    
    
    // manage store inventory function 
    public static void manageInventory()
    {
    	// local function variables
    	int inventoryItems = products.size(); 
    	
    	if (inventoryItems == 0)
    		System.out.println("Inventory is empty. You cannot manage this list right now."); 
    	else 
    		System.out.println("Inventory has " + inventoryItems + " items.");
    	

        System.out.println("----------------------------------------------------------"); 
        System.out.println("(Inventory management is currently not available.)"); 
        System.out.println("----------------------------------------------------------"); 
    }
       
    
    // initialize starting inventory function
    public static void initializeInventory()
    {
    	// create 2 Weapon objects
    	Weapon weapon1 = new Weapon(); 
    	weapon1.setName("Sword");
    	weapon1.setDescription("iLvl 117");
    	weapon1.setPrice(55.55);
    	weapon1.setQuantity(1);
    	products.add(weapon1); 
    	weapons.add(weapon1); 
    	// 
    	Weapon weapon2 = new Weapon(); 
    	weapon2.setName("Mace");
    	weapon2.setDescription("iLvl 120");
    	weapon2.setPrice(67.89);
    	weapon2.setQuantity(1);
    	products.add(weapon2);    
    	weapons.add(weapon2);
    	
    	    	
    	// create 2 Armor objects
    	Armor armor1 = new Armor(); 
    	armor1.setName("Helmet"); 
    	armor1.setDescription("iLvl 115");
    	armor1.setPrice(35.65);
    	armor1.setQuantity(1);
    	products.add(armor1); 
    	armors.add(armor1);    	
    	//
    	Armor armor2 = new Armor(); 
    	armor2.setName("Gauntlets"); 
    	armor2.setDescription("iLvl 113");
    	armor2.setPrice(78.23);
    	armor2.setQuantity(1);
    	products.add(armor2); 
    	armors.add(armor2); 
    	
    	    	
    	// create 2 Health objects
    	Health health1 = new Health(); 
    	health1.setName("Small Potion");
    	health1.setDescription("Restores 5,000 HP");
    	health1.setPrice(20.00);
    	health1.setQuantity(1);
    	products.add(health1);
    	healths.add(health1); 
    	//
    	Health health2 = new Health(); 
    	health2.setName("Large Potion");
    	health2.setDescription("Restores 10,000 HP");
    	health2.setPrice(50.00);
    	health2.setQuantity(1);
    	products.add(health2); 
    	healths.add(health2); 
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

