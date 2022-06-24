package com.sinensia.siraku.backend.presentation.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
	
	@GetMapping("/pedidos/{codigo}")
	public Pedido getByCodigo(@PathVariable Long codigo) {
		return pedidoServices.read(codigo);
	}
	
	@PostMapping("/pedidos")
	public ResponseEntity<?> create(@RequestBody Pedido pedido, UriComponentsBuilder ucb){
		
		Pedido createdPedido = pedidoServices.create(pedido);
		
		return ResponseEntity
				.created(ucb.path("pedidos/{codigo}").build(createdPedido.getCodigo()))
				.build();
	}
}
