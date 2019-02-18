package br.com.fiap.teste;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Zoologico;

public class BuscaTeste {

	public static void main(String[] args) {
		EntityManagerFactory farica = 
				Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = farica.createEntityManager();
		
		//Pesquisar um zoologico de id = 1
		Zoologico zoo = em.find(Zoologico.class, 1);
		System.out.println(zoo.getNome());
		
		//alterar o nome do zoo
		zoo.setNome("ZooB");
		
		//fazer commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		em.close();
		farica.close();

	}

}
