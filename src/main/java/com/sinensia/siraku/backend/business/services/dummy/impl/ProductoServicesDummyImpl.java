package com.sinensia.siraku.backend.business.services.dummy.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sinensia.siraku.backend.business.model.Familia;
import com.sinensia.siraku.backend.business.model.Producto;
import com.sinensia.siraku.backend.business.services.ProductoServices;

@Service
public class ProductoServicesDummyImpl implements ProductoServices{

	private final Map<Long, Producto> MAPA_PRODUCTOS = new TreeMap<>();
	
	public ProductoServicesDummyImpl() {
		init();
	}
	
	@Override
	public Producto create(Producto producto) {

		Long utimoCodigo = ((TreeMap<Long,Producto>) MAPA_PRODUCTOS).lastKey();
		Long nuevoCodigo = utimoCodigo + 1;
		
		producto.setCodigo(nuevoCodigo);
		MAPA_PRODUCTOS.put(producto.getCodigo(), producto);

		return producto;
	}

	@Override
	public Producto read(long codigo) {
		return MAPA_PRODUCTOS.get(codigo);
	}
	
	@Override
	public Producto update(Producto producto) {
	
		Long codigo = producto.getCodigo();
		
		if(!MAPA_PRODUCTOS.containsKey(codigo)) {
			throw new IllegalStateException("El código " + codigo + " no existe.");
		}
		
		MAPA_PRODUCTOS.replace(codigo, producto);
		
		return producto;
	}

	@Override
	public boolean delete(long codigo) {
		return MAPA_PRODUCTOS.remove(codigo) != null;
	}

	@Override
	public List<Producto> getAll() {
		return new ArrayList<>(MAPA_PRODUCTOS.values());
	}
	
	@Override
	public List<Producto> getByFamilia(Familia familia) {
		
		return MAPA_PRODUCTOS.values().stream()
			.filter(x -> x.getFamilia() == familia)
			.collect(Collectors.toList());
	}

	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		
		return MAPA_PRODUCTOS.values().stream()
			.filter(x -> x.getPrecio() >= min && x.getPrecio() <= max)
			.collect(Collectors.toList());
	}

	@Override
	public List<Producto> getBetweenDates(Date desde, Date hasta) {
		
		return MAPA_PRODUCTOS.values().stream()
				.filter(x -> x.getFechaAlta().after(desde) && x.getFechaAlta().before(hasta))
				.collect(Collectors.toList());
	}

	@Override
	public int getNumeroTotalProductos() {
		return MAPA_PRODUCTOS.size();
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

	private void init() {
		
		Producto producto1 = new Producto();
		Producto producto2 = new Producto();
		Producto producto3 = new Producto();
		Producto producto4 = new Producto();
		Producto producto5 = new Producto();
		
		Date fecha1 = null;
		Date fecha2 = null;
		Date fecha3 = null;
		Date fecha4 = null;
		Date fecha5 = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			fecha1 = sdf.parse("01/10/2021");
			fecha2 = sdf.parse("02/10/2021");
			fecha3 = sdf.parse("03/10/2021");
			fecha4 = sdf.parse("04/10/2021");
			fecha5 = sdf.parse("05/10/2021");
		} catch(Exception e){
			
		}
		
		producto1.setCodigo(100L);
		producto1.setNombre("Impresora Laser HP 2p");
		producto1.setPrecio(460.5);
		producto1.setFamilia(Familia.HARDWARE);
		producto1.setDescatalogado(false);
		producto1.setFechaAlta(fecha1);
		
		producto2.setCodigo(101L);
		producto2.setNombre("Alfrombrilla Mouse CR7");
		producto2.setPrecio(2.5);
		producto2.setFamilia(Familia.CONSUMIBLE);
		producto2.setDescatalogado(true);
		producto2.setFechaAlta(fecha2);
		
		producto3.setCodigo(102L);
		producto3.setNombre("Contanerd Deluxe v.2");
		producto3.setPrecio(45.8);
		producto3.setFamilia(Familia.SOFTWARE);
		producto3.setDescatalogado(false);
		producto3.setFechaAlta(fecha3);
		
		producto4.setCodigo(103L);
		producto4.setNombre("Ordenador Port�til Epson DE500");
		producto4.setPrecio(1200.0);
		producto4.setFamilia(Familia.HARDWARE);
		producto4.setDescatalogado(false);
		producto4.setFechaAlta(fecha4);
		
		producto5.setCodigo(104L);
		producto5.setNombre("Antivirus Defender MegaPlus v.3");
		producto5.setPrecio(14.7);
		producto5.setFamilia(Familia.SOFTWARE);
		producto5.setDescatalogado(false);
		producto5.setFechaAlta(fecha5);
		
		MAPA_PRODUCTOS.put(producto1.getCodigo(), producto1);
		MAPA_PRODUCTOS.put(producto2.getCodigo(), producto2);
		MAPA_PRODUCTOS.put(producto3.getCodigo(), producto3);
		MAPA_PRODUCTOS.put(producto4.getCodigo(), producto4);
		MAPA_PRODUCTOS.put(producto5.getCodigo(), producto5);
		
	}

}
