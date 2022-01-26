package app;

// super-class
public class SalableProduct
{
    // properties
    private String name;
    private String description;
    private double price;
    private int quantity;

    // constructor(s)
    public SalableProduct(){
        name = "";
        description = "";
        price = 0.00;
        quantity = 0;
    }
    public SalableProduct(String a, String b, double c, int d)
    {
        name = a;
        description = b;
        price = c;
        quantity = d;
    }

    // class methods

    // setters
    public void setName(String x) { this.name = x; }
    public void setDescription(String x) { this.description = x; }
    public void setPrice(double x) { this.price = x; }
    public void setQuantity(int x) { this.quantity = x; }

    // getters
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    // toString
    @Override
    public String toString()
    {
        return String.format("Item Name: %s\nDescription: %s\nPrice: $%,.2f\nQuantity: %d\n",
                name, description, price, quantity);
    }
}
