using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VacationTours
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
                        printFilteredInventory(searchInventory(vacations)); 
                        break;

                    case "quantity":
                        // Change the quantity of an individual vacation item. 
                        changeVacationQuantity(-1, vacations);
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
            Vacation vacation1 = new Vacation("Bronze", "Honolulu, Hawaii", dt, 7, "1 week getaway to the beautiful island of Wakiki", 499.99f, "https://about.hawaiilife.com/wp-content/uploads/2017/07/Honolulu-Hawaii.jpg", 10);

            dt = new DateTime(2022, 9, 13);
            Vacation vacation2 = new Vacation("Silver", "Paris, France", dt, 10, "10 day getaway to the romantic city of French Fries", 699.99f, "https://trickful.com/wp-content/uploads/2020/04/france.jpg",16);

            dt = new DateTime(2022, 5, 8);
            Vacation vacation3 = new Vacation("Gold", "Tokyo, Japan", dt, 14, "Two week stay at the Anime Capital of the World.", 845.67f, "https://www.japan-guide.com/thumb/destination_tokyo.jpg", 9);

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
            Console.WriteLine("'search' to search for products from a variety of criteria");
            Console.WriteLine("'quantity' to change the quantity of a product"); 
        }
        private static void printCurrentInventory(List<Vacation> vacations)
        {
            Console.ForegroundColor = ConsoleColor.DarkGreen;
            Console.WriteLine("\nHere is what you currently have in the Vacations Catalogue:");

            if (vacations.Count == 0)
            {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine("The inventory is empty.");
            }
            else
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
        private static void printFilteredInventory(List<Vacation> vacations)
        {
            Console.ForegroundColor = ConsoleColor.DarkGreen;
            Console.WriteLine("\nHere is what currently matches your search in the Vacations Catalogue:");

            if (vacations.Count == 0)
            {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine("No items match your search query.");
            }
            else
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
            cyan(); 
            Console.Write("\nEnter a name for the vacation: ");
            reset(); 
            string vacationName = Console.ReadLine().Trim();
            while (vacationName.Length == 0)
            {
                red(); 
                Console.WriteLine("Error! Vacation name cannot be empty, try again!");
                cyan();
                Console.Write("Enter vacation name edit: "); reset(); 
                vacationName = Console.ReadLine().Trim();
            }

            // Get vacation location from the user. 
            cyan(); 
            Console.Write("Enter the location of the vacation: "); reset(); 
            string location = Console.ReadLine().Trim();
            while (location.Length == 0)
            {
                red();
                Console.WriteLine("Error! Vacation name cannot be empty, try again!");
                cyan();
                Console.Write("Enter vacation name edit: "); reset();
                location = Console.ReadLine().Trim();
            }

            // Get vacation starting date from the user. 
            // Date variables. 
            int month = -1, day = -1, year = -1; // null
            DateTime startingDate = new DateTime(); 
            bool repeat = true;
            do
            {
                try
                {
                    // Get starting date's month from user.
                    cyan(); 
                    Console.Write("Enter vacation starting date's month (1-12): "); reset(); 
                    month = int.Parse(Console.ReadLine());
                    // Input validation for month. 
                    while (month < 1 || month > 12)
                    {
                        red(); 
                        Console.Write("Please enter a valid month (1-12): "); reset(); 
                        month = int.Parse(Console.ReadLine());
                    }
                    // Get starting date's day from user. 
                    cyan(); 
                    if (month == 11 || month == 4 || month == 6 || month == 9)
                    {
                        Console.Write("Enter vacation starting date's day (1-30): "); reset(); 
                        day = int.Parse(Console.ReadLine());
                        while (day < 1 || day > 30)
                        {
                            red(); 
                            Console.Write("Error! Enter a day (1-30): "); reset(); 
                            day = int.Parse(Console.ReadLine());
                        }
                    }
                    else if (month == 2)
                    {
                        Console.Write("Enter vacation starting date's day (1-28): "); reset(); 
                        day = int.Parse(Console.ReadLine());
                        while (day < 1 || day > 28)
                        {
                            red(); 
                            Console.Write("Error! Enter a day (1-28): "); reset(); 
                            day = int.Parse(Console.ReadLine());
                        }
                    }
                    else
                    {
                        Console.Write("Enter vacation starting date's day (1-31): "); reset(); 
                        day = int.Parse(Console.ReadLine());
                        while (day < 1 || day > 31)
                        {
                            red(); 
                            Console.Write("Error! Enter a day (1-31): "); reset(); 
                            day = int.Parse(Console.ReadLine());
                        }
                    }
                    // Get starting date's year from user. 
                    cyan(); 
                    Console.Write("Enter vacation starting date's year: "); reset();
                    year = int.Parse(Console.ReadLine());
                    while (year < 2022)
                    {
                        red(); 
                        Console.Write("Error! Starting date's year cannot be before 2022. Try again: "); reset(); 
                        year = int.Parse(Console.ReadLine());
                    }
                    // At this point, a correct date has been entered by the user so break out of do-while loop and set the new date. 
                    startingDate = new DateTime(year, month, day);
                    repeat = false; // Exit out of do-while loop. 
                }
                catch
                {
                    red(); 
                    Console.WriteLine("You entered something invalid while setting date edit, try all over again!"); 
                    reset(); 
                }
            } while (repeat != false);

            // Get the days of this trip for this vacation from the user. 
            int daysOfTrip = -1; 
            repeat = true;
            do
            {
                try
                {
                    cyan(); 
                    Console.Write("How many days is this trip: "); reset(); 
                    daysOfTrip = int.Parse(Console.ReadLine());
                    while (daysOfTrip < 1)
                    {
                        red();
                        Console.WriteLine("Error! Vacation days of trip must be greater than 0, try again!");
                        cyan();
                        Console.Write("How many days is this trip: "); reset(); 
                        daysOfTrip = int.Parse(Console.ReadLine());
                    }
                    // break out of loop because a correct days of trip value has been retrieved from user. 
                    repeat = false; 
                }
                catch
                {
                    red();
                    Console.WriteLine("Error! You entered something invalid, try again!");
                    reset(); 
                }
            } while (repeat != false);

            // Get the vacation description from the user. 
            cyan(); 
            Console.Write("Enter the description for this vacation: "); reset();
            string description = Console.ReadLine().Trim();
            while (description.Length == 0)
            {
                red();
                Console.WriteLine("Error! Vacation description cannot be empty, try again!");
                cyan();
                Console.Write("Enter the description for this vacation: "); reset();
                description = Console.ReadLine().Trim();
            }

            // Get the vacation price from the user. 
            float price = 0.00f; 
            repeat = true; 
            do
            {
                try
                {
                    cyan(); 
                    Console.Write("Enter the price for this vacation: $"); reset();
                    price = float.Parse(Console.ReadLine());
                    while (price <= 0)
                    {
                        red();
                        Console.WriteLine("Error! Price must be greater than 0, try again!");
                        cyan();
                        Console.Write("Enter the price for this vacation: $"); reset();
                        price = float.Parse(Console.ReadLine());
                    }
                    repeat = false; // Break out of loop because correct input has been entered. 
                }
                catch
                {
                    red();
                    Console.WriteLine("Error! You entered something invalid, try again!");
                    reset(); 
                }
            } while (repeat != false);

            // Get the vacation photo URL from the user. 
            cyan(); 
            Console.Write("Enter the photo URL for this vacation: "); reset(); 
            string photoURL = Console.ReadLine().Trim();
            while (photoURL.Length == 0)
            {
                red();
                Console.WriteLine("Error! Vacation photo URL cannot be empty, try again!");
                cyan();
                Console.Write("Enter the photo URL for this vacation: "); reset(); 
                photoURL = Console.ReadLine().Trim();
            }

            // Get the quantity for this vacation from the user. 
            int quantity = -1;
            repeat = true;
            do
            {
                try
                {
                    cyan();
                    Console.Write("How much quantity is left for this vacation: "); reset();
                    quantity = int.Parse(Console.ReadLine());
                    while (quantity < 1)
                    {
                        red();
                        Console.WriteLine("Error! Quantity must be greater than 0, try again!");
                        cyan();
                        Console.Write("How much quantity is left for this vacation: "); reset(); 
                        quantity = int.Parse(Console.ReadLine());
                    }
                    // break out of loop because a correct days of trip value has been retrieved from user. 
                    repeat = false;
                }
                catch
                {
                    red();
                    Console.WriteLine("Error! You entered something invalid, try again!");
                    reset();
                }
            } while (repeat != false);

            // Instantiate a new 'Vacation' object with the inputs from the user and add it to the vacations list. 
            Vacation newVacation = new Vacation(vacationName, location, startingDate, daysOfTrip, description, price, photoURL, quantity);
            vacations.Add(newVacation); // Add to List. 
            green();
            Console.WriteLine("You successfully added a vacation item to the inventory!"); reset(); 
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
                        Console.Write("Enter the index of the vacation item you want to edit: ");
                        Console.ResetColor();
                        int index = int.Parse(Console.ReadLine());
                        while (index < 1 || index > vacations.Count)
                        {
                            Console.ForegroundColor = ConsoleColor.Red;
                            Console.WriteLine("You entered an invalid index, try again: ");
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
                        // Edit vacation item's name. 
                        string tempVacationName = vacation.vacationName; // For debugging purposes only.  
                        Console.ForegroundColor = ConsoleColor.Yellow;
                        Console.WriteLine("\n(Current vacation name = " + vacation.vacationName + ")");
                        Console.ForegroundColor = ConsoleColor.Cyan;
                        Console.Write("Enter vacation name edit: ");
                        Console.ResetColor();
                        vacation.vacationName = Console.ReadLine().Trim();
                        // Vacation name input validation.
                        while (vacation.vacationName.Length == 0)
                        {
                            Console.ForegroundColor = ConsoleColor.Red;
                            Console.WriteLine("Error! Vacation name cannot be empty, try again!");
                            vacation.vacationName = tempVacationName; 
                            Console.ForegroundColor = ConsoleColor.Yellow;
                            Console.WriteLine("(Current vacation name = " + vacation.vacationName + ")");
                            Console.ForegroundColor = ConsoleColor.Cyan;
                            Console.Write("Enter vacation name edit: ");
                            Console.ResetColor();
                            vacation.vacationName = Console.ReadLine().Trim();
                        }

                        // Edit vacation item's location. 
                        string tempLocation = vacation.location; // For debuggin purposes only. 
                        Console.ForegroundColor = ConsoleColor.Yellow;
                        Console.WriteLine("(Current vacation location = " + vacation.location + ")");
                        Console.ForegroundColor = ConsoleColor.Cyan;
                        Console.Write("Enter vacation location edit: ");
                        Console.ResetColor();
                        vacation.location = Console.ReadLine().Trim();
                        // Vacation location input validation. 
                        while (vacation.location.Length == 0)
                        {
                            Console.ForegroundColor = ConsoleColor.Red;
                            Console.WriteLine("Error! Vacation location cannot be empty, try again!");
                            vacation.location = tempLocation; 
                            Console.ForegroundColor = ConsoleColor.Yellow;
                            Console.WriteLine("(Current vacation location = " + vacation.location + ")");
                            Console.ForegroundColor = ConsoleColor.Cyan;
                            Console.Write("Enter vacation location edit: ");
                            Console.ResetColor();
                            vacation.location = Console.ReadLine().Trim();
                        }

                        // Edit vacation item starting date. 
                        bool repeat = true;
                        do
                        {
                            try
                            {
                                // Date variables. 
                                int month = -1, day = -1, year = -1; // null

                                Console.ForegroundColor = ConsoleColor.Yellow;
                                Console.WriteLine("(Current vacation starting date = " + 
                                    vacation.startingDate.Month + "/" + 
                                    vacation.startingDate.Day + "/" + 
                                    vacation.startingDate.Year + ")");

                                // Get starting date's month from user.
                                Console.ForegroundColor = ConsoleColor.Cyan;
                                Console.Write("Enter vacation starting date's month (1-12): ");
                                Console.ResetColor();
                                month = int.Parse(Console.ReadLine());
                                // Input validation for month. 
                                while (month < 1 || month > 12)
                                {
                                    Console.ForegroundColor = ConsoleColor.Red;
                                    Console.Write("Please enter a valid month (1-12): ");
                                    Console.ResetColor();
                                    month = int.Parse(Console.ReadLine()); 
                                }
                                // Get starting date's day from user. 
                                Console.ForegroundColor = ConsoleColor.Cyan;
                                if (month == 11 || month == 4 || month == 6 || month == 9)
                                {
                                    Console.Write("Enter vacation starting date's day (1-30): ");
                                    Console.ResetColor();
                                    day = int.Parse(Console.ReadLine());
                                    while (day < 1 || day > 30)
                                    {
                                        Console.ForegroundColor = ConsoleColor.Red;
                                        Console.Write("Error! Enter a day (1-30): ");
                                        Console.ResetColor();
                                        day = int.Parse(Console.ReadLine()); 
                                    }
                                }
                                else if (month == 2)
                                {
                                    Console.Write("Enter vacation starting date's day (1-28): ");
                                    Console.ResetColor();
                                    day = int.Parse(Console.ReadLine());
                                    while (day < 1 || day > 28)
                                    {
                                        Console.ForegroundColor = ConsoleColor.Red;
                                        Console.Write("Error! Enter a day (1-28): ");
                                        Console.ResetColor();
                                        day = int.Parse(Console.ReadLine());
                                    }
                                }
                                else
                                {
                                    Console.Write("Enter vacation starting date's day (1-31): ");
                                    Console.ResetColor();
                                    day = int.Parse(Console.ReadLine());
                                    while (day < 1 || day > 31)
                                    {
                                        Console.ForegroundColor = ConsoleColor.Red;
                                        Console.Write("Error! Enter a day (1-31): ");
                                        Console.ResetColor();
                                        day = int.Parse(Console.ReadLine());
                                    }
                                }
                                // Get starting date's year from user. 
                                Console.ForegroundColor = ConsoleColor.Cyan; 
                                Console.Write("Enter vacation starting date's year: ");
                                Console.ResetColor();
                                year = int.Parse(Console.ReadLine());
                                while (year < 2022)
                                {
                                    Console.ForegroundColor = ConsoleColor.Red;
                                    Console.Write("Error! Starting date's year cannot be before 2022. Try again: ");
                                    Console.ResetColor();
                                    year = int.Parse(Console.ReadLine());
                                }

                                // At this point, a correct date has been entered by the user so break out of do-while loop and set the new date. 
                                DateTime newDate = new DateTime(year, month, day);
                                vacation.startingDate = newDate;
                                repeat = false; 
                            }
                            catch
                            {
                                Console.ForegroundColor = ConsoleColor.Red;
                                Console.WriteLine("You entered something invalid while setting date edit, try all over again!");
                                Console.ResetColor(); 
                            }
                        } while (repeat != false);

                        // Edit vacation item's days of trip. 
                        repeat = true;
                        int tempDaysOfTrip = vacation.daysOfTrip; // For debugging purposes only. 
                        do
                        {
                            try
                            {
                                Console.ForegroundColor = ConsoleColor.Yellow;
                                Console.WriteLine("(Current vacation days of trip = " + vacation.daysOfTrip + ")");
                                Console.ForegroundColor = ConsoleColor.Cyan;
                                Console.Write("Enter vacation days of trip edit: "); reset(); 
                                vacation.daysOfTrip = int.Parse(Console.ReadLine());
                                while (vacation.daysOfTrip < 1)
                                {
                                    Console.ForegroundColor = ConsoleColor.Red;
                                    Console.Write("Error! Days of trip must be at least 1 or greater, try again: ");
                                    Console.ResetColor();
                                    vacation.daysOfTrip = int.Parse(Console.ReadLine());
                                }
                                break; 
                            }
                            catch
                            {
                                Console.ForegroundColor = ConsoleColor.Red;
                                Console.WriteLine("You entered something invalid, try again!");
                                Console.ResetColor();
                                vacation.daysOfTrip = tempDaysOfTrip; 
                            }
                        } while (repeat != false);

                        // Edit vacation item description. 
                        string tempDescription = vacation.description; // For debugging purposes only. 
                        Console.ForegroundColor = ConsoleColor.Yellow;
                        Console.WriteLine("(Current vacation description = " + vacation.description + ")");
                        Console.ForegroundColor = ConsoleColor.Cyan;
                        Console.Write("Enter vacation description edit: ");
                        Console.ResetColor();
                        vacation.description = Console.ReadLine().Trim();
                        // Vacation description input validation. 
                        while (vacation.description.Length == 0)
                        {
                            Console.ForegroundColor = ConsoleColor.Red;
                            Console.WriteLine("Error! Vacation description cannot be empty, try again!");
                            vacation.description = tempDescription; 
                            Console.ForegroundColor = ConsoleColor.Yellow;
                            Console.WriteLine("(Current vacation description = " + vacation.description + ")");
                            cyan(); 
                            Console.Write("Enter vacation description edit: "); reset(); 
                            vacation.description = Console.ReadLine().Trim();
                        }

                        // Edit vacation item price. 
                        repeat = true;
                        float tempPrice = vacation.price; // For debugging purposes only. 
                        do
                        {
                            try
                            {
                                Console.ForegroundColor = ConsoleColor.Yellow;
                                Console.WriteLine("(Current vacation price = $" + vacation.price + ")");
                                Console.ForegroundColor = ConsoleColor.Cyan;
                                Console.Write("Enter vacation price edit: $");
                                Console.ResetColor();
                                vacation.price = float.Parse(Console.ReadLine());
                                // Vacation price input validation. 
                                while (vacation.price <= 0)
                                {
                                    Console.ForegroundColor = ConsoleColor.Red;
                                    Console.WriteLine("Error! Vacation price must be greater than 0, try again!");
                                    vacation.price = tempPrice; 
                                    Console.ForegroundColor = ConsoleColor.Yellow;
                                    Console.WriteLine("(Current vacation price = $" + vacation.price + ")");
                                    Console.ForegroundColor = ConsoleColor.Cyan;
                                    Console.Write("Enter vacation price edit: $"); reset(); 
                                    vacation.price = float.Parse(Console.ReadLine());
                                }
                                break; 
                            }
                            catch
                            {
                                Console.ForegroundColor = ConsoleColor.Red;
                                Console.WriteLine("You entered something invalid, try again!");
                                Console.ResetColor();
                            }
                        } while (repeat != false);

                        // Edit vacation photo URL. 
                        string tempPhotoURL = vacation.photoURL; // For debugging purposes only. 
                        Console.ForegroundColor = ConsoleColor.Yellow;
                        Console.WriteLine("(Current vacation photo URL = " + vacation.photoURL + ")");
                        Console.ForegroundColor = ConsoleColor.Cyan;
                        Console.Write("Enter vacation photo URL edit: ");
                        Console.ResetColor();
                        vacation.photoURL = Console.ReadLine();
                        // Vacation photo URL input validation. 
                        while (vacation.photoURL.Length == 0)
                        {
                            Console.ForegroundColor = ConsoleColor.Red;
                            Console.WriteLine("Error! Vacation photo URL cannot be empty, try again!");
                            vacation.photoURL = tempPhotoURL; 
                            Console.ForegroundColor = ConsoleColor.Yellow;
                            Console.WriteLine("(Current vacation photo URL = " + vacation.photoURL + ")");
                            Console.ForegroundColor = ConsoleColor.Cyan;
                            Console.Write("Enter vacation photo URL edit: ");
                            Console.ResetColor();
                            vacation.photoURL = Console.ReadLine().Trim();
                        }

                        // Edit the quantity for this vacation from the user. 
                        int quantity = -1;
                        repeat = true;
                        do
                        {
                            try
                            {
                                cyan();
                                Console.Write("Edit how much quantity is left for this vacation: "); reset();
                                quantity = int.Parse(Console.ReadLine());
                                while (quantity < 1)
                                {
                                    red();
                                    Console.WriteLine("Error! Quantity must be greater than 0, try again!");
                                    cyan();
                                    Console.Write("Edit how much quantity is left for this vacation: "); reset();
                                    quantity = int.Parse(Console.ReadLine());
                                }
                                // break out of loop because a correct days of trip value has been retrieved from user. 
                                vacation.quantity = quantity; 
                                repeat = false;
                            }
                            catch
                            {
                                red();
                                Console.WriteLine("Error! You entered something invalid, try again!");
                                reset();
                            }
                        } while (repeat != false);

                        break; // to exit foreach loop. 
                    }
                    index++;
                }
                green();
                Console.WriteLine("You successfully edited the vacation item in the inventory!"); reset();
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
                    if (deleteMe - 1 == index)
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
        public static List<Vacation> searchInventory(List<Vacation> vacations)
        {
            // Local Variables. 
            List<Vacation> returnList = new List<Vacation>();
            string choice = "";
            bool repeat = true; 

            do
            {
                cyan();
                Console.WriteLine("\nHow would you like to conduct your search?"); reset();
                Console.WriteLine("Search by 'name'\nSearch by 'price'\nSearch by 'date'");
                choice = Console.ReadLine().Trim(); 
                if (choice != "name" && choice != "price" && choice != "date")
                {
                    red();
                    Console.WriteLine("You entered something invalid, try again!"); reset(); 
                }
            } while (choice != "name" && choice != "price" && choice != "date");

            // Switch the correct choice selection. 
            switch (choice)
            {
                case "name":
                    cyan(); 
                    Console.Write("Enter a name you want to filter for in the inventory: "); reset(); 
                    string searchPhrase = Console.ReadLine().Trim(); 
                    // Search phrase input validation. 
                    while (searchPhrase.Length == 0)
                    {
                        red();
                        Console.WriteLine("Error! You didn't enter anything, try again!");
                        cyan();
                        Console.Write("Enter a name you want to search for in the inventory: "); reset(); 
                        searchPhrase = Console.ReadLine().Trim();
                    }
                    // Search for the name in the inventory. 
                    foreach(var vacation in vacations)
                    {
                        if ( vacation.vacationName.ToLower().Contains(searchPhrase.ToLower()) || vacation.location.ToLower().Contains(searchPhrase.ToLower()) )
                        {
                            returnList.Add(vacation); 
                        }
                    }
                    break;

                case "price":
                    float searchPrice = -1;
                    repeat = true; 
                    do
                    {
                        try
                        {
                            cyan();
                            Console.Write("Enter the max price to filter out in the inventory: $"); reset(); 
                            searchPrice = float.Parse(Console.ReadLine());
                            // Search phrase input validation. 
                            while (searchPrice <= 0)
                            {
                                red();
                                Console.WriteLine("Error! You must enter a price greater than $0, try again!");
                                cyan();
                                Console.Write("Enter the max price to filter out in the inventory: $"); reset(); 
                                searchPrice = float.Parse(Console.ReadLine());
                            }
                            repeat = false; // break out of loop. 
                        }
                        catch
                        {
                            red();
                            Console.WriteLine("Error! You entered something invalid, try again!");
                            reset(); 
                        }
                    } while (repeat != false); 

                    // Search for the price in the inventory. 
                    foreach (var vacation in vacations)
                    {
                        if (vacation.price <= searchPrice)
                        {
                            returnList.Add(vacation);
                        }
                    }
                    break;

                case "date":
                    // Get vacation starting date from the user. 
                    // Date variables. 
                    int month = -1, day = -1, year = -1; // null
                    DateTime searchDate = new DateTime();
                    repeat = true;
                    do
                    {
                        try
                        {
                            // Get starting date's month from user.
                            cyan();
                            Console.Write("Enter search date's month (1-12): "); reset();
                            month = int.Parse(Console.ReadLine());
                            // Input validation for month. 
                            while (month < 1 || month > 12)
                            {
                                red();
                                Console.Write("Please enter a valid month (1-12): "); reset();
                                month = int.Parse(Console.ReadLine());
                            }
                            // Get starting date's day from user. 
                            cyan();
                            if (month == 11 || month == 4 || month == 6 || month == 9)
                            {
                                Console.Write("Enter search date's day (1-30): "); reset();
                                day = int.Parse(Console.ReadLine());
                                while (day < 1 || day > 30)
                                {
                                    red();
                                    Console.Write("Error! Enter a day (1-30): "); reset();
                                    day = int.Parse(Console.ReadLine());
                                }
                            }
                            else if (month == 2)
                            {
                                Console.Write("Enter search date's day (1-28): "); reset();
                                day = int.Parse(Console.ReadLine());
                                while (day < 1 || day > 28)
                                {
                                    red();
                                    Console.Write("Error! Enter a day (1-28): "); reset();
                                    day = int.Parse(Console.ReadLine());
                                }
                            }
                            else
                            {
                                Console.Write("Enter search date's day (1-31): "); reset();
                                day = int.Parse(Console.ReadLine());
                                while (day < 1 || day > 31)
                                {
                                    red();
                                    Console.Write("Error! Enter a day (1-31): "); reset();
                                    day = int.Parse(Console.ReadLine());
                                }
                            }
                            // Get starting date's year from user. 
                            cyan();
                            Console.Write("Enter search date's year: "); reset();
                            year = int.Parse(Console.ReadLine());
                            while (year < 2022)
                            {
                                red();
                                Console.Write("Error! Search date's year cannot be before 2022. Try again: "); reset();
                                year = int.Parse(Console.ReadLine());
                            }
                            // At this point, a correct date has been entered by the user so break out of do-while loop and set the new date. 
                            searchDate = new DateTime(year, month, day);
                            repeat = false; // Exit out of do-while loop. 
                        }
                        catch
                        {
                            red();
                            Console.WriteLine("You entered something invalid while filtering by date, try all over again!");
                            reset();
                        }
                    } while (repeat != false);

                    // Search inventory for date filtered results. 
                    foreach(var vacation in vacations)
                    {
                        // string itemDate = vacation.startingDate.Month + "/" + vacation.startingDate.Day + "/" + vacation.startingDate.Year;
                        if (vacation.startingDate.Year.ToString().Contains(searchDate.Year.ToString()))
                        {
                            returnList.Add(vacation); 
                        }
                        else if (vacation.startingDate.Month.ToString().Contains(searchDate.Month.ToString()))
                        {
                            returnList.Add(vacation); 
                        }
                        else if (vacation.startingDate.Day.ToString().Contains(searchDate.Day.ToString()))
                        {
                            returnList.Add(vacation); 
                        }
                    }
                    reset(); 
                    break;
            }
            reset(); 

            return returnList; 
        }
        public static void changeVacationQuantity(int quantityChange, List<Vacation> vacations)
        {
            if (quantityChange == -1)
            {
                printCurrentInventory(vacations);
                bool condition = false;
                do
                {
                    try
                    {
                        cyan(); 
                        Console.Write("Enter the index of the vacation quantity you want to change: "); reset(); 
                        quantityChange = int.Parse(Console.ReadLine());
                        while (quantityChange < 1 || quantityChange > vacations.Count)
                        {
                            red(); 
                            Console.WriteLine("You entered an invalid index, try again!");
                            cyan();
                            Console.Write("Enter the index of the vacation quantity you want to change: "); reset();
                            quantityChange = int.Parse(Console.ReadLine());
                        }
                        changeVacationQuantity(quantityChange, vacations);
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
                    if (quantityChange - 1 == index)
                    {
                        bool repeat = true;
                        int tempQuantity = vacation.quantity; // For debugging purposes only. 
                        do
                        {
                            try
                            {
                                yellow();
                                Console.WriteLine("(Current vacation quantity = " + vacation.quantity + ")"); 
                                cyan();
                                Console.Write("Enter a new quantity for this vacation item: "); reset();
                                quantityChange = int.Parse(Console.ReadLine());
                                while (quantityChange < 0)
                                {
                                    red();
                                    Console.WriteLine("Error! Quantity cannot be a negative value, try again!");
                                    yellow();
                                    Console.WriteLine("(Current vacation quantity = " + vacation.quantity + ")");
                                    cyan();
                                    Console.Write("Enter a new quantity for this vacation item: "); reset();
                                    quantityChange = int.Parse(Console.ReadLine()); 
                                }
                                repeat = false; 
                            }
                            catch
                            {
                                red();
                                Console.WriteLine("You entered something invalid, try again!");
                                vacation.quantity = tempQuantity; 
                                reset(); 
                            }
                        } while (repeat != false); 

                        vacation.quantity = quantityChange;
                        Console.ForegroundColor = ConsoleColor.Green;
                        Console.WriteLine("The vacation item's quantity was successfully changed in the inventory.");
                        reset(); 
                        break;
                    }
                    index++;
                }
            }
        }

        // Console Coloring Utility Functions. 
        public static void cyan()
        {
            Console.ForegroundColor = ConsoleColor.Cyan; 
        }
        public static void red()
        {
            Console.ForegroundColor = ConsoleColor.Red; 
        }
        public static void yellow()
        {
            Console.ForegroundColor = ConsoleColor.Yellow; 
        }
        public static void green()
        {
            Console.ForegroundColor = ConsoleColor.Green; 
        }
        public static void reset()
        {
            Console.ResetColor(); 
        }

        // Other Utility Functions.
        public static void newline()
        {
            Console.WriteLine();
        }
    }
}

/*
Author: Shazeb Suhail
Date:   1/21/2022
*/
