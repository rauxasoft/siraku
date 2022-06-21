package com.sinensia.siraku.backend.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LogAspectConfig {

	private Logger logger = LoggerFactory.getLogger(LogAspectConfig.class);

//  ********************************************************************************************
	
	@Before(value="execution(* com.sinensia.siraku.backend.business.services.impl.*.*(..))") 
	public void businessLogger(JoinPoint joinPoint) {
		
		String clase = joinPoint.getTarget().getClass().getSimpleName();
		String signature = joinPoint.getSignature().getName();
		
		logger.info("Business Layer execution: [{}] en la clase [{}]", signature, clase);
	}
	
//  ********************************************************************************************	
	
	@Before(value="execution(* com.sinensia.siraku.backend.presentation.controllers.*.*(..))") 
	public void presentationLogger(JoinPoint joinPoint) {
		
		String clase = joinPoint.getTarget().getClass().getSimpleName();
		String signature = joinPoint.getSignature().getName();
		
		logger.info("Presentation Layer execution: [{}] en la clase [{}]", signature, clase);
	}
	

}
