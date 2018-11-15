package com.webhotel.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webhotel.dao.ProvinciaDAO;
import com.webhotel.modelos.Provincia;

@Service("provinciaServicio")
@Transactional
public class ProvinciaServicioImpl implements ProvinciaServicio{
	@Autowired
	private ProvinciaDAO dao;
	
	public List<Provincia>cargarProvincia(){
		return dao.cargarProvincia();
	}
	public List<Provincia> listarProvincias(int idpais){
		return dao.listarProvincias(idpais);
	}
}
