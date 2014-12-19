package com.rohit.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
  
	  
	public static boolean validate(LogBean bean){  
	boolean status=false;  
	System.out.println("inside LoginDAO");
	try{  
	Connection con=JDBCHelper.getConnection();
	System.out.println(con);
	if(con!=null)
	{
	              
	PreparedStatement ps=con.prepareStatement("select * from register where email=? and pass=?");  
	  
	ps.setString(1,bean.getEmail());  
	ps.setString(2, bean.getPass());  
	              
	ResultSet rs=ps.executeQuery();  
	status=rs.next();  
	} else
	{
		System.out.println("DB Connection failure");
	}
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("DB Connection failure");
	}  
	  
	return status;  
	  
	}  
}  


