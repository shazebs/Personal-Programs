package app;

// library imports
import java.util.Scanner;
import java.util.ArrayList;

/**
 * 
 * @author shazebs
 *
 */
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
    
    
    // global arrays 
    static ArrayList<SalableProduct> products = new ArrayList<>(); 
    static ArrayList<SalableProduct> shoppingCart = new ArrayList<>(); 
    // 
    /* static ArrayList<Weapon> weapons = new ArrayList<>(); 
    static ArrayList<Armor> armors = new ArrayList<>(); 
    static ArrayList<Health> healths = new ArrayList<>(); */
    
    // Scanner object
    static Scanner in = new Scanner(System.in);
    
    
    /**
     * Main driver method. 
     * @param args 
     */
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
        		if (in.hasNext()) in.reset(); 
        		
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
        	catch (Exception e) {
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
    
    public static void printInventory()
    {
    	System.out.println("----------------------------------------------------------"); 
        // loop and display all items in inventory 
    	int count = 0; 
    	for (SalableProduct item : products)
    	{
    		count++; 
    		System.out.printf("-- Item #%d --\n%s%n", count, item); 
    	}
    	System.out.println("----------------------------------------------------------");
    }
    
    public static void printShoppingCart()
    {
    	System.out.println("----------------------------------------------------------"); 
        // loop and display shopping cart items
        int count = 0; 
    	for (SalableProduct item : shoppingCart) {
    		count++; 
    		System.out.printf("-- Item #%d --\n%s%n", count, item); 
    	}
    	System.out.println("----------------------------------------------------------"); 
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
    	
    	
        printInventory(); 
    	
    	
    	// try adding items from inventory into shopping cart 
        if (inventoryItems != 0)
        {
        	try 
        	{
        		System.out.println("Would you like to purchase an item (y/n): ");
            	userChoice = in.next().charAt(0);
            	
            	// keep looping if user wants to add more items to shopping cart 
            	while (userChoice == 'y')
            	{ 
            		System.out.println("Enter the Item # you want to purchase:"); 
            		int itemChosen = in.nextInt();
            		
            		// add item to shopping cart 
            		shoppingCart.add(products.get(itemChosen-1)); 
            		// and remove it from inventory 
            		products.remove(itemChosen-1);
            		
            		// if all products have been removed, exit. 
            		if (products.size() == 0) {
            			System.out.println("The inventory is now empty. You might have some items in your shopping cart."); 
            			break; 
            		}
            		
            		System.out.println("You added Item #" + itemChosen + " to your cart. Add another? (y/n):");
            		userChoice = in.next().charAt(0);
            		
            		if (userChoice == 'y') printInventory();
            	} 
            	
            	// end of view inventory message 
            	if (userChoice != 'y' && shoppingCart.size() > 0)
            		System.out.println("You chose not to buy anything else. Proceed to shopping cart if you wish to purchase your items.");
            	else if (userChoice != 'y')
            		System.out.println("You chose not to buy anything.");
            	
        	}
        	catch (Exception e) {
        		System.err.println("You entered something invalid, back to main menu you go."); 
        	}
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
    	

        printShoppingCart(); 
    	
    	
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
	    			
	    			// get names of all items in shopping cart 
	    			String[] productNames = new String[shoppingCart.size()]; 
	    			int it = 0; 
	    		    for (SalableProduct cartItem : shoppingCart) {
	    		    	productNames[it] = cartItem.getName(); 
	    		    	it++; 
	    		    }
	    			// remove all items from shopping cart and inventory
	    		    for (String name : productNames) {
	    		    	for (SalableProduct product : products) {
	    		    		if (product.getName() == name) {
	    		    			products.remove(product); 
	    		    			break; 
	    		    		}
	    		    	}
	    		    }
	    			shoppingCart.clear();
	    			break;
	    			
	    			
	    		case 'b':
	    			System.out.println("You chose to remove an item from cart."); 
	    			
	    			// try removing items from shopping cart 
	    	    	try 
	    	    	{
	    	    		// while cart is not empty 
	    	    		while(shoppingCart.size() != 0)
	    	    		{
	    	    			// get input from the user on which item # to remove from cart 
	    	    			System.out.println("Enter the Item # you want to remove: ");
	    	    			int removeItem = in.nextInt(); 		
	    	    			
	    	    			// add removed shopping cart item back into inventory
	    	    			products.add(shoppingCart.get(removeItem-1)); 
	    	    			// then remove item from shopping cart 
	    	    			shoppingCart.remove(removeItem-1); 
	    	    			
	    	    			// display a successful item removal message 
	    	    			System.out.println("You removed Item #" + removeItem + " from shopping cart."); 
	    	    			
	    	    			// ask if user wants to remove more items 
	    	    			if (shoppingCart.size() != 0) 
	    	    			{
	    	    				System.out.println("Want to remove another item? (y/n): "); 
	    	    				char decision = in.next().charAt(0); 
	    	    				if (decision != 'y') break; 
	    	    				else 
	    	    					printShoppingCart(); 
	    	    			}
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
	    			
	    			// add all removed items back into inventory before clearing cart 
	    			for (SalableProduct cartItem : shoppingCart) {
	    				products.add(cartItem);
	    			}
	    			shoppingCart.clear(); 
	    			
	    			// print successful cart clear message 
	    			System.out.println("Your shopping cart is now empty."); 
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
    	char userChoice; 
    	
    	if (inventoryItems == 0)
    		System.out.println("Inventory is empty. You cannot manage this list right now."); 
    	else 
    		System.out.println("Inventory has " + inventoryItems + " items.");
    	
    	
    	printInventory(); 
    	try 
    	{
    		System.out.println("-- INVENTORY MANAGER MENU --\nMake a selection:\n(a) Add an item\n(b) Remove an item \n(c) Clear entire inventory\n(d) Cancel\n"); 
    		userChoice = in.next().charAt(0);
    		
    		switch (userChoice)
    		{
    		case 'a': 
    			System.out.println("You chose to add an item to the inventory!\n"); 
    			try 
    	    	{
    	    		System.out.println("What type of inventory item are you creating:\n(a) Sword\n(b) Bow\n(c) Shield\n(d) Helmet\n(e) Potion\n(f) Food\n(g) Cancel\n"); 
    	    		userChoice = in.next().charAt(0);
    	    		
    	    		switch (userChoice)
    	    		{
    	    			case 'a':
    	    				products.add(createInventoryItem(new Sword(), "Sword")); 
    	    				break; 
    	    			case 'b':
    	    				products.add(createInventoryItem(new Bow(), "Bow"));
    	    				break;
    	    			case 'c':
    	    				products.add(createInventoryItem(new Shield(), "Shield"));
    	    				break;
    	    			case 'd':
    	    				products.add(createInventoryItem(new Helmet(), "Helmet"));
    	    				break;
    	    			case 'e':
    	    				products.add(createInventoryItem(new Potion(), "Potion"));
    	    				break;
    	    			case 'f':
    	    				products.add(createInventoryItem(new Food(), "Food"));
    	    				break;
    	    			case 'g':
    	    				System.out.println("You decided not to add an inventory item.");
    	    				break;
    	    				
    	    			default:
    	    				System.out.println("You entered something invalid."); 
    	    				break; 
    	    		}
    	    	} 
    	    	catch (Exception e) {
    	    		System.err.println("You entered something invalid. Inventory item creation terminated, try again.");
    	    	}
    			break;
    			
    			
    		case 'b':
    			if (inventoryItems == 0)
    			{
    				System.out.println("Inventory is empty, you cannot remove anyting."); 
    			}
    			else 
    			{
    				System.out.println("You chose to remove an item from inventory."); 
    				// try removing items from the inventory 
	    	    	try 
	    	    	{
	    	    		// while cart is not empty 
	    	    		while(products.size() != 0)
	    	    		{
	    	    			// get input from the user on which item # to remove from inventory 
	    	    			System.out.println("Enter the Item # you want to remove: ");
	    	    			int removeItem = in.nextInt(); 		
	    	    			products.remove(removeItem-1); 
	    	    			
	    	    			// display a successful item removal message 
	    	    			System.out.println("You removed Item #" + removeItem + " from inventory."); 
	    	    			
	    	    			// ask if user wants to remove more items 
	    	    			if (products.size() != 0) {
	    	    				System.out.println("Want to remove another item? (y/n): "); 
	    	    				char decision = in.next().charAt(0); 
	    	    				if (decision != 'y') break; 
	    	    				else 
	    	    					printInventory(); 
	    	    			}
	    	    		}
	    	        	// end of purchasing items message
	    	        	if (shoppingCart.size() == 0)
	    	        		System.out.println("Inventory is now empty.");		
	    	        	else 
	    	        		System.out.println("Returning to Main Menu."); 
	    	    	}
	    	    	catch (Exception e) {
	    	    		System.err.println("You entered something invalid, back to main menu you go."); 
	    	    	}
    			}
    			break;
    			
    			
    		case 'c':
    			
    			if (products.size() == 0)
    				System.out.println("The inventory is already empty.");
    			else {
    				System.out.println("You chose to clear entire inventory."); 
    				products.clear(); 
    			}
    			break;
    			
    			
    		case 'd':
    			System.out.println("You chose to do nothing."); 
    			break;
    			
    			
    		default:
    			System.out.println("You entered something invalid, back to main menu you go.");
    			break; 
    		}
    		
    	} 
    	catch (Exception e) 
    	{
    		System.err.println("You entered something invalid, back to main menu you go.");
    	}
        
        in.nextLine(); // fix any scanner input errors 
    }
    
    /**
     * This function will assist in getting user input for new inventory item creation. 
     * @param SalableProduct object
     * @param class type
     * @return SalableProduct
     */
    public static SalableProduct createInventoryItem(SalableProduct product, String type)
    {
    	in.nextLine(); 
    	// get name property 
    	System.out.println("Enter a name for this item:"); 
    	product.setName(in.nextLine().trim());
    	while (product.getName() == "") {
    		System.out.println("Error, name cannot be left blank. Enter a name for this " + type + " item:"); 
    		product.setName(in.nextLine().trim());
    	}
    	
    	// get description property 
    	System.out.println("Enter a description for this item:");
    	product.setDescription(in.nextLine().trim());
    	while (product.getDescription() == "") {
    		System.out.println("Error, description cannot be left blank. Enter a description for this " + type + " item:"); 
    		product.setDescription(in.nextLine().trim());
    	}
    	
    	// get price property  
    	System.out.println("Enter a price for this item:");
    	product.setPrice(in.nextDouble());
    	
    	// get item level property 
    	System.out.println("Enter an iLvl for this item:");
    	product.setItemLevel(in.nextInt());
    	product.setType(type); 
    	
    	return product; 
    }
    
    
    // initialize starting inventory function
    public static void initializeInventory()
    {
    	// create 2 Weapon objects
    	Sword sword = new Sword(); 
    	sword.setName("Jaithys, the Prison Blade");
    	sword.setDescription("224-374 Damage");
    	sword.setPrice(15370.46);
    	sword.iLvl = 259;
    	sword.type = "Sword"; 
    	products.add(sword); 
    	// weapons.add(sword); 
    	// 
    	Bow bow = new Bow(); 
    	bow.setName("Rae'shalare, Death's Whisper");
    	bow.setDescription("212-287 Damage");
    	bow.setPrice(23226.85);
    	bow.iLvl = 233;
    	bow.type = "Bow"; 
    	products.add(bow);    
    	
    	    	
    	// create 2 Armor objects
    	Shield shield = new Shield(); 
    	shield.setName("Guard of the Sundered Defender"); 
    	shield.setDescription("1,992 Block");
    	shield.setPrice(8016.86);
    	shield.iLvl = 259;
    	shield.type = "Shield"; 
    	products.add(shield); 
    	// armors.add(shield);    	
    	//
    	Helmet helmet = new Helmet(); 
    	helmet.setName("Dark Tormentor's Gaze"); 
    	helmet.setDescription("195 Armor");
    	helmet.setPrice(6321.23);
    	helmet.iLvl = 252;
    	helmet.type = "Helmet"; 
    	products.add(helmet); 
    	// armors.add(helmet); 
    	
    	    	
    	// create 2 Health objects
    	Potion potion = new Potion(); 
    	potion.setName("Spiritual Healing Potion");
    	potion.setDescription("Restores 10,000 HP");
    	potion.setPrice(50.00);
    	potion.iLvl = 0;
    	potion.type = "Potion"; 
    	products.add(potion);
    	// healths.add(potion); 
    	//
    	Food food = new Food(); 
    	food.setName("Mon'Dazi");
    	food.setDescription("Restores 7,692 HP");
    	food.setPrice(200.00);
    	food.iLvl = 0;
    	food.type = "Food"; 
    	products.add(food); 
    	// healths.add(heal); 
    }
}
