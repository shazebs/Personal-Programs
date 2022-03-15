using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Minesweeper_GUI
{
    public class Board
    {
        // Properties 

        /* required */
        public Cell[,] grid { get; set; }
        public float difficulty { get; set; }
        public int size { get; set; }
        public int totalClicks { get; set; }
        public int startTime { get; set; }
        public int score { get; set;}

        /* included */
        public int totalBombs { get; set; }
        public int hiddenBombs { get; set; }



        // Constructors 

        /* default */
        public Board()
        {
            this.totalClicks = 0;
            this.score = 0;
            this.size = 0;
        }

        /* sized-constructor */ 
        public Board(int size)
        {
            // size the grid. 
            this.grid = new Cell[size, size];
            this.score = 0;
            this.size = size;
            this.totalClicks = 0;

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

        /* place bombs randomly on the grid */
        public void placeBombs(int diff) 
        {
            /* properties */ 
            Random rand = new Random();
            size = diff; 

            /* the algorithm for bomb placements */ 
            if (size == 12) totalBombs =  rand.Next(5, 10);
            if (size == 19) totalBombs = size * 2;
            if (size == 27) totalBombs = size * 2 + rand.Next(20, 50);


            /* loop and place bombs randomly throughout cells array */ 
            int count = 0;
            while (count != totalBombs)
            {
                /* select random coordinates on the grid */
                int x = rand.Next(size);
                int y = rand.Next(size);

                /* place a bomb if appropriate to do so */ 
                if (this.grid[x, y].isLive == false)
                {
                    this.grid[x, y].isLive = true;
                    count++; 
                }
            }
            /* print bomb locations through the console */ 
            for (var x=0; x < size; x++)
            {
                Console.Write("\t"); /* tab in front of row */ 
                for (var y = 0; y < size; y++) {
                    if (this.grid[x, y].isLive == false) Console.Write("~ ");
                    else if (this.grid[x, y].isLive) Console.Write("x "); 
                }
                Console.Write("\n"); 
            }
        }



        /* calculate live bomb neighbors */
        public void calculateLiveNeighbors()
        {
            // loop through rows
            for (int r = 0; r < this.size; r++)
            {
                // loop through columns
                for (int c = 0; c < this.size; c++)
                {
                    // Professor Sluiter's Code
                    // nw 
                    if (r-1 >0 && c-1 > 0 && grid[r - 1, c - 1].isLive) grid[r,c].liveNeighbors++;
                    // ne 
                    if (r - 1 > 0 && c + 1 < size && grid[r - 1, c + 1].isLive) grid[r, c].liveNeighbors++;
                    // w
                    if ( c -1  > 0 && grid[r, c - 1].isLive) grid[r, c].liveNeighbors++;
                    


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



        /* right click to set a flag */
        public void rightClick(int row, int col)
        {
            this.grid[row, col].hasFlag = true; /* set a flag */  
        }



        /* left click to place a bomb */
        public bool leftClick(int row, int col)
        {
            // if user hits a bomb, game over 
            if (this.grid[row, col].isLive == true)
            {
                grid[row, col].isVisited = true;
                return true; 
            }
            // if user hits an empty cell 
            else if (grid[row, col].liveNeighbors == 0)
            {
                floodFill(grid, row, col);
            }
            // if user hits a safe cell 
            else
            {
                // bomb not hit but cell has now been visited 
                this.grid[row, col].isVisited = true;
            }        
            return false; // default 
        }



        /* determine if the game has been won */
        public bool isGameWon() 
        {
            /* CHECK TO SEE IF USER HAS WON */
            // local variables 
            int totalSweep = 0;
            int totalCorrect = 0;

            // loop through grid and calculate number of safe cells visited
            for (var i = 0; i < size; i++)
            {
                for (var j = 0; j < size; j++)
                {
                    if (grid[i, j].liveNeighbors > 0 && grid[i, j].liveNeighbors < 9)
                    {
                        totalSweep++;
                    }
                    if (grid[i, j].liveNeighbors > 0 && grid[i, j].liveNeighbors < 9 && grid[i, j].isVisited)
                    {
                        totalCorrect++;
                    }
                    /* adjust score */ 
                    if (grid[i,j].isVisited && grid[i,j].isLive == false && grid[i, j].liveNeighbors > 0 && grid[i, j].liveNeighbors < 9)
                    {
                        score += grid[i, j].liveNeighbors;
                    }
                }
            }
            // check if user has won  
            if (totalSweep == totalCorrect)
            {
                return true;
            }

            return false; 
        }



        /* run this if the game has been lost */
        public bool isGameLost() { return false; }



        /* flood fill recrsion to reveal empty spaces */ 
        public void floodFill(Cell[,] grid, int row, int col)
        {
            // check to see if cell has already been visited 
            if (grid[row, col].isVisited == true)
            {
                return;
            }
            else // cell has not yet been visited 
            {
                // mark cell as visited
                grid[row, col].isVisited = true;
                
                // if cell has 0 live neighbors , flood fill if possible 
                if (grid[row, col].liveNeighbors == 0)
                {
                    // go south 
                    if (row + 1 < size &&grid[row + 1, col].isVisited == false)
                    {
                        floodFill(grid, row + 1, col);
                    }
                    // go north 
                    if (row - 1 >= 0 && grid[row - 1, col].isVisited == false)
                    {
                        floodFill(grid, row - 1, col);
                    }
                    // go east 
                    if (col + 1 < size && grid[row, col + 1].isVisited == false)
                    {
                        floodFill(grid, row, col + 1);
                    }
                    // go west 
                    if (col - 1 >= 0 && grid[row, col - 1].isVisited == false)
                    {
                        floodFill(grid, row, col - 1);
                    }
                    // go NE
                    if (row - 1 >= 0 && col + 1 < size && grid[row - 1, col + 1].isVisited == false)
                    {
                        floodFill(grid, row - 1, col + 1);
                    }
                    // go NW
                    if (row - 1 >= 0 && col - 1 >= 0 && grid[row - 1, col - 1].isVisited == false)
                    {
                        floodFill(grid, row - 1, col - 1);
                    }
                    // go SE
                    if (row + 1 < size && col + 1 < size && grid[row + 1, col + 1].isVisited == false)
                    {
                        floodFill(grid, row + 1, col + 1);
                    }
                    // go SW
                    if (row + 1 < size && col - 1 >= 0 && grid[row + 1, col - 1].isVisited == false)
                    {
                        floodFill(grid, row + 1, col - 1);
                    }
                }
                else // no flood fill was possible 
                    return;
            }
        }
        
    }
}
