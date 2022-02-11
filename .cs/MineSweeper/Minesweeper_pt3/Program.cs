using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Minesweeper
{
    class Program
    {
        // global variables 
        public static bool gameOver = false;
        public static bool userWin = false;

        // main method 
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
            board.setupLiveNeighbors(getDifficulty(board));

            // call board calculateLiveNeighbors method
            board.calculateLiveNeighbors();

            // display board in console 
            // printBoardWithNeighbors(board); newline();
            printBoard(board);


            // start a while loop to keep playing the game. 
            while (!gameOver)
            {
                // local variables within game loop 
                int row = -1, col = -1;
                bool valid = false;

                // get row input  
                do
                {
                    // set flag conditional loop 
                    while (board.setFlag())
                    {
                        printBoard(board); 
                    }

                    // get user input 
                    try
                    {
                        green(); 
                        Console.WriteLine("\nOkay time to play...");
                        yellow(); Console.WriteLine("Enter a row number: "); reset();
                        row = int.Parse(Console.ReadLine());

                        // validate user's input 
                        while (row < 0 || row > board.size - 1)
                        {
                            red(); Console.WriteLine($"Error! Please enter a whole number 0-{board.size - 1}, try again."); reset();
                            yellow(); Console.WriteLine("Enter a row number: "); reset();
                            row = int.Parse(Console.ReadLine());
                        }

                        // valid input has been entered 
                        valid = true;
                    }
                    catch // any exceptions 
                    {
                        red(); Console.WriteLine($"Error! Please enter a whole number 0-{board.size - 1}, try again."); reset();
                    }
                } while (!valid);


                // get column input 
                valid = false;
                do
                {
                    // get user input 
                    try
                    {
                        yellow(); Console.WriteLine("Enter a column number: "); reset();
                        col = int.Parse(Console.ReadLine());

                        // validate user input 
                        while (col < 0 || col > board.size - 1)
                        {
                            red(); Console.WriteLine($"Error! Please enter a whole number 0-{board.size - 1}, try again."); reset();
                            yellow(); Console.WriteLine("Enter a column number: "); reset();
                            col = int.Parse(Console.ReadLine());
                        }

                        // valid input has been entered 
                        valid = true;
                    }
                    catch // any exceptions
                    {
                        red(); Console.WriteLine($"Error! Please enter a whole number 0-{board.size - 1}, try again."); reset();
                    }
                } while (!valid);


                // mark that coordinate on the grid. 
                markCoordinate(board, row, col);

            }
            // show all cells on the grid  
            newline(); printBoardWithNeighbors(board); newline();


            // game over results 
            // -----------------
            // user loss
            if (gameOver && userWin == false)
            {
                red(); Console.WriteLine("User hit a bomb and lost."); reset();
            }
            // user win 
            else if (gameOver && userWin)
            {
                green(); Console.WriteLine("User has cleared the board and won!"); reset();
            }

            // wait to exit program
            Console.WriteLine("Your score cannot be shown at this time."); 
            red(); Console.WriteLine("-- Game Over --"); reset();
            Console.ReadLine();

        } // end of main method 


        // Functions

        public static void floodFill(Board board, int row, int col)
        {
            // check to see if cell has already been visited 
            if (board.grid[row, col].isVisited == true)
            {
                return;
            }
            else // cell has not yet been visited 
            {
                // mark cell as visited
                board.grid[row, col].isVisited = true;

                // if cell has 0 live neighbors , flood fill if possible 
                if (board.grid[row, col].liveNeighbors == 0)
                {
                    // go south 
                    if (row + 1 < board.size && board.grid[row + 1, col].isVisited == false)
                    {
                        floodFill(board, row + 1, col);
                    }
                    // go north 
                    if (row - 1 >= 0 && board.grid[row - 1, col].isVisited == false)
                    {
                        floodFill(board, row - 1, col);
                    }
                    // go east 
                    if (col + 1 < board.size && board.grid[row, col + 1].isVisited == false)
                    {
                        floodFill(board, row, col + 1);
                    }
                    // go west 
                    if (col - 1 >= 0 && board.grid[row, col - 1].isVisited == false)
                    {
                        floodFill(board, row, col - 1);
                    }
                    // go NE
                    if (row - 1 >= 0 && col + 1 < board.size && board.grid[row - 1, col + 1].isVisited == false)
                    {
                        floodFill(board, row - 1, col + 1);
                    }
                    // go NW
                    if (row - 1 >= 0 && col - 1 >= 0 && board.grid[row - 1, col - 1].isVisited == false)
                    {
                        floodFill(board, row - 1, col - 1);
                    }
                    // go SE
                    if (row + 1 < board.size && col + 1 < board.size && board.grid[row + 1, col + 1].isVisited == false)
                    {
                        floodFill(board, row + 1, col + 1);
                    }
                    // go SW
                    if (row + 1 < board.size && col - 1 >= 0 && board.grid[row + 1, col - 1].isVisited == false)
                    {
                        floodFill(board, row + 1, col - 1);
                    }
                }
                else // no flood fill was possible 
                    return;
            }
        }

        
        public static void markCoordinate(Board board, int row, int col)
        {
            // if user hit a bomb, game over 
            if (board.grid[row, col].isLive == true)
            {
                // print "hit bomb" message 
                red(); Console.WriteLine("You hit a bomb!"); reset();
                board.grid[row, col].isVisited = true;

                // mark game as over
                userWin = false;
                gameOver = true;
            }
            else if (board.grid[row, col].liveNeighbors == 0)
            {
                floodFill(board, row, col);
            }
            // user did not hit a bomb, continue game 
            else
            {
                // print "bomb not hit" message 
                green(); Console.WriteLine("Not a bomb"); reset();
                board.grid[row, col].isVisited = true;
            }

            // CHECK TO SEE IF USER HAS WON
            // local variables 
            bool boardCleared = false;
            int totalSweep = 0;
            int totalCorrect = 0;
            // loop through grid and calculate number of safe cells visited
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
            // check if user has won  
            if (totalSweep == totalCorrect)
            {
                green(); Console.WriteLine("All safe cells have been revealed!");
                userWin = true;
                gameOver = true;
            }

            // newline(); printBoardWithNeighbors(board); newline(); // turn this off to play without help 
            printBoard(board);
        }
        

        public static void printBoard(Board board)
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


                    // if Cell has a flag 
                    if (board.grid[r, c].hasFlag == true)
                    {
                        red(); Console.Write("  * "); reset();
                    }
                    // if Cell hasn't been clicked yet
                    else if (board.grid[r, c].isVisited == false)
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

                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                magenta(); Console.Write($"  {board.grid[r, c].liveNeighbors} "); reset();
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
                                magenta(); Console.Write($"  {board.grid[x, y].liveNeighbors} "); reset();
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
                                magenta(); Console.Write($"  {board.grid[x, y].liveNeighbors} "); reset();
                                break;
                        }
                    }
                }
                Console.WriteLine($"    {x}"); // print row indices
            }
            newline();
        }

        public static void getTurnFromUser()
        {
            // ... 
        }

        public static void initializeGame()
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
