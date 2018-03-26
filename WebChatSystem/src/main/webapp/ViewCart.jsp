<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<%@ page import="java.util.HashSet" %>
<%@ page import="com.fdmgroup.Cart.CartObj" %>
<html>
<head>
	<link href="styles/style.css" rel="stylesheet" type="text/css"/>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript">
		<% HashSet<CartObj> cartList = (HashSet<CartObj>) request.getSession().getAttribute("cartList"); %>
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
				<td><label>Quantity				</label></td> 
				<td><label>Price				</label></td> 
			</tr>
	  		<% for(CartObj cart: cartList){ %>
				<tr>
					<td><%= cart.getImage()%></td>	
					<td><%= cart.getProductID() %></td>
					<td><%= cart.getProductName() %></td>
					<td><%= cart.getQuantity()%></td>	
					<td><%= cart.getPrice() %></td> 
				</tr>
			<%}%>
	</table>
	<% if(cartList.size() != 0) { %>
		<form action="checkOut" method="POST" >
			<input type="submit" name="btnCheckOut" value="Check Out"/>
		</form>
	<%} else { %>
			<input type="button" name="btnCheckOut" value="Check Out" disabled/>
	<%} %>
	</div>
</body>
</html>