// Author: Shazeb Suhail
// Date:   11/21/20
// Time:   10:46 AM
/*
Write a program that demonstrates how various exceptions are caught with
    catch (Exception exception)
This time, define classes ExceptionA (which inherits from class Exception) and
ExceptionB (which inherits from class ExceptionA). In your program create try
blocks that throw exceptions of types ExceptionA, ExceptionB, NullPointerException,
and IOException. All exceptions should be caught with catch blocks specifying type
Exception.
 */
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExceptionHandlingTest {
    public static void main(String[] args) {
        // main method variables

        // Create a try...catch's
        // Try...catch for ExceptionA
        try {
            System.out.println("Calling method1");
            method1(); // this method throws an ExceptionA object
        }
        catch (Exception e) {
            System.out.printf("\t%s\n", e.toString());
        }

        // Try...catch for ExceptionB
        try {
            System.out.println("Calling method2");
            method2(); // this method throws an ExceptionB object
        }
        catch (Exception e) {
            System.out.printf("\t%s\n", e);
        }

        // Try...catch for NullPointerException
        try {
            System.out.println("Calling method3");
            method3(); // this method throws a NullPointerException
        }
        catch (Exception e) {
            System.out.printf("\t%s\n\n", e.toString());
        }

        // Try...catch for IOException
        try {
            System.out.println("Calling method4");
            method4(); // this method throws an IOException
        }
        catch (Exception e) {
            System.out.printf("\t%s\n", e);
        }

        // Print end output statements with a finally block
        finally {
            // get local date and time
            System.out.println("\nThank You for using the Exception application");
            System.out.print("Time of calculation is <");
            LocalDateTime localDate = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d,YYYY h:mm a");
            System.out.print(dtf.format(localDate));
            System.out.println(">");

            // End Program
            System.exit(0);
        }
    }

    // method1: throw a class ExceptionA object
    public static void method1() throws ExceptionA {
        throw new ExceptionA("an ExceptionA has been thrown");
    }

    // method2: throw a class ExceptionB object
    public static void method2() throws ExceptionB {
        throw new ExceptionB();
    }

    // method3: throw a class NullPointerException object
    public static void method3() throws NullPointerException {
        throw new NullPointerException("NullPointerException thrown in method3");
    }

    // method4: throw a class IOException object
    public static void method4() throws IOException {
        throw new IOException("IOException thrown in method4");
    }
}

// ExceptionA class inherits from class Exception
class ExceptionA extends Exception {
    // instance variables
    private String errorMessage;

    // constructor
    public ExceptionA() {
        // default initialization
    }
    public ExceptionA(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {return errorMessage;}

    // toString
    @Override
    public String toString() {
        return String.format("%s%s\n", "from class ExceptionA: ", getErrorMessage());
    }
}

// ExceptionB class inherits from class ExceptionA
class ExceptionB extends ExceptionA {
    // instance variables

    // toString
    @Override
    public String toString() {
        return String.format("%s%s\n", "from class ExceptionB: ", "an ExceptionB has been thrown");
    }
}

