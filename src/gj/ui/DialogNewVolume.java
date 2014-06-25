package gj.ui;

import gj.ui.swing.custom.JFileField;
import gj.ui.swing.custom.SwingUiUtils;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class DialogNewVolume extends JPanel {
	private static final long serialVersionUID = 1L;

	private JDialog dialog;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField volumeName;
	private JFileField file;
	private boolean ok=false;

	public DialogNewVolume() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(370,170));
		JPanel panel = new JPanel();
		GridLayout gl=new GridLayout(5, 1);
		panel.setLayout(gl);

		panel.add(new JLabel("  Journal Volume Name:"));
		panel.add(volumeName = new JTextField(""));
		panel.add(new JCheckBox(" Set as default", true));
		panel.add(new JLabel("  Create in this folder:"));
		file = new JFileField();
		file.setFileSelectionMode(JFileField.DIRECTORIES_ONLY);
		file.setTitle("Select a folder");
		file.setDefaultPath(System.getProperty("user.home"));
		panel.add(file);

		add(panel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();

		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ok=true;
				dialog.setVisible(false);
			}
		});
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dialog.setVisible(false);
			}
		});

		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	public boolean showDialog(Component parent) {
		ok = false;

		Frame owner = null;
		if (parent instanceof Frame)
			owner = (Frame) parent;
		else
			owner = (Frame) SwingUtilities.getAncestorOfClass(Frame.class,
					parent);

		// if first time, or if owner has changed, make new dialog
		if (dialog == null || dialog.getOwner() != owner) {
			dialog = new JDialog(owner, true);
			dialog.add(this);
			dialog.setModal(true);
			dialog.setResizable(false);
			dialog.getRootPane().setDefaultButton(okButton);
			dialog.pack();
		}

		// set title and show dialog
		dialog.setTitle("Create New Journal Volume");
		SwingUiUtils.centerScreen(dialog);
		dialog.setVisible(true);
		return ok;
	}
}
