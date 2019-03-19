package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	
	
	private static EntityManagerFactory emf;

	public EntityManagerFactorySingleton() {}
	
	public static EntityManagerFactory getInstace() {
		if (emf==null) {
			emf = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return emf;
	}
}
