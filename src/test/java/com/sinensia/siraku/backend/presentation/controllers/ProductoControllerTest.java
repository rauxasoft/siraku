package com.sinensia.siraku.backend.presentation.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
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
import com.sinensia.siraku.backend.presentation.restcontrollers.ProductoController;

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

	private Producto productoNuevo;
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
		
		when(productoServices.getBetweenPriceRange(0, 70)).thenReturn(productos1);
		
		MvcResult mvcResult = mockMvc.perform(get("/productos")
												.param("min","0")
												.param("max","70")
												.contentType("application/json"))
				  						.andExpect(status().isOk())
				  						.andReturn();

		String responseBody = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);

		assertThat(responseBody).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(productos1));
	}
	
	@Test
	public void cuandoCreoProducto() throws Exception {
		
		when(productoServices.create(productoNuevo)).thenReturn(producto1);
		
		String requestBody = objectMapper.writeValueAsString(productoNuevo);
		
		mockMvc.perform(post("/productos")
					.content(requestBody)
					.contentType("application/json"))
					.andExpect(status().isCreated())
					.andExpect(header().string("Location", "http://localhost/productos/100"));	
	}
	
	@Test
	public void cuandoEliminamosProductos() throws Exception {
		
		when(productoServices.delete(100L)).thenReturn(true);
		when(productoServices.delete(101L)).thenReturn(false);
		
		mockMvc.perform(delete("/productos/100")).andExpect(status().isNoContent());
		mockMvc.perform(delete("/productos/101")).andExpect(status().isNotFound());
		
	}
	

	// ***************************************************************
	//
	// PRIVATE METHODS
	//
	// ***************************************************************
	
	private void initMocks() {
		
		productoNuevo = new Producto();
		producto1 = new Producto();
		producto2 = new Producto();
		producto3 = new Producto();
		
		productoNuevo.setCodigo(null);
		producto1.setCodigo(100L);
		producto2.setCodigo(101L);
		producto3.setCodigo(102L);
		
		productoNuevo.setFamilia(Familia.HARDWARE);
		producto1.setFamilia(Familia.HARDWARE);
		producto2.setFamilia(Familia.SOFTWARE);
		producto3.setFamilia(Familia.CONSUMIBLE);
		
		productoNuevo.setPrecio(10.0);
		producto1.setPrecio(10.0);
		producto2.setPrecio(50.0);
		producto3.setPrecio(500.0);

		productoNuevo.setNombre("Producto1");
		producto1.setNombre("Producto1");
		producto2.setNombre("Producto2");
		producto3.setNombre("Producto3");
		
		productos1 = Arrays.asList(producto1, producto2); 				// precios entre 0 y 70
		productos2 = Arrays.asList(producto1);			  				// familia HARDWARE
		productos3 = Arrays.asList(producto1, producto2, producto3); 	// all
	}
	
}
