package br.com.fiap.dao;

import javax.naming.CommunicationException;

import br.com.fiap.entity.Imovel;

public interface ImovelDAO  {
		
	void cadastrar(Imovel imovel);
	
	Imovel consultar(int codigo);
	
	void atualizar(Imovel imovel);
	
	void remover(int codigo);
	
	void commit() throws CommunicationException;
}
