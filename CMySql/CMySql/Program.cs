using System;
using System.Data;
using MySql.Data.MySqlClient;
using Serpis.Ad;



class MainClass
    {
    private static IDbConnection dbConnection;
    public static void Main(string[] args)
        {
         dbConnection = new MySqlConnection(
        "server=localhost;database=dbprueba;uid=root;pwd=sistemas;ssl-mode=none"
            );
        dbConnection.Open();


        insertValue();
        showAll();
        ShowMetaInfo();
        /*int choice = numOption();
        doSql(choice);*/


        dbConnection.Close();

    }





    





    //Methods
    /*public static int numOption()
    {

        Console.WriteLine("Que opción quieres?\n0.Salir\n1.Nuevo\n2.Editar\n3.Borrar\n4.Consultar\n5.Listar");
        return Convert.ToInt32(Console.ReadLine());

    }
    //IdbDataParameter , parametername
    public static void doSql(int choice)
    {
        switch (choice)
        {
            case 0:
                InsertValues();
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }*/

    public static void InsertValues()
    {

    }





    //Methods for categoria
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

    public static void insertValue()
    {
        IDbCommand dbCommand = dbConnection.CreateCommand();
        Console.Write("Nombre");
        string nombre = Console.ReadLine();
        dbCommand.CommandText = "insert into categoria (nombre) values (@nombre)";
        DbCommandHelper.AddParameter(dbCommand, "nombre", nombre);

        dbCommand.ExecuteNonQuery();
    }


    public static void ShowMetaInfo()
    {
        IDbCommand dbCommand = dbConnection.CreateCommand();
        dbCommand.CommandText = "select * from categoria";
        IDataReader dataReader = dbCommand.ExecuteReader();

        Console.WriteLine("FieldCount={0}", dataReader.FieldCount);
        for(int i=0; i < dataReader.FieldCount; i++)
        {
            Console.WriteLine("FieldCount={0} = {1} Type={2}", i, dataReader.GetName(i), dataReader.GetFieldType(i));
        }
        dataReader.Close();
    }
}

