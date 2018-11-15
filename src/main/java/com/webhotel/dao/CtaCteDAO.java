package com.webhotel.dao;

import java.util.List;

import com.webhotel.modelos.CtaCte;

public interface CtaCteDAO {
	
	CtaCte buscarXId(int id);
	
	CtaCte buscarXNom(String nom);
	
	void guardar(CtaCte ctacte);
	
	void borrarXId(int id);
	
	List<CtaCte>listarCtaCte();

}
