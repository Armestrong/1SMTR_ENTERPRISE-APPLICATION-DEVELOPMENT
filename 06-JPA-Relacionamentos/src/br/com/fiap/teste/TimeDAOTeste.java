package br.com.fiap.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.TecnicoDAO;
import br.com.fiap.dao.TimeDAO;
import br.com.fiap.dao.impl.TecnicoDAOImpl;
import br.com.fiap.dao.impl.TimeDAOImpl;
import br.com.fiap.entity.Jogador;
import br.com.fiap.entity.Posicao;
import br.com.fiap.entity.Tecnico;
import br.com.fiap.entity.Time;
import br.com.fiap.exception.IdNotKnowFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class TimeDAOTeste {
	private static TimeDAO timeDao;
	private static TecnicoDAO tecnicoDao;
	private static Time time;
	private static Tecnico tecnico;
	

	@BeforeAll
	public static void init() {
		

		EntityManager em = EntityManagerFactorySingleton.getInstace().createEntityManager();

		timeDao = new TimeDAOImpl(em);
		tecnicoDao = new TecnicoDAOImpl(em);

	}

	@BeforeEach
	@DisplayName("Teste Cadastro OK")
	void cadastrarAntesdoTeste() {
		// Intanciar um time e um tecnico com o time
		// Cadastro tecnico e o time
		
		time = new Time(null,"FIAP DO TERROR", 1);
		tecnico = new Tecnico(time, "Rafa", new GregorianCalendar(1990, Calendar.AUGUST, 5));
		
		Jogador j1 = new Jogador();
		j1.setNome("Thiago");
		j1.setPosicao(Posicao.ADC);
		
		Jogador j2 = new Jogador();
		j2.setNome("rafa");
		j2.setPosicao(Posicao.JUNGLE);
		
		
		Jogador j3= new Jogador();
		j3.setNome("rafa");
		j3.setPosicao(Posicao.MID);
		
		time.addJogador(j1);
		time.addJogador(j2);
		time.addJogador(j3);
		
		try {
			//timeDao.create(time);
			tecnicoDao.create(tecnico);
			tecnicoDao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Errouuu");
		}
	}

	@Test
	void criacaoEintancia() {
		// Cadastrar um time e um tecnico
		assertNotEquals(0, time.getCodigo());
		assertNotEquals(0, tecnico.getCodigo());

	}

	@Test
	@DisplayName("Teste Pesquisa OK")
	void pesquisa() {
		try {
			Tecnico procura = tecnicoDao.read(tecnico.getCodigo());

			assertNotNull(procura);
			assertNotNull(procura.getTime().getCodigo());
			
			assertEquals(procura.getCodigo(), tecnico.getCodigo());
			assertEquals(procura.getTime().getCodigo(), time.getCodigo());

		} catch (IdNotKnowFoundException e) {
			e.printStackTrace();
			fail("Falha na pesquisa ..");
		}

	}

}
