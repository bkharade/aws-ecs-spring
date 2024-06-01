package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class controller {

	@GetMapping("Spring")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@GetMapping("iAmLive")
	public String iamAlive() {
		return "Installed at June 1st,2024";
	}

}