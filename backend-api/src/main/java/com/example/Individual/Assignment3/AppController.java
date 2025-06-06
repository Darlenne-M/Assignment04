package com.example.Individual.Assignment3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({"", "/", "/home", "dashboard", "/animals/"})
    public String showDashBoard(){
        return "redirect:/animals";
    }
    
}
