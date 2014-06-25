package gj.actions;

import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;

public class UserActions extends Actions {
	public static LinkedHashMap<String, GJAction> getActions() {
		return getActions("User");
	}

	private static void add(GJAction action) {
		add("User", action);
	}
	static {
		add(new GJAction("Login") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		add(new GJAction("New User") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		
		
		add(null);
		
		add(new GJAction("Preferences","settings.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		
	}
}
