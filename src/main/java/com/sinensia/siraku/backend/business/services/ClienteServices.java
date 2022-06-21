package com.sinensia.siraku.backend.business.services;

import java.util.List;

import com.sinensia.siraku.backend.business.model.Cliente;
import com.sinensia.siraku.backend.business.model.dtos.ClienteDTO2;

public interface ClienteServices {

	void create(Cliente cliente);
	
	Cliente read(String identificadorFiscal);
	
	List<Cliente> getAll();
	
	List<Cliente> getByPoblacion(String poblacion);
	List<Cliente> getByCodigoPostal(String codigoPostal);
	
	List<ClienteDTO2> getClieteDTO2();
	
}
