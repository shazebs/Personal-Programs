using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Whiteboard
{
    class Program
    {
        static void Main(string[] args)
        {
            // Print to the console a welcome message.
            Console.ForegroundColor = ConsoleColor.Cyan; 
            Console.WriteLine("Welcome to the Vacations Catalogue!");
            Console.ResetColor(); 

            // Create a List container that holds the class 'Vacation' objects. 
            List<Vacation> vacations = new List<Vacation>();

            // Call a method that initializes elements of a passed list container. 
            CreateStartingListOfVacations(vacations);

            // Create an empty string object that will hold the user's menu choice selection. 
            String choice = ""; 

            // While loop. 
            while (choice != "end")
            {
                printWelcome();

                choice = Console.ReadLine(); 
                switch (choice.Trim())
                {
                    // Keep each case statement small by creating helper methods. 
                    case "show":
                        // Display all the things in the list. 
                        printCurrentInventory(vacations);
                        break;

                    case "end":
                        choice = "end"; 
                        break;

                    case "add":
                        // Ask the user to provide a new thing and add it to the list. 
                        addProduct(vacations);
                        break;

                    case "delete":
                        // Ask the user for the id number of the item to remove. 
                        // Remove it from the list. 
                        printCurrentInventory(vacations);
                        if (vacations.Count != 0) deleteProduct(-1, vacations); // Recursive Function Call. 
                        break;

                    case "edit":
                        // Ask the user for the id number of an item.
                        // Get new values for the item. 
                        // Update the item's properties. 
                        printCurrentInventory(vacations);
                        if (vacations.Count != 0) editProduct(-1, vacations); // Recursive Function Call.
                        break;

                    case "search":
                        // Ask if user wants to search by name, price, or date. 
                        Console.WriteLine("This function is not yet available.");
                        break; 

                    default:
                        // Display an error message. 
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.WriteLine("\nYou entered something invalid. Try again.");
                        Console.ResetColor();
                        break; 
                }
            }

            Console.ForegroundColor = ConsoleColor.Red; 
            Console.Write("\nEnter any key to end the program..."); 
            Console.ReadKey();
        }
        private static void CreateStartingListOfVacations(List<Vacation> vacations)
        {
            // Instantiate new 'Vacation' objects. 
            DateTime dt = new DateTime(2022, 2, 7);
            Vacation vacation1 = new Vacation("Bronze", "Honolulu, Hawaii", dt, 7, "1 week getaway to the beautiful island of Wakiki", 499.99f, "images/hawaii.png");

            dt = new DateTime(2022, 5, 8); 
            Vacation vacation2 = new Vacation("Silver", "Paris, France", dt, 10, "10 day getaway to the romantic city of French Fries", 699.99f, "images/paris.png");  
            
            dt = new DateTime(2022, 5, 8); 
            Vacation vacation3 = new Vacation("Gold", "Tokyo, Japan", dt, 14, "Two week stay at the Anime Capital of the World.", 845.67f, "tokyo.png"); 

            // Add the instatiated objects to the list. 
            vacations.Add(vacation1);
            vacations.Add(vacation2);
            vacations.Add(vacation3); 
        }
        private static void printWelcome()
        {
            Console.WriteLine("\nYour choices are:");
            Console.WriteLine("'show' to display current inventory of things");
            Console.WriteLine("'end' stop this nonsense");
            Console.WriteLine("'add' add a new product");
            Console.WriteLine("'delete' remove a product");
            Console.WriteLine("'edit' change a product");
            Console.WriteLine("'search' to search for items from a variety of criteria"); 
        }
        private static void printCurrentInventory(List<Vacation> vacations)
        {
            Console.ForegroundColor = ConsoleColor.DarkGreen;
            Console.WriteLine("\nHere is what you currently have in the Vacations Catalogue:");

            if (vacations.Count == 0)
            {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine("The inventory is empty."); 
            } else
            {
                Console.ForegroundColor = ConsoleColor.Yellow;

                int count = 1; 
                foreach (Vacation vacation in vacations)
                {
                    Console.Write(count++ + ") ");
                    Console.WriteLine(vacation);
                }
            }
            Console.ResetColor(); 
        }
        private static void addProduct(List<Vacation> vacations)
        {
            // Ask the user for thing properties. 
            // Create a new thing using the constructor. 
            // Add the thing to the things list. 

            // Get vacation name from the user. 
            Console.Write("\nEnter a name for the vacation: ");
            string vacationName = Console.ReadLine();

            // Get vacation location from the user. 
            Console.Write("Enter the location of the vacation: ");
            string location = Console.ReadLine();

            // Get vacation starting month from the user. 
            Console.Write("What is the starting month of this vacation (1-12): ");
            int month = int.Parse(Console.ReadLine());
            // Get vacation starting day from the user. 
            Console.Write("What is the starting day of this vacation (1-31): "); 
            int day = int.Parse(Console.ReadLine());
            // Get vacation starting year from the user. 
            Console.Write("What is the starting year of this vacation: "); 
            int year = int.Parse(Console.ReadLine());

            // Get the days of this trip for this vacation from the user. 
            Console.Write("How many days is this trip: "); 
            int daysOfTrip = int.Parse(Console.ReadLine());

            // Get the vacation description from the user. 
            Console.Write("Enter the description for this vacation: ");
            string description = Console.ReadLine();

            // Get the vacation price from the user. 
            Console.Write("Enter the price for this vacation: $");
            float price = float.Parse(Console.ReadLine());

            // Get the vacation photo URL from the user. 
            Console.Write("Enter the photo URL for this vacation: ");
            string photoURL = Console.ReadLine();

            // Instantiate a new 'Vacation' object with the inputs from the user and add it to the vacations list. 
            DateTime dt = new DateTime(year, month, day);
            Vacation newVacation = new Vacation(vacationName, location, dt, daysOfTrip, description, price, photoURL);
            vacations.Add(newVacation); 
        }
        private static void editProduct(int updateMe, List<Vacation> vacations)
        {
            // Find the thing that matches the updateMe number. 
            // Show the current values of the things to the user. 
            // Ask for a new value for name. 
            // Ask for a new value for price. 
            // Update the properties of things[updateMe]

            if (updateMe == -1)
            {
                bool repeat = true;
                do
                {
                    try
                    {
                        Console.ForegroundColor = ConsoleColor.Cyan;
                        Console.WriteLine("Enter the index of the vacation item you want to edit: ");
                        Console.ResetColor();
                        int index = int.Parse(Console.ReadLine());
                        while (index < 1 || index > vacations.Count)
                        {
                            Console.ForegroundColor = ConsoleColor.Red;
                            Console.WriteLine("You entered an invalid index, try again!");
                            Console.ResetColor();
                            index = int.Parse(Console.ReadLine());
                        }
                        // At this point, a valid input has been registered by the user, so break out of do-while and move to next step. 
                        editProduct(index, vacations);
                        repeat = false;
                    }
                    catch
                    {
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.WriteLine("You entered something invalid, try again!");
                        Console.ResetColor();
                    }
                } while (repeat != false);
            }
            else
            {
                int index = 0;
                foreach (var vacation in vacations)
                {
                    if (updateMe - 1 == index)
                    {
                        // Edit vacation item name. 
                        Console.ForegroundColor = ConsoleColor.Yellow; 
                        Console.WriteLine("\n(Current vacation name = " + vacation.vacationName + ")");
                        Console.ForegroundColor = ConsoleColor.Cyan;
                        Console.Write("Enter vacation name edit: ");
                        Console.ResetColor();
                        vacation.vacationName = Console.ReadLine();

                        // Edit vacation item location. 
                        Console.ForegroundColor = ConsoleColor.Yellow;
                        Console.WriteLine("(Current vacation location = " + vacation.location + ")");
                        Console.ForegroundColor = ConsoleColor.Cyan;
                        Console.Write("Enter vacation location edit: ");
                        Console.ResetColor();
                        vacation.location = Console.ReadLine();

                        // Edit vacation item starting date. 
                        Console.ForegroundColor = ConsoleColor.Yellow;
                        Console.WriteLine("(Current vacation starting date = " + vacation.startingDate + ")");
                        Console.ForegroundColor = ConsoleColor.Cyan;
                        Console.Write("Enter vacation starting date's month (1-12): ");
                        Console.ResetColor();
                        int month = int.Parse(Console.ReadLine());
                        Console.Write("Enter vacation starting date's day (1-31): ");
                        Console.ResetColor();
                        int day = int.Parse(Console.ReadLine());
                        Console.Write("Enter vacation starting date's year: ");
                        Console.ResetColor();
                        int year = int.Parse(Console.ReadLine());
                        DateTime dt = new DateTime(year, month, day);
                        vacation.startingDate = dt; 

                        // Edit vacation item days of trip. 
                        Console.ForegroundColor = ConsoleColor.Yellow;
                        Console.WriteLine("(Current vacation starting date = " + vacation.daysOfTrip + ")");
                        Console.ForegroundColor = ConsoleColor.Cyan;
                        Console.Write("Enter vacation days of trip edit: ");
                        Console.ResetColor();
                        vacation.daysOfTrip = int.Parse(Console.ReadLine());

                        // Edit vacation item description. 
                        Console.ForegroundColor = ConsoleColor.Yellow;
                        Console.WriteLine("(Current vacation description = " + vacation.description + ")");
                        Console.ForegroundColor = ConsoleColor.Cyan;
                        Console.Write("Enter vacation description edit: ");
                        Console.ResetColor();
                        vacation.description = Console.ReadLine();

                        // Edit vacation item price. 
                        Console.ForegroundColor = ConsoleColor.Yellow;
                        Console.WriteLine("(Current vacation price = $" + vacation.price + ")");
                        Console.ForegroundColor = ConsoleColor.Cyan;
                        Console.Write("Enter vacation price edit: ");
                        Console.ResetColor();
                        vacation.price = float.Parse(Console.ReadLine());

                        // Edit vacation photo URL. 
                        Console.ForegroundColor = ConsoleColor.Yellow;
                        Console.WriteLine("(Current vacation photo URL = " + vacation.photoURL + ")");
                        Console.ForegroundColor = ConsoleColor.Cyan;
                        Console.Write("Enter vacation photo URL edit: ");
                        Console.ResetColor();
                        vacation.photoURL = Console.ReadLine();

                        Console.ResetColor();
                        break; // to exit foreach loop. 
                    }
                    index++;
                }
            }
        }
        public static void deleteProduct(int deleteMe, List<Vacation> vacations)
        {
            // Find the thing that matches the deleteMe number. 
            // Remove it from the list of things. 

            if (deleteMe == -1)
            {
                bool condition = false;
                do
                {
                    try
                    {
                        Console.ForegroundColor = ConsoleColor.Cyan;
                        Console.Write("Enter the index of the vacation you want to remove: ");
                        Console.ResetColor();

                        deleteMe = int.Parse(Console.ReadLine());

                        while (deleteMe < 1 || deleteMe > vacations.Count)
                        {
                            Console.ForegroundColor = ConsoleColor.Red;
                            Console.WriteLine("You entered an invalid index, try again!");
                            Console.ForegroundColor = ConsoleColor.Cyan;
                            Console.Write("Enter the index of the vacation you want to remove: ");
                            Console.ResetColor();
                            deleteMe = int.Parse(Console.ReadLine());
                        }
                        deleteProduct(deleteMe, vacations);
                        condition = true;
                    }
                    catch
                    {
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.WriteLine("You entered something invalid, try again!");
                        Console.ResetColor();
                    }
                } while (condition != true); 
            }
            else
            {
                int index = 0; 
                foreach (var vacation in vacations)
                {
                    if (deleteMe-1 == index)
                    {
                        vacations.Remove(vacation);
                        Console.ForegroundColor = ConsoleColor.Green;
                        Console.WriteLine("The vacation item was successfully located and removed from the inventory.");
                        Console.ResetColor();
                        break; 
                    }
                    index++; 
                }
            }
        }
    }
}
