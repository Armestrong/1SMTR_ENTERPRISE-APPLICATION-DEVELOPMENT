package br.com.fiap.teste;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.text.html.HTMLDocument.HTMLReader.FormAction;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.EnderecoDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.Pacote;

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
	void listPornome() {
		// NAO PRECISA DO FOR 
				// LEMBARAR Q NULLPOINTEXCEPTION PODE SER O Dao do GetIntance 
		List<Cliente> lista = dao.listaPNome("a");
		assertNotEquals(0, lista.size());
		
		//Validar se os clientes retornados estao corretos 
		for (Cliente cliente : lista) {
			assertTrue(cliente.getNome().contains("a"));
		}

	}
	
	
	@Test
	void listEstado() {
		// NAO PRECISA DO FOR 
		// LEMBARAR Q NULLPOINTEXCEPTION PODE SER O Dao do GetIntance 
		List<Cliente> lista = dao.listaPorEstado("BA");
		assertNotEquals(0, lista.size());
		
		//Validar se o estado "BA" é verdade
		for (Cliente cliente : lista) {
			assertEquals("BA", cliente.getEndereco().getCidade().getUf());
			// ou 
			assertTrue(cliente.getEndereco().getCidade().getUf().contains("BA"));
		}
		
	}
	
	
	@Test
	void obterQtdDias() {	
		List<Cliente> lista = dao.ClientesDaReserva(10);
		assertNotEquals(0, lista.size());
		
		for (Cliente cliente : lista) {
			
		}
		
	}
	
	
}
