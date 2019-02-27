package br.com.fiap.dao.Impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.entity.Veiculo;
import br.com.fiap.execao.CommitException;
import br.com.fiap.execao.SearchNotFoundException;

public class VeiculoDAOImpl implements VeiculoDAO {
	
	private EntityManager em;

	public VeiculoDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	public void cadastrarV(Veiculo veiculo) {
		em.persist(veiculo);
	}
	
	public Veiculo perquisarV(int codigo){
		return em.find(Veiculo.class, codigo);
	}
	
	public void atualizarV(Veiculo veiculo) {
		em.merge(veiculo);
	}
	
	public void removerV (int codigo) throws SearchNotFoundException {
		Veiculo veiculo = perquisarV(codigo);
		if (veiculo == null)
			throw new SearchNotFoundException();
			em.remove(veiculo);
	}
	
	public void commitV () throws CommitException{
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
