package br.com.fiap.dao;


import br.com.fiap.entity.Veiculo;
import br.com.fiap.execao.CommitException;
import br.com.fiap.execao.SearchNotFoundException;

public interface VeiculoDAO {

	public void cadastrarV(Veiculo veiculo);
	
	public Veiculo perquisarV(int codigo);
	
	public void atualizarV(Veiculo veiculo);
	
	public void removerV (int codigo) throws SearchNotFoundException;
	
	public void commitV () throws CommitException;
	
}
