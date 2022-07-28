package com.deloitte.spring.boot.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.deloitte.spring.boot.demo.Repository.EmployeeRepository;
import com.deloitte.spring.boot.demo.exception.EmployeeExistException;
import com.deloitte.spring.boot.demo.exception.EmployeeNotFoundException;
import com.deloitte.spring.boot.demo.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;
	
	DepartmentService depService;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	public Employee addEmployee(Employee e) {

		if (empRepository.existsById(e.getEmployeeId())) {
			System.out.println("Employee already Exist");
			String errorMessage = "Employee with eid " + e.getEmployeeId() + " already Exist.";
			LOG.warn(errorMessage);
			throw new EmployeeExistException(errorMessage);
		}
		if (null != e.getDepartment())
			depService.getDepartmentById(e.getDepartment().getDepartmentId());	
		return empRepository.save(e);
	}

	public Employee getEmployeeById(int employeeId) {

		LOG.info(Integer.toString(employeeId));
		Optional<Employee> empOptional = empRepository.findById(employeeId);
		if (empOptional.isPresent()) {
			Employee emp = empOptional.get();
			LOG.info(emp.toString());
			return emp;
		} else {
			String errorMessage = "Employee with eid " + employeeId + " not found.";
			LOG.warn(errorMessage);
			throw new EmployeeNotFoundException(errorMessage);
		}
	}

	public List<Employee> getAllEmployees() {
		// String sqlQuery = "SELECT * FROM employee ORDER BY employee_id";

		List<Employee> empList = empRepository.findAll();
//		Employee emp = new Employee(101, "Sonu", 90000);
//		Employee emp1 = new Employee(102, "Tinku", 98000);
//		Employee emp2 = new Employee(103, "Hari", 10000);
//		empList.add(emp);
//		empList.add(emp1);
//		empList.add(emp2);
		return empList;
	}

	public Employee updateEmployee(Employee employee) {
		if (empRepository.existsById(employee.getEmployeeId()))
			return empRepository.save(employee);
		else {
			return this.getEmployeeById(employee.getEmployeeId());
		}
	}

	public Employee deleteEmployeeById(int employeeId) {

		if (empRepository.existsById(employeeId))
			empRepository.deleteById(employeeId);
		else {
			return this.getEmployeeById(employeeId);
		}
		return null;
	}

	public List<Employee> getEmpsByFirstName(String firstName) {
//		List<Employee> empList = empRepository.findAll();
//		List<Employee> empsToReturn = new ArrayList<>();
//		for (Employee e: empList) {
//			if(e.getFirstName().equals(firstName))
//			{
//				empsToReturn.add(e);
//			}
//		}
//		return empsToReturn;
		
		
		LOG.info(firstName);
		List<Employee> empList=empRepository.findByFirstName(firstName);
		if(!empList.isEmpty())
			return empList;
		else {
			String errorMessage = "Employee with name " + firstName + " not found.";
			LOG.warn(errorMessage);
			throw new EmployeeNotFoundException(errorMessage);
			
		}
	}

	public List<Employee> getEmpsBySalaryGreaterThan(double salary) {
//		List<Employee> empList = empRepository.findAll();
//		List<Employee> empsToReturn = new ArrayList<>();
//		for (Employee e: empList) {
//			if(e.getSalary()>salary)
//			{
//				empsToReturn.add(e);
//			}
//		}
//		return empsToReturn;
		
		LOG.info(Double.toString(salary));
		List<Employee> empList=empRepository.findBySalaryGreaterThan(salary);
		if(!empList.isEmpty())
			return empList;
		else {
			String errorMessage = "Employee with salary greater than " + salary + " not found.";
			LOG.warn(errorMessage);
			throw new EmployeeNotFoundException(errorMessage);
			}
	}

	public List<Employee> getEmpsByDepartmentCity(String city) {
		
		List<Employee> empList=empRepository.findByDepartment_City(city);
		return empList;
	}
	

}
