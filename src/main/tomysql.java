package main;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;
import net.sf.json.JSONArray;

public class tomysql {
	
	static String url="jdbc:mysql://localhost:3306/chatdata?useSSL=false";
	static String admine="root";
	static String root="123";
	static String driver="com.mysql.jdbc.Driver";
	static int clearallsql(){
		String sql="truncate table qq";
		String qqdata=null;
		Connection co=null;
		int at=-2;
		try{
			Class.forName(driver);
			co=(Connection) DriverManager.getConnection(url, admine,root);
			PreparedStatement sta=(PreparedStatement) co.prepareStatement(sql);
			at=sta.executeUpdate();
			return at;
		}catch(Exception e){
			e.printStackTrace();
			return at;
		}
	}
	
	static int savabytestosql(byte object[]){
	
		String sql="insert into qq (qqdata) values(?)";
		String qqdata=null;
		Connection co=null;
		int at=-2;
		try{
			Class.forName(driver);
			co=(Connection) DriverManager.getConnection(url, admine,root);
			PreparedStatement sta=(PreparedStatement) co.prepareStatement(sql);
			sta.setObject(1, object);
			at=sta.executeUpdate();
			return at;
		}catch(Exception e){
			e.printStackTrace();
			return at;
		}
	}
	
	static int savabytestosql(String sql,JSONArray ob){
	
		String qqdata=null;
		Connection co=null;
		int at=-2;
		try{
			Class.forName(driver);
			co=(Connection) DriverManager.getConnection(url, admine,root);
			PreparedStatement sta=(PreparedStatement) co.prepareStatement(sql);
			sta.setObject(1, ob);
			at=sta.executeUpdate();
			return at;
		}catch(Exception e){
			e.printStackTrace();
			return at;
		}
	}
	
	static int savabytestosql(String sql,byte[] ob){
	
		String qqdata=null;
		Connection co=null;
		int at=-2;
		try{
			Class.forName(driver);
			co=(Connection) DriverManager.getConnection(url, admine,root);
			PreparedStatement sta=(PreparedStatement) co.prepareStatement(sql);
			sta.setBytes(1, ob);
			at=sta.executeUpdate();
			return at;
		}catch(Exception e){
			e.printStackTrace();
			return at;
		}
	}
	static int createtabeltosql(String sql){
		
		String qqdata=null;
		Connection co=null;
		int at=-2;
		try{
			Class.forName(driver);
			co=(Connection) DriverManager.getConnection(url, admine,root);
			PreparedStatement sta=(PreparedStatement) co.prepareStatement(sql);
			at=sta.executeUpdate();
			return at;
		}catch(Exception e){
			e.printStackTrace();
			return at;
		}
	}
	
	public static int updatesql(String sql){
	
		String qqdata=null;
		Connection co=null;
		int at=-2;
		try{
			Class.forName(driver);
			co=(Connection) DriverManager.getConnection(url, admine,root);
			PreparedStatement sta=(PreparedStatement) co.prepareStatement(sql);
			at=sta.executeUpdate();
			return at;
		}catch(Exception e){
			e.printStackTrace();
			return at;
		}
	}
	
	public static ResultSet querysql(String sql){
		
		String qqdata=null;
		Connection co=null;
		ResultSet at=null;
		try{
			Class.forName(driver);
			co= DriverManager.getConnection(url, admine,root);
			PreparedStatement sta =co.prepareStatement(sql);
			at=sta.executeQuery();
			return at;
		}catch(Exception e){
			e.printStackTrace();
			return at;
		}
	}
	
	static void testconnection() throws Exception{
		Class.forName(driver);
		Connection con= DriverManager.getConnection(url, admine,root);
	}

}
