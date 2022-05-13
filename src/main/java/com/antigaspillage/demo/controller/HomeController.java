package com.antigaspillage.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;

@RestController
public class HomeController {

    @Autowired
    EntityManager entityManager;

    @RequestMapping("/")
    @ResponseBody
    public ModelAndView viewHome(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping("/home")
    @ResponseBody
    public ModelAndView viewHome2(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }




}
