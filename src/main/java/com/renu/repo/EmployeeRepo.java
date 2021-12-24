package com.renu.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.renu.pojo.Employee;

import antlr.collections.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
