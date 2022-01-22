package com.renu.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renu.pojo.Employee;
import com.renu.pojo.LeaveBalance;
import com.renu.repo.AttendanceRepo;
import com.renu.repo.EmployeeRepo;
import com.renu.repo.LeaveBalanceRepo;
import com.sun.xml.bind.Utils;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepo emprepo;
	@Autowired
	private AttendanceRepo attenRepo;
	@Autowired
	private LeaveBalanceRepo levRepo;

	@Override
	public List<Employee> getAllEmployeeList() {
		List<Employee> al = new ArrayList<Employee>();

		emprepo.findAll().forEach(emp -> al.add(emp));

		return al;
	}

	@Override
	public Employee createEmployee(Employee emp) {
		Employee e = emprepo.save(emp);
		return e;

	}

	@Override

	public Employee updateEmp(Employee emp) {
		Employee e = emprepo.save(emp);
		return e;
	}

	@Override
	public void delete(long id) {

		Optional<Employee> savedEmp = emprepo.findById(id);

		if (savedEmp.isPresent()) {
			Employee e = savedEmp.get();
			emprepo.delete(e);
		}

	}

	public HashMap<String, List<Employee>> groupingByDepartment() {

		List<Employee> allEmployeeList = emprepo.findAll();

		HashMap<String, List<Employee>> deptwiseemplist = new HashMap<>();
		for (Employee e : allEmployeeList) {
			if (!deptwiseemplist.containsKey(e.getDepartment())) {
				List<Employee> newList = new ArrayList<>();
				newList.add(e);
				deptwiseemplist.put(e.getDepartment(), newList);
			} else {
				List<Employee> existingList = deptwiseemplist.get(e.getDepartment());
				existingList.add(e);
				deptwiseemplist.put(e.getDepartment(), existingList);
			}
		}
		return deptwiseemplist;
	}

	@Override
	public HashMap<String, List<Employee>> groupingByDegination() {

		List<Employee> allEmployeeList = emprepo.findAll();

		HashMap<String, List<Employee>> degiwiseemplist = new HashMap<>();
		for (Employee e : allEmployeeList) {
			if (!degiwiseemplist.containsKey(e.getDegination())) {
				List<Employee> newList = new ArrayList<>();
				newList.add(e);
				degiwiseemplist.put(e.getDegination(), newList);
			} else {
				List<Employee> existingList = degiwiseemplist.get(e.getDegination());
				existingList.add(e);
				degiwiseemplist.put(e.getDepartment(), existingList);
			}
		}
		return degiwiseemplist;
	}

	@Override
	public double calMonthlySalary(long empId, int monthId) {
		// get salary 60000
		// get total month days 31
		// how many days will present 18
		// cal leaves total days - present days to get leaves 31-18=13
		// get leave balance 20
		// and cal leaves balance 20-13 =7
		// update leave balance=7
		//
		Optional<Employee> emp = emprepo.findById(empId);
		double salTotal = emp.get().getSalary();
		// Calendar calendar = Calendar.getInstance();
		// System.currentTimeMillis()
		YearMonth yearMonthObject = YearMonth.of(YearMonth.now().getYear(), YearMonth.now().getMonthValue());
		int daysInMonth = yearMonthObject.lengthOfMonth();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate startdate = yearMonthObject.atDay(1);
		Date sdate = Date.from(startdate.atStartOfDay(defaultZoneId).toInstant());
		LocalDate enddate = yearMonthObject.atEndOfMonth();
		Date edate = Date.from(enddate.atStartOfDay(defaultZoneId).toInstant());
		System.out.println("no. of dys in month:" + daysInMonth);
		int inMonthsleaves = daysInMonth - attenRepo.inBetweenDatesAttendace(sdate, edate, empId);
		System.out.println("in month total leaves :" + inMonthsleaves);
		Optional<LeaveBalance> levBalEmpId = levRepo.findById(empId);
		int levBal = levBalEmpId.get().getTotalLeaves();
		System.out.println("leave balanec:" + levBal);
		
		//System.out.println("updateed leaves :"+ updateLevBal);
		int updateLevBal = levBal - inMonthsleaves;
		if(updateLevBal <0) {
			updateLevBal=0;
		}
		levRepo.updateLeaveBal(empId,updateLevBal);
		System.out.println("updateed leaves :"+ updateLevBal);
		
		if (levBal > inMonthsleaves) {
			
			System.out.println("total salary :" + salTotal);
			
			return salTotal;
		} else {
			int salPayTalDays = daysInMonth - inMonthsleaves + levBal;
			double oneDaysal = salTotal / daysInMonth;
			System.out.println("one day sal : " + oneDaysal);
			double inMonthSal = oneDaysal * salPayTalDays;
			System.out.println("month sal :" + inMonthSal);
			
			return inMonthSal;
		}
		
	}

}
