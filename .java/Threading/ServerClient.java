
// library imports
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

// A Client class that can connect to a server.
public class ServerClient
{
    // global properties
    static private Socket clientSocket;    // connect to the specified IP address or port.
    static private PrintWriter out;        // for sending text over the socket to the Server.
    static private BufferedReader in;      // for receiving text over the socket from the Server.

    /*
    Our server starts here.
    This is where we make...
     */
    public static void main(String[] args) throws IOException
    {
        // Create a Thread 1
        ServerThread KingThread = new ServerThread("King Thread");
        Thread kingThread = new Thread(KingThread);

        // Create a Thread 2
        ServerThread QueenThread = new ServerThread("Queen Thread");
        Thread queenThread = new Thread(QueenThread);

        // Create a Thread 3 (Administrative Application)
        ServerThread AdministrationThread = new ServerThread("Administration Thread");
        Thread administrativeApp = new Thread (AdministrationThread);

        // Create a Thread 4 (Store Application)
        ServerThread StoreThread = new ServerThread("Store Thread");
        Thread storeThread = new Thread(StoreThread);

        // start the threads, automatically jumps into run() function.
        kingThread.start();
        // queenThread.start();

        // start administrative and store threads
        // administrativeApp.start();
        // storeThread.start();


        // Create a client and connect it to a server.
        ServerClient pawnClient = new ServerClient();
        pawnClient.start("127.0.0.1", 6666);

        // Send a message to the server.
        String response = sendMessage("Is this thing on?");

        // Receive a response from the server.
        System.out.println("\nServer response is " + response);

        // clean up code and close this program.
        cleanup();


        // Exit the program.
        System.exit(999);
    }


    // start a client socket on a specific port of our choice.
    static public void start(String ip, int port) throws UnknownHostException, IOException
    {
        clientSocket = new Socket(ip, port);

        // Create some input|output network buffers to communicate back and forth with the Server
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }


    // send a message to the server hosting the socket we are connected to from this app.
    static public String sendMessage(String msg) throws IOException
    {
        System.out.printf("This client will now send the message:\n-- \"%s\" --\nto the server.\n", msg);
        // Send/Print a Message to Server with a terminating line feed.
        out.println(msg);

        // Return the response from the Server.
        return in.readLine();
    }


    // close all open utilities
    static public void cleanup() throws IOException
    {
        // Close all input and output network buffers and sockets
        in.close();
        out.close();
        clientSocket.close();
    }
}
