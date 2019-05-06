package br.com.fiap.main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.com.fiap.bo.CalculadoraBO;
import br.com.fiap.bo.impl.CalculadoraBOImpl;

public class RMIServerTeste {

	public static void main(String[] args) throws Exception {
		//Registrar o objeto remoto
		CalculadoraBO bo = new CalculadoraBOImpl();
		Registry registry = LocateRegistry.createRegistry(1014);
		registry.bind("chave", bo);
		System.out.println("Objeto remoto registrado !");
	}
}
