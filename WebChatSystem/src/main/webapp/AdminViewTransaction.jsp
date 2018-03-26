<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<%@ page import="java.util.HashSet" %>
<%@ page import="com.fdmgroup.CheckOut.CheckOutObj" %>
<html>
<head>
	<link href="styles/style.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript">
	<% HashSet<CheckOutObj> itemList =  (HashSet<CheckOutObj>) request.getSession().getAttribute("viewTransaction");%>
</script>
<title>Welcome <%= request.getSession().getAttribute("usernameSession") %></title>
</head>
<body>
	<div class="shoppingSite">
		<h1>View order ID:  <%= request.getSession().getAttribute("orderID") %> </h1>
		<span class="error">${error}</span><br>
		<br><br>	
		<table id="viewTransactionTable"> 
			<tr>
				<th>Product ID		</th>
				<th>Product Name	</th>
				<th>Price			</th> 
				<th>Quantity		</th> 
			</tr>
	  		<% for(CheckOutObj checkOutObj: itemList){ %>
				<tr>
					<td><%= checkOutObj.getProductID() %></td>	
					<td><%= checkOutObj.getProductName() %></td>
					<td><%= checkOutObj.getTotalPrice() %></td> 
					<td><%= checkOutObj.getQuantity()%></td>
				</tr>
			<%}%>
		</table>
		<br><br>
		<form action="ListAllTransaction" method="POST">
			<input type="submit" value="Back" name="btnBack" />
		</form>
	</div>
</body>
</html>