package com.buzhi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	public HelloWorldController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@RequestMapping("/")
    public String sayHello() {
        return "Hello,World!";
    }

}
