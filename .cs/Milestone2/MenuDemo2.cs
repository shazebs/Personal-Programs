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
                        bool condition = false;
                        do
                        {
                            try
                            {
                                Console.WriteLine("Enter the name of the vacation you want to remove: ");
                                string deleteMe = Console.ReadLine();
                                deleteProduct(deleteMe.Trim(), vacations);
                                condition = true;
                            }
                            catch
                            {
                                Console.ForegroundColor = ConsoleColor.Red;
                                Console.WriteLine("You entered something invalid, try again!");
                                Console.ResetColor();
                            }
                        } while (condition != true); 
                        break;

                    case "edit":
                        // Ask the user for the id number of an item.
                        // Get new values for the item. 
                        // Update the item's properties. 
                        printCurrentInventory(vacations);
                        Console.WriteLine("Enter the name of the vacation you want to change: ");
                        string updateMe = Console.ReadLine(); 
                        editProduct(updateMe.Trim(), vacations);
                        break;

                    case "search":
                        // Ask if user wants to search by name, price, or date. 
                        Console.WriteLine("This function is not yet available.");
                        break; 

                    default:
                        // Display an error message. 
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.WriteLine("You entered something invalid. Try again.");
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
            // Create some starting values for the list. 
            /*Thing thing1 = new Thing(99, "Banana Bender", 14.95f); 
            Thing thing2 = new Thing(105, "Inflatable Hammer", 25.00f); 
            Thing thing3 = new Thing(288, "Black Light", 11.55f); 
            Thing thing4 = new Thing(422, "A Round Tuit", 0.99f);*/

            DateTime dt = new DateTime(2022, 2, 7);

            // Instantiate new 'Vacation' objects. 
            Vacation vacation1 = new Vacation("Bronze", "Honolulu, Hawaii", dt, 7, "1 week getaway to the beautiful island of Wakiki", 499.99f, "images/hawaii.png");
            dt = new DateTime(2022, 5, 8); 
            Vacation vacation2 = new Vacation("Silver", "Paris, France", dt, 10, "10 day getaway to the romantic city of French Fries", 699.99f, "images/paris.png"); 

            // Add the instatiated objects to the list. 
            vacations.Add(vacation1);
            vacations.Add(vacation2); 
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
                Console.ForegroundColor = ConsoleColor.DarkYellow;
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
        private static void editProduct(string updateMe, List<Vacation> vacations)
        {
            // Find the thing that matches the updateMe number. 
            // Show the current values of the things to the user. 
            // Ask for a new value for name. 
            // Ask for a new value for price. 
            // Update the properties of things[updateMe]
            foreach(Vacation vacation in vacations)
            {
                /*if (updateMe == vacation.id)
                {
                    Console.Write("Enter a new name for this thing: ");
                    thing.name = Console.ReadLine();
                    Console.Write("Enter a new price for this thing: $");
                    thing.price = float.Parse(Console.ReadLine());
                    break; 
                }*/

                if (updateMe == vacation.vacationName)
                {
                    Console.WriteLine("You successfully located the vacation item you want to edit."); 
                } 
            }
        }
        private static void deleteProduct(string deleteMe, List<Vacation> vacations)
        {
            // Find the thing that matches the deleteMe number. 
            // Remove it from the list of things. 
            foreach(Vacation vacation in vacations)
            {
                if (deleteMe == vacation.vacationName)
                {
                    Console.WriteLine("You successfully located the vacation item you want to remove."); 
                    vacations.Remove(vacation);
                    Console.WriteLine("The vacation item was successfully removed from the inventory."); 
                    break; 
                }
            }
        }
        /*private static List<string> seachForItems(string searchPhrase, List<string> mythings)
        {
            // loop through the list or products 

            // if a partial 
        }*/
    }
}
