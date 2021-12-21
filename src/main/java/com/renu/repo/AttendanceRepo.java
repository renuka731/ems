package com.renu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renu.pojo.EmployeeAttendance;

@Repository
public interface AttendanceRepo extends JpaRepository<EmployeeAttendance, Long> {

}
