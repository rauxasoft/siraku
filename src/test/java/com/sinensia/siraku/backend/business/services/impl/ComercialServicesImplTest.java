package com.sinensia.siraku.backend.business.services.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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

import com.sinensia.siraku.backend.business.model.Comercial;
import com.sinensia.siraku.backend.integration.model.ComercialPL;
import com.sinensia.siraku.backend.integration.repositories.ComercialPLRepository;

@ExtendWith(MockitoExtension.class)
class ComercialServicesImplTest {

	@Mock
	private ComercialPLRepository comercialPLRepository;
	
	@Mock
	private DozerBeanMapper mapper;
	
	@InjectMocks
	private ComercialServicesImpl comercialServices;
	
	@BeforeEach
	public void init() {
		initMocks();
	}
	
	private Comercial comercial1;
	private Comercial comercial2;
	private ComercialPL comercialPL1;
	private ComercialPL comercialPL2;
	
	@Test
	void testCreate() {
		
		when(comercialPLRepository.save(comercialPL1)).thenReturn(comercialPL1);
		when(mapper.map(comercialPL1, Comercial.class)).thenReturn(comercial1);
		when(mapper.map(comercial1, ComercialPL.class)).thenReturn(comercialPL1);
		
		Comercial comercial = comercialServices.create(comercial1);
		
		assertNotNull(comercial);
		assertEquals(100L, comercial.getCodigo());
		assertEquals("Honorio", comercial.getNombre());
		assertEquals("Martín", comercial.getApellido1());
		assertEquals("Salvador", comercial.getApellido2());
	}

	@Test
	void testRead() {
		
		// Arrange
		
			when(comercialPLRepository.findById(100L)).thenReturn(Optional.of(comercialPL1));
			when(comercialPLRepository.findById(500L)).thenReturn(Optional.empty());
			when(mapper.map(comercialPL1, Comercial.class)).thenReturn(comercial1);
		
		// Act
		
			Comercial comercial = comercialServices.read(100);
			Comercial comercialNoExistente = comercialServices.read(500L);
		
		// Assert
		
			assertNotNull(comercial);
			assertEquals(100L, comercial.getCodigo());
			assertEquals("Honorio",comercial.getNombre());
			assertEquals("Martín",comercial.getApellido1());
			assertEquals("Salvador",comercial.getApellido2());
			
			assertNull(comercialNoExistente);
	}

	@Test
	void testGetAll() {
		
		when(comercialPLRepository.findAll()).thenReturn(Arrays.asList(comercialPL1, comercialPL2));
		when(mapper.map(comercialPL1, Comercial.class)).thenReturn(comercial1);
		when(mapper.map(comercialPL2, Comercial.class)).thenReturn(comercial2);
		
		List<Comercial> comerciales = comercialServices.getAll();
		
		assertNotNull(comerciales);
		assertEquals(2,comerciales.size());
		
		assertTrue(comerciales.contains(comercial1));
		assertTrue(comerciales.contains(comercial2));	
	}

	@Test
	void testGetNumeroTotalComerciales() {
		
		when(comercialPLRepository.count()).thenReturn(2567L);
		
		int numeroTotalComerciales = comercialServices.getNumeroTotalComerciales();
		
		assertEquals(2567, numeroTotalComerciales);
		
	}
	
	// ***************************************************************
	//
	// PRIVATE METHODS
	//
	// ***************************************************************
	
	private void initMocks() {
		
		comercialPL1 = new ComercialPL();
		comercialPL1.setCodigo(100L);
		comercialPL1.setNombre("Honorio");
		comercialPL1.setApellido1("Martín");
		comercialPL1.setApellido2("Salvador");
		
		comercialPL2 = new ComercialPL();
		comercialPL2.setCodigo(101L);
		comercialPL2.setNombre("Carlota");
		comercialPL2.setApellido1("Vilchez");
		comercialPL2.setApellido2("Tajada");
		
		comercial1 = new Comercial();
		comercial1.setCodigo(100L);
		comercial1.setNombre("Honorio");
		comercial1.setApellido1("Martín");
		comercial1.setApellido2("Salvador");
		
		comercial2 = new Comercial();
		comercial2.setCodigo(101L);
		comercial2.setNombre("Carlota");
		comercial2.setApellido1("Vilchez");
		comercial2.setApellido2("Tejada");
	
	}
		
}
