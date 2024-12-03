package com.sof306.lab7.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final HttpServletRequest request;

    @GetMapping("/home/index")
    public String index(Model model) {
        model.addAttribute("message", "This is home page");
        return "home/index";
    }

    @GetMapping("/home/about")
    public String about(Model model) {
        model.addAttribute("message", "This is introduction page");
        return "home/index";
    }

//    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/home/admins")
    public String admins(Model model) {
        if (!request.isUserInRole("ADMIN")) {
            return "redirect:/auth/access/denied";
        }
        model.addAttribute("message", "Hello administrators");
        return "home/index";
    }

//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/home/users")
    public String users(Model model) {
        if (!request.isUserInRole("ADMIN") || !request.isUserInRole("USER")) {
            return "redirect:/auth/access/denied";
        }
        model.addAttribute("message", "Hello users");
        return "home/index";
    }

//    @PreAuthorize("isAuthenticated()")
    @GetMapping("/home/authenticated")
    public String authenticated(Model model) {
        if (request.getRemoteUser() == null) {
            return "redirect:/auth/access/denied";
        }
        model.addAttribute("message", "Hello authenticated user");
        return "home/index";
    }

    @GetMapping("/home/thymeleaf1")
    public String thymeleaf1(Model model) {
        model.addAttribute("message", "Thymeleaf - Without extras");
        return "home/thymeleaf1";
    }

    @GetMapping("/home/thymeleaf2")
    public String thymeleaf2(Model model) {
        model.addAttribute("message", "Thymeleaf - With extras");
        return "home/thymeleaf2";
    }

}
