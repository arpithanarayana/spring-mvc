package com.te.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.te.ems.dto.LoginDTO;
import com.te.ems.entity.Employee;
import com.te.ems.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private final EmployeeRepository employeeRepository;

	@Override
	public String registerEmployee(String employeeId, String employeeName, String employeeEmail, String password) {
		Employee employee = Employee.builder().employeeId(employeeId)
		.employeeName(employeeName)
		.employeeEmail(employeeEmail)
		.password(password)
		.build();
		return employeeRepository.registerEmployee(employee);
	}

	@Override
	public boolean login(LoginDTO loginDTO) {
		return employeeRepository.login(loginDTO.getEmployeeId(), loginDTO.getPassword());
	}

	@Override
	public boolean forgotPassword(String employeeId, String password, String newpassword, String retypepassword) {
		return employeeRepository.forgotPassword(employeeId, password,newpassword, retypepassword);
	}

	@Override
	public boolean deleteEmployee(String employeeId) {
		return employeeRepository.deleteEmployee(employeeId);
	}

	@Override
	public List<Employee> fetchAllEmployee() {
		return employeeRepository.fetchAllEmployee();
	}

	@Override
	public boolean updateEmployee(String employeeId, String employeeEmail) {
		return employeeRepository.updateEmployee(employeeId, employeeEmail);
	}

}
