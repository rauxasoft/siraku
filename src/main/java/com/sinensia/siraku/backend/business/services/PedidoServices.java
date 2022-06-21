package com.sinensia.siraku.backend.business.services;

import java.util.List;

import com.sinensia.siraku.backend.business.model.Pedido;

public interface PedidoServices {

	Pedido create(Pedido pedido);
	Pedido read(long codigo);
	
	List<Pedido> getAll();
	
}
