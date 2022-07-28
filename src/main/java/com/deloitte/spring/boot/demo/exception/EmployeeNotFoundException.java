package com.deloitte.spring.boot.demo.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1626677487292187443L;

	public EmployeeNotFoundException() {
		super();
	}

	public EmployeeNotFoundException(String message) {
		super(message);
	}
}