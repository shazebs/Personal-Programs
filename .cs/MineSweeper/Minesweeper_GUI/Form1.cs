using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Minesweeper_GUI
{
    public partial class Form1 : Form
    {

        // properties 
        static Random rand = new Random();
        public static Stopwatch watch = new Stopwatch();
        Board board = new Board();  
        static List<Bitmap> listimage = new List<Bitmap>();
        List<GameStats> todayScores = new List<GameStats>();
        public Button[,] grid; // to hold the grid elements as an array object  
        public int form2Exited = -1;  // flag for form2 misclosure 
        static int lineOfCells; // grid sizing 
        static int panelWidth;
        bool newGame = false; // this condition allows for a new game to be started  
        bool clickable = true; // this allows panel buttons to be clicked 
        bool begin = true; // for timer tick 
        int localScore = 0;
        int bonusPoints = 0; // can only be added if game is won 
        int TotalSecs = 0; 
        string PlayerName = "";
        string parsableTime = ""; 



        // form1 constructor 
        public Form1()
        {
            InitializeComponent(); // do not remove 

            /* open form2 before form1 */ 
            Form2 f2 = new Form2(this); // create a form2 object 
            f2.ShowDialog(); // open the new form2 before form2 fully loads 

            // set panel beginning dimensions
            this.Height = 725; 

            // put resource images in a list 
            listimage.Add(Properties.Resources.roswell_ufo);
            listimage.Add(Properties.Resources.galaxy);
            listimage.Add(Properties.Resources.galaxy2);
        }
              


        /* populate game grid gui with button components based on a selected grid-size by the user */
        public void setupBoard(int numCells)
        {
            // set the gui panel's height property to make a perfect square 
            gamePanel.Height = gamePanel.Width;
            panelWidth = gamePanel.Width; // this variable will help us reset the game panel when new game is created 

            // to size Board object after form2 closes 
            lineOfCells = numCells;

            // adjust panel dimensions for hard
            if (lineOfCells == 27) {
                gamePanel.Height = gamePanel.Width + 12;
                gamePanel.Width = gamePanel.Height;
            }
            // adjust panel dimensions for medium
            if (lineOfCells == 19) {
                gamePanel.Height = gamePanel.Width + 2;
                gamePanel.Width = gamePanel.Height;
            }

            // set button size width in pixels 
            int buttonSize = gamePanel.Width / lineOfCells;
            
            // adjust panel dimensions for easy
            if (lineOfCells == 12) {
                gamePanel.Height = gamePanel.Width - 3; 
                gamePanel.Width = gamePanel.Height;
            }

            // initialize the grid array to hold Button objects 
            grid = new Button[lineOfCells, lineOfCells]; 

            // loop through grid array and setup buttons on the panel in form1  
            for (var x=0; x < lineOfCells; x++) 
            {
                for (var y=0; y < lineOfCells; y++) 
                { 
                    grid[x, y] = new Button(); // target grid index will initialize a new Button 
                    grid[x, y].Width = buttonSize; // the button is assigned a width 
                    grid[x, y].Height = buttonSize; // the button is assigned a height 
                    // grid[x, y].BackColor = Color.DarkSlateBlue;
                    grid[x, y].ForeColor = Color.White; // the button's text color is set  
                    grid[x, y].MouseDown += Grid_Button_MouseDown; // the button is assigned a click event handler  
                    gamePanel.Controls.Add(grid[x, y]); // a gui component is inserted onto a panel with this method 
                    grid[x, y].Location = new Point(y * buttonSize, x * buttonSize); // once gui component is placed on the panel, set the object's position using x-y coordinates 
                    grid[x, y].Tag = new Point(x,y); // create this tag on the button so it can be referenced later by its grid array index 

                    // set font-sizes of buttons
                    grid[x, y].FlatStyle = FlatStyle.Flat;
                    grid[x, y].FlatAppearance.BorderSize = 1;
                    // grid[x, y].FlatAppearance.BorderColor = Color.Black;
                    switch (lineOfCells)
                    {
                        case 12:
                            grid[x, y].Font = new Font("Arial", 14);
                            // grid[x, y].FlatAppearance.BorderColor = Color.White;
                            break;
                        case 19:
                            grid[x, y].Font = new Font("Arial", 12, FontStyle.Bold);
                            // grid[x, y].FlatAppearance.BorderColor = Color.White;
                            break;
                        case 27:
                            grid[x, y].Font = new Font("Arial", 11);
                            // grid[x, y].FlatAppearance.BorderColor = Color.White;
                            break;
                    }
                }
            }
            watch.Start(); // start game timer 
        }



        private void Grid_Button_MouseDown(object sender, MouseEventArgs e)
        {
            bool status = false; // for checking if game is over  

            // increment total number of button clicks 
            if (clickable) board.totalClicks++;
            lbl_TotalClicks.Text = $"Total Clicks: {board.totalClicks}";

            // the targeted Button object is cloned as another variable for testing purposes 
            Button clickedButton = (Button) sender;
            Point location = (Point) clickedButton.Tag;  // the Button's tag value is retreived as a Point object

            // determine the button's 2D array x and y index 
            int x = location.X;
            int y = location.Y;

            // if left mouseclick
            if (e.Button == MouseButtons.Left && clickable){
                status = board.leftClick(x, y); 
            }
            // if right mouseclick 
            if (e.Button == MouseButtons.Right && clickable)
            {
                // set flag on selected cell in the back-end
                board.rightClick(x, y);

                // set flag for panel on the front-end
                grid[x, y].Text = "🚩";
                grid[x, y].ForeColor = Color.Red;
            }
            checkForEndOfGame(status); // check if game should be over  
        }



        public void updateBoard(Board board)
        {
            // reset score variables
            localScore = 0;
            bonusPoints = 0;

            for (var x = 0; x < lineOfCells; x++){
                for (var y = 0; y < lineOfCells; y++){
                    // if cell is a live bomb
                    if (board.grid[x, y].isLive && board.grid[x, y].isVisited == true){
                        // show bomb image
                        grid[x, y].BackColor = Color.Red;
                        grid[x, y].ForeColor = Color.Black;
                        grid[x, y].Text = "💣";
                        // adjust font-size for bomb based on difficulty
                        switch (lineOfCells)
                        {
                            case 12:
                                grid[x, y].Font = new Font("Arial", 18);
                                break;
                            case 19:
                                grid[x, y].Font = new Font("Arial", 12, FontStyle.Bold);
                                break;
                            case 27:
                                grid[x, y].Font = new Font("Arial", 11);
                                break;
                        }
                    }
                    // if cell is safe 
                    if (board.grid[x,y].isVisited && 
                        board.grid[x,y].liveNeighbors > 0 && 
                        board.grid[x,y].liveNeighbors < 9)
                    {
                        // pass cell through a font-color filter 
                        switch (board.grid[x, y].liveNeighbors)
                        {
                            case 1:
                                // grid[x, y].ForeColor = Color.YellowGreen;
                                grid[x, y].ForeColor = Color.GreenYellow;
                                break;
                            case 2:
                                grid[x, y].ForeColor = Color.DodgerBlue;
                                break;
                            case 3:
                                grid[x, y].ForeColor = Color.HotPink;
                                break;
                            case 4:
                                grid[x, y].ForeColor = Color.Orange;
                                break;
                            case 5:
                                grid[x, y].ForeColor = Color.Turquoise;
                                break;
                            case 6:
                                grid[x, y].ForeColor = Color.MediumPurple;
                                break;
                        }
                        // flip to reveal cell element
                        grid[x, y].Text = $"{board.grid[x,y].liveNeighbors}"; 
                    }

                    // if empty cell is clicked, recursively flood-fill board
                    else if (board.grid[x,y].isVisited && 
                        board.grid[x,y].liveNeighbors < 1 && 
                        board.grid[x,y].isLive == false)
                    {
                        grid[x, y].BackColor = Color.LightGray;
                        // grid[x, y].BackColor = Color.Transparent;
                    }

                    // increment points to localScore 
                    if (board.grid[x, y].isVisited && 
                        board.grid[x, y].isLive == false && 
                        board.grid[x, y].liveNeighbors > 0 && 
                        board.grid[x, y].liveNeighbors < 9)
                    {
                        localScore += board.grid[x, y].liveNeighbors;
                    }
                }
            } 
            // display score 
            lbl_Score.Text = $"Score: {localScore}";
        }



        /* adds a win bonus depending on how many correct bombs were flagged */
        public int FlagBonus()
        {
            bonusPoints = 0; 
            for (var x = 0; x < lineOfCells; x++){
                for (var y = 0; y < lineOfCells; y++){
                    // check current cell for flag and bomb
                    if (board.grid[x, y].hasFlag && board.grid[x, y].isLive)
                    {
                        // if flag is incorrectly placed on this cell, change backColor to red 
                        if (board.grid[x, y].hasFlag && board.grid[x, y].isLive == false)
                        {
                            grid[x, y].BackColor = Color.Red;
                            grid[x, y].ForeColor = Color.Black;
                            grid[x, y].Text = "🚩";
                            bonusPoints -= 5;
                        }
                        else // flag was placed correctly 
                        {
                            // change cell backColor to green if flag is correct 
                            grid[x, y].BackColor = Color.GreenYellow;
                            grid[x, y].Text = "🚩";
                            bonusPoints += 5;
                        }
                    }
                }
            }
            return bonusPoints;
        }



        /* this function occurs every button click */
        public void checkForEndOfGame(bool gameLost)
        {
            if (gameLost)
            {
                // game over 
                updateBoard(board); // reveal bomb location
                watch.Stop(); // then stop the timer 
                MessageBox.Show("BOMB HIT!"); // tell the user what just happened
                printFullPanel(grid, board); // reveal entire board after user proceeds
                clickable = false; // do not let panel buttons be clickable  

                // print YOU LOST label 
                lbl_WinLoss.ForeColor = Color.Red;
                lbl_WinLoss.Font = new Font("Arial", 22); 
                lbl_WinLoss.Text = "YOU LOST";
                lbl_TotalScore.Text = "";

                // add game loss score to total today scores
                todayScores.Add(new GameStats(PlayerName, parseTime(), lineOfCells, board.totalBombs, localScore)); 
            }
            else // game is not yet over
            {
                updateBoard(board); // reveal cell location 

                // check if game was won from cell reveal
                if (board.isGameWon() && clickable)
                {
                    watch.Stop(); // stop the timer 
                    // print YOU WIN label 
                    lbl_WinLoss.Font = new Font("Arial", 22); 
                    lbl_WinLoss.ForeColor = Color.Green;
                    lbl_WinLoss.Text = "YOU WIN"; // adjust game win|loss status text 
                    MessageBox.Show("YOU WIN!!!"); // display a YOU WIN message box  
                    printFullPanel(grid, board); // reveal all cell locations 
                    clickable = false; // make panel buttons unclickable 

                    // update regular score
                    lbl_Score.Text = $"Score: {localScore} + {FlagBonus()}";
                    localScore += FlagBonus(); 

                    // update score with flag bonus
                    lbl_TotalScore.Text = $"{localScore} ";

                    // add score to a list of today's scores 
                    todayScores.Add(new GameStats(PlayerName, parseTime(), lineOfCells, board.totalBombs, localScore));
                }
            }
        }



        /* Function for parsing timer into an integer of seconds. */ 
        public int parseTime()
        {
            // find total seconds
            string[] tokens = parsableTime.Split(':').ToArray();
            switch (tokens.Length)
            {
                // seconds
                case 1:
                    TotalSecs = int.Parse(tokens[0]);
                    break;
                // minutes
                case 2:
                    TotalSecs = int.Parse(tokens[0]) * 60 + int.Parse(tokens[1]);
                    break;
                // hours
                case 3:
                    TotalSecs = (int.Parse(tokens[0]) * 3600) + (int.Parse(tokens[1]) * 60) + int.Parse(tokens[2]);
                    break;
                // days
                case 4:
                    TotalSecs = (int.Parse(tokens[0]) * 86400) + (int.Parse(tokens[1]) * 3600) + (int.Parse(tokens[2]) * 60) + int.Parse(tokens[3]);
                    break;
                default:
                    MessageBox.Show("A parsing issue occurred!");
                    break;
            }
            return TotalSecs;
        } 



        /* dispaly all elements of every button on the panel */
        public static void printFullPanel(Button[,] grid, Board board)
        {
            for (var x = 0; x < lineOfCells; x++)
            {
                for (var y = 0; y < lineOfCells; y++)
                {
                    if (board.grid[x, y].isLive == false && board.grid[x, y].liveNeighbors > 0)
                    {
                        /* pass through a font-color filter */
                        switch (board.grid[x, y].liveNeighbors)
                        {
                            case 1:
                                grid[x, y].ForeColor = Color.GreenYellow;
                                break;
                            case 2:
                                grid[x, y].ForeColor = Color.DodgerBlue;
                                break;
                            case 3:
                                grid[x, y].ForeColor = Color.HotPink;
                                break;
                            case 4:
                                grid[x, y].ForeColor = Color.Orange;
                                break;
                            case 5:
                                grid[x, y].ForeColor = Color.Turquoise;
                                break;
                            case 6:
                                grid[x, y].ForeColor = Color.MediumPurple;
                                break;

                        }
                        // set button text 
                        grid[x, y].Text = $"{board.grid[x, y].liveNeighbors}";
                    }
                    // bomb location font styling 
                    else if (board.grid[x, y].isLive)
                    {
                        grid[x, y].BackColor = Color.Red;
                        grid[x, y].ForeColor = Color.Black;
                        grid[x, y].Text = "💣";

                        switch(lineOfCells)
                        {
                            case 12:
                                grid[x, y].Font = new Font("Arial", 18);
                                break;
                            case 19:
                                grid[x, y].Font = new Font("Arial", 12, FontStyle.Bold);
                                break;
                            case 27:
                                grid[x, y].Font = new Font("Arial", 11);
                                break;
                        }
                    }
                    else {
                        grid[x, y].BackColor = Color.LightGray;
                        // grid[x, y].BackColor = Color.Transparent;
                    }
                }
            }
        }  



        /* utility function if user exits from form2 without selecting a difficulty level */
        private void Form1_Load(object sender, EventArgs e)
        {
            // if the is build is successful the game will load form1 
            if (form2Exited == 1)
            {
                lbl_Time.Text = "Time: ";
                board = new Board(lineOfCells); // setup Board before panel 
                localScore = board.score; 
                board.placeBombs(lineOfCells); // initialize back-end grid array with bombs randomly 
                board.calculateLiveNeighbors(); // initialize all other cell live neighbors property 
                // printFullPanel(grid, board); 
                // gamePanel.BackgroundImage = listimage[1]; 
                watch.Start();
            }
            // else the game exit message box will show and form1 will not load 
            else if (form2Exited == 0){
                this.Close(); // close form1
            }
            else // some unknown anomoly has occured 
                MessageBox.Show("-1");
        }



        /* this function is specific to aiding the process of resetting the game grid when the 'start new button' is clicked within form1, 
         since form1 technically isn't being re-loaded, it's just gaining focus after form2 closes with a new game input return */
        private void Form1_Activated(object sender, EventArgs e)
        {
            if (newGame == true)
            {
                newGame = false; // this flag is reset so a new game can be iterated once more
                // if the form2's build is successful the game will load form1
                if (form2Exited == 1)
                {
                    // GAME LOGIC 
                    lbl_Time.Text = "Time: ";
                    board = new Board(lineOfCells); // create a new back-end board object 
                    localScore = board.score;
                    board.placeBombs(lineOfCells); // initialize back-end board's grid array with bombs randomly
                    board.calculateLiveNeighbors(); // initialize the liveNeighbors property for back-end board's grid array 
                    // printFullPanel(grid, board); // mainly for debugging purposes, flips all panel buttons to reveal its element
                    // gamePanel.BackgroundImage = listimage[1]; 
                    watch.Start(); // start game timer
                }
                // if form2 was closed without clicking start game 
                else if (form2Exited == 0){
                    this.Close(); // close form1
                }
                else // some unknown anomoly has occured
                    MessageBox.Show("-1");
            }
        }



        /* start new game - button click event handler (coexisting-process with Form1_Activated function) */
        private void btn_startgame_Click(object sender, EventArgs e)
        {
            /* reset variables */
            grid = null;
            board = null;
            form2Exited = -1;
            lineOfCells = 0;
            newGame = true;
            clickable = true;
            lbl_WinLoss.Text = "";
            lbl_Score.Text = "Score: ";
            lbl_TotalClicks.Text = "Total Clicks: ";
            bonusPoints = 0;
            lbl_Time.Text = "Time: 0s";
            watch.Reset();
            TotalSecs = 0; 
            // gamePanel.BackgroundImage = null; // Set's panel background-image.

            // remove all buttons from panel 
            foreach (Control c in gamePanel.Controls.OfType<Button>().ToList()){
                gamePanel.Controls.Remove(c);
                c.Dispose();
            }

            // reset panel dimensions 
            gamePanel.Width = panelWidth;
            gamePanel.Height = panelWidth;

            // open form2 and initialize a new game 
            Form2 f2 = new Form2(this, PlayerName);
            f2.ShowDialog();
        }



        /* retrieve a string value from form2 and peform an operation 
         * with that value before function closure */
        public void difficultyLevel(String level, string name)
        {
            // set player's name
            if (name == "") PlayerName = " "; 
            else PlayerName = name; 

            // set game difficulty 
            string var = level;
            switch (var)
            {
                case "Easy":
                    setupBoard(12);
                    break;
                case "Medium":
                    setupBoard(19);
                    break;
                case "Hard":
                    setupBoard(27);
                    break;
                default:
                    break;
            }
        }



        /* form1 closure message */
        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            // MessageBox.Show("Good-bye");
        }


        /* end game - button click event handler */
        private void btn_Exit_Click(object sender, EventArgs e)
        {
            this.Close();
        }



        /* timer ticking event handler */ 
        private void timer_Tick(object sender, EventArgs e)
        {
            string line = "";

            // retrieve timer values 
            var ms = (watch.Elapsed.Milliseconds / 10).ToString("");
            var s = watch.Elapsed.Seconds.ToString("");
            var m = watch.Elapsed.Minutes.ToString("");
            var h = watch.Elapsed.Hours.ToString("");
            var d = watch.Elapsed.Days.ToString();

            /* format timer text */
            if (int.Parse(d) > 0)
            {
                line = d + "d : " + h + "h : " + m + "m : " + s + "s";
                parsableTime = $"{d}:{h}:{m}:{s}";
            }
            else if (int.Parse(h) > 0)
            {
                line = h + "h : " + m + "m : " + s + "s";
                parsableTime = $"{h}:{m}:{s}";
            }
            else if (int.Parse(m) > 0)
            {
                line = m + "m : " + s + "s";
                parsableTime = $"{m}:{s}";
            }
            else if (int.Parse(s) > 0)
            {
                line = s + "s";
                parsableTime = $"{s}";
            }

            // update timer text 
            if (int.Parse(s) < 1 && begin)
            {
                lbl_Time.Text = "Time: ";
                begin = false;
            }
            else{
                lbl_Time.Text = $"Time: {line}";
            }
            if (int.Parse(watch.ElapsedMilliseconds.ToString()) == 0){
                lbl_Time.Text = "";
            }
        }



        /* Button click event handler for opening High Scores menu */  
        private void btn_ViewHighScores_Click(object sender, EventArgs e)
        {
            // Open form3. 
            Form3 f3 = new Form3(this, todayScores); // create a form2 object 
            f3.ShowDialog(); // open the new form2 before form2 fully loads 
        }



    } // end of class. 

} // end of namespace. 
