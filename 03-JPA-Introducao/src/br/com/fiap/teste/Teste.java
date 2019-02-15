package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		// Criar um genrenciador de entidades (Entity Manager)
		//Primeiro Criar a fabrica de entity manager
		EntityManagerFactory  fabrica = 
				Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		//Depois, a fabrica cria o entity manager
		
		EntityManager em = fabrica.createEntityManager();
		em.close();
		fabrica.close();
	}

}
