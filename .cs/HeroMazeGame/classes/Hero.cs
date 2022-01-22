using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HeroMazeGame
{
    class Hero
    {
        public string Name { get; set; }
        public int HealthPoints { get; set; }
        public int RowNumber { get; set; }
        public int ColumnNumber { get; set; }
        public List<string> ThingsInMyBag 
        { 
            get; set; 
        }

        // constructor method. 
        // "called" when a new hero is hatched. 

        // Overloaded contructor. 
        public Hero()
        {
            ThingsInMyBag = new List<String>(); 
        }

        public void SayHi()
        {
            Console.WriteLine("Hello. I am a hero. My name is " + Name + "."); 
        }

        public void HowAmIFeeling()
        {
            // Print a message to tell how much health you have. 
            Console.WriteLine("{1} has {0} Health Points left.", HealthPoints, Name);

            // If health is low. 
            if (HealthPoints > 70)
                Console.WriteLine("{0} has great health!", Name);
            else if (HealthPoints > 20)
                Console.WriteLine("{0} is at ok health.", Name);
            else
                Console.WriteLine("{0} is at low health!", Name);
        }

        // .ToString(); method. 
        public override String ToString()
        {
            String msg = "My name is " + Name + "\nMy health is " + HealthPoints
                + "\nI am carrying " + ThingsInMyBag.Count + " items in my bag.";

            for (int i = 0; i < ThingsInMyBag.Count; i++)
            {
                msg += "\nOne item is " + ThingsInMyBag[i] + "."; 
            }

            return msg; 
        }

        // Take a Hit method.
        public void takeAHit(int hit)
        {
            HealthPoints -= hit;
        }

        // Eat a Health Pill method. 
        public void healthPill(int pill)
        {
            HealthPoints += pill;
            if (HealthPoints >= 100)
            {
                Console.WriteLine("{0} is now at Full Health!", Name);
                HealthPoints = 100; 
            }
        }

        // Move North method. 
        public void moveNorth(int spaces)
        {
            Console.WriteLine("{0} moved {1} spaces North.", Name, spaces);
            if (RowNumber - spaces < 0)
            {
                Console.WriteLine("{0} cannot move " + spaces + " spaces north, otherwise {0} will fall of the grid.");
            }
            else
                RowNumber -= spaces; 
        }

        // Move East method. 
        public void moveEast(int spaces)
        {
            Console.WriteLine("{0} moved {1} spaces East.", Name, spaces);
        }

        // Move West method. 
        public void moveWest(int spaces)
        {
            Console.WriteLine("{0} moved {1} spaces West.", Name, spaces);
        }

        // Move South method. 
        public void moveSouth(int spaces)
        {
            Console.WriteLine("{0} moved {1} spaces South.", Name, spaces);
        }
    }
}
