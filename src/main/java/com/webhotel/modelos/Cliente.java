package com.webhotel.modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente extends Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5933343041431378640L;
	@Column(name = "TIPO_DOCUMENTO")
	private int tipo_documento;
	@Column(name = "NRO_DOCUMENTO")
	private String nro_documento;
	@Column(name = "ESTADO_CIVIL")
	private int estado_civil;
	@Column(name = "OCUPACION")
	private String ocupacion;
	@Column(name = "FECHANACIMIENTO")
	private Date fechanacimiento;

	// Constructor
	public Cliente() {
		super();
	}

	public Cliente(int tipo_documento, String nro_documento, int estado_civil, String ocupacion, Date fechanacimiento) {
		super();
		this.tipo_documento = tipo_documento;
		this.nro_documento = nro_documento;
		this.estado_civil = estado_civil;
		this.ocupacion = ocupacion;
		this.fechanacimiento = fechanacimiento;
	}

	public int getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(int tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getNro_documento() {
		return nro_documento;
	}

	public void setNro_documento(String nro_documento) {
		this.nro_documento = nro_documento;
	}

	public int getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(int estado_civil) {
		this.estado_civil = estado_civil;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
