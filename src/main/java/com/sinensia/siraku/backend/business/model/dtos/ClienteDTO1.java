package com.sinensia.siraku.backend.business.model.dtos;

import java.io.Serializable;

public class ClienteDTO1 implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nombreComercial;
	private String nombreCompleto;
	
	public ClienteDTO1() {
		
	}
	
	public ClienteDTO1(String nombreComercial, String nombreCompleto) {
		this.nombreComercial = nombreComercial;
		this.nombreCompleto = nombreCompleto;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	@Override
	public String toString() {
		return "ClienteDTO1 [nombreComercial=" + nombreComercial + ", nombreCompleto=" + nombreCompleto + "]";
	}
	
}
