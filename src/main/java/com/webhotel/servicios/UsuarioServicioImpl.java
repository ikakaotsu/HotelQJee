package com.webhotel.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webhotel.dao.UsuarioDao;
import com.webhotel.modelos.Usuario;


@Service("usuarioServicio")
@Transactional
public class UsuarioServicioImpl implements UsuarioServicio{

	@Autowired
	private UsuarioDao dao;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public Usuario buscarXId(int id) {
		return dao.buscarXId(id);
	}

	public Usuario buscarXSSO(String sso) {
		Usuario usuario = dao.buscarXSSO(sso);
		return usuario;
	}

	public void guardarUsario(Usuario usuario) {
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		dao.guardar(usuario);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void actualizarUsuario(Usuario usuario) {
		Usuario entity = dao.buscarXId(usuario.getId());
		if(entity!=null){
			entity.setSsoId(usuario.getSsoId());
			if(!usuario.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(usuario.getPassword()));
			}
			entity.setNombre(usuario.getNombre());
			entity.setApellido(usuario.getApellido());
			entity.setDomicilio(usuario.getDomicilio());
			entity.setPais(usuario.getPais());
			entity.setProvincia(usuario.getProvincia());
			entity.setLocalidad(usuario.getLocalidad());
			entity.setTelefono(usuario.getTelefono());
			entity.setEmail(usuario.getEmail());
			entity.setCuil(usuario.getCuil());
			entity.setCategoria(usuario.getCategoria());
			entity.setProfesion(usuario.getProfesion());
			entity.setUsuarioPerfil(usuario.getUsuarioPerfil());
		}
	}

	
	public void borrarUsuarioXSSO(String sso) {
		dao.borrarXSSO(sso);
	}

	public List<Usuario> listarUsuarios() {
		return dao.listarUsuarios();
	}

	public boolean isUserSSOUnique(Integer id, String sso) {
		Usuario usuario = buscarXSSO(sso);
		return ( usuario == null || ((id != null) && (usuario.getId() == id)));
	}
	
}
