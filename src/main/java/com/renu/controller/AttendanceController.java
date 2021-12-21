package com.renu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renu.pojo.EmployeeAttendance;
import com.renu.service.EmpAttenImpl;

@RestController
public class AttendanceController {
	@Autowired
	private EmpAttenImpl empattService;

	@PostMapping("/createatten")
	public EmployeeAttendance createEmpAttendance(EmployeeAttendance empAtten) {
		EmployeeAttendance empatt = empattService.createAttendance(empAtten);
		return empatt;
	}

	@GetMapping("/getempAttlist")
	public List<EmployeeAttendance> getEmpAttLest() {
		return empattService.getEmpAttenList();
	}
}
