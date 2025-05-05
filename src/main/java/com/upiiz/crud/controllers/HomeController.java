package com.upiiz.crud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @GetMapping
    public String home() {
        return "login-v2";
    }
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    @GetMapping("/forgot")
    public String forgot() {
        return "forgot";
    }
    @PostMapping
    public String home2() {
        return "login-v2";
    }
    @PostMapping("/register")
    public String register2() {
        return "register";
    }
    @PostMapping("/forgot")
    public String forgot2() {
        return "forgot";
    }
}