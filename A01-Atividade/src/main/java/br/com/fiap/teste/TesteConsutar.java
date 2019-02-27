package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.dao.Impl.MotoristaDAOImpl;
import br.com.fiap.dao.Impl.VeiculoDAOImpl;
import br.com.fiap.entity.Motorista;
import br.com.fiap.entity.Veiculo;

public class TesteConsutar {

	public static void main(String[] args) {
		EntityManagerFactory fa = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fa.createEntityManager();
		
		VeiculoDAO vd = new VeiculoDAOImpl(em);
		MotoristaDAO md = new MotoristaDAOImpl(em);
		
		Motorista moto = md.consultarM(10);
		System.out.println(moto.getNome());
		System.out.println(moto.getCarteira());
		
		Veiculo vei = vd.perquisarV(102);
		System.out.println(vei.getCodigo());
		System.out.println(vei.getPlaca());

		em.close();
		fa.close();
	}

}
