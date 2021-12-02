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
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void btn_ok_Click(object sender, EventArgs e)
        {
            // Close form 2 and show form 1.
            Form1 f1 = new Form1();
            // f1.Show();

            f1.receiveData(textBox.Text); 

            // this referse to form 2. 
            this.Close();
        }
    }
}
