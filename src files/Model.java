package com.rohit.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rohit.java.JDBCHelper;
import com.rohit.java.RegBean;
import com.rohit.java.Constants;
import com.rohit.java.ContactBean;

public class Model {
	public String  register(RegBean r)
	{	
		System.out.println("Inside of Model's register()");
		String result = r.validate();
		System.out.println(r);
		System.out.println(result);
		if(result.equals(Constants.SUCCESS))
		{
			Connection con = null;
			ResultSet rs =null;
			PreparedStatement ps_sel = null,ps_ins=null;
			try
				{
				con = JDBCHelper.getConnection();
				System.out.println(con);
				if(con==null)
				return "Connection not established to DataBase";
				else
				{
					ps_sel = con.prepareStatement("select * from register where email = ?");
					ps_sel.setString(1,r.getEmail());
					ps_sel.execute();
					rs = ps_sel.getResultSet();
					System.out.println("rs output---->"+rs);
					if(rs.next())
					{	System.out.println("if block rs.next() output---->"+rs);

						return "Email already exists , please enter new email";
					}
					else
					{
						ps_ins = con.prepareStatement("insert into register (name,email,pass)values(?,?,?)");
						ps_ins.setString(1,r.getName());
						ps_ins.setString(2,r.getEmail());
						ps_ins.setString(3,r.getPass());
						ps_ins.execute();
						return Constants.SUCCESS;
					}
				}
				}catch(SQLException e)
				{
					e.printStackTrace();
					return "Opps Something went wrong "+e.getMessage();
				}finally{
					JDBCHelper.close(rs);
					JDBCHelper.close(ps_sel);
					JDBCHelper.close(ps_ins);
					JDBCHelper.getConnection();
					
				}
				}else
				{
					return result;
				}
				
		}
	public String login(LogBean l)
	{	
		System.out.println("inside login() of model");
		Connection con = null;
		con = JDBCHelper.getConnection();
		System.out.println(con);
		String result="";
		if(con==null) 
			return "DATABASE Connection Failed";
		else
		{	
			boolean status;
			result = l.validate();
			System.out.println(result);
			if(result.contains(Constants.SUCCESS))
			{	
				System.out.println("inside if block of result.contains");
				status = LoginDAO.validate(l);
				if(status==true)
				{
				return Constants.SUCCESS;
				}else  
				  return " Email or Password is Invalid";
			}return result;
		}
	}
		public RegBean getUserDetails(String email) {
		Connection con = null;
		PreparedStatement ps_sel = null;
		ResultSet rs = null;
		RegBean bean = null;
		System.out.println("inside getusersDetails");
		try
		{
			con = JDBCHelper.getConnection();
			if(con==null)
				
				throw new RuntimeException("DATABASE Connection Failure ,contact ADMIN");
			else
			{	System.out.println("inside if block getuserdetails");
				ps_sel = con.prepareStatement("select * from register where email = ?");
				ps_sel.setString(1, email);
				ps_sel.execute();
				rs = ps_sel.getResultSet();
				bean = new RegBean();
				while(rs.next())
				{
					bean.setName(rs.getString("name"));
					bean.setEmail(rs.getString("email"));
					bean.setPass(rs.getString("pass"));
				}
				return bean;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_sel);
			JDBCHelper.close(con);
		}
		
	}
	public String updateRegister(RegBean rb)
	{
		System.out.println(" inside of Model updateRegister method");
		String result=rb.validate();
		System.out.println(result);
		if(result.equals(Constants.SUCCESS))
		{
			Connection con = null;
			ResultSet rs = null;
			PreparedStatement ps_sel=null,ps_ins=null;
			
			try
			{
				con = JDBCHelper.getConnection();
				if(con==null)
				return "DATABASE Connection failed , contact your admin ";
				else
				{
					
					PreparedStatement ps_upd = con.prepareStatement("update register set name=? , pass=? where email = '"+rb.getEmail()+"'");
					ps_upd.setString(1, rb.getName());
					ps_upd.setString(2, rb.getPass());
					ps_upd.execute();
					
					return Constants.SUCCESS;
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return "Some problem has been occured , contact ADMIN";
			}
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_sel);
				JDBCHelper.close(ps_ins);
			}		
		}else
		{
			return result;
		}
	}
	public List<RegBean> listUsers() {
		Connection con = null;
		PreparedStatement ps_sel = null;
		ResultSet rs = null;
		RegBean bean = null;
		List<RegBean> users = null;
		try
		{
			con = JDBCHelper.getConnection();
			if(con==null)
				throw new RuntimeException("Connection cannot be established. Contact Admin!");
			else
			{
				ps_sel = con.prepareStatement("select * from register");
			
				ps_sel.execute();
				rs = ps_sel.getResultSet();
				users = new ArrayList<RegBean>();
				
				while(rs.next())
				{
					bean = new RegBean();
					bean.setName(rs.getString("name"));
					bean.setEmail(rs.getString("email"));
					users.add(bean);
				}
				return users;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_sel);
			JDBCHelper.close(con);
		}		
		
		
	}
	public String addContact(ContactBean cb ,String email) {
		
			System.out.println("Model->inside addContact()");
			System.out.println("Model-> "+cb.getName()+" "+cb.getEmails()+" "+cb.getDob()+" "+cb.getPhno()+" "+cb.getGender());
			System.out.println(email);
			System.out.println("Model-> apply input validations");
			
			String result = cb.validate();
			if(result.equals(Constants.SUCCESS))
			{
				
					Connection con = null;
					ResultSet rs =null;
					PreparedStatement ps_sel = null,ps_ins=null;
					try
						{
						con = JDBCHelper.getConnection();
						System.out.println(con);
						if(con==null)
						return "Connection not established to DataBase";
						else
							{	
								ps_sel = con.prepareStatement("select sl_no from register where email = '"+email+"'");
								ps_sel.execute();
								rs = ps_sel.getResultSet();
								String sl_no = null;
								if(rs.next())
								{
									sl_no =rs.getString("sl_no");
									System.out.println(sl_no);
								}
								
								
								
								ps_ins = con.prepareStatement("insert into contacts (name, reg_sl,emails,phno,dob,gender,tags)values(?,?,?,?,?,?,?)");
								
								ps_ins.setString(1,cb.getName());
								ps_ins.setString(2, sl_no);
								ps_ins.setString(3,cb.getEmails());
								ps_ins.setString(4,cb.getPhno());
								ps_ins.setString(5,cb.getDob());
								ps_ins.setString(6,cb.getGender());
								ps_ins.setString(7,cb.getTags());
								ps_ins.execute();
								return Constants.SUCCESS;
							}
						}
						catch(SQLException e)
						{
							e.printStackTrace();
							return "Opps Something went wrong "+e.getMessage();
						}finally{
							JDBCHelper.close(rs);
							JDBCHelper.close(ps_sel);
							JDBCHelper.close(ps_ins);
							JDBCHelper.getConnection();
							
						}
					}
						else
						{
							return result;
						}
				
				
		}
	@SuppressWarnings("resource")
	public List<ContactBean> listContacts(String email) {
		System.out.println("inside listContacts");
		Connection con = null;
		PreparedStatement ps_sel = null;
		ResultSet rs = null;
		ContactBean bean = null;
		List<ContactBean> users = null;
		try
		{
			con = JDBCHelper.getConnection();
			if(con==null)
				throw new RuntimeException("Connection cannot be established. Contact Admin!");
			else
			{
				ps_sel = con.prepareStatement("select sl_no from register where email = '"+email+"'");
				ps_sel.execute();
				rs = ps_sel.getResultSet();
				String sl_no = null;
				if(rs.next())
				{	
					sl_no =rs.getString("sl_no");
					System.out.println(sl_no);
				}
			
			
				
				ps_sel = con.prepareStatement("select * from contacts where reg_sl = '"+sl_no+"'");
				ps_sel.execute();
				rs = ps_sel.getResultSet();
				users = new ArrayList<ContactBean>();
				
				while(rs.next())
				{
					bean = new ContactBean();
					bean.setName(rs.getString("name"));
					bean.setEmails(rs.getString("emails"));
					bean.setPhno(rs.getString("phno"));
					bean.setDob(rs.getString("dob"));
					bean.setGender(rs.getString("gender"));
					bean.setTags(rs.getString("tags"));
					bean.setSl_no(rs.getString("sl_no"));
					users.add(bean);
				}
				return users;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_sel);
			JDBCHelper.close(con);
		}		
	}
		public ContactBean getContactDetails(String sl_no) {
		Connection con = null;
		PreparedStatement ps_sel = null;
		ResultSet rs = null;
		ContactBean bean = null;
		System.out.println("inside getusersDetails");
		try
		{
			con = JDBCHelper.getConnection();
			if(con==null)
				
				throw new RuntimeException("DATABASE Connection Failure ,contact ADMIN");
			else
			{	System.out.println("inside if block getuserdetails");
				ps_sel = con.prepareStatement("select * from contacts where sl_no = ?");
				ps_sel.setString(1, sl_no);
				ps_sel.execute();
				rs = ps_sel.getResultSet();
				bean = new ContactBean();
				while(rs.next())
				{
					bean.setName(rs.getString("name"));
					bean.setEmails(rs.getString("emails"));
					bean.setPhno(rs.getString("phno"));
					bean.setDob(rs.getString("dob"));
					bean.setGender(rs.getString("gender"));
					bean.setTags(rs.getString("tags"));
					
				}
				return bean;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_sel);
			JDBCHelper.close(con);
		}
		
	}public String updateContact(ContactBean cb,String sl_no)
	{
		System.out.println(" inside of Model updateContact method");
		String result=cb.validate();
		System.out.println(result);
		System.out.println(sl_no);
		if(result.equals(Constants.SUCCESS))
		{
			Connection con = null;
			ResultSet rs = null;
			PreparedStatement ps_sel=null,ps_ins=null;
			
			try
			{
				con = JDBCHelper.getConnection();
				if(con==null)
				return "DATABASE Connection failed , contact your admin ";
				else
				{
					
					PreparedStatement ps_upd = con.prepareStatement("update contacts set name=? ,emails=?, phno=?,dob=?,gender=?,tags=? where sl_no = '"+sl_no+"'");
					ps_upd.setString(1, cb.getName());
					ps_upd.setString(2, cb.getEmails());
					ps_upd.setString(3, cb.getPhno());
					ps_upd.setString(4, cb.getDob());
					ps_upd.setString(5, cb.getGender());
					ps_upd.setString(6, cb.getTags());
					ps_upd.execute();
					
					return Constants.SUCCESS;
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return "Some problem has been occured , contact ADMIN";
			}
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_sel);
				JDBCHelper.close(ps_ins);
			}		
		}else
		{
			return result;
		}
	}
	@SuppressWarnings("resource")
	public List<ContactBean> searchContacts(String value,String searchStr,String email) {
		System.out.println("inside searchContacts");
		System.out.println(value);
		System.out.println(searchStr);
		Connection con = null;
		PreparedStatement ps_sel = null;
		ResultSet rs = null;
		ContactBean bean = null;
		List<ContactBean> users = null;
		try
		{
			con = JDBCHelper.getConnection();
			if(con==null)
				throw new RuntimeException("Connection cannot be established. Contact Admin!");
			else
			{	
				ps_sel = con.prepareStatement("select sl_no from register where email = '"+email+"'");
				ps_sel.execute();
				rs = ps_sel.getResultSet();
				String sl_no = null;
				if(rs.next())
				{	
					sl_no =rs.getString("sl_no");
					System.out.println(sl_no);
				}
				ps_sel = con.prepareStatement("select * from contacts where reg_sl='"+sl_no+"' AND "+value+" like '%"+searchStr+"%"+"'"); 
				ps_sel.execute();
				rs = ps_sel.getResultSet();
				users = new ArrayList<ContactBean>();
				
				while(rs.next())
				{
					bean = new ContactBean();
					bean.setName(rs.getString("name"));
					bean.setEmails(rs.getString("emails"));
					bean.setPhno(rs.getString("phno"));
					bean.setDob(rs.getString("dob"));
					bean.setGender(rs.getString("gender"));
					bean.setTags(rs.getString("tags"));
					bean.setSl_no(rs.getString("sl_no"));
					users.add(bean);
				}
				return users;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_sel);
			JDBCHelper.close(con);
		}
	}
	
	public String delContact(ContactBean cb, String sl_no)
	{
		System.out.println("Model->inside delContact()");
		//System.out.println("Model-> "+cb.getName()+" "+cb.getEmails()+" "+cb.getDob()+" "+cb.getPhno()+" "+cb.getGender());
		System.out.println(sl_no);
				Connection con = null;
				ResultSet rs =null;
				PreparedStatement ps_sel = null,ps_ins=null;
				try
					{
					con = JDBCHelper.getConnection();
					System.out.println(con);
					if(con==null)
					return "Connection not established to DataBase";
					else
						{	
							ps_sel = con.prepareStatement("delete from Contacts where sl_no = '"+sl_no+"'");
							ps_sel.execute();
					
						}
					}
					catch(SQLException e)
					{
						e.printStackTrace();
						return "Opps Something went wrong "+e.getMessage();
					}finally{
						JDBCHelper.close(rs);
						JDBCHelper.close(ps_sel);
						JDBCHelper.close(ps_ins);
						JDBCHelper.getConnection();
						
					}
				return Constants.SUCCESS;
				}
	public List<ContactBean> bdayRmndr(String email) {
		System.out.println("inside bday() of model");
					List<ContactBean> users = listContacts(email);
					List<String> next7Days =DateHelper.listOfDates();
					System.out.println(next7Days);
					List<ContactBean> birthdayList = new ArrayList<>();
					for(ContactBean cb:users)
					{
						String condob=cb.getDob();
						System.out.println(condob);
						String month=condob.substring(5,7);
						String day=condob.substring(8,10);
						System.out.println("bdmonth "+month);
						System.out.println("bdday "+day);
							two:for(String s:next7Days)
							{	
								String pmonth=s.substring(5,7);
								int thisMonth =Integer.parseInt(pmonth);
								System.out.println(thisMonth);
								int nextMonth =thisMonth+1;
								String nday=s.substring(8,10);
								if(pmonth.equals(month) & nday.equals(day))
								{
									birthdayList.add(cb);
									break two;
								}
							}

						}
						
					

				return birthdayList;
			}
		}
		