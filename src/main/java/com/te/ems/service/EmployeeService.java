package com.te.ems.service;

import java.util.List;

import com.te.ems.dto.LoginDTO;
import com.te.ems.entity.Employee;

public interface EmployeeService {

	String registerEmployee(String employeeId, String employeeName, String employeeEmail, String password);

	boolean login(LoginDTO loginDTO);

	boolean forgotPassword(String employeeId, String password, String newpassword, String retypepassword);

	boolean deleteEmployee(String employeeId);

	List<Employee> fetchAllEmployee();

	boolean updateEmployee(String employeeId, String employeeEmail);

}
