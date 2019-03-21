package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_JOGADOR")
@SequenceGenerator(name="player", allocationSize=1,sequenceName="T_SQ_JOGADOR")
public class Jogador {
	@Id
	@Column(name="CD_CODIGO")
	@GeneratedValue(generator="player",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@ManyToOne()
	@JoinColumn(name="cd_time")
	private Time time;
	
	@Column(name="NM_NOME",nullable=false, length=100)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="DS_POSICAO")
	private Posicao posicao;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public Jogador(int codigo, Time time, String nome, Posicao posicao) {
		super();
		this.codigo = codigo;
		this.time = time;
		this.nome = nome;
		this.posicao = posicao;
	}

	public Jogador(Time time, String nome, Posicao posicao) {
		super();
		this.time = time;
		this.nome = nome;
		this.posicao = posicao;
	}

	public Jogador() {
		super();
	}
	
	
	
	
	
	
}
