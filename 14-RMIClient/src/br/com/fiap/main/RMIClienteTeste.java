package br.com.fiap.main;

import java.rmi.Naming;

import br.com.fiap.bo.CalculadoraBO;

public class RMIClienteTeste {

	public static void main(String[] args)throws Exception {
		//local do professor
		//CalculadoraBO bo = (CalculadoraBO) Naming.lookup("rmi://localhost:10.3.5.25:1014/chave");
		CalculadoraBO bo = (CalculadoraBO) Naming.lookup("rmi://localhost/chave");
		
		
		double soma = bo.somar(10, 10);
		System.out.println("Soma " + soma);

		int fatorial = (int) bo.fatorial(5);
		System.out.println("Fatorial :" + fatorial);
		
	}

}
