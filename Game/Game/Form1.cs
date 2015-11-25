using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Game
{

    public partial class Form1 : Form
    {
        private List<PictureBox> listOfTiles = new List<PictureBox>();

        private PictureBox[,] arrayOfTiles = new PictureBox[4,4];
        Random rnd = new Random();

        public Form1()
        {
            InitializeComponent();
        }


        private void button1_Click(object sender, EventArgs e)
        {
            foreach (var tile in listOfTiles)
            {
                tile.Left += 100;
            }
        }

        private void Form1_Load_1(object sender, EventArgs e)
        {
            //            listOfTiles.Add(Tile_1_1);
            //            listOfTiles.Add(Tile_1_2);
            //            listOfTiles.Add(Tile_1_3);
            //            listOfTiles.Add(Tile_1_4);
            //int i = 0;
            //int j = 0;
            //foreach (var pb in this.Controls.OfType<PictureBox>())
            //{
            //    listOfTiles.Add(pb);
            //    try
            //    {
            //        arrayOfTiles[j][i++] = pb;
            //    }
            //    catch (NullReferenceException ex)
            //    {

            //    }


            //    if (i == 4)
            //    {
            //        j++;
            //        i = 0;
            //    }
            //    pb.Click += new EventHandler(Tile_Click);
            //}
            createTileSet(6, 1);
        }

        private void Tile_Click(object sender, EventArgs e)
        {
            PictureBox tile = sender as PictureBox;

            if (tile != null)
            {
                tile.BackColor = Color.FromArgb(rnd.Next(255), rnd.Next(255), rnd.Next(255));
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            foreach (var tile in listOfTiles)
            {
                tile.Left -= 100;
            }
        }

        private void createTileSet(int verticalSize, int horizontalSize)
        {

            for (int i=0; i<verticalSize; i++)
                for (int j = 0; j < horizontalSize; j++)
                {
                    //Button pb = new Button();
                    PictureBox pb = new PictureBox();
                    //pb.Location = new Point(20, 30 * i + 10);
                    pb.Name = "Tileset_" + j + "_" + i;
                    pb.Visible = true;
                    pb.Location = new Point(100 * i, 100 * j);
                    pb.Size = new Size(100, 100);
                    pb.BackColor = Color.FromArgb(rnd.Next(255), rnd.Next(255), rnd.Next(255));
                    try
                    {
                        arrayOfTiles[j,i] = pb;
                    }
                    catch(Exception ex)
                    {

                    }
                    
                    pb.Click += new EventHandler(Tile_Click);
                    Controls.Add(pb);
                }
        }
    }
}
