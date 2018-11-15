package com.webhotel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.webhotel.modelos.Cliente;

@Repository("clienteDao")
public class ClienteDaoImpl extends AbstractDao<Integer, Cliente> implements ClienteDAO {
	
	public Cliente buscarXId(int id){
		return getByKey(id);
	}

	@Override
	public Cliente buscarXAyN(String ayn) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("apellido", ayn));
		Cliente cliente = (Cliente)crit.uniqueResult();
		return cliente;
	}

	@Override
	public void guardar(Cliente cliente) {
		persist(cliente);
		
	}

	@Override
	public void borrarXId(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Cliente cliente = (Cliente)crit.uniqueResult();
		delete(cliente);
		
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listarClientes() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("apellido"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Cliente> clientes = (List<Cliente>) criteria.list();
		return clientes;
	}
	

	
}
