package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{

	List<Cliente> lista() ;
	
	List<Cliente> listaPNome(String nome);
	
	List<Cliente> listaPorEstado(String estado);
	
	List<Cliente> ClientesDaReserva(int qtdReeserva);
	
	List<Cliente> busccarPorPartNomeECid(String nome,String cidade);
	
	List<Cliente>buscarPorEstados(List<String> estados);
}
