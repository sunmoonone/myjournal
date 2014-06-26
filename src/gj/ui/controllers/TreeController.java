package gj.ui.controllers;

import org.apache.log4j.Logger;

import gj.ui.GJTree;

public class TreeController extends GJController{
	final private static Logger logger=Logger.getLogger(TreeController.class);
	
	public static void load(GJTree gjTree, String category) {
		//get data
		//if data rebuild tree
		logger.info("load");
	}

	public static void updateNode(GJTree.Node parent,
			GJTree.Node node) {
		// TODO Auto-generated method stub
		GJTree.UserObject obj=(GJTree.UserObject)node.getUserObject();
		logger.info("update:"+obj.getId()+" , "+obj.getText());
	}

	public static void insertNode(GJTree.Node parent,
			GJTree.Node node) {
		// TODO Auto-generated method stub
		GJTree.UserObject obj=(GJTree.UserObject)node.getUserObject();
		GJTree.UserObject obj1=(GJTree.UserObject)parent.getUserObject();
		logger.info("insert node: "+obj.getId()+" , "+obj.getText()+" to:"+
				obj1.getId()+" , "+obj1.getText());
	}

	public static void deleteNode(GJTree.Node parent,
			GJTree.Node node) {
		
		GJTree.UserObject obj=(GJTree.UserObject)node.getUserObject();
		GJTree.UserObject obj1=(GJTree.UserObject)parent.getUserObject();
		logger.info("delete node: "+obj.getId()+" , "+obj.getText()+" from:"+
				obj1.getId()+" , "+obj1.getText());
		
		
	}

}
