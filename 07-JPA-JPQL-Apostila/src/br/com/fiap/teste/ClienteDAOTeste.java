package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;

class ClienteDAOTeste {
	private static ClienteDAO dao;
	
	@BeforeAll
	public static void intanc() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new ClienteDAOImpl(em);
	}
	
	@Test
	void listaAll() {
		List<Cliente> lista  = dao.lista();
		assertNotEquals(0, lista.size());
	}
	
	@Test
	void listNomeAll() {
		List<Cliente> lista = dao.listaPNome("T");
		assertEquals("T", lista.size());
	}

}
