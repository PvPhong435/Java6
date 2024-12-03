package com.sof306.lab8.rest.controller;

import com.sof306.lab8.entity.Product;
import com.sof306.lab8.service.ProductService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {

    ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable String id) {
        return productService.findById(id);
    }

}
