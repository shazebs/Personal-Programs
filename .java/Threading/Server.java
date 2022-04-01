
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
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    // Function to start the server and wait for connections on the specified port.
    public void start(int port) throws IOException
    {

        // Wait for a client connection.
        System.out.println("\nWaiting for a Client connection....");


        // open a socket and be ready to accept the first client that connects.
        serverSocket = new ServerSocket(port); // start the server on port etc.
        clientSocket = serverSocket.accept(); // listen for a client connection


        // If you get here, then a client connected to this server.
        System.out.println("Received a Client connection on port " + clientSocket.getLocalPort());
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        // Wait for responses from the client.
        String response;
        while ((response = in.readLine()) != null)
        {
            System.out.printf("\nHere is a message from the client:\n-- \"%s\" --\n\n", response);
            if ("Is this thing on?".equals(response)){
                out.println("Yes, this \"thing\" is on.");
                // break;
            }
        }

        // all responses have been received.
        System.out.println("Server is now shutting down...");
    }


    // this function closes any open utilities before ending program.
    public void cleanup() throws IOException
    {
        // Close all input and output network buffers and sockets
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }


    // this main branch starts the server.
    public static void main(String[] args) throws IOException
    {
        Server server = new Server();
        server.start(6666);
        server.cleanup();
    }
}

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
