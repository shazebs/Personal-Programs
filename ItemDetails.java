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
//------------------------------------------------------------------------------------------------------------------
