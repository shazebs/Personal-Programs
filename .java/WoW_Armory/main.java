import java.util.Scanner;

public class Milestone_2_cst_239
{
    // COlORS
    //
    // text color
    public static final String reset = "\u001B[0m";
    public static final String black = "\u001B[30m";
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";
    public static final String purple = "\u001B[35m";
    public static final String cyan = "\u001B[36m";
    public static final String white = "\u001B[37m";

    // main method
    public static void main(String[] args)
    {
        // Scanner object
        Scanner in = new Scanner(System.in);

        // display welcome message
        newline();
        System.out.println(blue + "Welcome to the World of Warcraft (WoW) Armory store!\n" + reset);

        // Instantiate some objects
        Weapon weapon1 = new Weapon();
        weapon1.setName("Recruit's Decapitator of the Quickblade");
        weapon1.setDescription("Soulbound Two-Handed Axe dealing 53-111 damage with an iLvl 120.");
        weapon1.setPrice(8757.50);
        weapon1.setQuantity(5);
        //
        Armor armor1 = new Armor();
        armor1.setName("Ceremonious Helm");
        armor1.setDescription("Plate armor, worn on head, soulbound with iLvl 117.");
        armor1.setPrice(3861.80);
        armor1.setQuantity(1);
        //
        Health health1 = new Health();
        health1.setName("Spiritual Healing Potion");
        health1.setDescription("Restores 10,000 health. (5 Min Cooldown)");
        health1.setPrice(75.00);
        health1.setQuantity(3);

        // print some output
        System.out.printf("%s%n%s%n%s%n", weapon1, armor1, health1);

    }

    // functions
    public static void newline() {System.out.println();}
    public static void newline(int x) { for(int i=0;i<x;i++) newline(); }
}


// super-class
class SalableProduct
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

// weapon
class Weapon extends SalableProduct
{
    // properties
    private String name;
    private String description;
    private double price;
    private int quantity;

    // constructor(s)
    public Weapon(){}
    public Weapon(String a, String b, double c, int d)
    {
        /*name = a;
        description = b;
        price = c;
        quantity = d;*/
        super();
    }

    // class methods

    // setters

    // getters
}

// armor
class Armor extends SalableProduct
{
    // properties
    private String name;
    private String description;
    private double price;
    private int quantity;

    // constructor(s)
    public Armor(){}
    public Armor(String a, String b, double c, int d)
    {
        /*name = a;
        description = b;
        price = c;
        quantity = d;*/
        super();
    }

    // class methods

    // setters

    // getters
}

// health
class Health extends SalableProduct
{
    // properties
    private String name;
    private String description;
    private double price;
    private int quantity;

    // constructor(s)
    public Health(){}
    public Health(String a, String b, double c, int d)
    {
        /*name = a;
        description = b;
        price = c;
        quantity = d;*/
        super();
    }

    // class methods

    // setters

    // getters
}
