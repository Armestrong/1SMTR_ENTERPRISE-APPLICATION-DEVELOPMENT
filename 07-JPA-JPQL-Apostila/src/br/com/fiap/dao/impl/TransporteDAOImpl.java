package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class TransporteDAOImpl extends GenericDAOImpl<Transporte, Integer> implements TransporteDAO {

	public TransporteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}


}
