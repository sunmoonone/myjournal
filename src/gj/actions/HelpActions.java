package gj.actions;

import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;

public class HelpActions extends Actions {
	public static LinkedHashMap<String, GJAction> getActions() {
		return getActions("Help");
	}

	private static void add(GJAction action) {
		add("Help", action);
	}
	static {
		
		add(new GJAction("Global Journal Help") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		
		add(new GJAction("Buy") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		
		add(new GJAction("Global Journal Website") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		add(null);
		
		add(new GJAction("About Global Journal","info.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		
	}
}
