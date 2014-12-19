<%@page import="com.rohit.java.ContactBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Birthdays</title>
</head>
<body background="Website-Background-26.png">
<div style = "text-align:right;float:right">
	<a href="logout.do"><img src="logout1.png" align="right"/></a><br><br/>
	<a href="editAcc.do"><img src="editacc1.png" align="RIGHT"/></a>
	</div>

<center><h1>     List of Birthdays in next 7 Days</h1></center>
<%
	
	
	if(request.getAttribute("blist")!=null){
		
	
	
	ArrayList<ContactBean> al= (ArrayList<ContactBean>)request.getAttribute("blist");
	
	out.print("<hr>");
	for(ContactBean r:al)
	{
		
		out.print("<center><br/></li>  <li> Name : "+r.getName()+"</li> <li>Email(s) : "+r.getEmails()+"</li> <li>DOB : "+r.getDob()+"</li> <li>PhNo  : "+r.getPhno()+"</li> <li>Tags : "+r.getTags()+"<br><b><a href="+"'"+"editContactView.do?Csl_no="+r.getSl_no()+"'"+">"+"Edit Contact"+"</a></b>"+"<hr>");
		
	}
	}
	
	
%>

</body>
</html>