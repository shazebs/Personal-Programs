
// library imports
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
This is a server class.
 */
public class Server
{
    // global properties
    static private ServerSocket serverSocket;
    static private Socket clientSocket;
    static private PrintWriter out;
    static private BufferedReader in;

    // Function to start the server and wait for connections on the specified port.
    static public void start(int port) throws IOException
    {
        // Wait for a client connection.
        System.out.println("\nWaiting for a Client connection to our Store....");

        // open a socket and be ready to accept the first client that connects.
        serverSocket = new ServerSocket(port); // start the server on port etc.
        clientSocket = serverSocket.accept(); // listen for a client connection

        // If you get here, then a client connected to this server.
        System.out.println("\nReceived a Client connection from our Store on port " + clientSocket.getLocalPort());
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        // Wait for responses from the client.
        String response;
        while ((response = in.readLine()) != null)
        {
            System.out.printf("\nHere is a message from the client:\n-- \"%s\" --\n\n", response);
            String line = "Server's response: \"Hello from Admin User.\"";
            out.printf(line);
            break;
        }

        // all responses have been received.
        System.out.println("Server is now shutting down...");
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
            System.out.println("\nServer resources have been cleaned up.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // this main branch starts the server.
    public static void main(String[] args) throws IOException
    {
        ServerThread ServerThread = new ServerThread("Server Thread");
        Thread serverThread = new Thread(ServerThread);
        serverThread.start();

        // cleanup();
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
