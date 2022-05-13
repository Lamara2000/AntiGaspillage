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

    @Autowired
    EntityManager entityManager;


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
        User usertest = appUserDAO.createAppUser(appUserForm);
        System.out.println(usertest.toString());

        try {
            System.out.println(appUserForm.toString());
            User newUser = appUserDAO.createAppUser(appUserForm);
            userRepo.save(newUser);
            redirectAttributes.addFlashAttribute("flashUser", newUser);

        }
        // Other error!!
        catch (Exception e) {
            List<Role> roles = roleDAO.findAll();
            model.addAttribute("countries", roles);
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return new ModelAndView("registerPage");
        }
        return new ModelAndView("redirect:/registerSuccessful");
    }
}
