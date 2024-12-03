package com.sof306.lab8.controller;

import com.sof306.lab8.entity.Product;

import com.sof306.lab8.repository.AccountDao;
import com.sof306.lab8.service.ProductService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    ProductService productService;
    AccountDao accountDao;

    public ProductController(ProductService productService, AccountDao accountDao) {
        this.productService = productService;
        this.accountDao = accountDao;
    }

    @GetMapping("/list")
    public String list(Model model, @RequestParam Optional<String> cid, 
    		@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "9") int size) 
    {
    	Pageable pageable = PageRequest.of(page, size);

    	Page<Product> productPage = cid.isPresent() ? productService.findAllByCategoryId(cid.get(),pageable) : productService.findAll(pageable);
        model.addAttribute("items", productPage.getContent());
        model.addAttribute("currentPage", productPage.getNumber());
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("pageSize", size);
        return "product/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable String id) {
        Product item = productService.findById(id);
        model.addAttribute("item", item);
        return "product/detail";
    }

}
