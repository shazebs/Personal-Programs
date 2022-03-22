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

namespace People_i_Know_gui
{
    public partial class Form1 : Form
    {
        List<Person> people = new List<Person>(); 

        public Form1()
        {
            InitializeComponent();
        }

        private void btn_AddToList_Click(object sender, EventArgs e)
        {
            // check to make sure no input field was left empty
            Person noob = new Person(txt_FirstName.Text, txt_LastName.Text, txt_URL.Text); 

            if (noob.firstname.Trim() == "" || noob.lastname.Trim() == "" || noob.url.Trim() == "")
                MessageBox.Show("Error!\nNo input field can be left blank."); 
            else
            {
                people.Add(noob); 

                // add item to list box 
                listBox.Items.Add($"{noob.firstname} | {noob.lastname} | {noob.url}");

                // clear input fields
                txt_FirstName.Text = ""; 
                txt_LastName.Text = ""; 
                txt_URL.Text = ""; 
            }
        }

        private void btn_SaveToFile_Click(object sender, EventArgs e)
        {
            List<String> lines = new List<String>(); 
            string saveFilePath = @"S:\PROGRAMMING\C_Sharp_Code_Files\CST-250\People_i_Know_gui\savedFile.txt";

            foreach (Person p in people)
                lines.Add($"{p.firstname} | {p.lastname} | {p.url}"); 

            if (people.Count == 0)
                MessageBox.Show("List is empty.\nNo file will be saved."); 
            else
            {
                File.WriteAllLines(saveFilePath, lines);
                MessageBox.Show("File was successfully saved!"); 
            }
        }

        private void btn_LoadFromFile_Click(object sender, EventArgs e)
        {
            if (people.Count != 0) people.Clear();
            listBox.Items.Clear(); 

            string filePath = @"S:\PROGRAMMING\C_Sharp_Code_Files\CST-250\People_i_Know_gui\loadFile.txt"; 
            List<String> lines = File.ReadAllLines(filePath).ToList();

            List<int> errors = new List<int>(); 

            int rep = -1; 
            foreach (String line in lines)
            {
                rep++; 
                try
                {
                    string[] tokens = line.Split(',', '|');

                    Person noob = new Person(tokens[0], tokens[1], tokens[2]);

                    people.Add(noob);

                    listBox.Items.Add($"{noob.firstname} | {noob.lastname} | {noob.url}");
                }
                catch (Exception error)
                {
                    Console.WriteLine($"Index {rep} contained data in an incorrect format, it was skipped over in loading.");
                    errors.Add(rep); 
                }
            }

            if (errors.Count > 0)
            {
                String line = "";
                foreach (int i in errors)
                {
                    line += $"#{i}\n"; 
                }
                MessageBox.Show("File was loaded successfully however,\nthe following line(s) were not added because format is incorrect:\n\n" + line);
            }
            MessageBox.Show("File was successfully loaded.");
        }
    }
}
