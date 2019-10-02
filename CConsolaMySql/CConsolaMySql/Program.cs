using System;

namespace CConsolaMySql
{
    class MainClass
    {
        private static IDbConnection dbConnection;
        public static void Main(string[] args)
        {
            int choice = 0;

            Console.WriteLine("Que opción quieres?\n0.Salir\n1.Nuevo\n2.Editar\n3.Borrar\n4.Consultar\n5.Listar");
            choice = Convert.ToInt32(Console.ReadLine());

            switch (choice)
            {
                case 0:
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




        }
    }
}
