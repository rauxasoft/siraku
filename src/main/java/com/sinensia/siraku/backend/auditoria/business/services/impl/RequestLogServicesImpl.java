package com.sinensia.siraku.backend.auditoria.business.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sinensia.siraku.backend.auditoria.business.model.RequestLog;
import com.sinensia.siraku.backend.auditoria.business.services.RequestLogServices;
import com.sinensia.siraku.backend.auditoria.integration.model.RequestLogPL;
import com.sinensia.siraku.backend.auditoria.integration.repositories.RequestLogPLRepository;

@Service
public class RequestLogServicesImpl implements RequestLogServices{

	@Autowired
	private RequestLogPLRepository requestLogPLRepository;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	@Override
	@Transactional
	public void create(RequestLog requestLog) {
		
		RequestLogPL requestLogPL = mapper.map(requestLog, RequestLogPL.class);
		requestLogPLRepository.save(requestLogPL);
	}

	@Override
	public List<RequestLog> getAll() {
		
		return requestLogPLRepository.findAll(Sort.by("timeStamp").descending())
				.stream()
				.map(x -> mapper.map(x, RequestLog.class))
				.collect(Collectors.toList());
	}

}
