package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.dao.Impl.VeiculoDAOImpl;
import br.com.fiap.entity.Cor;
import br.com.fiap.entity.Veiculo;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.SeachNotFoundException;

class VeiculoTeste {

	private static VeiculoDAO daov;
	private Veiculo vei;

	@BeforeAll
	public static void init() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");
		EntityManager em = fabrica.createEntityManager();

		daov = new VeiculoDAOImpl(em);

	}

	@BeforeEach
	void beforeTest() {

		vei = new Veiculo("SWWA11", Cor.PRETO, 1997);

		// ARRUMAR O MOTORISTA OIR CONTA DO SEQUENCE CD

		try {

			daov.cadastrar(vei);
			daov.commit();

		} catch (CommitException e) {
			e.printStackTrace();
			fail("Teste falhou ..");

		}

	}

	@Test
	@DisplayName("Teste de cadastro com sucesso")
	void createTest() {

		assertNotEquals(vei.getCodigo(), 0);

	}

	@Test
	@DisplayName("Teste de pesquisa com sucesso")
	void read() {

		try {

			Veiculo searchv = daov.pesquisar(vei.getCodigo());

			assertNotNull(searchv);

			assertEquals(searchv.getCodigo(), vei.getCodigo());

		} catch (SeachNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Test
	@DisplayName("Atualização realizada com sucesso")
	void update() {

		vei.setCor(Cor.MARROM);
		vei.setPlaca("007BR");

		try {

			daov.atualizar(vei);
			daov.commit();

		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste Atulizar ..");
		}

		try {

			Veiculo searchv = daov.pesquisar(vei.getCodigo());

			assertEquals(Cor.MARROM, searchv.getCor());
			assertEquals("007BR", searchv.getPlaca());

		} catch (SeachNotFoundException e) {
			e.printStackTrace();
			fail("Falha no teste  pesquisa na att");
		}

	}

	@Test
	@DisplayName("Remoçao realizada com sucesso")
	void remove() {

		try {

			daov.remover(vei.getCodigo());
			daov.commit();

		} catch (SeachNotFoundException | CommitException e) {
			e.printStackTrace();
			fail("Falha no teste ..");
		}

		Veiculo searchv = null;

		try {

			searchv = daov.pesquisar(vei.getCodigo());

			fail("Falha no teste");
		} catch (SeachNotFoundException e) {

			assertNull(searchv);

		}

	}

}
