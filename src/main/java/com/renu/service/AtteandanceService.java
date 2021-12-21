package com.renu.service;

import java.util.List;

import com.renu.pojo.EmployeeAttendance;

public interface AtteandanceService {
	EmployeeAttendance createAttendance(EmployeeAttendance empAtt);

	List<EmployeeAttendance> getEmpAttenList();

}
