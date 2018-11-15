package com.webhotel.servicios;

import java.util.List;

import com.webhotel.modelos.CtaCte;

public interface CtaCteServicio {

	CtaCte buscarXId(int id);
	
	CtaCte buscarXNom(String nom);
	
	void guardarCtaCte(CtaCte ctacte);
	
	void actualizarCtaCte(CtaCte ctacte);
	
	void borrarCtaCteXid(int id);
	
	List<CtaCte> listarCtaCte();
	
}
