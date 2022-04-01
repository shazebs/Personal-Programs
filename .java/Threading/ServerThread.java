import java.util.Random;

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
        // Execute Thread commands in this order.
        Timer(rand.nextInt(180));
    }


    // Timer function.
    public void Timer(int t){
        // Create a Timer ofo 60 seconds
        for (int i = t ; t >= i ; i--)
        {
            System.out.println($thread + " " + i);

            // Try to make a "glitch" occur
            if (i == rand.nextInt(i+1)) System.out.println(" -- GLITCH -- " + $thread + " on " + i);

            // Putting the thread to sleep example.
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
            }
            if (i == 0) {
                System.out.println("Timer ended.");
                for (var j = 0; j < 1000000; j++)
                {
                    System.out.println($thread + "timer ended " + j + " seconds ago.");
                    // Putting the thread to sleep example.
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e){
                    }
                }
            }
        }
    }


} // end of ServerThread class.


/*
Additional Resources:

https://www.youtube.com/watch?v=r_MbozD32eo (Java Thread Youtube Tutorial)



 */
