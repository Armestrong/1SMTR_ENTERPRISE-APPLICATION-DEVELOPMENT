package br.com.fiap.dao.Impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.entity.Motorista;
import br.com.fiap.execao.CommitException;
import br.com.fiap.execao.SearchNotFoundException;

public class MotoristaDAOImpl implements MotoristaDAO {

	EntityManager em;


	public MotoristaDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	public void cadastrarM(Motorista moto) {
		em.persist(moto);
	}

	public Motorista consultarM(int codigo) {
		return em.find(Motorista.class, codigo);
	}

	public void atualizarM(Motorista moto) {
		em.merge(moto);
	}

	public void removerM(int codigo) throws SearchNotFoundException {
		Motorista moto = consultarM(codigo);
		if (moto == null)
			throw new SearchNotFoundException();
		em.remove(moto);
	}

	public void commitM() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			
			throw new CommitException();
		}

	}
}
