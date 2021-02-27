// Author: @shazebs
// Date:   1/14/21
// Time:   12:38 AM
// Last update: 1/27/20 @ 6:24 am

// import libraries
import java.util.Scanner;
import java.util.ArrayList;

// driver class
public class MacroNutrients {

    // create Scanner
    static Scanner input = new Scanner(System.in);

    // text font color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    // background text color
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    // Global Constants
    private int proteinCals = 4;
    private int carbCals = 4;
    private int fatCals = 9;


    // start of main
    public static void main(String[] args) {
        System.out.println();

        // Array - Data Structure
        FoodItem[] foodItems = new FoodItem[45];
        //
        foodItems[1]  = new FoodItem("Greek Yogurt",             12, 8,  0);
        foodItems[2]  = new FoodItem("Danimals",                 2,  11, 0);
        foodItems[3]  = new FoodItem("8 Turkey aqSlices",        16, 6,  8);
        foodItems[4]  = new FoodItem("Slice of Bread",           3,  16, 1);
        foodItems[5]  = new FoodItem("Burger Bun",               4,  28, 2);
        foodItems[6]  = new FoodItem("Beef Patty",               17, 6,  28);
        foodItems[7]  = new FoodItem("4 Seekh Khebabs",          16, 2,  6);
        foodItems[8]  = new FoodItem("Bowl of Cereal",           2,  31, 1.5);
        foodItems[9]  = new FoodItem("1 cup of milk",            8,  13, 9);
        foodItems[10] = new FoodItem("White Egg",                6,  0,  5);
        foodItems[11] = new FoodItem("1 Scoop Protein Powder",   24, 8,  2.5);
        foodItems[12] = new FoodItem("1 Cup Almond Milk",        1,  21, 2.5);
        foodItems[13] = new FoodItem("Hot Pocket",               9,  40, 11);
        foodItems[14] = new FoodItem("Orange Chicken (1/2)",     44, 66, 26);
        foodItems[15] = new FoodItem("PediaSure Shake",          7,  33, 9);
        foodItems[16] = new FoodItem("Chunky's Soup",            18, 48, 15);
        foodItems[17] = new FoodItem("Chapati(Roti)",            3,  15, 3);
        foodItems[18] = new FoodItem("1 serving Mustard Greens", 2,  4,  0);
        foodItems[19] = new FoodItem("White Potato",             6,  63, 0.5);
        foodItems[20] = new FoodItem("Masoor ki Daal",           1,  2.5,0);
        foodItems[21] = new FoodItem("Chicken Patty",            10, 11, 11);
        foodItems[22] = new FoodItem("4 Hot'n'Spicy Wings",      11, 3,  13);
        foodItems[23] = new FoodItem("Tandoori Plain Naan",      9,  38, 6);
            foodItems[23].saturatedFat = (int) 3.5;
            foodItems[23].transFat = 0;
            foodItems[23].cholesterol = 0;
            foodItems[23].sodium = 170;
            foodItems[23].dietaryFiber = 1;
            foodItems[23].totalSugars = 3;
            foodItems[23].addedSugars = 2;
            foodItems[23].vitaminD = 0;
            foodItems[23].calcium = 21;
            foodItems[23].iron = 2;
            foodItems[23].potassium = 50;
        foodItems[24] = new FoodItem("Ashoka Tandoori Naan",     9,  53, 9);
            foodItems[24].saturatedFat = 5;
            foodItems[24].transFat = 0;
            foodItems[24].cholesterol = 20;
            foodItems[24].sodium = 360;
            foodItems[24].dietaryFiber = 2;
            foodItems[24].totalSugars = 0;
            foodItems[24].addedSugars = 0;
            foodItems[24].vitaminD = 0;
            foodItems[24].calcium = 60;
            foodItems[24].iron = 2;
            foodItems[24].potassium = 0;
        foodItems[25] = new FoodItem("Sesame-Seed Burger Buns",  7,  37, 3.5);
        foodItems[26] = new FoodItem("Whole Wheat Bread",        4,  11, 0.5);
        foodItems[27] = new FoodItem("Mini-Tortilla",            2,  21, 1);
        foodItems[28] = new FoodItem("Nutrition Bar",            10, 15, 12);


        // Juices
        foodItems[29] = new FoodItem("Raspberry Lemonade",       0,  28, 0);
            foodItems[29].totalSugars = 26;
            foodItems[29].addedSugars = 26;
        foodItems[30] = new FoodItem("Peach Juice",              0,  26, 0);
            foodItems[30].totalSugars = 25;
            foodItems[30].addedSugars = 21;


            // Fast Food Items
        // Raising Canes
        foodItems[31] = new FoodItem("Cane's Chicken Finger",   13, 5, 6);
            foodItems[31].saturatedFat = 1;
            foodItems[31].transFat = 0;
            foodItems[31].cholesterol = 40;
            foodItems[31].sodium = 190;
            foodItems[31].dietaryFiber = 1;
        foodItems[32] = new FoodItem("Cane's Crinkle-Cut Fries",       5, 49, 19);
            foodItems[32].saturatedFat = 1;
            foodItems[32].transFat = 0;
            foodItems[32].cholesterol = 0;
            foodItems[32].sodium = 310;
            foodItems[32].dietaryFiber = 7;
            foodItems[32].totalSugars = 1;
        foodItems[33] = new FoodItem("Cane's Texas Toast", 4, 23, 4);
            foodItems[33].saturatedFat = (int) 1.5;
            foodItems[33].sodium = 260;
            foodItems[33].dietaryFiber = 1;
            foodItems[33].totalSugars = 4;
        foodItems[34] = new FoodItem("Cane's Sauce", 0, 6, 19);
            foodItems[34].saturatedFat = 3;
            foodItems[34].transFat = 0;
            foodItems[34].cholesterol = 10;
            foodItems[34].sodium = 580;
            foodItems[34].totalSugars = 4;
            foodItems[34].dietaryFiber = 0;
        foodItems[35] = new FoodItem("Cane's Chicken Sandwich", 48, 66, 39);
            foodItems[35].saturatedFat = 6;
            foodItems[35].transFat = 0;
            foodItems[35].cholesterol = 120;
            foodItems[35].sodium = 1470;
            foodItems[35].dietaryFiber = 5;
            foodItems[35].totalSugars = 13;
        foodItems[36] = new FoodItem("Sprite Can (12 fl oz)", 0, 38, 0);
            foodItems[36].totalSugars = 38;
            foodItems[36].addedSugars = 38;
            foodItems[36].sodium = 65;
        foodItems[37] = new FoodItem("Kawan Plain Paratha", 4, 35, 14);
            foodItems[37].saturatedFat = 8;
            foodItems[37].transFat = 0;
            foodItems[37].cholesterol = 0;
            foodItems[37].sodium = 260;
            foodItems[37].dietaryFiber = 2;
            foodItems[37].totalSugars = 3;
            foodItems[37].addedSugars = 3;
            foodItems[37].vitaminD = 0;
            foodItems[37].calcium = 16;
            foodItems[37].iron = 1;
            foodItems[37].potassium = 60;
        foodItems[38] = new FoodItem("Naked Blue Machine", 2, 76, 0);
            foodItems[38].saturatedFat = 0;
            foodItems[38].transFat = 0;
            foodItems[38].cholesterol = 0;
            foodItems[38].sodium = 20;
            foodItems[38].dietaryFiber = 3;
            foodItems[38].totalSugars = 55;
            foodItems[38].addedSugars = 0;
            foodItems[38].vitaminD = 0;
            foodItems[38].vitaminC = 114;
            foodItems[38].vitaminE = 40;
            foodItems[38].vitaminA = 0;
            foodItems[38].calcium = 50;
            foodItems[38].iron = (int) 0.7;
            foodItems[38].potassium = 700;
            foodItems[38].niacin = 38;
            foodItems[38].vitaminB6 = (int) 3.8;
            foodItems[38].vitaminB12 = (int) 11.4;
            foodItems[38].pantothenicAcid = 19;
        foodItems[39] = new FoodItem("Naked Kale Blazer", 4, 40, 0);
        foodItems[40] = new FoodItem("Naked Orange Carrot Mango", 2, 55, 0);
            foodItems[40].saturatedFat = 0;
            foodItems[40].transFat = 0;
            foodItems[40].cholesterol = 0;
            foodItems[40].sodium = 50;
            foodItems[40].dietaryFiber = 2;
            foodItems[40].totalSugars = 49;
            foodItems[40].addedSugars = 0;
            foodItems[40].vitaminD = 0;
            foodItems[40].vitaminC = 90;
            foodItems[40].vitaminE = 0;
            foodItems[40].vitaminA = 850;
            foodItems[40].calcium = 40;
            foodItems[40].iron = 1.5;
            foodItems[40].potassium = 840;
            foodItems[40].niacin = 38;
            foodItems[40].vitaminB6 = 0;
            foodItems[40].vitaminB12 = 0;
            foodItems[40].pantothenicAcid = 0;
        foodItems[41] = new FoodItem("Naked Power-C", 2, 55, 0);
        foodItems[42] = new FoodItem("Naked Tropical Guava", 3, 62, 0);
            foodItems[42].saturatedFat = 0;
            foodItems[42].transFat = 0;
            foodItems[42].cholesterol = 0;
            foodItems[42].sodium = 15;
            foodItems[42].dietaryFiber = 9;
            foodItems[42].totalSugars = 50;
            foodItems[42].addedSugars = 0;
            foodItems[42].vitaminD = 0;
            foodItems[42].iron = 0.4;
            foodItems[42].vitaminC = 135;
            foodItems[42].calcium = 50;
            foodItems[42].potassium = 800;
        foodItems[43] = new FoodItem("Tropicana Orange Juice", 2, 26, 0);
            foodItems[43].sodium = 0;
            foodItems[43].totalSugars = 22;
            foodItems[43].addedSugars = 0;
            foodItems[43].vitaminD = 0;
            foodItems[43].potassium = 450;
            foodItems[43].calcium = 20;
            foodItems[43].vitaminC = 78;
        foodItems[44] = new FoodItem("Progresso Chicken Tortilla Soup", 11, 31, 2);
            foodItems[44].saturatedFat = 0;
            foodItems[44].transFat = 0;
            foodItems[44].cholesterol = 15;
            foodItems[44].sodium = 1350;
            foodItems[44].dietaryFiber = 5;
            foodItems[44].totalSugars = 7;
            foodItems[44].addedSugars = 0.5;
            foodItems[44].vitaminD = 0;
            foodItems[44].calcium = 90;
            foodItems[44].iron = 2.3;
            foodItems[44].potassium = 1000;





        // Local variables
        ArrayList<Integer> menuChoices = new ArrayList<Integer>();

        // display food menu
        displayMenu(foodItems);

        // initialize menuChoices array
        initMenuChoices(menuChoices, foodItems);

        // print macro results
        displayMacros(menuChoices,foodItems);

        // ...
        dailyMacrosArray();




        //-----------------------------------------/
        // ** END PROGRAM **
        System.out.print(ANSI_RED);
        System.out.print("\nProgram has ended.");
        System.out.print(ANSI_RESET);
        System.out.printf(
                "%n%nNext on the list to do: \n" + ANSI_GREEN +
                        "\t+ make time to add micro nutrients to the menu items." + ANSI_RESET
        );
        System.exit(99);
    }


