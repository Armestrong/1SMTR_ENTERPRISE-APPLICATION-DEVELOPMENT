package br.com.fiap.dao;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotKnowFoundException;

public interface GenericDAO<T, K> {
	
	void create(T entity) ;
	T read(K id) throws IdNotKnowFoundException;
	void update(T entity);
	void delete(K id) throws IdNotKnowFoundException;
	void commit () throws CommitException;

}
