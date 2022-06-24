package com.sinensia.siraku.backend.auditoria.presentation.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.siraku.backend.auditoria.business.model.RequestLog;
import com.sinensia.siraku.backend.auditoria.business.services.RequestLogServices;

@RestController
@RequestMapping("/auditoria")
public class RequestLogController {

	@Autowired
	private RequestLogServices requestLogServices;
	
	@GetMapping("/request-logs")
	public List<RequestLog> getAll(){
		return requestLogServices.getAll();
	}
	
}
