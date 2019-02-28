package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	// 1 - ATRIBUTO ESTATICO DO OBJETO QUE SERA UNICO
	private static EntityManagerFactory emf;

	
	// 2 - CONSTRUTOR PRIVADO
	private EntityManagerFactorySingleton() {

	}

	// 3 - METODO ESTATICO QUE ESTANCIA O OBJETO UNICO
	public static EntityManagerFactory getInstance() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return emf;
	}

	
	
	
}
