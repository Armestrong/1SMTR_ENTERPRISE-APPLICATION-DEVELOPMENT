package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.TecnicoDAO;
import br.com.fiap.dao.TimeDAO;
import br.com.fiap.dao.impl.TecnicoDAOImpl;
import br.com.fiap.dao.impl.TimeDAOImpl;
import br.com.fiap.entity.Jogador;
import br.com.fiap.entity.Posicao;
import br.com.fiap.entity.Tecnico;
import br.com.fiap.entity.Time;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class TimeDAOTest {

	private static TimeDAO timeDao;
	private static TecnicoDAO tecnicoDao;
	
	private Time time;
	private Tecnico tecnico;
	
	@BeforeAll //método que executa antes todos os testes
	public static void inicializar() {
		EntityManager em = EntityManagerFactorySingleton
							.getInstance().createEntityManager();
		timeDao = new TimeDAOImpl(em);
		tecnicoDao = new TecnicoDAOImpl(em);
	}
	
	@BeforeEach //método executado antes de cada teste
	public void cadastrarAntesDosTestes() {
		//Cadastrar um time e um tecnico
		//Instanciar um time e um tecnico com o time
		
		time = new Time(null, "FIAP LOL", 1);
		tecnico = new Tecnico(time, "Rafa", 
			new GregorianCalendar(1990, Calendar.JANUARY, 5));
		
		Jogador j1 = new Jogador();
		j1.setNome("Thiago");
		j1.setPosicao(Posicao.ADC);
		
		Jogador j2 = new Jogador();
		j2.setNome("Rafa");
		j2.setPosicao(Posicao.JUNGLE);
		
		time.addJogador(j1);
		time.addJogador(j2);
		
		//Cadastrar o tecnico e o time
		try {
			//timeDao.create(time);
			tecnicoDao.create(tecnico); 
			tecnicoDao.commit();
		}catch(Exception e) {
			e.printStackTrace();
			fail("Errouuuu");
		}
	}
	
	@Test
	void readTest() {
		//Pesquisar o tecnico pelo ID
		try {
			Tecnico busca = tecnicoDao.read(tecnico.getCodigo());
			
			assertNotNull(busca);
			assertNotNull(busca.getTime());
			
		} catch(Exception e) {
			e.printStackTrace();
			fail("Errouuuu");
		}
	}
	
	@Test
	void createTest() {
		assertNotEquals(0, time.getCodigo());
		assertNotEquals(0, tecnico.getCodigo());
	}

}
