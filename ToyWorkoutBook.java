// Author: @shazebs
// Date:   12/26/20
// Time:   7:06 PM

// library imports
//
// standards
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
//
// for working with files
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.NoSuchElementException;
import java.util.FormatterClosedException;
import java.util.Formatter;


public class WorkoutLogs {

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

    // start of main method
    public static void main(String[] args) throws IOException {
        // Scanner object
        Scanner in = new Scanner(System.in);

        // display menu and get selection
        int value;
        do {
            menu();
            value = in.nextInt();

            switch (value) {
                case 1:
                    newWorkoutLog(in);
                    break;
                case 2:
                    seePreviousWorkout();
                    break;
                case 3:
                    scanWorkoutBook();
                    break;
                default:
                    if (value == 0)
                        break;
                    System.out.println(red + "You entered an invalid value!" + reset);
            }
        } while (value != 0);

        // Last statement
        System.out.print(green + "\nProgram successfully ended." + reset);
        System.exit(9);

    }

    // > functions list <

    // function 1
    public static void newline() {System.out.println();}

    // function 2
    public static void menu() {
        // even if you look again, yeah
        // unexplainable
        // juice wrld
        // kid laroi

        System.out.printf(
                "%n%s%n",
                // [1] : See previous workout
                // [2] : Create a new workout log
                // [3] : Workout analysis summary
                // [0] : EXIT PROGRAM

                green + "[1]" + reset + " : Create a new workout log.\n" +
                green + "[2]" + reset + " : See previous workout.\n" +
                green + "[3]" + reset + " : Scan workout book.\n" +
                red   + "[0]" + reset + " : EXIT PROGRAM.\n"
        );
    }

    // function 3
    public static void newWorkoutLog(Scanner in) throws IOException {
        // function's array list
        ArrayList<String> exerciseNames = new ArrayList<String>();
        ArrayList<String> maxWeights = new ArrayList<>();


        // create an ExerciseSession object
        ExerciseSession exercise = new ExerciseSession();

        // Display text that tells user what to do next.
        System.out.println("Enter a title: ");
        exercise.sessionTitle = in.nextLine();
        exercise.sessionTitle = in.nextLine();
        System.out.println("Enter session date: ");
        exercise.sessionDate = in.nextLine();
        System.out.println("Enter number of exercises: ");
        exercise.numExercises = in.nextInt();
        // new arrays
        String[] names = new String[exercise.numExercises];
        String[] weights = new String[exercise.numExercises];


        // loop and get input for each exercise
        for (int i = 0; i < exercise.numExercises; i++)
        {
            System.out.print("Exercise #" + (i+1) +  " name: ");
            if (i == 0)
                exercise.exerciseName = in.nextLine();
            exercise.exerciseName = in.nextLine();
            // exerciseNames.add(exercise.exerciseName);
            names[i] = exercise.exerciseName;


            try { //------------------------------------------------------------------------
                System.out.print("Max lbs: ");
                exercise.maxlbs = in.nextLine();
                // maxWeights.add(exercise.maxlbs);
                // maxWeights.add(exercise.maxlbs = in.nextLine());
                weights[i] = exercise.maxlbs;

            }
            catch (Exception e) {
                    System.out.println("Program encountered an error. Enter again: ");
                    // exercise.maxlbs = in.nextLine();
                    // maxWeights.add(exercise.maxlbs);
                    // maxWeights.add(exercise.maxlbs = in.nextLine());
                    weights[i] = exercise.maxlbs;
            }//----------------------------------------------------------------------------
        }// end for loop


        // display results
        newline();
        for(int i = 0; i < exercise.numExercises; i++) {
            System.out.printf("%s : %35s : %s%n",
                    ("#" + (red + (i + 1) + reset)),
                    yellow + names[i] + reset,
                    green + weights[i] + reset);
        }
        newline();



        // ask if user wants to save the workout log
        System.out.println("Save this workout log?");
        System.out.print(green + "(y/n): " + reset);
        char choice = in.next().charAt(0);

        if (choice == 'y')
            saveFile(in, exercise, names, weights); // call to function 4
        else
            System.out.println(yellow + "You chose to not to save the file." + reset);


    }

    // function 4
    // save 2 string arrays to a file
    public static void saveFile(Scanner in, ExerciseSession session,
                                String[] array1, String[] array2)
                                throws IOException {

        try (Formatter file = new Formatter("workout1.txt")) {
            // write to the file
            file.format("%s\n%s\n",
                    session.sessionDate,
                    session.sessionTitle);

            for (int i = 0; i < session.numExercises; i++) {
                file.format("%d. %s : %s\n",
                        i + 1,
                        array1[i],
                        array2[i]);
            }
        }
        catch (SecurityException | FileNotFoundException | FormatterClosedException e) {
            e.printStackTrace();
        }

        // Notify user that file saved successfully.
        System.out.println(green + "File saved successfully!" + reset);

    }

    // function 5
    public static void seePreviousWorkout() {
        // function variables

        System.out.println(yellow + "This feature is not yet available." + reset);

    }

    // function 6
    public static void scanWorkoutBook() {
        // function variables

        System.out.println(yellow + "This feature is not yet available." + reset);
    }

    // function 7

    // function 8

    // function 9

    // function 10


} // End of functions list.
// End of main method.

// |---------------------------------------------------------------------|
// | CLASSES | CLASSES | CLASSES | CLASSES | CLASSES | CLASSES | CLASSES |
// |---------------------------------------------------------------------|

// class 1
class ExerciseSession {
    // Instance Variables.
    String sessionTitle;    // exercise session title
    String sessionDate;     // date of actual workout
    int numExercises;       // number of exercises to log
    String exerciseName;
    String maxlbs;          // can be written as "bodyweight"

    // constructor 1
    ExerciseSession() {} // no-args


}

// Additional Notes:
/*
1. This program will use String builder to store workout logs


 */
