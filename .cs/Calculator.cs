 
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator
{
    class Program
    {
        static void Main(string[] args)
        {
            // declare variables
            float num1 = 0;
            float num2 = 0;

            // display title of console app
            Console.WriteLine("Console Calculator in C#\r");
            Console.WriteLine("------------------------\n");

            // get input for 'num1' from user.
            Console.WriteLine("Type a number, and then press Enter");
            num1 = Convert.ToInt32(Console.ReadLine());

            // get input for 'num2' from user. 
            Console.WriteLine("Type another number, and then press Enter");
            num2 = Convert.ToInt32(Console.ReadLine());

            // ask the user to choose an option.
            Console.WriteLine("Choose an option from the following list:");
            Console.WriteLine("\ta - Add");
            Console.WriteLine("\ts - Subtract");
            Console.WriteLine("\tm - Multiply");
            Console.WriteLine("\td - Divide");
            Console.Write("Your option? "); 

            // create a switch menu 
            switch (Console.ReadLine())
            {
                case "a":
                    Console.WriteLine($"Your result: {num1} + {num2} = " + (num1 + num2));
                    break;
                case "s":
                    Console.WriteLine($"Your result: {num1} - {num2} = " + (num1 - num2));
                    break;
                case "m":
                    Console.WriteLine($"Your result: {num1} * {num2} = " + (num1 * num2));
                    break;
                case "d":
                    // ask the user to enter a non-zero divisor until they do so.
                    while (num2 == 0)
                    {
                        Console.WriteLine("Enter a non-zero divisor: ");
                        num2 = Convert.ToInt32(Console.ReadLine()); 
                    }
                    Console.WriteLine($"Your result: {num1} / {num2} = " + (num1 / num2)); 
                    break;
            }
            // wait for user to respond before closing.
            Console.WriteLine("Press any key to close the Calculator console app...");
            Console.ReadKey();
        }
    }
}
