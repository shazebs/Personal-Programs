//package app;

import java.io.*;
import java.util.*;
import java.net.*;

public class Store {
    // global variables
    static ArrayList<SalableProduct> products = new ArrayList<>();
    static ArrayList<SalableProduct> shoppingCart = new ArrayList<>();
    static private PrintWriter printWriter;
    static private BufferedReader bufferedReader;
    static Scanner in = new Scanner(System.in);

    /**
     * author: Shazeb Suhail
     * @param args (program statements)
     */
    public static void main(String[] args)
    {
        newline();
        startServer();
        // display welcome message
        System.out.println("----------------------------------------------------------");
        System.out.println("-- Welcome to the World of Warcraft (WoW) Armory store! --");
        System.out.println("----------------------------------------------------------");

        // Initialize starting inventory using a file read.
        try{ initializeInventory("InventoryItems.txt"); }
        catch (FileNotFoundException e){ e.printStackTrace(); }
        catch (IOException e){ e.printStackTrace(); }

        // main program loop
        String userChoice = "";
        do {
            newline();
            printMenu();
            try {
                // for Scanner input errors
                if (in.hasNext()) in.reset();

                // read a menu input from user
                userChoice = in.next();
                newline();
                switch(userChoice)
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
            catch (Exception e){
                System.out.println("You entered something invalid, try again.");
                in.next();
            }
        } while ( userChoice != "4" );
    }

    /**
     * This function prints a newline in the console output.
     */
    public static void newline() {System.out.println();}
    /**
     * This function passes a whole number determining how many newlines to display in the console output.
     * @param x
     */
    public static void newline(int x) { for(int i=0;i<x;i++) newline(); }

    /**
     * This function prints the main menu.
     */
    public static void printMenu()
    {
        System.out.println("-- MAIN MENU --\nMake a selection:\n" +
                "(1) : View Store Inventory\n" +
                "(2) : Manage Store Inventory\n" +
                "(3) : View Shopping Cart\n" +
                "(4) : Exit");
    }

    /**
     * This function prints the all items in the inventory list.
     */
    public static void printInventory()
    {
        // loop and display all inventory items
        int count = 0;
        System.out.println("----------------------------------------------------------");
        for (SalableProduct item : products){
            System.out.printf("-- Item #%d --\n%s%n", ++count, item);
        }
        System.out.println("----------------------------------------------------------");
    }

    /**
     * This function prints all the items in the shopping cart.
     */
    public static void printShoppingCart()
    {
        // loop and display all shopping cart items
        int count = 0;
        System.out.println("----------------------------------------------------------");
        for (SalableProduct item : shoppingCart){
            System.out.printf("-- Item #%d --\n%s%n", ++count, item);
        }
        System.out.println("----------------------------------------------------------");
    }

    /**
     * This item deals with adding items from inventory list to shopping cart.
     */
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

        // if inventory is not empty
        if (inventoryItems != 0)
        {
            try // adding items from inventory to shopping cart
            {
                // ask user if he/she would like to sort the list
                System.out.println("Would you like to SORT the list (y/n): ");
                userChoice = in.next().trim().charAt(0);
                if (userChoice == 'y')
                {
                    System.out.println("-- Pick a Sort Filter --\n"
                            + "a) Ascending by Name\n"
                            + "b) Ascending by Price\n"
                            + "c) Descending by Name\n"
                            + "d) Descending by Price");
                    userChoice = in.next().trim().charAt(0);
                    switch(userChoice)
                    {
                        case 'a':
                            sortBy(1, "name", products, "inventory");
                            break;

                        case 'b':
                            sortBy(1, "price", products, "inventory");
                            break;

                        case 'c':
                            sortBy(-1, "name", products, "inventory");
                            break;

                        case 'd':
                            sortBy(-1, "price", products, "inventory");
                            break;

                        default:
                            System.out.println("You entered something invalid, no sorting will happen.");
                            break;
                    }
                }

                // ask user if he/she would like to purchase an item and get their input
                System.out.println("Would you like to PURCHASE an item (y/n): ");
                userChoice = in.next().trim().charAt(0);

                // keep looping if user wants to add more items to shopping cart
                while (userChoice == 'y'){
                    // prompt user for input on next item to add to shopping cart
                    System.out.println("Enter the Item # you want to purchase:");
                    int itemChosen = in.nextInt();

                    // add item to shopping cart
                    shoppingCart.add(products.get(itemChosen-1));
                    // and remove it from inventory
                    products.remove(itemChosen-1);

                    // if all products have been removed, exit this loop.
                    if (products.size() == 0) {
                        System.out.println("The inventory is now empty. You might have some items in your shopping cart.");
                        break;
                    }
                    // ask user if he/she wants to add more items to their shopping cart from the inventory list
                    System.out.println("You added Item #" + itemChosen + " to your cart. Add another? (y/n):");
                    userChoice = in.next().charAt(0);
                    // if user agrees, print the inventory list and loop again
                    if (userChoice == 'y') printInventory();
                }

                // end of view inventory message
                if (userChoice != 'y' && shoppingCart.size() > 0)
                    System.out.println("You chose not to buy anything else. Proceed to shopping cart if you wish to purchase your items.");
                else if (userChoice != 'y')
                    System.out.println("You chose not to buy anything.");

            }
            // this block alerts user of any error that may have occurred during this process
            catch (Exception e) {
                System.err.println("You entered something invalid, back to main menu you go.");
            }
        }
        // fix any scanner input errors and exit this function
        in.nextLine();
    }


