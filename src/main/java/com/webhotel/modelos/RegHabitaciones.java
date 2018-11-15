package com.webhotel.modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RegHabitaciones")
public class RegHabitaciones {
	@Id
	@Column(name="ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="codcliente")
	private int codcliente;
	@Column(name="fyhingreso")
	private Date fyhingreso;
	@Column(name="fyhegreso")
	private Date fyhegreso;
	@Column(name="nrohabitacion")
	private String nrohabitacion;
	@Column(name="flag")
	private boolean flag;
	
	
	public RegHabitaciones() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RegHabitaciones(int id, int codcliente, Date fyhingreso, Date fyhegreso, String nrohabitacion,
			boolean flag) {
		super();
		this.id = id;
		this.codcliente = codcliente;
		this.fyhingreso = fyhingreso;
		this.fyhegreso = fyhegreso;
		this.nrohabitacion = nrohabitacion;
		this.flag = flag;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCodcliente() {
		return codcliente;
	}


	public void setCodcliente(int codcliente) {
		this.codcliente = codcliente;
	}


	public Date getFyhingreso() {
		return fyhingreso;
	}


	public void setFyhingreso(Date fyhingreso) {
		this.fyhingreso = fyhingreso;
	}


	public Date getFyhegreso() {
		return fyhegreso;
	}


	public void setFyhegreso(Date fyhegreso) {
		this.fyhegreso = fyhegreso;
	}


	public String getNrohabitacion() {
		return nrohabitacion;
	}


	public void setNrohabitacion(String nrohabitacion) {
		this.nrohabitacion = nrohabitacion;
	}


	public boolean isFlag() {
		return flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
