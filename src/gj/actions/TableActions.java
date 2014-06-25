package gj.actions;

import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;

public class TableActions extends Actions {
	public static LinkedHashMap<String, GJAction> getActions() {
		return getActions("Table");
	}

	private static void add(GJAction action) {
		add("Table",action);
	}
	static {
		add(new GJAction("Insert Table","table.png"){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		add(GJAction.Separator());
		add(new GJAction("Insert Row Below","insert-row-down.png"){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		add(new GJAction("Insert Row Above","insert-row-up.png"){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		add(new GJAction("Insert Column Right","insert-col-right.png"){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		add(new GJAction("Insert Column Left","insert-col-left.png"){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		add(GJAction.Separator());
		add(new GJAction("Delete Row(s)","delete-row.png"){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		add(new GJAction("Delete Column(s)","delete-column.png"){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		add(GJAction.Separator());
		add(new GJAction("Delete Table","delete-table.png"){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		add(GJAction.Separator());
		add(new GJAction("Split Cells","split-cells.png"){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		add(new GJAction("Merge Cells","merge-cells.png"){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		add(GJAction.Separator());
		add(new GJAction("Table Properties...","property.png"){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
	}
}
