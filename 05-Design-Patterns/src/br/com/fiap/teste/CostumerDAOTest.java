package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import br.com.fiap.dao.CostumerDAO;
import br.com.fiap.dao.Impl.CostumerDAOImpl;
import br.com.fiap.entity.Costumer;
import br.com.fiap.entity.Gender;
import br.com.fiap.excecao.CommitException;

class CostumerDAOTest {
	

	@Test
	void createTest() {
		//arrange : Instacia os objetos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");
		EntityManager em = fabrica.createEntityManager();
		CostumerDAO dao = new CostumerDAOImpl(em);
		Costumer c= new Costumer("Teste", new GregorianCalendar( 1999, Calendar.MARCH,15), Gender.FEMALE, null); 
		
		//Act :cadastrar o cliente
		try {
			dao.create(c);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Nao passaras no teste facista...");		}
		
		//Assert: Validar o resultado
		//Valida se a sequence gerou um codigo para o costumer
		assertNotEquals(c.getId(), 0);
		
	}

}
