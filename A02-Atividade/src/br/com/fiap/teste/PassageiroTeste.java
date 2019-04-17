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

import br.com.fiap.dao.PassageiroDAO;
import br.com.fiap.dao.Impl.PassageiroImpl;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Passageiro;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.SeachNotFoundException;

class PassageiroTeste {


	private static PassageiroDAO daopp;
	private Passageiro pp;

	@BeforeAll
	public static void init() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");
		EntityManager em = fabrica.createEntityManager();

		daopp = new PassageiroImpl(em);

	}

	@BeforeEach
	void beforeTest() {
		
		pp = new Passageiro("Berna", new GregorianCalendar(1999, Calendar.APRIL, 15), Genero.M);

		try {
			daopp.cadastrar(pp);
			daopp.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Teste falhou ..");

		}

	}

	@Test
	@DisplayName("Teste de cadastro com sucesso")
	void createTest() {

		assertNotEquals(pp.getPassageiro(), 0);

	}

	@Test
	@DisplayName("Teste de pesquisa com sucesso")
	void read() {

		try {
			Passageiro searchpp = daopp.pesquisar(pp.getPassageiro());

			assertNotNull(searchpp);

			assertEquals(searchpp.getPassageiro(), pp.getPassageiro());

		} catch (SeachNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Test
	@DisplayName("Atualização realizada com sucesso")
	void update() {

		pp.setGenero(Genero.M);
		pp.setNomePassageiro("DANIEL");

		try {

			daopp.atualizar(pp);
			daopp.commit();

		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste Atulizar ..");
		}

		try {
			Passageiro searchpp = daopp.pesquisar(pp.getPassageiro());

			assertEquals(Genero.M, searchpp.getGenero());
			assertEquals("DANIEL", searchpp.getNomePassageiro());

		} catch (SeachNotFoundException e) {
			e.printStackTrace();
			fail("Falha no teste  pesquisa na att");
		}

	}

	@Test
	@DisplayName("Remoçao realizada com sucesso")
	void remove() {

		try {
			daopp.remover(pp.getPassageiro());
			daopp.commit();

		} catch (SeachNotFoundException | CommitException e) {
			e.printStackTrace();
			fail("Falha no teste ..");
		}
		Passageiro searchpp = null;

		try {
			searchpp = daopp.pesquisar(pp.getPassageiro());
			fail("Falha no teste");
		} catch (SeachNotFoundException e) {
			assertNull(searchpp);
		}

	}

}