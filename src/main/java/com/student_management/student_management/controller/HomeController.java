package com.student_management.student_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "home/index";
    }
    @GetMapping("/test")
    public String test() {
        return "home/test";
    }
}