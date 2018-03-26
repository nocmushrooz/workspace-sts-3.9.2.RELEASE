<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fdmgroup.Item.Item" %>
<html>
<head>
	<link href="styles/style.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript">
		<% ArrayList<String> convoList =  (ArrayList<String>) request.getSession().getAttribute("convoList");%>
	
		<% String message = (String)request.getAttribute("alertMsg");%>
		var msg = "<%= message %>";
		if( msg != "null"){	
			alert(msg);
		}
	</script>
<title>Welcome <%= request.getSession().getAttribute("usernameSession") %></title>
</head>
<body>
	<div class="shoppingSite">
		<h1 id="H1">Welcome <%= request.getSession().getAttribute( "usernameSession" ) %> </h1>
		<form method="POST" action="Logout" name="LogoutForm">
			<input type="submit" value="Logout" name="btnLogout" />
		</form>
		<br><br><br><br><br>
		<span class="error" style="color:red">${error}</span><br>
		<a href="UpdateUser.jsp"><input type="button" value="Update User Details" name="btnCUpdateUserDetails" /></a>
		<br><br>
		<form action="retrieveCatalog" method="POST">
			<input type="submit" value="View Catalog" name="btnCatalog" />
		</form>
		<br>
		<a href="QueryHome.jsp"><input type="button" value="Check on Order Queries" name="btnQuery"/></a>	
	</div>
</body>
</html>