package br.com.fiap.dao.Impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CorridaDAO;
import br.com.fiap.entity.Corrida;

public class CorridaDAOimpl extends GenericDAOImpl<Corrida, Integer> implements CorridaDAO  {

	public CorridaDAOimpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Corrida> BuscarCorridaProData(Calendar ini, Calendar fim) {
		return em.createQuery("from ",Corrida.class)
				.setParameter("", ini)
				.setParameter("", fim)
				.setMaxResults(30)
				.setFirstResult(0)
				.getResultList();
	}

	
	

}
