using System;
using System.Data;
using MySql.Data.MySqlClient;
using Gtk;

using CGtk2;

public partial class MainWindow : Gtk.Window
{
    private static IDbConnection dbConnection;
    public MainWindow() : base(Gtk.WindowType.Toplevel)
    {
        Build();
        dbConnection = new MySqlConnection(
           "server=localhost;database=dbprueba;uid=root;pwd=sistemas;ssl-mode=none"
               );
        dbConnection.Open();

        treeView.AppendColumn("id", new CellRendererText(), "text", 0);
        treeView.AppendColumn("nombre", new CellRendererText(), "text", 1);
        ListStore listStore = new ListStore(typeof(ulong), typeof(string));
        ShowAll(treeView, listStore);



        refreshStateActions();
        treeView.Selection.Changed += (sender, e) => refreshStateActions();
        quitAction.Activated += (sender, e) => Application.Quit();
        newAction.Activated += (sender, e) => AddWindow();

    }

    private void AddWindow()
    {
        new CategoriaWindow();
    }

    protected void OnDeleteEvent(object sender, DeleteEventArgs a)
    {
        Application.Quit();
        a.RetVal = true;
    }

    private void refreshStateActions()
    {
        bool hasSelectedRows = treeView.Selection.CountSelectedRows() > 0;
        editAction.Sensitive = hasSelectedRows;
        deleteAction.Sensitive = hasSelectedRows;
    }

    public static void ShowAll(TreeView treeView, ListStore listStore)
    {
        //Primer paso (Get the query)
        IDbCommand dbCommand = dbConnection.CreateCommand();
        dbCommand.CommandText = "select * from categoria";
        IDataReader dataReader = dbCommand.ExecuteReader();


        while (dataReader.Read()) //While true
        {
            listStore.AppendValues(dataReader["id"], dataReader["nombre"]);
        }

        treeView.Model = listStore;

        dataReader.Close();
    }
}
