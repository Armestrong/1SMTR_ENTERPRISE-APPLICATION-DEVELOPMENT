package br.com.fiap.dao.impl;

import br.com.fiap.entity.Campeonato;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CampeonatoDAO;

public class CampeonatoDAOImpl extends GenericDAOImpl<Campeonato, Integer> implements CampeonatoDAO{

	public CampeonatoDAOImpl(EntityManager em) {
		super(em);
	}

}
