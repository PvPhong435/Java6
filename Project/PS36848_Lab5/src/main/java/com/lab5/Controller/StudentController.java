package com.lab5.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab5.Dao.StudentDao;
import com.lab5.Model.Student;

import lombok.RequiredArgsConstructor;
@CrossOrigin("*")
@Controller
@RequiredArgsConstructor
public class StudentController {

	@Autowired
	StudentDao dao;
	
	@RequestMapping("/student/index")
	public String getMain(Model model)
	{
		List<Student> list=dao.findAll();
		
		model.addAttribute("students", list);
		return "/Views/index";
	}
	
	@GetMapping("/rest/students")
	public List<Student> getAll(Model model)
	{
		return dao.findAll();
	}
	
	@GetMapping("/rest/students/{email}")
	public Student getOne(@PathVariable("email") String email)
	{
		return dao.findById(email).get();
	}
	
	@PostMapping("/rest/students")
	public Student post(@RequestBody Student student)
	{
		dao.save(student);
		return student;
	}
	
	@PutMapping("/rest/students/{email}")
	public Student put(@PathVariable("email")String email,@RequestBody Student student)
	{
		dao.save(student);
		return student;
	}
	
	@DeleteMapping("/rest/students/{email}")
	public void delete(@PathVariable("email")String email)
	{
		dao.deleteById(email);
	}
}
