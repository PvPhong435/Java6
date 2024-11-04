package com.Lab2.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Lab2.bean.Student2;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class StudentController {
	@RequestMapping("/student")
	public String student(Model model,@RequestParam("index")Optional<Integer> index)throws Exception
	{
		ObjectMapper mapper=new ObjectMapper();
		String path="E:\\FPT Polytechnic\\JAVA\\Java6\\Project\\PS36848_LAB2\\src\\main\\resources\\static\\students.json";
		File file = new File(path);
		TypeReference<List<Student2>> type=new TypeReference<List<Student2>>() {
		};
		List<Student2> list=mapper.readValue(file, type);
		
		Student2 student=list.get(index.orElse(0));
		model.addAttribute("sv",student);
		model.addAttribute("index",index.orElse(0));
		
		return "student";
	}
}
