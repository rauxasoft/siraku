package com.sinensia.siraku.backend.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.siraku.backend.business.model.Pedido;
import com.sinensia.siraku.backend.business.services.PedidoServices;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoServices pedidoServices;
	
	@GetMapping
	public List<Pedido> getAll(){
		return pedidoServices.getAll();
	}
}
