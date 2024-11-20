package com.store.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.store.Dao.ProductDao;
import com.store.entity.Product;
import com.store.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/product/list")
	public String list(Model model)
	{
		List<Product> list=productService.findAll();
		model.addAttribute("items", list); 
		return "product/list";
	}
	
	@RequestMapping("/product/detail")
	public String detail()
	{
		
		return "product/list";
	}
}
