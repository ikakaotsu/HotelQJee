package com.webhotel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.webhotel.modelos.Localidad;

@Repository("localidadDao")
public class LocalidadDaoImpl extends AbstractDao<Integer, Localidad> implements LocalidadDAO {

	@SuppressWarnings("unchecked")
	public List<Localidad> cargarLocalidad() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("nombre"));
		return (List<Localidad>)crit.list();
	}
	@SuppressWarnings("unchecked")
	public List<Localidad> listarLocalidad(int idprovincia) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("provincia_id", idprovincia));
		return (List<Localidad>)crit.list();
	}
}
