package br.com.fiap.main;

import java.io.ObjectOutputStream;
import java.net.Socket;

import br.com.fiap.entity.Vingador;

public class ClienteSocketTeste {
	//Criar um objeto e serializar na rede
	public static void main(String[] args) throws Exception {
		Vingador hulk = new Vingador("Hulk","Força",false);
		
		// servidor do professor onde mandei os atributos
		//Socket socket = new Socket("10.3.5.25", 1014);
		Socket socket = new Socket("localhost", 1014);
		
		
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
		output.writeObject(hulk);
		System.out.println("Objeto serializado na rede !");
		output.close();
		socket.close();
		
	}
}
