package gj.ui;

import gj.ui.swing.custom.GBC;
import gj.ui.swing.custom.SwingUiUtils;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;

public class DialogVerifyPassword extends JPanel{
	private static final long serialVersionUID = 1L;
	private JDialog dialog;
	private JButton okButton;
	private JButton cancelButton;
	private JPasswordField pwd;
	
	private boolean ok=false;
	
	public DialogVerifyPassword(){
		setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(370,120));
		JLabel label=new JLabel("");
		label.setPreferredSize(new Dimension(320,25));
		
		
		pwd=new JPasswordField();
		pwd.setPreferredSize(new Dimension(320,25));

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
		
		okButton.setPreferredSize(new Dimension(80,25));
		cancelButton.setPreferredSize(new Dimension(80,25));
		
		add(pwd,new GBC(0,0,8,1).setFill(GBC.HORIZONTAL));
		add(label,new GBC(0,1,8,1).setFill(GBC.HORIZONTAL));
		JLabel pad=new JLabel("");
		pad.setPreferredSize(new Dimension(160,25));
		add(pad,new GBC(0,2,4,1));
		add(okButton,new GBC(6,2,1,1).setAnchor(GBC.EAST).setFill(GBC.NONE).setInsets(0, 0, 0, 5));
		add(cancelButton,new GBC(7,2,1,1).setAnchor(GBC.BASELINE_TRAILING).setFill(GBC.NONE));
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
		dialog.setTitle("Password Required");
		SwingUiUtils.centerScreen(dialog);
		dialog.setVisible(true);
		return ok;
	}
}
