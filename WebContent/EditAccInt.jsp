<jsp:useBean id="update" class="com.rohit.java.RegBean" scope="request">
	<jsp:setProperty name="update" property="*" />
</jsp:useBean>
<jsp:forward page="/updateRegister.do"></jsp:forward>
