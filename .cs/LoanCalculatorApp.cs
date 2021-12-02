using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace LoanCalculator
{
    public partial class Form1 : Form
    {
        // Declare Variables.
        decimal loan_amount = 0.00m;
        int number_of_months = 0;
        decimal interest_rate = 0.005m;

        public Form1()
        {
            InitializeComponent();
        }

        private void btn_calculate_Click(object sender, EventArgs e)
        {
            // method 1 of parsing 
            // assign new values to the variables.
            /*
            try { 
                // parse the loan amount 
                loan_amount = decimal.Parse(txt_loanAmount.Text); 
                // parse the number of months 
                number_of_months = int.Parse(txt_numberOfMonths.Text);
                // parse the interest rate 
                interest_rate = decimal.Parse(txt_interestRate.Text);
            }
            // error handling block 
            catch {
                // print an error message if user enters input other than numbers.
                MessageBox.Show("Please enter only numbers."); 
            } */


            // method 2 of parsing 
            if (decimal.TryParse(txt_loanAmount.Text, out loan_amount))
            {
                if (int.TryParse(txt_numberOfMonths.Text, out number_of_months))
                {
                    if (decimal.TryParse(txt_interestRate.Text, out interest_rate))
                    {
                        // success, all three values are correctly assigned.

                        // calculate the loan

                        int counter = 0;
                        while (counter < number_of_months)
                        {
                            loan_amount = loan_amount + (loan_amount * interest_rate);
                            listBox1.Items.Add("At month " + counter + " the loan is " + loan_amount.ToString("c"));
                            counter = counter + 1; 
                        }

                        // done with the while loop
                        txt_finalValue.Text = loan_amount.ToString("c");
                    }
                }
            }
        }

        private void btn_clear_Click(object sender, EventArgs e)
        {
            // clear all text values. 
            txt_finalValue.Text = "";
            txt_interestRate.Text = "";
            txt_loanAmount.Text = "";
            txt_numberOfMonths.Text = "";
            listBox1.Items.Clear();
        }

        private void btn_exit_Click(object sender, EventArgs e)
        {
            // terminate the form app. 
            this.Close();
        }
    }
}
