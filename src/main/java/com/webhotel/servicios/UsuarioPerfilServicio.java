package com.webhotel.servicios;

import java.util.List;

import com.webhotel.modelos.UsuarioPerfil;


public interface UsuarioPerfilServicio {

	UsuarioPerfil buscarXId(int id);

	UsuarioPerfil buscarXType(String type);
	
	List<UsuarioPerfil> listar();
	
}
