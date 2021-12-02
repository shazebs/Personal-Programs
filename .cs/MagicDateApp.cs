using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Magic_Date_App
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void dateTimePicker_ValueChanged(object sender, EventArgs e)
        {
            // Create a date time object. 
            DateTime moment = dateTimePicker.Value;

            // create an int variable to hold the value of year
            int year = moment.Year;
            // set the year text 
            lbl_YearOutput.Text = year.ToString();

            // create an int variable to hold value of month
            int month = moment.Month;
            // set the month text 
            lbl_MonthOutput.Text = month.ToString();

            // create an int variable to hold the value of day
            int day = moment.Day;
            // set the day text 
            lbl_DayOutput.Text = day.ToString();

            // create an int value to hold sum of month and day
            int sum = (month + day); 
            // display sum output
            lbl_SumOutput.Text = sum.ToString();

            // if magic number, print success message. 
            if (sum.ToString() == getLastTwoDigits(year))
            {
                lbl_MagicNumber.Text = "You found a Magic Number!";
            }
            // Default output if not magic number. 
            else
            {
                lbl_MagicNumber.Text = moment.ToString();
            }

        }

        // Get last two digits of the year. 
        public static String getLastTwoDigits(int value)
        {
            // create a string value to return.
            string year = value.ToString();
            // get the string value via substring. 
            year = year.Substring(year.Length - 2);
            // return the string value. 
            return year;
        }

    }
}
