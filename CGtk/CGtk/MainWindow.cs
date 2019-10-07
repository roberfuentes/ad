using System;
using Gtk;
using CGtk;

public partial class MainWindow : Gtk.Window
{
    public MainWindow() : base(Gtk.WindowType.Toplevel)
    {
        Build();

        treeView.AppendColumn("id", new CellRendererText(), "text", 0);
        treeView.AppendColumn("nombre", new CellRendererText(), "text", 1);

        ListStore lStore = new ListStore(typeof(string), typeof(string));
        treeView.Model = lStore;
        lStore.AppendValues("1", "cat1");
        lStore.AppendValues("2", "cat2");

        newAction.Activated += (sender, e) => new CategoriaWindow();

    }

    protected void OnDeleteEvent(object sender, DeleteEventArgs a)
    {
        Application.Quit();
        a.RetVal = true;
    }
}
