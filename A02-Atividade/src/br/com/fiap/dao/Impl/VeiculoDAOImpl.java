package br.com.fiap.dao.Impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.entity.Veiculo;

public class VeiculoDAOImpl extends GenericDAOImpl<Veiculo, Integer> implements VeiculoDAO {

	public VeiculoDAOImpl(EntityManager em) {
		super(em);
		
	}

	
}
