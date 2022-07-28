package com.deloitte.spring.boot.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "dept_table")
public class Department {

	@Id
	@Column(name = "department_id")
	@GenericGenerator(name = "dept_seq", strategy = "increment")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq")
	private int departmentId;

	@Column(name = "department_name")
	@Size(min = 2, max = 40, message = "departmentName should be minimum of 2 and a maximum of 40 characters")
	@NotNull(message = "department Name cannot be Null")
	private String departmentName;

	@Column(name = "city")
	private String city;

	public Department() {
	}

	public Department(String departmentName, String city) {
		super();
		this.departmentName = departmentName;
		this.city = city;
	}

	public Department(int departmentId, String departmentName, String city) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.city = city;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", city=" + city
				+ "]";
	}

}