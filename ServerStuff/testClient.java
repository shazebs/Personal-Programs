
// library imports
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class testClient {
    public static void main(String[] args0) throws IOException
    {
        try {
            Client serverClient = new Client();
            serverClient.start("127.0.0.1", 4444);
            System.out.println("This client has connected to JServer.");
        }
        catch (Exception error)
        {
            error.printStackTrace();
            System.out.println("This client did not connect to JServer.");
        }

        System.out.print("\nThis program has now ended.");
        System.exit(999);
    }
}
