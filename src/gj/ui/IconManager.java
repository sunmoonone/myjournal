package gj.ui;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.apache.log4j.Logger;

public class IconManager {
	final private static Logger logger = Logger.getLogger(IconManager.class);
	
	private static Map<String,Image> cache=new HashMap<String,Image>();
	
	public static Icon getIcon(String name){
		if(name==null || name.equals(""))return null;
		return new ImageIcon(getImage(name));
	}
	
	public static Image getImage(String name){
		if(cache.containsKey(name))return cache.get(name);
		
		URL url=IconManager.class.getClassLoader().getResource("gj/res/"+name);
		if(url==null){
			logger.error("Image not found:"+name);
			return null;
		}
		Image img= Toolkit.getDefaultToolkit().getImage(url);
		cache.put(name, img);
		return img;
	}

	public static List<? extends Image> getAppImages() {
		List<Image> list =new ArrayList<Image>();
		//list.add(getImage("earth48.png"));
		list.add(getImage("earth32.png"));
		list.add(getImage("earth16.png"));
		return list;
	}

	public static Icon getDefaultIcon() {
		return getIcon("default-icon.png");
	}
}
