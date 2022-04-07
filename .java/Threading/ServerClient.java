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

    // start a client socket on a specific port of our choice.
    static public void start(String ip, int port) throws UnknownHostException, IOException
    {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    // send a message to the server hosting the socket we are connected to from this app.
    static public String sendMessage(String msg) throws IOException
    {
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

    public static void main(String[] args) throws IOException
    {
        ServerThread Timer = new ServerThread("Weed Detox");
        Thread timer = new Thread(Timer);
        timer.start();
    }
}
