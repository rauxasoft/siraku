package com.sinensia.siraku.backend.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class HttpInterceptor implements HandlerInterceptor {

//	@Autowired
//	private RequestLogServices requestLogServices;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		request.setAttribute("startTime", System.currentTimeMillis());
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		Long startTime = (Long) request.getAttribute("startTime");
		Long elapsedTime = System.currentTimeMillis() - startTime;
		
		
	//	RequestLog requestLog = new RequestLog();
	//	requestLog.setURL(request.getssss);
	//	requestLog.setElapsedTime(elapsedTime);
	//	requestLog.setMethod(request.getMethod());
	//	requestLog.setHttpStatusCode(response.getXXXX());
		
	//	requestLogServices.create(requestLog);
		
		
		// De un objeto request podemos extraer la siguiente información:
		
		// 1.- La IP remota
		// 2.- El verbo HTTP utilizado
		// 3.- La URL solicitada
		
		// De un objeto response podemos extraer la siguiente información:
		
		// 1.- El código de estado HTTP
		
		//TODO
		
		// Vamos a registrar cada petición HTTP con la información que se detalla en la base de datos!
		// Necesitamos:
		// 1.- Crear un modelo RequestLog
		// 2.- Crear la tabla
		// 3.- Crear el repsoitorio
		// 4.- Crear el servicio de business (interface)
		
		//     void create(RequestLog)
		//     List<RequestLog> getAll()
		
		// 5.- Implementar el servicio de business 
		// 6.- Inyectar el servicios de business en esta misma clase
		// 7.- Crear un nuevo controlador RequestLogController para poder obtener listado del registro de logs
		
	}


}
