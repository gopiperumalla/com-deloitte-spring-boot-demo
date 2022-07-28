package com.deloitte.spring.boot.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "emp_table")
public class Employee {

	@Id // PK
	@GenericGenerator(name = "emp_seq", strategy = "increment")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
	@Column(name = "employee_id")
	private int employeeId;

	@Column(name = "first_name")
	@NotNull(message = "firstName can not be null.")
	@Size(min = 3, max = 40, message = "firstName should be min 3 and max 40 characters.")
	private String firstName;

	@Column(name = "salary")
	private double salary;
	
	@Column(name="role")
	private Role role;
	
	@ManyToOne
	@JoinColumn(name = "departmentId")
	private Department department;

	public Employee() {
		super();
	}

	public Employee(String firstName, double salary) {
		super();
		this.firstName = firstName;
		this.salary = salary;
	}

	public Employee(int employeeId, String firstName, double salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.salary = salary;
	}

	public Employee(String firstName, double salary, Role role, Department department) {
		super();
		this.firstName = firstName;
		this.salary = salary;
		this.role = role;
		this.department = department;
	}

	public Employee(int employeeId, String firstName, double salary, Role role, Department department) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.salary = salary;
		this.role = role;
		this.department = department;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", salary=" + salary + ", role="
				+ role + ", department=" + department + "]";
	}

}