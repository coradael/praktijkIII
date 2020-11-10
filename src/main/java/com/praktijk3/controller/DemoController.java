package com.praktijk3.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/hi2")
	public String intro(Model model) {
		
		//attribute for testing
		model.addAttribute("date", new java.util.Date());
		
		return "hi2";
	}

}
