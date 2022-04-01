public class ServerClient
{

    /*
    Our server starts here.
    This is where we make

     */
    public static void main(String[] args)
    {
        // Create a Thread 1
        ServerThread KingThread = new ServerThread("King Thread");
        Thread kingThread = new Thread(KingThread);

        // Create a Thread 2
        ServerThread QueenThread = new ServerThread("Queen Thread");
        Thread queenThread = new Thread(QueenThread);

        // start the threads, automatically jumps into run() function.
        kingThread.start();
        queenThread.start();
    }
}
