using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MyFriendsList
{
    public partial class Form1 : Form
    {
        // Declare Variables.
        // list container
        List<String> myFriends = new List<String>();
        BindingSource bs = new BindingSource();

        public Form1()
        {
            InitializeComponent();
            // intermediate binding source 
            bs.DataSource = myFriends;
        }

        private void btn_Add_Click(object sender, EventArgs e)
        {
            // add an item to the list container. 
            myFriends.Add(txt_newFriend.Text);
            listBox1.DataSource = bs;
            bs.ResetBindings(false); // not changing from string type
            label1.Text = ("There are " + myFriends.Count + 
                " people in the list");
        }

        private void Add_5_Friends_Click(object sender, EventArgs e)
        {
            listBox1.DataSource = bs;
            // 5 friends 
            myFriends.Add("Kerena");
            myFriends.Add("Sam");
            myFriends.Add("Thomas");
            myFriends.Add("Joseph & Joseph");
            myFriends.Add("Sonny & Sal");
            // ... 
            label1.Text = ("There are " + myFriends.Count +
                " people in the list");
            bs.ResetBindings(false);
        }

        private void btn_sortAscending_Click(object sender, EventArgs e)
        {
            // sort in ascending order method demonstration
            myFriends.Sort();
            bs.ResetBindings(false);
        }

        private void btn_sortDescending_Click(object sender, EventArgs e)
        {
            // sort in reverse order method demonstration
            myFriends.Sort();
            myFriends.Reverse();
            bs.ResetBindings(false);
        }

        private void btn_clear_Click(object sender, EventArgs e)
        {
            // clear all items 
            myFriends.Clear();
            txt_newFriend.Clear();
            label1.Text = "";
            bs.ResetBindings(false);
        }
    }
}
