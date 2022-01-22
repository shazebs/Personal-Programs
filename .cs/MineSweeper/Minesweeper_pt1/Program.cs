using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Minesweeper_pt1
{
    class Program
    {
        // Main Method
        static void Main(string[] args)
        {
            // declare local variables
            int size = 0;
            float difficulty = 0; 

            // Display welcome message
            cyan(); Console.WriteLine("Welcome to Minesweeper!"); reset();

            // get board size from user 
            size = getBoardSize();

            // create a new Board object
            Board board = new Board(size); // set to default(10)
            board.size = size;

            // Console.WriteLine($"Size: {board.size}");

            // set game difficulty for board object 
            // (aka: call board setupLiveNeighbors method) 
            board.setupLiveNeighbors(getDifficulty(board));

            // call board calculateLiveNeighbors method
            board.calculateLiveNeighbors(); 

            // display board in console 
            newline(); 
            printBoard(board);

            // (display board for debugging purposes only)
            newline();
            printBoardWithNeighbors(board); 

            // wait to exit program 
            Console.ReadLine(); 
        }

        // Functions
        static void printBoard(Board board)
        {
            // loop through rows
            for (var x=0; x<board.size; x++)
            {
                // Create column indices
                if (x == 0) {
                    for (var k = 0; k < board.size; k++) {
                        if (k < 10)
                            Console.Write($"  {k} "); 
                        else 
                            Console.Write($" {k} ");
                    }
                    newline(2);
                }

                // loop through columns 
                for (var y=0; y<board.size; y++)
                {
                    // if cell hasn't been clicked. 
                    if (board.grid[x, y].isVisited == false)
                    {
                        /*if (y > 9)
                            Console.Write("  ~ ");
                        else
                            Console.Write("  ~ ");*/
                        Console.Write("  - ");
                    }

                    // else-if cell has been clicked. 
                    else if (board.grid[x, y].isVisited) 
                    {
                        red(); Console.Write("  * "); reset(); 
                    }
                }

                Console.WriteLine($"    {x}"); // print row indices
            }
            newline(); 
        }

        public static void printBoardWithNeighbors(Board board)
        {
            magenta(); Console.WriteLine("Here is the board printed showing liveNeighbors for all Cells."); reset();
            newline(); 

            // loop through rows
            for (var x = 0; x < board.size; x++)
            {
                // Create column indices
                if (x == 0)
                {
                    for (var k = 0; k < board.size; k++)
                    {
                        if (k < 10)
                            Console.Write($"  {k} ");
                        else
                            Console.Write($" {k} ");
                    }
                    newline(2);
                }

                // loop through columns 
                for (var y = 0; y < board.size; y++)
                {
                    // if cell hasn't been clicked. 
                    if (board.grid[x, y].isVisited == false)
                    {
                        switch(board.grid[x, y].liveNeighbors)
                        {
                            case 0:
                                Console.Write($"  - ");
                                break; 

                            case 1:
                                darkGreen(); Console.Write($"  {board.grid[x, y].liveNeighbors} "); reset();
                                break;

                            case 2:
                                blue(); Console.Write($"  {board.grid[x, y].liveNeighbors} "); reset();
                                break;

                            case 3:
                                darkYellow(); Console.Write($"  {board.grid[x, y].liveNeighbors} "); reset();
                                break;

                            case 4:
                                cyan(); Console.Write($"  {board.grid[x, y].liveNeighbors} "); reset();
                                break;

                            case 9:
                                red(); Console.Write($"  {board.grid[x, y].liveNeighbors} "); reset();
                                break;

                            default:
                                gray(); Console.Write($"  {board.grid[x, y].liveNeighbors} "); reset();
                                break;
                        }
                    }
                    // else-if cell has been clicked. 
                    else if (board.grid[x, y].isVisited)
                    {
                        red(); Console.Write("  * "); reset();
                    }
                }
                Console.WriteLine($"    {x}"); // print row indices
            }
            newline();
        }

        static void getTurnFromUser()
        {
            // ... 
        }

        static void initializeGame()
        {
            // ... 
        }

        public static int getBoardSize()
        {
            int size = 0; // var to return 

            // Get input from user for board size
            while (size < 10 || size > 50) {
                try {
                    // display instructions for user input
                    yellow(); Console.Write("Enter a size for your board (10-50): "); reset();

                    // get input for size from user
                    size = int.Parse(Console.ReadLine());

                    // print error message (if appropriate) L
                    if (size < 10 || size > 50) {
                        red(); Console.WriteLine("Error! Incorrect size range, try again!");
                    }
                }
                catch { // exceptions 
                    red();
                    Console.WriteLine("Error! You entered something invalid, try again!");
                    reset();
                }
            }
            reset();
            return size;
        }

        public static float getDifficulty(Board board)
        {
            float difficulty = 0;

            while (difficulty < 1 || difficulty > 99)
            {
                try
                {
                    // ask user to enter a game difficulty
                    yellow();
                    Console.Write("Enter a game difficulty from (1-99%): "); reset();

                    // get input from user
                    difficulty = float.Parse(Console.ReadLine());

                    // print error message (if appropriate)
                    if (difficulty < 1 || difficulty > 99) {
                        red(); Console.WriteLine("Error! Incorrect range for difficulty, try again!");
                    }
                }
                catch {
                    red(); Console.WriteLine("Error! You entered something invalid, try again!");
                }
            }

            // round difficulty value to nearest integer value
            difficulty = (float)Math.Round(difficulty);

            // display difficulty percentage to user 
            green(); Console.WriteLine($"You set the game difficulty to {difficulty}%"); reset();

            // calculate how many bombs should be active according to user inputted difficulty 
            int liveBombs = (int)((board.size*2) * (difficulty / 100));

            // at least one bomb should be active if difficulty percentage is too low 
            if (liveBombs == 0) liveBombs = 1;

            // display to user number of live bombs on the board
            // Console.WriteLine($"Live Bombs: {liveBombs}"); // (display only for debugging purposes) 

            return (float) liveBombs;
        }

        // Console coloring functions
        public static void red() { Console.ForegroundColor = ConsoleColor.Red; }
        public static void cyan() { Console.ForegroundColor = ConsoleColor.Cyan; }
        public static void yellow() { Console.ForegroundColor = ConsoleColor.Yellow; }
        public static void green() { Console.ForegroundColor = ConsoleColor.Green; }
        public static void darkGreen() { Console.ForegroundColor = ConsoleColor.DarkGreen; }
        public static void magenta() { Console.ForegroundColor = ConsoleColor.Magenta; }
        public static void blue() { Console.ForegroundColor = ConsoleColor.Blue; }
        public static void darkYellow() { Console.ForegroundColor = ConsoleColor.DarkYellow; }
        public static void gray() { Console.ForegroundColor = ConsoleColor.Gray; }
        public static void reset() { Console.ResetColor(); }

        // Utility functions
        public static void newline() { Console.WriteLine(); }
        public static void newline(int x) { for (var i = 0; i < x; i++) newline(); }
    }
}
