// Author: @shazebs
// Date:   12/27/20
// Time:   10:28 PM

// library imports
import java.util.Scanner;

public class GroceriesList {
    public static void main(String[] args) {
        // create Scanner object
        Scanner input = new Scanner(System.in);

        String[] groceriesPurchaseList = {
                "Water bottles",
                "Orange juice",
                "Simply watermelon juice",
                "Simply fruit punch juice",
                "Milk jugs",
                "Canola oil",
                "Cashews",
                "Peanuts",
                "Apples",
                "Bananas",
                "Grapes",
                "Eggs",
                "Yogurt",
                "Potatoes",
                "Sensodyne toothpaste",
                "Optic white toothpaste",
                "Crest toothpaste",
                "Body wash",
                "Almond Milk",
                "Turkey Slices",
                "Cereal",
                "Burger patties",
                "Burger buns",
                "Band-aids",
                "Ketchup",
                "Red Rooster hot sauce",
                "Chicken",
                "Beef",
                "Salmon",
                "Chicken drumsticks",
                "Frozen entrees",
                "Macaroni & chicken breast entrees",
                "Serrano peppers",
                "Cauliflower",
                "Bell peppers",
                "Carrots",
                "Bread",
                "Pediasure shakes",
                "Canned Soups",
                "Large supreme pizza",
                "Sponges",
                "Toilet paper",
                "Tomato seeds"
        };

        String[] groceriesAtHomeList = {
                "Corn cobs",
                "Chocolate chip waffles",
                "Mixed vegetables",
                "Onions",
                "Tomatoes",
                "Cilantro",
                "Leeks",
                "Butter",
                "Mayo",
                "Glazed bagels",
                "Mirchi ground",
                "Bread crumbs",
                "Salt",
                "Lemon pepper",
                "Black pepper",
                "Sugar",
                "Rice",
                "Protein cookies",
                "Cake rusk",
                "Nutrition bars",
                "Popsicles",
                "Waffle fries",
                "Puff pastries",
                "Hot pockets x 7",
                "Orange chicken x 1",
                "Small cheese pizza x 1",
                "Fettuccine Alfredo x 3",
                "Seekh kababs x 8",
                "Shami kababs x 10",
                "Mustard greens x 2",
                "Broccoli x 1",
                "Syrup",
                "Nutella",
                "Peanut butter",
                "Raw honey",
                "Basmati rice",
                "Mini tortillas"
        };


        // Stater Bros gift card amounts
        double  card_0970 = 25.00,
                card_6966 = 25.00,
                card_5920 = 25.00,
                card_6994 = 25.00,
                card_3986 = 25.00,
                card_0950 = 25.00;

        double total = card_0970 + card_6966 + card_5920 +
                        card_6994 + card_3986 + card_0950;


        // Print outputs
        System.out.println();
        System.out.printf("-- We have %s food items at home.\n",
                groceriesAtHomeList.length);
        System.out.printf("-- We need %s food items from the store.\n",
                groceriesPurchaseList.length);
        //
        System.out.printf("\nTOTAL money to spend $ %,.2f\n", total);



        // Print grocery list
        printArrayObjects(groceriesPurchaseList,
                " > Grocery shopping list <", 9);
        System.out.println();
        // Print food at home
        printArrayObjects(groceriesAtHomeList,
                "> Food at home <", 9);



        // System.exit()
        System.err.print("\nProgram successfully ended.");

    }
    //
    // Function Declarations
    //
    // method to print array contents
    public static void printArrayObjects(String[] array, String arrayName, int x) {

        System.out.printf("\n%s\n", arrayName);
        for (int i = 0; i < array.length; i++) {

            if (i < x) { // less than a specific amount
                System.out.print(i + 1 + ".  ");
                System.out.println(array[i]);
            } else {
                System.out.print(i + 1 + ". ");
                System.out.println(array[i]);
            }
        }

    }
} // end of main method.
