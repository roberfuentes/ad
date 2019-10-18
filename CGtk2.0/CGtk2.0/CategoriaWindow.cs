using System;
using System.Data;
using MySql.Data.MySqlClient;
namespace CGtk2
{
    public partial class CategoriaWindow : Gtk.Window
    {
        public static string name = "";
        public CategoriaWindow() :
                base(Gtk.WindowType.Toplevel)

        {
            this.Build();

            buttonAceptar.Clicked += (sender, e) => CategoriaWindow.SendVariable(entryName.Text);
            /*treeView.AppendColumn("id", new CellRendererText(), "text", 0);
            treeView.AppendColumn("nombre", new CellRendererText(), "text", 1);
            ListStore listStore = new ListStore(typeof(ulong), typeof(string));
            MainWindow.ShowAll(treeView, listStore);*/




        }


        public static void SendVariable(String e)
        {
            Console.WriteLine(e);
            if(e != null)
            {
                Console.WriteLine("sending");
                name = e;

            }

        }
        /*public static void InsertValue()
        {

            IDbCommand dbCommand = dbConnection.CreateCommand();
            Console.Write("Nombre");
            string nombre = Console.ReadLine();
            dbCommand.CommandText = "insert into categoria (nombre) values (@nombre)";
            DbCommandHelper.AddParameter(dbCommand, "nombre", nombre);

            dbCommand.ExecuteNonQuery();
        }*/
    }
}
