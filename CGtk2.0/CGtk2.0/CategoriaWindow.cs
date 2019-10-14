using System;
using System.Data;
using MySql.Data.MySqlClient;
namespace CGtk2
{
    public partial class CategoriaWindow : Gtk.Window
    {
        public CategoriaWindow() :
                base(Gtk.WindowType.Toplevel)
        {
            this.Build();

            buttonAceptar.Clicked += new EventHandler(SendVariable);




        }


        protected void SendVariable(Object sender, EventArgs e)
        {
            if(entryName.Text != null)
            {
                Name = entryName.Text;
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
