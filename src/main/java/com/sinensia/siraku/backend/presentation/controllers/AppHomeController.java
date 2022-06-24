package com.sinensia.siraku.backend.presentation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/siraku")
public class AppHomeController {

	@GetMapping({"/home","/"})
	public String getHome() {
		return "home";        
	}
	
}
