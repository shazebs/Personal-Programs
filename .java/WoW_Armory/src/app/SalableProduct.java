package app;

/**
 * author: Shazeb Suhail
 * This SalableProduct class is the blueprint of all inventory item objects.
 */
public class SalableProduct
{
    // class properties
    private String name;
    private String description;
    private double price;
    int iLvl;
    String type;

    /**
     * Default Constructor
     *
     */
    public SalableProduct(){
        name = "";
        description = "";
        price = 0.00;
        iLvl = 0;
        type = ""; 
    }

    /**
     * Non-Default Constructor
     *
     */
    public SalableProduct(String a, String b, double c, int d, String e)
    {
        name = a;
        description = b;
        price = c;
        iLvl = d;
        type = e; 
    }

    /**
     * Setter Methods
     *
     */
    public void setName(String x) { this.name = x; }
    public void setDescription(String x) { this.description = x; }
    public void setPrice(double x) { this.price = x; }
    public void setItemLevel(int x) { this.iLvl = x; }
    public void setType(String x) { this.type = x; }

    /**
     * Getter methods
     *
     */
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public int getItemLevel() { return iLvl; }
    public String getType() { return type; }

    /**
     * Overrided ToString method
     *
     * @return String
     */
    @Override
    public String toString()
    {
        return String.format("%s\n%s\n%s\n$%,.2f\niLvl %d\n",
                name, type, description, price, iLvl);
    }
}