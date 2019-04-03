package br.com.fiap.dao.impl;

import br.com.fiap.entity.Jogador;

import javax.persistence.EntityManager;

import br.com.fiap.dao.JogadorDAO;

public class JogadorDAOImpl 
			extends GenericDAOImpl<Jogador, Integer>
										implements JogadorDAO{

	public JogadorDAOImpl(EntityManager em) {
		super(em);
	}

}
