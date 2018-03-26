<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fdmgroup.User.User" %>
<html>
<head>
	<link href="styles/style.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript">
	<% ArrayList<User> userList =  (ArrayList<User>) request.getAttribute("ExistingUserList");%>
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
		<h1>View All user </h1>
		<span class="error">${error}</span><br>
		<a href="AdminRegister.jsp" ><input type="button" value="Register New User"/></a>
		<br><br><br><br>
		<table id="viewTransactionTable"> 
			<tr>
				<th>Username		</th>
				<th>User Address	</th>
				<th>Postal Code		</th> 
				<th>Name			</th> 
				<th>Contact Number	</th> 
				<th>Email Address	</th> 
				<th>User Type		</th> 
			</tr>
	  		<% for(User user: userList){ %>
				<tr>
					<td><%= user.getUsername() %></td>
					<td><%= user.getUserAddress() %></td>
					<td><%= user.getPostalCode() %></td> 
					<td><%= user.getName()%></td>
					<td><%= user.getContactNumber()%></td>
					<td><%= user.getEmailAddress()%></td>	
					<td><%= user.getUserType()%></td>						
				</tr>
			<%}%>
		</table>
		<br><br><br>
		<a href="AdminLoginHome.jsp"><input type="button" value="Back To Main Menu" name="btnBack"/></a>
	</div>
</body>
</html>