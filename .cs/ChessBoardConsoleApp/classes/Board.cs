using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChessBoard
{
	public class Board
	{
		// the size of the board usually 8x8
		public int Size { get; set; }

		// 2d array of type cell
		public Cell[,] theGrid { get; set; }

		// constructor
		public Board(int s)
		{
			// initial size of the board is defined by s.
			Size = s;

			// create a new 2d array of type Cell
			theGrid = new Cell[Size, Size];

			// fill 2d array index with new Cells
			for (int i = 0; i < Size; i++)
			{
				for (int j = 0; j < Size; j++)
					theGrid[i, j] = new Cell(i, j);
			}
		}


		// methods

		// mark next legal moves function 
		public void MarkNextLegalMoves(Cell currentCell, string chessPiece)
		{
			// step 1 - clear all previous moves
			for (int i = 0; i < Size; i++)
			{
				for (int j = 0; j < Size; j++)
				{
					theGrid[i, j].LegalNextMove = false;
					theGrid[i, j].CurrentlyOccupied = false;
				}
			}

			// step 2 - find all legal moves and mark the cells as "legal"
			switch ( chessPiece.Trim() )
			{
				case "knight":
				case "Knight":
					knightPiece(currentCell, theGrid, Size); 
					break;

				case "king":
				case "King":
					kingPiece(currentCell, theGrid, Size);
					break;

				case "rook":
				case "Rook":
					rookPiece(currentCell, theGrid, Size);
					break;

				case "bishop":
				case "Bishop":
					bishopPiece(currentCell, theGrid, Size);
					break;

				case "queen":
				case "Queen":
					queenPiece(currentCell, theGrid, Size); 
					break;

				default:
					Console.ForegroundColor = ConsoleColor.Red;
					Console.WriteLine("\nError! You entered something unrecognizable by the current system software, try again.");
					Console.ResetColor();
					break;
			}
			// mark piece grid location 
			theGrid[currentCell.RowNumber, currentCell.ColumnNumber].CurrentlyOccupied = true;
		}


		// Chess Pieces functions 

		public static void kingPiece(Cell currentCell, Cell[,] theGrid, int Size)
		{
			// if ( cell is an in-between piece ) { ... } 
			// ------------------------------------------
			// in-between a 2d array (index-bounds scan)    
			if ((currentCell.RowNumber > 0 && currentCell.RowNumber < Size - 1) &&
					(currentCell.ColumnNumber > 0 && currentCell.ColumnNumber < Size - 1))
			{
				// top 
				theGrid[currentCell.RowNumber - 1, currentCell.ColumnNumber].LegalNextMove = true;

				// top-right
				theGrid[currentCell.RowNumber - 1, currentCell.ColumnNumber + 1].LegalNextMove = true;

				// right 
				theGrid[currentCell.RowNumber, currentCell.ColumnNumber + 1].LegalNextMove = true;

				// bottom-right
				theGrid[currentCell.RowNumber + 1, currentCell.ColumnNumber + 1].LegalNextMove = true;

				// bottom
				theGrid[currentCell.RowNumber + 1, currentCell.ColumnNumber].LegalNextMove = true;

				// bottom-left
				theGrid[currentCell.RowNumber + 1, currentCell.ColumnNumber - 1].LegalNextMove = true;

				// left
				theGrid[currentCell.RowNumber, currentCell.ColumnNumber - 1].LegalNextMove = true;

				// top-left
				theGrid[currentCell.RowNumber - 1, currentCell.ColumnNumber - 1].LegalNextMove = true;
				return;
			}


			// if ( cell is a corner piece ) { ... }
			// ----------------------------------------
			// top-left corner Cell 
			if (currentCell.RowNumber == 0 && currentCell.ColumnNumber == 0)
			{
				// right 
				theGrid[currentCell.RowNumber, currentCell.ColumnNumber + 1].LegalNextMove = true;

				// bottom-right
				theGrid[currentCell.RowNumber + 1, currentCell.ColumnNumber + 1].LegalNextMove = true;

				// bottom
				theGrid[currentCell.RowNumber + 1, currentCell.ColumnNumber].LegalNextMove = true;
				return;
			}
			// top-right corner Cell
			else if (currentCell.RowNumber == 0 && currentCell.ColumnNumber == Size - 1)
			{
				// left
				theGrid[currentCell.RowNumber, currentCell.ColumnNumber - 1].LegalNextMove = true;

				// bottom-left
				theGrid[currentCell.RowNumber + 1, currentCell.ColumnNumber - 1].LegalNextMove = true;

				// bottom
				theGrid[currentCell.RowNumber + 1, currentCell.ColumnNumber].LegalNextMove = true;
				return;
			}
			// bottom-right corner Cell
			else if (currentCell.RowNumber == Size - 1 && currentCell.ColumnNumber == Size - 1)
			{
				// top 
				theGrid[currentCell.RowNumber - 1, currentCell.ColumnNumber].LegalNextMove = true;

				// top-left
				theGrid[currentCell.RowNumber - 1, currentCell.ColumnNumber - 1].LegalNextMove = true;

				// left
				theGrid[currentCell.RowNumber, currentCell.ColumnNumber - 1].LegalNextMove = true;
				return;
			}
			// bottom-left corner Cell
			else if (currentCell.RowNumber == Size - 1 && currentCell.ColumnNumber == 0)
			{
				// top 
				theGrid[currentCell.RowNumber - 1, currentCell.ColumnNumber].LegalNextMove = true;

				// top-right
				theGrid[currentCell.RowNumber - 1, currentCell.ColumnNumber + 1].LegalNextMove = true;

				// right
				theGrid[currentCell.RowNumber, currentCell.ColumnNumber + 1].LegalNextMove = true;
				return;
			}



			// if ( cell is a sides piece ) { ... }
			// -------------------------------------
			// top side Cells
			if (currentCell.RowNumber == 0 && (currentCell.ColumnNumber != 0 && currentCell.ColumnNumber != Size - 1))
			{
				// right 
				theGrid[currentCell.RowNumber, currentCell.ColumnNumber + 1].LegalNextMove = true;

				// bottom-right
				theGrid[currentCell.RowNumber + 1, currentCell.ColumnNumber + 1].LegalNextMove = true;

				// bottom
				theGrid[currentCell.RowNumber + 1, currentCell.ColumnNumber].LegalNextMove = true;

				// bottom-left 
				theGrid[currentCell.RowNumber + 1, currentCell.ColumnNumber - 1].LegalNextMove = true;

				// left
				theGrid[currentCell.RowNumber, currentCell.ColumnNumber - 1].LegalNextMove = true;
			}
			// right side Cells
			else if (currentCell.ColumnNumber == Size - 1 && (currentCell.RowNumber != 0 && currentCell.RowNumber != Size - 1))
			{
				// top
				theGrid[currentCell.RowNumber - 1, currentCell.ColumnNumber].LegalNextMove = true;

				// top-left
				theGrid[currentCell.RowNumber - 1, currentCell.ColumnNumber - 1].LegalNextMove = true;

				// left
				theGrid[currentCell.RowNumber, currentCell.ColumnNumber - 1].LegalNextMove = true;

				// bottom-left
				theGrid[currentCell.RowNumber + 1, currentCell.ColumnNumber - 1].LegalNextMove = true;

				// bottom
				theGrid[currentCell.RowNumber + 1, currentCell.ColumnNumber].LegalNextMove = true;
			}
			// bottom side Cells
			else if (currentCell.RowNumber == Size - 1 && (currentCell.ColumnNumber != 0 && currentCell.ColumnNumber != Size - 1))
			{
				// top 
				theGrid[currentCell.RowNumber - 1, currentCell.ColumnNumber].LegalNextMove = true;

				// top-left
				theGrid[currentCell.RowNumber - 1, currentCell.ColumnNumber - 1].LegalNextMove = true;

				// left
				theGrid[currentCell.RowNumber, currentCell.ColumnNumber - 1].LegalNextMove = true;

				// top-right
				theGrid[currentCell.RowNumber - 1, currentCell.ColumnNumber + 1].LegalNextMove = true;

				// right 
				theGrid[currentCell.RowNumber, currentCell.ColumnNumber + 1].LegalNextMove = true;
			}
			// left side Cells
			else if (currentCell.ColumnNumber == 0)
			{
				// top 
				theGrid[currentCell.RowNumber - 1, currentCell.ColumnNumber].LegalNextMove = true;

				// top-right
				theGrid[currentCell.RowNumber - 1, currentCell.ColumnNumber + 1].LegalNextMove = true;

				// right
				theGrid[currentCell.RowNumber, currentCell.ColumnNumber + 1].LegalNextMove = true;

				// bottom-right
				theGrid[currentCell.RowNumber + 1, currentCell.ColumnNumber + 1].LegalNextMove = true;

				// bottom 
				theGrid[currentCell.RowNumber + 1, currentCell.ColumnNumber].LegalNextMove = true;
			}
		}
		public static void bishopPiece(Cell currentCell, Cell[,] theGrid, int Size)
		{
			// local function variables 
			int r = currentCell.RowNumber, c = currentCell.ColumnNumber;
			bool goTopRight = false, goBottomRight = false, goBottomLeft = false, goTopLeft = false;

			// ( corner Cell pieces only )
			// top-left corner Cell
			if (r == 0 && c == 0)
			{
				goBottomRight = true;
			}
				// top-right corner Cell
				else if (r == 0 && c == Size - 1)
				{
					goBottomLeft = true;
				}
					// bottom-right corner Cell
					else if (r == Size - 1 && c == Size - 1)
					{
						goTopLeft = true;
					}
						// Bottom-left corner Cell
						else if (r == Size - 1 && c == 0)
						{
							goTopRight = true;
						}

			// ( sides Cell pieces only -- while avoiding corners -- ) 
			// top side
			if (r == 0 && (c != 0 && c != Size - 1))
			{
				goBottomLeft = true;
				goBottomRight = true;
			}
				// right side
				else if (c == Size - 1 && (r != 0 && r != Size - 1))
				{
					goTopLeft = true;
					goBottomLeft = true;
				}
					// bottom side
					else if (r == Size - 1 && (c != 0 && c != Size - 1))
					{
						goTopRight = true;
						goTopLeft = true;
					}
						// left side 
						else if (c == 0 && (r != 0 && r != Size - 1))
						{
							goTopRight = true;
							goBottomRight = true;
						}

			// ( go diagonal in all directions ) 
			if ((r > 0 && r < Size - 1) && (c > 0 && c < Size - 1))
			{
				goTopRight = true;
				goBottomRight = true;
				goBottomLeft = true;
				goTopLeft = true;
			}

			// mark the next legal moves
			int spacesRight = 0, spacesLeft = 0; 

			// upward diagonals 
			if (goTopRight || goTopLeft)
			{
				// loop upward rows
				for (int i = r; i > 0; i--)
				{
					// mark top right
					if (goTopRight && c + spacesRight < Size-1) {
						theGrid[i - 1, c + ++spacesRight].LegalNextMove = true;
					}
					// mark top left 
					if (goTopLeft && c - spacesLeft > 0) {
						theGrid[i - 1, c - ++spacesLeft].LegalNextMove = true;
					}
				}
			}

			// downward diagonals
			spacesRight = 0;
			spacesLeft = 0; 
			if ( goBottomRight || goBottomLeft )
            {
				// loop downward rows
				for (int i = r; i < Size-1; i++)
                {
					// mark bottom right
					if (goBottomRight && c + spacesRight < Size-1)
					{
						theGrid[i + 1, c + ++spacesRight].LegalNextMove = true;
					}
					// mark bottom left 
					if (goBottomLeft && c - spacesLeft > 0)
					{
						theGrid[i + 1, c - ++spacesLeft].LegalNextMove = true;
					}
				}
            }
		}
		public static void rookPiece(Cell currentCell, Cell[,] theGrid, int Size) 
		{
			// local function variables
			int r = currentCell.RowNumber, c = currentCell.ColumnNumber;
			bool goTop = false, goRight = false, goBottom = false, goLeft = false; 


			// ( corner Cell pieces only )
			// top-left corner Cell
			if ( r==0 && c==0 )
            {
				goRight = true;
				goBottom = true; 
            }
				// top-right corner Cell
				else if ( r==0 && c==Size-1)
				{
					goLeft = true;
					goBottom = true; 
				}
					// bottom-right corner Cell
					else if ( r== Size-1 && c== Size-1 )
					{
						goTop = true;
						goLeft = true; 
					}
						// Bottom-left corner Cell
						else if ( r==Size-1 && c==0 )
						{
							goTop = true;
							goRight = true; 
						}


			// ( sides Cell pieces only -- while avoiding corners -- ) 
			// top side
			if ( r == 0 && (c != 0 && c != Size-1) )
            {
				goRight = true;
				goBottom = true;
				goLeft = true; 
            }
				// right side
				else if ( c == Size-1 && ( r != 0 && r != Size-1) )
				{

				}
					// bottom side
					else if ( r == Size-1 && ( c != 0 && c != Size-1) )
					{
						goTop = true;
						goRight = true;
						goLeft = true; 
					}
						// left side 
						else if ( c == 0 && ( r != 0 && r != Size-1) )
						{
							goRight = true;
							goTop = true;
							goBottom = true; 
						}


			// ( Cell pieces in-between only )
			// all around 
			if ( ( r > 0 && r < Size-1 ) && ( c > 0 && c < Size-1) )
            {
				goTop = true;
				goRight = true;
				goBottom = true;
				goLeft = true; 
            }


			// mark the next legal moves
			if (goTop)
            {
				// loop up rows marking legal moves
				for (int i = r; i > 0; i--) {
					theGrid[i - 1, c].LegalNextMove = true; 
                }
            }
			if (goRight)
            {
				// loop forwards through columns marking legal moves
				for (int i = c; i < Size-1; i++) {
					theGrid[r, i + 1].LegalNextMove = true; 
                }
            }
			if (goBottom)
            {
				for (int i = r; i < Size-1; i++) {
					theGrid[i + 1, c].LegalNextMove = true; 
                }
            }
			if (goLeft)
            {
				for (int i = c; i > 0; i--) {
					theGrid[r, i - 1].LegalNextMove = true;
				}
			}


			// (rook) possible recursion forumula 
			// -----------------------------------
			// while (r-1 >= 0) 
			//		loop up the row
			// while (r+1 <= Size - 1)
			//		loop down the row
			// while (c+1 <= Size-1
			//		loop forward across columns
			// while (c-1 >= 0)
			//		loop backwards across columns

		}
		public static void knightPiece(Cell currentCell, Cell[,] theGrid, int Size) 
		{
			// local function variables 
			int r = currentCell.RowNumber, c = currentCell.ColumnNumber; 

			// ( for corner cells only ) 
			// -------------------------------
			// top-left corner 
			if (r == 0 && c == 0)
			{
				// mark right-bottom
				theGrid[r + 1, c + 2].LegalNextMove = true;

				// mark bottom-right 
				theGrid[r + 2, c + 1].LegalNextMove = true; 
            }
			// top-right corner 
			else if ( r == 0 && c == Size-1 )
            {
				// mark left-bottom
				theGrid[r + 1, c - 2].LegalNextMove = true;

				// mark bottom-left
				theGrid[r + 2, c - 1].LegalNextMove = true; 
            }
			// bottom-right corner 
			else if ( r == Size-1 && c == Size-1 )
            {
				// mark top-left
				theGrid[r - 2, c - 1].LegalNextMove = true;

				// mark left-top 
				theGrid[r - 1, c - 2].LegalNextMove = true;
            }
			// bottom-left corner 
			else if ( r == Size-1 && c == 0 )
            {
				// mark top-right
				theGrid[r - 2, c + 1].LegalNextMove = true;

				// mark right-top 
				theGrid[r - 1, c + 2].LegalNextMove = true; 
            }


			// ( for sides only ) 
			// --------------------------
			// top side
			if (r == 0 && (c != 0 && c != Size - 1))
			{
				// mark right-bottom
				if ( !(c + 2 > Size-1) )
					theGrid[r + 1, c + 2].LegalNextMove = true;

				// mark bottom-right
				theGrid[r + 2, c + 1].LegalNextMove = true;

				// mark bottom-left
				theGrid[r + 2, c - 1].LegalNextMove = true;

				// mark left-bottom
				if ( !(c - 2 < 0) )
					theGrid[r + 1, c - 2].LegalNextMove = true;
			}
			// right side 
			else if (c == Size-1 && (r != 0 && r != Size - 1))
			{
				// mark top-left
				if ( !(r - 2 < 0) )
					theGrid[r - 2, c - 1].LegalNextMove = true;

				// mark left-top
				theGrid[r - 1, c - 2].LegalNextMove = true;

				// mark bottom-left
				if (!(r + 2 > Size - 1))
					theGrid[r + 2, c - 1].LegalNextMove = true;

				// mark left-bottom
				theGrid[r + 1, c - 2].LegalNextMove = true; 
			}
			// bottom side
			else if ( r == Size-1 && (c != 0 && c != Size-1) )
            {
				// mark top-right 
				theGrid[r - 2, c + 1].LegalNextMove = true;

				// mark top-left
				theGrid[r - 2, c - 1].LegalNextMove = true;

				// mark right-top
				if ( !(c + 2 > Size-1) )
					theGrid[r - 1, c + 2].LegalNextMove = true;

				// mark left-top
				if ( !(c - 2 < 0) )
					theGrid[r - 1, c - 2].LegalNextMove = true; 

            }
			// left side 
			else if ( c == 0 && (r != 0 && r != Size-1) ) 
            {
				// mark right-top
				theGrid[r - 1, c + 2].LegalNextMove = true;

				// mark right-bottom
				theGrid[r + 1, c + 2].LegalNextMove = true;

				// mark top-right
				if ( !(r - 2 < 0) )
					theGrid[r - 2, c + 1].LegalNextMove = true;

				// mark bottom-right
				if ( !(r + 2 > Size-1) )
					theGrid[r + 2, c + 1].LegalNextMove = true; 
            }


			// ( for in-between cells only )
			// ----------------------------------
			if ( (r > 0 && r < Size-1) && (c > 0 && c < Size-1) )
            {
				// mark top-right
				if ( !(r - 2 < 0) )
					theGrid[r - 2, c + 1].LegalNextMove = true;

				// mark top-left
				if (!(r - 2 < 0))
					theGrid[r - 2, c - 1].LegalNextMove = true;

				// mark right-top
				if (!(c + 2 > Size - 1))
					theGrid[r - 1, c + 2].LegalNextMove = true;

				// mark right-bottom
				if (!(c + 2 > Size - 1))
					theGrid[r + 1, c + 2].LegalNextMove = true;

				// mark bottom-right
				if (!(r + 2 > Size - 1))
					theGrid[r + 2, c + 1].LegalNextMove = true;

				// mark bottom-left
				if (!(r + 2 > Size - 1))
					theGrid[r + 2, c - 1].LegalNextMove = true;

				// mark left-top
				if (!(c - 2 < 0))
					theGrid[r - 1, c - 2].LegalNextMove = true;

				// mark left-bottom
				if (!(c - 2 < 0))
					theGrid[r + 1, c - 2].LegalNextMove = true;
            }
		}
		public static void queenPiece(Cell currentCell, Cell[,] theGrid, int Size)
		{
			// local function variables 
			int r = currentCell.RowNumber, c = currentCell.ColumnNumber;
			bool goTop = false, goRight = false, goBottom = false, goLeft = false,
					goTopRight = false, goBottomRight = false, goBottomLeft = false, goTopLeft = false; 


			// ( corner pieces only ) 
			// -------------------------------
			// top-left corner
			if ( r == 0 && c == 0 )
            {
				// mark rights
				for (int i = c; i < Size - 1; i++) {
					theGrid[r, i + 1].LegalNextMove = true;
				}

				// mark bottoms
				for (int i = r; i < Size - 1; i++) {
					theGrid[i + 1, c].LegalNextMove = true;
				}

				// mark diagonal bottom rights
				int spacesRight = 0;
				for (int i = r; i < Size - 1; i++) {
					// bounds check, then mark Cell 
					if (c + spacesRight < Size - 1) {
						theGrid[i + 1, c + ++spacesRight].LegalNextMove = true;
					}
				}
			}
			// top-right corner
			else if ( r == 0 && c == Size-1)
            {
				// mark lefts
				for (int i = c; i > 0; i--) {
					theGrid[r, i - 1].LegalNextMove = true;
				}

				// mark bottoms
				for (int i = r; i < Size - 1; i++) {
					theGrid[i + 1, c].LegalNextMove = true;
				}

				// mark diagonal bottom lefts
				int spacesLeft = 0; 
				for (int i = r; i < Size - 1; i++) {
					// mark bottom left 
					if (c - spacesLeft > 0) {
						theGrid[i + 1, c - ++spacesLeft].LegalNextMove = true;
					}
				}
			}
			// bottom-right corner
			else if ( r == Size-1 && c == Size-1 )
            {
				// mark tops
				for (int i = r; i > 0; i--) {
					theGrid[i - 1, c].LegalNextMove = true;
				}

				// mark lefts 
				for (int i = c; i > 0; i--) {
					theGrid[r, i - 1].LegalNextMove = true;
				}

				// mark diagonal top lefts
				int spacesLeft = 0;
				// loop upward rows
				for (int i = r; i > 0; i--) {
					// mark top left 
					if (c - spacesLeft > 0) {
						theGrid[i - 1, c - ++spacesLeft].LegalNextMove = true;
					}
				}
			}
			// bottom-left corner
			else if ( r == Size-1 && c == 0)
            {
				// mark tops
				for (int i = r; i > 0; i--) {
					theGrid[i - 1, c].LegalNextMove = true;
				}

				// mark rights
				for (int i = c; i < Size - 1; i++) {
					theGrid[r, i + 1].LegalNextMove = true;
				}

				// mark diagonal top rights
				int spacesRight = 0;
				// loop upward rows
				for (int i = r; i > 0; i--) {
					// mark top right
					if (c + spacesRight < Size - 1) {
						theGrid[i - 1, c + ++spacesRight].LegalNextMove = true;
					}
				}
			}


			// ( sides pieces only ) 
			// --------------------------------
			// top side
			if ( r == 0 && (c != 0 && c != Size-1) )
            {
				// mark rights
				for (int i = c; i < Size - 1; i++) {
					theGrid[r, i + 1].LegalNextMove = true;
				}

				// mark lefts
				for (int i = c; i > 0; i--) {
					theGrid[r, i - 1].LegalNextMove = true;
				}

				// mark bottoms
				for (int i = r; i < Size - 1; i++) {
					theGrid[i + 1, c].LegalNextMove = true;
				}

				// mark diagonal bottom rights
				int spacesRight = 0;
				for (int i = r; i < Size - 1; i++) {
					// bounds check, then mark Cell 
					if (c + spacesRight < Size - 1) {
						theGrid[i + 1, c + ++spacesRight].LegalNextMove = true;
					}
				}

				// mark diagonal bottom lefts 
				int spacesLeft = 0;
				for (int i = r; i < Size - 1; i++) {
					// mark bottom left 
					if (c - spacesLeft > 0) {
						theGrid[i + 1, c - ++spacesLeft].LegalNextMove = true;
					}
				}
			}
			// right side 
			else if ( c == Size-1 && (r != 0 && r != Size-1) )
            {
				// mark tops
				for (int i = r; i > 0; i--) {
					theGrid[i - 1, c].LegalNextMove = true;
				}

				// mark lefts
				for (int i = c; i > 0; i--) {
					theGrid[r, i - 1].LegalNextMove = true;
				}

				// mark bottoms
				for (int i = r; i < Size - 1; i++) {
					theGrid[i + 1, c].LegalNextMove = true;
				}

				// mark diagonal top lefts
				int spacesLeft = 0;
				// loop upward rows
				for (int i = r; i > 0; i--) {
					// mark top left 
					if (c - spacesLeft > 0) {
						theGrid[i - 1, c - ++spacesLeft].LegalNextMove = true;
					}
				}

				// mark diagonal bottom lefts 
				spacesLeft = 0;
				for (int i = r; i < Size - 1; i++) {
					// mark bottom left 
					if (c - spacesLeft > 0) {
						theGrid[i + 1, c - ++spacesLeft].LegalNextMove = true;
					}
				}
			}
			// bottom side 
			else if ( r == Size - 1 && (c != 0 && c != Size-1) )
            {
				// mark tops
				for (int i = r; i > 0; i--) {
					theGrid[i - 1, c].LegalNextMove = true;
				}

				// mark rights
				for (int i = c; i < Size - 1; i++) {
					theGrid[r, i + 1].LegalNextMove = true;
				}

				// mark lefts
				for (int i = c; i > 0; i--) {
					theGrid[r, i - 1].LegalNextMove = true;
				}

				// mark diagonal top rights
				int spacesRight = 0;
				// loop upward rows
				for (int i = r; i > 0; i--) {
					// mark top right
					if (c + spacesRight < Size - 1) {
						theGrid[i - 1, c + ++spacesRight].LegalNextMove = true;
					}
				}

				// mark diagonal top lefts 
				int spacesLeft = 0;
				// loop upward rows
				for (int i = r; i > 0; i--) {
					// mark top left 
					if (c - spacesLeft > 0) {
						theGrid[i - 1, c - ++spacesLeft].LegalNextMove = true;
					}
				}
			}
			// left side
			else if (c == 0 && (r != 0 && r != Size - 1))
			{
				// mark tops
				for (int i = r; i > 0; i--) {
					theGrid[i - 1, c].LegalNextMove = true;
				}

				// mark rights
				for (int i = c; i < Size - 1; i++) {
					theGrid[r, i + 1].LegalNextMove = true;
				}

				// mark bottoms
				for (int i = r; i < Size - 1; i++) {
					theGrid[i + 1, c].LegalNextMove = true;
				}

				// mark diagonal top rights
				int spacesRight = 0;
				// loop upward rows
				for (int i = r; i > 0; i--) {
					// mark top right
					if (c + spacesRight < Size - 1) {
						theGrid[i - 1, c + ++spacesRight].LegalNextMove = true;
					}
				}

				// mark diagonal bottom rights 
				spacesRight = 0;
				for (int i = r; i < Size - 1; i++) {
					// bounds check, then mark Cell 
					if (c + spacesRight < Size - 1) {
						theGrid[i + 1, c + ++spacesRight].LegalNextMove = true;
					}
				}
			}


			// ( in-between pieces only ) 
			// --------------------------------
			if ( ( r > 0 && r < Size-1 ) && ( c > 0 && c < Size-1 ) )
            {
				// mark tops
				for (int i = r; i > 0; i--) {
					theGrid[i - 1, c].LegalNextMove = true;
				}

				// mark rights
				for (int i = c; i < Size - 1; i++) {
					theGrid[r, i + 1].LegalNextMove = true;
				}

				// mark bottoms
				for (int i = r; i < Size - 1; i++) {
					theGrid[i + 1, c].LegalNextMove = true;
				}

				// mark lefts
				for (int i = c; i > 0; i--) {
					theGrid[r, i - 1].LegalNextMove = true;
				}

				// mark diagonal top rights
				int spacesRight = 0;
				// loop upward rows
				for (int i = r; i > 0; i--) {
					// mark top right
					if (c + spacesRight < Size - 1) {
						theGrid[i - 1, c + ++spacesRight].LegalNextMove = true;
					}
				}

				// mark diagonal bottom rights 
				spacesRight = 0;
				for (int i = r; i < Size - 1; i++) {
					// bounds check, then mark Cell 
					if (c + spacesRight < Size - 1) {
						theGrid[i + 1, c + ++spacesRight].LegalNextMove = true;
					}
				}

				// mark diagonal bottom lefts
				int spacesLeft = 0;
				for (int i = r; i < Size - 1; i++) {
					// mark bottom left 
					if (c - spacesLeft > 0) {
						theGrid[i + 1, c - ++spacesLeft].LegalNextMove = true;
					}
				}

				// mark diagonal top lefts 
				spacesLeft = 0;
				// loop upward rows
				for (int i = r; i > 0; i--) {
					// mark top left 
					if (c - spacesLeft > 0) {
						theGrid[i - 1, c - ++spacesLeft].LegalNextMove = true;
					}
				}
			}

		}

		/*public static void pawnPiece(Cell currentCell, Cell[,] theGrid, int Size) { }*/
	}
}
