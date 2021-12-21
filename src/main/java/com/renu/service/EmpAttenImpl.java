package com.renu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renu.pojo.EmployeeAttendance;
import com.renu.repo.AttendanceRepo;

@Service
public class EmpAttenImpl implements AtteandanceService {
	@Autowired
	private AttendanceRepo attenRepo;

	@Override
	public EmployeeAttendance createAttendance(EmployeeAttendance empAtt) {
		EmployeeAttendance empatten = attenRepo.save(empAtt);
		return empatten;
	}

	@Override
	public List<EmployeeAttendance> getEmpAttenList() {
		List<EmployeeAttendance> al = new ArrayList<EmployeeAttendance>();
		attenRepo.findAll().forEach(empatt -> al.add(empatt));
		return al;
	}

}
