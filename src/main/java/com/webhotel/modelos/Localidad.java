package com.webhotel.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Localidad")
public class Localidad {

	@Id
	@Column(name="ID", nullable= false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="cpostal")
	private int cpostal;
	
	@Column(name="provincia_id")
	private int provincia_id;
	
	public Localidad() {
		super();
	}
	
	

	public Localidad(int id, String nombre, int cpostal, int provincia_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cpostal = cpostal;
		this.provincia_id = provincia_id;
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

	public int getCpostal() {
		return cpostal;
	}

	public void setCpostal(int cpostal) {
		this.cpostal = cpostal;
	}

	public int getProvincia_id() {
		return provincia_id;
	}

	public void setProvincia_id(int provincia_id) {
		this.provincia_id = provincia_id;
	}


	
}
