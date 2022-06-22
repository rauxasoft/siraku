package com.sinensia.siraku.backend.business.services.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sinensia.siraku.backend.business.model.Cliente;
import com.sinensia.siraku.backend.business.model.Comercial;
import com.sinensia.siraku.backend.business.model.LineaPedido;
import com.sinensia.siraku.backend.business.model.Pedido;
import com.sinensia.siraku.backend.integration.model.ClientePL;
import com.sinensia.siraku.backend.integration.model.ComercialPL;
import com.sinensia.siraku.backend.integration.model.LineaPedidoPL;
import com.sinensia.siraku.backend.integration.model.PedidoPL;
import com.sinensia.siraku.backend.integration.repositories.PedidoPLRepository;

@ExtendWith(MockitoExtension.class)
class PedidoServicesImplTest {

	@Mock
	private PedidoPLRepository pedidoPLRepository;
	
	@Mock
	private DozerBeanMapper mapper;
	
	@InjectMocks
	private PedidoServicesImpl pedidoServices;
	
	@BeforeEach
	public void init() {
		initMocks();
	}
	
	private Pedido pedido1;
	private Pedido pedido2;
	private PedidoPL pedidoPL1;
	private PedidoPL pedidoPL2;
	
	@Test
	void testCreate() {
		
		when(pedidoPLRepository.save(pedidoPL1)).thenReturn(pedidoPL1);
		when(mapper.map(pedidoPL1, Pedido.class)).thenReturn(pedido1);
		when(mapper.map(pedido1, PedidoPL.class)).thenReturn(pedidoPL1);

		Pedido pedido = pedidoServices.create(pedido1);
		
		assertNotNull(pedido);
		assertEquals(100L, pedido.getCodigo());
		assertEquals("Primera observación", pedido.getObservaciones());
		assertNull(pedido.getComercial().getApellido2());
		assertEquals("Pulido", pedido.getComercial().getApellido1());
		
	}

	@Test
	void testRead() {
		
		when(pedidoPLRepository.findById(100L)).thenReturn(Optional.of(pedidoPL1));
		when(mapper.map(pedidoPL1, Pedido.class)).thenReturn(pedido1);
		
		Pedido pedido = pedidoServices.read(100L);
		
		assertNotNull(pedido);
		assertEquals(100L, pedido.getCodigo());
		assertEquals("Primera observación", pedido.getObservaciones());
		assertNull(pedido.getComercial().getApellido2());
		assertEquals("Pulido", pedido.getComercial().getApellido1());
		
	}

	@Test
	void testGetAll() {

		when(pedidoPLRepository.findAll()).thenReturn(Arrays.asList(pedidoPL1, pedidoPL2));
		when(mapper.map(pedidoPL1, Pedido.class)).thenReturn(pedido1);
		when(mapper.map(pedidoPL2, Pedido.class)).thenReturn(pedido2);
		
		List<Pedido> pedidos = pedidoServices.getAll();
		
		assertNotNull(pedidos);
		assertEquals(2, pedidos.size());
		
		assertTrue(pedidos.contains(pedido1));
		assertTrue(pedidos.contains(pedido2));
		
	}
	
	// ***************************************************************
	//
	// PRIVATE METHODS
	//
	// ***************************************************************
	
	private void initMocks() {
		
		List<LineaPedido> lista = new ArrayList<LineaPedido>();
		List<LineaPedidoPL> listaPL = new ArrayList<LineaPedidoPL>();
		
		Comercial comercial1 = new Comercial();
		comercial1.setApellido1("Pulido");
		
		ComercialPL comercialPL1 = new ComercialPL();
		comercialPL1.setApellido1("Pulido");
		
		pedido1 = new Pedido();
		pedido1.setCodigo(100L);
		pedido1.setCliente(new Cliente());
		pedido1.setComercial(comercial1);
		pedido1.setObservaciones("Primera observación");
		pedido1.setLineas(lista);
		
		pedido2 = new Pedido();
		pedido2.setCodigo(101L);
		pedido2.setCliente(new Cliente());
		pedido2.setComercial(comercial1);
		pedido2.setObservaciones("Segunda observación");
		pedido2.setLineas(lista);
		
		pedidoPL1 = new PedidoPL();
		pedidoPL1.setCodigo(100L);
		pedidoPL1.setCliente(new ClientePL());
		pedidoPL1.setComercial(comercialPL1);
		pedidoPL1.setObservaciones("Primera observación");
		pedidoPL1.setLineas(listaPL);
		
		pedidoPL2 = new PedidoPL();
		pedidoPL2.setCodigo(101L);
		pedidoPL2.setCliente(new ClientePL());
		pedidoPL2.setComercial(comercialPL1);
		pedidoPL2.setObservaciones("Segunda observación");
		pedidoPL2.setLineas(listaPL);
	}
}
