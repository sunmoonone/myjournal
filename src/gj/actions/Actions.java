package gj.actions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.Action;

public class Actions {
	protected static Map<String,LinkedHashMap<String,GJAction>> actions = 
			new HashMap<String,LinkedHashMap<String,GJAction>>();

	protected Actions(){}
	
	public static GJAction getAction(String category,String name){
		LinkedHashMap<String, GJAction> m=actions.get(category);
		if(m==null||!m.containsKey(name))return null;
		
		return m.get(name);
	}
	
	public static List<GJAction> getActions(String category,String... name){
		List<GJAction> l=new LinkedList<GJAction>();
		LinkedHashMap<String, GJAction> m=actions.get(category);
		if(m==null)return l;
		
		for(String n:name){
			if(!m.containsKey(n))continue;
			l.add(m.get(n));
		}
		
		return l;
	}

	public static LinkedHashMap<String, GJAction> getActions(String category) {
		return actions.get(category);
	}

	protected static void add(String category, GJAction action) {
		LinkedHashMap<String,GJAction> m=null;
		
		if(!actions.containsKey(category)){
			m=new LinkedHashMap<String,GJAction>();
			actions.put(category, m);
		}else{
			m=actions.get(category);
		}
		if(action==null)
			action=GJAction.Separator();
				
		m.put((String)action.getValue(Action.NAME), action);
	}
}
