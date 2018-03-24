package main;

import java.sql.ResultSet;
import java.util.*;
import java.util.ArrayList;

public class dbhelper {
	
	public static ArrayList<User> searchUser(String searchWho){
		ArrayList<User> users=new ArrayList<User>();
		String sql="select * from users where admine like '%"+searchWho+"%' or name like '%"+searchWho+"%'";
		ResultSet set=tomysql.querysql(sql);
  		try{
  			while(set.next()){
  				User user=new User(set.getString("name"),set.getString("admine"));
  				users.add(user);
  			}
  		}catch(Exception e){
  			e.printStackTrace();
  		}
		return users;
	}
	
	
	public static boolean addfriend(String admine,String addWho){
		
		return false;
	}
	
	public static boolean checkUser(String admine,String password){
		return false;
		
	}
	
}
