package gj.ui;

import gj.ui.swing.custom.JCalendar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.Calendar;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class TreePane extends JSplitPane {
	private static MyTree currentTree;

	private MyTree tree;
	private JScrollPane scroll;
	private JCalendar calendar;

	public TreePane(String rootText) {
		super(JSplitPane.VERTICAL_SPLIT);
		this.setMinimumSize(new Dimension(210, 200));

		// Create the tree.

		buildTree(rootText);
		// Add the tree to a scroll pane.
		scroll = new JScrollPane(tree);
		calendar = new JCalendar(Calendar.MONDAY);
		calendar.setPreIcon(IconManager.getIcon("left-arrow.png"));
		calendar.setNextIcon(IconManager.getIcon("right-arrow.png"));
		calendar.setTodayIcon(IconManager.getIcon("now.png"));
		this.setLeftComponent(calendar);
		this.setRightComponent(scroll);
	}

	private void buildTree(String rootText) {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootText);
		DefaultMutableTreeNode first = new DefaultMutableTreeNode("New "+rootText+" Node");
		root.add(first);
		
		tree = new MyTree(root);
//		tree.putClientProperty("JTree.lineStyle", "Angled");
		tree.setShowsRootHandles(true);
		tree.setExpandsSelectedPaths(true);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setEditable(true);
		
		selectNode(tree,first);
	}
	
	protected static void selectNode(MyTree tree,TreeNode node){
		DefaultTreeModel model=(DefaultTreeModel)tree.getModel();
		TreePath path = new TreePath(model.getPathToRoot(node));
		tree.setSelectionPath(path);
	}
	
	protected static void selectNode(MyTree tree,TreeNode node,DefaultTreeModel model){
		TreePath path = new TreePath(model.getPathToRoot(node));
		tree.setSelectionPath(path);
	}

	public static void onNewNode(ActionEvent e) {
		if(currentTree==null||currentTree.isLoading())return;
		
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) currentTree
				.getLastSelectedPathComponent();

		DefaultTreeModel model=(DefaultTreeModel)currentTree.getModel();
		
		if (selectedNode == null){
			Object root=model.getRoot();
			if(root==null){
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("New");
				model.setRoot(newNode);
				return;
			}else{
				TreePath path = new TreePath(model.getPathToRoot((TreeNode)root));
				currentTree.setSelectionPath(path);
				selectedNode=(DefaultMutableTreeNode)root;
			}
		}

		DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectedNode.getParent();

		if (parent == null){
			onNewSubNode(e);
			return;
		}

		DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("New");

		int selectedIndex = parent.getIndex(selectedNode);
		
		
		model.insertNodeInto(newNode, parent, selectedIndex + 1);

		TreeNode[] nodes = model.getPathToRoot(newNode);
		TreePath path = new TreePath(nodes);
		currentTree.scrollPathToVisible(path);
	}

	public static void onNewSubNode(ActionEvent e) {
		if(currentTree==null||currentTree.isLoading())return;
		
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) currentTree
				.getLastSelectedPathComponent();

		if (selectedNode == null)
			return;
		
		DefaultTreeModel model=(DefaultTreeModel)currentTree.getModel();

		DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("New");
		model.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());

		// now display new node

		TreeNode[] nodes = model.getPathToRoot(newNode);
		TreePath path = new TreePath(nodes);
		currentTree.scrollPathToVisible(path);
		
	}

	public static void onDeleteNode(ActionEvent e) {
		if(currentTree==null||currentTree.isLoading())return;
		
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) currentTree
				.getLastSelectedPathComponent();

		if (selectedNode != null && selectedNode.getParent() != null){
			DefaultTreeModel model=(DefaultTreeModel)currentTree.getModel();			
			model.removeNodeFromParent(selectedNode);
		}
	}

	public static MyTree getCurrentTree() {
		return currentTree;
	}

	public void onActivate() {
		currentTree=this.tree;
		if(!currentTree.isLoaded()){
			currentTree.load();
		}
	}
}

class MyTree extends JTree{
	protected boolean loaded=false;
	protected boolean loading=false;
	
	public MyTree(DefaultMutableTreeNode root) {
		super(root);
	}

	public void load() {
		// TODO Auto-generated method stub
		
	}

	public boolean isLoaded() {
		return loaded;
	}

	public boolean isLoading(){
		return loading;
	}
}
