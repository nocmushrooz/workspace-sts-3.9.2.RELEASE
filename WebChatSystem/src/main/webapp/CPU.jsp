<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fdmgroup.Item.Item" %>
<html>
<head>
	<link href="styles/style.css" rel="stylesheet" type="text/css"/>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript">
		<% ArrayList<Item> CPUList = (ArrayList<Item>) request.getSession().getAttribute("CPUList"); %>
		<% String message = (String)request.getAttribute("alertMsg");%>
		var msg = "<%=message%>";
		if( msg != "null"){	
			alert(msg);
		}
		
	</script>
	<title>Welcome <%= request.getSession().getAttribute("usernameSession") %></title>
</head>
<body>
	<h1>Shopping Catalogue</h1>
	<div class="navbar">
    	<a href="LoginHome.jsp">Main Menu</a>
  		
    		<form method="POST">
    			<input type="Submit" value="CPU" formaction="viewCPU"/>
    			<input type="Submit" value="Ram" formaction="viewRam"/>
    			<input type="Submit" value="Graphic Card" formaction="viewGraphicCard"/>
    		</form>
  		<a style="float:right" href="index.jsp">Logout</a>
	</div>
	<br><br><br>
	<div class="shoppingSite">
		<form action="ViewCart" method="post">
			<input type="submit" value="View Cart" name = "Submit Cart"/>
		</form>	
	<table id="queryTable"> 
			<tr>
				<td><label>Picture				</label></td> 
				<td><label>Product ID			</label></td>
				<td><label>Product Name			</label></td>
				<td><label>Product Description	</label></td> 
				<td><label>Quantity				</label></td> 
				<td><label>Category				</label></td> 
				<td><label>Price				</label></td> 
				<td></td>
			</tr>
	  		<% for(Item iL: CPUList){ %>
				<tr>
					<td><%= iL.getPicture()%></td>	
					<td><%= iL.getProductID() %></td>
					<td><%= iL.getProductName() %></td>
					<td><%= iL.getDescription() %></td> 
					<td><%= iL.getQuantity()%></td>
					<td><%= iL.getCategory()%></td>
					<td><%= iL.getPrice()%></td>		
					<td><form action="AddToCart" method="POST">	
							<input type="number" name="inputQuantity" value="1"><br>
							<input type="hidden" name="hiddenProductID" value="<%= iL.getProductID() %>"/>
							<input type="submit" name="btnSubmit" value="Add To Cart" />
						</form>	</td>			
				</tr>
			<%}%>
	</table>

	</div>
</body>
</html>