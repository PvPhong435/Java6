package com.Lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.Lab3.bean.Student;
import com.Lab3.bean.StudentValidation;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ValidationController {
	
	@GetMapping("/validation/form")
	public String form(Model model)
	{
		StudentValidation student=new StudentValidation();
//		student.setFullname("Phạm Văn Phong");
		model.addAttribute("sv", student);
		
		return "Validation/form";
	}
	
	@PostMapping("/validation/save")
	public String save(Model model,@Validated @ModelAttribute("sv") StudentValidation form,Errors error) {
		if(error.hasErrors())
		{
			model.addAttribute("message","Vui lòng sửa các lỗi sau");
			System.out.println("có lỗi");
			return "Validation/form";
		}
		else
		{
			return "Validation/success";
		}
	}
}
