package com.renu.service;

import java.util.List;
import java.util.Optional;

import com.renu.pojo.Employee;

public interface Employee_service {
	List<Employee> getAllEmployeeList();

	Employee createEmployee(Employee emp);

	Employee updateEmp(Employee emp, long id);

	//Optional<Employee> findById(long id);

	void delete(long id);
}
