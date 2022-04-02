using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Minesweeper_GUI
{
    public partial class Form2 : Form
    {
        // properties
        Form1 parent; // to hold form 1 object 


        // form 2 initialization 'default 'constructor
        public Form2()
        {
            InitializeComponent();
        }



        // form 2 initialization 'non-default' constructor
        public Form2(Form1 form)
        {
            /* do not remove */ 
            InitializeComponent();

            // set form2's local 'parent' property to form1 object 
            this.parent = form;

            // Set focus on name text upon form creation. 
            txt_PlayerName.Select();
        }



        public Form2(Form1 form, string PlayerName)
        {
            InitializeComponent();

            // set form2's local 'parent' property to form1 object 
            this.parent = form;

            // Re-use player name and set focus on player name text box. 
            txt_PlayerName.Text = PlayerName; 
            txt_PlayerName.Select();
        }



        // start game - button click event handler 
        private void btn_startgame_Click(object sender, EventArgs e)
        {
            // send difficulty level value from form2 to form1 
            if (txt_PlayerName.Text.Trim() == ""){
                MessageBox.Show("Please enter a name.");
            }
            else if (radioEasy.Checked){
                parent.difficultyLevel("Easy", txt_PlayerName.Text);
                parent.form2Exited = 1;
                this.Close();
            }
            else if (radioMedium.Checked){
                parent.difficultyLevel("Medium", txt_PlayerName.Text);
                parent.form2Exited = 1;
                this.Close();
            }
            else if (radioHard.Checked){ 
                parent.difficultyLevel("Hard", txt_PlayerName.Text);
                parent.form2Exited = 1;
                this.Close();
            }
            else{
                MessageBox.Show("Select a difficulty then press start.");
            }
        }



        // event handler for when form2 has closed 
        private void Form2_FormClosed(object sender, FormClosedEventArgs e)
        {
            // if difficulty was not set by user or form was closed by the x button,
            // flag a condition to close form1 upon load
            if (parent.form2Exited == -1) {
                parent.form2Exited = 0; 
            }
        }



    } // end of class. 

} // end of namespace. 
