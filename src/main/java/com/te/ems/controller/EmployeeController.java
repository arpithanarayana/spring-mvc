package com.te.ems.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.te.ems.dto.LoginDTO;
import com.te.ems.entity.Employee;
import com.te.ems.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = "/employees")
@Controller
public class EmployeeController {

	private final EmployeeService employeeService;

	/* Employee register */

	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request, ModelMap modelMap) {
		String employeeId = request.getParameter("employeeId");
		String employeeName = request.getParameter("employeeName");
		String employeeEmail = request.getParameter("employeeEmail");
		String password = request.getParameter("password");

		employeeId = employeeService.registerEmployee(employeeId, employeeName, employeeEmail, password);

		modelMap.addAttribute("message", "Employee register sucessfully");
		return "login";
	}

	/* Employee login */

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute LoginDTO loginDTO, Model model) {
		boolean isLogin = employeeService.login(loginDTO);
		if (!isLogin) {
			model.addAttribute("message", "employee login unsucessfully");
			return "login";
		} else {
			model.addAttribute("message", "employee login sucessfully");
			return "welcome";
		}
	}

	/* forgotpassword */

	@RequestMapping(path = "/forgotpassword", method = RequestMethod.GET)
	public String forgotPassword() {
		return "forgotpassword";
	}

	@RequestMapping(path = "/forgotpassword", method = RequestMethod.POST)
	public String forgotPassword(@RequestParam(name = "employeeId") String employeeId,
			@RequestParam(name = "password") String password, @RequestParam(name = "newpassword") String newpassword,
			@RequestParam(name = "retypepassword") String retypepassword, Model model) {

		boolean isForgot = employeeService.forgotPassword(employeeId, password, newpassword, retypepassword);
		if (!isForgot) {
			model.addAttribute("message", "employee reset-password unsucessfully");
			return "forgotpassword";
		} else {
			model.addAttribute("message", "employee reset-password sucessfully");
			return "login";
		}
	}

	/* update Employee */

	@RequestMapping(path = "/update", method = RequestMethod.GET)
	public String updateEmployee() {
		return "update";
	}

	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public String updateEmployee(@RequestParam(name = "employeeId") String employeeId,
			@RequestParam(name = "employeeEmail") String employeeEmail, Model model) {
		boolean isUpdate = employeeService.updateEmployee(employeeId, employeeEmail);
		if (!isUpdate) {
			model.addAttribute("message", "employee not found");
			return "update";
		} else {
			model.addAttribute("message", "employee details updated sucessfully");
			return "update";
		}
	}

	/* Delete employee */

	@RequestMapping(path = "/delete", method = RequestMethod.GET)
	public String delete() {
		return "delete";
	}

	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam(name = "employeeId") String employeeId, Model model) {
		boolean isDelete = employeeService.deleteEmployee(employeeId);
		if (!isDelete) {
			model.addAttribute("message", "employee not found");
			return "delete";
		} else {
			model.addAttribute("message", "employee deleted sucessfully");
			return "welcome";
		}
	}

	/* Fetech all employee details */

	@RequestMapping(path = "/fetch", method = RequestMethod.GET)
	public String fetch() {
		return "fetch";
	}

	@RequestMapping(path = "/fetch", method = RequestMethod.POST)
	public String fetch(@RequestParam(name = "fetch") String fetch, Model model) {
		List<Employee> employees = employeeService.fetchAllEmployee();

		model.addAttribute("fetch", employees);
		return "fetchall";
	}
}
