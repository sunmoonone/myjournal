package gj.ui;

import java.awt.event.ActionEvent;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainPane extends JTabbedPane{
	private static MainPane pane;
	private MainPane(){}
	
	public static MainPane getInstance(){
		if(pane==null){
			pane = new MainPane();
			pane.getModel().addChangeListener(new ChangeListener(){

				@Override
				public void stateChanged(ChangeEvent e) {
					onSelectionChanged();
				}
				
			});
//			pane.add(new CategoryPane("Work"));
//			pane.add(new CategoryPane("Plan"));
//			pane.add(new CategoryPane("Journal"));
//			pane.add(new CategoryPane("Accounts"));
		}
		return pane;
	}

	protected static void onSelectionChanged() {
		((CategoryPane)pane.getSelectedComponent()).onActivate();
	}
	
	public static void onNewCategory(ActionEvent e) {
		DialogGetTextInput dialog=new DialogGetTextInput();
		boolean ret=dialog.showDialog(pane, "Name for new category",true);
		if(ret){
			CategoryPane p=new CategoryPane(dialog.getText());
			pane.add(p);
			pane.setSelectedComponent(p);
		}
	}
}
