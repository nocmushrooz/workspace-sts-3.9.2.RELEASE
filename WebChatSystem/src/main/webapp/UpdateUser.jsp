<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<link href="styles/style.css" rel="stylesheet" type="text/css"/>
	<title>Update User Details</title>
	<script type="text/javascript">
		<% String message = (String)request.getAttribute("alertMsg");%>
		var msg = "<%=message%>";
		if( msg != "null"){	
			alert(msg);
		}
	</script>
</head>
<body>
	<br><br>
	<h1 id="updateH1">Updating <%= request.getSession().getAttribute( "usernameSession" ) %>'s details</h1>
	<div class="shoppingSiteUpdate">
		<form action="UpdateUser" method="POST"> 
			<label id="updateLabel">Email*:<br>
				<input type="email" name="email" id="updateBox" placeholder="Your new email address ..." value="<%= (String)session.getAttribute("emailAddressSession") %>" /> <!-- pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" -->
			</label>
			<br><br><label id="updateLabel">Password*:<br>
				<input type="password" name="password" id="updateBox" placeholder="Your new password ..." value="<%= (String)session.getAttribute("passwordSession") %>" />
			</label>
			<br><br><label id="updateLabel">Address*:<br>
				<input type="text" id="updateBox" name="address" placeholder="Your new address ..." value="<%= (String)session.getAttribute("addressSession") %>" />
			</label>
			<br><br><label id="updateLabel">Postal Code*:<br>
				<input type="text" id="updateBox" name="postalCode" placeholder="Your new postal code ..." value="<%= (Integer)session.getAttribute("postalCodeSession") %>" />
			</label>
			<br><br><label id="updateLabel">Contact Number*:<br>
				<input type="text" id="updateBox" name="contactNum" placeholder="Your new contact number ..." value="<%= (Integer)session.getAttribute("contactNumberSession") %>" />
			</label><br><br><br>
			<a href="LoginHome.jsp"><input type="submit" value="Submit" name="updateBtn" /></a> 
		</form>
		<a href="LoginHome.jsp"><input type="submit" value="Back to Main Menu" name="updateBtn" /></a> 
	</div>
</body>
</html>