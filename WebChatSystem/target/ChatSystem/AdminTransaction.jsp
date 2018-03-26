<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<%@ page import="java.util.HashSet" %>
<%@ page import="com.fdmgroup.Transaction.TransactionObj" %>
<html>
<head>
	<link href="styles/style.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript">
	<% HashSet<TransactionObj> transactionList =  (HashSet<TransactionObj>) request.getSession().getAttribute("transactionList");%>
</script>
<title>Welcome <%= request.getSession().getAttribute("usernameSession") %></title>
</head>
<body>
	<div class="shoppingSite">
		<h1>View Transaction </h1>
		<span class="error">${error}</span><br>
		<br><br>	
		<table id="viewTransactionTable"> 
			<tr>
				<th>Order_ID			</th>
				<th>Username			</th>
				<th>Total Price			</th> 
				<th>Transaction Date	</th>
				<th>Delivery Status		</th>
				<th>Confirm Delivery	</th>
				<th/>
			</tr>
	  		<% for(TransactionObj tO: transactionList){ %>
				<tr>
					<td><%= tO.getOrder_id() %></td>
					<td><%= tO.getUsername() %></td>
					<td><%= tO.getTotalPrice() %></td> 
					<td><%= tO.getTransactionDate()%></td>
					<td><%= tO.getDeliveryStatus()%></td>
					<td><% if(tO.getDeliveryStatus().equalsIgnoreCase("Pending")) { %>
						<form action="deliveredTransaction"  method="POST">	
							<input type="hidden" name="hiddenOrderID" value="<%= tO.getOrder_id() %>"/>
							<input type="submit" name="btnSubmit" value="Delivered"/>
						</form>
						<%}%>
					</td>
					<td><form action="viewTransaction" method="POST">
						<input type="hidden" name="hiddenOrderID" value="<%= tO.getOrder_id() %>"/>
						<input type="submit" name="btnSubmit" value="View Transaction"/>
					</form></td>
					
				</tr>
			<%}%>
		</table>
		<br><br><br>
		<a href="AdminLoginHome.jsp"><input type="button" value="Back To Main Menu" name="btnBack"/></a>
	</div>
</body>
</html>