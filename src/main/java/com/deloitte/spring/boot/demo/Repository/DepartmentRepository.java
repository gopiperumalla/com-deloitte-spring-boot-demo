package com.deloitte.spring.boot.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloitte.spring.boot.demo.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	public abstract List<Department> findByDepartmentName(String departmentName);

	public abstract List<Department> findByCity(String city);
}