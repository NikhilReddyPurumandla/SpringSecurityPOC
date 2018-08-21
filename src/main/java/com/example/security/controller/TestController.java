package com.example.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@RequestMapping(value= "/allow", method = RequestMethod.GET)
	public String test() {
		return "Hello World!!";
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value= "secured/auth",method = RequestMethod.GET)
	public String deny(){
		return "secured method!!";
		
	}
}
