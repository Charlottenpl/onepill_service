package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
