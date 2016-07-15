package JDBC;

import java.sql.*; //����java.sql�������е���

public class ConnDB {
	public Connection conn=null;   //����Connection�����ʵ��
	public Statement stmt=null;
	public ResultSet rs=null;
	public static Connection getConnection(){
		String driverClass="org.postgresql.Driver";
		String url="jdbc:postgresql://localhost/Test";
		String user="postgres";
		String password="huangjing";
		Connection conn=null;
		try{
			Class.forName(driverClass);
			conn=DriverManager.getConnection(url,user,password);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		if(conn==null){
			System.out.print("����:������ݿ�����ʧ�ܣ�");
		}
		return conn;
		
	}
	
	public ResultSet executeQuery(String sql){
		try{
			conn=getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=stmt.executeQuery(sql);
		}catch(SQLException ex){
			System.out.print(ex.getMessage());
		}
		return rs;
		
	}
	
	public void close(){
		try{
			if(rs!=null){
				rs.close();
			}
			if(stmt!=null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}catch(Exception e){
			e.printStackTrace(System.err);
		}
	}
}
