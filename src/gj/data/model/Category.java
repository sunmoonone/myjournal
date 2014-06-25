package gj.data.model;

import smn.dal.model.ColumnCollection;
import smn.dal.model.IntCol;
import smn.dal.model.KeyType;
import smn.dal.model.SmnModel;
import smn.dal.model.StringCol;
import smn.dal.query.Value;

public class Category extends SmnModel<Integer>{
	final public IntCol id=new IntCol("id",KeyType.Primary);
	final public StringCol title=new StringCol("title",true,new Value("New Category"));
	final public IntCol type=new IntCol("type",true);//daily,loose-leaf,templates,events,alarms,timers
	final public IntCol order=new IntCol("order",true);
	final public StringCol password=new StringCol("pwd",64);
	
	@Override
	public ColumnCollection __getColumns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String __getTable() {
		return "category";
	}

}
