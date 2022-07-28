package com.deloitte.spring.boot.demo.exception;

public class EmployeeExistException extends RuntimeException{
	public EmployeeExistException()
	{
		super();
		
	}
	public EmployeeExistException(String msg)
	{
		super(msg);
		
	}

}
