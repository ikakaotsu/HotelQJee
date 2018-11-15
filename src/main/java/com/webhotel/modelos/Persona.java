package com.webhotel.modelos;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@MappedSuperclass
public abstract class Persona {
	
	@Id
	@Column(name="ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length=60)
	private String nombre;
	@Column(length=60)
	private String apellido;
	@Column(length=60)
	private String domicilio;
	@Column(length=60)
	private int pais;
	@Column(length=60)
	private int provincia;
	@Column(length=60)
	private int localidad;
	@Column(length=60)
	private String telefono;
	@Column(length=60)
	private String email;
	
//	Constructor
	public Persona() {
		super();
	}

public Persona(int id, String nombre, String apellido, String domicilio, int pais, int provincia, int localidad,
		String telefono, String email) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.apellido = apellido;
	this.domicilio = domicilio;
	this.pais = pais;
	this.provincia = provincia;
	this.localidad = localidad;
	this.telefono = telefono;
	this.email = email;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public String getDomicilio() {
	return domicilio;
}

public void setDomicilio(String domicilio) {
	this.domicilio = domicilio;
}

public int getPais() {
	return pais;
}

public void setPais(int pais) {
	this.pais = pais;
}

public int getProvincia() {
	return provincia;
}

public void setProvincia(int provincia) {
	this.provincia = provincia;
}

public int getLocalidad() {
	return localidad;
}

public void setLocalidad(int localidad) {
	this.localidad = localidad;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
	
}
