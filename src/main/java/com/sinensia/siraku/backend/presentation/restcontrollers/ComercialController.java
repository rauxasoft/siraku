package com.sinensia.siraku.backend.presentation.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
	
	@GetMapping("/comerciales/{codigo}")
	public Comercial getByCodigo(@PathVariable Long codigo) {
		return comercialServices.read(codigo);
	}
	
	@PostMapping("/comerciales")
	public ResponseEntity<?> create(@RequestBody Comercial comercial, UriComponentsBuilder ucb){
		
		Comercial createdComercial = comercialServices.create(comercial);
		
		return ResponseEntity
				.created(ucb.path("/comerciales/{codigo}").build(createdComercial.getCodigo()))
				.build();
	}
}
