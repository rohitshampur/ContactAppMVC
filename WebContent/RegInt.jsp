<jsp:useBean id="reg" class= "com.rohit.java.RegBean" scope = "request">
<jsp:setProperty name="reg" property="*"/>
</jsp:useBean>
<jsp:forward page="/register.do"></jsp:forward>