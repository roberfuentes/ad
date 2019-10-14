using System;
using System.Reflection;

namespace CReflexion
{
    class MainClass
    {
        public static void Main(string[] args)
        {


            Categoria c = new Categoria(5, "Cat 5");
            //Console.WriteLine("c.Id={0} c.Nombre={1}", c.Id, c.Nombre);

            show(c, "Id", "Nombre");
        }

        private static void show(object obj, params string[] propertyNames)
        {
            foreach (string propertyName in propertyNames)
            {
                Console.WriteLine("Name = {0}, Value = {1}",
                    propertyName, obj.GetType().GetProperty(propertyName).GetValue(obj));
            }
        }
    }
}
