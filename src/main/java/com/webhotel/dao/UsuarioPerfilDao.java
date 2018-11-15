package com.webhotel.dao;

import java.util.List;

import com.webhotel.modelos.UsuarioPerfil;


public interface UsuarioPerfilDao {

	List<UsuarioPerfil> listar();
	
	UsuarioPerfil buscarXTipo(String type);
	
	UsuarioPerfil buscarXId(int id);
}
