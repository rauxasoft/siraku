package com.sinensia.siraku.backend.business.services.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.sinensia.siraku.backend.business.model.Comercial;
import com.sinensia.siraku.backend.business.services.ComercialServices;

@SpringBootTest
@Sql(scripts = {"/data/h2/schema.sql","/data/h2/data.sql"})
class ComercialServicesImplIntegrationTest {

	@Autowired
	private ComercialServices comercialServices;
	
	@Test
	void testCreate() {
		
		Comercial comercial = new Comercial();
		comercial.setCodigo(null);
		comercial.setNombre("Nombre Nuevo");
		comercial.setApellido1("Apellido1 Nuevo");
		comercial.setApellido2("Apellido2 Nuevo");
		
		int numeroComercialesAntes = comercialServices.getNumeroTotalComerciales();
		
		Comercial createdComercial = comercialServices.create(comercial);
		
		assertNotNull(createdComercial);
		assertNotNull(createdComercial.getCodigo());
		assertEquals("Nombre Nuevo", createdComercial.getNombre());
		assertEquals("Apellido1 Nuevo", createdComercial.getApellido1());
		assertEquals("Apellido2 Nuevo", createdComercial.getApellido2());
		
		int numeroComercialesDespues = comercialServices.getNumeroTotalComerciales();
		
		assertTrue(numeroComercialesDespues == numeroComercialesAntes + 1);
		
	}

	@Test
	void testRead() {
		
		Comercial comercial = comercialServices.read(100L);
		
		assertNotNull(comercial);
		assertEquals(100L, comercial.getCodigo());
		assertEquals("Pepín",comercial.getNombre());
		assertEquals("Gálvez",comercial.getApellido1());
		assertEquals("Ridruejo",comercial.getApellido2());

		comercial = comercialServices.read(500L);
		
		assertNull(comercial);
		
	}

	@Test
	void testGetAll() {
		
		Comercial comercial1 = new Comercial();
		Comercial comercial2 = new Comercial();
		Comercial comercial3 = new Comercial();
		Comercial comercial4 = new Comercial();
		
		comercial1.setCodigo(100L);
		comercial2.setCodigo(101L);
		comercial3.setCodigo(102L);
		comercial4.setCodigo(103L);
		
		List<Comercial> comerciales = comercialServices.getAll();
		
		assertNotNull(comerciales);
		assertEquals(4, comerciales.size());
		assertTrue(comerciales.contains(comercial1));
		assertTrue(comerciales.contains(comercial2));
		assertTrue(comerciales.contains(comercial3));
		assertTrue(comerciales.contains(comercial4));
		
	}

	@Test
	void testGetNumeroTotalComerciales() {
		
		int numeroTotalComerciales = comercialServices.getNumeroTotalComerciales();
		
		assertEquals(4,numeroTotalComerciales);
		
	}

}
