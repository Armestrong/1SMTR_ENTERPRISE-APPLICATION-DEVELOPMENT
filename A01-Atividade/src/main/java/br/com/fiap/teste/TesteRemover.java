package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.dao.Impl.MotoristaDAOImpl;
import br.com.fiap.dao.Impl.VeiculoDAOImpl;
import br.com.fiap.execao.CommitException;
import br.com.fiap.execao.SearchNotFoundException;

public class TesteRemover {

	public static void main(String[] args) {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = f.createEntityManager();
		
		VeiculoDAO vd = new VeiculoDAOImpl(em);
		MotoristaDAO md = new MotoristaDAOImpl(em);
		
		try {
			vd.removerV(102);
			md.removerM(10);
			vd.commitV();
			md.commitM();
		} catch (SearchNotFoundException e) {
			e.printStackTrace();
		} catch (CommitException e) {
			e.printStackTrace();
		}

		em.close();
		f.close();
	}
	//finalizado
}
