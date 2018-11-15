package com.webhotel.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webhotel.dao.PaisDAO;
import com.webhotel.modelos.Pais;

@Service("paisServicio")
@Transactional
public class PaisServicioImpl implements PaisServicio {

	@Autowired
	private PaisDAO dao;
	
	public List<Pais> listarPaises() {
		return dao.listarPaises();
	}
	
	
}
