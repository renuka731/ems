package com.renu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renu.pojo.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
