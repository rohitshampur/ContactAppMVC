<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.rohit.java.RegBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
	<h1><b><i>SUCCESSFULLY LOGGED IN</i></b></h1>
	<% 	//String name = (String)session.getAttribute("name");
		//out.println("WELOCOME "+name+"<br/>");
	%>
	<br/><a href="menu.do">Click to Enter MENU</a><br/>
	<form action="logout.do">
	<p align="right"><input type = "submit" value ="Logout"></p>
	</form>

</body>
</html>