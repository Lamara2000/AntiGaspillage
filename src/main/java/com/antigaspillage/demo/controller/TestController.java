package com.antigaspillage.demo.controller;

import com.antigaspillage.demo.data.User;
import com.antigaspillage.demo.form.AppUserForm;
import com.antigaspillage.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView vewTest(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("testpage");

        AppUserForm form = new AppUserForm();
        model.addAttribute("appUserForm", form);
        modelAndView.addObject("appUserForm", form);
        return modelAndView;
    }

   @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ModelAndView viewTest2(Model model, @ModelAttribute("appUserForm")
   @Validated AppUserForm appUserForm, BindingResult result, final RedirectAttributes redirectAttributes){
        User u = userRepository.findUserWithName(appUserForm.getEmail());
       System.out.println(u.toString());
        return new ModelAndView("testpage");
   }
}
