using System;
using MySql.Data.MySqlClient;
using Gtk;

namespace CGtk2
{
    class MainClass
    {

        public static void Main(string[] args)
        {
            Application.Init();
            MainWindow win = new MainWindow();
            win.Show();
            Application.Run();
        }
    }
}
