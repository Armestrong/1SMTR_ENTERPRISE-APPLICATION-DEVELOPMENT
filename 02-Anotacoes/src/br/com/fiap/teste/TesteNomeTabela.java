package br.com.fiap.teste;

import br.com.fiap.anotacao.Tabela;
import br.com.fiap.bean.Animal;

public class TesteNomeTabela {

	public static void main(String[] args) {
		
		Animal animal = new Animal();
		Tabela anotacao = animal.getClass().getAnnotation(Tabela.class);
		// Recupera a anotação @Tabela
		System.out.println("SELECT * FROM "+ anotacao.nome());
		
		
	}

}
