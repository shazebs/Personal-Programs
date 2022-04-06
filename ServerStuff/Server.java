import java.io.*;
import java.net.*;
import java.util.*;

public class Server 
{
    public static void main(String[] args) 
    {
        ServerSocket server = null; 
        try {
            server = new ServerSocket(4445);
            server.setReuseAddress(true);

            System.out.println("Waiting for a connection...");
            while (true) {
                Socket client = WowServer.accept();

                System.out.println("New client connected: " + client.getInetAddress().getHostAddress());
    
                ClientThread clientSocket = new ClientThread(client);
    
                new Thread(clientSocket).start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Server could not be started.");
        } 
        finally {
            if (server != null) {
                try {
                    server.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class ClientThread implements Runnable
    {
        private final Socket clientSocket;

        public ClientThread(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            PrintWriter out = null;
            BufferedReader in = null;
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String line;

                while ((line = in.readLine()) != null)
                {
                    System.out.printf("Sent from AdminClient: \"%s\"\n", line);
                    out.println(line);
                }
            }
            catch (SocketException e) {
                System.out.println("AdminClient has been disconnected from the server.");
            }
            catch (IOException e){
                e.printStackTrace();
                System.out.println("Read the error logs.");
            }
            finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                        clientSocket.close();
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
} 