package com.deloitte.spring.boot.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.spring.boot.demo.exception.DepartmentNotFoundException;
import com.deloitte.spring.boot.demo.model.Department;
import com.deloitte.spring.boot.demo.Repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository deptRepository;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	public List<Department> getAllDepartments() {
		return deptRepository.findAll();
	}

	public Department getDepartmentById(int departmentId) {
		LOG.info(Integer.toString(departmentId));
		Optional<Department> deptOptional = deptRepository.findById(departmentId);
		if (deptOptional.isPresent()) {
			return deptOptional.get();
		} else {
			String errorMessage = "Department with id " + departmentId + " is not found";
			LOG.warn(errorMessage);
			throw new DepartmentNotFoundException(errorMessage);
		}
	}

	public List<Department> getDepartmentsByDepartmentName(String departmentName) {
		LOG.info(departmentName);
		List<Department> deptList = deptRepository.findByDepartmentName(departmentName);
		if (!deptList.isEmpty()) {
			return deptList;
		} else {
			String errorMessage = "Department with department name " + departmentName + " is not found";
			LOG.warn(errorMessage);
			throw new DepartmentNotFoundException(errorMessage);
		}
	}

	public List<Department> getDepartmentsByCity(String city) {
		LOG.info(city);
		List<Department> deptList = deptRepository.findByCity(city);
		if (!deptList.isEmpty()) {
			return deptList;
		} else {
			String errorMessage = "Department with city " + city + " is not found";
			LOG.warn(errorMessage);
			throw new DepartmentNotFoundException(errorMessage);
		}
	}

	public Department addDepartment(Department department) {
		LOG.info(department.toString());
		return deptRepository.save(department);
	}

	public Department updateDepartment(Department department) {
		LOG.info(department.toString());
		Department dept = this.getDepartmentById(department.getDepartmentId());
		dept = deptRepository.save(department);
		return dept;
	}

	public Department deleteDepartment(int departmentId) {
		LOG.info(Integer.toString(departmentId));
		Department dept = this.getDepartmentById(departmentId);
		if (null != dept)
			deptRepository.deleteById(departmentId);
		return dept;
	}
}

//public class DepartmentService {
//	public Department getDept() {
//		Department dept = new Department(10, "HR", "Hyderabad");
//		System.out.println("dept-service");
//		return dept;
//	}
//
//	public List<Department> getAllDepartments() {
//		Department dept1 = new Department(11, "CSE", "Hyderbad");
//		Department dept2 = new Department(12, "ECE", "Bangalore");
//		Department dept3 = new Department(13, "EEE", "Chennai");
//		List<Department> deptList = new ArrayList<>();
//		deptList.add(dept1);
//		deptList.add(dept2);
//		deptList.add(dept3);
//		return deptList;
//	}
//}