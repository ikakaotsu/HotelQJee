package com.webhotel.modelos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Reserva")
public class Reserva {

	@Id
	@Column(name="ID", nullable = false)
	private int id;
	
	@Column(name="NROHABITACION")
	private int nrohabitacion;
	
	@Column(name="TIPOHABITACION")
	private String tipohabitacion;
	
	@Column(name="NROCLIENTE")
	private int nrocliente;
	
	@Column(name="FECHAINGRESO")
	private LocalDate fechaingreso;
	
	@Column(name="FECHAEGRESO")
	private LocalDate fechaegreso;
	
	@Column(name="ESTADO")
	private String estado;
	
	@Column(name="DETALLES")
	private String detalles;
	

	public Reserva() {
		super();
	}

	public Reserva(int id, int nrohabitacion, String tipohabitacion, int nrocliente, LocalDate fechaingreso,
			LocalDate fechaegreso, String estado, String detalles) {
		super();
		this.id = id;
		this.nrohabitacion = nrohabitacion;
		this.tipohabitacion = tipohabitacion;
		this.nrocliente = nrocliente;
		this.fechaingreso = fechaingreso;
		this.fechaegreso = fechaegreso;
		this.estado = estado;
		this.detalles = detalles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNrohabitacion() {
		return nrohabitacion;
	}

	public void setNrohabitacion(int nrohabitacion) {
		this.nrohabitacion = nrohabitacion;
	}

	public String getTipohabitacion() {
		return tipohabitacion;
	}

	public void setTipohabitacion(String tipohabitacion) {
		this.tipohabitacion = tipohabitacion;
	}

	public int getNrocliente() {
		return nrocliente;
	}

	public void setNrocliente(int nrocliente) {
		this.nrocliente = nrocliente;
	}

	public LocalDate getFechaingreso() {
		return fechaingreso;
	}

	public void setFechaingreso(LocalDate fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public LocalDate getFechaegreso() {
		return fechaegreso;
	}

	public void setFechaegreso(LocalDate fechaegreso) {
		this.fechaegreso = fechaegreso;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	
}
