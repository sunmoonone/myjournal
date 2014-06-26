package gj.ui.swing.custom;

import java.awt.Component;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class SwingUiUtils {
	public static Frame getSourceFrame(ActionEvent e) {
		return (Frame) SwingUtilities.getAncestorOfClass(Frame.class,
				(Component) e.getSource());
	}

	public static void centerScreen(Component com) {
		GraphicsConfiguration gc = com.getGraphicsConfiguration();
		Rectangle screen=gc.getBounds();
		
		int y = screen.height / 2 - com.getSize().height / 2;
		int x = screen.width / 2 - com.getSize().width / 2;
		com.setLocation(x, y);
	}

	public static Component getAncestorFrame(Component com) {
		return SwingUtilities.getAncestorOfClass(Frame.class,
				com);
	}

	public static void alert(Component parent,String message) {
		JOptionPane.showMessageDialog(parent, message);
	}
}
