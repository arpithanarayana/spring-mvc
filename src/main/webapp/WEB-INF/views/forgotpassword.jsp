<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>ForgotPassword Page</h1>
<table>
		<form action="forgotpassword" method="post">
			<tr>
				<td>Enter the EmployeeId:</td>
				<td><input type="text" name="employeeId"
					placeholder="Example TY001"></td>
			</tr>
			<tr>
				<td>Enter the password:</td>
				<td><input type="password" name="password"
					placeholder="Example TY001"></td>
			</tr>
			<tr>
				<td>Enter the New password:</td>
				<td><input type="password" name="newpassword"
					placeholder="Example TY001"></td>
			</tr>
			<tr>
				<td>Enter the retype-password:</td>
				<td><input type="password" name="retypepassword"
					placeholder="Example TY001"></td>
			</tr>
			<tr>
				<td></td>
				<td><button>ForgotPassword</button></td>
			</tr>
		</form>
	</table>


</body>
</html>