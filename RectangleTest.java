// Author: Shazeb Suhail
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RectangleTest {
    public static void main(String[] args) {
        // create a scanner object
        Scanner input = new Scanner(System.in);

        // create a Rectangle class
        Rectangle box = new Rectangle();

        // get initial values of perimeter and area
        System.out.println("Initial Values of box object:");
        System.out.printf("%s%.2f%n%s%.2f%n",
                "length: ", box.getLength(),
                "width:  ", box.getWidth());
        box.calcArea();
        box.calcPerimeter();

        // Ask user to initialize length and width
        // try...catch setLength
        try {
            System.out.print("\nNow...Enter a length in the range (0.00 -> 20.00): ");
            double length = input.nextDouble();
            box.setLength(length);

            // try...catch setWidth
            try {
                System.out.print("Enter a width in the range (0.00 -> 20.00): ");
                double width = input.nextDouble();
                box.setWidth(width);
            }
            catch (IllegalArgumentException e) {
                System.out.printf("%nERROR! Exception while initializing user specified length: %s%n",
                        e.getMessage());
            }
        }
        catch (IllegalArgumentException e) {
            System.out.printf("%nERROR! Exception while initializing user specified length: %s%n",
                    e.getMessage());
        }

        // return new values of length and width
        System.out.println("\nFinal values of box object:");
        System.out.printf("%s%.2f%n", "length: ", box.getLength());
        System.out.printf("%s%.2f%n", "width:  ", box.getWidth());
        box.calcArea();
        box.calcPerimeter();

        // End Prompts.
        //==================================================================================
        System.out.printf("\nThank you for using the Rectangle application.\n"); //
        System.out.printf("Time of calculation is <");                                    //
        // Get Local Date and Time.                                                       //
        LocalDateTime localDate = LocalDateTime.now();                                    //
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, YYYY h:mm a");       //
        System.out.print(dtf.format(localDate));                                          //
        System.out.println(">");                                                          //
        //==================================================================================

        // Last Statement of the Program.
        System.exit(0);
    }
}


// Author: Shazeb Suhail
/*
Create a class 'Rectangle' with attributes 'length' and 'width',
each of which defaults to 1. Provide methods that calculate the
rectangle's perimeter and area. It has set and get methods for
both length and width. The set methods should verify that length
and width are each floating-point numbers larger than 0.0 and less
than 20.0. Write a program to test class Rectangle.
 */
class Rectangle {
    // instance variables
    private double length;
    private double width;

    // default constructor initializes instance variables to 1
    public Rectangle() {
        this.length = 1.0;
        this.width = 1.0;
    }

    // Calculate perimeter method
    public void calcPerimeter() {
        // calculate perimeter
        double perimeter = (length*2 + width*2);

        // return perimeter value
        System.out.printf("%s%.2f%n", "Perimeter: ", perimeter);
    }

    // Calculate Area Method
    public void calcArea() {
        // calculate area
        double area = (length * width);

        // return area value
       System.out.printf("%s%.2f%n", "Area: ", area);
    }

    // Mutator Methods
    // set instance variable length
    public void setLength(double length) {
        // validate method argument before initializing instance variable 'length'
        if (length < 0.0 || length > 20.0) {
            throw new IllegalArgumentException(
                    "*length must be a floating-point value greater than 0 and less than 20");
        }

        this.length = length;
    }

    // set instance variable width
    public void setWidth(double width) {
        // validate method argument before initializing instance variable 'width'
        if (width < 0.0 || width > 20.0) {
            throw new IllegalArgumentException(
                    "*width must be a floating-point value greater than 0 and less than 20");
        }

        this.width = width;
    }

    // Accessor Methods
    // get instance variable length
    public double getLength() { return length; }

    // get instance variable width
    public double getWidth() { return width; }
}
