package com.Lab2.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Lab2.bean.Student2;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class UtilityController {
	@RequestMapping("/demo/utilities")
	public String utilites(Model model) throws Exception
	{
		File file=new ClassPathResource("/static/students.json").getFile();
		TypeReference<List<Student2>> type=new TypeReference<List<Student2>>() {
		};
		ObjectMapper mapper=new ObjectMapper();
		List<Student2> list=mapper.readValue(file, type);
		
		model.addAttribute("dssv",list);
		model.addAttribute("now",new Date());
		return "utilities";
	}
	
}
