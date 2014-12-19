
<jsp:useBean id="search" class="com.rohit.java.ContactBean" scope="request">
	<jsp:setProperty name="search" property="*"/>
</jsp:useBean>

<jsp:forward page="/search.do"/>