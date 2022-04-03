import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// start of Server class.
class Server
{
    // properties
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter p_writer;
    private BufferedReader b_reader;

    public void start(int port) throws IOException
    {
        System.out.println("Server Socket is open, searching for a client connection...");
        // Open a server-side socket and listen for a client connection.
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();

        // Display a message if a client socket connects to the server socket.
        System.out.println("Received a new client socket on port: " + clientSocket.getLocalPort());

        // Initialize our PrintWriter and BufferedReader objects since a connection has formed.
        p_writer = new PrintWriter(clientSocket.getOutputStream(), true);
        b_reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("Server is online.\n");
    }

    public void cleanup() throws IOException {
        try {
            p_writer.close();
            b_reader.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Server resources have been cleaned up.");
        }
        catch (Exception error)
        {
            error.printStackTrace();
            System.out.println("No resources were open that needed to be closed.");
        }
    }

} // end of Server class.