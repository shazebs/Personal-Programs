
// This is the Admin user.
public class Admin
{
    public static void main(String[] args)
    {
        // Create an Admin server.
        ServerThread AdminThread = new ServerThread("Admin Thread");
        Thread adminThread = new Thread(AdminThread);
        adminThread.start();
    }
}
