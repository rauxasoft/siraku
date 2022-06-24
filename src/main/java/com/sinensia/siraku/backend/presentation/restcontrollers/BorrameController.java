package com.sinensia.siraku.backend.presentation.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.siraku.backend.business.services.ClienteServices;
import com.sinensia.siraku.backend.business.services.ProductoServices;
import com.sinensia.siraku.backend.integration.model.LineaPedidoPL;
import com.sinensia.siraku.backend.integration.model.PedidoPL;
import com.sinensia.siraku.backend.integration.repositories.ClientePLRepository;
import com.sinensia.siraku.backend.integration.repositories.PedidoPLRepository;

@RestController
@SuppressWarnings("unused")
public class BorrameController {

	@Autowired
	private ClientePLRepository clienteRepository;
	
	@Autowired
	private PedidoPLRepository pedidoPLRepository;
	
	@Autowired
	private ProductoServices productoServices;
	
	@Autowired
	private ClienteServices clienteServices;
	
	@GetMapping("/test")
	public Object resultado() {
		
		// return clienteRepository.findAll();
		// return clienteRepository.findByNombre("Marta");
		// return clienteRepository.findByNombreLikeIgnoreCaseAndDireccionPoblacionOrderByIdentificadorFiscalDesc("%a%","Vendrell");
		// return clienteRepository.buscamePorNombre("Marta");
		// return clienteRepository.findByNombreAndDireccionLike("AR", "Barcelona");
		// return clienteRepository.dameCosas();
		// return clienteRepository.findClienteDTO1();
	    // return clienteServices.getClieteDTO2();
		// return productoServices.getNumeroTotalProductosPorFamilia();
		// return productoServices.getPrecioMedioPorFamilia();
		//   return pedidoPLRepository.getLineasPedido();
		   return pedidoPLRepository.getLineasPedido(2L);
		
	
		
		
	}
}
