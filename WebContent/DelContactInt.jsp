
<jsp:useBean id="delcontact" class="com.rohit.java.ContactBean" scope="request">
	<jsp:setProperty name="delcontact" property="*"/>
</jsp:useBean>

<jsp:forward page="/deleteContact.do"/>