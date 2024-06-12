<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Page</title>
</head>
<%
String message = (String) request.getAttribute("message");
%>
<body>
	<%
	if (message != null) {
	%>
	<h1><%=message%></h1>
	<%
	}
	%>
	<h1>Delete Page</h1>
	<table>
		<form action="delete" method="post">
			<tr>
				<td>Enter the EmployeeId:</td>
				<td><input type="text" name="employeeId"
					placeholder="Example TY001"></td>
			</tr>
			<tr>
				<td></td>
				<td><button>Delete</button></td>
			</tr>
		</form>
	</table>

</body>
</html>