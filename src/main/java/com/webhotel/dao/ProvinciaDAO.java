package com.webhotel.dao;

import java.util.List;
import com.webhotel.modelos.Provincia;

public interface ProvinciaDAO {
	List<Provincia>cargarProvincia();
	List<Provincia>listarProvincias(int idpais);
}
