package com.Lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.Lab3.bean.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class StudentController {
	
	@GetMapping("/student/form")
	public String form(Model model)
	{
		Student student=new Student();
		student.setFullname("Phạm Văn Phong");
		model.addAttribute("sv", student);
		
		return "student/form";
	}
	
	@PostMapping("/student/save")
	public String postMethodName(@ModelAttribute("sv") Student form) {
		
		return "student/success";
	}
	
}