    // Main methods
    //
    /*                  displayMenu()               */
    public static void displayMenu(FoodItem[] arr) {
        // function variables
        // ...none so far.

        System.out.print(ANSI_WHITE_BACKGROUND);
        System.out.print(ANSI_BLACK);
        System.out.println("\t\t\t\t\t> FOOD MENU < ");
        System.out.print(ANSI_RESET);

        // print category titles
        System.out.print(ANSI_YELLOW);
        System.out.printf("    %-24s %8s  %5s %6s\n",
                "Food Item #", "Protein", "Carb", "Fat");
        System.out.print(ANSI_RESET);
        System.out.println("--------------------------------------------------------------------------");

        // loop and display food items
        for (int i = 1; i < arr.length; i++) {

            // start of Raising Cane's menu
            if (i == 31) {
                System.out.print("\n\\\\ Raising Cane's\n");

            }

            // numbering formatting
            if (i < 10) {
                System.out.print(i + ".  ");
            }
            else
                System.out.print(i + ". ");


            // print data
            System.out.printf("%-40s %-8.0f %-6.0f %-5.0f \n",
                    // #. 'itemName' 'protein' 'carb' 'fat' "\n"
                    arr[i].getItemName(),
                    arr[i].getProtein(),
                    arr[i].getCarb(),
                    arr[i].getFat()
            );
        } // end of loop
        System.out.println("----------------------------------------------------------------------------");
    }



