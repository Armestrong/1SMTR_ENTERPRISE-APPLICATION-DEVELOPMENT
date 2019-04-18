package br.com.fiap.dao.Impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PagamentoDAO;
import br.com.fiap.entity.Pagamento;

public  class PagamentoImpl extends GenericDAOImpl<Pagamento, Integer> implements PagamentoDAO{

	public PagamentoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double AllPagamentos(int codPasg) {
		return em.createQuery("select sum(p.valorPagamento) from Pagamento p where p.corrida.passageiro.passageiro = :p",double.class)
				.setParameter("p", codPasg)
				.getSingleResult();
	}
	
	


}
