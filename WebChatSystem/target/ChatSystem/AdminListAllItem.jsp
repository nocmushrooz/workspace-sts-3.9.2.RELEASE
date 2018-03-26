<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fdmgroup.Item.Item" %>
<html>
<head>
	<link href="styles/style.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript">
	<% ArrayList<Item> itemList =  (ArrayList<Item>) request.getSession().getAttribute("adminItemList");%>
	
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
		<h1>View All Items</h1>
		<span class="error">${error}</span><br>
		<br>
		<table id="queryTable"> 
			<tr>
				<td><label>Product ID			</label></td>
				<td><label>Product Name			</label></td>
				<td><label>Product Description	</label></td> 
				<td><label>Quantity				</label></td> 
				<td><label>Category				</label></td> 
				<td><label>Picture				</label></td> 
				<td><label>Price				</label></td> 
				<td></td>
			</tr>
	  		<% for(Item iL: itemList){ %>
				<tr>
					<td><%= iL.getProductID() %></td>
					<td><%= iL.getProductName() %></td>
					<td><%= iL.getDescription() %></td> 
					<td><%= iL.getQuantity()%></td>
					<td><%= iL.getCategory()%></td>
					<td><%= iL.getPicture()%></td>	
					<td><%= iL.getPrice()%></td>		
					<td><form action="updateItem" method="POST">	
							<input type="hidden" name="hiddenProductID" value="<%= iL.getProductID() %>"/>
							<input type="submit" name="btnEdit" value="Edit" />
						</form>	</td>			
				</tr>
			<%}%>
		</table>
		<br><br><br>
		<a href="AdminLoginHome.jsp"><input type="button" value="Back To Main Menu" name="btnBack"/></a>
	</div>
</body>
</html>