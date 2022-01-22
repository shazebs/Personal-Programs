using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChessBoard
{
	public class Cell
	{
		// properties 
		public int RowNumber { get; set; }
		public int ColumnNumber { get; set; }
		public bool CurrentlyOccupied { get; set; }
		public bool LegalNextMove { get; set; }

		// constructor 
		public Cell(int x, int y)
		{
			RowNumber = x;
			ColumnNumber = y;

		}
	}
}
