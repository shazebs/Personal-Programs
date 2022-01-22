using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Minesweeper_pt1
{
    class Cell
    {
        // Properties 
        public int row { get; set; }
        public int col { get; set; }
        public bool isVisited { get; set; }
        public bool isLive { get; set; }
        public int liveNeighbors { get; set; }
        public bool hasFlag { get; set; }

        // Constructors 
        public Cell() 
        {
            this.col = -1;
            this.row = -1;
            this.isVisited = false;
            this.isLive = false;
            this.liveNeighbors = 0;
            this.hasFlag = false; 
        }

        // Constructor 2
        public Cell(int row, int col)
        {
            this.row = row;
            this.col = col;
            this.isVisited = false;
            this.isLive = false;
            this.liveNeighbors = 0;
            this.hasFlag = false; 
        }

        // Getters
        public int getRow() { return this.row; }
        public int getCol() { return this.col; }
        public bool getIsVisited() { return isVisited; }
        public bool getIsLive() { return isLive; }
        public int getLiveNeighbors() { return liveNeighbors; }
        public bool getHasFlag() { return hasFlag; }

        // Setters
        public void setRow(int row) { this.row = row; }
        public void setCol(int col) { this.col = col; }
        public void setIsVisited(bool x) { this.isVisited = x; }
        public void setIsLive(bool x) { this.isLive = x; }
        public void setLiveNeighbors(int x) { this.liveNeighbors = x; }
        public void setHasFlag(bool flag) { this.hasFlag = flag; }
    }
}
