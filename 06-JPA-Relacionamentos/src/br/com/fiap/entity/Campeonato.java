package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_CAMPEONATO")
@SequenceGenerator(name="camp", allocationSize=1,sequenceName="T_SQ_CAMPEONATO")
public class Campeonato {
	
	@Id
	@Column(name="CD_CODIDO")
	@GeneratedValue(generator="camp",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="NM_NOME",nullable=false, length=100)
	private String nome;
	
	@Column(name="VL_PREMIACAO")
	private double premiacao;
	
	@Column(name="DT_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	
	@Column(name="DS_LOCAL")
	private String local;


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


	public Calendar getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}


	public Campeonato(int codigo, String nome, double premiacao, Calendar dataNascimento, String local) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.premiacao = premiacao;
		this.dataNascimento = dataNascimento;
		this.local = local;
	}


	public Campeonato(String nome, double premiacao, Calendar dataNascimento, String local) {
		super();
		this.nome = nome;
		this.premiacao = premiacao;
		this.dataNascimento = dataNascimento;
		this.local = local;
	}


	public Campeonato() {
		super();
	}
	
	
	

}