    //
    /*                  intMenuChoices(ArrayList<Int>)               */
    public static void initMenuChoices(ArrayList<Integer> menuChoices, FoodItem[] foodItems) {
        // function variables
        int choice = -1; // initialize it to false

        // let user know how to end loop
        System.out.println("(To end the following loop enter 0)");

        // try...catch blocks
        do {
            try {
                //
                System.out.print(ANSI_GREEN +"Enter food item #: " + ANSI_RESET);
                choice = input.nextInt();

                // input validation
                choice = inputValidation(choice, (foodItems.length - 1) );

                if (choice != 0) {
                    //
                    int numLoops = ifChoice_ServingSize(choice);

                    // necessary for loop
                    for (int i = 0; i < numLoops; i++) {
                        menuChoices.add(choice);
                    }
                }

            } catch (Exception e) {
                System.err.println("You cannot enter letters or unknown character commands!\n");
                break;
            }
            //
        } while (choice != 0);

    }




    // find out how many servings ?
    public static int ifChoice_ServingSize(int c) {
        // function variables
        int servingSize =-1;

        if (c > 0) {
            System.out.print("How many: ");
            servingSize = input.nextInt();
            return servingSize;
        }
        else
            return servingSize;

    }



    /*                  displayMacros(ArrayList<Int>)           */
    public static void displayMacros(ArrayList<Integer> intArray,
                                       FoodItem[] foodArray) {
        // MacroNutrients running totals
        double totalMacros = 0;
        double totalCalories = 0;
        double totalProtein = 0;
        double totalCarb = 0;
        double totalFat = 0;
        // MicroNutrient running totals
        double totalSugars = 0;
        double totalAddedSugars = 0;
        double totalCholesterol = 0;
        double totalSodium = 0;
        double totalCalcium = 0;
        double totalIron = 0;
        double totalPotassium = 0;
        double totalDietaryFiber = 0;
        double totalNiacin = 0;
        double totalRiboflavin = 0;
        double totalThiamine = 0;
        double totalPantothenicAcid = 0;
        double totalSaturatedFat = 0;
        double totalTransFat = 0;
        double totalPolyunsaturatedFat = 0;
        double totalMonounsaturatedFat = 0;
        double totalVitaminA = 0;
        double totalVitaminB6 = 0;
        double totalVitaminB12 = 0;
        double totalVitaminC = 0;
        double totalVitaminD = 0;
        double totalVitaminE = 0;

        for (int i = 0; i < intArray.size(); i++) {

            // print MacroNutrient data
            totalProtein  += foodArray[intArray.get(i)].getProtein();
            totalCarb     += foodArray[intArray.get(i)].getCarb();
            totalFat      += foodArray[intArray.get(i)].getFat();
            totalCalories += foodArray[intArray.get(i)].getTotalCalories();
            totalMacros   += foodArray[intArray.get(i)].getTotalMacros();

            // print MicroNutrient data
            totalSugars             += foodArray[intArray.get(i)].totalSugars;
            totalAddedSugars        += foodArray[intArray.get(i)].addedSugars;
            totalCholesterol        += foodArray[intArray.get(i)].cholesterol;
            totalSodium             += foodArray[intArray.get(i)].sodium;
            totalCalcium            += foodArray[intArray.get(i)].calcium;
            totalIron               += foodArray[intArray.get(i)].iron;
            totalPotassium          += foodArray[intArray.get(i)].potassium;
            totalDietaryFiber       += foodArray[intArray.get(i)].dietaryFiber;
            totalRiboflavin         += foodArray[intArray.get(i)].riboflavin;
            totalThiamine           += foodArray[intArray.get(i)].thiamine;
            totalPantothenicAcid    += foodArray[intArray.get(i)].pantothenicAcid;
            totalSaturatedFat       += foodArray[intArray.get(i)].saturatedFat;
            totalTransFat           += foodArray[intArray.get(i)].transFat;
            totalPolyunsaturatedFat += foodArray[intArray.get(i)].polyunsaturatedFat;
            totalMonounsaturatedFat += foodArray[intArray.get(i)].monounsaturatedFat;
            totalVitaminA           += foodArray[intArray.get(i)].vitaminA;
            totalVitaminB6          += foodArray[intArray.get(i)].vitaminB6;
            totalVitaminB12         += foodArray[intArray.get(i)].vitaminB12;
            totalVitaminC           += foodArray[intArray.get(i)].vitaminC;
            totalVitaminD           += foodArray[intArray.get(i)].vitaminD;
            totalVitaminE           += foodArray[intArray.get(i)].vitaminE;

        }

        System.out.printf(
                        "%n%s %.0fg\n" +
                        "%s \n" +
                        "%-9s %.0fg\n" +
                        "%-9s %.0fg\n" +
                        "%-9s %.0fg\n" +
                        "(%.0f Calories)\n" +
                        "%s\n\n" +

                        /*
                        -------------------
                        Protein:  54g (19%)
                        Carbs:    172g (61%)
                        Fats:     56g (20%)
                        -------------------
                        Total: 282g
                        (1404 Calories)
                         */

                        "%s \n" +           // MicroNutrients
                        "%s \n" +           // -----------------

                        "%-20s %.0fg\n" +   // Total Sugars:
                        "%-20s %.0fg\n" +   // Added Sugars:
                        "%-20s %.0fmg\n" +  // Cholesterol:
                        "%-20s %.0fmg\n" +   // Sodium:
                        "%-20s %.0fmg\n" +   // Calcium:
                        "%-20s %.0fmg\n" +   // Iron:
                        "%-20s %.0fmg\n" +   // Potassium:
                        "%-20s %.0fg\n" +   // Dietary Fiber:
                        "%-20s %.0fg\n" +   // Niacin:
                        "%-20s %.0fg\n" +   // Riboflavin:
                        "%-20s %.0fg\n" +   // Thiamine:
                        "%-20s %.0fg\n" +   // Pantothenic Acid:
                        "%-20s %.0fg\n" +   // Saturated Fat:
                        "%-20s %.0fg\n" +   // TransFat:
                        "%-20s %.0fg\n" +   // Polyunsaturated Fat:
                        "%-20s %.0fg\n" +   // Monounsaturated Fat:
                        "%-20s %.0fmcg\n" +   // Vitamin A:
                        "%-20s %.0fmg\n" +   // Vitamin B6:
                        "%-20s %.0fmg\n" +   // Vitamin B12:
                        "%-20s %.0fmg\n" +   // Vitamin C:
                        "%-20s %.0fmg\n" +   // Vitamin D:
                        "%-20s %.0fmg\n"  +  // Vitamin E:
                        "%s\n\n",


                "Macros:", totalMacros,
                "---------------",
                "Proteins:", totalProtein,
                "Carbs:",    totalCarb,
                "Fats:",     totalFat,
                totalCalories,
                "---------------",

                "MicroNutrients:",
                "-----------------------",
                "Total Sugars:",        totalSugars,
                "Added Sugars:",        totalAddedSugars,
                "Cholesterol:",         totalCholesterol,
                "Sodium:",              totalSodium,
                "Calcium:",             totalCalcium,
                "Iron:",                totalIron,
                "Potassium:",           totalPotassium,
                "Dietary Fiber:",       totalDietaryFiber,
                "Niacin:",              totalNiacin,
                "Riboflavin:",          totalRiboflavin,
                "Thiamine:",            totalThiamine,
                "Pantothenic Acid:",    totalPantothenicAcid,
                "Saturated Fat:",       totalSaturatedFat,
                "TransFat:",            totalTransFat,
                "Polyunsaturated Fat:", totalPolyunsaturatedFat,
                "Monounsaturated Fat:", totalMonounsaturatedFat,
                "Vitamin A:",           totalVitaminA,
                "Vitamin B6:",          totalVitaminB6,
                "Vitamin B12:",         totalVitaminB12,
                "Vitamin C:",           totalVitaminC,
                "Vitamin D:",           totalVitaminD,
                "Vitamin E:",           totalVitaminE,
                "-----------------------"
                );
    }



