package com.sof306.lab8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingCartController {

    @GetMapping("/cart/view")
    public String view(Model model) {
        return "cart/view";
    }

}
