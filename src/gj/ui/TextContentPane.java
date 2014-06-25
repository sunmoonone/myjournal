package gj.ui;

import java.awt.Color;

import javax.swing.JEditorPane;

public class TextContentPane extends JEditorPane {
	private static final long serialVersionUID = 3695723084916242322L;
	public TextContentPane(){
		super("text/html",null);
		this.setBackground(new Color(125, 181, 142));
	}
}
