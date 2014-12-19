<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
</head>
<body>
	<h1>Sucessfully Loggedout</h1>
	
	<a href="HomePage.html">Click to go to HomePage</a>
	<% session.removeAttribute("email");
	   session.removeAttribute("pass");
	   session.removeAttribute("list");
	   session.invalidate();
	   response.setHeader("Cache-Control","no-cache"); 
	   response.setHeader("Cache-Control","no-store"); 
	   response.setDateHeader("Expires", 0); 
	   response.sendRedirect("HomePage.html");

	%>
	
	

</body>
</html>