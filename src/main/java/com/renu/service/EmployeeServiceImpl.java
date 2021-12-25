package com.renu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renu.pojo.Employee;
import com.renu.repo.EmployeeRepo;
import com.sun.xml.bind.Utils;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepo emprepo;

	@Override
	public List<Employee> getAllEmployeeList() {
		List<Employee> al = new ArrayList<Employee>();

		emprepo.findAll().forEach(emp -> al.add(emp));

		return al;
	}

	@Override
	public Employee createEmployee(Employee emp) {
		Employee e = emprepo.save(emp);
		return e;

	}

	@Override

	public Employee updateEmp(Employee emp) {
		Employee e=	emprepo.save(emp);
		return e;
	}

	@Override
	public void delete(long id) {

		Optional<Employee> savedEmp = emprepo.findById(id);

		if (savedEmp.isPresent()) {
			Employee e = savedEmp.get();
			emprepo.delete(e);
		}

	}

	public HashMap<String, List<Employee>> groupingByDepartment() {

		List<Employee> allEmployeeList = emprepo.findAll();

		HashMap<String, List<Employee>> deptwiseemplist = new HashMap<>();
		for (Employee e : allEmployeeList) {
			if (!deptwiseemplist.containsKey(e.getDepartment())) {
				List<Employee> newList = new ArrayList<>();
				newList.add(e);
				deptwiseemplist.put(e.getDepartment(), newList);
			} else {
				List<Employee> existingList = deptwiseemplist.get(e.getDepartment());
				existingList.add(e);
				deptwiseemplist.put(e.getDepartment(), existingList);
			}
		}
		return deptwiseemplist;
	}

	@Override
	public HashMap<String, List<Employee>> groupingByDegination() {

		List<Employee> allEmployeeList = emprepo.findAll();

		HashMap<String, List<Employee>> degiwiseemplist = new HashMap<>();
		for (Employee e : allEmployeeList) {
			if (!degiwiseemplist.containsKey(e.getDegination())) {
				List<Employee> newList = new ArrayList<>();
				newList.add(e);
				degiwiseemplist.put(e.getDegination(), newList);
			} else {
				List<Employee> existingList = degiwiseemplist.get(e.getDegination());
				existingList.add(e);
				degiwiseemplist.put(e.getDepartment(), existingList);
			}
		}
		return degiwiseemplist;
	}

}
