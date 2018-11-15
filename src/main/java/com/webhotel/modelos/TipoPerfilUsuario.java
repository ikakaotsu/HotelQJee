package com.webhotel.modelos;

import java.io.Serializable;

public enum TipoPerfilUsuario implements Serializable{
	USER("USER"),
	DBA("DBA"),
	ADMIN("ADMIN");
	
	String tipoPerfilUsuario;
	
	private TipoPerfilUsuario(String tipoPerfilUsuario){
		this.tipoPerfilUsuario = tipoPerfilUsuario;
	}
	
	public String getTipoPerfilUsuario(){
		return tipoPerfilUsuario;
	}
	
}
