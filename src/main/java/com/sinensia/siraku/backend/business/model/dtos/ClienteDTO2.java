package com.sinensia.siraku.backend.business.model.dtos;

import java.io.Serializable;

public class ClienteDTO2 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String nombreComercial;
	private String nombreCompleto;
	
	public ClienteDTO2() {
		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
		return "ClienteDTO2 [codigo=" + codigo + ", nombreComercial=" + nombreComercial + ", nombreCompleto="
				+ nombreCompleto + "]";
	}
	
}
