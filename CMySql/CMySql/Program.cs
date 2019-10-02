using System;
using System.Data;
using MySql.Data.MySqlClient;


class MainClass
    {
    private static IDbConnection dbConnection;
    public static void Main(string[] args)
        {
         dbConnection = new MySqlConnection(
        "server=localhost;database=dbprueba;uid=root;pwd=sistemas;ssl-mode=none"
            );
        dbConnection.Open();

        int choice = 0;
        Console.WriteLine("What do you want to do?");
        choice = Convert.ToInt32(Console.ReadLine());


        switch (choice)
        {

            case 0:

                break;

            case 1:
                break;
            


        }





        //ShowMetaInfo();
        //insertValue();
        //showAll();

        //Segundo paso



        dbConnection.Close();

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
        string nombre = "nuevo" + DateTime.Now;
        dbCommand.CommandText = String.Format("insert into categoria (nombre) values ('{0}')", nombre);
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

