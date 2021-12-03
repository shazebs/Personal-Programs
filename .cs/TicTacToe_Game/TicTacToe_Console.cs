using BoardLogic; // using a different class. 
using System;

namespace TicTacToe
{
    class Program
    {
        // Start by creating an array for tic tac toe board squares.
        static Board game = new Board(); 

        static void Main(string[] args)
        {
            int userTurn = -1;
            int computerTurn = -1;
            Random rand = new Random();

            while (game.checkForWinner() == 0)
            {
                // Don't allow the user to choose an already occupied square.
                while (userTurn == -1 || game.Grid[userTurn] != 0)
                {
                    Console.WriteLine("Please enter a number 0 to 8");
                    userTurn = int.Parse(Console.ReadLine());
                    Console.WriteLine("You typed " + userTurn);
                }
                game.Grid[userTurn] = 1;

                if (game.isBoardFull()) break; // break out of game.

                // My Exit game code.
                /*int quit = 0;
                for (int i = 0; i < game.Grid.Length; i++)
                {
                    if (game.Grid[i] != 0)
                    {
                        quit++;
                    }
                }
                if (quit == 9) break;*/


                // Don't allow the computer to pick an invalid number.
                while (computerTurn == -1 || game.Grid[computerTurn] != 0)
                {
                    computerTurn = rand.Next(8);
                    Console.WriteLine("Computer chooses " + computerTurn);
                }

                if (game.isBoardFull()) break; // break out of game.

                game.Grid[computerTurn] = 2;
                printBoard();
            }

            /*if (game.checkForWinner() == 0)
            {
                Console.WriteLine("The game ends in a tie.");
            }*/

            Console.WriteLine("Player " + game.checkForWinner() + " won the game.");
            Console.ReadLine(); 
        }

        // Functions. 
        
        private static void printBoard()
        {
            // Print array values via for loop. 
            for (int i = 0; i < 9; i++)
            {
                /*Console.WriteLine("Square " + i + " contains " + board[i]);*/
                if (game.Grid[i] == 0)
                {
                    Console.Write(".");
                }
                if (game.Grid[i] == 1)
                {
                    Console.Write("X");
                }
                if (game.Grid[i] == 2)
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
