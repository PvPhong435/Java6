package com.store.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	@RequestMapping("/product/list")
	public String list()
	{
		return "product/list";
	}
	
	@RequestMapping("/product/detail")
	public String detail()
	{
		
		return "product/list";
	}
}