    // input validation method for array bounds
    /*                inputValidation(int)          */
    public static int inputValidation(int choice, int arrLength) {
        // function variables
        // ... none so far

        while (choice < 0 || choice > arrLength) {
            System.out.print("Error! Enter valid food item #: ");
            choice = input.nextInt();
        }

        return choice;

    }


    // ... > incomplete <
    // this method holds an array containing E.O.D macros
    public static void dailyMacrosArray() {
        // function variables
        int[] dailyMacros = {
                1104 // 1/27/21 - Wednesday
        };

    }


} // end of class MacroNutrients.java



/*
* Additional Notes:
* - We need to add micro nutrients into the FoodItem.class
*
* */

// last update : 1/27/21
// class for food menu
class FoodItem {

    // instance variables
    private String itemName;

    // macronutrient variables
    private int proteinCals = 4, carbCals = 4, fatCals = 9; // values can't be changed unless with a method
    private double protein, carb, fat;

    // micronutrient variables
    double totalSugars;     // in grams
    double addedSugars;     // avoid this category
    double cholesterol;     // mg - less than 200 mg daily limit
    double sodium;          // salt mg - less than 2,300 mg daily limit
    double calcium;         // bones mg - 1000 mg daily requirement
    double iron;            // mg - 8.7 mg daily requirement
    double potassium;       // mg - 3,500-4,700 mg daily requirement
    double vitaminD;        // bones mg - 20 mcg daily requirement
    double vitaminA;        // 900 mcg daily requirement
    double vitaminE;        // 15 mg daily daily requirement
    double vitaminC;        // 90 mg daily daily requirement
    double vitaminB12;      // 6 mcg
    double vitaminB6;       // 1.7 mg
    double dietaryFiber;    // in grams
    double niacin;          // 16 mg daily limit
    double riboflavin;      // 1.3 mg daily limit
    double thiamine;        // vitamin B₁ - 1.2 mg daily limit
    double pantothenicAcid; // vitamin B5 - 5-10 mg daily limit
    double saturatedFat;    // 16 to 22 g daily limit
    double transFat;        // 2g daily limit
    double polyunsaturatedFat; // <22 g daily limit
    double monounsaturatedFat; // <44 g daily limit



    // constructor #0
    FoodItem(){} // no-args
    //
    // constructor #1
    FoodItem(String item, double p, double c, double f) {
        itemName = item;
        protein = p;
        carb = c;
        fat = f;
    }

    // SET METHODS
    // set 'itemName'
    public void setItemName(String item) {
        itemName = item;
    }

    // set 'protein'
    public void setProtein(double p) {
        protein = p;
    }

    // set 'carb'
    public void setCarb(double c) {
        protein = c;
    }

    // set 'fat'
    public void setFat(double f) {
        protein = f;
    }

    // GET METHODS
    // get 'itemName'
    public String getItemName() {return itemName;}

    // get 'protein'
    public double getProtein() { return protein; }

    // get 'carb'
    public double getCarb() { return carb; }

    // get 'fat'
    public double getFat() { return fat; }


    // Calculation Methods
    // get total calories
    public double getTotalCalories() {
        return (
                (protein*proteinCals) +
                (carb*carbCals) +
                (fat*fatCals)
        );
    }

    // get total macros
    public double getTotalMacros() {
        return (protein + carb + fat);
    }


} // end of class FoodItem.java
