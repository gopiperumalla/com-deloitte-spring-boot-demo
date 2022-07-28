package com.deloitte.spring.boot.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.spring.boot.demo.model.Department;
import com.deloitte.spring.boot.demo.service.DepartmentService;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

	@Autowired
	DepartmentService deptService;

	@RequestMapping(path = "/get-all-depts", method = RequestMethod.GET)
	public ResponseEntity<List<Department>> getAllDepts() {
		System.out.println("get-all-depts");
		List<Department> deptList = deptService.getAllDepartments();
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "List of all Departments displayed successfully!");
		ResponseEntity<List<Department>> response = new ResponseEntity<>(deptList, headers, status);
		return response;
	}

	@RequestMapping(path = "/get-dept-by-id/{id}", method = RequestMethod.GET)
	public ResponseEntity<Department> getDeptById(@PathVariable(name = "id") int departmentId) {
		System.out.println("get-dept-by-id");
		Department dept = deptService.getDepartmentById(departmentId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Department with id " + departmentId + " is found successfully!");
		ResponseEntity<Department> response = new ResponseEntity<>(dept, headers, status);
		return response;
	}

	@RequestMapping(path = "/get-dept-by-name/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<Department>> getAllDeptsByDepartmentName(
			@PathVariable(name = "name") String departmentName) {
		System.out.println("get-all-depts-by-name");
		List<Department> deptList = deptService.getDepartmentsByDepartmentName(departmentName);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Department with department name " + departmentName + " is found successfully!");
		ResponseEntity<List<Department>> response = new ResponseEntity<>(deptList, headers, status);
		return response;
	}

	@RequestMapping(path = "/get-dept-by-city/{city}", method = RequestMethod.GET)
	public ResponseEntity<List<Department>> getAllDeptsByCity(@PathVariable(name = "city") String city) {
		System.out.println("get-all-depts-by-city");
		List<Department> deptList = deptService.getDepartmentsByCity(city);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Department with id " + city + " is found successfully!");
		ResponseEntity<List<Department>> response = new ResponseEntity<>(deptList, headers, status);
		return response;
	}

	@RequestMapping(path = "/add-dept", method = RequestMethod.POST)
	public ResponseEntity<Department> addDept(@Valid @RequestBody Department department) {
		System.out.println("add-dept");
		Department dept = deptService.addDepartment(department);
		HttpStatus status = HttpStatus.CREATED;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Department with id " + department.getDepartmentId() + " is added successfully!");
		ResponseEntity<Department> response = new ResponseEntity<>(dept, headers, status);
		return response;
	}

	@RequestMapping(path = "/update-dept", method = RequestMethod.PUT)
	public ResponseEntity<Department> updateDept(@Valid @RequestBody Department department) {
		System.out.println("add-dept");
		Department dept = deptService.updateDepartment(department);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Department with id " + department.getDepartmentId() + " is updated successfully!");
		ResponseEntity<Department> response = new ResponseEntity<>(dept, headers, status);
		return response;
	}

	@RequestMapping(path = "/delete-dept/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Department> deleteDept(@PathVariable(name = "id") int departmentId) {
		System.out.println("delete-dept");
		Department dept = deptService.deleteDepartment(departmentId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Department with id " + departmentId + " is deleted successfully!");
		ResponseEntity<Department> response = new ResponseEntity<>(dept, headers, status);
		return response;
	}
}