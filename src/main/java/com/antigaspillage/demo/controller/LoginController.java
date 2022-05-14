package com.antigaspillage.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

    @GetMapping("/login")
    public ModelAndView loginPage(Model model) {return new ModelAndView("login");}

    @PostMapping("/account")
    public ModelAndView accountRedirection(Model model){
        return new ModelAndView("accountPage");
    }
}
