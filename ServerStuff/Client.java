import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

// start of Client class.
class Client
{
    private Socket clientSocket;
    private PrintWriter p_writer;
    private BufferedReader b_reader;

    public void start(String ip, int port) throws UnknownHostException, IOException
    {
        clientSocket = new Socket(ip, port);

        p_writer = new PrintWriter(clientSocket.getOutputStream(), true);
        b_reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void cleanup() throws IOException
    {
        p_writer.close();
        b_reader.close();
        clientSocket.close();
    }

} // end of Client class.