package br.com.fiap.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.entity.Motorista;

public class MotoristaDAOImpl extends GenericDAOImpl<Motorista, Integer> implements MotoristaDAO {

	public MotoristaDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Motorista> ParteNomeMoto(String nome) {
	
		return em.createQuery("from Motorista m m.nome like :n",Motorista.class).setParameter("n", "%"+nome+"%")
				.setMaxResults(50)
				.setFirstResult(0)
				.getResultList();
	}

	
}
