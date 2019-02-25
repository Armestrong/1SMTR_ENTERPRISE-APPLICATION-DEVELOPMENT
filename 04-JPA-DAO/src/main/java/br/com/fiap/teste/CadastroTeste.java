package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.ImovelDAO;
import br.com.fiap.dao.impl.ImovelDAOImpl;
import br.com.fiap.entity.Imovel;
import br.com.fiap.entity.Tipo;
import br.com.fiap.excecao.CommitException;

public class CadastroTeste {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		
		ImovelDAO dao = new ImovelDAOImpl(em); 
		
		Imovel imovel = new Imovel(Tipo.APARTAMENTO, 100, new GregorianCalendar(2010,Calendar.JANUARY,2), "Av paulista");
		dao.cadastrar(imovel);
		
		try {
			dao.commit();
		} catch (CommitException e) {
			
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
		
	}

}
