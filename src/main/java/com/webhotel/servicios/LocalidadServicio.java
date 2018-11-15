package com.webhotel.servicios;

import java.util.List;

import com.webhotel.modelos.Localidad;

public interface LocalidadServicio {
	List<Localidad>cargarLocalidad();
	List<Localidad> listarLocalidad(int idprovincia);
}
