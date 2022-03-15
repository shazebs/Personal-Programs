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
        Form1 parent; /* to hold form 1 object */ 



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

            /* console log */
            Console.WriteLine("\nHello from form2 load function\n"); 
        }



        // start game - button click event handler 
        private void btn_startgame_Click(object sender, EventArgs e)
        {
            /* send difficulty level value from form2 to form1 */
            if (radioEasy.Checked){
                parent.difficultyLevel("Easy");
                parent.form2Exited = 1;
            }
            else if (radioMedium.Checked){
                parent.difficultyLevel("Medium");
                parent.form2Exited = 1;
            }
            else if (radioHard.Checked){ 
                parent.difficultyLevel("Hard");
                parent.form2Exited = 1;
            }
            // close this form 2
            this.Close();
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

    }
}
