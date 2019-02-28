package br.com.fiap.dao.Impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.SeachNotFoundException;

public  abstract class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	EntityManager em;

	private Class<T> clazz;

	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		super();
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
				;
	}

	@Override
	public void create(T table) {
		em.persist(table);

	}

	@Override
	public T read(K key) throws SeachNotFoundException {

		T table = em.find(clazz, key);
		if (table == null) {
			throw new SeachNotFoundException();
		}
		return table;
	}

	@Override
	public void update(T table) {
		em.merge(table);
	}

	@Override
	public void delete(K key) throws SeachNotFoundException {
		T table = read(key);
		em.remove(table);
	}

	@Override
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
