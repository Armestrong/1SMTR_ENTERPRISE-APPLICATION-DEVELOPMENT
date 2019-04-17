package br.com.fiap.dao.Impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.generic.GenericDAO;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.SeachNotFoundException;

public abstract class GenericDAOImpl<T, K> implements GenericDAO<T, K>{

	EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		super();
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		
	}

	public void cadastrar(T table) {
		em.persist(table);
		
	}

	public T pesquisar(K key) throws SeachNotFoundException {
		T entity = em.find(clazz, key);
		if(entity == null){
			throw new SeachNotFoundException();
		}
		return entity;
	}

	public void atualizar(T table) {
		em.merge(table);
		
	}

	public void remover(K key) throws SeachNotFoundException {
		T table = pesquisar(key);
		em.remove(table);
		
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException();
		}
		
	}

}
