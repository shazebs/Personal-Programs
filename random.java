// library imports
import java.io.*;

public class FilePlay
{
    private static int copyFile ( String inputFile, String outputFile ) {
        // Input and Output File Read/Writer declarations
        BufferedReader in = null;
        BufferedWriter out = null;

        try {
            // FileReader and FileWriter class objects
            in = new BufferedReader(new FileReader(inputFile));
            out = new BufferedWriter(new FileWriter(outputFile));

            // variable to hold ASCII numerical character
            String line;

			/* while in-reading file object doesn't have an ASCII key of -1 (end of file),
			 keep outputting the ASCII character to the out-writing file
			 then return 0 if everything was successful */
            while ((line = in.readLine()) != null)
            {
                String[] tokens = line.split("\\|");
                out.write(String.format("Name is %s %s of age %s\n", tokens[0], tokens[1], tokens[2]));
            }
            return 0;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
        catch (IOException e) {
            e.printStackTrace();
            return -2;
        }
        // finally closing block for try..catch
        finally {
            // try to close the files upon exit
            try {
                if (in != null)
                    in.close();
                if (out != null)
                    out.close();
            }
            // catch any IO exception that may be thrown and return -2
            catch (IOException e) {
                e.printStackTrace();
                return -2;
            }
        }
    }
    // main method
    public static void main(String[] args)
    {
        // call method to read/write files
        int err = FilePlay.copyFile("InUsers.txt", "OutUsers.txt");

        // display copy file results
        switch (err)
        {
            case 0:
                System.out.println("File was copied successfully.");
                break;
            case -1:
                System.out.println("File could not be opened.");
                break;
            case -2:
                System.out.println("File I/O error.");
                break;
        }
    }
}
