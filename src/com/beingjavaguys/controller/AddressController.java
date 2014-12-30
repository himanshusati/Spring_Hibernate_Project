package com.beingjavaguys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.beingjavaguys.domain.User;
import com.beingjavaguys.domain.UserAddress;
import com.beingjavaguys.service.UserService;

@Controller
public class AddressController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/AddAddress")
	public ModelAndView getRegisterForm(@ModelAttribute("UserAddress") UserAddress address,
			BindingResult result) {
		ArrayList<String> state = new ArrayList<String>();
		state.add("Delhi NCR");
		state.add("Mumbai");
		state.add("Chennai");
		state.add("Banglore");
		state.add("Hyderabad");
		ArrayList<String> city = new ArrayList<String>();
		city.add("Delhi");
		city.add("Gurgaon");
		city.add("noida");
		city.add("ghaziabad");
		city.add("Greater Noida");
		city.add("Kolkata");
		city.add("Chennai");
		city.add("Bangalore");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("state", state);
		model.put("city", city);
		System.out.println("Address Form");
		
		
		return new ModelAndView("AddAddress", "model", model);
	}
	
	@RequestMapping("/saveAddress")
	public ModelAndView saveAddress(@ModelAttribute("UserAddress") UserAddress address,
			BindingResult result,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		User attribute = (User) session.getAttribute("userdetails");
		if(attribute!=null)
		{
			
		address.setUser(attribute);
		address.getH_city();
		address.getH_no();
		userService.addAddress(address);
		}
		return new ModelAndView("AddAddress");
	}
	}
	

