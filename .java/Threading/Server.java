
// library imports
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
This is a Server class.
 */
public class Server
{
    // global properties
    static private ServerSocket serverSocket;
    static private Socket clientSocket;
    static private PrintWriter out;
    static private BufferedReader in;

    static Scanner cin = new Scanner(System.in);

    // Function to start the server and wait for connections on the specified port.
    static public void start(int port) throws IOException
    {
        // Wait for a client connection.
        System.out.println("\nWaiting for a Client connection to this server....");

        // open a socket and be ready to accept the first client that connects.
        serverSocket = new ServerSocket(port); // start the server on port etc.
        clientSocket = serverSocket.accept(); // listen for a client connection

        // If you get here, then a client connected to this server.
        System.out.println("\nReceived a Client connection from our Store on port " + clientSocket.getLocalPort());
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Wait for a response from the client and send a response back to the client.
        String response;
        response = in.readLine();
        System.out.printf("\nHere is a message from the client:\n-- \"%s\" --\nA message was sent back to the client.\n\n", response);
        out.println("You are online!");

        // Admin User can now send commands to the store.
        if(!SendCommands()) {
            System.out.println("Sending commands has ended.");
        }

        // all responses have been received.
        System.out.println("Server is now shutting down...");
    }


    // Receive commands for Client-side class.
    static public void ReceiveCommands() throws IOException {
        // function properties
        String command = "";

        // function task
        while ( command != "end" ) {
            System.out.println( "Enter a command:\n" );
            switch ( cin.nextLine().trim() )
            {
                case "u":
                case "U":
                    System.out.println( "Command: U" );
                    break;

                case "r":
                case "R":
                    System.out.println( "Command: R" );
                    break;

                case "end":
                case "END":
                    System.out.println( "END of receiving commands." );
                    break;

                default:
                    System.out.println( "That command does not exist." );
                    break;
            }
        }
    }


    // Send Commands
    static public boolean SendCommands() {
        boolean on = true;
        do {
            System.out.print("Enter a command: ");
            switch ( cin.nextLine().trim() )
            {
                case "u":
                case "U":
                    System.out.println("Command: U");
                    out.println("Command: U was called from Admin User.");
                    break;

                case "r":
                case "R":
                    System.out.println("Command: R");
                    out.println("Command: R was called from Admin User.");
                    break;

                case "end":
                case "END":
                    System.out.println("END of sending commands.");
                    out.println("END of receiving commands from Admin User.");
                    on = false;
                    break;

                default:
                    System.out.println("That command does not exist.");
                    break;
            }
            System.out.println();
        } while (on);
        return on;
    }


    // this function closes any open utilities before ending program.
    static public void cleanup() throws IOException {
        // Close all input and output network buffers and sockets
        try
        {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Server resources have been cleaned up.");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Nonfatal crash.");
        }
    }

    // this main branch starts the server.
    public static void main(String[] args) throws IOException
    {
        ServerThread ServerThread = new ServerThread("Server Thread");
        Thread serverThread = new Thread(ServerThread);
        serverThread.start();

        cleanup();
    }

} // end of Server class.

/*
<-- Additional Assignment Notes -->

1. Ability to send Administration commands over the local network from an Admin User to the Store Front Application --

2. Command: U, will update the Store Inventory Management System with new Salable Products.
    The data payload will be a JSON string of Salable Products. --

3. Command: R, will return all of the Salable Products from the Store Inventory Management System in JSON format. --

4. The Administration Service should be run in the background,
    such that it does not impact the User while interacting with the Store Front Application,
    and should leverage the File Server to read and write JSON inventory data files.

5. Update UML

6. Update FLOWCHART

7. Create JavaDocs

8. Create a Screencast Presentation

9. Upload to Github

10. Submit the assignment

 */