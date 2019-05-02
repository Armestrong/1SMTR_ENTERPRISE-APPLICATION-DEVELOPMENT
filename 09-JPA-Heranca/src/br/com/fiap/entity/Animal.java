package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorColumn(name="DS_TIPO")
//@DiscriminatorValue("A")

@Entity
@Table(name="T_ANIMAL")
@SequenceGenerator(name="ani", allocationSize=1, sequenceName="SQ_T_ANIMAL")
public class Animal {
	
	@Id
	@Column(name="CD_ANIMAL")
	@GeneratedValue(generator="ani",strategy=GenerationType.SEQUENCE)
	private int cdAnimal;
	
	@Column(name="NM_ANIMAL")
	private String nome;

	@Column(name="DS_COR")
	private String cor;
	
	
	public Animal(int cdAnimal, String nome, String cor) {
		super();
		this.cdAnimal = cdAnimal;
		this.nome = nome;
		this.cor = cor;
	}

	
	
	
	public Animal(String nome, String cor) {
		super();
		this.nome = nome;
		this.cor = cor;
	}




	public Animal() {
		super();
	}
	

	public int getCdAnimal() {
		return cdAnimal;
	}

	public void setCdAnimal(int cdAnimal) {
		this.cdAnimal = cdAnimal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
}
