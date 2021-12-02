using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HeroMazeGame
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello WRLD!\n");

            Hero thor = new Hero();
            thor.Name = "Thor Almighty";
            thor.HealthPoints = 100;
            thor.RowNumber = 2;
            thor.ColumnNumber = 0;
            thor.ThingsInMyBag.Add("Hammer");
            thor.ThingsInMyBag.Add("Comb");
            thor.ThingsInMyBag.Add("Mirror");

            Hero shaz = new Hero();
            shaz.Name = "Shaz da Wizard";
            shaz.HealthPoints = 99;
            shaz.RowNumber = 0; 
            shaz.ColumnNumber = 0;
            shaz.ThingsInMyBag.Add("11th Generation i9 CPU");
            shaz.ThingsInMyBag.Add("NVIDIA GeForce RTX 3090");
            shaz.ThingsInMyBag.Add("10tb SSD Hard-Drive");
            shaz.ThingsInMyBag.Add("64gb RAM"); 

            thor.SayHi();
            shaz.SayHi();
            newline();

            thor.HealthPoints = 50;
            thor.HowAmIFeeling();
            newline(); 

            shaz.HowAmIFeeling();
            newline();

            // Print thor's and shaz's ToString methods.
            Console.WriteLine(thor);
            newline(); 
            Console.WriteLine(shaz);
            newline();

            // Wait for user's clearance before exiting program. 
            Console.ReadKey();
        }

        public static void newline() { Console.WriteLine(); }
        public static void newline(int n) { for (int i = 0; i < n; i++) newline(); }
    }
}
