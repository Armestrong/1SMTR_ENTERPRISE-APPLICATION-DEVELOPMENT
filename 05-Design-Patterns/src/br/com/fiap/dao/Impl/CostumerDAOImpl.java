package br.com.fiap.dao.Impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CostumerDAO;
import br.com.fiap.entity.Costumer;

public class CostumerDAOImpl extends GenericDAOImpl<Costumer, Integer> implements CostumerDAO {

	public CostumerDAOImpl(EntityManager em) {
		super(em);
		
	}



}
