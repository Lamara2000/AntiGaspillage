package com.antigaspillage.demo.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.antigaspillage.demo.data.*;
import com.antigaspillage.demo.repository.CartRepository;
import com.antigaspillage.demo.repository.ReservationRepository;
import com.antigaspillage.demo.repository.TraderRepository;
import com.antigaspillage.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.antigaspillage.demo.dao.ICartDAO;
import com.antigaspillage.demo.dao.ICategoryDAO;
import com.antigaspillage.demo.dao.ITraderDAO;

@RestController
public class CartController {
	
	@Autowired
	private ICartDAO dao;
	
	@Autowired
	private ICategoryDAO categoryDao;
	
	@Autowired
	private ITraderDAO traderDAO;
	
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private TraderRepository traderRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/carts")
	public ModelAndView index(Model model) {
		ModelAndView modelAndView = new ModelAndView("carts");
		List<Cart> list = dao.findAll();
		modelAndView.addObject("carts",list);
		return modelAndView;
	}

	@RequestMapping(value = "/rerservCart", method = RequestMethod.GET)
	public ModelAndView viewAdd(Model model, @RequestParam Long id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView modelAndView = new ModelAndView("reservCarts");
		User user = userRepository.findUserWithName(auth.getName());
		Trader trader = traderRepository.findByUserId(user);
		Cart cart = cartRepository.findWithId(id) ;
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		Reservation reservation = new Reservation(user,trader,cart , timestamp,0);
		modelAndView.addObject("reservasion",reservation);
		return modelAndView;
	}

	@RequestMapping(value = "/reservCart", method = RequestMethod.POST)
	public ModelAndView saveRes(Model model, @ModelAttribute("reservasion")
	@Validated Reservation reservation, BindingResult result, final RedirectAttributes redirectAttributes) {
		try {
			reservationRepository.save(reservation);
		}
		catch (Exception e) {
			List<Category> list = categoryDao.findAll();
			model.addAttribute("categories",list);
			return new ModelAndView("addCart");
		}
		return new ModelAndView("redirect:/carts");
	}
	
	@RequestMapping(value = "/addCart", method = RequestMethod.GET)
	public ModelAndView viewRes(Model model) {
		ModelAndView modelAndView = new ModelAndView("addCart");
		Cart form = new Cart();
		List<Category> list = categoryDao.findAll();
		modelAndView.addObject("cartForm",form);
		modelAndView.addObject("categories",list);
		return modelAndView;
	}
	
	@RequestMapping(value = "/addCart", method = RequestMethod.POST)
	public ModelAndView saveAdd(Model model, @ModelAttribute("cartForm")
    @Validated Cart cart, BindingResult result, final RedirectAttributes redirectAttributes) {
		try {
			User current = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			cart.setTrader(traderDAO.findByRef(current.getId()));
			cartRepository.save(cart);
        }
        catch (Exception e) {
        	List<Category> list = categoryDao.findAll();
    		model.addAttribute("categories",list);
            return new ModelAndView("addCart");
        }
        return new ModelAndView("redirect:/carts");
	}
	
	

}
