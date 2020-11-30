import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// Author: Shazeb Suhail
// Date:   11/7/20
/*
(Quadrilateral Inheritance Hierarchy)
 Write an inheritance hierarchy for classes:
    > Quadrilateral
    > Trapezoid
    > Parallelogram
    > Rectangle
    > Square
 Use 'Quadrilateral' as the superclass of the hierarchy.
 Create and use a 'Point' class to represent the points in each shape.
 Make the hierarchy as deep (i.e. as many levels) as possible.
 Specify the instance variables and methods for each class.
 The 'private' instance variables of 'Quadrilateral' should be the x-y coordinate
 pairs for the four endpoints of the 'Quadrilateral'.
 Write a program that instantiates objects of your classes and outputs each
 object's area (except 'Quadrilateral').
 */
public class ShapeTest {
    public static void main(String[] args) {
        // Create Square class object
        Square squareObject = new Square(
                1,4,4,4,4,1,1,1);
        System.out.printf("%s\n%s\n", "Square object details:", squareObject);

        // Create a Rectangle class object
        Rectangle rectangleObject = new Rectangle(
                7,6,15,6,15,1,7,1);
        System.out.printf("%s\n%s\n", "Rectangle object details:", rectangleObject);

        // Create a Trapezoid class object
        Trapezoid trapezoidObject = new Trapezoid(
                -6,-2,-3,-2,-3,-8,-6,-6);
        System.out.printf("%s\n%s\n", "Trapezoid object details:", trapezoidObject);

        // Create a Parallelogram class object
        Parallelogram parallelogramObject = new Parallelogram(
                4,-3,10,-3,7,-7,1,-7);
        System.out.printf("%s\n%s\n", "Parallelogram object details", parallelogramObject);

        // Output End Prompts with Local Date/Time
        System.out.printf("\nThank You for using the Quadrilateral Application.\n");
        System.out.printf("Time of Calculation is <");

        // Get local date and time
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d, YYYY h:mm a");
        System.out.print(dtf.format(localDate));
        System.out.println(">");

        // Last Statement of the Program.
        System.exit(0);

    } // end of method main
} // end of class ShapeTest.java



// Author: Shazeb Suhail
// Date:   11/7/20
// Start of Superclass Quadrilateral
//----------------------------------
class Quadrilateral {
    // class Quadrilateral's instance variables
    private double pointA_x, pointA_y;
    private double pointB_x, pointB_y;
    private double pointC_x, pointC_y;
    private double pointD_x, pointD_y;

    private double side_A_to_B,
            side_B_to_C,
            side_C_to_D,
            side_D_to_A;

    // start of class Quadrilateral's constructor
    public Quadrilateral (double pointA_x, double pointA_y,
                          double pointB_x, double pointB_y,
                          double pointC_x, double pointC_y,
                          double pointD_x, double pointD_y) {
        // implicit call to class Object's constructor happens here

        // initialize private instance variables
        // Point A: x and y
        this.pointA_x = pointA_x;
        this.pointA_y = pointA_y;

        // Point B: x and y
        this.pointB_x = pointB_x;
        this.pointB_y = pointB_y;

        // Point C: x and y
        this.pointC_x = pointC_x;
        this.pointC_y = pointC_y;

        // Point D: x and y
        this.pointD_x = pointD_x;
        this.pointD_y = pointD_y;

        // set the side lengths now
        setSide_A_to_B();
        setSide_B_to_C();
        setSide_C_to_D();
        setSide_D_to_A();
    } // end of class Quadrilateral's constructor

    // GET METHODS
    // get individual point x and y coordinate values
    public double getPointA_x() {return pointA_x;}
    public double getPointA_y() {return pointA_y;}


    public double getPointB_x() {return pointB_x;}
    public double getPointB_y() {return pointB_y;}

    public double getPointC_x() {return pointC_x;}
    public double getPointC_y() {return pointC_y;}

    public double getPointD_x() {return pointD_x;}
    public double getPointD_y() {return pointD_y;}

    // get side lengths
    public double getSide_A_to_B() {return side_A_to_B;}
    public double getSide_B_to_C() {return side_B_to_C;}
    public double getSide_C_to_D() {return side_C_to_D;}
    public double getSide_D_to_A() {return side_D_to_A;}
    // end of Get methods

    // SET METHODS
    // Set Points: A, B, C, and D
    public void setPointA(double pointA_x, double pointA_y) {
        this.pointA_x = pointA_x;
        this.pointA_y = pointA_y;
    }

    public void setPointB(double pointB_x, double pointB_y) {
        this.pointB_x = pointB_x;
        this.pointB_y = pointB_y;
    }

    public void setPointC(double pointC_x, double pointC_y) {
        this.pointC_x = pointC_x;
        this.pointC_y = pointC_y;
    }

    public void setPointD(double pointD_x, double pointD_y) {
        this.pointD_x = pointD_x;
        this.pointD_y = pointD_y;
    }

    // initialize all side lengths of the Quadrilateral object
    public void setSide_A_to_B() {
        // calculate the length from pointA to pointB using distance formula
        double x_value = (getPointB_x() - getPointA_x());
        double y_value = (getPointB_y() - getPointA_y());
        side_A_to_B = Math.sqrt((x_value * x_value) + (y_value * y_value));

    }

