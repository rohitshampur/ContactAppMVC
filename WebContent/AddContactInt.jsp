
<jsp:useBean id="contact" class="com.rohit.java.ContactBean" scope="request">
	<jsp:setProperty name="contact" property="*"/>
</jsp:useBean>

<jsp:forward page="/addContact.do"/>