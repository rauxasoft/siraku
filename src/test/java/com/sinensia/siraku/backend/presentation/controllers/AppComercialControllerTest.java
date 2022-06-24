package com.sinensia.siraku.backend.presentation.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
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
import com.sinensia.siraku.backend.business.model.Comercial;
import com.sinensia.siraku.backend.business.services.ComercialServices;
import com.sinensia.siraku.backend.presentation.restcontrollers.ComercialController;

@WebMvcTest(controllers=ComercialController.class)
class AppComercialControllerTest {

	@Autowired
	private MockMvc mockMvc;	// "aparato" que va a realizar peticiones HTTP y recibir respuestas (es el cliente)
	
	@Autowired
	private ObjectMapper objectMapper; // "aparato" de Jackson para serializar/deserializar de JSON a Java o viceversa
	
	@MockBean
	private ComercialServices comercialServices; // servicio "fake"
	
	@BeforeEach
	public void init() {
		initMocks();
	}
	
	private Comercial comercialNuevo;
	private Comercial comercial1;
	private Comercial comercial2;
	private List<Comercial> comerciales;
	
	@Test
	public void cuandoPidoComerciales() throws Exception {
		
		when(comercialServices.getAll()).thenReturn(comerciales);
		
		MvcResult mvcResult = mockMvc.perform(get("/comerciales").contentType("application/json"))
									 .andExpect(status().isOk())
									 .andReturn();
	
		String responseBody = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);	
		
		assertThat(responseBody).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(comerciales));				
		
	}
	
	@Test
	public void cuandoPidoComercialPorCodigo() throws Exception {
		
		when(comercialServices.read(100L)).thenReturn(comercial1);
		
		MvcResult mvcResult = mockMvc.perform(get("/comerciales/100").contentType("application/json"))
				 .andExpect(status().isOk())
				 .andReturn();
		
		String responseBody = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
		assertThat(responseBody).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(comercial1));
		
	}
	
	@Test
	public void cuandoCreoComercial() throws Exception {
		
		when(comercialServices.create(comercialNuevo)).thenReturn(comercial1);
		
		String requestBody = objectMapper.writeValueAsString(comercialNuevo);
		
		mockMvc.perform(post("/comerciales")
				.content(requestBody)
				.contentType("application/json"))
				.andExpect(status().isCreated())
				.andExpect(header().string("Location", "http://localhost/comerciales/100"));	
		
	}
	
	
	// ***************************************************************
	//
	// PRIVATE METHODS
	//
	// ***************************************************************
	
	private void initMocks() {
		
		comercialNuevo = new Comercial();
		comercialNuevo.setCodigo(null);
		comercialNuevo.setNombre("Pepín");
		comercialNuevo.setApellido1("Gálvez");
		comercialNuevo.setApellido2("Ridruejo");
		
		comercial1 = new Comercial();
		comercial1.setCodigo(100L);
		comercial1.setNombre("Pepín");
		comercial1.setApellido1("Gálvez");
		comercial1.setApellido2("Ridruejo");
		
		comercial2 = new Comercial();
		comercial2.setCodigo(101L);
		comercial2.setNombre("Carlota");
		comercial2.setApellido1("Cifuentes");
		comercial2.setApellido2("Merino");
		
		comerciales = Arrays.asList(comercial1, comercial2);
		
	}
}
