package com.app.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.app.model.Employee;
import com.app.repository.EmployeeRepository;

@Component
public class TestRunner implements ApplicationRunner{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("From run method in TestRunner class.");
		
		System.out.println("---- To get record by getEmployeeByEmployeeId(Integer employeeId) method ----");
		Employee employee1 = employeeRepository.getEmployeeByEmployeeId(1);
		if(employee1 != null) {
			System.out.println(employee1.getEmployeeId()+" --> "+employee1.getEmployeeName()+"["+employee1.getEmployeeCode()+"]");
		}
		
		System.out.println("---- To get records by getEmployeeByEmployeeId(Integer employeeId) method ----");
		List<Employee> employeeList1 = employeeRepository.getEmployeesByEmployeeName("Pavan");
		employeeList1.forEach(e -> {
			System.out.println(e.getEmployeeId()+" --> "+e.getEmployeeName()+"["+e.getEmployeeCode()+"]");
		});
		
		System.out.println("---- To get records by getEmployeesByEmployeeNameAndDesignation(String employeeName, String designation) method ----");
		List<Employee> employeeList2 = employeeRepository.getEmployeesByEmployeeNameAndDesignation("Pavan", "QA Engineer");
		employeeList2.forEach(e -> {
			System.out.println(e.getEmployeeId()+" --> "+e.getEmployeeName()+"["+e.getEmployeeCode()+"]");
		});
		
		System.out.println("---- To get records by getEmployeesByEmployeeCodeAndEmployeeName(String employeeCode, String employeeName) method ----");
		List<Employee> employeeList3 = employeeRepository.getEmployeesByEmployeeCodeAndEmployeeName("A002", "Sathish");
		employeeList3.forEach(e -> {
			System.out.println(e.getEmployeeId()+" --> "+e.getEmployeeName()+"["+e.getEmployeeCode()+"]");
		});
		
		System.out.println("---- To get records by getEmployeesAgeLessthenOrEqual(@Param(value = \"age\") Integer employeeAge) method ----");
		List<Employee> employeeList4 = employeeRepository.getEmployeesAgeLessthenOrEqual(27);
		employeeList4.forEach(e -> {
			System.out.println(e.getEmployeeId()+" --> "+e.getEmployeeName()+"["+e.getEmployeeCode()+"] --> "+e.getAge());
		});
		
		System.out.println("---- To get records by getAllEmployeeNames() method ----");
		List<String> employeeNamesList1 = employeeRepository.getAllEmployeeNames();
		employeeNamesList1.forEach(e -> {
			System.out.println(e);
		});
		
		System.out.println("---- To get records by getAllEmployeeIdsAndEmployeeNames() method ----");
		List<Object[]> employeeIdAndEmployeeNameList1 = employeeRepository.getAllEmployeeIdsAndEmployeeNames();
		employeeIdAndEmployeeNameList1.forEach(e -> {
			System.out.println(e[0]+" --> "+e[1]);
		});
		
		System.out.println("---- To get records by getAllEmployeeIdAndEmployeeCodeAndEmployeeName() method ----");
		List<Employee> employeeList5 = employeeRepository.getAllEmployeeIdAndEmployeeCodeAndEmployeeName();
		employeeList5.forEach(e -> {
			System.out.println(e.getEmployeeId()+" --> "+e.getEmployeeName()+"["+e.getEmployeeCode()+"]");
		});
		
		System.out.println("---- To get records by countOfEmployees() method ----");
		Long employeeCount1 = employeeRepository.countOfEmployees();
		System.out.println(employeeCount1);
		
		System.out.println("---- To get records by averageOfEmployeeAges() method ----");
		Double employeeAverageAge1 = employeeRepository.averageOfEmployeeAges();
		System.out.println(employeeAverageAge1);
	}

}
