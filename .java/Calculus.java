// Author: Shazeb Suhail
// Date:   1/13/21
// Time:   11:39 PM

// import libraries
import java.util.Scanner;

public class Calculus {

    // Global Constants
    //-----------------//
    // fundamental identities
    private static String fundamental1 = "sin(x)cos(x) = ½sin(x)";
    private static String fundamental2 = "sin2(x) = 2sin(x)cos(x)";
    private static String fundamental3a = "cos2(x) = ½sin2(x)";
    private static String fundamental3b = "cos2(x) = 1-2sin²(x)";
    private static String fundamental4 = "2sin²(x) = 1-cos2(x)";
    private static String fundamental5 = "1 + tan²(x) = sec²(x)";
    private static String fundamental6 = "1 + cot²(x) = csc²(x)";
    private static String fundamental7 = "1 = cos²(x) + sin²(x)";

    // F.O.I.L.
    private static String cubedFoil = "(a³ + b³) = (a + b)(a² - ab + b²)";

    // (7.1) integrate by parts
    private static String integrateByPartsFormula = "uv - ∫vdu";

    // (7.2) power down identities
    private static String trigPowerDown1 = "sin²(x) = ½[1-cos2(x)]"; // power down rule
    private static String trigPowerDown2 = "cos²(x) = ½[1+cos2(x)]"; // power down rule

    // (7.3) trig sub identities
    private static String trigSub1a = "sqrt[1-sin²(x)] = cos(x)";
    private static String trigSub1b = "sqrt[1-cos²(x)] = sin(x)";
    private static String trigSub2 = "sqrt[1+tan²(x)] = sec(x)";
    private static String trigSub3 = "sqrt[sec²(x)-1] = tan(x)";

    // (7.4) rational functions
    private static String rational1 =
            "[A/(x-a)] + [B/(x-b)]  \"if Q(x) = (x-a)(x-b)\"";
    private static String rational2 =
            "[A/(x-a)] + [B/(x-a)²] \"if Q(x) = (x-a)²\"";

    // (7.2) approximate integral formulas
    private static String changeInX = " ⃤ x = (b - a)/n";
    private static String midpointRule =
            "∫a->b f(x)dx = Mn = [f(x₁) + f(x₂) + ... + f(xₙ)] ⃤ x";
    private static String trapezoidRule =
            "\"...\" = Tn = ( ⃤ x/2)[f(a) + 2f(x₁) + 2f(x₂) + ... + f(b)]"; // ∫a->b f(x)dx =
    private static String simpsonsRule =
            "\"...\" = Sn = ( ⃤ x/3)[f(a) + 4f(x₁) + 2f(x₂) + 4f(x₃) + ... + f(b)]";

    // Exponential growth and decay formulas
    private static String exponentialGrowth = "f(x) = a(1 + r)ⁿ";
    private static String exponentialDecay = "t = -xN";    // dN/dt = -xN
    // N = quantity
    // x = exponential decay constant
    // t = tim



    // COlORS
    //
    // text color
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String BLACKTEXT = "\u001B[30m";
    public static final String REDTEXT = "\u001B[31m";
    public static final String GREENTEXT = "\u001B[32m";
    public static final String YELLOWTEXT = "\u001B[33m";
    public static final String BLUETEXT = "\u001B[34m";
    public static final String PURPLETEXT = "\u001B[35m";
    public static final String CYANTEXT = "\u001B[36m";
    public static final String WHITETEXT = "\u001B[37m";

    // text wrap color
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


    // class main.
    public static void main(String[] args) {
        System.out.println();
        Scanner input = new Scanner(System.in);

        // for Ryan
        // System.out.println(Math.sin(Math.toRadians(35)));

        System.out.println("\tMAIN MENU:");
        System.out.println("[1] Display Math Formulas");
        System.out.println("[2] Switch to Exponential Growth Calculator");
        System.out.print(GREENTEXT + "Selection: ");
        int selection = input.nextInt();
        newline();
        //
        switch(selection) {
            case 1:
                displayAllFormulas();
                break;
            case 2:
                exponentialGrowthCalculator(input);
                break;
            default:
                System.out.print("You entered an unknown menu option!");
        }


        // ** END PROGRAM **
        // last statement of main method.
        System.out.println("Program has ended. Game over.");
        System.exit(99);
    }