    /**
     * This function deals with the shopping cart operations.
     */
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

        // if the inventory is not empty
        if (cartItems != 0)
        {
            // ask user if he/she would like to sort the list
            System.out.println("Would you like to SORT the list (y/n): ");
            userChoice = in.next().trim().charAt(0);
            if (userChoice == 'y')
            {
                System.out.println("-- Pick a Sort Filter --\n"
                        + "a) Ascending by Name\n"
                        + "b) Ascending by Price\n"
                        + "c) Descending by Name\n"
                        + "d) Descending by Price");
                userChoice = in.next().trim().charAt(0);
                switch(userChoice)
                {
                    case 'a':
                        sortBy(1, "name", shoppingCart, "cart");
                        break;

                    case 'b':
                        sortBy(1, "price", shoppingCart, "cart");
                        break;

                    case 'c':
                        sortBy(-1, "name", shoppingCart, "cart");
                        break;

                    case 'd':
                        sortBy(-1, "price", shoppingCart, "cart");
                        break;

                    default:
                        System.out.println("You entered something invalid, no sorting will happen.");
                        break;
                }
            }

            // see if user wants to purchase items or remove items from shopping cart
            try {
                System.out.println("-- SHOPPING CART MENU --\n"
                        + "Make a selection:\n"
                        + "(a) Purchase all items\n"
                        + "(b) Remove an item from cart\n"
                        + "(c) Clear entire cart\n"
                        + "(d) Cancel\n");
                userChoice = in.next().charAt(0);

            } catch (Exception e) {
                System.err.println("You entered something invalid, back to main menu you go.");
            }

            // switch to a correct shopping cart process depending on user's input
            switch(userChoice)
            {
                // if user chooses to purchase all items in the cart, execute these instructions
                case 'a':
                    System.out.println("You chose to purchase all items!");

                    // sum up total for shopping cart and print the purchase total
                    double total = 0.00;
                    for (SalableProduct item : shoppingCart) { total = total + item.getPrice(); }
                    System.out.printf("You spent $%,.2f at the WoW Armory. Thank You, please come again!%n", total);

                    // array to hold names of all items in shopping cart
                    String[] productNames = new String[shoppingCart.size()];

                    int it = 0;
                    // loop through shopping cart and add each item's name to a list
                    for (SalableProduct cartItem : shoppingCart) { productNames[it++] = cartItem.getName(); }

                    // using the names in the list, remove those items from the main inventory
                    for (String name : productNames) {
                        for (SalableProduct product : products) {
                            if (product.getName() == name) {
                                products.remove(product);
                                break;
                            }
                        }
                    }
                    // and finally, clear the shopping cart list
                    shoppingCart.clear();
                    break;

                // if user chooses to remove items from their cart, execute these instruction
                case 'b':
                    System.out.println("You chose to remove an item from cart.");

                    // try removing items from shopping cart
                    try
                    {
                        // while cart is not empty
                        while(shoppingCart.size() != 0)
                        {
                            // get input from the user on which item # to remove from shopping cart
                            System.out.println("Enter the Item # you want to remove: ");
                            int removeItem = in.nextInt();

                            // add removed shopping cart item back into main inventory list
                            products.add(shoppingCart.get(removeItem-1));
                            // then remove item from shopping cart list
                            shoppingCart.remove(removeItem-1);

                            // display a successful item removal message
                            System.out.println("You removed Item #" + removeItem + " from shopping cart.");

                            // if the shopping cart list is not empty yet
                            if (shoppingCart.size() != 0)
                            {
                                // ask user if he/she wants to remove another item from shopping cart list
                                System.out.println("Want to remove another item? (y/n): ");
                                char decision = in.next().charAt(0);

                                // if yes, print all shopping cart items and repeat the loop
                                if (decision != 'y') break;
                                else
                                    printShoppingCart();
                            }
                        }
                        // if shopping cart is not empty, print a message to the user
                        if (shoppingCart.size() == 0)
                            System.out.println("Your shopping cart is now empty.");
                        else
                            System.out.println("Returning to Main Menu. Please re-view your shopping cart to see your updated cart items.");
                    }
                    // lets user know of any errors, if any do occur
                    catch (Exception e) {
                        System.err.println("You entered something invalid, back to main menu you go.");
                    }
                    break;

                // if user wants to remove all items from the shopping cart, execute these instructions
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
        // fix any scanner input errors
        in.nextLine();
    }

    /**
     * This function deals with managing inventory operations.
     */
    public static void manageInventory()
    {
        // local function variables
        int inventoryItems = products.size();
        char userChoice;

        // print the number of items in the inventory list
        if (inventoryItems == 0)
            System.out.println("Inventory is empty. You cannot manage this list right now.");
        else
            System.out.println("Inventory has " + inventoryItems + " items.");
        printInventory();


        try
        {
            // ask user if he/she would like to sort the list
            System.out.println("Would you like to SORT the list (y/n): ");
            userChoice = in.next().trim().charAt(0);
            if (userChoice == 'y')
            {
                System.out.println("-- Pick a Sort Filter --\n"
                        + "a) Ascending by Name\n"
                        + "b) Ascending by Price\n"
                        + "c) Descending by Name\n"
                        + "d) Descending by Price");
                userChoice = in.next().trim().charAt(0);
                switch(userChoice)
                {
                    case 'a':
                        sortBy(1, "name", products, "inventory");
                        break;

                    case 'b':
                        sortBy(1, "price", products, "inventory");
                        break;

                    case 'c':
                        sortBy(-1, "name", products, "inventory");
                        break;

                    case 'd':
                        sortBy(-1, "price", products, "inventory");
                        break;

                    default:
                        System.out.println("You entered something invalid, no sorting will happen.");
                        break;
                }
            }

            // print the sub-menu for inventory manager component
            System.out.println("-- INVENTORY MANAGER MENU --\n"
                    + "Make a selection:\n"
                    + "(a) Add an item\n"
                    + "(b) Remove an item \n"
                    + "(c) Clear entire inventory\n"
                    + "(d) Cancel\n");
            userChoice = in.next().charAt(0);

            // switch to the correct inventory item process
            switch (userChoice)
            {

                // if user wants to add an item to the inventory, execute these instructions
                case 'a':
                    System.out.println("You chose to add an item to the inventory!\n");

                    // try adding a new inventory item
                    try
                    {
                        System.out.println("What type of inventory item are you creating:\n"
                                + "(a) Sword\n"
                                + "(b) Bow\n"
                                + "(c) Shield\n"
                                + "(d) Helmet\n"
                                + "(e) Potion\n"
                                + "(f) Food\n"
                                + "(g) Cancel\n");
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


                // if user wants to remove an item from the inventory list, execute these instructions
                case 'b':
                    // if list is empty, print a message to the user
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
                                // try removing that item
                                products.remove(removeItem-1);

                                // display a successful item removal message
                                System.out.println("You removed Item #" + removeItem + " from inventory.");

                                // ask user if he/she wants to remove another item
                                if (products.size() != 0) {
                                    System.out.println("Want to remove another item? (y/n): ");
                                    char decision = in.next().charAt(0);

                                    // if yes, print items in inventory list and repeat the loop
                                    if (decision != 'y') break;
                                    else
                                        printInventory();
                                }
                            }
                            // if all items in inventory are now gone, let the user know
                            if (products.size() == 0)
                                System.out.println("Inventory is now empty.");
                            else
                                System.out.println("Returning to Main Menu.");
                        }
                        // print an error message to user if one occurs
                        catch (Exception e) {
                            System.err.println("You entered something invalid, back to main menu you go.");
                        }
                    }
                    break;


                // if user chooses to empty the entire inventory list, execute these instructions
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
        // fix any scanner input errors
        in.nextLine();
    }

    /**
     * This function will assist in getting user input for new inventory item creation.
     * @param SalableProduct object
     * @param class type
     * @return SalableProduct
     */
    public static SalableProduct createInventoryItem(SalableProduct product, String type)
    {
        // fix any scanner input errors
        in.nextLine();

        // get a name property
        System.out.println("Enter a name for this item:");
        product.setName(in.nextLine().trim());
        while (product.getName() == "") {
            System.out.println("Error, name cannot be left blank. Enter a name for this " + type + " item:");
            product.setName(in.nextLine().trim());
        }

        // get a description property
        System.out.println("Enter a description for this item:");
        product.setDescription(in.nextLine().trim());
        while (product.getDescription() == "") {
            System.out.println("Error, description cannot be left blank. Enter a description for this " + type + " item:");
            product.setDescription(in.nextLine().trim());
        }

        // get a price property
        System.out.println("Enter a price for this item:");
        product.setPrice(in.nextDouble());

        // get an item level property
        System.out.println("Enter an iLvl for this item:");
        product.setItemLevel(in.nextInt());
        product.setType(type);

        return product;
    }

    /**
     * Pass a name for a text file and parse its contents to add a new inventory item to the list.
     * @param inputFile
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void initializeInventory(String inputFile) throws FileNotFoundException, IOException
    {

        // Input and Output File Read declaration
        BufferedReader in = null;

        // FileReader class object
        in = new BufferedReader(new FileReader(inputFile));

        // to hold line of file
        String line;


        while ((line = in.readLine()) != null)
        {
            String[] tokens = line.split("\\|");

            switch(tokens[0])
            {
                case "Sword":
                    Sword newSword = new Sword();
                    createNewItem(tokens, newSword);
                    break;
                case "Bow":
                    Bow newBow = new Bow();
                    createNewItem(tokens, newBow);
                    break;
                case "Shield":
                    Shield newShield = new Shield();
                    createNewItem(tokens, newShield);
                    break;
                case "Helmet":
                    Helmet newHelmet = new Helmet();
                    createNewItem(tokens, newHelmet);
                    break;
                case "Potion":
                    Potion newPotion = new Potion();
                    createNewItem(tokens, newPotion);
                    break;
                case "Food":
                    Food newFood = new Food();
                    createNewItem(tokens, newFood);
                    break;
            }
        }

        // clean up files
        try {
            if (in != null)
                in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Create a new SalableProduct and add it to the inventory list.
     * @param tokens
     * @param product
     */
    public static void createNewItem(String[] tokens, SalableProduct product)
    {
        // initialize object's properties
        product.setType(tokens[0]);
        product.setName(tokens[1]);
        product.setDescription(tokens[2]);
        product.setPrice(Double.parseDouble(tokens[3]));
        product.setItemLevel(Integer.parseInt(tokens[4]));

        // add object to inventory list
        products.add(product);
    }

    /**
     * This function sorts a list by ascending/descending name or price values.
     * @param dir (sort direction)
     * @param x (name or price param)
     * @param list (collection to sort)
     * @param y (inventory or shopping cart param)
     */
    public static void sortBy(int dir, String x, ArrayList<SalableProduct> list, String y)
    {
        newline();

        // create a temporary array for sorting
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Double> prices = new ArrayList<Double>();
        ArrayList<SalableProduct> placeholders = new ArrayList<SalableProduct>();

        // place all inventory item via name and price two separate lists and sort them
        for (int i=0; i < list.size(); i++) {
            names.add(list.get(i).getName());
            prices.add(list.get(i).getPrice());
        }
        Collections.sort(names);
        Collections.sort(prices);

        // initialize placeholder sorted list
        for (int i=0; i<list.size(); i++) {
            for (SalableProduct product : list)
            {
                if (product.getName() == names.get(i) && x == "name") {
                    placeholders.add(product);
                }
                if (product.getPrice() == prices.get(i) && x == "price") {
                    placeholders.add(product);
                }
            }
        }

        // switch to the correct sort filter instruction
        switch(dir) {
            // descending
            case -1:
                // by name
                if (x == "name") {
                    // reverse items in the list
                    Collections.sort(names, Collections.reverseOrder());
                    placeholders.clear();

                    // insert reverse alphabetically inventory items into a temporary list
                    for (int i=0; i<list.size(); i++) {
                        for (SalableProduct product : list)
                        {
                            if (product.getName() == names.get(i)) {
                                placeholders.add(product);
                                break;
                            }
                        }
                    }
                    // clear the original inventory list and insert the sorted list items
                    if (y == "inventory") {
                        products.clear();
                        products = placeholders;
                        System.out.println("~ Items sorted by product name descending alphabetical ~");
                        printInventory();
                    }
                    else if (y == "cart") {
                        shoppingCart.clear();
                        shoppingCart = placeholders;
                        System.out.println("~ Items sorted by product name descending alphabetical ~");
                        printShoppingCart();
                    }
                }
                // by price
                else if (x == "price") {
                    // reverse the list and print the items
                    Collections.sort(prices, Collections.reverseOrder());
                    placeholders.clear();

                    // insert descending inventory items into a temporary list
                    for (int i=0; i<list.size(); i++) {
                        for (SalableProduct product : list)
                        {
                            if (product.getPrice() == prices.get(i)) {
                                placeholders.add(product);
                                break;
                            }
                        }
                    }
                    // clear the original inventory list and insert the sorted list items
                    if (y == "inventory") {
                        products.clear();
                        products = placeholders;
                        System.out.println("~ Items sorted by product price highest to lowest ~");
                        printInventory();
                    }
                    else if (y == "cart") {
                        shoppingCart.clear();
                        shoppingCart = placeholders;
                        System.out.println("~ Items sorted by product price highest to lowest ~");
                        printShoppingCart();
                    }
                }
                break;

            // ascending
            case 1:
                // by name
                if (x == "name") {
                    if (y == "inventory") {
                        products.clear();
                        products = placeholders;
                        System.out.println("~ Items sorted by product name ascending alphabetical ~");
                        printInventory();
                    }
                    else if (y == "cart") {
                        shoppingCart.clear();
                        shoppingCart = placeholders;
                        System.out.println("~ Items sorted by product name ascending alphabetical ~");
                        printShoppingCart();
                    }
                }
                else if (x == "price") {
                    if (y == "inventory") {
                        products.clear();
                        products = placeholders;
                        System.out.println("~ Items sorted by product price lowest to highest ~");
                        printInventory();
                    }
                    else if (y == "cart") {
                        shoppingCart.clear();
                        shoppingCart = placeholders;
                        System.out.println("~ Items sorted by product price lowest to highest ~");
                        printShoppingCart();
                    }
                }

                break;

            // default case
            default:
                break;
        }
    }

    /**
     * print generic array type elements function
     * @param <E> Element
     * @param list generic array object
     */
    public static <E> void printItemsE(E[] list)
    {
        for (E item : list)
        {
            System.out.println(item);
        }
    }

    /**
     * Start the WowServer and wait for AdminClient to connect before continuing.
     * + ServerSocket
     * + ClientThread (Java Thread)
     */
    public static void startServer()
    {
        // Server Stuff
        ServerSocket WowServer = null;
        try {
            WowServer = new ServerSocket(4445);
            WowServer.setReuseAddress(true);

            System.out.println("Waiting for a connection...");

            /*while (true)
            {*/
            Socket client = WowServer.accept();

            System.out.println("New client connected: " + client.getInetAddress().getHostAddress());

            ClientThread clientSocket = new ClientThread(client);

            new Thread(clientSocket).start();
            //}
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            if (WowServer != null) {
                try {
                    WowServer.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * This function handles continuous input and output of a java Thread in a Server-type class.
     * + Sockets
     * + PrintWriter
     * + BufferedReader
     */
    public static class ClientThread implements Runnable
    {
        private final Socket clientSocket;

        public ClientThread(Socket socket) {
            this.clientSocket = socket;
        }

        public void run()
        {
            PrintWriter out = null;
            BufferedReader in = null;

            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String line;

                while ((line = in.readLine()) != null)
                {
                    System.out.printf("Sent from AdminClient: \"%s\"\n", line);
                    switch(line /*.toLowerCase()*/)
                    {
                        case "Command U: Inventory has been Updated":
                            line = "booyah";
                            break;
                        case "Command R: Viewing All Inventory Items":
                            line = "yippee";
                            break;
                        case "Disconnected from WowServer":
                            line = "merp";
                            break;
                        default:
                            line = "zoinks";
                            break;
                    }
                    out.println(line);
                }
            }
            catch (SocketException e) {
                System.out.println("AdminClient has been disconnected from the server.");
            }
            catch (IOException e)
            {
                e.printStackTrace();
                System.out.println("Read the error logs.");
            }
            finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                        clientSocket.close();
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

} // end of Store class.


/*

Command: U, will update the Store Inventory Management System with new Salable Products.
            The data payload will be a JSON string of Salable Products.

Command: R, will return all of the Salable Products from the Store Inventory Management System in JSON format.

 */