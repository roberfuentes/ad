using System;
using System.Collections.Generic;
namespace CMySql
{
    public class Menu
    {
        private IList<string> labels = new List<string>();
        private bool exit = false;
        private string menuLabel;
        private IDictionary<string, Action> actions = new Dictionary<string, Action>();


        private Menu(string menulabel)
        {
            this.menuLabel = menulabel;
        }


        public static Menu Create(string menuLabel)
        {
            return new Menu(menuLabel);
        }


        public Menu Add(string label, Action action)
        {
            labels.Add(label);
            string option = label.Substring(0, 1).ToUpper();
            actions.Add(option, action);
            return this;
        }
        public Menu ExitWhen(string label)
        {
            labels.Add(label);
            string option = label.Substring(0, 1).ToUpper();
            actions.Add(option, () => exit = true);
            return this;

        }

        public void Loop()
        {
            //here do a loop to represent all of this.
            while (!exit)
            {
                foreach (string label in labels)
                    Console.WriteLine(label);
            
            string option = Console.ReadLine();

            if (actions.ContainsKey(option))
            {
                actions[option]();

            }
            else
            {
                Console.WriteLine("Opción inválida. Vuelve a introducir");
            }
            }
        }
    }
}