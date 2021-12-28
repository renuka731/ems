package com.renu.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.renu.pojo.EmployeeAttendance;

@Repository
public interface AttendanceRepo extends JpaRepository<EmployeeAttendance, Integer> {
	
	@Query("select COUNT(a) from EmployeeAttendance a where  a.date> ?1 and a.date < ?2")
	int inBetweenDatesAttendace(Date startdate, Date enddate, long id);

}
