package gj.actions;

import gj.ui.CategoryPane;
import gj.ui.MainPane;
import gj.ui.TreePane;

import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;

public class TreeActions extends Actions {
	public static LinkedHashMap<String, GJAction> getActions() {
		return getActions("Tree");
	}

	private static void add(GJAction action) {
		add("Tree", action);
	}
	
	static {
		add(new GJAction("New Node", "empty-doc.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				TreePane.onNewNode(e);
			}
		});

		add(new GJAction("New Sub Node","new-sub.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				TreePane.onNewSubNode(e);
			}
		});
		
		add(new GJAction("New Category","tab.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainPane.onNewCategory(e);
			}

		});
		
		add(new GJAction("Delete Node","delete-node.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				TreePane.onDeleteNode(e);
			}
		});
		
		add(new GJAction("Categories","property.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		add(GJAction.Separator());
		
		add(new GJAction("Toggle Tree", "tree.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}

}
