package com.sinensia.siraku.backend.business.services;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sinensia.siraku.backend.business.model.Familia;
import com.sinensia.siraku.backend.business.model.Producto;

public interface ProductoServices {

	
	/**
	 * El método create devuelve el Producto con el c�digo que le ha otorgado el sistema
	 * 
	 */
	Producto create(Producto producto);
	
	Producto read(long codigo);
	
	/**
	 * El producto entrante debe tener un código existente
	 * 
	 * Si el código no existe lanza una IllegaStateException
	 * 
	 */
	Producto update(Producto producto);
	
	/**
	 * 
	 * Devuelve true si se ha podido eliminar
	 * 
	 */
	boolean delete(long codigo);
	
	List<Producto> getAll();
	
	List<Producto> getByFamilia(Familia familia);
	
	List<Producto> getBetweenPriceRange(double min, double max);
	
	List<Producto> getBetweenDates(Date desde, Date hasta);
	
	int getNumeroTotalProductos();
	
	Map<Familia, Integer> getNumeroTotalProductosPorFamilia();
	
	Map<Familia, Double> getPrecioMedioPorFamilia();

}
