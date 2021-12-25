package com.renu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.renu.pojo.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployeeList();

	Employee createEmployee(Employee emp);

	Employee updateEmp(Employee emp);

	// Optional<Employee> findById(long id);

	void delete(long id);

	HashMap<String, List<Employee>> groupingByDepartment();

	HashMap<String, List<Employee>> groupingByDegination();
}
