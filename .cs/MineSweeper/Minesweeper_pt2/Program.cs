using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Minesweeper_pt2
{
    class Program
    {
        static bool gameOver = false;
        static bool userWin = false;

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

            // set game difficulty for board object 
            // (aka: call board setupLiveNeighbors method) 
            board.setupLiveNeighbors(getDifficulty(board));

            // call board calculateLiveNeighbors method
            board.calculateLiveNeighbors();

            // display board in console 
            printBoardWithNeighbors(board); newline();
            printBoardv3(board);

            // start a while loop to keep playing the game. 
            while (!gameOver)
            {
                // local variables within loop 
                int row = -1, col = -1;
                bool valid = false;

                // display instructions to Game User
                // validate row input 
                do
                {
                    try
                    {
                        yellow(); Console.WriteLine("Enter a row number: "); reset();
                        row = int.Parse(Console.ReadLine());
                        while (row < 0 || row > board.size - 1)
                        {
                            red(); Console.WriteLine($"Error! Please enter a whole number 0-{board.size - 1}, try again."); reset();
                            yellow(); Console.WriteLine("Enter a row number: "); reset();
                            row = int.Parse(Console.ReadLine());
                        }
                        valid = true;
                    }
                    catch
                    {
                        red(); Console.WriteLine($"Error! Please enter a whole number 0-{board.size - 1}, try again."); reset();
                    }
                } while (!valid);

                // validate column input 
                valid = false;
                do
                {
                    try
                    {
                        yellow(); Console.WriteLine("Enter a column number: "); reset();
                        col = int.Parse(Console.ReadLine());
                        while (col < 0 || col > board.size - 1)
                        {
                            red(); Console.WriteLine($"Error! Please enter a whole number 0-{board.size - 1}, try again."); reset();
                            yellow(); Console.WriteLine("Enter a column number: "); reset();
                            col = int.Parse(Console.ReadLine());
                        }
                        valid = true;
                    }
                    catch
                    {
                        red(); Console.WriteLine($"Error! Please enter a whole number 0-{board.size - 1}, try again."); reset();
                    }
                } while (!valid);

                // mark that coordinate on the grid. 
                markCoordinate(board, row, col);
            }
            if (gameOver && userWin == false)
            {
                red(); Console.WriteLine("User hit a bomb and lost."); reset();
            }
            else if (gameOver && userWin)
            {
                green(); Console.WriteLine("User has cleared the board and won!"); reset();
            }

            // wait to exit program 
            newline(); printBoardWithNeighbors(board); newline();
            red(); Console.WriteLine("-- Game Over --"); reset();
            Console.ReadLine();
        }

        // Functions
        static void markCoordinate(Board board, int row, int col)
        {
            // local function variables 

            // mark the grid coordinate
            if (board.grid[row, col].isLive == true)
            {
                red(); Console.WriteLine("You hit a bomb!"); reset();
                board.grid[row, col].isVisited = true;
                // mark game as over
                userWin = false;
                gameOver = true;
            }
            else
            {
                green(); Console.WriteLine("Not a bomb"); reset();
                board.grid[row, col].isVisited = true;

                // check if user has won
                bool boardCleared = false;
                int totalSweep = 0;
                int totalCorrect = 0;
                for (var i = 0; i < board.size; i++)
                {
                    for (var j = 0; j < board.size; j++)
                    {
                        if (board.grid[i, j].liveNeighbors > 0 && board.grid[i, j].liveNeighbors < 9)
                        {
                            totalSweep++;
                        }
                        if (board.grid[i, j].liveNeighbors > 0 && board.grid[i, j].liveNeighbors < 9 && board.grid[i, j].isVisited)
                        {
                            totalCorrect++;
                        }
                    }
                }
                if (totalSweep == totalCorrect)
                {
                    userWin = true;
                    gameOver = true;
                }
            }
            // newline(); printBoardWithNeighbors(board); newline(); /* turn this off to play without help */ 
            printBoardv3(board);
        }

        // print board (version 3) 
        static void printBoardv3(Board board)
        {
            newline();
            // ROW LOOP
            for (var r = 0; r < board.size; r++)
            {
                // COLUMN LOOP
                for (var c = 0; c < board.size; c++)
                {
                    // Print column numbers (only occurs once) 
                    if (r == 0 && c == 0)
                    {
                        Console.Write("   "); // beginning padding
                        yellow();
                        for (var k = 0; k < board.size; k++)
                        {
                            if (k < 10)
                                Console.Write($"  {k} ");
                            else
                                Console.Write($" {k} ");
                        }
                        reset();
                        newline(2);
                    }

                    // Print row number
                    if (c == 0)
                    {
                        yellow();
                        if (r < 10)
                            Console.Write($" {r} ");
                        else
                            Console.Write($"{r} ");
                        reset();
                    }


                    // if Cell hasn't been clicked yet
                    if (board.grid[r, c].isVisited == false)
                    {
                        Console.Write("  ? ");
                    }
                    else
                    {
                        switch (board.grid[r, c].liveNeighbors)
                        {
                            case 0:
                                cyan();
                                Console.Write($"  - "); reset();
                                break;

                            case 1:
                                darkGreen(); Console.Write($"  {board.grid[r, c].liveNeighbors} "); reset();
                                break;

                            case 2:
                                blue(); Console.Write($"  {board.grid[r, c].liveNeighbors} "); reset();
                                break;

                            case 3:
                                darkYellow(); Console.Write($"  {board.grid[r, c].liveNeighbors} "); reset();
                                break;

                            case 4:
                                cyan(); Console.Write($"  {board.grid[r, c].liveNeighbors} "); reset();
                                break;

                            case 9:
                                red(); Console.Write($"  {board.grid[r, c].liveNeighbors} "); reset();
                                break;

                            default:
                                gray(); Console.Write($"  {board.grid[r, c].liveNeighbors} "); reset();
                                break;
                        }
                    }
                }
                newline(); // newline after every row
            }
            newline();
        }

        static void printBoard(Board board)
        {
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
            yellow(); Console.WriteLine("Here is the board printed showing liveNeighbors for all Cells."); reset();
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
                        switch (board.grid[x, y].liveNeighbors)
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
                        switch (board.grid[x, y].liveNeighbors)
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
            while (size < 10 || size > 50)
            {
                try
                {
                    // display instructions for user input
                    yellow(); Console.Write("Enter a size for your board (10-50): "); reset();

                    // get input for size from user
                    size = int.Parse(Console.ReadLine());

                    // print error message (if appropriate) L
                    if (size < 10 || size > 50)
                    {
                        red(); Console.WriteLine("Error! Incorrect size range, try again!");
                    }
                }
                catch
                { // exceptions 
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
                    if (difficulty < 1 || difficulty > 99)
                    {
                        red(); Console.WriteLine("Error! Incorrect range for difficulty, try again!");
                    }
                }
                catch
                {
                    red(); Console.WriteLine("Error! You entered something invalid, try again!");
                }
            }

            // round difficulty value to nearest integer value
            difficulty = (float)Math.Round(difficulty);

            // display difficulty percentage to user 
            green(); Console.WriteLine($"You set the game difficulty to {difficulty}%"); reset();

            // calculate how many bombs should be active according to user inputted difficulty 
            int liveBombs = (int)((board.size * 2) * (difficulty / 100));

            // at least one bomb should be active if difficulty percentage is too low 
            if (liveBombs == 0) liveBombs = 1;

            // display to user number of live bombs on the board
            // Console.WriteLine($"Live Bombs: {liveBombs}"); // (display only for debugging purposes) 

            return (float)liveBombs;
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
