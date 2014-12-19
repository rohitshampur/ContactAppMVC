<jsp:useBean id="log" class= "com.rohit.java.LogBean" scope= "request">
<jsp:setProperty name="log" property="*"/>
</jsp:useBean>
<jsp:forward page="/login.do"></jsp:forward>
