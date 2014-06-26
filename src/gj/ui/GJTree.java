package gj.ui;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import gj.ui.controllers.TreeController;

import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class GJTree extends JTree implements TreeModelListener {
	private boolean loaded = false;
	private boolean loading = false;
	private DefaultTreeModel model;
	private String category;

	private GJTree(Node root, String category) {
		super(root);
		model = (DefaultTreeModel) treeModel;
		this.category = category;

		model.addTreeModelListener(this);
	}

	public static GJTree create(String category) {
		Node root = createNode(category);

		Node first = createNode(null, "New " + category + " Node");
		root.add(first);
		GJTree t = new GJTree(root, category);
		t.selectNode(first);
		return t;
	}

	private void selectNode(Node node) {
		TreePath path = new TreePath(model.getPathToRoot(node));
		this.setSelectionPath(path);
	}

	public synchronized void deleteNode() {
		if (this.isLoading())
			return;

		Node selectedNode = (Node) this.getLastSelectedPathComponent();

		if (selectedNode != null && selectedNode.getParent() != null) {
			model.removeNodeFromParent(selectedNode);
		}
		
		XMLEncoder out;
		try {
			out = new XMLEncoder(new FileOutputStream("target/tree.xml"));
			out.writeObject(model);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void addNode() {
		if (this.isLoading())
			return;

		Node selectedNode = (Node) this.getLastSelectedPathComponent();

		if (selectedNode == null) {
			Object root = model.getRoot();
			if (root == null) {
				model.setRoot(createNode(category));
				return;
			} else {
				TreePath path = new TreePath(model.getPathToRoot((TreeNode) root));
				this.setSelectionPath(path);
				selectedNode = (Node) root;
			}
		}

		Node parent = (Node) selectedNode.getParent();

		if (parent == null) {
			addSubNode();
			return;
		}

		Node newNode = createNode("New " + category + " Node");

		int selectedIndex = parent.getIndex(selectedNode);

		model.insertNodeInto(newNode, parent, selectedIndex + 1);

		TreeNode[] nodes = model.getPathToRoot(newNode);
		TreePath path = new TreePath(nodes);
		this.scrollPathToVisible(path);
	}

	public synchronized void addSubNode() {
		if (this.isLoading())
			return;

		Node selectedNode = (Node) this.getLastSelectedPathComponent();

		if (selectedNode == null)
			return;

		Node newNode = createNode("New " + category + " Node");
		model.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());

		TreeNode[] nodes = model.getPathToRoot(newNode);
		TreePath path = new TreePath(nodes);
		this.scrollPathToVisible(path);

	}

	public static Node createNode(Integer id, String text) {
		return new Node(new UserObject(id, text));
	}

	private static Node createNode(String text) {
		return new Node(new UserObject(null, text));
	}

	public synchronized void load() {
		this.loading = true;
		TreeController.load(this, this.category);
		
		XMLDecoder in;
		try {
			in = new XMLDecoder(new FileInputStream("target/tree.xml"));
			DefaultTreeModel m = (DefaultTreeModel) in.readObject();
			this.setModel(m);
			model=m;
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.loading = false;
		this.loaded = true;
	}

	public synchronized boolean isLoaded() {
		return loaded;
	}

	public synchronized boolean isLoading() {
		return loading;
	}

	public static class UserObject {
		private Integer id;
		private String text;

		public UserObject(){
			
		}
		
		public UserObject(Integer id, String text) {
			this.id = id;
			this.text = text;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String toString() {
			return text;
		}
	}

	@Override
	public void treeNodesChanged(TreeModelEvent e) {
		Node root = (Node) e.getTreePath().getLastPathComponent();
		if (e.getChildIndices() == null) {
			// edit root node
			TreeController.updateNode(root, root);
		} else {
			// edit this node:
			TreeController.updateNode(root, (Node) e.getChildren()[0]);
		}
	}

	@Override
	public void treeNodesInserted(TreeModelEvent e) {
		// TODO Auto-generated method stub
		// inserted nodes : e.getChildren()
		// parent node: e.getTreePath().getLastPathComponent();
		TreeController.insertNode((Node) e.getTreePath().getLastPathComponent(),
				(Node) e.getChildren()[0]);
	}

	@Override
	public void treeNodesRemoved(TreeModelEvent e) {
		// TODO Auto-generated method stub
		// removed nodes: e.getChildren()
		// parent node: e.getTreePath().getLastPathComponent();
		TreeController.deleteNode((Node) e.getTreePath().getLastPathComponent(),
				(Node) e.getChildren()[0]);
	}

	@Override
	public void treeStructureChanged(TreeModelEvent e) {
		// TODO Auto-generated method stub

	}

	public static class Node extends DefaultMutableTreeNode {
		public Node(){
			super();
		}
		//private Integer contentId;
		public Node(UserObject nodeUserObject) {
			super(nodeUserObject);
		}

		public void setUserObject(Object userObject) {
			if (userObject.getClass() != UserObject.class) {
				this.userObject = new UserObject(null, userObject == null ? null
						: userObject.toString());
			} else {
				this.userObject = userObject;
			}
		}
	}
}
