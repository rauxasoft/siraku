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

import com.sinensia.siraku.backend.business.model.Cliente;
import com.sinensia.siraku.backend.business.services.ClienteServices;

@RestController
public class ClienteController {

	@Autowired
	private ClienteServices clienteServices;
	
	@GetMapping("/clientes")
	public List<Cliente> getAll(){
		return clienteServices.getAll();
	}
	
	@GetMapping("/clientes/{identificador}")
	public Cliente getByIdentificador(@PathVariable String identificador) {
		return clienteServices.read(identificador);
	}
	
	@PostMapping("/clientes")
	public ResponseEntity<?> create(@RequestBody Cliente cliente, UriComponentsBuilder ucb){
		
		clienteServices.create(cliente);
		
		return ResponseEntity
				.created(ucb.path("/clientes/{idIdentificadorFiscal}").build(cliente.getIdentificadorFiscal()))
				.build();
	}
	
}
