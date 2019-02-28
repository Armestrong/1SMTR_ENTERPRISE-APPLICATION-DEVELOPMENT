package br.com.fiap.dao;

import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.SeachNotFoundException;

public interface GenericDAO<T, K> {

	void create(T table);

	T read(K key) throws SeachNotFoundException;

	void update(T table);

	void delete(K key) throws SeachNotFoundException;

	void commit() throws CommitException;
}
