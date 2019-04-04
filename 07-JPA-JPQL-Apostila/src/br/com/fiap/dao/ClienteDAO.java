package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{

	List<Cliente> lista() ;
	
	List<Cliente> listaPNome(String nome);
	
	List<Cliente> listaPorEstado(String estado);
	
	List<Cliente> ClientesDaReserva(int qtdReeserva);
}
