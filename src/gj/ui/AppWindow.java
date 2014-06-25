package gj.ui;

import gj.actions.EditActions;
import gj.actions.HelpActions;
import gj.actions.TreeActions;
import gj.actions.FormatActions;
import gj.actions.InsertActions;
import gj.actions.GJAction;
import gj.actions.GlobalActions;
import gj.actions.TableActions;
import gj.actions.ToolbarActions;
import gj.actions.AppsActions;
import gj.actions.UserActions;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;


public class AppWindow {

	private JFrame frame;
	private JMenuBar menuBar;
	private JToolBar toolbar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//System.getProperty("user.name");
		//System.getProperty("user.home");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindow window = new AppWindow();
					window.frame.setVisible(true);
					//ToolActions.newVolume.fire(window.frame);
					//Actions.verifyPassword.fire(window.frame);
					window.setupMainFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppWindow() {
		initialize();
	}
	
	private void initialize(){
		initMain();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initMain() {
		frame = new JFrame();
		frame.setIconImages(IconManager.getAppImages());
		
		frame.setBounds(100, 100, 800, 600);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Global Journal");
	}

	private void setupMainFrame() {
		menuBar=new JMenuBar();
		JMenu journal=new JMenu("Global");
		for(GJAction a:GlobalActions.getActions().values()){
			addActionToMenu(a,journal);
		}
		menuBar.add(journal);
		
		JMenu edit=new JMenu("Edit");
		for(GJAction a:EditActions.getActions().values()){
			addActionToMenu(a,edit);
		}
		menuBar.add(edit);
		
		JMenu insert=new JMenu("Insert");
		for(GJAction a:InsertActions.getActions().values()){
			addActionToMenu(a,insert);
		}
		menuBar.add(insert);
		
		JMenu format=new JMenu("Format");
		for(GJAction a:FormatActions.getActions().values()){
			addActionToMenu(a,format);
		}
		menuBar.add(format);
		
		JMenu table=new JMenu("Table");
		for(GJAction a:TableActions.getActions().values()){
			addActionToMenu(a,table);
		}
		menuBar.add(table);
		
		
		JMenu entry=new JMenu("Tree");
		for(GJAction a:TreeActions.getActions().values()){
			addActionToMenu(a,entry);
		}
		menuBar.add(entry);
		
		JMenu user=new JMenu("User");
		for(GJAction a:UserActions.getActions().values()){
			addActionToMenu(a,user);
		}
		menuBar.add(user);
		
		JMenu tools=new JMenu("Apps");
		for(GJAction a:AppsActions.getActions().values()){
			addActionToMenu(a,tools);
		}
		menuBar.add(tools);
		
		JMenu help=new JMenu("Help");
		for(GJAction a:HelpActions.getActions().values()){
			addActionToMenu(a,help);
		}
		menuBar.add(help);
		
		frame.setJMenuBar(menuBar);
		
		toolbar=new JToolBar();
		toolbar.setRollover(true);
		toolbar.setFloatable(false);
		toolbar.setBorderPainted(false);
		
		addToolbarActions();
		
		frame.add(toolbar,BorderLayout.NORTH);
		
		frame.add(MainPane.getInstance(),BorderLayout.CENTER);
		frame.validate();
	}
	
	private void addActionToMenu(GJAction a, JMenu menu) {
		if(a.isHidden())return;
		
		if(a.isSeparator()){
			menu.addSeparator();
		}else{
			JMenuItem it=new JMenuItem(a);
			it.setPreferredSize(new Dimension(200,it.getPreferredSize().height));
			it.setText(a.getText());
			it.setIconTextGap(8);
			if(!a.hasIcon())
				it.setIcon(IconManager.getDefaultIcon());
			menu.add(it);
		}
	}

	private void addToolbarActions(){
		for(GJAction a:ToolbarActions.getActions()){
			addActionToToolbar(a);
		}
		
		JComboBox fonts=new JComboBox();
		fonts.setMaximumSize(new Dimension(150,200));
		
		JComboBox fontSizes=new JComboBox();
		fontSizes.setMaximumSize(new Dimension(60,200));
		
		JComboBox fontStyles=new JComboBox();
		fontStyles.setMaximumSize(new Dimension(130,200));
		
		toolbar.add(fonts);
		toolbar.add(fontSizes);
		toolbar.add(fontStyles);
		toolbar.addSeparator();
	}
	
	private void addActionToToolbar(GJAction a){
		if(a.isHidden())return;
		
		if(a.isSeparator()){
			toolbar.addSeparator();
			
		}else if(a.isTogglable()){
			JToggleButton jtb=new JToggleButton(a);
			if(a.hasIcon()){
				jtb.setText("");
			}
			jtb.setFocusPainted(false);
			jtb.setBorderPainted(false);
			jtb.setToolTipText(a.getName());
			toolbar.add(jtb);
		}else{
			JButton b=new JButton(a);
			if(a.hasIcon()){
				b.setText("");
			}
			b.setFocusPainted(false);
			b.setBorderPainted(false);
			b.setToolTipText(a.getName());
			toolbar.add(b);
		}
	}
}
