package com.sinensia.siraku.backend.presentation.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinensia.siraku.backend.business.model.Familia;
import com.sinensia.siraku.backend.business.model.Producto;
import com.sinensia.siraku.backend.business.services.ProductoServices;

@WebMvcTest(controllers=ProductoController.class)
class ProductoControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private ProductoServices productoServices;
	
	@BeforeEach
	public void init() {
		initMocks();
	}

	private Producto producto1;
	private Producto producto2;
	private Producto producto3;
	private List<Producto> productos1;
	private List<Producto> productos2;
	private List<Producto> productos3;

	@Test
	public void cuandoPidoTodosLosProductos() throws Exception {
		
		when(productoServices.getAll()).thenReturn(productos3);
		
		MvcResult mvcResult = mockMvc.perform(get("/productos").contentType("application/json"))
								.andExpect(status().isOk())
								.andReturn();
		
		String responseBody = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
		
		assertThat(responseBody).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(productos3));
	}
	
	@Test
	public void cuandoPidoProductosPorFamilia() throws Exception {
		
		when(productoServices.getByFamilia(Familia.HARDWARE)).thenReturn(productos2);
		
		MvcResult mvcResult = mockMvc.perform(get("/productos").param("familia","HARDWARE").contentType("application/json"))
											  .andExpect(status().isOk())
											  .andReturn();
		
		String responseBody = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
		
		assertThat(responseBody).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(productos2));
		
	}
	
	@Test
	public void cuandoPidoProductosEntreRangoPrecios() throws Exception {
		//TODO
	}
	
	@Test
	public void cuandoCreoProducto() throws Exception {
		//TODO
	}
	
	public void cuandoEliminamosProductoExistente() throws Exception {
		//TODO
	}
	
	public void cuandoEliminamosProductoNoExistente() throws Exception {
		//TODO
	}
	
	
	// ***************************************************************
	//
	// PRIVATE METHODS
	//
	// ***************************************************************
	
	private void initMocks() {
		
		producto1 = new Producto();
		producto2 = new Producto();
		producto3 = new Producto();
		
		producto1.setCodigo(100L);
		producto2.setCodigo(101L);
		producto3.setCodigo(102L);
		
		producto1.setFamilia(Familia.HARDWARE);
		producto2.setFamilia(Familia.SOFTWARE);
		producto3.setFamilia(Familia.CONSUMIBLE);
		
		producto1.setPrecio(10.0);
		producto2.setPrecio(50.0);
		producto3.setPrecio(500.0);

		producto1.setNombre("Producto1");
		producto2.setNombre("Producto2");
		producto3.setNombre("Producto3");
		
		productos1 = Arrays.asList(producto1, producto2); 				// precios entre 0 y 70
		productos2 = Arrays.asList(producto1);			  				// familia HARDWARE
		productos3 = Arrays.asList(producto1, producto2, producto3); 	// all
	}
	
}
