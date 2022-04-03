
// library imports
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class main
{
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        Server JServer = new Server();

        try {
            JServer.start(4444);

            idleState(cin);

            System.out.println("\nThe server will now shut down");
            JServer.cleanup();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Server did not start.");
        }

        System.out.print("\nThis program has now ended.");
        System.exit(999);
    }

    public static void idleState(Scanner cin) {
        System.out.printf("-- MAIN MENU -- \n1) %s \n2) %s \n3) %s",
                "Command U", "Command R", "End server.\n> ");
        switch(cin.nextLine().trim())
        {
            case "1":
                Command_U();
                break;

            case "2":
                Command_R();
                break;

            case "3":
                return;

            default:
                System.out.println("\nYou entered something unknown.");
                break;
        }
    }

    public static void Command_U()
    {
        System.out.println("\nYou are now in Command U's function.");
    }

    public static void Command_R()
    {
        System.out.println("\nYou are now in Command R's function.");
    }

}