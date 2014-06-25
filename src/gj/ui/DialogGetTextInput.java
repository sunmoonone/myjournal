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
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import smn.utils.Functions;

public class DialogGetTextInput extends JPanel{
	protected JDialog dialog;
	protected JButton okButton;
	protected JButton cancelButton;
	protected JTextField txt;
	
	protected boolean ok=false;
	protected boolean force=false;
	
	public DialogGetTextInput(){
		setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(370,120));
		JLabel label=new JLabel("");
		label.setPreferredSize(new Dimension(320,25));
		
		
		txt=new JTextField();
		txt.setPreferredSize(new Dimension(320,25));

		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				onOKButtonClicked(event);
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
		
		add(txt,new GBC(0,0,8,1).setFill(GBC.HORIZONTAL));
		add(label,new GBC(0,1,8,1).setFill(GBC.HORIZONTAL));
		JLabel pad=new JLabel("");
		pad.setPreferredSize(new Dimension(160,25));
		add(pad,new GBC(0,2,4,1));
		add(okButton,new GBC(6,2,1,1).setAnchor(GBC.EAST).setFill(GBC.NONE).setInsets(0, 0, 0, 5));
		add(cancelButton,new GBC(7,2,1,1).setAnchor(GBC.BASELINE_TRAILING).setFill(GBC.NONE));
	}
	
	protected void onOKButtonClicked(ActionEvent event) {
		if(force){
			String s=txt.getText();
			if(Functions.IsNullOrWhiteSpace(s)){
				ok=false;
				return;
			}
		}
		ok=true;
		dialog.setVisible(false);
	}

	public boolean showDialog(Component parent,String title,boolean force) {
		ok = false;
		this.force=force;
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
		dialog.setTitle(title);
		SwingUiUtils.centerScreen(dialog);
		dialog.setVisible(true);
		return ok;
	}
	
	public String getText(){
		return txt.getText();
	}

}
