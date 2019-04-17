package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.Impl.MotoristaDAOImpl;
import br.com.fiap.entity.Motorista;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class MotoristaTeste {
	
	
	private static MotoristaDAOImpl dao;

	@BeforeAll
	static void iniciar() {
		EntityManager em = EntityManagerFactorySingleton.getIntance().createEntityManager();
		dao = new MotoristaDAOImpl(em);
	}
	
	@Test
	void buscarPnome() {
		List<Motorista> lista = new ArrayList<>();
		dao.ParteNomeMoto("a");
		assertNotEquals(0, lista.size());
		
		for (Motorista motorista : lista) {
			assertTrue(motorista.getNome().contains("a"));
		}
	}

}
