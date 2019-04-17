package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.CorridaDAO;
import br.com.fiap.dao.Impl.CorridaDAOimpl;
import br.com.fiap.entity.Corrida;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.SeachNotFoundException;

class CorridaTeste {

	private static CorridaDAO daoc;
	private Corrida c;

	

	@BeforeAll
	public static void init() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");
		EntityManager em = fabrica.createEntityManager();

		daoc = new CorridaDAOimpl(em);

	}

	@BeforeEach
	void beforeTest() {
		c = new Corrida("MIX", "FIX", new GregorianCalendar(1991, Calendar.AUGUST, 1), (float) 19.98);
		

		try {
			daoc.cadastrar(c);
			daoc.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Teste falhou ..");

		}

	}

	@Test
	@DisplayName("Teste de cadastro com sucesso")
	void createTest() {

		assertNotEquals(c.getCorrida(), 0);

	}

	@Test
	@DisplayName("Teste de pesquisa com sucesso")
	void read() {

		try {
			Corrida searchc = daoc.pesquisar(c.getCorrida());

			assertNotNull(searchc);

			assertEquals(searchc.getCorrida(), c.getCorrida());

		} catch (SeachNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Test
	@DisplayName("Atualização realizada com sucesso")
	void update() {

		c.setOrigem("GUI Teste");
		c.setDestino("VIX Teste");

		try {

			daoc.atualizar(c);
			daoc.commit();

		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste Atulizar ..");
		}

		try {
			Corrida searchc = daoc.pesquisar(c.getCorrida());

			assertEquals("GUI Teste", searchc.getOrigem());
			assertEquals("VIX Teste", searchc.getDestino());


		} catch (SeachNotFoundException e) {
			e.printStackTrace();
			fail("Falha no teste  pesquisa na att");
		}

	}

	@Test
	@DisplayName("Remoçao realizada com sucesso")
	void remove() {

		try {
			daoc.remover(c.getCorrida());
			daoc.commit();

		} catch (SeachNotFoundException | CommitException e) {
			e.printStackTrace();
			fail("Falha no teste ..");
		}
		Corrida searchc = null;

		try {
			searchc = daoc.pesquisar(c.getCorrida());
			fail("Falha no teste");
		} catch (SeachNotFoundException e) {
			assertNull(searchc);
		}

	}

}
