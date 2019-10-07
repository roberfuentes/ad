using System;
using System.Data;
using CGtk;
using MySql.Data.MySqlClient;
using MySql.Data;
namespace CGtk 
{ 


public partial class CategoriaWindow : Gtk.Window
    {
        public CategoriaWindow() :
                base(Gtk.WindowType.Toplevel)
        {
            this.Build();
            IDbConnection dbConnection;
            dbConnection = new MySqlConnection("server=localhost;database=dbprueba;uid=root;pwd=sistemas;ssl-mode=none"
            );

            dbConnection.Open();

            btnAceptar.Click += btnAceptarClick; // Can't pass dbConnection


        }

        public void btnAceptarClick(object sender, EventArgs e, IDbConnection dbConnection)
        {
            string nameData = entryName.Text;
            if(nameData != "")
            {
                IDbCommand dbCommand = dbConnection.CreateCommand();
                Console.Write("Nombre");
                string nombre = Console.ReadLine();
                dbCommand.CommandText = "insert into categoria (nombre) values (@nombre)";
                DbCommandHelper.AddParameter(dbCommand, "nombre", nombre); //DbCOmmandHelper what's going on??

                dbCommand.ExecuteNonQuery();
            }
        }
    }
}
