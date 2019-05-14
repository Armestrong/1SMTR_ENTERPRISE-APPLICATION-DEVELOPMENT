package br.com.fiap.dao.Impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CorridaDAO;
import br.com.fiap.entity.Corrida;
import br.com.fiap.entity.Motorista;
import br.com.fiap.entity.Passageiro;

public class CorridaDAOimpl extends GenericDAOImpl<Corrida, Integer> implements CorridaDAO  {

	public CorridaDAOimpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Corrida> BuscarCorridaProData(Calendar ini, Calendar fim) {
		return em.createQuery("from Corrida c where c.dataCorrida between :i and :f ",Corrida.class)
				.setParameter("", ini)
				.setParameter("", fim)
				.setMaxResults(30)
				.setFirstResult(0)
				.getResultList();
	}

	@Override
	public List<Corrida> todasAsCorridas(Motorista motorista) {
		return em.createQuery("from Corrida c where c.motorista.carteira = :m",Corrida.class)
				.setParameter("m", motorista)
				.getResultList();
	}

	@Override
	public long qtdCorridasPassageiro(int codpasg) {
		return em.createQuery("select count(c) from Corrida c where c.passageiro.passageiro = :c",long.class)
				.setParameter("c", codpasg)
				.getSingleResult();
	}

	@Override
	public List<Corrida> BuscarAllCorriByPartNome(String nome) {
		return em.createQuery("from Corrida c where c.passageiro.nome like :n",Corrida.class)
				.setParameter("n","%"+nome+"%")
				.setMaxResults(40)
				.getResultList();
	}

	@Override
	public long qtdCorridasDeMotoByData(int codigoMoto, Calendar ini, Calendar fim) {
		// TODO Auto-generated method stub
		return em.createQuery("select count(c) from Corrida c where c.motorista.carteira = :c and c.dataCorrida between :i and :f",long.class)
				.setParameter("c", codigoMoto)
				.setParameter("i", ini)
				.setParameter("f", fim)
				.getSingleResult();
	}

	@Override
	public List<Corrida> max10ValorDeCorrida(int codPassag) {
		return em.createQuery("from Corrida c where c.passageiro.passageiro = :cc order by c.valorCorrida desc",Corrida.class)
				.setParameter("cc", codPassag)
				.setMaxResults(10)
				.getResultList();
	}

	@Override
	public List<Corrida> CorridasRealizadasByPassaEoMoto(int CodPassa, int CodMoto) {
		return em.createQuery("from Corrida c where c.passageiro.passageiro = :p and c.motorista.carteita = :m",Corrida.class)
				.setParameter("p", CodPassa)
				.setParameter("m", CodMoto)
				.getResultList();
	}

	

	
	

}
