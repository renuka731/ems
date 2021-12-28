package com.renu.service;

import java.util.Date;
import java.util.List;

import com.renu.pojo.EmployeeAttendance;

public interface AtteandanceService {
	EmployeeAttendance createAttendance(EmployeeAttendance empAtt);
	List<EmployeeAttendance> createAllAttendance(List<EmployeeAttendance> empAtt);

	List<EmployeeAttendance> getEmpAttenList();

	//List<EmployeeAttendance> getMonthlyAttenRport(Date startdate, Date enddate);

	List<EmployeeAttendance> getMonthlyAttenRport(Date startdate, Date enddate);
	int inBetweenDatesAttendace(Date startdate,Date enddate,long id) ;
}
