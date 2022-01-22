using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ChessBoardClasses;

namespace ChessBoard
{
	class Program
	{
		// global properties 
		static Board myBoard = new Board(8);

		// main method 
		static void Main(string[] args)
		{
			// show the empty chess board
			printBoard(myBoard);

			// ask the user for an x andy coordinate where we will place a piece
			Cell currentCell = setCurrentCell();
			currentCell.CurrentlyOccupied = true;

			// calculate all legal moves for that piece

			// print the chess board. Use an x for occupied square. Use a + for legal move. Use . for empty cell.
			printBoard(myBoard);

			// wait for another enter key press before ending the program.
			Console.Write("\nExit Game ");
			Console.ReadLine();
		}

		// functions 

		// set current cell function 
		private static Cell setCurrentCell()
		{
			// get x and y coordinates from the user. return a cell location.
			Console.WriteLine("Enter the current row number");
			int currentRow = int.Parse(Console.ReadLine());
			Console.WriteLine("Enter the current row number");
			int currentCol = int.Parse(Console.ReadLine());

			return myBoard.theGrid[currentRow, currentCol];
		}



		// print boad (function) 
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

				Console.WriteLine(); // newline after row end
			}

			Console.WriteLine("================================================");
		}


	}
}
