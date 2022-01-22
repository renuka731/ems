package com.renu.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.renu.pojo.EmployeeAttendance;

@Repository
public interface AttendanceRepo extends JpaRepository<EmployeeAttendance, Integer> {

	@Query("select COUNT(a) from EmployeeAttendance a where  a.date >= ?1 and a.date <= ?2 and a.id =?3")
	int inBetweenDatesAttendace(Date startdate, Date enddate, long id);

	@Query("select a from EmployeeAttendance a where a.id =?1")
	List<EmployeeAttendance> findById(long id);

}
