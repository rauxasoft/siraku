package com.sinensia.siraku.backend.business.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinensia.siraku.backend.business.model.Cliente;
import com.sinensia.siraku.backend.business.model.dtos.ClienteDTO2;
import com.sinensia.siraku.backend.business.services.ClienteServices;
import com.sinensia.siraku.backend.integration.model.ClientePL;
import com.sinensia.siraku.backend.integration.repositories.ClientePLRepository;

@Service
public class ClienteServicesImpl implements ClienteServices{

	@Autowired
	private ClientePLRepository clientePLRepository;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	@Override
	public List<ClienteDTO2> getClieteDTO2() {
		
		List<Object[]> resultSet = clientePLRepository.findDataForDTO2();
		
		List<ClienteDTO2> clientesDTO2 = new ArrayList<>();
		
		for(Object[] fila: resultSet) {
			
			String identificadorFiscal = (String) fila[0];
			String nombreComercial = (String) fila[1];
			String nombre = (String) fila[2];
			String apellido1 = (String) fila[3];
			String apellido2 = (String) fila[4];
			
			ClienteDTO2 clienteDTO2 = new ClienteDTO2();
			clienteDTO2.setCodigo(identificadorFiscal);
			clienteDTO2.setNombreComercial(nombreComercial);
			clienteDTO2.setNombreCompleto(apellido1 + " " + apellido2 + ", " + nombre);
			
			clientesDTO2.add(clienteDTO2);
		}
		
		return clientesDTO2;
	}
	
	@Override
	@Transactional
	public void create(Cliente cliente) {
		
		ClientePL clientePL = mapper.map(cliente, ClientePL.class);
		clientePLRepository.save(clientePL);
	}

	@Override
	public Cliente read(String identificadorFiscal) {
		ClientePL clientePL = clientePLRepository.findById(identificadorFiscal).orElse(null);
		return mapper.map(clientePL, Cliente.class);
	}

	@Override
	public List<Cliente> getAll() {
		return convertFromClientesPL(clientePLRepository.findAll());
	}

	@Override
	public List<Cliente> getByPoblacion(String poblacion) {
		return convertFromClientesPL(clientePLRepository.findByDireccionPoblacion(poblacion));
	}

	@Override
	public List<Cliente> getByCodigoPostal(String codigoPostal) {
		return convertFromClientesPL(clientePLRepository.findByDireccionCodigoPostal(codigoPostal));
	}
	
	// ***************************************************************
	//
	// PRIVATE METHODS
	//
	// ***************************************************************

	private List<Cliente> convertFromClientesPL(List<ClientePL> clientesPL){
		
		return clientesPL.stream()
				.map(x -> mapper.map(x, Cliente.class))
				.collect(Collectors.toList());
	}
	
}
