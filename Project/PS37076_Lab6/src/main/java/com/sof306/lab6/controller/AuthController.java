package com.sof306.lab6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/auth/login/form")
    public String form() {
        return "auth/login";
    }

    @GetMapping("/auth/login/success")
    public String success(Model model) {
        model.addAttribute("message", "Đăng nhập thành công");
        return "forward:/auth/login/form";
    }

    @GetMapping("/auth/login/error")
    public String error(Model model) {
        model.addAttribute("message", "Sai thông tin đăng nhập!");
        return "forward:/auth/login/form";
    }

    @GetMapping("/auth/logout/success")
    public String logout(Model model) {
        model.addAttribute("message", "Đăng xuất thành công");
        return "forward:/auth/login/form";
    }

    @GetMapping("/auth/access/denied")
    public String accessDenied(Model model) {
        model.addAttribute("message", "Bạn không có quyền truy xuất");
        return "auth/login";
    }

}
