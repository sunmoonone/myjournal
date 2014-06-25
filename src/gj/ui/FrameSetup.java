package gj.ui;

import gj.actions.AppsActions;
import gj.ui.swing.custom.SwingUiUtils;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


public class FrameSetup {
	private JFrame login;
	
	public FrameSetup(){
		login = new JFrame();
		
	    login.setSize(270, 150);
	    SwingUiUtils.centerScreen(login);
	    
		login.setAlwaysOnTop(true);
		login.setUndecorated(true);
		
		GridBagLayout grid=new GridBagLayout();
		login.setLayout(grid);

//		JButton newVol=new JButton(ToolActions.newVolume);
//		newVol.setPreferredSize(new Dimension(200, 30));
//		JButton chooseVol=new JButton(ToolActions.chooseVolume);
//		chooseVol.setPreferredSize(new Dimension(200, 30));
//		JButton cancel=new JButton(ToolActions.exit);
//		cancel.setPreferredSize(new Dimension(200, 30));
		
//		login.add(newVol,new GBC(1, 0,4,2).setInsets(1).setFill(GBC.HORIZONTAL));
//		login.add(chooseVol,new GBC(1, 2,4,2).setInsets(1).setFill(GBC.HORIZONTAL));
//		login.add(cancel,new GBC(1, 4,4,2).setInsets(1).setFill(GBC.HORIZONTAL));
	}
}
