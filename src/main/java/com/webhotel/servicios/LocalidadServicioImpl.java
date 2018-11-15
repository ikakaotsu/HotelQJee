package com.webhotel.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webhotel.dao.LocalidadDAO;
import com.webhotel.modelos.Localidad;

@Service("localidadServicio")
@Transactional
public class LocalidadServicioImpl implements LocalidadServicio{
	@Autowired
	private LocalidadDAO dao;

	public List<Localidad> cargarLocalidad() {
		return dao.cargarLocalidad();
	}
		
	public List<Localidad> listarLocalidad(int idprovincia) {
		return dao.listarLocalidad(idprovincia);
	}
}
