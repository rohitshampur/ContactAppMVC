<%@page import="com.rohit.java.ContactBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contacts</title>
</head>
<body background="Website-Background-26.png">
<div style = "text-align:right;float:right">
	<form action="logout.do">
	<p align="right"><input type = "submit" value ="Logout"></p>
	</form>
	<form action="Menu.jsp">
	<p align="left"><input type = "submit" value ="GO BACK"></p>
	</form>
	</div>
	<% 	
	
	String s = (String)session.getAttribute("email"); 
	out.print(s);
	if(s==null)
	{	
		
		RequestDispatcher rd = request.getRequestDispatcher("HomePage.html");
		rd.forward(request,response);
	}
%>
<h1 style="color:Blue" align="center">Existing Contacts</h1>
<%
	ArrayList<ContactBean> al= (ArrayList<ContactBean>)request.getAttribute("list1");
	int uid=0;
	for(ContactBean r:al)
	{
		uid++;
		out.print("<li>SL No "+uid+"</li>  <li> Name : "+r.getName()+"</li> <li>Email(s) : "+r.getEmails()+"</li> <li>DOB : "+r.getDob()+"</li> <li>PhNo  : "+r.getPhno()+"</li> <li>Tags : "+r.getTags()+"<br><b><a href="+"'"+"editContactView.do?Csl_no="+r.getSl_no()+"'"+">"+"Edit Contact"+"</a></b>"+"<br><b><a href="+"'"+"deleteContact.do?Csl_no="+r.getSl_no()+"'"+">"+"Delete Contact"+"</a></b>"+"<hr>");
		
	}
	uid=0;
	
%>
</body>
</html>