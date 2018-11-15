package com.webhotel.dao;

import java.util.List;
import com.webhotel.modelos.Localidad;

public interface LocalidadDAO {
	List<Localidad>cargarLocalidad();
	List<Localidad>listarLocalidad(int idprovincia);

}
