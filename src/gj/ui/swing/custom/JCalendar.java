package gj.ui.swing.custom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class JCalendar extends JPanel {
	JTable table;
	JButton lbl;
	JButton pre;
	JButton next;
	JButton now;
	
	public JCalendar(int firstDayOfWeek) {
		setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(210, 180));

		JPanel p1 = new JPanel();
		p1.setLayout(new GridBagLayout());
		pre = new JButton("");
		pre.setBorderPainted(false);
		next = new JButton("");
		next.setBorderPainted(false);
		now = new JButton("");
		now.setBorderPainted(false);
		lbl = new JButton("");
		lbl.setBorderPainted(false);
		lbl.setPreferredSize(new Dimension(48, 16));
		Dimension icon16 = new Dimension(16, 16);

		pre.setPreferredSize(icon16);
		now.setPreferredSize(icon16);
		next.setPreferredSize(icon16);
		p1.add(pre, new GBC(0, 0, 1, 1).setAnchor(GBC.WEST).setFill(GBC.NONE));
		p1.add(lbl, new GBC(2, 0, 3, 1).setAnchor(GBC.BASELINE_LEADING)
				.setWeight(100, 0).setFill(GBC.BOTH));
		p1.add(now, new GBC(5, 0, 1, 1));
		p1.add(next, new GBC(6, 0, 1, 1).setAnchor(GBC.EAST));

		add(p1, BorderLayout.NORTH);

		table = new JTable(new CalendarTableModel(firstDayOfWeek));
		table.setFillsViewportHeight(true);
		table.setRowHeight(24);
		table.setRowSelectionAllowed(false);
		table.setShowGrid(false);
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionBackground(new Color(51,153,255));
		table.setSelectionForeground(Color.WHITE);
		
		table.setDefaultRenderer(Date.class, new CalendarCellRenderer((CalendarTableModel)table.getModel(),table.getForeground()));
		setHeaderRenderer();
		
		JScrollPane scroll = new JScrollPane(table);
		
		add(scroll, BorderLayout.CENTER);
		
		now.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				selectToday();
			}
			
		});
		
		pre.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				preMonth();
			}
			
		});
		
		next.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				nextMonth();
			}
			
		});
		
		selectToday();
	}
	
	private void setHeaderRenderer() {
		CalendarHeaderRenderer r=new CalendarHeaderRenderer();
		Enumeration<TableColumn> iter=table.getColumnModel().getColumns();
		while(iter.hasMoreElements()){
			iter.nextElement().setHeaderRenderer(r);
		}
	}

	public Date getSelected(){
		int x=table.getSelectedRow();
		int y=table.getSelectedColumn();
		if(x==-1|| y==-1)return null;
		CalendarTableModel m = (CalendarTableModel)table.getModel();
		return (Date)m.getValueAt(x, y);
	}

	protected void preMonth() {
		CalendarTableModel m = (CalendarTableModel)table.getModel();
		m.preMonth();
		lbl.setText(m.getCaption());
	}


	protected void nextMonth() {
		CalendarTableModel m = (CalendarTableModel)table.getModel();
		m.nextMonth();
		lbl.setText(m.getCaption());
	}
	
	public void addSelectionListener(ListSelectionListener listener){
		table.getColumnModel().getSelectionModel().addListSelectionListener(listener);
	}

	private void selectToday(){
		CalendarTableModel m = (CalendarTableModel)table.getModel();
		Dimension pos=m.findToday(true);
		if(pos.width==-1)return;
		lbl.setText(m.getCaption());
		table.changeSelection(pos.width, pos.height, false, false);
	}
	
	public void setPreIcon(Icon icon) {
		pre.setIcon(icon);
	}

	public void setNextIcon(Icon icon) {
		next.setIcon(icon);
	}

	public void setTodayIcon(Icon icon) {
		now.setIcon(icon);
	}

	private static class CalendarTableModel extends AbstractTableModel{
		private Calendar cal;
		private Date[][] data;
		private String[] cols;
		protected SimpleDateFormat fmt=new SimpleDateFormat("MM.yyyy");
		
		public CalendarTableModel(int firstDayOfWeek){
			this.cal=Calendar.getInstance();
			cal.setFirstDayOfWeek(firstDayOfWeek);
			fillData();
		}
		
		public String getCaption() {
			return fmt.format(cal.getTime());
		}

		public void nextMonth(){
			cal.add(Calendar.MONTH, 1);
			this.fillData();
			this.fireTableDataChanged();
		}
		public void preMonth(){
			cal.add(Calendar.MONTH, -1);
			this.fillData();
			this.fireTableDataChanged();
		}
		
		public Dimension findToday(boolean force) {
			Calendar now=Calendar.getInstance();
			Calendar tmp=Calendar.getInstance();
			int i,j,x=-1,y=-1;
			for (i = 0; i < 6; i++) {
				for (j = 0; j < 7; j++) {
					tmp.setTime(data[i][j]);
					if(tmp.get(Calendar.YEAR)==now.get(Calendar.YEAR) && 
							tmp.get(Calendar.MONTH)==now.get(Calendar.MONTH) &&
							tmp.get(Calendar.DAY_OF_MONTH)==now.get(Calendar.DAY_OF_MONTH)){
						x=i;y=j;break;
					}
				}
			}
			Dimension d= new Dimension(x,y);
			if(!force || d.width!=-1)return d;
			
			cal.setTime(new Date());
			this.fillData();
			this.fireTableDataChanged();
			return findToday(false);
		}

		private void fillData(){
			data=new Date[6][7];
			
			Calendar tmp=Calendar.getInstance();
			tmp.setTime(cal.getTime());
			tmp.set(Calendar.DAY_OF_MONTH, 1);
			
			int firstDayOfWeek = cal.getFirstDayOfWeek();
			tmp.setFirstDayOfWeek(firstDayOfWeek);
			
			int dayOfWeek = tmp.get(Calendar.DAY_OF_WEEK);
			
			if(firstDayOfWeek==Calendar.SUNDAY){
				tmp.add(Calendar.DAY_OF_MONTH, diffDayOfWeek(dayOfWeek,firstDayOfWeek));
			}else{
				tmp.add(Calendar.DAY_OF_MONTH, diffDayOfWeek(firstDayOfWeek, dayOfWeek));
			}
			int i, j = 0;
			for (i = 0; i < 6; i++) {
				for (j = 0; j < 7; j++) {
					if(i!=0||j!=0){
						tmp.add(Calendar.DAY_OF_MONTH, 1);
					}
					data[i][j] = tmp.getTime();
				}
			}
		}
		
		@Override
		public int getRowCount() {
			return 6;
		}

		@Override
		public int getColumnCount() {
			return 7;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return data[rowIndex][columnIndex];
		}
		
		@Override
		public String getColumnName(int column) {
			ensureCols();
			return cols[column];
		}
		
		public Class<?> getColumnClass(int columnIndex) {
			return Date.class;
		}
		
		private void ensureCols(){
			if (cal.getFirstDayOfWeek() == Calendar.SUNDAY) {
				if(cols==null||!cols[0].equals("Sun")){
					cols= new String[] { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri","Sat" };
				}
			} else {
				if(cols==null||!cols[0].equals("Mon")){
					cols= new String[] { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat","Sun" };
				}
			}
		}
		
		public static int diffDayOfWeek(int day1, int day2) {
			day1=getConstDayOfWeek(day1);
			day2=getConstDayOfWeek(day2);
			return day1-day2;
		}

		public static int getConstDayOfWeek(int day) {
			switch (day) {
			case Calendar.SUNDAY:
				return 7;
			case Calendar.SATURDAY:
				return 6;
			case Calendar.FRIDAY:
				return 5;
			case Calendar.THURSDAY:
				return 4;
			case Calendar.WEDNESDAY:
				return 3;
			case Calendar.TUESDAY:
				return 2;
			case Calendar.MONDAY:
				return 1;
			default:
				return day;
			}
		}

		public Calendar getCalendar() {
			return cal;
		}
	}
	
	private static class CalendarHeaderRenderer extends JLabel implements TableCellRenderer{

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			this.setHorizontalAlignment(JLabel.CENTER);
			
			setText(value==null?"":value.toString());
			return this;
		}
		
	}
	
	private static class CalendarCellRenderer extends DefaultTableCellRenderer{
		protected SimpleDateFormat fmt=new SimpleDateFormat("d");
		protected Color defaultForeground;
		protected Calendar cal;
		
		public CalendarCellRenderer(CalendarTableModel model,Color defaultForeground){
			this.defaultForeground=defaultForeground;
			this.setHorizontalAlignment(JLabel.CENTER);
			this.cal=model.getCalendar();
		}
		
		public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
			super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
			
			Calendar v=Calendar.getInstance();
			v.setTime((Date)value);
			
			if(!isSelected && cal.get(Calendar.MONTH)!=v.get(Calendar.MONTH)){
				setForeground(Color.lightGray);
			}else if(!isSelected && !hasFocus){
				setForeground(defaultForeground);
			}
			setValue(fmt.format(v.getTime()));
			return this;
		}
	}
}
