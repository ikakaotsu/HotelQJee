package com.webhotel.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webhotel.dao.UsuarioPerfilDao;
import com.webhotel.modelos.UsuarioPerfil;


@Service("userProfileService")
@Transactional
public class UsuarioPerfilServicioImpl implements UsuarioPerfilServicio{
	
	@Autowired
	UsuarioPerfilDao dao;
	
	public UsuarioPerfil buscarXId(int id) {
		return dao.buscarXId(id);
	}

	public UsuarioPerfil buscarXType(String type){
		return dao.buscarXTipo(type);
	}

	public List<UsuarioPerfil> listar() {
		return dao.listar();
	}
}
