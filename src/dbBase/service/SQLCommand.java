package dbBase.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dbBase.util.DBcon;

public class SQLCommand {

	 
    public static Map<String, List<Object>> executeQuery(Connection con,String sql,String fDatabase){
    	Map<String, List<Object>> map=new HashMap<String, List<Object>>();
    	List<Object> eliment=null;
    	Statement statement=null;
    	ResultSet rs=null;
		try {
			statement = con.createStatement();
			rs=statement.executeQuery(sql);
			ResultSetMetaData rt=rs.getMetaData();
			int i=rt.getColumnCount();
			
			while(rs.next()){
				eliment=new ArrayList<Object>();
				for(int j=1;j<=i;j++){
					Object o=rs.getObject(j);
					eliment.add(rs.getObject(j));
				}
				String str=getMapKey(fDatabase);
				map.put(rs.getString(str),eliment);
			}
			return map;
		} catch (SQLException e) {
			System.out.println("获取数据出现异常： "+e.getMessage());
			return null;
		}finally{
			DBcon.closeResultSet(rs);
			DBcon.closeStatement(statement);
			//DBcon.closeConnection(con);
		}
    	
    }
    
    public static String getMapKey(String fDatabase){
    	if(fDatabase.equals("information_schema.COLUMNS")){
    		return "column_name";//选择字段
    	}else if(fDatabase.equals("information_schema.KEY_COLUMN_USAGE")){
    		return "column_name";//表键值
    	}else if(fDatabase.equals("information_schema.TABLE_CONSTRAINTS")){
    		return "Constraint_name";//check暂定
    	}else if(fDatabase.equals("information_schema.STATISTICS")){
    		return "column_name";//索引
    	}else{
    		return "";
    	}
    }
}
