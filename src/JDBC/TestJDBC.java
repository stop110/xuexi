package JDBC;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJDBC {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws SQLException {
		ConnDB conn=new ConnDB();
		String sql=null;
		sql="select * from chengjidan";
		System.out.println(sql);
		ResultSet rs=conn.executeQuery(sql);
		//遍历rs集合
				if (rs == null)   
		            return;   
		        ResultSetMetaData md = rs.getMetaData(); //得到结果集(rs)的结构信息，比如字段数、字段名等   
		        int columnCount = md.getColumnCount(); //返回此 ResultSet 对象中的列数   
		        List list = new ArrayList();   
		        Map rowData = new HashMap();   
		        while (rs.next()) {   
		         rowData = new HashMap(columnCount);   
		         for (int i = 1; i <= columnCount; i++) {   
		                 rowData.put(md.getColumnName(i), rs.getObject(i));   
		         }   
		         list.add(rowData);   
		         System.out.println("list:" + list.toString());   
		        }   
		        return;
	}
}
