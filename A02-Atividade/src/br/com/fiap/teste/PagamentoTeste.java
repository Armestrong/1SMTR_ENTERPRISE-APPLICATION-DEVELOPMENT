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

import br.com.fiap.dao.PagamentoDAO;
import br.com.fiap.dao.Impl.PagamentoImpl;
import br.com.fiap.entity.FormaPagamento;
import br.com.fiap.entity.Pagamento;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.SeachNotFoundException;

class PagamentoTeste {


	private static PagamentoDAO daop;
	private Pagamento p;


	@BeforeAll
	public static void init() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");
		EntityManager em = fabrica.createEntityManager();

		daop = new PagamentoImpl(em);

	}

	@BeforeEach
	void beforeTest() {
		
		
		//ARRUMAR O MOTORISTA OIR CONTA DO SEQUENCE CD
		
		p = new Pagamento(new GregorianCalendar(1699, Calendar.APRIL, 15), (float) 5.50, FormaPagamento.DEBITO);
		

		try {
			daop.cadastrar(p);
			daop.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Teste falhou ..");

		}

	}

	@Test
	@DisplayName("Teste de cadastro com sucesso")
	void createTest() {

		assertNotEquals(p.getPagamento(), 0);

	}

	@Test
	@DisplayName("Teste de pesquisa com sucesso")
	void read() {

		try {
			Pagamento searchp = daop.pesquisar(p.getPagamento());

			assertNotNull(searchp);
			assertEquals(searchp.getPagamento(), p.getPagamento());

		} catch (SeachNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Test
	@DisplayName("Atualização realizada com sucesso")
	void update() {

		p.setValorPagamento((float) 50.00);
		p.setFormaPagamento(FormaPagamento.DINHEIRO);

		try {

			daop.atualizar(p);
			daop.commit();

		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste Atulizar ..");
		}

		try {
			Pagamento searchp = daop.pesquisar(p.getPagamento());
			assertEquals (Float.valueOf((float) 50.00), searchp.getValorPagamento());
			assertEquals(FormaPagamento.DINHEIRO, searchp.getFormaPagamento());

		} catch (SeachNotFoundException e) {
			e.printStackTrace();
			fail("Falha no teste  pesquisa na att");
		}

	}

	@Test
	@DisplayName("Remoçao realizada com sucesso")
	void remove() {

		try {
		
			daop.remover(p.getPagamento());
			daop.commit();

		} catch (SeachNotFoundException | CommitException e) {
			e.printStackTrace();
			fail("Falha no teste ..");
		}
		Pagamento searchp = null;

		try {
			searchp = daop.pesquisar(p.getPagamento());
			fail("Falha no teste");
		} catch (SeachNotFoundException e) {
			assertNull(searchp);
		}

	}

}

