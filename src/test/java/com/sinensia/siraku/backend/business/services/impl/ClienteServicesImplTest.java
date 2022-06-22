package com.sinensia.siraku.backend.business.services.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sinensia.siraku.backend.business.model.dtos.ClienteDTO2;
import com.sinensia.siraku.backend.integration.repositories.ClientePLRepository;

@ExtendWith(MockitoExtension.class)
class ClienteServicesImplTest {

	@Mock
	private ClientePLRepository clientePLRepository;
	
	@Mock
	private DozerBeanMapper mapper;
	
	@InjectMocks
	private ClienteServicesImpl clienteServices;
	
	@BeforeEach
	public void init() {
		initMocks();
	}
	
	@Test
	void testGetClieteDTO2() {
		
		List<Object[]> resultSet = new ArrayList<>();
		
		Object[] fila1 = new Object[] {"12345A","Nombre Comercial 1","Nombre1","Apellido11","Apellido21"};
		Object[] fila2 = new Object[] {"12356B","Nombre Comercial 2","Nombre2","Apellido12","Apellido22"};
		Object[] fila3 = new Object[] {"44332C","Nombre Comercial 3","Nombre3","Apellido13","Apellido23"};
		
		resultSet.add(fila1);
		resultSet.add(fila2);
		resultSet.add(fila3);
		
		when(clientePLRepository.findDataForDTO2()).thenReturn(resultSet);
		
		List<ClienteDTO2> clientesDTO2 = clienteServices.getClieteDTO2();
		
		assertNotNull(clientesDTO2);
		assertEquals(3, clientesDTO2.size());
		
		List<String> codigos = clientesDTO2.stream().map(x -> x.getCodigo()).collect(Collectors.toList());
		List<String> nombresCompletos = clientesDTO2.stream().map(x -> x.getNombreCompleto()).collect(Collectors.toList());
		
		assertTrue(codigos.contains("12345A"));
		assertTrue(codigos.contains("12356B"));
		assertTrue(codigos.contains("44332C"));
		
		assertTrue(nombresCompletos.contains("Apellido11 Apellido21, Nombre1"));
		assertTrue(nombresCompletos.contains("Apellido12 Apellido22, Nombre2"));
		assertTrue(nombresCompletos.contains("Apellido13 Apellido23, Nombre3"));
		
	}

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testRead() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	void testGetByPoblacion() {
		fail("Not yet implemented");
	}

	@Test
	void testGetByCodigoPostal() {
		fail("Not yet implemented");
	}
	
	// ***************************************************************
	//
	// PRIVATE METHODS
	//
	// ***************************************************************
	
	private void initMocks() {
		
	}

}
