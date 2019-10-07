
// This file has been generated by the GUI designer. Do not modify.

public partial class MainWindow
{
	private global::Gtk.UIManager UIManager;

	private global::Gtk.Action newAction;

	private global::Gtk.Action editAction;

	private global::Gtk.Action deleteAction;

	private global::Gtk.Action refreshAction;

	private global::Gtk.Action stopAction;

	private global::Gtk.VBox vBox;

	private global::Gtk.Toolbar toolbar1;

	private global::Gtk.ScrolledWindow GtkScrolledWindow;

	private global::Gtk.TreeView treeView;

	protected virtual void Build()
	{
		global::Stetic.Gui.Initialize(this);
		// Widget MainWindow
		this.UIManager = new global::Gtk.UIManager();
		global::Gtk.ActionGroup w1 = new global::Gtk.ActionGroup("Default");
		this.newAction = new global::Gtk.Action("newAction", null, null, "gtk-new");
		w1.Add(this.newAction, null);
		this.editAction = new global::Gtk.Action("editAction", null, null, "gtk-edit");
		w1.Add(this.editAction, null);
		this.deleteAction = new global::Gtk.Action("deleteAction", null, null, "gtk-delete");
		w1.Add(this.deleteAction, null);
		this.refreshAction = new global::Gtk.Action("refreshAction", null, null, "gtk-refresh");
		w1.Add(this.refreshAction, null);
		this.stopAction = new global::Gtk.Action("stopAction", null, null, "gtk-stop");
		w1.Add(this.stopAction, null);
		this.UIManager.InsertActionGroup(w1, 0);
		this.AddAccelGroup(this.UIManager.AccelGroup);
		this.Name = "MainWindow";
		this.Title = global::Mono.Unix.Catalog.GetString("MainWindow");
		this.WindowPosition = ((global::Gtk.WindowPosition)(4));
		// Container child MainWindow.Gtk.Container+ContainerChild
		this.vBox = new global::Gtk.VBox();
		this.vBox.Name = "vBox";
		this.vBox.Spacing = 6;
		// Container child vBox.Gtk.Box+BoxChild
		this.UIManager.AddUiFromString(@"<ui><toolbar name='toolbar1'><toolitem name='newAction' action='newAction'/><toolitem name='editAction' action='editAction'/><toolitem name='deleteAction' action='deleteAction'/><toolitem name='refreshAction' action='refreshAction'/><toolitem name='stopAction' action='stopAction'/></toolbar></ui>");
		this.toolbar1 = ((global::Gtk.Toolbar)(this.UIManager.GetWidget("/toolbar1")));
		this.toolbar1.Name = "toolbar1";
		this.toolbar1.ShowArrow = false;
		this.vBox.Add(this.toolbar1);
		global::Gtk.Box.BoxChild w2 = ((global::Gtk.Box.BoxChild)(this.vBox[this.toolbar1]));
		w2.Position = 0;
		w2.Expand = false;
		w2.Fill = false;
		// Container child vBox.Gtk.Box+BoxChild
		this.GtkScrolledWindow = new global::Gtk.ScrolledWindow();
		this.GtkScrolledWindow.Name = "GtkScrolledWindow";
		this.GtkScrolledWindow.ShadowType = ((global::Gtk.ShadowType)(1));
		// Container child GtkScrolledWindow.Gtk.Container+ContainerChild
		this.treeView = new global::Gtk.TreeView();
		this.treeView.CanFocus = true;
		this.treeView.Name = "treeView";
		this.GtkScrolledWindow.Add(this.treeView);
		this.vBox.Add(this.GtkScrolledWindow);
		global::Gtk.Box.BoxChild w4 = ((global::Gtk.Box.BoxChild)(this.vBox[this.GtkScrolledWindow]));
		w4.Position = 1;
		this.Add(this.vBox);
		if ((this.Child != null))
		{
			this.Child.ShowAll();
		}
		this.DefaultWidth = 416;
		this.DefaultHeight = 300;
		this.Show();
		this.DeleteEvent += new global::Gtk.DeleteEventHandler(this.OnDeleteEvent);
	}
}
