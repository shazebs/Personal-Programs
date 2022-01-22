using System;

namespace TicTacToe
{
    class Program
    {
        // Start by creating an array for tic tac toe board squares.
        static int[] board = new int[9];

        static void Main(string[] args)
        {
            // Create some intitial values for the array elements.
            for (int i=0; i < 9; i++)
            {
                board[i] = 0;
            }

            int userTurn = -1;
            int computerTurn = -1; 
            Random rand = new Random(); 

            while (checkForWinner() == 0)
            {
                // Don't allow the user to choose an already occupied square.
                while (userTurn == -1 || board[userTurn] != 0)
                {
                    Console.WriteLine("Please enter a number 0 to 8");
                    userTurn = int.Parse(Console.ReadLine());
                    Console.WriteLine("You typed " + userTurn);
                }
                board[userTurn] = 1;

                int quit = 0;
                for (int i = 0; i < board.Length; i++)
                {
                    if (board[i] != 0)
                    {
                        quit++;
                    }
                }
                if (quit == 9) break;

                // Don't allow the computer to pick an invalid number.
                while (computerTurn == -1 || board[computerTurn] != 0)
                {
                    computerTurn = rand.Next(8);
                    Console.WriteLine("Computer chooses " + computerTurn);
                }

                board[computerTurn] = 2;
                printBoard(); 
            }
            if (checkForWinner() == 0)
            {
                Console.WriteLine("The game ends in a tie.");
            }
            else 
                Console.WriteLine("Player " + checkForWinner() + " won the game.");
        }

        // Functions. 
        private static int checkForWinner()
        {
            // return a 0 if nobody won. Return the player number if they won.

            // top row.
            if (board[0] == board[1] && board[1] == board[2])
            {
                return board[0]; 
            }

            // second row.
            if (board[3] == board[4] && board[4] == board[5])
            {
                return board[3]; 
            }

            // third row.
            if (board[6] == board[7] && board[7] == board[8])
            {
                return board[6]; 
            }

            // first column.
            if (board[0] == board[3] && board[3] == board[6])
            {
                return board[0];
            }

            // second column.
            if (board[1] == board[4] && board[4] == board[7])
            {
                return board[1];
            }

            // third column. 
            if (board[2] == board[5] && board[5] == board[8])
            {
                return board[2];
            }

            // first diagonal. 
            if (board[0] == board[4] && board[4] == board[8])
            {
                return board[0];
            }

            // second diagonal. 
            if (board[6] == board[4] && board[4] == board[2])
            {
                return board[6];
            }

            return 0; 
        }
        private static void printBoard()
        {
            // Print array values via for loop. 
            for (int i = 0; i < 9; i++)
            {
                /*Console.WriteLine("Square " + i + " contains " + board[i]);*/
                if (board[i] == 0)
                {
                    Console.Write(".");
                }
                if (board[i] == 1)
                {
                    Console.Write("X");
                }
                if (board[i] == 2)
                {
                    Console.Write("O");
                }

                // Print a newline every 3rd character.
                if (i == 2 || i == 5 || i == 8)
                {
                    Console.WriteLine();
                }
            }
        }
    }
}
