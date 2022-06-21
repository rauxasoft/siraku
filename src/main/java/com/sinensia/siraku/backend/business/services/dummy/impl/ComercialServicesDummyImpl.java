package com.sinensia.siraku.backend.business.services.dummy.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sinensia.siraku.backend.business.model.Comercial;
import com.sinensia.siraku.backend.business.services.ComercialServices;

@Service
public class ComercialServicesDummyImpl implements ComercialServices {

	private Map<Long, Comercial> MAPA_COMERCIALES = new HashMap<>();
	
	public ComercialServicesDummyImpl() {
		init();
	}
	
	@Override
	public Comercial create(Comercial comercial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comercial read(long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comercial> getAll() {
		return new ArrayList<>(MAPA_COMERCIALES.values());
	}

	@Override
	public int getNumeroTotalComerciales() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void init() {
		
		Comercial comercial1 = new Comercial();
		Comercial comercial2 = new Comercial();
		
		comercial1.setCodigo(10000L);
		comercial1.setNombre("Comercial Dummy 1");
		comercial1.setApellido1("Apellido Dummy 1");
		comercial1.setApellido2("Apellido Dummy 1");
		
		comercial2.setCodigo(10001L);
		comercial2.setNombre("Comercial Dummy 2");
		comercial2.setApellido1("Apellido Dummy 2");
		comercial2.setApellido2("Apellido Dummy 2");
		
		MAPA_COMERCIALES.put(comercial1.getCodigo(), comercial1);
		MAPA_COMERCIALES.put(comercial2.getCodigo(), comercial2);
		
	}

}
