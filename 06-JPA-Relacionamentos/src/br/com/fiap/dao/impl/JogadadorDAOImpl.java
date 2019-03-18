package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.JogadorDAO;
import br.com.fiap.entity.Jogador;

public class JogadadorDAOImpl extends  GenericDAOImpl<Jogador, Integer> implements JogadorDAO {

	public JogadadorDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
