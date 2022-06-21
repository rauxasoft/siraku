package com.sinensia.siraku.backend.business.services.dummy.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.sinensia.siraku.backend.business.model.Cliente;
import com.sinensia.siraku.backend.business.model.dtos.ClienteDTO2;
import com.sinensia.siraku.backend.business.services.ClienteServices;

@Service
public class ClienteServicesDummyImpl implements ClienteServices{
	
	public ClienteServicesDummyImpl() {
		Cliente cliente = new Cliente();
		cliente.setIdentificadorFiscal("23232323S");
		
		MAPA_CLIENTES.put("23232323S", cliente);
	}
	
	private final Map<String, Cliente> MAPA_CLIENTES = new TreeMap<>();

	@Override
	public void create(Cliente cliente) {		
		MAPA_CLIENTES.put(cliente.getIdentificadorFiscal(), cliente);
	}

	@Override
	public Cliente read(String identificadorFiscal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> getAll() {
		return new ArrayList<>(MAPA_CLIENTES.values());
	}

	@Override
	public List<Cliente> getByPoblacion(String poblacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> getByCodigoPostal(String codigoPostal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDTO2> getClieteDTO2() {
		// TODO Auto-generated method stub
		return null;
	}

}
