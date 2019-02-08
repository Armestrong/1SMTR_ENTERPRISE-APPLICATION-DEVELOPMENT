package br.com.fiap.teste;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.bean.Animal;

public class Teste {

	public static void main(String[] args) {
		// Instanciar um Animal 
		
		Animal animal = new Animal();
		
		// API reflection: recupera toda a estrutura da classe 
		// exibir o ome da classe
		
		System.out.println(animal.getClass().getSimpleName());
		
		// Recuperar os metodos da classe animal
		System.out.println("MÉTODOS :");
		Method[] metodos = animal.getClass().getDeclaredMethods();
		
		for (Method m : metodos) {
			System.out.println(m.getName());
		}
		
		// Recuperar os atributos da classe animal
		System.out.println(" ");
		System.out.println("ATRIBUTOS:");
		Field[] atribrutos = animal.getClass().getDeclaredFields();
		
		for (int i = 0; i < atribrutos.length; i++) {
			System.out.println(atribrutos[i].getName());
			
			//Recuperar a anotação @Coluna
			Coluna a = atribrutos[i].getAnnotation(Coluna.class);
			System.out.println(" ");
			System.out.println("Campo:" + a.nome());
			System.out.println("Obrigatorio:" + a.nullable());
		}
	}

}
