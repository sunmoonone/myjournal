package gj.ui;

import gj.ui.swing.custom.JCalendar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.Calendar;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.tree.TreeSelectionModel;

public class TreePane extends JSplitPane {
	private static GJTree currentTree;

	private GJTree tree;
	private JScrollPane scroll;
	private JCalendar calendar;

	public TreePane(String category) {
		super(JSplitPane.VERTICAL_SPLIT);
		this.setMinimumSize(new Dimension(210, 200));

		buildTree(category);
		scroll = new JScrollPane(tree);
		calendar = new JCalendar(Calendar.MONDAY);
		calendar.setPreIcon(IconManager.getIcon("left-arrow.png"));
		calendar.setNextIcon(IconManager.getIcon("right-arrow.png"));
		calendar.setTodayIcon(IconManager.getIcon("now.png"));
		this.setLeftComponent(calendar);
		this.setRightComponent(scroll);
	}

	private void buildTree(String category) {
		tree = GJTree.create(category);
		//tree.putClientProperty("JTree.lineStyle", "Angled");
		tree.setShowsRootHandles(true);
		tree.setExpandsSelectedPaths(true);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setEditable(true);
	}
	
	public static void onNewNode(ActionEvent e) {
		if(currentTree==null)return;
		currentTree.addNode();
	}

	public static void onNewSubNode(ActionEvent e) {
		if(currentTree==null)return;
		currentTree.addSubNode();
		
	}

	public static void onDeleteNode(ActionEvent e) {
		if(currentTree==null)return;
		currentTree.deleteNode();
	}

	public void onActivate() {
		currentTree=this.tree;
		if(!currentTree.isLoaded()){
			currentTree.load();
		}
	}
}

