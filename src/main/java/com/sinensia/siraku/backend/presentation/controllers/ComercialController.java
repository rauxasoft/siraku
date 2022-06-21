package com.sinensia.siraku.backend.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.siraku.backend.business.model.Comercial;
import com.sinensia.siraku.backend.business.services.ComercialServices;

@RestController
public class ComercialController {

	@Autowired
	private ComercialServices comercialServices;
	
	@GetMapping("/comerciales")
	public List<Comercial> getAll(){
		return comercialServices.getAll();
	}
}
