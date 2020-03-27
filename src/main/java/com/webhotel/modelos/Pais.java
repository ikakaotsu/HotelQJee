package com.webhotel.modelos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Pais")
public class Pais {

	@Id
	@Column(name="ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="code")
	private int code;
	
	@Column(name="iso3166a1")
	private char iso3166a1;
	
	@Column(name="iso3166a2")
	private char iso3166a2;
	
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany(mappedBy="pais",cascade=CascadeType.ALL)
	private Set<Provincia> provincias = new HashSet<Provincia>();

	public Pais() {
		super();
	}
	
	

	public Pais(int id, int code, char iso3166a1, char iso3166a2, String nombre, Set<Provincia> provincias) {
		super();
		this.id = id;
		this.code = code;
		this.iso3166a1 = iso3166a1;
		this.iso3166a2 = iso3166a2;
		this.nombre = nombre;
		this.provincias = provincias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public char getIso3166a1() {
		return iso3166a1;
	}

	public void setIso3166a1(char iso3166a1) {
		this.iso3166a1 = iso3166a1;
	}

	public char getIso3166a2() {
		return iso3166a2;
	}

	public void setIso3166a2(char iso3166a2) {
		this.iso3166a2 = iso3166a2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(Set<Provincia> provincias) {
		this.provincias = provincias;
	}
	
}
