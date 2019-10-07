using System;
using System.Data;
using MySql.Data.MySqlClient;
using Serpis.Ad;
namespace CMySql
{


    class MainClass
    {
        private static IDbConnection dbConnection;
        public static void Main(string[] args)
        {
            dbConnection = new MySqlConnection(
           "server=localhost;database=dbprueba;uid=root;pwd=sistemas;ssl-mode=none"
               );
           dbConnection.Open();


           /*insertValue();
           showAll();
           ShowMetaInfo();*/
           /*int choice = numOption();
           doSql(choice);*/


            //dbConnection.Close();

            Menu.Create("Elija usted una opción")
            .Add("1, Nuevo", nuevo)
            .Add("2, Editar", editar)
            .Add("3, Borrar", borrar)
            .Add("4, Consultar", consultar).Loop();

        }

        private static void nuevo()
        {
            Console.WriteLine("Nuevo");
            insertValue();


        }
        private static void editar()
        {
            Console.WriteLine("editar");
            editValue();
        }
        private static void borrar()
        {
            Console.WriteLine("borrar");
            deleteValue();
        }
        private static void consultar()
        {
            Console.WriteLine("consultar");
            showAll();
        }

        public static void InsertValues()
        {

        }

        //Methods for categoria


        public static void insertValue()
        {
            IDbCommand dbCommand = dbConnection.CreateCommand();
            Console.Write("Nombre");
            string nombre = Console.ReadLine();
            dbCommand.CommandText = "insert into categoria (nombre) values (@nombre)";
            DbCommandHelper.AddParameter(dbCommand, "nombre", nombre);

            dbCommand.ExecuteNonQuery();
        }

        public static void editValue()
        {
            IDbCommand dbCommand = dbConnection.CreateCommand();
            Console.Write("ID: ");
            string id = Console.ReadLine();
            Console.Write("Nombre: ");
            string nombre = Console.ReadLine();
            dbCommand.CommandText = "update categoria set nombre='" + nombre + "' where id=" +id;
            dbCommand.ExecuteNonQuery();
        }

        public static void deleteValue()
        {
            IDbCommand dbCommand = dbConnection.CreateCommand();
            Console.Write("ID: ");
            string id = Console.ReadLine();
            dbCommand.CommandText = "DELETE FROM categoria WHERE id=" + id;
            dbCommand.ExecuteNonQuery();

        }

        public static void showAll()
        {

            //Primer paso (Get the query)
            IDbCommand dbCommand = dbConnection.CreateCommand();
            dbCommand.CommandText = "select * from categoria";
            IDataReader dataReader = dbCommand.ExecuteReader();


            while (dataReader.Read()) //While true
            {
                Console.WriteLine("id={0} nombre={1}", dataReader["id"], dataReader["nombre"]);
            }

            dataReader.Close();
        }


        /*public static void ShowMetaInfo()
        {
            IDbCommand dbCommand = dbConnection.CreateCommand();
            dbCommand.CommandText = "select * from categoria";
            IDataReader dataReader = dbCommand.ExecuteReader();

            Console.WriteLine("FieldCount={0}", dataReader.FieldCount);
            for (int i = 0; i < dataReader.FieldCount; i++)
            {
                Console.WriteLine("FieldCount={0} = {1} Type={2}", i, dataReader.GetName(i), dataReader.GetFieldType(i));
            }
            dataReader.Close();
        }*/
    }
}
