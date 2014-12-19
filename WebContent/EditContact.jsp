<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII" errorPage="Error.jsp" import="com.rohit.java.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Edit Account</title>
</head>
<body background="Website-Background-26.png">
	<h1>EDIT CONTACT</h1>
	
	<%
		ContactBean cb = (ContactBean) request.getAttribute("contactDetails");
	%>
	
	<form action="EditContactInt.jsp" method="post">
		Name: <input type="text" name="name" value='<%= cb.getName() %>'/><br/>
		Email: <input type="text" name="emails"  value= '<%= cb.getEmails() %>'   /><br/>
		DOB: <input type="text" name="dob" value='<%= cb.getDob() %>'/><br/>
		PH.no<input type="text" name="phno" value='<%= cb.getPhno() %>'/><br/>
		Tags<input type="text" name="tags" value='<%= cb.getTags() %>'/><br/>
		Gender: <input type="text" name="gender" value='<%= cb.getGender() %>'/><br/>
		<br/>
		<input type="submit" value="Update"/>
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