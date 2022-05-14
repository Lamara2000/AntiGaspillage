package com.antigaspillage.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.antigaspillage.demo.dao.ICartDAO;
import com.antigaspillage.demo.dao.ICategoryDAO;
import com.antigaspillage.demo.dao.ITraderDAO;
import com.antigaspillage.demo.data.Cart;
import com.antigaspillage.demo.data.Category;
import com.antigaspillage.demo.data.Role;
import com.antigaspillage.demo.data.User;
import com.antigaspillage.demo.repository.RepoCart;

@Controller
public class CartController {
	
	@Autowired
	private ICartDAO dao;
	
	@Autowired
	private ICategoryDAO categoryDao;
	
	@Autowired
	private ITraderDAO traderDao;
	
	@Autowired
	private RepoCart repo;
	
	@RequestMapping("/carts")
	public String index(Model model) {
		List<Cart> list = dao.findAll();
		model.addAttribute("carts",list);
		return "carts";
	}
	
	@RequestMapping(value = "/addCart", method = RequestMethod.GET)
	public String viewAdd(Model model) {
		Cart form = new Cart();
		List<Category> list = categoryDao.findAll();
		model.addAttribute("cartForm",form);
		model.addAttribute("categories",list);
		return "addCart";
	}
	
	@RequestMapping(value = "/addCart", method = RequestMethod.POST)
	public ModelAndView saveAdd(Model model, @ModelAttribute("cartForm")
    @Validated Cart cart, BindingResult result, final RedirectAttributes redirectAttributes) {
		try {
			User current = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			cart.setTrader(traderDao.findByRef(current.getId()));
			repo.save(cart);
        }
        catch (Exception e) {
        	List<Category> list = categoryDao.findAll();
    		model.addAttribute("categories",list);
            return new ModelAndView("addCart");
        }
        return new ModelAndView("redirect:/carts");
	}
	
	

}
