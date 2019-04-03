package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.TecnicoDAO;
import br.com.fiap.dao.TimeDAO;
import br.com.fiap.dao.impl.TecnicoDAOImpl;
import br.com.fiap.dao.impl.TimeDAOImpl;
import br.com.fiap.entity.Campeonato;
import br.com.fiap.entity.Jogador;
import br.com.fiap.entity.Posicao;
import br.com.fiap.entity.Tecnico;
import br.com.fiap.entity.Time;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class TimeDAOTeste {

	private static TimeDAO timeDao;
	private static TecnicoDAO tecnicoDao;
	private Time time;
	private Tecnico tecnico;

	@BeforeAll // metodo que executa antes todos os testes
	public static void inicializar() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		timeDao = new TimeDAOImpl(em);
		tecnicoDao = new TecnicoDAOImpl(em);

	}

	@BeforeEach
	void cadastrarAntesdosTestes() {
		// cadastrar um time e um tecnico
		// Instanciar um tecnico(com time) e um time
		time = new Time(null, "FIAP Lol", 1);
		tecnico = new Tecnico(time, "Rafa", new GregorianCalendar(1990, Calendar.JANUARY, 5));
		Jogador j1 = new Jogador();
		j1.setNome("Thiago");
		j1.setPosicao(Posicao.ADC);

		Jogador j2 = new Jogador();

		j2.setNome("Rafa");
		j2.setPosicao(Posicao.JUNGLE);
		time.addJogador(j1);
		time.addJogador(j2);

		
		
		//Adicionar os campeonatos do time
		Campeonato c1 = new Campeonato("CBLOL", 100000, "Online");
		Campeonato c2 = new Campeonato("LCS", 200000, "USA");
		List<Campeonato> campeonatos = new ArrayList<>();
		campeonatos.add(c1);
		campeonatos.add(c2);
		
		time.setCampeonatos(campeonatos);
		
		
		
		// cadastrar o tecnico e o time
		try {
			// timeDao.create(time);
			tecnicoDao.create(tecnico);
			tecnicoDao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail(("Errou"));
		}
		assertNotEquals(0, time.getCodigo());
		assertNotEquals(0, tecnico.getCodigo());

	}

	@Test
	void readTest() {
		try {

			Tecnico busca = tecnicoDao.read(tecnico.getCodigo());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Errou");
		}
	}
}
