package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> lista() {
		TypedQuery<Cliente> query = em.createQuery("from Cliente", Cliente.class);
		return query.getResultList();
		/*return em.createQuery("from Cliente", Cliente.class)
				.getResultList();*/
	}

	@Override
	public List<Cliente> listaPNome(String nome) {
		/*TypedQuery<Cliente> query = em.createQuery("from Cliente c where c.nome like :churros",Cliente.class);
		query.setParameter("churros","%"+nome+"%");
		return query.getResultList();*/
		return em.createQuery("from Cliente c where c.nome like :churros",Cliente.class)
				.setParameter("churros","%"+nome+"%")
				.getResultList();
				
	}

	@Override
	public List<Cliente> listaPorEstado(String estado) {
		// Realizando um get no UF(ID) Da Classe cidade passando pela classe endereco, e obtendo o id da classe podedendo obter qualquer atributo da mesma
		/*TypedQuery<Cliente> query = em.createQuery("from Cliente c where c.endereco.cidade.uf =:e",Cliente.class);
		query.setParameter("e",estado);
		return query.getResultList();*/
		return em.createQuery("from Cliente c where c.endereco.cidade.uf =:e",Cliente.class)
				.setParameter("e",estado)
				.getResultList();
	}

	@Override
	public List<Cliente> ClientesDaReserva(int qtdReeserva) {
		/*TypedQuery<Cliente> query = em.createQuery("select r.cliente from Reserva r where r.numeroDias =:f",Cliente.class);
 		query.setParameter("f", qtdReeserva);
		return  query.getResultList();*/
		return em.createQuery("select r.cliente from Reserva r where r.numeroDias = :f",Cliente.class)
				.setParameter("f", qtdReeserva)
				.getResultList();
	}
	
	
	

}
