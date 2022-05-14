package com.antigaspillage.demo.controller;

import com.antigaspillage.demo.dao.TraderDAOImpl;
import com.antigaspillage.demo.data.Role;
import com.antigaspillage.demo.data.Trader;
import com.antigaspillage.demo.data.User;
import com.antigaspillage.demo.form.AppTraderForm;
import com.antigaspillage.demo.form.AppUserForm;
import com.antigaspillage.demo.repository.RoleRepository;
import com.antigaspillage.demo.repository.TraderRepository;
import com.antigaspillage.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class TraderController {

    @Autowired
    private TraderDAOImpl traderDAO;

    @Autowired
    private TraderRepository traderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private User user;

    @RequestMapping(value = "/becomeTrader", method = RequestMethod.GET)
    public ModelAndView viewRegister(Model model, @RequestParam Long curUser) {
        ModelAndView modelAndView = new ModelAndView();
        user = userRepository.getById(curUser);
        modelAndView.setViewName("becomeTrader");

        AppTraderForm appTraderForm = new AppTraderForm();
        modelAndView.addObject("appTraderForm", appTraderForm);
        return modelAndView;
    }

    @RequestMapping(value = "/becomeTrader", method = RequestMethod.POST)
    public ModelAndView saveRegister(Model model, @ModelAttribute("appTraderForm")
    @Validated AppTraderForm appTraderForm, BindingResult result, final RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();

        Trader newTrader = traderDAO.addNewTrader(appTraderForm,user);
        Role role = roleRepository.findRoleByName("USER_TRADER");

        traderRepository.updateUser(role, user.getId());
        traderRepository.save(newTrader);

        modelAndView.setViewName("login");
        return modelAndView;
    }
}
