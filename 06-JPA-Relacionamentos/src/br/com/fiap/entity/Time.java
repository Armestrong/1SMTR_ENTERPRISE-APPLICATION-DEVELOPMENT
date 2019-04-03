package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "T_TIME")
@Entity
@SequenceGenerator(name = "time", sequenceName = "T_SQ_TIME", allocationSize = 1)
public class Time {

	@Id
	@Column(name = "cd_time")
	@GeneratedValue(generator = "time", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@OneToOne(mappedBy = "time")
	private Tecnico tecnico;

	@OneToMany(mappedBy = "time", cascade = CascadeType.PERSIST)
	private List<Jogador> jogadores = new ArrayList<Jogador>();

	@Column(name = "nm_time")
	private String nome;

	@Column(name = "nm_titulos")
	private int titulos;

	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name = "T_TIME_CAMPEONATO", 
	joinColumns = @JoinColumn(name = ""), 
	inverseJoinColumns = @JoinColumn(name = ""))
	private List<Campeonato> campeonatos;

	public Time() {
		super();
	}

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

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public List<Campeonato> getCampeonatos() {
		return campeonatos;
	}

	public void setCampeonatos(List<Campeonato> campeonatos) {
		this.campeonatos = campeonatos;
	}

	public void addJogador(Jogador jogador) {
		// add jogador na lista
		jogadores.add(jogador);
		// add time no jogador
		jogador.setTime(this);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public List<Jogador> getJogador() {
		return jogadores;
	}

	public void setJogador(List<Jogador> jogador) {
		this.jogadores = jogador;
	}

}
