<%@page import="com.te.ems.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Employee Details</h1>
	<table border = "2">
		<tr>
		<th>EmployeeId</th>
		<th>EmployeeName</th>
		<th>EmployeeEmail</th>
		</tr>

		<% List<Employee> employees = (List<Employee>) request.getAttribute("fetch");
		
		for(Employee employee: employees)
		{
		%>
		<tr>
		<td><%= employee.getEmployeeId() %></td>
		<td><%= employee.getEmployeeName() %></td>
		<td><%= employee.getEmployeeEmail() %></td>
		</tr>
		
		<%} %>



	</table>

</body>
</html>