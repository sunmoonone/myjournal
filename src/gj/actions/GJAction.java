package gj.actions;

import gj.ui.IconManager;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;


public abstract class GJAction extends AbstractAction {
	protected boolean togglable=false;
	protected boolean hidden=false;
	protected String desc;
	
	protected GJAction(){}
	
	public GJAction(String name) {
		super(name);
	}

	public GJAction(String name, String iconName){
		super(name, IconManager.getIcon(iconName));
	}
	
	public GJAction(String name, String iconName,boolean togglable){
		super(name, IconManager.getIcon(iconName));
		this.togglable=togglable;
	}
	
	public GJAction(String name, String iconName,boolean togglable,boolean hidden){
		super(name, IconManager.getIcon(iconName));
		this.togglable=togglable;
		this.hidden=hidden;
	}

	public void fire(Object source) {
		this.actionPerformed(new ActionEvent(source,
				ActionEvent.ACTION_PERFORMED, (String) this
						.getValue(Action.NAME)));
	}
	
	public boolean isSeparator(){
		return false;
	}
	
	public boolean hasIcon(){
		return this.getValue(Action.SMALL_ICON)!=null;
	}
	
	public boolean isTogglable(){
		return this.togglable;
	}
	public boolean isHidden(){
		return this.hidden;
	}

	public String getName() {
		return this.getValue(Action.NAME).toString();
	}
	
	private static class SeparatorAction extends GJAction{
		private static int counter=0;
		public SeparatorAction() {
			super("null"+(counter++));
		}

		@Override
		public void actionPerformed(ActionEvent e) {}
		
		public boolean isSeparator(){
			return true;
		}
	}

	public static GJAction Separator() {
		return new SeparatorAction();
	}

	public void setDecription(String desc) {
		this.desc=desc;
	}
	public String getDescription(String desc) {
		return desc;
	}
	
	public String getText(){
		if(desc!=null && !desc.equals(""))return desc;
		return this.getName();
	}
}
