package com.webhotel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.webhotel.modelos.CtaCte;

@Repository("ctacteDao")
public class CtaCteDaoImpl extends AbstractDao<Integer, CtaCte> implements CtaCteDAO {

	@Override
	public CtaCte buscarXId(int id) {
		return getByKey(id);
	}

	@Override
	public CtaCte buscarXNom(String nom) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("nombre", nom));
		CtaCte ctacte = (CtaCte)crit.uniqueResult();
		return ctacte;
	}

	@Override
	public void guardar(CtaCte ctacte) {
		persist(ctacte);

	}

	@Override
	public void borrarXId(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		CtaCte ctacte = (CtaCte)crit.uniqueResult();
		delete(ctacte);
	}

	@SuppressWarnings("unchecked")
	public List<CtaCte> listarCtaCte() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("nombre"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<CtaCte> ctacte = (List<CtaCte>)criteria.list();
		return ctacte;
	}

}
