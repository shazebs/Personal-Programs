using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Minesweeper_GUI
{
    public class GameStats
    {
        /* Class Properties */ 
        public string PlayerName { get; set; }
        public int GameSeconds { get; set; }
        public int BoardSize { get; set; }
        public int TotalBombs { get; set; }
        public int GameScore { get; set; }


        /* Default Constructor */ 
        public GameStats() { }


        /* Non-Default Constructor */ 
        public GameStats(string name, int secs, int size, int bombs, int score)
        {
            this.PlayerName = name;
            this.GameSeconds = secs;
            this.BoardSize = size;
            this.TotalBombs = bombs;
            this.GameScore = score;
        }


        /* ToString method */ 
        public string ToString()
        {
            string diff = ""; 
            switch (BoardSize)
            {
                case 12:
                    diff = "Easy";
                    break;
                case 19:
                    diff = "Medium";
                    break;
                case 27:
                    diff = "Hard";
                    break;
            }
            return $"Score::{GameScore} | Player::{PlayerName} | Time::{GameSeconds}s | Total Bombs::{TotalBombs} | Difficulty::{diff}";  
        }


        /* Method for sorting ( Replaced by Form3.HighScoresSortingAlgo() ) */ 
        public void CompareTo(Object obj)
        {
            GameStats other = (GameStats) obj; 
        }



    } // end of class. 

} // end of namespace. 
