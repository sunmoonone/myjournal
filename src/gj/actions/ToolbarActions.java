package gj.actions;

import java.util.LinkedList;
import java.util.List;

public class ToolbarActions {
	public static List<GJAction> getActions() {

		List<GJAction> l = new LinkedList<GJAction>();
		l.addAll(Actions.getActions("Global", "Save", "Print", "Lock"));
		l.add(GJAction.Separator());
		l.addAll(Actions.getActions("Edit", "Cut", "Copy", "Paste", "Undo", "Redo","Find"));
		l.add(GJAction.Separator());
		l.addAll(Actions.getActions("Tree", "New Node", "New Sub Node","New Category"));
		l.add(GJAction.Separator());
		l.addAll(Actions.getActions("Apps",  "New Mail", "New Event", "New Audio Record", "Timer",
				"Alarms","Chat","Dictionary"));
		l.add(GJAction.Separator());
		l.addAll(Actions.getActions("Table", "Insert Table"));
		l.addAll(Actions.getActions("Insert", "Todo","Smiley","Images","Link","Code"));
		l.add(GJAction.Separator());
		l.addAll(Actions.getActions("Format", "Bold", "Italic", "Underline", "Strikeout", "Align Left",
				"Align Center",
				"Align Right", "Align Block","Numbering", "Bullets","Small Numbering","Small Bullets",
				"Indent", "Unindent"));
		return l;
	}
}
