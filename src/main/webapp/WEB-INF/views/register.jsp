<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register page</title>
</head>
<body>
<h1>Register page</h1>
	<table>
		<form action="register" method="post">
		<tr>
			<td>Enter the EmployeeId:</td>
			<td><input type="text" name="employeeId"
				placeholder="Example TY001"></td>
		</tr>
		<tr>
			<td>Enter the EmployeeName:</td>
			<td><input type="text" name="employeeName"
				placeholder="Example abc"></td>
		</tr>
		<tr>
			<td>Enter the EmployeeEmail:</td>
			<td><input type="text" name="employeeEmail"
				placeholder="Example TY001@gmail.com"></td>
		</tr>
		<tr>
			<td>Enter the password:</td>
			<td><input type="password" name="password"
				placeholder="Example TY001"></td>
		</tr>
		<tr>
			<td></td>
			<td><button>register</button></td>
		</tr>
		</form>
	</table>

</body>
</html>