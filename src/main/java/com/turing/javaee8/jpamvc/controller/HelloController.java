package com.turing.javaee8.jpamvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turing.javaee8.jpamvc.service.GreetingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class HelloController {
	
	@Autowired
	GreetingService greetingService;
	
	@GetMapping("/hello")
	String hello() {
		log.info("hello from inside hello method");
		return "hello";
	}
	
	@GetMapping("/hi")
	String hi() {
		log.info("hello from inside hi method");
		return "hi";
	}
	@GetMapping("/greet")
	String greet() {
		return this.greetingService.greet();
	}
}
