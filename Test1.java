// Author: Shazeb Suhail
// Date:   11/21/20
// Time:   7:06 PM
// Testing 'interface' 'Payable' and concrete class 'Sum'

// imported libraries
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        // create a 'Scanner' object
        Scanner input = new Scanner(System.in);

        // create a payable object
        mainClass object = new mainClass();

        // call 'Sum' method from main method variable 'sum' object
        // System.out.printf("Sum: %,.2f\n", object.Sum(10,10,60,10,10));

        // method setTaxRate test
        // System.out.println();
        // object.setTaxRate();
        // System.out.println(object.getTaxRateToString());

        // create an ItemDetails object, (ItemDetails extends mainClass)
        ItemDetails item0 = new ItemDetails("Battlefield 4", 1, 10.00);
        ItemDetails item1 = new ItemDetails("Gears of War 4", 1, 5.00);
        ItemDetails item2 = new ItemDetails("Assassin's Creed IV: Black Flag", 1, 15.00);
        ItemDetails item3 = new ItemDetails("Battlefield Hardline", 1, 5.00);
        ItemDetails item4 = new ItemDetails("Assassin's Creed Unity", 1, 15.00);

        ItemDetails[] items = new ItemDetails[5];
        items[0] = item0;
        items[1] = item1;
        items[2] = item2;
        items[3] = item3;
        items[4] = item4;

        // calculate total price of all items
        double totalPriceOfItems = 0.0;

        // Cacluate Sum of all item prices
        for (int item = 0; item < items.length; item++) {
            totalPriceOfItems += items[item].getPrice();
        }

        // Print details for all items
        for (int item = 0; item < items.length; item++) {
            System.out.printf("Item %d: %s \nQuantity: %d \nPrice: $%,.2f \n\n",
                    item+1, items[item].getName(), items[item].getQuantity(), items[item].getPrice());
        }

        // output Sum for all item prices
        System.out.printf("Sum: $%,.2f\n", totalPriceOfItems);

    }
}


// Author: Shazeb Suhail
// Date:   11/21/20
// Time:   9:01 PM

public class ItemDetails extends mainClass {
    // instance variables
    private String name; // to hold item's name
    private int quantity; // to hold quantity of items
    private double price;   // to hold price

    // constructor(s)
    //------------------------------------------------------------------------------------------------------------------
    public ItemDetails() {
        // no argument constructor
    }

    public ItemDetails(String name) {
        this.name = name;
    }

    public ItemDetails (String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public ItemDetails(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    // end of constructors


    // Set Methods
    //------------------------------------------------------------------------------------------------------------------

    // set 'name'
    public void setName(String name) {
        this.name = name;
    }

    // set 'quantity'
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // set 'price'
    public void setPrice(double price) {
        this.price = price;
    }


    // Get Methods
    //------------------------------------------------------------------------------------------------------------------

    // get 'name'
    public String getName() {return name;}

    // get 'quantity'
    public int getQuantity() {return quantity;}

    // get 'price'
    public double getPrice() {return price;}

} // end of class ItemDetails
