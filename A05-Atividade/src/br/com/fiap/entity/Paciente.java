package br.com.fiap.entity;

import javax.persistence.Entity;

@Entity
public class Paciente {
	private int codigoPaciente;
	private String nome;
	private String endereco;
}
