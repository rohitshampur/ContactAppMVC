<jsp:useBean id="updateC" class="com.rohit.java.ContactBean" scope="request">
	<jsp:setProperty name="updateC" property="*" />
</jsp:useBean>
<jsp:forward page="/updateContacts.do"></jsp:forward>
