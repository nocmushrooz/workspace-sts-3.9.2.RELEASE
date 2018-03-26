<html>
<head>
	<link href="styles/style.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript">
	<% String message = (String)request.getAttribute("alertMsg");%>
	var msg = "<%=message%>";
	if( msg != "null"){	
		alert(msg);
	}
	</script>
</head>
<body>
	<div class="shoppingSiteWithBanner">
		<h2>Welcome to WGW Shopping Site</h2>
		<form action="Login" method="POST">
		 	<span class="error" style="color:red">${error}</span><br>
		 	<table id="indexTable">
				<tbody>
					<tr>
			 			<td id="textLabel"><strong>Username</strong></td>
			 			<td id="textBox"><input type="text" id="indexBox" name="Username" placeholder="Your username ..." /></td>
					</tr>
					<tr>
			 			<td id="textLabel"><strong>Password</strong></td>
			 			<td id="textBox"><input type="password" id="indexBox" name="Password" placeholder="Your password ..." /></td> 
			   		</tr>
					<tr>
						<td><a href="Register.jsp"><input type="button" value="Register" name="indexBtn"/></a></td>
						<td><input type="submit" value="Login" name="indexBtn"></input></td>
					</tr>
				</tbody>
			</table>
		</form>
		<br><br>
		<form action="autoAdd" method="POST">
			<input id="autoAddButton" type="submit" value="Auto add 10 users" name="auto"></input>
		</form>
	</div>
</body>
</html>
