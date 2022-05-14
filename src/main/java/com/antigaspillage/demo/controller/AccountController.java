package com.antigaspillage.demo.controller;

import com.antigaspillage.demo.data.*;
import com.antigaspillage.demo.repository.CartRepository;
import com.antigaspillage.demo.repository.ReservationRepository;
import com.antigaspillage.demo.repository.TraderRepository;
import com.antigaspillage.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private TraderRepository traderRepository;



    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ModelAndView viewAccount(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView modelAndView = new ModelAndView("accountPage");

        User user = userRepository.findUserWithName(auth.getName());
        Trader trader = traderRepository.findByUserId(user);
        List<Reservation> reservations = reservationRepository.findUserWithUser(user);
        List<Cart> cartList = cartRepository.listTraderCart(trader);

        Role role = user.getRole();
        boolean traderRole =false;
        if (role.getName().equals("USER_TRADER"))
            traderRole=true;

        modelAndView.addObject("role", role);
        modelAndView.addObject("user", user);
        modelAndView.addObject("reservations",reservations);
        modelAndView.addObject("carts", cartList);
        modelAndView.addObject("statut", traderRole);
        return modelAndView;
    }

    @GetMapping("/dellReserv")
    public ModelAndView viewAccountDelete(@RequestParam Long reservation) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView modelAndView = new ModelAndView("accountPage");

        User user = userRepository.findUserWithName(auth.getName());
        Trader trader = traderRepository.findByUserId(user);
        List<Reservation> reservations = reservationRepository.findUserWithUser(user);
        List<Cart> cartList = cartRepository.listTraderCart(trader);

        Role role = user.getRole();

        modelAndView.addObject("role", role);
        modelAndView.addObject("user", user);
        modelAndView.addObject("reservations",reservations);
        modelAndView.addObject("carts", cartList);

        reservationRepository.deletteById(reservation);
        return modelAndView;
    }

    @GetMapping("/dellCart")
    public ModelAndView viewDellCart(@RequestParam Long cart) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView modelAndView = new ModelAndView("accountPage");

        User user = userRepository.findUserWithName(auth.getName());
        Trader trader = traderRepository.findByUserId(user);
        List<Reservation> reservations = reservationRepository.findUserWithUser(user);
        List<Cart> cartList = cartRepository.listTraderCart(trader);

        Role role = user.getRole();


        modelAndView.addObject("role", role);
        modelAndView.addObject("user", user);
        modelAndView.addObject("reservations",reservations);
        modelAndView.addObject("carts", cartList);

        cartRepository.deletteById(cart);
        return modelAndView;
    }

    @GetMapping("/traderForm")
    public ModelAndView switchToTraer(Model model){
        ModelAndView modelAndView = new ModelAndView("becomeTrader");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        userRepository.findUserWithName(auth.getName());
        modelAndView.addObject(auth.getName());
        return modelAndView;
    }

}
