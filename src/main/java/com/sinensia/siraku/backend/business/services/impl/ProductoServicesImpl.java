package com.sinensia.siraku.backend.business.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.sinensia.siraku.backend.business.model.Familia;
import com.sinensia.siraku.backend.business.model.Producto;
import com.sinensia.siraku.backend.business.services.ProductoServices;
import com.sinensia.siraku.backend.integration.model.FamiliaPL;
import com.sinensia.siraku.backend.integration.model.ProductoPL;
import com.sinensia.siraku.backend.integration.repositories.ProductoPLRepository;

@Service
@Primary
public class ProductoServicesImpl implements ProductoServices {

	@Autowired
	private ProductoPLRepository productoPLRepository;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	@Override
	public Producto create(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto read(long codigo) {
		ProductoPL productoPL = productoPLRepository.findById(codigo).orElse(null);
		return mapper.map(productoPL, Producto.class);
	}

	@Override
	public Producto update(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(long codigo) {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> getBetweenDates(Date desde, Date hasta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumeroTotalProductos() {
		return (int) productoPLRepository.count();
	}

	@Override
	public Map<Familia, Integer> getNumeroTotalProductosPorFamilia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Familia, Double> getPrecioMedioPorFamilia() {
		// TODO Auto-generated method stub
		return null;
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
