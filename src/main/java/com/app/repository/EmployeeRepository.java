package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query(value = "from Employee e where e.employeeId = ?1")
	public Employee getEmployeeByEmployeeId(Integer employeeId);
	
	@Query("from Employee e where e.employeeName = ?1")
	public List<Employee> getEmployeesByEmployeeName(String employeeName);
	
	@Query(value = "from Employee e where e.employeeName = ?1 and e.designation = ?2")
	public List<Employee> getEmployeesByEmployeeNameAndDesignation(String employeeName, String designation);
	
	@Query(value = "from Employee e where e.employeeCode = :employeeCode and e.employeeName = :employeeName")
	public List<Employee> getEmployeesByEmployeeCodeAndEmployeeName(String employeeCode, String employeeName);
	
	@Query(value = "from Employee e where e.age <= :age order by e.age desc")
	public List<Employee> getEmployeesAgeLessthenOrEqual(@Param(value = "age") Integer employeeAge);
	
	@Query(value = "select e.employeeName from Employee e order by e.employeeName")
	public List<String> getAllEmployeeNames();
	
	@Query(value = "select e.employeeId, e.employeeName from Employee e order by e.employeeName asc")
	public List<Object[]> getAllEmployeeIdsAndEmployeeNames();
	
	@Query(value = "select new Employee(e.employeeId, e.employeeCode, e.employeeName) from Employee e")
	public List<Employee> getAllEmployeeIdAndEmployeeCodeAndEmployeeName();
	
	@Query(value = "select count(e.employeeId) from Employee e")
	public Integer countOfEmployees();
	
	@Query(value = "select avg(e.age) from Employee e")
	public Integer averageOfEmployeeAges();
}
