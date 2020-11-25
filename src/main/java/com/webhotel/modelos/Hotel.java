package com.webhotel.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Hotel")
public class Hotel {

	@Id
	@Column(name="ID", nullable = false)
	private int id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="DOMICILIO")
	private String domicilio;
	
	@Column(name="TELEFONO")
	private int telefono;
	
	@Column(name="CUIT")
	private int cuit;
	
	@Column(name="EMAIL")
	private String email;
	
	public Hotel() {
		super();
	}
	
	public Hotel(int id, String nombre, String descripcion, String domicilio, int telefono, int cuit, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.cuit = cuit;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getCuit() {
		return cuit;
	}

	public void setCuit(int cuit) {
		this.cuit = cuit;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
