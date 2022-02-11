using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Minesweeper
{
    public class Board
    {
        // Properties 

        public Cell[,] grid { get; set; }
        public float difficulty { get; set; }
        public int size { get; set; }
        public int totalBombs { get; set; }
        public int hiddenBombs { get; set; }


        // Constructors 

        public Board()
        {
            //... 
        }
        public Board(int size)
        {
            // size the grid. 
            this.grid = new Cell[size, size];

            // loop through grid. 
            for (int x = 0; x < size; x++)
            {
                for (int y = 0; y < size; y++)
                {
                    // place a Cell into selected grid index
                    // and initialize Cell row/col properties. 
                    grid[x, y] = new Cell(x, y);
                }
            }
        }


        // Methods

        public void setupLiveNeighbors(float difficulty)
        {
            // Display to user number of live bombs 
            Program.red();
            Console.WriteLine($"This board has: {difficulty} live bombs.");
            Program.reset();

            // initialize total number of live bombs
            this.totalBombs = (int)difficulty;

            // create a random number generator
            Random rand = new Random();

            int bombsInit = 0; // temporary running total 
            while (bombsInit != this.totalBombs)
            {
                // select random coordinates on the grid 
                int x = rand.Next(this.size);
                int y = rand.Next(this.size);

                /* set a bomb at this grid coordinate if Cell does not already have live bomb 
                 otherwise, try again at new coordinate */
                if (this.grid[x, y].isLive == false)
                {
                    this.grid[x, y].isLive = true;
                    bombsInit++;

                    /* (for debugging purposes only - uncomment as necessary) */
                    // Console.WriteLine($"Bomb #{bombsInit} has been set!");
                    // this.grid[x, y].isVisited = true;
                }
            }
        }

        public void calculateLiveNeighbors()
        {
            // loop through rows
            for (int r = 0; r < this.size; r++)
            {
                // loop through columns
                for (int c = 0; c < this.size; c++)
                {

                    /* // Professor Sluiter's Code

                    // nw 
                    if (r-1 >0 && c-1 > 0 && grid[r - 1, c - 1].isLive) grid[r,c].liveNeighbors++;

                    // ne 
                    if (r - 1 > 0 && c + 1 < size && grid[r - 1, c + 1].isLive) grid[r, c].liveNeighbors++;

                    // w
                    if ( c -1  > 0 && grid[r, c - 1].isLive) grid[r, c].liveNeighbors++;

                    */


                    // if selected Cell already has a bomb
                    if (grid[r, c].isLive)
                    {
                        grid[r, c].liveNeighbors = 9;
                        continue;   // move to next Cell
                    }


                    // (for board corner Cells only)
                    // top-left corner
                    if (r == 0 && c == 0)
                    {
                        // Console.WriteLine($"You are at top-left corner cell at coordinates [{r}, {c}]");

                        int nearbyBombs = 0;

                        // forward check
                        if (grid[r, c + 1].isLive) nearbyBombs++;

                        // bottom-right 
                        if (grid[r + 1, c + 1].isLive) nearbyBombs++;

                        // bottom 
                        if (grid[r + 1, c].isLive) nearbyBombs++;

                        // set liveNeighbors
                        grid[r, c].liveNeighbors = nearbyBombs;
                        continue;
                    }

                    // top-right corner
                    else if (r == 0 && c == this.size - 1)
                    {
                        // Console.WriteLine($"You are at top-right corner cell at coordinates [{r}, {c}]");

                        int nearbyBombs = 0;

                        // backward
                        if (grid[r, c - 1].isLive) nearbyBombs++;

                        // bottom-left
                        if (grid[r + 1, c - 1].isLive) nearbyBombs++;

                        // bottom
                        if (grid[r + 1, c].isLive) nearbyBombs++;

                        grid[r, c].liveNeighbors = nearbyBombs;
                        continue;
                    }

                    // bottom-left corner 
                    else if (r == this.size - 1 && c == 0)
                    {
                        // Console.WriteLine($"You are at bottom-left corner cell at coordinates [{r}, {c}]");

                        int nearbyBombs = 0;

                        // top
                        if (grid[r - 1, c].isLive) nearbyBombs++;

                        // top-right
                        if (grid[r - 1, c + 1].isLive) nearbyBombs++;

                        // forward
                        if (grid[r, c + 1].isLive) nearbyBombs++;

                        grid[r, c].liveNeighbors = nearbyBombs;
                        continue;
                    }

                    // bottom-right corner 
                    else if (r == this.size - 1 && c == this.size - 1)
                    {
                        // Console.WriteLine($"You are at bottom-right corner cell at coordinates [{r}, {c}]");

                        int nearbyBombs = 0;

                        // top
                        if (grid[r - 1, c].isLive) nearbyBombs++;

                        // top-left
                        if (grid[r - 1, c - 1].isLive) nearbyBombs++;

                        // backward
                        if (grid[r, c - 1].isLive) nearbyBombs++;

                        grid[r, c].liveNeighbors = nearbyBombs;
                        continue;
                    }


                    // (for Cells on board sides only) 
                    // top-side
                    if (r == 0)
                    {
                        int nearbyBombs = 0;

                        // forward
                        if (grid[r, c + 1].isLive) nearbyBombs++;

                        // bottom-right
                        if (grid[r + 1, c + 1].isLive) nearbyBombs++;

                        // bottom 
                        if (grid[r + 1, c].isLive) nearbyBombs++;

                        // bottom-left
                        if (grid[r + 1, c - 1].isLive) nearbyBombs++;

                        // backward
                        if (grid[r, c - 1].isLive) nearbyBombs++;

                        // set liveNeighbors
                        grid[r, c].liveNeighbors = nearbyBombs;
                        continue;
                    }

                    // right-side
                    else if (c == this.size - 1)
                    {
                        int nearbyBombs = 0;

                        // top
                        if (grid[r - 1, c].isLive) nearbyBombs++;

                        // top-left
                        if (grid[r - 1, c - 1].isLive) nearbyBombs++;

                        // backward
                        if (grid[r, c - 1].isLive) nearbyBombs++;

                        // bottom-left
                        if (grid[r + 1, c - 1].isLive) nearbyBombs++;

                        // bottom
                        if (grid[r + 1, c].isLive) nearbyBombs++;

                        // set liveNeighbors
                        grid[r, c].liveNeighbors = nearbyBombs;
                        continue;
                    }

                    // bottom-side
                    else if (r == this.size - 1)
                    {
                        int nearbyBombs = 0;

                        // forward
                        if (grid[r, c + 1].isLive) nearbyBombs++;

                        // top-right
                        if (grid[r - 1, c + 1].isLive) nearbyBombs++;

                        // top
                        if (grid[r - 1, c].isLive) nearbyBombs++;

                        // top-left 
                        if (grid[r - 1, c - 1].isLive) nearbyBombs++;

                        // backward
                        if (grid[r, c - 1].isLive) nearbyBombs++;

                        // set liveNeighbors
                        grid[r, c].liveNeighbors = nearbyBombs;
                        continue;
                    }

                    // left-side
                    else if (c == 0)
                    {
                        int nearbyBombs = 0;

                        // top
                        if (grid[r - 1, c].isLive) nearbyBombs++;

                        // top-right
                        if (grid[r - 1, c + 1].isLive) nearbyBombs++;

                        // forward
                        if (grid[r, c + 1].isLive) nearbyBombs++;

                        // bottom-right
                        if (grid[r + 1, c + 1].isLive) nearbyBombs++;

                        // bottom
                        if (grid[r + 1, c].isLive) nearbyBombs++;

                        // set liveNeighbors
                        grid[r, c].liveNeighbors = nearbyBombs;
                        continue;
                    }


                    // (for Cells in-between)
                    if ((r > 0 && r < this.size - 1) && (c > 0 && c < this.size - 1))
                    {
                        int nearbyBombs = 0;

                        // top
                        if (grid[r - 1, c].isLive) nearbyBombs++;

                        // top-right
                        if (grid[r - 1, c + 1].isLive) nearbyBombs++;

                        // right
                        if (grid[r, c + 1].isLive) nearbyBombs++;

                        // bottom-right
                        if (grid[r + 1, c + 1].isLive) nearbyBombs++;

                        // bottom
                        if (grid[r + 1, c].isLive) nearbyBombs++;

                        // bottom-left
                        if (grid[r + 1, c - 1].isLive) nearbyBombs++;

                        // left
                        if (grid[r, c - 1].isLive) nearbyBombs++;

                        // top-left
                        if (grid[r - 1, c - 1].isLive) nearbyBombs++;

                        // set liveNeighbors
                        grid[r, c].liveNeighbors = nearbyBombs;
                        continue;
                    }
                }
            }
        }

        public void leftClick(int row, int col)
        {
            // ... 
        }

        public void rightClick(int row, int col)
        {
            // ... 
        }

        public bool isGameWon()
        {
            // ...

            return false; // default 
        }

        public bool setFlag()
        {
            // local function variable
            bool valid = false;
            int row = -1, col = -1;

            // ask if user wants to flag a cell 
            Program.magenta(); 
            Console.Write("Do you want to flag a cell? (y/n): ");
            Program.reset(); 
            String setFlag = Console.ReadLine();

            Program.magenta(); 
            if (setFlag == "y")
            {
                // display what user decided to do 
                Program.green(); 
                Console.WriteLine("You chose to set a flag.\n");

                // get row input  
                do
                {
                    try
                    {
                        // display instruction to user 
                        Program.cyan();
                        Console.WriteLine("Enter the row number of the cell to flag:");
                        Program.reset(); 
                        row = int.Parse(Console.ReadLine());

                        // validate user's input 
                        while (row < 0 || row > size - 1)
                        {
                            Program.red(); Console.WriteLine($"Error! Please enter a whole number 0-{size - 1}, try again."); Program.reset();
                            Program.cyan();
                            Console.WriteLine("Enter the row number of the cell to flag:");
                            Program.reset();
                            row = int.Parse(Console.ReadLine());
                        }

                        // valid input has been entered 
                        valid = true;
                    }
                    catch // any exceptions 
                    {
                        Program.red(); Console.WriteLine($"Error! Please enter a whole number 0-{size - 1}, try again."); Program.reset();
                    }

                } while (!valid);

                // get column input 
                valid = false;
                do
                {
                    // get user input 
                    try
                    {
                        // display instruction to user 
                        Program.cyan();
                        Console.WriteLine("Enter the column number of the cell to flag:");
                        Program.reset();
                        col = int.Parse(Console.ReadLine());

                        // validate user input 
                        while (col < 0 || col > size - 1)
                        {
                            Program.red(); Console.WriteLine($"Error! Please enter a whole number 0-{size - 1}, try again."); Program.reset();
                            Program.cyan();
                            Console.WriteLine("Enter the column number of the cell to flag:");
                            Program.reset();
                            col = int.Parse(Console.ReadLine());
                        }

                        // valid input has been entered 
                        valid = true;
                    }
                    catch // any exceptions
                    {
                        Program.red(); Console.WriteLine($"Error! Please enter a whole number 0-{size - 1}, try again."); Program.reset();
                    }
                } while (!valid);

                // set the flag
                grid[row, col].hasFlag = true;
                Program.green(); 
                Console.WriteLine("Flag has been set!");
                Program.reset();
                return true; 
            }
            else
            {
                Program.red(); 
                Console.WriteLine("You chose to not set a flag.");
                Program.reset();
                return false; 
            }
        }
    }
}
