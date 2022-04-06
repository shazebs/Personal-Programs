
// library imports
import java.io.IOException;

// start of Thread class.
public class Threads implements Runnable
{
    String threadName = "";

    Threads(String s) {threadName = s;}

    @Override
    public void run() {
        Timer();
    }

    public void Timer ()
    {
        System.out.println();
        int count = 0;
        while (count != 604800) {
            System.out.printf("%s started %ds ago.\n", threadName, count++);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException error) {
                System.out.println("An \"InterruptedException\" was thrown in " + threadName);
            }
        }
        System.out.println("A week has passed.");
        System.out.print("\nThe program has now ended.");
        System.exit(999);
    }

    public static void main(String[] args)
    {
        Threads MyThread = new Threads("Test Thread");
        Thread myThread = new Thread(MyThread);
        myThread.start();
    }

} // end of Thread class.
