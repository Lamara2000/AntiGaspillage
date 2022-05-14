package com.antigaspillage.demo.controller;

import com.antigaspillage.demo.dao.RoleDAOImpl;
import com.antigaspillage.demo.dao.UserDAOImpl;
import com.antigaspillage.demo.data.Role;
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

import javax.persistence.EntityManager;
import java.util.List;

@RestController
public class RegisterController {
    @Autowired
    private UserDAOImpl appUserDAO;
    @Autowired
    private RoleDAOImpl roleDAO;

    @Autowired
    private UserRepository userRepo;


    @RequestMapping("/registerSuccessful")
    public String viewRegisterSuccessful(Model model) {

        return "registerSuccessfulPage";
    }

    // Show Register page.
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView viewRegister(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");

        AppUserForm form = new AppUserForm();
        model.addAttribute("appUserForm", form);
        modelAndView.addObject("appUserForm", form);
        return modelAndView;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView saveRegister(Model model, @ModelAttribute("appUserForm")
    @Validated AppUserForm appUserForm, BindingResult result, final RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();
        String error ="";

            User newUser = appUserDAO.createAppUser(appUserForm);
            if (newUser!=null) {
                userRepo.save(newUser);
                redirectAttributes.addFlashAttribute("flashUser", newUser);
                modelAndView.setViewName("registerSuccessful");
            }else {
                error = "Mots de passe non conforme";
                modelAndView.addObject("error", error);
                modelAndView.setViewName("register");
            }

        return modelAndView;
    }
}
