package com.sinensia.siraku.backend.business.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinensia.siraku.backend.business.model.Pedido;
import com.sinensia.siraku.backend.business.services.PedidoServices;
import com.sinensia.siraku.backend.integration.model.PedidoPL;
import com.sinensia.siraku.backend.integration.repositories.PedidoPLRepository;

@Service
public class PedidoServicesImpl implements PedidoServices{

	@Autowired
	private PedidoPLRepository pedidoPLRepository;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	@Override
	@Transactional
	public Pedido create(Pedido pedido) {
		PedidoPL pedidoPL = mapper.map(pedido, PedidoPL.class);
		PedidoPL createdPedidoPL = pedidoPLRepository.save(pedidoPL);
		return mapper.map(createdPedidoPL, Pedido.class);
	}

	@Override
	public Pedido read(long codigo) {
		PedidoPL pedidoPL = pedidoPLRepository.findById(codigo).orElse(null);
		return mapper.map(pedidoPL, Pedido.class);
	}

	@Override
	public List<Pedido> getAll() {
		
		return pedidoPLRepository.findAll().stream()
				.map(x -> mapper.map(x, Pedido.class))
				.collect(Collectors.toList());
	}

}
