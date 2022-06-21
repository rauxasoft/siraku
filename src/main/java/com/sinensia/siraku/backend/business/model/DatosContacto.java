package com.sinensia.siraku.backend.business.model;

import java.io.Serializable;

public class DatosContacto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String telefono1;
	private String telefono2;
	private String email;
	
	public DatosContacto() {
		
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "DatosContacto [telefono1=" + telefono1 + ", telefono2=" + telefono2 + ", email=" + email + "]";
	}
	
}
