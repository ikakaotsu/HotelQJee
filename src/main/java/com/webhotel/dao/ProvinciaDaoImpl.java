package com.webhotel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.webhotel.modelos.Provincia;

@Repository("provinciaDao")
public class ProvinciaDaoImpl extends AbstractDao<Integer, Provincia> implements ProvinciaDAO {
	
	@SuppressWarnings("unchecked")
	public List<Provincia> cargarProvincia(){
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("nombre"));
		return (List<Provincia>)crit.list();
	}
	@SuppressWarnings("unchecked")
	public List<Provincia> listarProvincias(int idpais) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("pais.id", idpais));
		return (List<Provincia>)crit.list();
	}
}
