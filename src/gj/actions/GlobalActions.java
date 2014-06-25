package gj.actions;

import gj.ui.DialogNewVolume;
import gj.ui.DialogVerifyPassword;
import gj.ui.swing.custom.SwingUiUtils;

import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;


public class GlobalActions extends Actions {
	public static LinkedHashMap<String, GJAction> getActions() {
		return getActions("Global");
	}

	private static void add(GJAction action) {
		add("Global",action);
	}

	static {
		add(new GJAction("Lock", "lock.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		
		add(GJAction.Separator());
		
		add(new GJAction("Save", "save.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		add(new GJAction("Print", "print.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		add(GJAction.Separator());
		add(new GJAction("Switch Volume","switch-volume.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
			}

		});

		add(new GJAction("New Volume","new-volume.png") {
			DialogNewVolume dialog;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (dialog == null) {
					dialog = new DialogNewVolume();
				}
				dialog.showDialog(SwingUiUtils.getSourceFrame(e));
			}

		});
		add(GJAction.Separator());
		add(new GJAction("Backup","backup.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		
		add(new GJAction("Restore","restore.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		add(new GJAction("Verify Password",null,false,true) {
			DialogVerifyPassword dialog;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (dialog == null) {
					dialog = new DialogVerifyPassword();
				}
				dialog.showDialog(SwingUiUtils.getSourceFrame(e));
			}

		});
		add(GJAction.Separator());
		add(new GJAction("Quit","exit.png") {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
	}
}
