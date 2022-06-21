package com.sinensia.siraku.backend.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.siraku.backend.business.services.ClienteServices;
import com.sinensia.siraku.backend.integration.repositories.ClientePLRepository;

@RestController
public class BorrameController {

	@SuppressWarnings("unused")
	@Autowired
	private ClientePLRepository clienteRepository;
	
	@Autowired
	private ClienteServices clienteServices;
	
	@GetMapping("/test")
	public Object resultado() {
		
		// return clienteRepository.findAll();
		// return clienteRepository.findByNombre("Marta");
		// return clienteRepository.findByNombreLikeIgnoreCaseAndDireccionPoblacionOrderByIdentificadorFiscalDesc("%a%","Vendrell");
		// return clienteRepository.buscamePorNombre("Marta");
		// return clienteRepository.findByNombreAndDireccionLike("AR", "Barcelona");
		// return clienteRepository.dameCosas();
		// return clienteRepository.findClienteDTO1();
		   return clienteServices.getClieteDTO2();
		
	}
}