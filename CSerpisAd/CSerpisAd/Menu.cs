using System;
using System.Collections.Generic;
namespace CSerpisAd
{
    public class Menu
    {
        public static Menu Create(string title)
        {
            return new Menu();
        }

        public Menu Add(string label, Action action)
        {
            return this
        }
        public Menu ExitWhen(string label)
        {
            return this;

        }

        public void Loop()
        {
            //here do a loop to represent all of this.
        }
    }
}
