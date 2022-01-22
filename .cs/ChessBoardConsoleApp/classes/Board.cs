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
		public Cell[,] theGrid{ get; set; }

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
			switch (chessPiece)
			{
				case "Knight":
					theGrid[currentCell.RowNumber + 2, currentCell.ColumnNumber + 1].LegalNextMove = true;
					theGrid[currentCell.RowNumber + 2, currentCell.ColumnNumber - 1].LegalNextMove = true;
					theGrid[currentCell.RowNumber - 2, currentCell.ColumnNumber + 1].LegalNextMove = true;
					theGrid[currentCell.RowNumber - 2, currentCell.ColumnNumber - 1].LegalNextMove = true;
					theGrid[currentCell.RowNumber + 1, currentCell.ColumnNumber + 2].LegalNextMove = true;
					theGrid[currentCell.RowNumber + 1, currentCell.ColumnNumber - 2].LegalNextMove = true;
					theGrid[currentCell.RowNumber - 1, currentCell.ColumnNumber + 2].LegalNextMove = true;
					theGrid[currentCell.RowNumber - 1, currentCell.ColumnNumber - 2].LegalNextMove = true;

					break;

				case "King":
					break;

				case "Rook":
					break;

				case "Bishop":
					break;

				case "Queen":
					break;

				default:
					break;
			}
		}
	}
}
