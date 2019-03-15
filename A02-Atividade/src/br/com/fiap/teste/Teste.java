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
import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.dao.PagamentoDAO;
import br.com.fiap.dao.PassageiroDAO;
import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.dao.Impl.CorridaDAOimpl;
import br.com.fiap.dao.Impl.MotoristaDAOImpl;
import br.com.fiap.dao.Impl.PagamentoImpl;
import br.com.fiap.dao.Impl.PassageiroImpl;
import br.com.fiap.dao.Impl.VeiculoDAOImpl;
import br.com.fiap.entity.Cor;
import br.com.fiap.entity.Corrida;
import br.com.fiap.entity.FormaPagamento;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Motorista;
import br.com.fiap.entity.Pagamento;
import br.com.fiap.entity.Passageiro;
import br.com.fiap.entity.Veiculo;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.SeachNotFoundException;

class Teste {

	private static CorridaDAO daoc;
	private Corrida c;

	private static VeiculoDAO daov;
	private Veiculo vei;

	private static MotoristaDAO daom;
	private Motorista mm;

	private static PagamentoDAO daop;
	private Pagamento p;

	private static PassageiroDAO daopp;
	private Passageiro pp;

	@BeforeAll
	public static void init() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");
		EntityManager em = fabrica.createEntityManager();

		daoc = new CorridaDAOimpl(em);
		daov = new VeiculoDAOImpl(em);
		daom = new MotoristaDAOImpl(em);
		daop = new PagamentoImpl(em);
		daopp = new PassageiroImpl(em);

	}

	@BeforeEach
	void beforeTest() {
		c = new Corrida("MIX", "FIX", new GregorianCalendar(1991, Calendar.AUGUST, 1), (float) 19.98);
		
		vei = new Veiculo("SWWA11", Cor.PRETO, 1997);
		
		//ARRUMAR O MOTORISTA OIR CONTA DO SEQUENCE CD
		mm = new Motorista ("Arms", new GregorianCalendar(1998, Calendar.APRIL, 12), null, Genero.M);
		
		p = new Pagamento(new GregorianCalendar(1699, Calendar.APRIL, 15), (float) 5.50, FormaPagamento.DEBITO);
		
		pp = new Passageiro("Berna", new GregorianCalendar(1999, Calendar.APRIL, 15), Genero.M);

		try {
			daoc.cadastrar(c);
			daoc.commit();
			daov.cadastrar(vei);
			daov.commit();
			daom.cadastrar(mm);
			daom.commit();
			daop.cadastrar(p);
			daop.commit();
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

		assertNotEquals(c.getCorrida(), 0);
		assertNotEquals(vei.getCodigo(), 0);
		assertNotEquals(mm.getCarteira(), 0);
		assertNotEquals(p.getPagamento(), 0);
		assertNotEquals(pp.getPassageiro(), 0);

	}

	@Test
	@DisplayName("Teste de pesquisa com sucesso")
	void read() {

		try {
			Corrida searchc = daoc.pesquisar(c.getCorrida());
			Veiculo searchv = daov.pesquisar(vei.getCodigo());
			Motorista searchm = daom.pesquisar(mm.getCarteira());
			Pagamento searchp = daop.pesquisar(p.getPagamento());
			Passageiro searchpp = daopp.pesquisar(pp.getPassageiro());

			assertNotNull(searchc);
			assertNotNull(searchv);
			assertNotNull(searchm);
			assertNotNull(searchp);
			assertNotNull(searchpp);

			assertEquals(searchc.getCorrida(), c.getCorrida());
			assertEquals(searchv.getCodigo(), vei.getCodigo());
			assertEquals(searchm.getCarteira(), mm.getCarteira());
			assertEquals(searchp.getPagamento(), p.getPagamento());
			assertEquals(searchpp.getPassageiro(), pp.getPassageiro());

		} catch (SeachNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Test
	@DisplayName("Atualização realizada com sucesso")
	void update() {

		c.setOrigem("GUI Teste");
		c.setDestino("VIX Teste");
		vei.setCor(Cor.MARROM);
		vei.setPlaca("007BR");
		mm.setGenero(Genero.F);
		mm.setNome("Maria");
		p.setValorPagamento((float) 50.00);
		p.setFormaPagamento(FormaPagamento.DINHEIRO);
		pp.setGenero(Genero.M);
		pp.setNomePassageiro("DANIEL");

		try {

			daoc.atualizar(c);
			daoc.commit();
			daov.atualizar(vei);
			daov.commit();
			daom.atualizar(mm);
			daom.commit();
			daop.atualizar(p);
			daop.commit();
			daopp.atualizar(pp);
			daopp.commit();

		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste Atulizar ..");
		}

		try {
			Corrida searchc = daoc.pesquisar(c.getCorrida());
			Veiculo searchv = daov.pesquisar(vei.getCodigo());
			Motorista searchm = daom.pesquisar(mm.getCarteira());
			Pagamento searchp = daop.pesquisar(p.getPagamento());
			Passageiro searchpp = daopp.pesquisar(pp.getPassageiro());

			assertEquals("GUI Teste", searchc.getOrigem());
			assertEquals("VIX Teste", searchc.getDestino());
			assertEquals(Cor.MARROM, searchv.getCor());
			assertEquals("007BR", searchv.getPlaca());
			assertEquals(Genero.F, searchm.getGenero());
			assertEquals("Maria", searchm.getNome());

			assertEquals (Float.valueOf((float) 50.00), searchp.getValorPagamento());
			assertEquals(FormaPagamento.DINHEIRO, searchp.getFormaPagamento());
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
			daoc.remover(c.getCorrida());
			daoc.commit();
			daov.remover(vei.getCodigo());
			daov.commit();
			daom.remover(mm.getCarteira());
			daom.commit();
			daop.remover(p.getPagamento());
			daop.commit();
			daopp.remover(pp.getPassageiro());
			daopp.commit();

		} catch (SeachNotFoundException | CommitException e) {
			e.printStackTrace();
			fail("Falha no teste ..");
		}
		Corrida searchc = null;
		Veiculo searchv = null;
		Motorista searchm = null;
		Pagamento searchp = null;
		Passageiro searchpp = null;

		try {
			searchc = daoc.pesquisar(c.getCorrida());
			searchv = daov.pesquisar(vei.getCodigo());
			searchm = daom.pesquisar(mm.getCarteira());
			searchp = daop.pesquisar(p.getPagamento());
			searchpp = daopp.pesquisar(pp.getPassageiro());
			fail("Falha no teste");
		} catch (SeachNotFoundException e) {
			assertNull(searchc);
			assertNull(searchv);
			assertNull(searchm);
			assertNull(searchp);
			assertNull(searchpp);
		}

	}

}
