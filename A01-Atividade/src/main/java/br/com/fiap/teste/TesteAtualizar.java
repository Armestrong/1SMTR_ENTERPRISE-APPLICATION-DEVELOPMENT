package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.dao.Impl.MotoristaDAOImpl;
import br.com.fiap.dao.Impl.VeiculoDAOImpl;
import br.com.fiap.entity.Cor;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Motorista;
import br.com.fiap.entity.Veiculo;

public class TesteAtualizar {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		VeiculoDAO vdao = new VeiculoDAOImpl(em);
		MotoristaDAO mdao = new MotoristaDAOImpl(em);
		
		Veiculo vei = new Veiculo(1, "TEY000", Cor.MARROM, 2018);
		Motorista moto = new Motorista(10, "JENNEFIER",new GregorianCalendar(Calendar.AUGUST,20,1997), null, Genero.F);

		
		try {
		vdao.atualizarV(vei);
		mdao.atualizarM(moto);
		vdao.commitV();
		mdao.commitM();
		} catch (Exception e) {
			e.printStackTrace();
			em.close();
			fabrica.close();
		}
		
	}
	//finalizado
}
