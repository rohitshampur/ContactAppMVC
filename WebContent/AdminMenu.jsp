
<HTML>
<HEAD>
<style>
#header {
    background-color:transparent;
    color:white;
    text-align:center;
    padding:5px;
}
#nav {
    line-height:30px;
    background-color:;
    height:500px;
    width:165px;
    float:left;
    padding:20px; 
}
a:link{
color:blue;
background-color:transparent;
}
a:hover{
colour:black;
background-color: #def;
}
#contentwrap {
    width: 1250px;
    height:300;
    float: center;
    margin: 0 auto;
}

#content {
    background:;
   
    margin: 5px;
}


#footer {
   
    color:red;
    clear:both;
    text-align:left;
    width:500px
    padding:1px; 
}
</style>
</HEAD>
<body background="Website-Background-26.png">

<div id="header">
<img src="logo contact.jpg"align="middle" style="width:1200px;height:200px">
<h3><a href="logout.do"><img src="logout.png" align="right"/></a></h3>
	

</div>

<div id="contentwrap">
        <div id="content">

<form action="">

<h2 style="color:Blue;">WELCOME <%= session.getAttribute("uname") %></h2>
<a href="editAcc.do"><img src="editacc.png" align="middle"/></a><br/>
<a href="listUser.do"><img src="listuser.png" align="middle"/></a><br/>
<a href="openAddContactView.do"><img src="addcontact.png" align="middle"/></a><br/>
<a href="openListContact.do"><img src="listcontact.png" align="middle"/></a><br/>
<a href="searchContact.do"><img src="searchcontact.png" align="middle"/></a><br/>
<a href="bdayRmndr.do"><img src="birthday.png" align="middle"/></a><br/><br/>
</form>
</div>
</div>


<div id="section">

 

 
<p>

</p>
</div>

<div id="footer">

<a href=""><img src="facebook button.png" align="right" width="60" height="60"/></a>
<a href=""><img src="google+.png" align="right" width="60" height="60"/></a>
<a href=""><img src="linkind in.png" align="right" width="60" height="60"/></a>
<a href=""><img src="twitt.png" align="right" width="60" height="60"/></a>
</div>

</body>
</HTML>
