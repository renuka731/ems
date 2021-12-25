package com.renu.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.renu.pojo.Employee;
import com.renu.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employee_service;

	@GetMapping("/getemp")
	public List<Employee> showEployees() {
		System.out.println("get employee list");
		return employee_service.getAllEmployeeList();

	}

	@PostMapping("/createemp")
	public Employee createEmployees(@RequestBody Employee emp) {
		System.out.println("employee created successfully");
		Employee e = employee_service.createEmployee(emp);
		return e;
	}

	@PutMapping("/updateemp")
	public Employee updatesEmployees(@RequestBody Employee emp) {
		System.out.println("employee update successfully");
		Employee updatedEmployee = employee_service.updateEmp(emp);
		System.out.println("update employee successfully");
		return updatedEmployee;
	}

	@DeleteMapping("/delete")
	public void deleteEmp(int id) {
		System.out.println("employee delete");
		employee_service.delete(id);
		System.out.println("emp deleted successfully");
	}

	@GetMapping("/getgroupingdept")
	public HashMap<String, List<Employee>> getGroupByDept() {
		System.out.println("department wise emp list");
		HashMap<String, List<Employee>> deptwiseemplist = employee_service.groupingByDepartment();
		return deptwiseemplist;
	}

	@GetMapping("/getgroupingdegi")
	public HashMap<String, List<Employee>> getGroupByDegi() {
		System.out.println("department wise emp list");
		HashMap<String, List<Employee>> degiwiseemplist = employee_service.groupingByDegination();
		return degiwiseemplist;
	}
}
