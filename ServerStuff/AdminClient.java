//package app;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * author: Shazeb Suhail
 * This AdminClient class must be run after running Store class.
 *
 */
public class AdminClient
{
    // global variables
    static Scanner cin = new Scanner(System.in);

    /**
     * This main method starts up our AdminClient which should only be compiled after we start our Store class.
     * + Socket object
     * + PrintWriter object
     * + BufferedReader object
     * + try-catch-finally blocks
     * + .equalsIgnoreCase() method
     *
     * @param args statements
     * @throws IOException thrown from the use of Socket objects
     */
    public static void main(String[] args) throws IOException
    {
        try (Socket socket = new Socket("localhost", 4445))
        {
            System.out.println("\nConnection to WowServer was successful.\nYou are online!");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line = null;
            while (!"exit".equalsIgnoreCase(line))
            {
                // print menu options
                String msg = displayOptions();

                // send a message to server
                out.println(msg);
                out.flush();

                // read-in the server's response
                line = in.readLine();

                // process the response
                msg = processServerResponse(line);

                // display the correct output response
                if (msg.equalsIgnoreCase("r")) {
                    System.out.printf("WowServer replied: \"%s\"\n", "All Inventory Items have been retrieved!");
                }
                else {
                    System.out.printf("WowServer replied: \"%s\"\n", line);
                }
            }

            // close any open resources
            cin.close();
            out.close();
            in.close();
        }
        catch (ConnectException e) {
            e.printStackTrace();
            System.out.println("Restart WowServer.");
        }
        catch (SocketException e) {
            e.printStackTrace();
            System.out.println("WowServer shut down. Connection was lost.");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nRead the error stack trace for more info.");
        }

        // shut down message
        System.out.print("AdminClient has shutdown.");
        System.exit(999);
    }

    /**
     * This function displays the AdminClient menu options and returns a string message to send to the server.
     * + .trim() method
     * + switch block
     *
     * @return String Message to send to Server
     */
    public static String displayOptions()
    {
        // display menu options
        System.out.printf("\n-- Main Menu -- \n1) %s \n2) %s \n3) %s \n> ",
                "Command U", "Command R", "Disconnect"
        );

        // read and process the user's input
        String userInput = cin.nextLine().trim();
        switch(userInput)
        {
            case "1":
                String json = COMMAND_U();
                return json;
            case "2":
                return "Command R: Retrieving All Inventory Items as a JSON payload.";
            case "3":
                Store.newline();
                return "Disconnected from WowServer.";
            default:
                Store.newline();
                return userInput;
        }
    }

    /**
     * This function processes the String response received from the server.
     * + .substring() method
     * + switch block
     *
     * @param line server response
     * @return flag identified with server response
     */
    public static String processServerResponse(String line)
    {
        String flag = line.substring(0, 1);
        switch(flag)
        {
            // if server response was a JSON payload
            case "r":
                System.out.println("Server response was detected to be a JSON payload.");
                COMMAND_R(line.substring(1));
                break;
            // if some other server response was received
            default:
                break;
        }
        return flag;
    }

    /**
     * This function sends new SalableProduct items to the sever as a JSON payload.
     * + .trim() method
     * + switch block
     */
    public static String COMMAND_U()
    {
        // display instructions to user
        System.out.println("How do you want to update the WowServer Inventory Items?");
        System.out.printf("1) %s \n2) %s \n> ",
                "Manually Insert New SalableProduct",
                "Insert From a File");

        // process user's input
        switch(cin.nextLine().trim())
        {
            // if user chooses to manually insert new SalableProduct items.
            case "1":
                // prompt user the different type of SalableProduct classes available to be created.
                System.out.println("What type of product do you want to create?");
                System.out.printf("1) %s \n2) %s \n3) %s \n4) %s \n5) %s \n6) %s \n> ",
                        "Sword", "Bow", "Shield", "Helmet", "Potion", "Food");
                String type = cin.nextLine().trim();

                // begin product creation
                SalableProduct product = null;
                switch(type)
                {
                    case "1":
                        System.out.println("You chose Sword.");
                        product = Store.createInventoryItem(new Sword(), "Sword", true);
                        break;
                    case "2":
                        System.out.println("You chose Bow.");
                        product = Store.createInventoryItem(new Bow(), "Bow", true);
                        break;
                    case "3":
                        System.out.println("You chose Shield.");
                        product = Store.createInventoryItem(new Shield(), "Shield", true);
                        break;
                    case "4":
                        System.out.println("You chose Helmet.");
                        product = Store.createInventoryItem(new Helmet(), "Helmet", true );
                        break;
                    case "5":
                        System.out.println("You chose Potion.");
                        product = Store.createInventoryItem(new Potion(), "Potion", true);
                        break;
                    case "6":
                        System.out.println("You chose Food");
                        product = Store.createInventoryItem(new Food(), "Food", true);
                        break;
                    default:
                        System.out.println("You entered something invalid so the product creation process terminated.\nTry again.");
                        break;
                }
                // format the product into JSON
                if (product != null)
                {
                    String json = "u{";
                    json += "\"type\":\"" + product.type + "\"|";
                    json += "\"name\":\"" + product.getName() + "\"|";
                    json += "\"description\":\"" + product.getDescription() + "\"|";
                    json += "\"price\":" + product.getPrice() + "|";
                    json += "\"ilvl\":" + product.iLvl + "";
                    json += "}";
                    // System.out.println(json);
                    return json;
                }
                break;

            // if user chooses to automatically insert new SalableProduct items via JSON format text file.
            case "2":
                System.out.println("You chose automatic");
                break;

            default:
                System.out.println("You chose something beyond the scope of this project");
                break;
        }
        Store.newline();
        return "bruh";
    }

    /**
     * This function returns a JSON formatted list of all current Inventory Items.
     * + String[] arrays
     * + .split() method
     *
     * @param json String of Inventory Items
     */
    public static void COMMAND_R(String json)
    {
        // display a message
        System.out.println("Here are all inventory items retrieved from WowServer:");

        int obj = 0;
        System.out.println("[");

        // parse the json String into objects
        String[] objects = json.split("@");

        // loop through JSON objects and print objects
        for (String object : objects)
        {
            System.out.println("\t{");
            System.out.println("\t\t\"id\": " + (obj+1) + ",");

            // parse JSON objects into key-value pairs
            String[] fields = object.split("[|{}]");

            // loop through JSON object's key-value pairs
            int key = 0;
            for (String field : fields)
            {
                // code snip for parsing issue
                if (field.trim() == "") {
                    ++key;
                    continue;
                }

                // print key-value pair
                System.out.print("\t\t" + field);

                // add a comma if more key-value pairs exist in this JSON object
                if (!(++key == fields.length)) {
                    System.out.println(",");
                } else {
                    System.out.println();
                }
            }

            // add a comma if more JSON objects exist and have yet to be parsed
            if (!(++obj == objects.length)) {
                System.out.println("\t},");
            }
            else {
                System.out.println("\t}");
            }
        }
        System.out.println("]\n");
    }
}