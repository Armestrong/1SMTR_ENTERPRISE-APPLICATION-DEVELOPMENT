package br.com.fiap.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.entity.Veiculo;

public class VeiculoDAOImpl extends GenericDAOImpl<Veiculo, Integer> implements VeiculoDAO {

	public VeiculoDAOImpl(EntityManager em) {
		super(em);
		
	}

	@Override
	public List<Veiculo> veiculoValorMinimoDoAno(int ano) {
		
		return em.createQuery(" from Veiculo v where v.ano <= :a .",Veiculo.class)
				.setParameter("a",ano)
				.getResultList();
	}

	
	
	
}
