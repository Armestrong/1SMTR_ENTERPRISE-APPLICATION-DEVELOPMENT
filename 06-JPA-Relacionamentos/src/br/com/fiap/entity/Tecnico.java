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
@Table(name = "T_TECNICO")
@SequenceGenerator(name = "tecnico", sequenceName = "SQ_T_TECNICO", allocationSize = 1)
public class Tecnico {

	@Id
	@Column(name = "cd_tecnico")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tecnico")
	private int codigo;

	//cadastrar ou atualiza time também
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY) 
	@JoinColumn(name = "cd_time")
	private Time time;

	@Column(name = "nm_tecnico", nullable = false, length = 50)
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento")
	private Calendar dataNascimento;

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

}
