package br.com.fiap.main;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import br.com.fiap.entity.Vingador;

public class ServerSocketTeste {

	public static void main(String[] args) throws Exception {
		//Aguardar uma conexao e ler o objeto vingador
		ServerSocket server = new ServerSocket(1014);
		System.out.println("Aguardando Conexao ...");
		Socket socket = server.accept();
		
		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		
		//ler o objeto e exibir as informaçoes
		Vingador v = (Vingador) input.readObject();
		System.out.println("Nome  :" +v.getNome());
		System.out.println("Poder :" + v.getPoder());
		System.out.println("Digno :" + (v.isDigno()?"Sim":"Nao"));
		
		socket.close();
		server.close();
		
	}

}
