package br.com.fiap.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.CustomerDAO;
import br.com.fiap.dao.impl.CustomerDAOImpl;
import br.com.fiap.entity.Customer;
import br.com.fiap.entity.Gender;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.SearchNotFoundException;

class CustomerDAOTest {

	private static CustomerDAO dao;
	
	private Customer customer;

	@BeforeAll // Método executado antes de todos os testes
	public static void init() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");

		EntityManager em = fabrica.createEntityManager();

		dao = new CustomerDAOImpl(em);
	}

	@BeforeEach // Método executado antes de cada teste
	void beforeTest() {
		// Arrange: instanciar os objetos
		customer = new Customer("Teste", new GregorianCalendar(1999, Calendar.MARCH, 15), Gender.OTHERS, null);

		// Act: cadastrar o cliente
		try {
			dao.create(customer);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste...");
		}
	}

	@Test
	@DisplayName("Teste de cadastro com sucesso")
	void createTest() {
		// Assert: validar o resultado
		// valida se a sequence gerou um código para o customer
		assertNotEquals(customer.getId(), 0);
	}

	@Test
	@DisplayName("Teste de busca com sucesso")
	void read() {
		// Act - pesquisar o customer que foi cadastrado
		try {
			Customer search = dao.read(customer.getId());

			// Assert - valida se pesquisou corretamente
			assertNotNull(search);
			assertEquals(search.getId(), customer.getId());

		} catch (SearchNotFoundException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
	}

	@Test
	@DisplayName("Teste de atualização com sucesso")
	void update() {
		
		// Atualizar o customer cadastrado
		customer.setName("Teste Update");
		customer.setGender(Gender.MALE);

		try {
			dao.update(customer);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}

		// Pesquisar o customer
		try {
			Customer search = dao.read(customer.getId());
			// Validar se as alterações foram realizadas
			assertEquals("Teste Update", search.getName());
			assertEquals(Gender.MALE, search.getGender());

		} catch (SearchNotFoundException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}

	}

	@Test
	@DisplayName("Teste de remoção com sucesso")
	void remove() {
		// Remover o customer
		try {
			dao.delete(customer.getId());
			dao.commit();
		} catch (SearchNotFoundException | CommitException e) {
			e.printStackTrace();
			fail("Deu ruim");
		}
		// Pesquisar o customer que foi removido
		Customer search = null;
		try {
			search = dao.read(customer.getId());
			fail("Falha no teste");
		} catch (SearchNotFoundException e) {
			// Sucesso
			assertNull(search);
		}
	}

}
