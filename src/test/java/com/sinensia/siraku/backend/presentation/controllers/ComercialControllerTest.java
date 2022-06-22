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
import com.sinensia.siraku.backend.business.model.Comercial;
import com.sinensia.siraku.backend.business.services.ComercialServices;

@WebMvcTest(controllers=ComercialController.class)
class ComercialControllerTest {

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
	
	private Comercial comercial1;
	private Comercial comercial2;
	private List<Comercial> comerciales;
	
	@Test
	public void cuandoPidoComerciales() throws Exception {
		
		when(comercialServices.getAll()).thenReturn(comerciales);
		
		MvcResult mvcResult = mockMvc.perform(get("/comerciales").contentType("application/json"))
									 .andExpect(status().isOk())
									 .andReturn();
		
		// MvcResult de alguna manera modeliza la respuesta HTTP
		// En MvcResult tenemos un body que podemos analizar
		// En MvcResult tenemos el código HTTP, el tiempo en milisegundos, y todos los headers
		
		String responseBody = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);	// Obtenemos JSON (String) que viaja en la respuesta
		String comercialesAsJSON = objectMapper.writeValueAsString(comerciales);  					// Serializar objeto Java a JSON (String)
		
		System.out.println("responseBody: 				  " + responseBody);
		System.out.println("comercial serializado a JSON: " + comercialesAsJSON);
		
		assertThat(responseBody).isEqualToIgnoringWhitespace(comercialesAsJSON);					// Comprobamos que nuestro controlador ha serializado correctamente.
		
	}
	
	
	
	
	// ***************************************************************
	//
	// PRIVATE METHODS
	//
	// ***************************************************************
	
	private void initMocks() {
		
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
