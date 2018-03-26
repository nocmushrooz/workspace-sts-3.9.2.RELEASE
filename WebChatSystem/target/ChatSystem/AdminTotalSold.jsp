<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<%@ page import="java.util.HashSet" %>
<%@ page import="com.fdmgroup.TotalSold.TotalSoldObj" %>
<html>
<head>
	<link href="styles/style.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript">
	<% HashSet<TotalSoldObj> TotalSold =  (HashSet<TotalSoldObj>) request.getSession().getAttribute("totalSoldList");%>
</script>
<title>Welcome <%= request.getSession().getAttribute("usernameSession") %></title>
</head>
<body>
	<div class="shoppingSite">
		<h1>View Total Sold </h1>
		<span class="error">${error}</span><br>
		<br><br>	
		<table id="viewTransactionTable"> 
			<tr>
				<th>Product ID		</th>
				<th>Product Name	</th>
				<th>Price			</th> 
				<th>Quantity		</th> 
			</tr>
	  		<% for(TotalSoldObj tS: TotalSold){ %>
				<tr>
					<td><%= tS.getProductID() %></td>
					<td><%= tS.getProductName() %></td>
					<td><%= tS.getPrice() %></td> 
					<td><%= tS.getQuantity()%></td>
				</tr>
			<%}%>
		</table>
		<br><br><br>
		<a href="AdminLoginHome.jsp"><input type="button" value="Back To Main Menu" name="btnBack"/></a>
	</div>
</body>
</html>