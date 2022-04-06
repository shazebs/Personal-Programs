import java.util.*;
import java.net.*;
import java.io.*;

public class Client 
{
    public static void main(String[] args) 
    {
        try (Socket socket = new Socket("localhost", 4445))
        {
            System.out.println("\nConnection to WowServer was successful.\nYou are online!\n");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    
            String line = null;    
            while (!"exit".equalsIgnoreCase(line)) {
                out.println(displayOptions());
                out.flush();
                System.out.printf("WowServer replied: \"%s\"\n\n", in.readLine());
            }
            cin.close();
            out.close();
            in.close();
            socket.close();
        }
        catch (ConnectException e) {
            e.printStackTrace();
            System.out.println("Restart WowServer.");
        }
        catch (SocketException e) {
            e.printStackTrace();
            System.out.println("WowServer shut down. Connection was lost.");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Read the error stack trace for more info.");
        }
    }
} 