    // functions list
    //
    // analysis a value as a derivative or antiderivative
    public static void valueAnalysis(String dx) {
        // function variables
        // ....incomplete....

    }
    //
    // display an array
    public static void displayArray(String...array) {
        for (String index : array) {
            System.out.println(index);
        }
    }
    //
    // newline
    public static void newline() {System.out.println();}
    //
    //
    // *display* fundamental equations
    public static void displayFundamentalEquations() {
        // array
        String[] calculus = {fundamental1, fundamental2,
                fundamental3a, fundamental3b, fundamental4,
                fundamental5, fundamental6, fundamental7};

        // *display fundamental trig functions
        System.out.print(YELLOWTEXT);
        System.out.print("// Fundamental Equations\n");
        System.out.print(COLOR_RESET);
        displayArray(calculus);

        // new line
        System.out.println();
    }
    //
    // *display power down identities
    public static void displayTrigPowerDown() {
        // array
        String[] calculus = {trigPowerDown1, trigPowerDown2};

        // display fundamental trig functions
        System.out.print(YELLOWTEXT);
        System.out.print("// Power Down Identities\n");
        System.out.print(COLOR_RESET);
        displayArray(calculus);

        // new line
        System.out.println();
    }
    //
    // *display trig substitution identities
    public static void displayTrigSubs() {
        // array
        String[] calculus = {
                trigSub1a, trigSub1b, trigSub2, trigSub3};

        // display fundamental trig functions
        System.out.print(YELLOWTEXT);
        System.out.print("// (7.3) Trig Subs\n");
        System.out.print(COLOR_RESET);
        displayArray(calculus);

        // new line
        System.out.println();
    }
    //
    // *display trig substitution identities
    public static void displayRationalFunctions() {
        // array
        String[] calculus = {
                rational1, rational2};

        // display fundamental trig functions
        System.out.print(YELLOWTEXT);
        System.out.print("// (7.4) Rational Function Formulas\n");
        System.out.print(COLOR_RESET);
        displayArray(calculus);

        // new line
        System.out.println();
    }
    //
    // *display (7.2) integrate by parts formula
    public static void displayIntegrateByPartsFormula() {

        System.out.print(YELLOWTEXT);
        System.out.print("// (7.2) Integrate by Parts Formula\n");
        System.out.print(COLOR_RESET);
        System.out.println(integrateByPartsFormula);

        // new line
        System.out.println();
    }
    //
    // *display F.O.I.L patterns
    public static void displayFOIL() {
        //array
        String[] calculus = {
                cubedFoil
        };
        System.out.print(YELLOWTEXT);
        System.out.print("// F.O.I.L Formulas\n");
        System.out.print(COLOR_RESET);
        displayArray(calculus);

        // new line
        System.out.println();
    }
    //
    // *dipslay approximate integral formulas
    public static void displayApproximateIntegralFormulas() {
        // array
        String[] calculus = { changeInX,
                midpointRule, trapezoidRule, simpsonsRule
        };
        System.out.print(YELLOWTEXT);
        System.out.print("// (7.7) Midpoint Rules, Trapezoid Rule," +
                "and Simpson's Rule\n");
        System.out.print(COLOR_RESET);
        displayArray(calculus);
        // new line
        System.out.println() ;
    }
    //
    // Pari's Algebra homework
    public static void exponentialGrowthCalculator(Scanner in) {
        // function variables
        double a = 0.0;     // a = initial amount
        double r = 0.0;     // growth rate
        double n = 0.0;     // number of time intervals

        System.out.print(YELLOWTEXT + "Formulas" + COLOR_RESET);
        System.out.println("\nExponential Growth : " + exponentialGrowth + "\nExponential Decay  : " + exponentialDecay);
        System.out.println();

        for (int i = 0; i < 10; i++) {

            // exit loop condition
            if (i == 9) {
                System.out.print("You have reached the max number of tries! Back to main menu now.");
                break;
            }

            // get user inputs
            System.out.print("Enter initial amount (a) = ");
            a = in.nextDouble();
            System.out.print("Enter growth rate (r) = ");
            r = in.nextDouble();
            System.out.print("Enter time interval (n) = ");
            n = in.nextDouble();

            // calculation
            double temp = Math.pow((1 + r), n);
            double formulaAnswer = a * temp;

            // Print the answer to Question #1
            System.out.printf("%sAnswer = %.6f %s%n", GREENTEXT, formulaAnswer, COLOR_RESET);

            // newline
            System.out.print(REDTEXT + "Run again? (y/n): " + COLOR_RESET);
            char choice = in.next().charAt(0);

            // exit loop condition
            if (choice == 'n') {
                break;
            } newline();

        } // end for loop

        /*
        Question 1 : Find a bank account balance if the account starts with $100, has an annual rate of 4 %,
                    and the money left in the account for 12 years.

         */
    } // end of function 'exponentialGrowthCalculator'


    // display all formulas
    public static void displayAllFormulas() {
        // Display Formulas
        // method calls
        displayFundamentalEquations();
        //
        displayFOIL();
        //
        displayTrigPowerDown();
        //
        displayIntegrateByPartsFormula();
        //
        displayTrigSubs();
        //
        displayRationalFunctions();
        //
        displayApproximateIntegralFormulas();
        //

    }



} // end of main method.



/*
Additional Notes:
------------------
// (9.3) Solve under 1 differential equations by "seperable method"
private String order1 = "y' + xy = x²";      // first derivative -- velocity function?
private String order2 = "y" + xy' = x²";    // second derivative -- position function : y = f(x)

// example's
------------------------------------------------
#1)  s(x) = y = x²   // speed
    v = y' = 2x     // velocity
    // t -> time
    s(t) = t²
    v(t) = s'(t) = 2t   // velocity equation
    ∫ s'(t) = ∫ 2t
    v(t) = t² + C  <-- ANS

// "Seperable Method"
#2)  dy/dx = x sqrt[y]
     dy/sqrt[y] = x dx
     y^(-1/2)dy = (1/2)x² + C
     2sqrt[y] = (1/2)x² + C
     2(1/2)y^(-1/2)(dy/dx) = x
     dy/dx = xsqrt[y]


 #4)  y' + xe^y = 0
      (dy/dx) = -xe^y
      e^-y(dy) = -x dx


 */
