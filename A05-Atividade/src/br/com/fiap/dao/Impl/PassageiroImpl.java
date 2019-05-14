package br.com.fiap.dao.Impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PassageiroDAO;
import br.com.fiap.entity.Passageiro;

public class PassageiroImpl extends GenericDAOImpl<Passageiro, Integer> implements PassageiroDAO {

	public PassageiroImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
