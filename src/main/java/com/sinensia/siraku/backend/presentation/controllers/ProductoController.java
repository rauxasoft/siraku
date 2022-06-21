package com.sinensia.siraku.backend.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.siraku.backend.business.model.Producto;
import com.sinensia.siraku.backend.business.services.ProductoServices;

@RestController
public class ProductoController {

	@Autowired
	private ProductoServices productoServices;
	
	@GetMapping("/productos")
	public List<Producto> getAll(){
		return productoServices.getAll();
	}
}
