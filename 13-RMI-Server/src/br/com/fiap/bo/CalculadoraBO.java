package br.com.fiap.bo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculadoraBO extends Remote {

	double somar(double n1, double n2) throws RemoteException;

	double subtrair(double n1, double n2) throws RemoteException;

	double fatorial(int n) throws RemoteException;
}
