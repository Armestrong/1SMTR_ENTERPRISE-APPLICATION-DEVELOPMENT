package br.com.fiap.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import br.com.fiap.entity.Predio;

public class SerializacaoTeste {

	public static void main(String[] args) throws Exception {
		
		//Serializar um objeto
		//Gravar o estado do objeto em um arquivo
		
		Predio predio = new Predio(8, true, 24);
		
		FileOutputStream file = new FileOutputStream("predio.txt");
		
		ObjectOutputStream output = new ObjectOutputStream(file);
		
		output.writeObject(predio);
		System.out.println("Predio Serializado !");
		 output.close();
		 file.close();
		
	}
}
