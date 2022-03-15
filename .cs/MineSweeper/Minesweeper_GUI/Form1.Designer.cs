
namespace Minesweeper_GUI
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.gamePanel = new System.Windows.Forms.Panel();
            this.btn_startgame = new System.Windows.Forms.Button();
            this.lbl_WinLoss = new System.Windows.Forms.Label();
            this.lbl_Score = new System.Windows.Forms.Label();
            this.lbl_TotalClicks = new System.Windows.Forms.Label();
            this.btn_Exit = new System.Windows.Forms.Button();
            this.lbl_TotalScore = new System.Windows.Forms.Label();
            this.timer = new System.Windows.Forms.Timer(this.components);
            this.lbl_Time = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // gamePanel
            // 
            this.gamePanel.Location = new System.Drawing.Point(16, 3);
            this.gamePanel.Margin = new System.Windows.Forms.Padding(4);
            this.gamePanel.Name = "gamePanel";
            this.gamePanel.Size = new System.Drawing.Size(1215, 1213);
            this.gamePanel.TabIndex = 0;
            // 
            // btn_startgame
            // 
            this.btn_startgame.BackColor = System.Drawing.Color.YellowGreen;
            this.btn_startgame.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_startgame.Location = new System.Drawing.Point(1292, 1040);
            this.btn_startgame.Margin = new System.Windows.Forms.Padding(4);
            this.btn_startgame.Name = "btn_startgame";
            this.btn_startgame.Size = new System.Drawing.Size(356, 73);
            this.btn_startgame.TabIndex = 5;
            this.btn_startgame.Text = "Start New Game";
            this.btn_startgame.UseVisualStyleBackColor = false;
            this.btn_startgame.Click += new System.EventHandler(this.btn_startgame_Click);
            // 
            // lbl_WinLoss
            // 
            this.lbl_WinLoss.AutoSize = true;
            this.lbl_WinLoss.BackColor = System.Drawing.Color.Transparent;
            this.lbl_WinLoss.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbl_WinLoss.Location = new System.Drawing.Point(1315, 181);
            this.lbl_WinLoss.Name = "lbl_WinLoss";
            this.lbl_WinLoss.Size = new System.Drawing.Size(0, 48);
            this.lbl_WinLoss.TabIndex = 6;
            // 
            // lbl_Score
            // 
            this.lbl_Score.AutoSize = true;
            this.lbl_Score.BackColor = System.Drawing.Color.Black;
            this.lbl_Score.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.14286F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbl_Score.ForeColor = System.Drawing.Color.White;
            this.lbl_Score.Location = new System.Drawing.Point(1271, 347);
            this.lbl_Score.Name = "lbl_Score";
            this.lbl_Score.Size = new System.Drawing.Size(115, 39);
            this.lbl_Score.TabIndex = 7;
            this.lbl_Score.Text = "Score:";
            // 
            // lbl_TotalClicks
            // 
            this.lbl_TotalClicks.AutoSize = true;
            this.lbl_TotalClicks.BackColor = System.Drawing.Color.Black;
            this.lbl_TotalClicks.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.14286F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbl_TotalClicks.ForeColor = System.Drawing.Color.White;
            this.lbl_TotalClicks.Location = new System.Drawing.Point(1271, 413);
            this.lbl_TotalClicks.Name = "lbl_TotalClicks";
            this.lbl_TotalClicks.Size = new System.Drawing.Size(203, 39);
            this.lbl_TotalClicks.TabIndex = 8;
            this.lbl_TotalClicks.Text = "Total Clicks:";
            // 
            // btn_Exit
            // 
            this.btn_Exit.BackColor = System.Drawing.Color.IndianRed;
            this.btn_Exit.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_Exit.Location = new System.Drawing.Point(1358, 1132);
            this.btn_Exit.Margin = new System.Windows.Forms.Padding(4);
            this.btn_Exit.Name = "btn_Exit";
            this.btn_Exit.Size = new System.Drawing.Size(224, 73);
            this.btn_Exit.TabIndex = 9;
            this.btn_Exit.Text = "Exit Game";
            this.btn_Exit.UseVisualStyleBackColor = false;
            this.btn_Exit.Click += new System.EventHandler(this.btn_Exit_Click);
            // 
            // lbl_TotalScore
            // 
            this.lbl_TotalScore.AutoSize = true;
            this.lbl_TotalScore.BackColor = System.Drawing.Color.Transparent;
            this.lbl_TotalScore.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.lbl_TotalScore.Font = new System.Drawing.Font("Microsoft Sans Serif", 24F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbl_TotalScore.ForeColor = System.Drawing.Color.DodgerBlue;
            this.lbl_TotalScore.Location = new System.Drawing.Point(1418, 273);
            this.lbl_TotalScore.Name = "lbl_TotalScore";
            this.lbl_TotalScore.Size = new System.Drawing.Size(0, 64);
            this.lbl_TotalScore.TabIndex = 10;
            // 
            // timer
            // 
            this.timer.Enabled = true;
            this.timer.Tick += new System.EventHandler(this.timer_Tick);
            // 
            // lbl_Time
            // 
            this.lbl_Time.AutoSize = true;
            this.lbl_Time.BackColor = System.Drawing.Color.Black;
            this.lbl_Time.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.14286F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbl_Time.ForeColor = System.Drawing.Color.White;
            this.lbl_Time.Location = new System.Drawing.Point(1271, 488);
            this.lbl_Time.Name = "lbl_Time";
            this.lbl_Time.Size = new System.Drawing.Size(0, 39);
            this.lbl_Time.TabIndex = 11;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(11F, 24F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.BackgroundImage = global::Minesweeper_GUI.Properties.Resources.roswell_ufo;
            this.ClientSize = new System.Drawing.Size(1701, 1250);
            this.Controls.Add(this.lbl_Time);
            this.Controls.Add(this.lbl_TotalScore);
            this.Controls.Add(this.btn_Exit);
            this.Controls.Add(this.lbl_TotalClicks);
            this.Controls.Add(this.lbl_Score);
            this.Controls.Add(this.lbl_WinLoss);
            this.Controls.Add(this.btn_startgame);
            this.Controls.Add(this.gamePanel);
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Shazeb\'s Minesweeper-ReMake Game";
            this.Activated += new System.EventHandler(this.Form1_Activated);
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.Form1_FormClosing);
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Panel gamePanel;
        private System.Windows.Forms.Button btn_startgame;
        private System.Windows.Forms.Label lbl_WinLoss;
        private System.Windows.Forms.Label lbl_Score;
        private System.Windows.Forms.Label lbl_TotalClicks;
        private System.Windows.Forms.Button btn_Exit;
        private System.Windows.Forms.Label lbl_TotalScore;
        private System.Windows.Forms.Timer timer;
        private System.Windows.Forms.Label lbl_Time;
    }
}

