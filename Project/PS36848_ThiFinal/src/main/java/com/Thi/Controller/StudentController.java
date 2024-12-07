package com.Thi.Controller;

import javax.print.DocFlavor.STRING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Thi.Dao.StudentDao;
import com.Thi.Model.Student;
import com.Thi.Model.StudentMap;

@Controller
public class StudentController {
	@Autowired
	StudentDao dao;
	
	@RequestMapping("/student/index")
	public String index(Model model)
	{
		Student student=new Student("","",0.0,true,"VN");
		model.addAttribute("form", student);
		StudentMap map=dao.findAll();
		model.addAttribute("items", map);
		return "student/index";
	}
	
	@RequestMapping("/student/edit/{key}")
	public String edit(Model model,@PathVariable("key") String key)
	{
		model.addAttribute("key",key);
		Student student=dao.findByKey(key);
		model.addAttribute("form", student);
		StudentMap map=dao.findAll();
		model.addAttribute("items", map);
		return "student/index";
		
	}
	
	@RequestMapping("/student/create")
	public String create(Student student)
	{
		dao.create(student);
		return "redirect:/student/index";
	}
	
	@RequestMapping("/student/update/{key}")
	public String update(@PathVariable("key") String key,Student student)
	{
		dao.update(key, student);
		return "redirect:/student/edit/"+key;
	}
	
	@RequestMapping("/student/delete/{key}")
	public String delete(@PathVariable("key") String key)
	{
		dao.delete(key);
		return "redirect:/student/index";
	}
	
	@RequestMapping("/student/{find}")
	public String findLike(@PathVariable("find") String find,Model model)
	{
		
		return "";
	}
}
