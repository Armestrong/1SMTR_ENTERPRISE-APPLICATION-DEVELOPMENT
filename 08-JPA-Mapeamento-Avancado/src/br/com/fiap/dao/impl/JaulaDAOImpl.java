package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.dao.JaulaDAO;
import br.com.fiap.entity.Jaula;

public class JaulaDAOImpl extends GenericDAOImpl<Jaula, Integer>
									implements JaulaDAO{

	public JaulaDAOImpl(EntityManager em) {
		super(em);
	}

}
