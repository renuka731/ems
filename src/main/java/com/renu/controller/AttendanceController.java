package com.renu.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.renu.pojo.EmployeeAttendance;
import com.renu.service.EmpAttenImpl;

@RestController
public class AttendanceController {
	@Autowired
	private EmpAttenImpl empattService;

	@PostMapping("/createatten")
	public EmployeeAttendance createEmpAttendance(@RequestBody EmployeeAttendance empAtten) {
		System.out.println("emp attendance report create");
		EmployeeAttendance empatt = empattService.createAttendance(empAtten);
		System.out.println("emp attendance report create successfully");
		return empatt;
	}

	@PostMapping("/createAll")
	public List<EmployeeAttendance> createEmpAttendance(@RequestBody List<EmployeeAttendance> empAttens) {
		System.out.println("emp attendance report create");
		List<EmployeeAttendance> empatt = empattService.createAllAttendance(empAttens);
		System.out.println("emp attendance report create successfully");
		return empatt;
	}

	@GetMapping("/getempAttlist")
	public List<EmployeeAttendance> getEmpAttList() {
		System.out.println("get emp attendace report");
		List<EmployeeAttendance> al = empattService.getEmpAttenList();
		
		System.out.println(al.size());
		return al;
	}

	@GetMapping("/getempAttmonthlylist")
	public List<EmployeeAttendance> getEmpMonthlyAttList(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startdate, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date enddate) {
		System.out.println("get emp monthly attendace  report");
		System.out.println(startdate);
		System.out.println(enddate);
		return empattService.getMonthlyAttenRport(startdate, enddate);

	}

	@GetMapping("/getinbetweendatesattreport")
	public int getInBetweenDatesAtten(@RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd") Date startdate, @RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd")  Date enddate, @RequestParam long id) {
		System.out.println("get emp  attendace in between dates  report");
		System.out.println(startdate);
		System.out.println(enddate);
		System.out.println(id);
		
		
		return empattService.inBetweenDatesAttendace(startdate, enddate, id);
		
		

	}
}
