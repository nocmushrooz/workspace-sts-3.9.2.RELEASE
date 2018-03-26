<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fdmgroup.Item.Item" %>
<html>
<head>
	<link href="styles/style.css" rel="stylesheet" type="text/css"/>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript">
		<% ArrayList<Item> randomList = (ArrayList<Item>) request.getSession().getAttribute("randomList"); %>
		<% String message = (String)request.getAttribute("alertMsg");%>
		var msg = "<%=message%>";
		if( msg != "null"){	
			alert(msg);
		}
		
	</script>
	<title>Welcome <%= request.getSession().getAttribute("usernameSession") %></title>
</head>
<body>
	<h1>Shopping catalogue</h1>
	<br><br>
	<div class="navbar">
    	<a href="LoginHome.jsp">Main Menu</a>
    		<form method="POST">
    			<input type="Submit" value="CPU" name="btnCatalog1" formaction="viewCPU"/>
    			<input type="Submit" value="Ram" name="btnCatalog1" formaction="viewRam"/>
    			<input type="Submit" value="Graphic Card" name="btnCatalog1" formaction="viewGraphicCard"/>
    		</form>
  		<a style="float:right" href="index.jsp">Logout</a>
	</div>
	<div class="shoppingSite">
		<br><br>
		<form action="ViewCart" method="post">
			<input type="submit" value="View Cart" name = "Submit Cart"/>
		</form>	
		<br><br>
		<table id="viewTransactionTable"> 
				<tr>
					<th>Picture					</th> 
					<th>Product ID				</th>
					<th>Product Name			</th>
					<th>Product Description		</th> 
					<th>Quantity				</th> 
					<th>Category				</th> 
					<th>Price					</th> 
					<th></th>
				</tr>
		  		<% for(Item iL: randomList){ %>
					<tr>
						<td><%= iL.getPicture()%></td>	
						<td><%= iL.getProductID() %></td>
						<td><%= iL.getProductName() %></td>
						<td><%= iL.getDescription() %></td> 
						<td><%= iL.getQuantity()%></td>
						<td><%= iL.getCategory()%></td>
						<td><%= iL.getPrice()%></td>		
						<td><form action="AddToCart" method="POST">	
								<input type="number" name="inputQuantity" value="1">
								<input type="hidden" name="hiddenProductID" value="<%= iL.getProductID() %>"/>
								<input type="submit" name="btnSubmit" value="Add To Cart" />
							</form>	</td>			
					</tr>
				<%}%>
		</table>
	</div>
</body>
</html>