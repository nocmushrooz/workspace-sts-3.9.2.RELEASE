<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fdmgroup.Message.Message" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
	<link href="styles/style.css" rel="stylesheet" type="text/css"/>
	<title>View Conversation</title>
	<% ArrayList<Message> messageList =  (ArrayList<Message>) request.getSession().getAttribute("messageList");%>
	<% String queryStatus =  (String) request.getSession().getAttribute("tempQueryStatus");%>
</head>
<body>
	<div class="adminViewQuery">
		<h2>Query <%= request.getSession().getAttribute("viewQuery") %></h2>
		<br>
		<form method="POST" action="AdminSendMessage" name="sendMessageForm">
			<select name="updateStatus" id="updateStatus">
				<% if(queryStatus.equalsIgnoreCase("Pending")) { %>
					<option selected>Pending</option>
					<option>In progress</option>
					<option>Completed</option>
					<option>Closed</option>
				<%} else if(queryStatus.equalsIgnoreCase("In progress")) {%>
					<option >Pending</option>
					<option selected>In progress</option>
					<option>Completed</option>
					<option>Closed</option>
				<%} else if(queryStatus.equalsIgnoreCase("Completed")) {%>
					<option >Pending</option>
					<option >In progress</option>
					<option selected>Completed</option>
					<option>Closed</option>
				<%} else if(queryStatus.equalsIgnoreCase("Closed")) {%>
					<option>Pending</option>
					<option>In progress</option>
					<option>Completed</option>
					<option selected>Closed</option>
				<%}%>
			</select>
			<br>
			<textarea  readonly="readonly" name="MessageArea"><% for(Message mL: messageList){ %><%= mL.getSenderUsername() %> <%= mL.getDateNTime() %>-><%= mL.getMessages() %>&#10;<%}%></textarea>
			<br>
			<textarea name="message"></textarea><br><br>
			<a href="AdminQueryHome.jsp"><input type="button" value="Back To Main Menu" name="btnBack" id="btnAdminViewQuery" /></a>
			<input type="submit"value="Send Message" name="btnSendMessage" id="btnAdminViewQuery" />
		</form>
	</div>
</body>
</html>