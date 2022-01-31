package app;

// super-class
public class SalableProduct
{
    // properties
    private String name;
    private String description;
    private double price;
    int iLvl;

    // constructor(s)
    public SalableProduct(){
        name = "";
        description = "";
        price = 0.00;
        iLvl = 0;
    }
    public SalableProduct(String a, String b, double c, int d)
    {
        name = a;
        description = b;
        price = c;
        iLvl = d;
    }

    // class methods

    /**
     * 
     * @param Setter Methods
     */
    public void setName(String x) { this.name = x; }
    public void setDescription(String x) { this.description = x; }
    public void setPrice(double x) { this.price = x; }
    public void setItemLevel(int x) { this.iLvl = x; }

    /**
     * 
     * @return Getter methods 
     */
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public int getItemLevel() { return iLvl; }

    // toString
    @Override
    public String toString()
    {
        return String.format("%s\n%s\n$%,.2f\niLvl %d\n",
                name, description, price, iLvl);
    }
}
