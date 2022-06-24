package com.sinensia.siraku.backend.presentation.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinensia.siraku.backend.business.services.ComercialServices;

@Controller
@RequestMapping("/ciraku")
public class AppComercialController {

	@Autowired
	private ComercialServices comercialServices;
	
	@GetMapping("/comerciales")
	public ModelAndView getComerciales() {
		
		ModelAndView mav = new ModelAndView("comerciales");
		
		mav.addObject("comerciales", comercialServices.getAll());
		mav.addObject("hoy", new Date());
		
		return mav;
	}
	
}
