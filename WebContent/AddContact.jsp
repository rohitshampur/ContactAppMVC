<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add Contact</title>
</head>
<body background="Website-Background-26.png">
	
	
	<div style = "text-align:right;float:right">
	<a href="logout.do"><img src="logout1.png" align="right"/></a><br><br/>
	<a href="editAcc.do"><img src="editacc1.png" align="right"/></a><br/>
	<a href="Menu.jsp"><img src="goback.png" align="right" /></a><
	</div>
	<center><h1 style="color:blue;"><big>Add Contact</big></h1></center>
	<form action="AddContactInt.jsp">
		<center>
		<table  border="0.1%" width="30" bgcolor="white" style="color:red" >
		<tr><td><b>Enter name:</b></td> <td> <input type="text" name="name" value="${reg.name }"/></td></tr>
		<tr><td><b>Enter email(s):</b></td> <td> <input type="text" name="emails" value="${reg.emails }"/></td></tr>
		<tr><td><b>Enter Mob Number :</b></td> <td> <input type="text" name="phno" value="${reg.phno }" /></td></tr>
		<tr><td><b>Enter dob(yyyy-MM-dd): </b></td> <td> <input type="date" name="dob" value="${reg.dob}"/></td></tr>
		<tr><td><b>Enter tags :</b></td> <td><input type="text" name="tags" value ="${reg.tags }"/></td></tr>
		<tr><td><b>Gender :</b></td> <td><SELECT type="text" name="gender" gender="Select"><option><option>male<option>female</SELECT>
		</td></tr>
		<tr><td><b><input type="submit" value ="Add Contact"/></td></tr>
		</table>
		</center>
		</form>
	
	
	
	<% 
	out.println("<br/>");
		if(request.getAttribute("message")!=null)
		{
			String msg = (String) request.getAttribute("message");
			out.println("<h2>Successfully added the contact</h2>");
			out.println("<b>"+msg+"</b>");
			
		}
	
	%>
	
	<% 
		out.println("<br/>");
		if(request.getAttribute("errorMsg")!=null)
		{
			String msg = (String) request.getAttribute("errorMsg");
			
			out.println("<center><h2>Error</h2></center>");
			out.println("<center><b>"+msg+"</b></center>");
			
		}
	
	%>
	
	
	
	
	
</body>
</html>




