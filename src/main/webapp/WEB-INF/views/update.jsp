<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update page</title>
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
	<H1>Update Page</H1>
	<table>
		<form action="update" method="post">
			<tr>
				<td>Enter the EmployeeId:</td>
				<td><input type="text" name="employeeId"
					placeholder="Example TY001"></td>
			</tr>
			<tr>
				<td>Enter the EmployeeEmail:</td>
				<td><input type="text" name="employeeEmail"
					placeholder="Example TY001@gmail.com"></td>
			</tr>
			<tr>
				<td></td>
				<td><button>update</button></td>
			</tr>
		</form>
	</table>

</body>
</html>