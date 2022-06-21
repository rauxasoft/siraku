package com.sinensia.siraku.backend.business.model;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	private String identificadorFiscal;
	private String nombreComercial;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Direccion direccion;
	private DatosContacto datosContacto;
	
	public Cliente() {
		
	}

	public String getIdentificadorFiscal() {
		return identificadorFiscal;
	}

	public void setIdentificadorFiscal(String identificadorFiscal) {
		this.identificadorFiscal = identificadorFiscal;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public DatosContacto getDatosContacto() {
		return datosContacto;
	}

	public void setDatosContacto(DatosContacto datosContacto) {
		this.datosContacto = datosContacto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificadorFiscal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(identificadorFiscal, other.identificadorFiscal);
	}

	@Override
	public String toString() {
		return "Cliente [identificadorFiscal=" + identificadorFiscal + ", nombreComercial=" + nombreComercial
				+ ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", direccion="
				+ direccion + ", datosContacto=" + datosContacto + "]";
	}
	
}
