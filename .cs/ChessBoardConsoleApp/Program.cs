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
			upgradedPrintBoard(myBoard);

			bool tryagain = true;
			do
			{
				// ask the user for an x andy coordinate where we will place a piece
				Cell currentCell = setCurrentCell(); // function call 
				currentCell.CurrentlyOccupied = true;

				// menu for chess piece selection
				string currentPiece = selectPiece();

				// calculate all legal moves for that piece
				myBoard.MarkNextLegalMoves(currentCell, currentPiece);

				// print the chess board. Use an x for occupied square. Use a + for legal move. Use . for empty cell.
				upgradedPrintBoard(myBoard);

			} while (tryagain); 
			

			// wait for another enter key press before ending the program.
			Console.Write("Exit Game ");
			Console.ReadLine();
		}


        // functions 

		// select the chess piece we are working with 
        private static string selectPiece()
        {
			// local function variable 
			String piece = "";

			// display instruction to user 
			cyan(); Console.Write("Enter the name of the name of the piece you want to select ");
			yellow(); Console.WriteLine("\n--- Knight, Rook, Bishop, King, or Queen ---"); reset();

			// get input from user 
			piece = Console.ReadLine();

			// make sure user didn't enter an empty string. 
			while (piece.Trim() == "")
            {
				red(); Console.WriteLine("Error! Input cannot be left blank, try again.");
				cyan(); Console.Write("Enter the name of the name of the piece you want to select ");
				yellow(); Console.WriteLine("\n--- Knight, Rook, Bishop, King, or Queen ---"); reset();
				// get input from user 
				piece = Console.ReadLine();
			}

			return piece; 
        }


        // set current cell function 
        private static Cell setCurrentCell()
		{
			// local function variables 
			int currentRow = 0, currentCol = 0;
			bool repeat = true; 

			// get row number from user 
			while (repeat)
            {
				try
				{
					// get user input 
					cyan();
					Console.WriteLine("Enter the current row number:"); green();
					currentRow = int.Parse(Console.ReadLine());
					reset(); 

					// input validate row value 
					while (currentRow < 1 || currentRow > 8)
					{
						red(); Console.WriteLine("Error! Enter a whole number between 1-8 only, try again!");
						cyan();
						Console.WriteLine("Enter the current row number:"); green();
						currentRow = int.Parse(Console.ReadLine());
					}
					repeat = false; // exit loop 
				}
				catch // any error that may occur 
				{
					// print error message 
					red(); Console.WriteLine("You didn't enter a whole number between 1-8, try again."); reset();
				}
				reset(); 
			}

			// get column number from user 
			repeat = true; 
			while (repeat)
            {
				try
				{
					// display instruction
					cyan(); Console.WriteLine("Enter the current column number:"); reset();
					// read-in user input 
					green(); 
					currentCol = int.Parse(Console.ReadLine()); reset(); 

					// input validate column value 
					while (currentCol < 1 || currentCol > 8)
					{
						red(); Console.WriteLine("Error! Enter a whole number between 1-8 only, try again!");
						cyan();
						Console.WriteLine("Enter the current column number:"); green();
						currentCol = int.Parse(Console.ReadLine());
					}

					repeat = false; // exit loop 
				}
				catch
				{
					// print error message 
					red(); Console.WriteLine("You didn't enter a whole number between 1-8, try again."); reset();
				}
				reset();  
			}
			
			// return currentCell back to main() 
			return myBoard.theGrid[currentRow-1, currentCol-1];
		}


		// print boad (function) -- (replaced by upgraded version) --
		/*private static void printBoard(Board myBoard)
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
		}*/


		// print board (upgraded function) 
		private static void upgradedPrintBoard(Board myBoard)
		{
			newline(); // drop the board a line down. 


			bool top = true; 
			// row loop 
			for (int i = 0; i < myBoard.Size; i++)
			{
				// column loop 
				for (int j = 0; j < myBoard.Size; j++)
				{

					// create top of board
					if (top) 
					{
						if (i == 0 && j == 0)
						{
							Console.Write("   "); // beginning padding 

							// Write column number on top of board 
							for (int k = 0; k < myBoard.Size; k++) {
								green(); 
								Console.Write($"  {k+1} "); 
								reset(); 
							}
							Console.WriteLine("\n   +---+---+---+---+---+---+---+---+");
						}
						top = false; 
					}


					// Write row number on left side of board  
					if (j == 0)
					{
						green();
						Console.Write($" {i + 1} "); reset(); 
						Console.Write("|");
					}

					// select the Cell in the 2d grid
					Cell selected = myBoard.theGrid[i, j];

						// display selected piece on board in green 
						if (selected.CurrentlyOccupied == true)
						{
							green();
							Console.Write(" X "); reset(); 
							Console.Write("|");
						}
						// display legal next move in red 
						else if (selected.LegalNextMove == true)
						{
							red();
							Console.Write(" + "); reset(); 
							Console.Write("|");  
						}
						// leave blank if all else fails 
						else 
							Console.Write("   |");


					// close board via right side row ending
					if (j == myBoard.Size -1) {
						Console.Write("\n   +---+---+---+---+---+---+---+---+"); 
                    }

				}
				newline(); // new line after every row 
			}
			newline(); // new line after board ends 
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
