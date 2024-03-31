package com.javaexpress.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/hello")
public class HelloController {
	
	@GetMapping //fetch the data from database or source
	public String getHello() {
		return "Welcome to Spring Boot Course";
	}
	//  http://localhost:8080/api/hello
}
