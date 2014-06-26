package gj.data.model;

import smn.dal.model.BooleanCol;
import smn.dal.model.ColumnCollection;
import smn.dal.model.IntCol;
import smn.dal.model.KeyType;
import smn.dal.model.SmnModel;
import smn.dal.model.StringCol;
import smn.dal.query.Value;

public class TreeData extends SmnModel<Integer>{

	final public IntCol id=new IntCol("id",KeyType.Primary);
	final public IntCol pid=new IntCol("pid",true);
	final public IntCol categoryId=new IntCol("category_id",true);
	final public StringCol title=new StringCol("title",true,new Value("new node"));
	final public StringCol icon=new StringCol("icon",true,new Value("default-node-icon.png"));
	final public IntCol contentId=new IntCol("content_id",true);
	final public BooleanCol expanded=new BooleanCol("expanded",true,new Value(false));
	final public IntCol order=new IntCol("order",true);
	
	public boolean testIsRoot(){
		return this.pid.veq(0);
	}
	
	@Override
	public ColumnCollection __getColumns() {
		return new ColumnCollection(id,pid,categoryId,title,icon,contentId,expanded,order);
	}

	@Override
	public String __getTable() {
		return "tree_data";
	}

}
