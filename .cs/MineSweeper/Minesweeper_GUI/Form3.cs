using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace Minesweeper_GUI
{
    public partial class Form3 : Form
    {
        /* global properties */ 
        Form1 parent; // to hold form 1 object 
        List<GameStats> todayScores = new List<GameStats>();
        List<GameStats> allTimeScores = new List<GameStats>();
        string filePath = @"HighScores.txt";



        /* Default Form3 constructor. */ 
        public Form3()
        {
            InitializeComponent();
        }


        /* Non-default Form3 constructor */ 
        public Form3(Form1 form1, List<GameStats> scoresList)
        {
            InitializeComponent();

            // set form2's local 'parent' property to form1 object 
            this.parent = form1;

            // initialize today's scores into a list. 
            todayScores = scoresList;

            // If no new scores are available.
            if (todayScores.Count == 0){
                list_TodayScores.Items.Add("No new scores today.");
            }
            // If new scores are available.
            else {
                updateTodayScores();
            }
        }



        /* Function to refresh today's scores list box. */ 
        public void updateTodayScores()
        {
            // Clear today's scores list box.
            list_TodayScores.Items.Clear();

            // Sort today's scores.
            todayScores = HighScoreSortingAlgo(todayScores);

            // Add today's scores to list box.
            int count = 1;
            foreach (var score in todayScores){
                list_TodayScores.Items.Add($"{count++}. " + score.ToString());
            }
        }



        /* Function to refresh all time scores list box. */ 
        public void updateLegendScores()
        {
            // Clear legend scores list box.
            list_LegendScores.Items.Clear();

            // Sort today's scores.
            allTimeScores = HighScoreSortingAlgo(allTimeScores);

            // Add today's scores to list box.
            int count = 1;
            foreach (var score in allTimeScores){
                list_LegendScores.Items.Add($"{count++}. " + score.ToString());
            }
        }



        /* When form3 first loads */ 
        private void Form3_Load(object sender, EventArgs e)
        {
            // On form load, read high scores from a file.
            getAllScoresFromFile(); 

            // Refresh the legend scores list box.
            updateLegendScores();
        }



        /* Save high scores button click handler */ 
        private void btn_SaveHighScores_Click(object sender, EventArgs e)
        {
            // Save all scores to a file.
            saveAllScoresToFile(); 

            // Then load that file back into legend scores list box. 
            getAllScoresFromFile(); 

            // Refresh the legend scores list box. 
            updateLegendScores();
        }



        /* Function that saves all today's scores and existing all times scores, sorted, into a save file */ 
        private void saveAllScoresToFile()
        {
            // a list to hold non-duplicate scores from today.
            List<GameStats> nonDuplicates = new List<GameStats>();

            // loop through today's scores
            foreach (GameStats today in todayScores){
                bool add = true; 
                // loop through all time scores
                foreach(GameStats stat in allTimeScores) {
                    // compare today's stats with every all time score
                    if (today.PlayerName == stat.PlayerName &&
                        today.GameScore == stat.GameScore &&
                        today.BoardSize == stat.BoardSize &&
                        today.TotalBombs == stat.TotalBombs &&
                        today.GameSeconds == stat.GameSeconds 
                        ) 
                    {
                        // A duplicate set has been found.
                        add = false;
                        break; 
                    }
                }
                if (add) nonDuplicates.Add(today);
            }

            // Join today's scores and all time scores into one list and sort it. 
            List<GameStats> stats = HighScoreSortingAlgo(allTimeScores.Concat(nonDuplicates).ToList());

            // Create lines of all player stats. 
            List<string> lines = new List<string>();
            foreach (GameStats stat in stats){
                lines.Add($"{stat.PlayerName}|{stat.GameSeconds}|{stat.BoardSize}|{stat.TotalBombs}|{stat.GameScore}"); 
            }

            // Write lines to a save file.
            File.WriteAllLines(filePath, lines);

            // Update the legend scores list box.
            getAllScoresFromFile();
        }



        /* Function to read all scores from a saved file and insert them into the legend scores list box. */ 
        private List<GameStats> getAllScoresFromFile()
        {
            // Clear legend scores list box and backend list. 
            list_LegendScores.Items.Clear();
            allTimeScores.Clear();

            try {
                // Read all lines from text file into a list. 
                List<String> lines = File.ReadAllLines(filePath).ToList();

                // Loop through list of all read lines. 
                foreach (string line in lines) {
                    try {
                        // Separate all data fields in the line. 
                        string[] tokens = line.Split('|');

                        // Print tokens to console.
                        foreach (string token in tokens)
                        {
                            Console.Write(" " + token);
                        }
                        Console.WriteLine();

                        // Use the array tokens to create new GameStat objects.
                        GameStats newStats = new GameStats(
                                               tokens[0].Trim(),    // name
                                    int.Parse(tokens[1].Trim()),    // time
                                    int.Parse(tokens[2].Trim()),    // size
                                    int.Parse(tokens[3].Trim()),    // bombs
                                    int.Parse(tokens[4].Trim())     // score
                                );
                        // if a duplicate stats set is found, do not add to list of distinct player stats
                        allTimeScores.Add(newStats);
                        Console.WriteLine("newStats added to playerStats");
                    }
                    catch (Exception error) {
                        MessageBox.Show("An error occurred while reading 'HighScore.txt' file.");
                    }
                }
            }
            catch (Exception e) {
                list_LegendScores.Items.Add("Set a new high score!");
                Console.WriteLine("No All Time Scores exist.");
            }

            // Now that we have all player stats read from file, sort the list. 
            HighScoreSortingAlgo(allTimeScores);

            // return playerStats List
            return allTimeScores;
        }



        /* My High Scores Sorting Algorithm */ 
        private List<GameStats> HighScoreSortingAlgo(List<GameStats> orignalList)
        {
            // function properties 
            List<int> gameScores = new List<int>();
            List<GameStats> list = orignalList;
            int rep, replicate, next;

            // start to end loop 
            for (rep = 0; rep < list.Count; rep++)
            {
                // Reset subscripts for comparing list indices. 
                replicate = rep;
                next = replicate + 1;

                // Debugging s
                Console.WriteLine("\nWe are now in for loop rep = " + rep);
                Console.WriteLine($"Rep = {rep}, Replicate = {replicate}, Next = {next}, list.Count = {list.Count}");

                // End of list reached, 
                if (next == list.Count){
                    Console.WriteLine($"End of list reached."); 
                    break; 
                }

                // --------------------------------------------------------------------------
                // The Sorting Algorithm. 
                // --------------------------------------------------------------------------
                if (list[rep].GameScore == list[next].GameScore)
                {
                    // compare time
                    if (list[rep].GameSeconds == list[next].GameSeconds)
                    {
                        // compare bombs
                        if (list[rep].TotalBombs == list[next].TotalBombs)
                        {
                            // compare difficulty
                            if (list[rep].BoardSize == list[next].BoardSize)
                            {
                                // do nothing now.
                            }
                            else if (list[rep].BoardSize <= list[next].BoardSize)
                            {
                                // make a clone of second object
                                GameStats clone = new GameStats(
                                        list[next].PlayerName,
                                        list[next].GameSeconds,
                                        list[next].BoardSize,
                                        list[next].TotalBombs,
                                        list[next].GameScore
                                    );
                                // swap the indexes
                                list.RemoveAt(next); // remove second object
                                list.Insert(rep, clone); // insert clone before first object

                                // Reverse sort highest score to front of the list. 
                                while (replicate > 0)
                                {
                                    // make next variable current first object index 
                                    next = replicate;

                                    // if first object index score is greater than preceding score, swap elements.
                                    if (list[replicate].BoardSize >= list[--replicate].GameScore && list[next].GameScore >= list[replicate].GameScore && list[next].GameSeconds <= list[replicate].GameSeconds && list[next].TotalBombs >= list[replicate].TotalBombs)
                                    {
                                        // clone for swap 
                                        clone = new GameStats(
                                            list[next].PlayerName,
                                            list[next].GameSeconds,
                                            list[next].BoardSize,
                                            list[next].TotalBombs,
                                            list[next].GameScore
                                        );
                                        // swap the indexes
                                        list.RemoveAt(next); // remove second object
                                        list.Insert(replicate, clone); // insert clone before first object 
                                    }
                                }
                            }
                        }
                        else if (list[rep].TotalBombs < list[next].TotalBombs)
                        {
                            // make a clone of second object
                            GameStats clone = new GameStats(
                                    list[next].PlayerName,
                                    list[next].GameSeconds,
                                    list[next].BoardSize,
                                    list[next].TotalBombs,
                                    list[next].GameScore
                                );
                            // swap the indexes
                            list.RemoveAt(next); // remove second object
                            list.Insert(rep, clone); // insert clone before first object

                            // Reverse sort highest score to front of the list. 
                            while (replicate > 0)
                            {
                                // make next variable current first object index 
                                next = replicate;

                                // if first object index score is greater than preceding score, swap elements.
                                if (list[replicate].TotalBombs > list[--replicate].TotalBombs && list[next].GameScore >= list[replicate].GameScore && list[next].GameSeconds <= list[replicate].GameSeconds)
                                {
                                    // clone for swap 
                                    clone = new GameStats(
                                        list[next].PlayerName,
                                        list[next].GameSeconds,
                                        list[next].BoardSize,
                                        list[next].TotalBombs,
                                        list[next].GameScore
                                    );
                                    // swap the indexes
                                    list.RemoveAt(next); // remove second object
                                    list.Insert(replicate, clone); // insert clone before first object 
                                }
                            }
                        }
                    }
                    else if (list[rep].GameSeconds > list[next].GameSeconds)
                    {
                        // make a clone of second object
                        GameStats clone = new GameStats(
                                list[next].PlayerName,
                                list[next].GameSeconds,
                                list[next].BoardSize,
                                list[next].TotalBombs,
                                list[next].GameScore
                            );
                        // swap the indexes
                        list.RemoveAt(next); // remove second object
                        list.Insert(rep, clone); // insert clone before first object

                        // Reverse sort highest score to front of the list. 
                        while (replicate > 0)
                        {
                            // make next variable current first object index 
                            next = replicate;

                            // if first object index score is greater than preceding score, swap elements.
                            if (list[replicate].GameSeconds < list[--replicate].GameScore && list[next].GameScore >= list[replicate].GameScore)
                            {
                                // clone for swap 
                                clone = new GameStats(
                                    list[next].PlayerName,
                                    list[next].GameSeconds,
                                    list[next].BoardSize,
                                    list[next].TotalBombs,
                                    list[next].GameScore
                                );
                                // swap the indexes
                                list.RemoveAt(next); // remove second object
                                list.Insert(replicate, clone); // insert clone before first object 
                            }
                        }
                    }
                }
                // if current score is less than score next on the list 
                else if (list[rep].GameScore < list[next].GameScore)
                {
                    Console.WriteLine($"list[rep({rep})].GameScore ({list[rep].GameScore}) is < list[next({next})].GameScore ({list[next].GameScore})");
                    Console.WriteLine($"rep = {rep} next = {next}");
                    // make a clone of second object
                    GameStats clone = new GameStats(
                            list[next].PlayerName,
                            list[next].GameSeconds,
                            list[next].BoardSize,
                            list[next].TotalBombs,
                            list[next].GameScore
                        );

                    // swap the indexes
                    list.RemoveAt(next); // remove second object
                    list.Insert(rep, clone); // insert clone before first object 

                    // Reverse sort highest score to front of the list. 
                    while (replicate > 0)
                    {
                        // make next variable current first object index 
                        next = replicate; 

                        // if first object index score is greater than preceding score, swap elements.
                        if (list[replicate].GameScore > list[--replicate].GameScore)
                        {
                            // clone for swap 
                            clone = new GameStats(
                                list[next].PlayerName,
                                list[next].GameSeconds,
                                list[next].BoardSize,
                                list[next].TotalBombs,
                                list[next].GameScore
                            );

                            // swap the indexes
                            list.RemoveAt(next); // remove second object
                            list.Insert(replicate, clone); // insert clone before first object 
                        }
                    }
                }
                // --------------------------------------------------------------------------
            }

            // Return sorted list upon function exit. 
            return list; 
        }



        /* Exit out of High Scores form */ 
        private void btn_ReturnToGame_Click(object sender, EventArgs e)
        {
            this.Close(); // close form3
        }



    } // end of class 

} // end of namespace 
