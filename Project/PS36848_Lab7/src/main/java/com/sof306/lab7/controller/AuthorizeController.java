package com.sof306.lab7.controller;

import com.sof306.lab7.service.SecurityRestTemplate;
import com.sof306.lab7.service.SecurityRestUrl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AuthorizeController {

    private final SecurityRestTemplate restTemplate;

    private final String url = "http://localhost:8080/rest/authorities";

    @GetMapping("/rest/template")
    public String demo1(Model model) {
        model.addAttribute("db", restTemplate.get(url));
        return "view";
    }

    @GetMapping("/rest/url")
    public String demo2(Model model) {
        model.addAttribute("db", SecurityRestUrl.get(url));
        return "view";
    }

}
