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
		//����rs����
				if (rs == null)   
		            return;   
		        ResultSetMetaData md = rs.getMetaData(); //�õ������(rs)�Ľṹ��Ϣ�������ֶ������ֶ�����   
		        int columnCount = md.getColumnCount(); //���ش� ResultSet �����е�����   
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
