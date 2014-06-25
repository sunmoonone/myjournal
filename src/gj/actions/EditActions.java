package gj.actions;

import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;

public class EditActions extends Actions{
	public static LinkedHashMap<String,GJAction> getActions() {
		return getActions("Edit");
	}
	
	private static void add(GJAction action){
		add("Edit",action);
	}
	static {
		add(new GJAction("Undo", "undo.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		add(new GJAction("Redo", "redo.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		
		add(new GJAction("Cut", "cut.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		add(new GJAction("Copy", "copy.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		add(new GJAction("Paste", "paste.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		add(new GJAction("Find", "find.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		add(null);
		add(new GJAction("Edit source") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}
}
