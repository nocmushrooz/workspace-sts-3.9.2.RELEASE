<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="POST">
		<table>
			 <tr>
		    	<td id="label"><label id="registerLabel">Username  </label></td>
		    	<td id="textField">
		    		<input type="text" id="username" name="fieldUsername" pattern="[a-zA-Z0-9]+" maxLength="14" size ="40" required/>
		    	</td>
		  	</tr>
			<tr>
		    	<td id="label"><label id="registerLabel">Password  </label></td>
		    	<td id="textField"><input type="password" id="password" name="fieldPassword" required/></td> 
		    </tr>
		</table>
	</form>
</body>
</html>