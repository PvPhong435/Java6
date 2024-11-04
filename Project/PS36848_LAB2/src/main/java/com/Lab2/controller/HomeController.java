package com.Lab2.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Lab2.bean.Student2;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {
	@RequestMapping("/home/index")
	public String index(Model model) throws Exception
	{
		model.addAttribute("message","Welcome to Thymeleaf");
		ObjectMapper mapper=new ObjectMapper();
		String path="E:\\FPT Polytechnic\\JAVA\\Java6\\Project\\PS36848_LAB2\\src\\main\\resources\\static\\student.json";
		File file = new File(path);
		Student2 student=mapper.readValue(file, Student2.class);
		model.addAttribute("sv",student);
		return "home/index";
	}
}
