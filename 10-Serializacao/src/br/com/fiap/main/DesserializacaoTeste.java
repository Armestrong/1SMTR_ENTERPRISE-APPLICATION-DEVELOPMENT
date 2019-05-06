package br.com.fiap.main;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import br.com.fiap.entity.Predio;

public class DesserializacaoTeste {

	public static void main(String[] args) throws Exception {
		
		FileInputStream file = new FileInputStream("predio.txt");

		
		ObjectInputStream input = new ObjectInputStream(file);
		
		//Desserializacao o objeto predio
		//Ler o arquivo e recuperar o objeto predio
		
		Predio predio = (Predio) input.readObject();
		
System.out.println("Andares :" + predio.getAndar());
System.out.println("Altura  :" + predio.getAltura());
System.out.println("Elevador:" + (predio.isElevador()?"Sim":"Nao"));

		
		
		
	}

}
