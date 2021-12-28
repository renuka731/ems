package com.renu.service;

import java.util.ArrayList;
import java.util.Date;
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
	public List<EmployeeAttendance> createAllAttendance(List<EmployeeAttendance> empAtt) {
		List<EmployeeAttendance> empatten = attenRepo.saveAll(empAtt);
		return empatten;
	}

	@Override
	public List<EmployeeAttendance> getEmpAttenList() {
		List<EmployeeAttendance> getempAttendancedails = new ArrayList<EmployeeAttendance>();
		attenRepo.findAll().forEach(empatt -> getempAttendancedails.add(empatt));
		return getempAttendancedails;
	}

	@Override
	public List<EmployeeAttendance> getMonthlyAttenRport(Date startdate, Date enddate) {

		List<EmployeeAttendance> monthlywiseAttend = attenRepo.findAll();

		return monthlywiseAttend;
	}

	@Override
	public int inBetweenDatesAttendace(Date startdate, Date enddate, long id) {
		int i= attenRepo.inBetweenDatesAttendace(startdate,enddate,id);
		System.out.println("attendance in between dates :"+i);
	return i;
		
	}

}
