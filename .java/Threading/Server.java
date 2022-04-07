package server;

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
    static public void start(int port) throws IOException {
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
}
