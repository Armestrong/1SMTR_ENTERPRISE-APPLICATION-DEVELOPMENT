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
@SequenceGenerator(name="time",sequenceName="SQ_T_TIME",allocationSize=1)
public class Time {

	@Id
	@Column(name="cd_time")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="time")
	private int codigo;
	
	@OneToOne(mappedBy="time")
	private Tecnico tecnico;
	
	@OneToMany(mappedBy="time", cascade=CascadeType.PERSIST)
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	
	@Column(name="nm_time", nullable=false, length=100)
	private String nome;
	
	@Column(name="nr_titulos")
	private int titulos;
	
	public Time(Tecnico tecnico, String nome, int titulos) {
		super();
		this.tecnico = tecnico;
		this.nome = nome;
		this.titulos = titulos;
	}

	public Time(int codigo, Tecnico tecnico, String nome, int titulos) {
		super();
		this.codigo = codigo;
		this.tecnico = tecnico;
		this.nome = nome;
		this.titulos = titulos;
	}

	public Time() {
		super();
	}
	
	public void addJogador(Jogador jogador) {
		//adicionar o jogador na lista
		jogadores.add(jogador);
		//adicionar o time no jogador
		jogador.setTime(this);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTitulos() {
		return titulos;
	}

	public void setTitulos(int titulos) {
		this.titulos = titulos;
	}
}
