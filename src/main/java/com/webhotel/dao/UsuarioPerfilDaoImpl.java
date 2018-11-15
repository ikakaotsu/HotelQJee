package com.webhotel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.webhotel.modelos.UsuarioPerfil;



@Repository("usuarioPerfilDao")
public class UsuarioPerfilDaoImpl extends AbstractDao<Integer, UsuarioPerfil>implements UsuarioPerfilDao{

	public UsuarioPerfil buscarXId(int id) {
		return getByKey(id);
	}

	public UsuarioPerfil buscarXTipo(String type) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("type", type));
		return (UsuarioPerfil) crit.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<UsuarioPerfil> listar(){
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("type"));
		return (List<UsuarioPerfil>)crit.list();
	}
	
}
