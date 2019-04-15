package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

class PacoteDAOTeste {

	private static PacoteDAO dao;
	private static TransporteDAO daot;
	
	
	@BeforeAll
	public static void instanciar() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new PacoteDAOImpl(em);
		daot = new TransporteDAOImpl(em);
	}

	
	@Test
	void obeterPacotePTranspor() {
		
		Transporte t = new Transporte();
		//passando como codigo 1 a pesquisa
		t = daot.pesquisar(1);
		
		List<Pacote> lista = dao.buscarPorTransporte(t);
					
			// esperando que venha 2 pacotes referente ao codigo 
			assertEquals(2,lista.size());
			
			//validando para ver se é verdade
			//ver no pacote todos os transportes com id 1
			for (Pacote pacote : lista) {
				assertEquals(1,pacote.getTransporte().getId());
			}
	}
	
	@Test
	void buscarPData() {
		Calendar ini = new GregorianCalendar(2017, Calendar.JANUARY, 1); 
		Calendar fim = new GregorianCalendar(2018, Calendar.JANUARY, 1);
	
		
		List<Pacote> lista = dao.buscarPorData(ini, fim);
		
		for (Pacote pacote : lista) {
			assertTrue(pacote.getDataSaida().after(ini) && pacote.getDataSaida().before(fim));
		}
	
	}
	
	
}