    public void setSide_B_to_C() {
        // calculate the length from pointB to pointC using distance formula
        double x_value = (getPointC_x() - getPointB_x());
        double y_value = (getPointC_y() - getPointB_y());
        side_B_to_C = Math.sqrt((x_value * x_value) + (y_value * y_value));
    }

    public void setSide_C_to_D() {
        // calculate the length from pointC to pointD using distance formula
        double x_value = (getPointD_x() - getPointC_x());
        double y_value = (getPointD_y() - getPointC_y());
        side_C_to_D = Math.sqrt((x_value * x_value) + (y_value * y_value));
    }

    public void setSide_D_to_A() {
        // calculate the length from pointD to pointA using distance formula
        double x_value = (getPointA_x() - getPointD_x());
        double y_value = (getPointA_y() - getPointD_y());
        side_D_to_A = Math.sqrt((x_value * x_value) + (y_value * y_value));
    }
    // end of Set Methods

    // return a formatted String for values of the Quadrilateral's side lengths
    public String toString() {
        return String.format("%s%s%s%s\n%s%.2f\n%s%.2f\n%s%.2f\n%s%.2f\n",
                "Points: A(" + getPointA_x() + "," + getPointA_y() + "), ",
                "B(" + getPointB_x() + "," + getPointB_y() + "), ",
                "C(" + getPointC_x() + "," + getPointC_y() + "), ",
                "D(" + getPointD_x() + "," + getPointD_y() + ")",
                "Side AB is ", getSide_A_to_B(),
                "Side BC is ", getSide_B_to_C(),
                "Side CD is ", getSide_C_to_D(),
                "Side DA is ", getSide_D_to_A());
    }

} // end of class Quadrilateral


// Start of subclass Trapezoid
//----------------------------
class Trapezoid extends Quadrilateral {
    // class Trapezoid's instance variables
    private double height;

    // class Trapezoid's constructor
    public Trapezoid (double pointA_x, double pointA_y,
                      double pointB_x, double pointB_y,
                      double pointC_x, double pointC_y,
                      double pointD_x, double pointD_y) {

        // explicit call to superclass's constructor
        super(pointA_x, pointA_y,
                pointB_x, pointB_y,
                pointC_x, pointC_y,
                pointD_x, pointD_y);
    } // end of class Trapezoid's constructor

    // set height method
    public void setHeight(double height) {
        this.height = height;
    }

    // get height method
    public double getHeight() {return height;}

    // method to calculate Trapezoid's area goes here
    // however, it is incomplete

    // class Trapezoid's Overrided toString method
    public String toString() {
        return String.format("%s%s\n",
                super.toString(),
                "Area is N/A due to incompletion");
    }
} // end of subclass Trapezoid


// Start of subclass Parallelogram
//--------------------------------
class Parallelogram extends Trapezoid {
    // class Parallelogram's instance variables

    // class Parallelogram's constructor
    public Parallelogram (double pointA_x, double pointA_y,
                          double pointB_x, double pointB_y,
                          double pointC_x, double pointC_y,
                          double pointD_x, double pointD_y) {

        // explicit call to superclass's constructor
        super(pointA_x, pointA_y,
                pointB_x, pointB_y,
                pointC_x, pointC_y,
                pointD_x, pointD_y);
    } // end of class Parallelogram's constructor

    // method to calculate Parallelogram object's area goes here
    // however, it is incomplete

} // end of class Parallelogram


// Start of subclass Rectangle
//----------------------------
class Rectangle extends Quadrilateral {
    // class Rectangle's instance variables
    private double rectangleArea;
    // class Rectangle's constructor
    public Rectangle (double pointA_x, double pointA_y,
                      double pointB_x, double pointB_y,
                      double pointC_x, double pointC_y,
                      double pointD_x, double pointD_y) {

        // explicit call to superclass's constructor
        super(pointA_x, pointA_y,
                pointB_x, pointB_y,
                pointC_x, pointC_y,
                pointD_x, pointD_y);
    } // end of class Rectangle's constructor

    // return the area of a Rectangle object
    public double getRectangleArea() {
        return rectangleArea = super.getSide_A_to_B() * super.getSide_B_to_C();
    }

    // class Rectangle's Overidded toString method
    @Override
    public String toString() {
        return String.format("%s%s%.2f\n",
                super.toString(), "Area is ", getRectangleArea());
    }
}// end of class Rectangle


// Start of subclass Square
//-------------------------
class Square extends Quadrilateral {
    // class Square's instance variables
    private double squareArea; // to hold the value of area for a Square object

    // class Rectangle's constructor
    public Square (double pointA_x, double pointA_y,
                   double pointB_x, double pointB_y,
                   double pointC_x, double pointC_y,
                   double pointD_x, double pointD_y) {

        // explicit call to superclass's constructor
        super(pointA_x, pointA_y,
                pointB_x, pointB_y,
                pointC_x, pointC_y,
                pointD_x, pointD_y);
    } // end of class Square's constructor

    // return the area of a Square object
    public double getSquareArea() {
        return squareArea = super.getSide_A_to_B() * super.getSide_B_to_C();
    }

    // class Square's Overrided toString method
    @Override
    public String toString() {
        return String.format("%s%s%.2f\n",
                super.toString(), "Area is ", getSquareArea());
    }
} // end of class Square
