package gj.data.model;

import smn.dal.model.ColumnCollection;
import smn.dal.model.IntCol;
import smn.dal.model.KeyType;
import smn.dal.model.SmnModel;
import smn.dal.model.StringCol;

public class Content extends SmnModel<Integer> {
	final public IntCol id=new IntCol("id",KeyType.Primary);
	final public StringCol content=new StringCol("content");
	
	@Override
	public ColumnCollection __getColumns() {
		return new ColumnCollection(id,content);
	}

	@Override
	public String __getTable() {
		return "content";
	}

}
