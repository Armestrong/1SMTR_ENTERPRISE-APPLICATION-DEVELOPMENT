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

import br.com.fiap.dao.Impl.MotoristaDAOImpl;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Motorista;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.SeachNotFoundException;

class MotoristaTeste {

	

	
	private static MotoristaDAOImpl daom;
	private Motorista mm;

	



	@BeforeAll
	public static void init() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");
		EntityManager em = fabrica.createEntityManager();

		
		daom = new MotoristaDAOImpl(em);
		
	}

	
	@BeforeEach
	void beforeTest() {
		
		
		//ARRUMAR O MOTORISTA OIR CONTA DO SEQUENCE CD
		mm = new Motorista ("Arms", new GregorianCalendar(1998, Calendar.APRIL, 12), null, Genero.M);
		
		

		try {
			daom.cadastrar(mm);
			daom.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Teste falhou ..");

		}

	}

	@Test
	@DisplayName("Teste de cadastro com sucesso")
	void createTest() {

		assertNotEquals(mm.getCarteira(), 0);

	}

	@Test
	@DisplayName("Teste de pesquisa com sucesso")
	void read() {

		try {
			Motorista searchm = daom.pesquisar(mm.getCarteira());

			assertNotNull(searchm);

			assertEquals(searchm.getCarteira(), mm.getCarteira());

		} catch (SeachNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Test
	@DisplayName("Atualização realizada com sucesso")
	void update() {

		mm.setGenero(Genero.F);
		mm.setNome("Maria");

		try {

			daom.atualizar(mm);
			daom.commit();

		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste Atulizar ..");
		}

		try {
			Motorista searchm = daom.pesquisar(mm.getCarteira());

			assertEquals(Genero.F, searchm.getGenero());
			assertEquals("Maria", searchm.getNome());


		} catch (SeachNotFoundException e) {
			e.printStackTrace();
			fail("Falha no teste  pesquisa na att");
		}

	}

	@Test
	@DisplayName("Remoçao realizada com sucesso")
	void remove() {

		try {
			daom.remover(mm.getCarteira());
			daom.commit();

		} catch (SeachNotFoundException | CommitException e) {
			e.printStackTrace();
			fail("Falha no teste ..");
		}
		Motorista searchm = null;

		try {
			searchm = daom.pesquisar(mm.getCarteira());
			fail("Falha no teste");
		} catch (SeachNotFoundException e) {
			assertNull(searchm);
		}

	}

}
