package com.deloitte.spring.boot.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.spring.boot.demo.model.Employee;
import com.deloitte.spring.boot.demo.service.EmployeeService;

//http://localhost:9999/swagger-ui/index.html

@RestController
@RequestMapping("/emp")
public class EmployeeController {

//EmployeeService empService=new EmployeeService();
	@Autowired
	EmployeeService empService;

//getEmpbyId	
	@GetMapping("/get-emp-by-id/{eid}")
	public ResponseEntity<Employee> getEmpById(@PathVariable(name = "eid") int employeeId) {
		System.out.println(employeeId);
		Employee e=empService.getEmployeeById(employeeId);
		
		HttpStatus status=HttpStatus.OK;
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Message", "Employee "+employeeId+" is found Successfully.");
		
		ResponseEntity<Employee> response= new ResponseEntity<>(e,headers,status);
		return response;
	}

//getAllEmps

	@GetMapping("/get-all-emps")
	public ResponseEntity<List<Employee>> getAllEmps() {
		System.out.println("emp-controller");
		List<Employee> e=empService.getAllEmployees();
		
		HttpStatus status=HttpStatus.OK;
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Message", "Employee "+e.toString()+" is Stored Successfully.");
		
		ResponseEntity<List<Employee>> response= new ResponseEntity(e,headers,status);
		return response;

	}

//DeleteEmp By Id
	@GetMapping("/del-emp-id/{eid}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable(name = "eid") int employeeId) {
		
		Employee e=empService.deleteEmployeeById(employeeId);
		
		HttpStatus status=HttpStatus.OK;
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Message", "Employee "+employeeId+" is deleted Successfully.");
		
		ResponseEntity<Employee> response= new ResponseEntity<>(e,headers,status);
		return response;

	}

//Update Employee
	@RequestMapping(path = "/update-emp", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmp(@Valid @RequestBody Employee employee) {
		
		
		HttpStatus status=HttpStatus.CREATED;
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Message", "Employee "+employee.getEmployeeId()+" is Updated Successfully.");
		
		ResponseEntity<Employee> response= new ResponseEntity<>(employee,headers,status);
		empService.updateEmployee(employee);
		return response;
	}

//Add Employee
	@RequestMapping(path = "/add-emp", method = RequestMethod.POST)
	public ResponseEntity<Employee> addEmp(@Valid @RequestBody Employee employee) {
		HttpStatus status=HttpStatus.CREATED;
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Message", "Employee "+employee.getEmployeeId()+" is added Successfully.");
		
		ResponseEntity<Employee> response= new ResponseEntity<>(employee,headers,status);
		empService.addEmployee(employee);
		return response;
	}
	
//get emp by name	
	@GetMapping("/get-emp-by-name/{first-name}")
	public ResponseEntity<List<Employee>> getEmpsByFirstName(@PathVariable(name = "first-name") String firstName) {
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Message", "Employees with firstname  "+firstName+" is fetched Successfully.");
		
		return new ResponseEntity<List<Employee>>(empService.getEmpsByFirstName(firstName),headers,HttpStatus.OK);
	}
		
	
//Get Emp by Salary greater than given salary
	@GetMapping("/get-emp-by-salary-greater-than/{salary}")
	public ResponseEntity<List<Employee>> getEmpsBySalaryGreaterThan(@PathVariable(name = "salary") double salary) {
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Message", "Employees with salary greater then  "+salary+" is fetched Successfully.");
		
		return new ResponseEntity<List<Employee>>(empService.getEmpsBySalaryGreaterThan(salary),headers,HttpStatus.OK);
	}
	
//Get employee by department city
	@GetMapping("/get-emps-by-dept-city/{city}")
	public ResponseEntity<List<Employee>> getEmpsByDepartmentCity(@PathVariable(name = "city") String city) {
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Message", "Employees with city name  "+city+" is fetched Successfully.");
		
		return new ResponseEntity<List<Employee>>(empService.getEmpsByDepartmentCity(city),headers,HttpStatus.OK);
	}

}