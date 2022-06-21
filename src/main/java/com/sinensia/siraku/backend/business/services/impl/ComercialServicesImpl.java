package com.sinensia.siraku.backend.business.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinensia.siraku.backend.business.model.Comercial;
import com.sinensia.siraku.backend.business.services.ComercialServices;
import com.sinensia.siraku.backend.integration.model.ComercialPL;
import com.sinensia.siraku.backend.integration.repositories.ComercialPLRepository;

@Service
public class ComercialServicesImpl implements ComercialServices{

	@Autowired
	private ComercialPLRepository comercialPLRepository;
	
	@Autowired
	private DozerBeanMapper mapper;

	@Override
	@Transactional
	public Comercial create(Comercial comercial) {
		ComercialPL comercialPL = mapper.map(comercial, ComercialPL.class);
		ComercialPL createdComercialPL = comercialPLRepository.save(comercialPL);
		return mapper.map(createdComercialPL, Comercial.class);
	}

	@Override
	public Comercial read(long codigo) {
		Optional<ComercialPL> optional = comercialPLRepository.findById(codigo);
		return optional.isPresent()? mapper.map(optional.get(), Comercial.class) : null;
	}

	@Override
	public List<Comercial> getAll() {
		
		return comercialPLRepository.findAll().stream()
				.map(x -> mapper.map(x, Comercial.class))
				.collect(Collectors.toList());
	}

	@Override
	public int getNumeroTotalComerciales() {
		return (int) comercialPLRepository.count();
	}
	
}
