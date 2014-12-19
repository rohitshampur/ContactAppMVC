<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII" errorPage="Error.jsp" import="com.rohit.java.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Edit Account</title>
</head>
<body background="Website-Background-26.png">
<div style = "text-align:right;float:right">
	<a href="logout.do"><img src="logout1.png" align="right"/></a><br/>
	<a href="Menu.jsp"><img src="goback.png" align="left"/></a>
	</div>
	<center><h1>    EDIT ACCOUNT</h1></center>
	
	<%
		RegBean rb = (RegBean) request.getAttribute("userDetails");
	%>
	
	<form action="EditAccInt.jsp" method="post">
	<center>
	<table  border="1%" width="300" bgcolor="white" style="color:red" >
		<tr><td><b>Enter name:</b></td> <td> <input type="text" name="name" value='<%= rb.getName() %>'/><br/></td></tr>
		<tr><td><b>Enter email:</b></td> <td> <input type="text" name="email"  value= '<%= rb.getEmail() %>' readonly  /><br/></td></tr>
		<tr><td><b>Enter pass: </b></td> <td><input type="password" name="pass" value='<%= rb.getPass() %>'/><br/></td></tr>
		<tr><td><b>Repeat pass:</b></td> <td> <input type="password" name="rpass" value='<%= rb.getPass() %>'/><br/></td></tr>
		<tr><td><input type="submit" value="Update"/></td></tr>
		</table>
		</center>
		
	</form>
	<%
		if(request.getAttribute("message")!=null)
		{
			out.println("<h2>Success</h2>");
			out.println(request.getAttribute("message"));
		}
	
	%>
	
	<%
		if(request.getAttribute("errorMsg")!=null)
		{
			out.println("<h2>Error</h2>");
			out.println(request.getAttribute("errorMsg"));
		}
		
	
	%>
	
</body>
</html>









