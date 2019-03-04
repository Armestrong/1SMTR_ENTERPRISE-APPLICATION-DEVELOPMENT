package br.com.fiap.dao.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.dao.Impl.PagamentoImpl;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TesteCadastro {

	public static <T, K> void main(String[] args) {
		
		EntityManagerFactory emf = EntityManagerFactorySingleton.getIntance();
		EntityManager em = emf.createEntityManager();
		
		GenericDAO<T, K> dao = new PagamentoImpl<T, K>(em){
			
		};
	}

}
