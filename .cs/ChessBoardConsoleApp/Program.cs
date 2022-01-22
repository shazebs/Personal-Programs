using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
// using ChessBoardModel2;

namespace ChessBoardConsoleApp
{
	class Program
	{
		static Board myBoard = new Board(8);

		static void Main(string[] args)
		{
			// show the empty chess board
			printBoard(myBoard);

			// ask the user for an x andy coordinate where we will place a piece

			// calculate all legal moves for that piece

			// print the chess board. Use an x for occupied square. Use a + for legal move. Use . for empty cell.

			// wait for another enter key press before ending the program.
			Console.ReadLine(); 
		}

		private static void printBoard(Board myBoard)
		{
			// print the chess board to the console. Use X for the piece location. + 
			for (int i = 0; i < myBoard.Size; i++)
			{
				for (int j = 0; j < myBoard.Size; j++)
				{
					Cell c = myBoard.theGrid[i, j];

					if (c.CurrentlyOccupied == true)
						Console.Write("X");
					else if (c.LegalNextMove == true)
						Console.Write("+");
					else
						Console.Write(".");
				}

				Console.WriteLine();
			}

			Console.WriteLine("================================================");
		}
	}
}
