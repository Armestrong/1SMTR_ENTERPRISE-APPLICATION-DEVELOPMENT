package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_FUNCIONARIO")

@SecondaryTable(name="T_FUNCIONARIO_FINANCEIRO")

@SequenceGenerator(name="func",sequenceName="SQ_T_FUNCIONARIO",allocationSize=1)
public class Funcionario {

	@Id
	@Column(name="cd_funcionario")
	@GeneratedValue(generator="func",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_funcionario", nullable = false)
	private String nome;
	
	@Column(name="vl_salario", table="T_FUNCIONARIO_FINANCEIRO")
	private float salario;
	
	@Column(name="ds_cargo")
	@Enumerated(EnumType.STRING)
	private Cargo cargo;
	
	@Column(name="nr_conta", table = "T_FUNCIONARIO_FINANCEIRO")
	private int conta;
	
	public Funcionario() {
		super();
	}

	public Funcionario(String nome, float salario, Cargo cargo) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.cargo = cargo;
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

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}
	
}
