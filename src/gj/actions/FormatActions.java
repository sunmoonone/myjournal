package gj.actions;

import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;

public class FormatActions extends Actions{
	public static LinkedHashMap<String,GJAction> getActions() {
		return Actions.getActions("Format");
	}
	
	private static void add(GJAction action){
		Actions.add("Format",action);
	}
	
	static {
		add(new GJAction("Bold", "bold.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		add(new GJAction("Italic", "italic.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		add(new GJAction("Underline", "underline.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		add(new GJAction("Strikeout", "strikeout.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		add(new GJAction("Align Left", "align-left.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		add(new GJAction("Align Right", "align-right.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		add(new GJAction("Align Center", "align-center.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		
		add(new GJAction("Align Block", "align-block.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		add(new GJAction("Numbering", "numbering.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		add(new GJAction("Bullets", "bullets.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		add(new GJAction("Small Numbering", "sub-numbering.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		add(new GJAction("Small Bullets", "sub-bullets.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		add(new GJAction("Indent", "indent.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		add(new GJAction("Unindent", "unindent.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}

}
