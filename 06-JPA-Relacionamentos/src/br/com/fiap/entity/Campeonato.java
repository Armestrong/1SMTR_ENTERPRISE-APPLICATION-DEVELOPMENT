package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CAMPEONATO")
@SequenceGenerator(name="campeonato",sequenceName="T_SQ_CAMPEONATO",allocationSize=1)
public class Campeonato {
	@Id
	@Column(name="cd_campeonato")
	@GeneratedValue(generator="campeonato", strategy= GenerationType.SEQUENCE)
	private int codigo;
	
	
	@Column(name="nm_campeonato")
	private String nome;
	
	@Column(name="ds_premiacao")
	private double premiacao;
	
	
	@Column(name="ds_local")
	private String local;


	public Campeonato(int codigo, String nome, double premiacao, String local, List<Time> times) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.premiacao = premiacao;
		this.local = local;
		this.times = times;
	}


	public Campeonato(String nome, double premiacao, String local) {
		
		this.nome = nome;
		this.premiacao = premiacao;
		this.local = local;
	
	}


	public Campeonato() {
		super();
	}


	@ManyToMany(mappedBy="campeonatos")
	
	private List<Time> times;
	
	public List<Time> getTimes() {
		return times;
	}


	public void setTimes(List<Time> times) {
		this.times = times;
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


	public double getPremiacao() {
		return premiacao;
	}


	public void setPremiacao(double premiacao) {
		this.premiacao = premiacao;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}
	
	
}
