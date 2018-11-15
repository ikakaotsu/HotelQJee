package com.webhotel.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.webhotel.modelos.Pais;

@Repository("paisDao")
public class PaisDaoImpl extends AbstractDao<Integer, Pais>implements PaisDAO {

	@SuppressWarnings("unchecked")
	public List<Pais> listarPaises() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("nombre"));
		return (List<Pais>)crit.list();
	}
	
}
