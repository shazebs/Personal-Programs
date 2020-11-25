// Author: Shazeb Suhail
// Date:   11.21.20
// Time:   6:48 PM

// library imports
import java.util.InputMismatchException;
import java.util.Scanner;

// interface start
public interface Payable {
    public abstract double Sum(double...numbers); // return sum of prices
}
//----------------------------------------------------------------------------------------------------------------------

// The following code is how you make a {structure}/class for an 'item' object.
class mainClass implements Payable  {
    // Since this class is 'implementing' an interface, this {function}/method must complete the abstract class*
    // create a 'Scanner' object
    Scanner input = new Scanner(System.in);

    // instance variables
    private double taxRate = 0.0;

    //------------------------------------------------------------------------------------------------------------------

    // Set Methods

    //------------------------------------------------------------------------------------------------------------------
    // set taxRate
    public void setTaxRate() throws InputMismatchException {
        // local variables
        boolean loopCondition = true;

        // 'try...catch' in a 'DoWhile' to catch invalid taxRate input.
        do {
            try {
                // Ask user for input.
                System.out.print("Enter a Tax Rate in decimals: ");
                this.taxRate = input.nextDouble();

                // throw an exception if tax rate is wrong
                if (taxRate < 0 | taxRate > 1) {
                   // throw an exception
                  throw new Exception("\n(ERROR555): Tax Rate must be >= 0.0 and <= 0.1");
                }
                //
                loopCondition = false;
            }
            catch (InputMismatchException e) {
                System.out.println("\n(ERROR556): Tax Rate must be >= 0.0 and <= 0.1");
                input.nextLine();
            }
            catch (Exception e) {
                System.out.printf("%s\n", e.getMessage());
            }

        } while (loopCondition);

    } // end of setTaxRate method

    //------------------------------------------------------------------------------------------------------------------

    // Get Methods

    //------------------------------------------------------------------------------------------------------------------
    // get taxRate
    public double getTaxRate() {return taxRate;}

    // get taxRate toString
    public String getTaxRateToString() {
        return String.format("Tax Rate: %.2f%%", getTaxRate()*100);

    } // end of getTaxRateToString method
    //------------------------------------------------------------------------------------------------------------------

    // complete 'abstract' method inherited from 'interface' Payable
    // get sum
    @Override
    public double Sum(double...numbers) {
        double sum = 0.0; // local variables

        // calculate sum with 'enhanced for loop'
        for (double number : numbers) {
            sum += number;
        }

        // return Sum
        return sum;

    } // end of Sum method
    //------------------------------------------------------------------------------------------------------------------
}
