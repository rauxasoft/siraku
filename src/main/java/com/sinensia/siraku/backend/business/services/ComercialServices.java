package com.sinensia.siraku.backend.business.services;

import java.util.List;

import com.sinensia.siraku.backend.business.model.Comercial;

public interface ComercialServices {

	/**
	 * El método create devuelve el Comercial con el código que le ha otorgado el sistema
	 * 
	 */
	Comercial create(Comercial comercial);
	
	Comercial read(long codigo);

	List<Comercial> getAll();
	
	int getNumeroTotalComerciales();
	
}
