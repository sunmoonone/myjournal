package gj.data.model;

import smn.dal.model.BinaryCol;
import smn.dal.model.BooleanCol;
import smn.dal.model.ByteCol;
import smn.dal.model.CharCol;
import smn.dal.model.ColumnCollection;
import smn.dal.model.DateCol;
import smn.dal.model.FloatCol;
import smn.dal.model.IntCol;
import smn.dal.model.KeyType;
import smn.dal.model.SmnModel;
import smn.dal.model.StringCol;
import smn.dal.query.Value;

public class Config extends SmnModel<Integer> {
	final public IntCol id=new IntCol("id",KeyType.Primary);
	final public IntCol pid=new IntCol("pid",new Value(0));
	final public IntCol order=new IntCol("order",true);
	final public StringCol name=new StringCol("name",true);
	
	//int,float,string,boolean,date,byte[],list,map
	final public StringCol type=new StringCol("type",true);
	final public IntCol intVal=new IntCol("int_val");
	final public FloatCol floatVal=new FloatCol("float_val");
	
	final public BooleanCol boolVal=new BooleanCol("bool_val");
	final public DateCol dateVal=new DateCol("date_val");
	final public BinaryCol binVal=new BinaryCol("bin_val");
	final public CharCol charVal=new CharCol("char_val");
	final public ByteCol byteVal=new ByteCol("byte_val");
	final public StringCol strVal=new StringCol("str_val");
	
	@Override
	public ColumnCollection __getColumns() {
		return new ColumnCollection(id,pid,order,name,type,intVal,floatVal,
				boolVal,dateVal,binVal,charVal,byteVal,strVal);
	}

	@Override
	public String __getTable() {
		// TODO Auto-generated method stub
		return "config";
	}

	public static <T> T get(String key) {
		return null;
	}

}
