<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fdmgroup.Item.Item" %>

<html>
<head>
	<link href="styles/style.css" rel="stylesheet" type="text/css"/>
	<title>View Item</title>
	<% Item item =  (Item) request.getSession().getAttribute("selectedItem");%>
</head>
<body>
	<div class="registerUser">
		<h2>Update Item <%= item.getProductID() %></h2>
		<form method="POST" action="checkUpdate" >
			<label>Quantity:</label>
				<input type="text" name="updateQuantity" value="<%= item.getQuantity() %>"><br>
			<label>Price:</label>
				<input type="text" name="updatePrice" value = "<%= item.getPrice() %>"><br>
			<label>Description</label>
				<textarea name="updateDescription"  rows="5" cols="50"><%=item.getDescription() %></textarea><br>
			<input type="hidden" value="<%= item.getProductID() %>" name = "hiddenItem" />
			<input type="submit"value="Back" name="btnBack" formaction="ListAllItems" />
			<input type="submit"value="Update Item" name="btnUpdateItem"  />
		</form>
	</div>
</body>
</html>