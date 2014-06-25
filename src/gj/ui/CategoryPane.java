package gj.ui;

import javax.swing.JSplitPane;

public class CategoryPane extends JSplitPane {
	private static final long serialVersionUID = -4882291227179220663L;
	private TreePane treePane;
	private TextContentPane textPane;
	
	public CategoryPane(String title){
		super(JSplitPane.HORIZONTAL_SPLIT,false);
		this.setName(title);
		treePane=new TreePane(title);
		textPane=new TextContentPane();
		this.setLeftComponent(treePane);
		this.setRightComponent(textPane);
	}

	public void onActivate() {
		treePane.onActivate();
	}
	
}
