<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
	<link href="styles/style.css" rel="stylesheet" type="text/css"/>
	<% ArrayList<String> newChatList = (ArrayList<String>) request.getSession().getAttribute("newChatList");%>
	<title>Start new query</title>
</head>
<body>
	<div class="newQuery">
		<h2>Start new query</h2>
		<form action="InitiateQuery" method="POST">
			<span class="error">${error}</span><br>
			<label>Category:</label>
			<br>
			<select name="categoryField" required>
				<option>Shipping</option>
				<option>Item</option>
				<option>General</option>
				<option>Refund</option>
			</select><br><br>
			<label>Subject:</label><br>
			<textarea name="subjectArea" required ></textarea><br>
			<a href="QueryHome.jsp"><input type="button" value="Back" name="btnBack" id="btnNewQuery" /></a>
			<input type="submit" value="Submit" name="btnStartQuery" id="btnNewQuery" />
		</form>
	</div>
</body>
</html>