using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ListManagerApp
{
    public partial class Form1 : Form
    {
        // List to hold all of the names. 
        static List<String> names = new List<String>();
        // Create a binding source. 
        BindingSource namesBindingSource = new BindingSource();

        public Form1()
        {
            InitializeComponent();

            // Testing. Put some names in the list to start.
            /*names.Add("Adam");
            names.Add("Denise");
            names.Add("Charity");*/ 
        }

        internal void receiveData(string newName)
        {
            names.Add(newName);
            // MessageBox.Show("Item count = " + names.Count); 
        }

        private void btn_add_Click(object sender, EventArgs e)
        {
            // Form 1 opens form 2 when add button is clicked.
            Form2 f2 = new Form2();
            /*f2.Show(); */
            f2.ShowDialog(); 
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // Add the names of the listbox.

            // Set the data source for the binding. 
            namesBindingSource.DataSource = names;

            // Set the binding to the listbox. 
            listBox.DataSource = namesBindingSource; 
        }

        private void Form1_Activated(object sender, EventArgs e)
        {
            // Occurs whenever the form regains focus. Comes back to the foreground.

            namesBindingSource.ResetBindings(false); 
        }

        private void listBox_Click(object sender, EventArgs e)
        {
            // What is sender? 
            // MessageBox.Show(sender.ToString()); 
            // MessageBox.Show("You clicked item # " + (listBox.SelectedIndex + 1)); 
            int i = listBox.SelectedIndex;
            if (i >= 0)
            {
                DialogResult result = MessageBox.Show("Would you like to delete " + names[i] + "?", "Confirm Delete", MessageBoxButtons.YesNo); 
                if (result == DialogResult.Yes)
                {
                    names.RemoveAt(i);
                    namesBindingSource.ResetBindings(false); 
                }
            }
        }

        private void comboBox_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (comboBox.SelectedItem == "a -> z")
            {
                names.Sort();
            }
            else if (comboBox.SelectedItem == "z -> a")
            {
                names.Sort();
                names.Reverse();
            }
            namesBindingSource.ResetBindings(false);
        }
    }
}

/*
 * In this Project we learned:
 * 1) We looked at the ListBox control
 * 2) We have to work on a static data source so that it would work from one instance to another. 
 * 3) We did our own custom dialog box. 
 * 4) We also worked on binding sources. 
 * 5) We did show and hide forms. 
 * 6) We were able to send data from one form to another. 
 * 7) We sorted the lists.
 * 8) We also did deleting items with message boxes. 
 */
