package com.deloitte.spring.boot.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.spring.boot.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	List<Employee> findByFirstName(String firstName);

	List<Employee> findBySalaryGreaterThan(double salary);
	
	List<Employee> findByDepartment_City(String city);
	
	

}
