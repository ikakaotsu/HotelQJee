package com.webhotel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.webhotel.modelos.Usuario;



@Repository("userDao")
public class UsuarioDaoImpl extends AbstractDao<Integer, Usuario> implements UsuarioDao {

	static final Logger logger = LoggerFactory.getLogger(UsuarioDaoImpl.class);
	
	public Usuario buscarXId(int id) {
		Usuario usuario = getByKey(id);
		if(usuario!=null){
			Hibernate.initialize(usuario.getUsuarioPerfil());
		}
		return usuario;
	}

	public Usuario buscarXSSO(String sso) {
		logger.info("SSO : {}", sso);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		Usuario usuario = (Usuario)crit.uniqueResult();
		if(usuario!=null){
			Hibernate.initialize(usuario.getUsuarioPerfil());
		}
		return usuario;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarios() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("nombre"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Usuario> users = (List<Usuario>) criteria.list();
		
		// No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of userProfiles if you want.
		/*
		for(User user : users){
			Hibernate.initialize(user.getUserProfiles());
		}*/
		return users;
	}

	public void guardar(Usuario usuario) {
		persist(usuario);
	}

	public void borrarXSSO(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		Usuario usuario = (Usuario)crit.uniqueResult();
		delete(usuario);
	}

}
