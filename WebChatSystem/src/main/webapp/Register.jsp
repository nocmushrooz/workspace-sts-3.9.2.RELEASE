<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="styles/style.css">
	<title>Register New User</title>
</head>
<body>
	<h1>Register New User</h1>
	<div class="registerUser">
		<form action="Register" method="POST" name="registerForm">
			<span class="error" style="color:red">${error}</span><br>
			<table id="registerTable">
	  			<tbody>
	  				<tr>
		    			<td id="label"><label id="registerLabel">Username  </label></td>
		    			<td id="textField">
		    				<input type="text" id="username" name="fieldUsername" pattern="[a-zA-Z0-9]+" maxLength="14" size ="40" required/>
		    				<span class="error" style="color:red">${errorUsernameExist}</span>
		    			</td>
		  			</tr>
		  			<tr>
		    			<td id="label"><label id="registerLabel">Password  </label></td>
		    			<td id="textField"><input type="password" id="password" name="fieldPassword" required/></td> 
		    		</tr>
		    		<tr>
		    			<td id="label"><Label id="registerLabel">Full Name  </Label></td>
		    			<td id="textField"><input type="text" id="name" name="fieldName" pattern="[a-zA-Z\s]+" required/></td> 
					</tr>
		  			<tr>
		    			<td id="label"><label id="registerLabel">Address  </label></td>
		    			<td id="textField"><textArea id="address" name="fieldAddress" rows="8" cols="42" required></textarea></td> 
					</tr>
					<tr>
		    			<td id="label"><label id="registerLabel">Postal code  </label></td>
		    			<td id="textField"><input type="text" id="postCode" name="fieldPostCode" maxLength="9" pattern="[0-9]+" required/></td> 
					</tr>
					<tr>
		    			<td id="label"><label id="registerLabel">Contact Number  </label></td>
		    			<td id="textField">
		    				<input type="text" id="contactNumber" name="fieldContactNumber" maxLength="9" pattern="[0-9]+" required/>
							<span class="error" style="color:red">${errorContactExist}</span>
						</td> 
					</tr>
					<tr>
		    			<td id="label"><label id="registerLabel">Email Address  </label></td>
		    			<td id="textField">
		    				<input type="email" id="emailAddress" name="fieldEmailAddress" pattern="[a-zA-Z0-9._%+-]{1,40}[@]{1}[a-zA-Z]{1,10}[.]{1}[a-zA-Z]{3}" required/>
							<span class="error" style="color:red">${errorEmailAddressExist}</span>
						</td> 
					</tr>
					<tr>
		    			<td id="btnBackTD"><a href="index.jsp"><input type="button" value="Back to Login Page" name="btnBack" id="btnRegister" /></a></td>
						<td id="btnRegisterTD"><input type="Submit" value="Register" name="btnRegister" id="btnRegister" /></td>
					</tr>
	  			</tbody>
			</table>
			<input type="button" value="Reset Form" name="btnResetForm" onClick="this.form.reset()" id="btnReset" />
		</form>
	</div>
</body>
</html>		
