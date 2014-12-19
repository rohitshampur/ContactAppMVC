<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body background="sky.jpg">
	<a href="AdminMenu.jsp"><img src="menu.png" align="middle"/></a>
	<%
		
		if(request.getAttribute("message")!=null)
		{	String m = (String)request.getAttribute("message");
			out.println("<h2>Success</h2>");
			out.println("<h1>"+m+"</h1>");
		}
	
	%>
	<%
		if(request.getAttribute("errorMsg")!=null)
		{	
			String e =(String)request.getAttribute("errorMsg");
			out.println("<h1>Update Failed<h1>");
			out.println("<h1>Error</h1>");
			out.println("<h2>"+e+"<h2>");
		}
	
	%>

</body>
</html>