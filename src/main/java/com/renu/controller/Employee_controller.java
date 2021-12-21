package com.renu.controller;

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
import com.renu.service.Employee_service_implementation;

@RestController
public class Employee_controller {

	@Autowired
	private Employee_service_implementation employee_service;

	@GetMapping("/getemp")
	public List<Employee> showEployees() {
		return employee_service.getAllEmployeeList();

	}

	@PostMapping("/createemp")
	public Employee createEmployees(@RequestBody Employee emp) {
		Employee e = employee_service.createEmployee(emp);
		return e;
	}

	@PutMapping("/updateemp")
	public Employee updatesEmployees(@RequestBody Employee emp, @PathVariable long id) {
		Employee updatedEmployee = employee_service.updateEmp(emp, id);
		return updatedEmployee;
	}

	@DeleteMapping("/delete")
	public void deleteEmp(int id) {
		employee_service.delete(id);
	}
}
