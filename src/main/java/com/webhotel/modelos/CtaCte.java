package com.webhotel.modelos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CTACTE")
public class CtaCte extends Persona implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4929276810599062709L;
	@Column(name="CUIT")
	private String cuit;
	@Column(name="CODIGO_POSTAL")
	private int codigo_postal;
	@Column(name="IVA_TIPO")
	private int iva_tipo;
	
//	Constructor
	public CtaCte() {
		super();
	}
public CtaCte(String cuit, int codigo_postal, int iva_tipo) {
		super();
		this.cuit = cuit;
		this.codigo_postal = codigo_postal;
		this.iva_tipo = iva_tipo;
	}

	//	Getters and Setters
	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public int getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(int codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public int getIva_tipo() {
		return iva_tipo;
	}

	public void setIva_tipo(int iva_tipo) {
		this.iva_tipo = iva_tipo;
	}
	
	
	
}
