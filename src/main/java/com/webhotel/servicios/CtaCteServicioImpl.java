package com.webhotel.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webhotel.modelos.CtaCte;
import com.webhotel.dao.CtaCteDAO;

@Service("ctacteServicio")
@Transactional
public class CtaCteServicioImpl implements CtaCteServicio {

	@Autowired
	private CtaCteDAO dao;
	
	@Override
	public CtaCte buscarXId(int id) {
		return dao.buscarXId(id);
	}

	@Override
	public CtaCte buscarXNom(String nom) {
		return dao.buscarXNom(nom);
	}

	@Override
	public void guardarCtaCte(CtaCte ctacte) {
		dao.guardar(ctacte);

	}

	@Override
	public void actualizarCtaCte(CtaCte ctacte) {
		CtaCte entity = dao.buscarXId(ctacte.getId());
		if(entity != null){
			entity.setNombre(ctacte.getNombre());
			entity.setDomicilio(ctacte.getDomicilio());
			entity.setPais(ctacte.getPais());
			entity.setProvincia(ctacte.getProvincia());
			entity.setLocalidad(ctacte.getLocalidad());
			entity.setLocalidad2(ctacte.getLocalidad2());
			entity.setTelefono(ctacte.getTelefono());
			entity.setEmail(ctacte.getEmail());
			entity.setCuit(ctacte.getCuit());
			entity.setIva_tipo(ctacte.getIva_tipo());
		}

	}

	@Override
	public void borrarCtaCteXid(int id) {
		dao.borrarXId(id);

	}

	@Override
	public List<CtaCte> listarCtaCte() {
		return dao.listarCtaCte();
	}

}
