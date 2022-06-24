package com.sinensia.siraku.backend.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinensia.siraku.backend.business.model.Comercial;
import com.sinensia.siraku.backend.business.services.ComercialServices;

@Controller
@RequestMapping("/siraku")
public class AppComercialController {

	@Autowired
	private ComercialServices comercialServices;
	
	@GetMapping("/comerciales")
	public ModelAndView getComerciales() {
		ModelAndView mav = new ModelAndView("comerciales");
		mav.addObject("comerciales", comercialServices.getAll());
		return mav;
	}

	
	// Para entregar el formulario de alta
	
	@GetMapping("/alta-comercial")
    public ModelAndView showForm() {
		
		// 1.- Nombre de la vista
		// 2.- Adjuntamos un objeto (un comercial nuevo) y le ponemos un nombre ("comercial")
		
        return new ModelAndView("alta-comercial", "comercial", new Comercial());
    }
	
	
	// Para recoger datos del formulario y crear el comercial
	
	@PostMapping("/addComercial")
    public ModelAndView submit(@ModelAttribute("comercial") Comercial comercial) {
  	
        comercialServices.create(comercial);
		
        ModelAndView mav = new ModelAndView("comerciales");
		mav.addObject("comerciales", comercialServices.getAll());
		return mav;
		
    } 
	
}
