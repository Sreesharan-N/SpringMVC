package com.springmvc.Application.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Application.Service.CartService;
import com.springmvc.Application.UserBean.CartEntryBean;
import com.springmvc.Application.UserBean.FormBean;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="/addtocart",method=RequestMethod.POST)
	public String executeCart(HttpServletRequest request,@ModelAttribute("data") FormBean form) throws SQLException
	{
			boolean result=cartService.addToCart(form);
			if(result)
			{
				return "redirect:/showCart";
			}
			else
			{
				return "redirect:/productDescription";
			}
	}
	
	@RequestMapping(value="/showCart",method=RequestMethod.GET)
	public String displayShowCart(HttpServletRequest request,FormBean form,Model model) throws SQLException
	{
			FormBean result=cartService.showCart(form);
			if(result!=null)
			{
				model.addAttribute("form", result);
				return "cart";
			}
			else
			{
				return "productDescription";
			}
	}
	
	@RequestMapping(value="/deleteCart",method=RequestMethod.POST)
	public String displayDeleteCart(@ModelAttribute("delete")CartEntryBean cartentry,Model model) throws SQLException
	{
		boolean result=cartService.deleteCart(cartentry);
		if(result)
		{
			model.addAttribute("deleted successfully",cartentry);
			return "redirect:/showCart";
		}
		else
		{
			return "cart";
		}
		
	}
	
	@RequestMapping(value="/updateCart",method=RequestMethod.POST)
	public String displayUpdateCart(@ModelAttribute("update")CartEntryBean cartentry,Model model) throws SQLException
	{
		boolean result=cartService.updateCart(cartentry);
		if(result)
		{
			
			model.addAttribute("updated successfully",cartentry);
			return "redirect:/showCart";
		}
		else
		{
			return "cart";
		}
		
	}
}
