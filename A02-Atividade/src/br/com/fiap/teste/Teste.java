package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import br.com.fiap.dao.PassageiroDAO;
import br.com.fiap.dao.Impl.PassageiroImpl;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Passageiro;
import br.com.fiap.excecao.CommitException;

class Teste {

	@Test
	void createTest() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");
		EntityManager em = fabrica.createEntityManager();
		/*CARRO
		 * 
		 * CorridaDAO dao = new CorridaDAOimpl(em);
		 Corrida c = new Corrida("M", "F", new GregorianCalendar( 1999, Calendar.MARCH,15),(float) 1998);*/
		
		/*VEICULO
		 * 
		 * VeiculoDAO dao = new VeiculoDAOImpl(em);
		Veiculo vei = new Veiculo("SWWA11", Cor.PRETO, 1998);*/
		
		/*MOTORISTA
		 * 
		 * MotoristaDAO dao = new MotoristaDAOImpl (em);
		Motorista mm = new Motorista(1,"Arms", new GregorianCalendar( 1999, Calendar.APRIL,15), null, Genero.M);*/
		
		/*PAGAMENTO
		 * 
		 * PagamentoDAO dao = new PagamentoImpl(em);
		Pagamento p = new Pagamento(new GregorianCalendar( 1999, Calendar.APRIL,15), (float) 5.50,FormaPagamento.DEBITO);*/
		
		/*PASSAGEIRO
		 */
		  PassageiroDAO dao = new PassageiroImpl(em);
		Passageiro p = new Passageiro("Berna", new GregorianCalendar( 1999, Calendar.APRIL,15), Genero.M);
		
		try {
			dao.cadastrar(p);
			dao.commit();
			
		} catch (CommitException e) {
			e.printStackTrace();
			fail("ERRO .. ");
		}
		
		assertNotEquals(p.getGenero(), 0);
		
	}

}
