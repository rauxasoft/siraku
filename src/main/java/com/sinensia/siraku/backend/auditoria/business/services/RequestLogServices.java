package com.sinensia.siraku.backend.auditoria.business.services;

import java.util.List;

import com.sinensia.siraku.backend.auditoria.business.model.RequestLog;

public interface RequestLogServices {

	void create(RequestLog requestLog);
	
	List<RequestLog> getAll();
	
}
