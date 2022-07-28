package com.deloitte.spring.boot.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//	http://localhost:9999/hello

	@GetMapping("/hello")
	public String hello() {
		System.out.println("HelloController");
		return "HelloController world!";
	}

	@GetMapping("/hi")
	public String hi() {
		System.out.println("Hi");
		return "Hi there!";
	}
}