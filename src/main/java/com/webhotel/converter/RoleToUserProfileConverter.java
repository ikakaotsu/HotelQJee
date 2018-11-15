package com.webhotel.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.webhotel.modelos.UsuarioPerfil;
import com.webhotel.servicios.UsuarioPerfilServicio;

/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class RoleToUserProfileConverter implements Converter<Object, UsuarioPerfil>{

	static final Logger logger = LoggerFactory.getLogger(RoleToUserProfileConverter.class);
	
	@Autowired
	UsuarioPerfilServicio usuarioPerfilServicio;

	/**
	 * Gets UserProfile by Id
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	public UsuarioPerfil convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		UsuarioPerfil perfil= usuarioPerfilServicio.buscarXId(id);
		logger.info("Perfil : {}",perfil);
		return perfil;
	}
	
}