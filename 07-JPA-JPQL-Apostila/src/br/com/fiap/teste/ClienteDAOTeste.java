package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;

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
private static EnderecoDAO daod;
private static CidadeDAO daoc;
private static PacoteDAO daop;

	
	@BeforeAll
	public static void intanc() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new ClienteDAOImpl(em);
		daod = new EnderecoDAOImpl(em);
		daop = new PacoteDAOImpl(em);
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
		for (Cliente cliente : lista) {
			assertNotEquals(0, lista.size());
		}

	}
	
	
	@Test
	void listEstado() {
		// NAO PRECISA DO FOR 
		// LEMBARAR Q NULLPOINTEXCEPTION PODE SER O Dao do GetIntance 
		List<Cliente> lista = dao.listaPorEstado("SP");
		
		for (Cliente cliente : lista) {
			assertEquals(1, lista.size());
		}
		
	}
	
	
	@Test
	void obterQtdDias() {
		
		
		List<Cliente> lista = dao.ClientesDaReserva(10);
		assertNotEquals(0, lista.size());
	}
	
}
