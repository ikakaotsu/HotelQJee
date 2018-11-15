package com.webhotel.servicios;

import java.util.List;

import com.webhotel.modelos.Provincia;

public interface ProvinciaServicio {
	List<Provincia>cargarProvincia();
	List<Provincia> listarProvincias(int idpais);
}
