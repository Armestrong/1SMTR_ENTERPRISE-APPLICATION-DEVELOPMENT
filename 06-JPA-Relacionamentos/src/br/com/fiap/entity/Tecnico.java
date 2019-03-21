package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_TECNICO")
@SequenceGenerator(name="tec", allocationSize=1,sequenceName="T_SQ_TECNICO")
public class Tecnico {
	
	@Id
	@Column(name="CD_CODIGO")
	@GeneratedValue(generator="tec",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@OneToOne(fetch= FetchType.LAZY,cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="cd_time")
	private Time time;
	
	@Column(name="NM_NOME",nullable=false, length=100)
	private String nome;
	
	@Column(name="DT_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	
	
	

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





	public Calendar getDataNascimento() {
		return dataNascimento;
	}





	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	


	public Tecnico() {
		super();
	}





	public Tecnico(Time time, String nome, Calendar dataNascimento) {
		super();
		this.time = time;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}





	public Tecnico(int codigo, Time time, String nome, Calendar dataNascimento) {
		super();
		this.codigo = codigo;
		this.time = time;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	
	
}
