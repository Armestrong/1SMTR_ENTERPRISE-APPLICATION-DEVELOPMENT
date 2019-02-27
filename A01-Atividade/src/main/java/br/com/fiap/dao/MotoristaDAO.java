package br.com.fiap.dao;



import br.com.fiap.entity.Motorista;
import br.com.fiap.execao.CommitException;
import br.com.fiap.execao.SearchNotFoundException;

public interface MotoristaDAO {
	
	 void cadastrarM(Motorista moto);

	 Motorista consultarM(int codigo);

	 void atualizarM(Motorista moto);

	 void removerM(int codigo) throws SearchNotFoundException;

	 void commitM() throws CommitException;
	
}
