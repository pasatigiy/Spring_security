package com.example.springsecc06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calc")
public class CalcController {

    @GetMapping
    public String calc(){
        return "calc";
    }
}
