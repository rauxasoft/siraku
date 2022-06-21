package com.sinensia.siraku.backend.business.services.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinensia.siraku.backend.business.model.Familia;
import com.sinensia.siraku.backend.business.model.Producto;
import com.sinensia.siraku.backend.business.services.ProductoServices;
import com.sinensia.siraku.backend.integration.model.FamiliaPL;
import com.sinensia.siraku.backend.integration.model.ProductoPL;
import com.sinensia.siraku.backend.integration.repositories.ProductoPLRepository;

@Service
public class ProductoServicesImpl implements ProductoServices {

	@Autowired
	private ProductoPLRepository productoPLRepository;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	@Override
	@Transactional
	public Producto create(Producto producto) {
		ProductoPL productoPL = mapper.map(producto, ProductoPL.class);
		ProductoPL createdProductoPL = productoPLRepository.save(productoPL);
		return mapper.map(createdProductoPL, Producto.class);
	}

	@Override
	public Producto read(long codigo) {
		ProductoPL productoPL = productoPLRepository.findById(codigo).orElse(null);
		return mapper.map(productoPL, Producto.class);
	}

	@Override
	@Transactional
	public Producto update(Producto producto) {
		
		boolean exists = productoPLRepository.existsById(producto.getCodigo());
		
		if(!exists) {
			return null;
		}
		
		ProductoPL productoPL = mapper.map(producto, ProductoPL.class);
		ProductoPL updatedProductoPL = productoPLRepository.save(productoPL);
		
		return mapper.map(updatedProductoPL, Producto.class);
	}

	@Override
	@Transactional
	public boolean delete(long codigo) {
		
		boolean existeAntes = productoPLRepository.existsById(codigo);
		
		if(existeAntes) {
			productoPLRepository.deleteById(codigo);
		}
		
		boolean existeDespues = productoPLRepository.existsById(codigo);
		
		return existeAntes && !existeDespues;
	}

	@Override
	public List<Producto> getAll() {
		return convertFromProductosPL(productoPLRepository.findAll());
	}

	@Override
	public List<Producto> getByFamilia(Familia familia) {
		FamiliaPL familiaPL = FamiliaPL.valueOf(familia.toString());
		return convertFromProductosPL(productoPLRepository.findByFamilia(familiaPL));
	}

	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		return convertFromProductosPL(productoPLRepository.findByPrecioBetween(min, max));
	}

	@Override
	public List<Producto> getBetweenDates(Date desde, Date hasta) {
		return convertFromProductosPL(productoPLRepository.findByFechaAltaBetween(desde, hasta));
	}

	@Override
	public int getNumeroTotalProductos() {
		return (int) productoPLRepository.count();
	}

	@Override
	public Map<Familia, Integer> getNumeroTotalProductosPorFamilia() {
		
		Map<Familia, Integer> estadisticas = new HashMap<>();
		
		List<Object[]> resultSet = productoPLRepository.getEstadistica1();
		
		for(Object[] fila: resultSet) {
			Familia familia = (Familia) fila[0];
			long cantidad = (Long) fila[1];
			estadisticas.put(familia, (int) cantidad);
		}
		
		return estadisticas;
	}

	@Override
	public Map<Familia, Double> getPrecioMedioPorFamilia() {
		
		Map<Familia, Double> estadisticas = new HashMap<>();
		
		List<Object[]> resultSet = productoPLRepository.getEstadistica2();
		
		for(Object[] fila: resultSet) {
			Familia familia = (Familia) fila[0];
			double precioMedio = (Double) fila[1];
			estadisticas.put(familia, precioMedio);
		}
		
		return estadisticas;
	}
	
	// ***************************************************************
	//
	// PRIVATE METHODS
	//
	// ***************************************************************

	private List<Producto> convertFromProductosPL(List<ProductoPL> productosPL){
		
		return productosPL.stream()
				.map(x -> mapper.map(x, Producto.class))
				.collect(Collectors.toList());
	}
	
}
