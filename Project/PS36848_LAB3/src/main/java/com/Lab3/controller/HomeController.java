package com.Lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	@GetMapping("/home/index")
	public String index(Model model)
	{
		return "home/index";
	}
	
	@GetMapping("/home/about")
	public String about(Model model) {
		return "home/about";
	}
	
}
