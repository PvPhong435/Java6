package com.Lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeI18nController {
	@GetMapping("/home/indexI18n")
	public String index(Model model)
	{
		return "home/indexI18n";
	}
	
	@GetMapping("/home/aboutI18n")
	public String about(Model model) {
		return "home/aboutI18n";
	}
	
}
