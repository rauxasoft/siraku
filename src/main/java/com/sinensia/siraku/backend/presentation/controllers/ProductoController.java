package com.sinensia.siraku.backend.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
	
	@GetMapping("/productos/{codigo}")
	public Producto getByCodigo(@PathVariable("codigo") Long codigo) {
		return productoServices.read(codigo);
	}
	
	@PostMapping("/productos")
	public ResponseEntity<?> create(@RequestBody Producto producto, UriComponentsBuilder ucb){
		
		Producto createdProducto = productoServices.create(producto);
		
		return ResponseEntity
				.created(ucb.path("/productos/{codigo}").build(createdProducto.getCodigo()))
				.build();
	}
}
