package com.webhotel.servicios;

import java.util.List;

import com.webhotel.modelos.Usuario;

public interface UsuarioServicio {
	
	Usuario buscarXId(int id);
	
	Usuario buscarXSSO(String sso);
	
	void guardarUsario(Usuario usuario);
	
	void actualizarUsuario(Usuario usuario);
	
	void borrarUsuarioXSSO(String sso);

	List<Usuario> listarUsuarios(); 
	
	boolean isUserSSOUnique(Integer id, String sso);

}