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

public class TesteGravar {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();

		VeiculoDAO vdao = new VeiculoDAOImpl(em);
		MotoristaDAO mdao = new MotoristaDAOImpl(em);

		Veiculo vei = new Veiculo("AVE102", Cor.PRETO, 9899);
		Motorista moto = new Motorista(10, "JANNIFER", new GregorianCalendar(Calendar.APRIL, 20, 1998), null,
				Genero.F);
		vdao.cadastrarV(vei);
		mdao.cadastrarM(moto);

		try {
			vdao.commitV();
			mdao.commitM();
		} catch (Exception e) {
			e.printStackTrace();
			em.close();
			fabrica.close();
		}

	}

}
