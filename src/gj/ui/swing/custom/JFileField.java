package gj.ui.swing.custom;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

import smn.utils.Functions;

public class JFileField extends JPanel {
	private static final long serialVersionUID = 1L;

	/** Instruction to display only files. */
    public static final int FILES_ONLY = JFileChooser.FILES_ONLY;

    /** Instruction to display only directories. */
    public static final int DIRECTORIES_ONLY = JFileChooser.DIRECTORIES_ONLY;

    /** Instruction to display both files and directories. */
    public static final int FILES_AND_DIRECTORIES = JFileChooser.FILES_AND_DIRECTORIES;
    
	private JTextField path;
	private JButton button;
	private JFileChooser dialog;
	private String defaultPath="";
	private int fileSelectionMode=JFileChooser.FILES_ONLY;

	private String title;
	

	private boolean multiSelectionEnabled = false;

	public JFileField() {
		setLayout(new GridBagLayout());
		
		path=new JTextField(defaultPath);
		path.setPreferredSize(new Dimension(100,25));
		button = new JButton();
		button.setPreferredSize(new Dimension(18,25));
		add(path,new GBC(0,0,5,1).setFill(GBC.HORIZONTAL).setWeight(100, 100));
		add(button,new GBC(5,0,1,1).setFill(GBC.HORIZONTAL).setWeight(0, 0));
		
		button.setText("...");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (dialog == null) {
					dialog = new JFileChooser(defaultPath);
					dialog.setName(title);
				}

				dialog.setMultiSelectionEnabled(multiSelectionEnabled);
				dialog.setFileSelectionMode(fileSelectionMode);
				
				int state = dialog.showDialog(SwingUiUtils.getAncestorFrame(JFileField.this), "Select");
				if (state == JFileChooser.APPROVE_OPTION) {
					if (multiSelectionEnabled) {
						File[] fs = dialog.getSelectedFiles();
						if (fs != null)
							path.setText(Functions.join(fs, "::"));
					} else {
						File file = dialog.getSelectedFile();
						if (file != null) {
							path.setText(file.toString());
						}
					}
				}
			}
		});
	}

	public void setMultiSelectionEnabled(boolean flag) {
		this.multiSelectionEnabled = flag;
	}
	public void setFileSelectionMode(int mode){
		this.fileSelectionMode=mode;
	}

	public File getSelectedFile() {
		if (dialog == null)
			return null;
		return dialog.getSelectedFile();
	}

	public File[] getSelectedFiles() {
		if (dialog == null)
			return null;
		return dialog.getSelectedFiles();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDefaultPath() {
		return defaultPath;
	}

	public void setDefaultPath(String defaultPath) {
		this.defaultPath = defaultPath;
		path.setText(defaultPath);
	}
	
	public void setText(String text){
		button.setText(text);
	}
	

}
