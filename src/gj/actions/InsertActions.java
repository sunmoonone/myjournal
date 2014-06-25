package gj.actions;

import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;

public class InsertActions  extends Actions {
	public static LinkedHashMap<String, GJAction> getActions() {
		return getActions("Insert");
	}

	private static void add(GJAction action) {
		Actions.add("Insert",action);
	}
	static{
		add(new GJAction("Todo", "todo.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		add(new GJAction("Link", "link.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		add(new GJAction("Code", "code.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		add(new GJAction("Smiley", "smiley.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		add(new GJAction("Images", "images.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		add(new GJAction("Audio", "charm-music.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		add(new GJAction("Video", "video.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

}
