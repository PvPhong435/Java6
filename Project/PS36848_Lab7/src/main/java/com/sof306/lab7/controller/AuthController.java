package com.sof306.lab7.controller;

import com.sof306.lab7.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private String url = "http://localhost:3000/rest/authorities";

    private final UserService userService;

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

    @GetMapping("/oauth2/login/success")
    public String success(OAuth2AuthenticationToken oauth2) {
        userService.loginFormOAuth2(oauth2);
        return "redirect:home/index";
    }

    

}
