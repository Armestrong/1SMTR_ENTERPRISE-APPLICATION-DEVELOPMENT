package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_TIME")
@SequenceGenerator(name="team", allocationSize=1,sequenceName="T_SQ_TIME")
public class Time {
	@Id
	@Column(name="CD_CODIGO")
	@GeneratedValue(generator="team",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@OneToMany(mappedBy="time", cascade=CascadeType.PERSIST)
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	

	@OneToOne(mappedBy="time")
	private Tecnico tecnico;
	
	@Column(name="NM_NOME",nullable=false, length=100)
	private String nome;
	
	@Column(name="QTD_MUNDIAL")
	private int mundiais;

	
	
	
	
	public int getCodigo() {
		return codigo;
	}





	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}





	public List<Jogador> getJoadores() {
		return jogadores;
	}





	public void setJoadores(List<Jogador> joadores) {
		this.jogadores = joadores;
	}





	public Tecnico getTecnico() {
		return tecnico;
	}





	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}





	public String getNome() {
		return nome;
	}





	public void setNome(String nome) {
		this.nome = nome;
	}





	public int getMundiais() {
		return mundiais;
	}





	public void setMundiais(int mundiais) {
		this.mundiais = mundiais;
	}





	public Time() {
		super();
	}


	public void addJogador(Jogador jogador) {
		// Adicionar o jogar na lsita
		jogadores.add(jogador);
		 jogador.setTime(this);
		//adiciona o Time do jogador
		
	}
	
	

	public Time(Tecnico tecnico, String nome, int mundiais) {
		super();
		
		this.tecnico = tecnico;
		this.nome = nome;
		this.mundiais = mundiais;
	}





	public Time(int codigo, List<Jogador> joadores, Tecnico tecnico, String nome, int mundiais) {
		super();
		this.codigo = codigo;
		
		this.tecnico = tecnico;
		this.nome = nome;
		this.mundiais = mundiais;
	}
	
	
}
