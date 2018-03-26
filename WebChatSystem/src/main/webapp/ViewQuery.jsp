<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fdmgroup.Message.Message" %>
<html>
<head>
	<link href="styles/style.css" rel="stylesheet" type="text/css"/>
	<title>View Conversation</title>
	<% ArrayList<Message> messageList =  (ArrayList<Message>) request.getSession().getAttribute("messageList");%>
</head>
<body>
	<div class="newQuery">
		<h2>Query <%= request.getSession().getAttribute("viewQuery") %></h2>
		<form method="POST" action="sendMessage" name="sendMessageForm">
			<textarea  readonly="readonly"   name="MessageArea" rows="20" cols="60"><% for(Message mL: messageList){ %><%= mL.getSenderUsername() %> <%= mL.getDateNTime() %>-><%= mL.getMessages() %>&#10;<%}%></textarea>
			<br>
			<textarea name="message" cols="60" required></textarea><br><br>
			<a href="QueryHome.jsp"><input type="button" value="Back To Main Menu" name="btnBack" id="btnViewQuery" /></a>
			<input type="submit" value="Send Message" name="btnSendMessage" id="btnViewQuery" />
		</form>
	</div>
</body>
</html>