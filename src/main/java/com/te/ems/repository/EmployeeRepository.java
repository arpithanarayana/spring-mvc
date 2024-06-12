package com.te.ems.repository;

import java.util.List;

import com.te.ems.entity.Employee;

public interface EmployeeRepository {

	String registerEmployee(Employee employee);

	boolean login(String employeeId, String password);

	boolean forgotPassword(String employeeId, String password, String newpassword, String retypepassword);

	boolean deleteEmployee(String employeeId);

	List<Employee> fetchAllEmployee();

	boolean updateEmployee(String employeeId, String employeeEmail);

}
