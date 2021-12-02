using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace FileIODemo
{
    class Program
    {
        static void Main(string[] args)
        {
            // Create a string variable to hold a directory path. 
            string filePath = @"H:\GCU Fall 2021\CST-150 with Shad Sluiter\Activity 4\text.txt";

            // Create an array object. 
            List<string> lines = new List<string>();
            List<Person> people = new List<Person>();

            lines = File.ReadAllLines(filePath).ToList();

            // Traverse thru the lines array. 
            foreach (string line in lines)
            {
                string[] items = line.Split(',');
                Person p = new Person(items[0], items[1], items[2]);
                people.Add(p);
            }

            List<string> outContents = new List<string>(); 

            // Traverse thru the people array. 
            foreach (Person p in people)
            {
                // Display a person object's .ToString(); method in the console. 
                Console.WriteLine(p);
                outContents.Add(p.ToString());
            }

            // Create a string variable to hold the path of the outfile to be written to.
            string outFile = @"H:\GCU Fall 2021\CST-150 with Shad Sluiter\Activity 4\outputFile.txt";

            // Write to the outFile. 
            File.WriteAllLines(outFile, outContents); 

            // Wait for user before exiting. 
            Console.ReadLine();
        }
    }
}

// Version 1 (saved for later) 

/*// Read all lines from text file into array object.
            lines = File.ReadAllLines(filePath).ToList();

            // Traverse thru the array container.
            foreach (string line in lines)
            {
                // Display a single line from the array. 
                Console.WriteLine(line); 
            }

            // Add a custome line to the end of the file. 
            lines.Add("John, Doe, www.nobody.com");

            // Re-write the file, this time including the custom line at the end. 
            File.WriteAllLines(filePath, lines);*/
