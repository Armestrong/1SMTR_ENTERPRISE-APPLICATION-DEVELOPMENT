package br.com.fiap.bo.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.com.fiap.bo.CalculadoraBO;

public class CalculadoraBOImpl extends UnicastRemoteObject implements CalculadoraBO {

	
	
	
	public CalculadoraBOImpl() throws RemoteException {
		super();
		
	}

	@Override
	public double somar(double n1, double n2) throws RemoteException {
		System.out.println("Somando ...");
		return n1 + n2;
	}

	@Override
	public double subtrair(double n1, double n2) throws RemoteException {
		System.out.println("Subtraindo ...");
		return n1 - n2;
	}

	@Override
	public int fatorial(int n) throws RemoteException {
		System.out.println("Fatorando...");
		for (int i = n-1; i > 1; i--) {
			n *= i;
		}
		return n;//(n==1?1:fatorial(n-1)*n);
	}

}
