package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class HelloController {

	@Value("${message}")
	private String message;
	
	@GetMapping("/")
	public String index() {
		return "hello from app, " + message; 
	}
	
	@GetMapping("/greetings")
	public String greetings() {
		String dburl = System.getenv().getOrDefault("example.datasource.url", "got default value");
		return "db URL : " + dburl; 
	}
	
}
