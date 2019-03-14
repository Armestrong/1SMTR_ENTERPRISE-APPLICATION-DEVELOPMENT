package br.com.fiap.dao.generic;

import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.SeachNotFoundException;

public interface GenericDAO<T, K>{

	void cadastrar (T table);
	T pesquisar (K key) throws SeachNotFoundException;
	void atualizar (T table);
	void remover (K key) throws SeachNotFoundException;
	void commit () throws CommitException;
}
