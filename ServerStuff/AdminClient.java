import java.io.*;
import java.net.*;
import java.util.Scanner;

public class AdminClient 
{
    static Scanner cin = new Scanner(System.in);
    public static void main(String[] args0) throws IOException
    {
        try (Socket socket = new Socket("localhost", 4445))
        {
            System.out.println("\nConnection to WowServer was successful.\nYou are online!\n");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line = null;
            while (!"exit".equalsIgnoreCase(line))
            {
                out.println(displayOptions());
                out.flush();
                System.out.printf("WowServer replied: \"%s\"\n\n", in.readLine());
            }
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
            System.out.println("Read the error stack trace for more info.");
        }
    }
    public static String displayOptions()
    {
        System.out.printf("-- Main Menu -- \n1) %s \n2) %s \n3) %s \n> ",
                    "Command U", "Command R", "Disconnect"
                );
        String userInput = cin.nextLine();
        switch(userInput.trim())
        {
            case "1":
                COMMAND_R();
                return "Command U: Inventory has been Updated";
            case "2":
                COMMAND_U();
                return "Command R: Viewing All Inventory Items";
            case "3":
                Store.newline();
                return "Disconnected from WowServer";
            default:
                return userInput;
        }
    }
    public static void COMMAND_R()
    {
        System.out.println("How do you want to update the WowServer Inventory Items?");
        System.out.printf("1) %s \n2) %s \n> ",
                "Manually Insert New SalableProduct",
                "Insert From a File");
        switch(cin.nextLine().trim())
        {
            case "1":
                System.out.println("You chose manual");
                break;
            case "2":
                System.out.println("You chose automatic");
                break;
            default:
                System.out.println("You chose something beyond the scope of this project");
                break;
        } Store.newline();
    }
    public static void COMMAND_U()
    {
        System.out.println("Here are all inventory items retrieved from WowServer:");
        System.out.println("...none so far...\n");
    }
}