package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ManutencaoDAO;
import br.com.fiap.entity.Manutencao;
import br.com.fiap.entity.ManutencaoPK;

public class ManutencaoDAOImpl 
				extends GenericDAOImpl<Manutencao, ManutencaoPK>
												implements ManutencaoDAO{

	public ManutencaoDAOImpl(EntityManager em) {
		super(em);
	}

}