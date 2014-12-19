package com.rohit.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCHelper {
	public static void close(ResultSet rs)
	{
		try
		{
			if(rs!=null)
				rs.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static void close(Connection con)
	{
		try
		{
			if (con!=null)
				con.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement pr)
	{
		try 
		{	
			if(pr!=null)
			pr.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public static Connection getConnection()
	{
		try 
		{	
			Class.forName(Constants.DRIVER);
			Connection con = DriverManager.getConnection(Constants.URL,Constants.UID,Constants.PASS);
			return con;
			
		} catch (SQLException | ClassNotFoundException e) {
		
			e.printStackTrace();
			return null;
		}
		
	}
}
