import java.util.Random;
import java.io.IOException;

public class ServerThread implements Runnable
{
    // Properties
    Random rand = new Random();
    String $thread = "";

    // Constructor
    ServerThread(String $thread){
        this.$thread = $thread;
    }

    @Override
    public void run()
    {
        Timer(5);
        /*Server server = new Server();
        try
        {
            // Starting the server.
            server.start(6667);

            // Close in/out buffers and socket.
            server.cleanup();
        }
        catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    // Timer function.
    public void Timer(int t){
        // Create a Timer ofo 60 seconds
        for (int i = t ; t >= i ; i--)
        {
            System.out.println($thread + " " + i);

            // Putting the thread to sleep example.
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {

            }
            if (i == 0)
            {
                System.out.println("Timer ended.");
                for (var j = 0; j < 1000000; j++)
                {
                    System.out.println($thread + " timer started " + j + " seconds ago.");

                    // Putting the thread to sleep example.
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {

                    }
                }
            }
        }
    }
}
