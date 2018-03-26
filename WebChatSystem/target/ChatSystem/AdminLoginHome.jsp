<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
	<link href="styles/style.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript">
		<% ArrayList<String> convoList =  (ArrayList<String>) request.getSession().getAttribute("convoList");%>
	
		<% String message = (String)request.getAttribute("alertMsg");%>
		var msg = "<%=message%>";
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
		<br><br><br><br><br><br><br><br>
		<a href="AdminQueryHome.jsp"><input type="button" value="View Query" name="btnQuery"/></a>	
		<br>
		<form action="TotalSold" method="POST">
			<input type="submit" value="Total Sold" name="btnTotalSold" formaction="TotalSold"/><br>
			<br><input type="submit" value="View all Transactions" name="btnViewAllTransaction" formaction="ListAllTransaction" /><br>
			<br><input type="submit" value="View All Items" name="btnViewAllItem" formaction="ListAllItems"/><br>
			<br><input type="submit" value="View All Users" name="btnViewAllUser" formaction="AdminViewAllUser" /><br>
		</form>
		
	</div>
</body>
</html>