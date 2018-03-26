<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fdmgroup.Query.QueryObj" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<link href="styles/style.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript">
	<% ArrayList<QueryObj> queryList =  (ArrayList<QueryObj>) request.getSession().getAttribute("queryList");%>

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
		<h1>Welcome <%= request.getSession().getAttribute( "usernameSession" ) %> </h1>
		<span class="error">${error}</span><br>
		
		<br><br>	
		<table id="viewTransactionTable"> 
			<tr>
				<th>Username		</th>
				<th>Query Number	</th>
				<th>Subject			</th> 
				<th>Category		</th> 
				<th>Query Status	</th> 
				<th>View Query		</th> 
			</tr>
	  		<% for(QueryObj query: queryList){ %>
				<tr>
					<td><%= query.getQueryUsername() %></td>
					<td><%= query.getQueryNo() %></td>
					<td><%= query.getQuerySubjet() %></td> 
					<td><%= query.getQueryCategory()%></td>
					<td><%= query.getQueryStatus()%></td>
					<td>
						<form action="AdminViewQuery" method="POST">
							<input type="hidden" name="rowValueName" value="<%= query.getQueryUsername() %>"/>
							<input type="hidden" name="rowValue" value="<%= query.getQueryNo() %>"/>
							<input type="hidden" name="rowValueStatus" value="<%= query.getQueryStatus()%>"/>
							<input type="submit" value="View Query" name="btnViewQuery"/>
						</form>
					</td>						
				</tr>
			<%}%>
		</table>
		<a href="AdminLoginHome.jsp"><input type="button" value="Back To Main Menu" name="btnBack"/></a>
	</div>
</body>
</html>