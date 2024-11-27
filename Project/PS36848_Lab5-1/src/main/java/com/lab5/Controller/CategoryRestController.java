package com.lab5.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lab5.Dao.CategoryDao;
import com.lab5.Model.Categories;

import lombok.Delegate;

import org.springframework.web.bind.annotation.PutMapping;


@CrossOrigin("*")
@RestController
public class CategoryRestController {
	@Autowired
	CategoryDao dao;
	
	@GetMapping("/rest/categories")
	public ResponseEntity<List<Categories>> getAll(Model model)
	{
		return ResponseEntity.ok(dao.findAll());
	}
	
	@GetMapping("/rest/categories/{id}")
	public ResponseEntity<Categories> getOne(@PathVariable("id") String id)
	{
		if(!dao.existsById(id))
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dao.findById(id).get());
	}
	
	@PostMapping("/rest/categories")
	public ResponseEntity<Categories> post(@RequestBody Categories category)
	{
		if(dao.existsById(category.getId()))
		{
			return ResponseEntity.badRequest().build();
		}
		dao.save(category);
		return ResponseEntity.ok(category);
	}
	
	@PutMapping("/rest/categories/{id}")
	public ResponseEntity<Categories> put(@PathVariable("id") String id, @RequestBody Categories category) {
		if(!dao.existsById(id))
		{
			return ResponseEntity.notFound().build();
		}
		dao.save(category);
		return ResponseEntity.ok(category);
	}
	
	@DeleteMapping("/rest/categories/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String id)
	{
		if(!dao.existsById(id))
		{
			return ResponseEntity.notFound().build();
		}
		dao.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	
}
