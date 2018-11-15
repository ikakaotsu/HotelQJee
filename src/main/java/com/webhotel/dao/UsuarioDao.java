package com.webhotel.dao;

import java.util.List;

import com.webhotel.modelos.Usuario;;


public interface UsuarioDao {

	Usuario buscarXId(int id);
	
	Usuario buscarXSSO(String sso);
	
	void guardar(Usuario user);
	
	void borrarXSSO(String sso);
	
	List<Usuario> listarUsuarios();

}

