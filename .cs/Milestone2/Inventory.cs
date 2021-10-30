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
            Console.WriteLine("Welcome to the store!");

            // Create a List container that holds the class 'Thing' objects. 
            List<Thing> things = new List<Thing>();

            // Call a method that initializes elements of a passed list container. 
            CreateStartingListOfThings(things);

            // Create an empty string object that will hold the user's menu choice selection. 
            String choice = ""; 

            // While loop. 
            while (choice != "end")
            {
                printWelcome();

                choice = Console.ReadLine(); 
                switch (choice)
                {
                    // Keep each case statement small by creating helper methods. 
                    case "show":
                        // Display all the things in the list. 
                        printCurrentInventory(things);
                        break;

                    case "add":
                        // Ask the user to provide a new thing and add it to the list. 
                        addProduct(things);
                        break;

                    case "delete":
                        // Ask the user for the id number of the item to remove. 
                        // Remove it from the list. 
                        printCurrentInventory(things);
                        Console.WriteLine("Enter the id number of the thing you want to remove: ");
                        int deleteMe = int.Parse(Console.ReadLine());
                        deleteProduct(deleteMe, things);
                        break;

                    case "edit":
                        // Ask the user for the id number of an item.
                        // Get new values for the item. 
                        // Update the item's properties. 
                        printCurrentInventory(things);
                        Console.WriteLine("Enter the id number of the thing you want to change: ");
                        int updateMe = int.Parse(Console.ReadLine());
                        editProduct(updateMe, things);
                        break; 
                }
            }

            Console.ReadLine();
        }
        private static void CreateStartingListOfThings(List<Thing> things)
        {
            // Create some starting values for the list. 
            Thing thing1 = new Thing(99, "Banana Bender", 14.95f); 
            Thing thing2 = new Thing(105, "Inflatable Hammer", 25.00f); 
            Thing thing3 = new Thing(288, "Black Light", 11.55f); 
            Thing thing4 = new Thing(422, "A Round Tuit", 0.99f);

            things.Add(thing1); 
            things.Add(thing2); 
            things.Add(thing3); 
            things.Add(thing4); 
        }
        private static void printWelcome()
        {
            Console.WriteLine("Your choices are:");
            Console.WriteLine("'show' to display current inventory of things");
            Console.WriteLine("'end' stop this nonsense");
            Console.WriteLine("'add' add a new product");
            Console.WriteLine("'delete' remove a product");
            Console.WriteLine("'edit' change a product");
        }
        private static void printCurrentInventory(List<Thing> things)
        {
            Console.ForegroundColor = ConsoleColor.DarkGreen;
            Console.WriteLine("Here is what you currently have in your store:");
            Console.ForegroundColor = ConsoleColor.DarkYellow; 
            foreach (Thing thing in things)
            {
                Console.WriteLine(thing);
            }
            Console.ResetColor(); 
        }
        private static void addProduct(List<Thing> things)
        {
            // Ask the user for thing properties. 
            // Create a new thing using the constructor. 
            // Add the thing to the things list. 
            Console.Write("Enter an id number for this product: ");
            int id = int.Parse(Console.ReadLine());
            Console.Write("Enter the name for this product: ");
            String name = Console.ReadLine();
            Console.Write("Enter the price for this product: ");
            float price = float.Parse(Console.ReadLine());

            Thing newThing = new Thing(id, name, price);
            things.Add(newThing); 
        }
        private static void editProduct(int updateMe, List<Thing> things)
        {
            // Find the thing that matches the updateMe number. 
            // Show the current values of the things to the user. 
            // Ask for a new value for name. 
            // Ask for a new value for price. 
            // Update the properties of things[updateMe]
            foreach(Thing thing in things)
            {
                if (updateMe == thing.id)
                {
                    Console.Write("Enter a new name for this thing: ");
                    thing.name = Console.ReadLine();
                    Console.Write("Enter a new price for this thing: $");
                    thing.price = float.Parse(Console.ReadLine());
                    break; 
                }
            }
        }
        private static void deleteProduct(int deleteMe, List<Thing> things)
        {
            // Find the thing that matches the deleteMe number. 
            // Remove it from the list of things. 
            foreach(Thing thing in things)
            {
                if (deleteMe == thing.id)
                {
                    things.Remove(thing);
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
