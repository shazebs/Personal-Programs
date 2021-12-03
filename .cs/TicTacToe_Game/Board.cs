using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BoardLogic
{
    public class Board
    {
        public  int[] Grid { get; set; }
        public Board()
        {
            Grid = new int[9];
            // initialize the Grid. 
            // Create some intitial values for the array elements.
            for (int i = 0; i < 9; i++)
            {
                Grid[i] = 0;
            }
        }

        public bool isBoardFull()
        {
            bool isFull = true;
            // assume the board is full. if an exception is found, change the 
            for (int i = 0; i < Grid.Length; i++)
            {
                if (Grid[i] == 0)
                {
                    isFull = false;
                }
            }
            return isFull;
        }

        public int checkForWinner()
        {
            // return a 0 if nobody won. Return the player number if they won.

            // top row.
            if (Grid[0] == Grid[1] && Grid[1] == Grid[2])
            {
                return Grid[0];
            }

            // second row.
            if (Grid[3] == Grid[4] && Grid[4] == Grid[5])
            {
                return Grid[3];
            }

            // third row.
            if (Grid[6] == Grid[7] && Grid[7] == Grid[8])
            {
                return Grid[6];
            }

            // first column.
            if (Grid[0] == Grid[3] && Grid[3] == Grid[6])
            {
                return Grid[0];
            }

            // second column.
            if (Grid[1] == Grid[4] && Grid[4] == Grid[7])
            {
                return Grid[1];
            }

            // third column. 
            if (Grid[2] == Grid[5] && Grid[5] == Grid[8])
            {
                return Grid[2];
            }

            // first diagonal. 
            if (Grid[0] == Grid[4] && Grid[4] == Grid[8])
            {
                return Grid[0];
            }

            // second diagonal. 
            if (Grid[6] == Grid[4] && Grid[4] == Grid[2])
            {
                return Grid[6];
            }

            return 0;
        }
    }
}
