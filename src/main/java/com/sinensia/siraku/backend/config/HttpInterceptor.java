package com.sinensia.siraku.backend.config;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sinensia.siraku.backend.auditoria.business.model.RequestLog;
import com.sinensia.siraku.backend.auditoria.business.services.RequestLogServices;

@Component
public class HttpInterceptor implements HandlerInterceptor {

	@Autowired
	private RequestLogServices requestLogServices;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		Long elapsedTime = System.currentTimeMillis() - (Long) request.getAttribute("startTime");
		
		RequestLog requestLog = new RequestLog();
	
		requestLog.setTimeStamp(new Date());
		requestLog.setElapsedTime(elapsedTime);
		requestLog.setIp(request.getRemoteAddr());
		requestLog.setMethod(request.getMethod());
		requestLog.setUrl(request.getRequestURI());
		requestLog.setHttpStatusCode(String.valueOf(response.getStatus()));
		
		requestLogServices.create(requestLog);
	
	}


}
