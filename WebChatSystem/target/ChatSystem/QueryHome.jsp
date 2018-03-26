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
		<table id="outerTableQueryHome">
			<tr>
				<td>
					<h1 id="H1">Welcome <%= request.getSession().getAttribute( "usernameSession" ) %> </h1>
					<form method="POST" action="Logout" name="LogoutForm">
						<input type="submit" value="Logout" name="btnLogout" />
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<span class="error">${error}</span><br>
					<br><br><br><br>
					<table id="queryTable"> 
						<tr>
							<td><label>Query Number</label></td>
							<td><label>Subject</label> </td> 
							<td><label>Category</label> </td> 
							<td><label>Query Status</label></td> 
							<td><label>View Query</label> </td> 
						</tr>
				  		<% for(QueryObj query: queryList){ %>
						<tr>
							<td><%= query.getQueryNo() %></td>
							<td><%= query.getQuerySubjet() %></td> 
							<td><%= query.getQueryCategory()%></td>
							<td><%= query.getQueryStatus()%></td>
							<td>
								<form action="ViewQuery" method="POST">
									<input type="hidden" name="rowValue" value="<%= query.getQueryNo() %>">
									<input type="submit" value="View Query" name="btnViewQuery"/>
								</form>
							</td>						
						</tr>
						<%}%>
					</table>
					<br><br>
					<a href="newQuery.jsp"><input type="button" value="Start new Query" name="btnStartNewConv" /></a>	
					<a href="LoginHome.jsp"><input type="button" value="Back to Main Menu" name="btnBack"/></a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>