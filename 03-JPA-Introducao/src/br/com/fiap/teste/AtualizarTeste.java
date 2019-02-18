package br.com.fiap.teste;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Tipo;
import br.com.fiap.entity.Zoologico;

public class AtualizarTeste {

	public static void main(String[] args) {
		 
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
	
		//Depois, a fabrica cria o entity manager
		EntityManager em = fabrica.createEntityManager();
		
		
		// Criar um objeto zooogico com um id existente no banco
		Zoologico zoo = new Zoologico(1,"Zoo de Santos",
				100,Tipo.terrestre, new Date(), new Date(),
				Calendar.getInstance(),
				false, null);
				
				
				// atualizar os dados no banco de dados
		em.merge(zoo);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
	}

}
