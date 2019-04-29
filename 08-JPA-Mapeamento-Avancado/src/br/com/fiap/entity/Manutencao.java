package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_MANUTENCAO")
@IdClass(ManutencaoPK.class)
public class Manutencao {

	@Id
	@Column(name="cd_manutencao")
	@GeneratedValue(generator="manu",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="manu",sequenceName="SQ_T_MANUTENCAO",allocationSize=1)
	private int codigo;
	
	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_jaula")
	private Jaula jaula;
	
	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_funcionario")
	private Funcionario funcionario;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_manutencao")
	private Calendar data;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo")
	private TipoManutencao tipo;
	
	@Column(name="ds_observacoes")
	private String observacoes;
	
	public Manutencao() {
		super();
	}

	public Manutencao(Jaula jaula, Funcionario funcionario, Calendar data, TipoManutencao tipo, String observacoes) {
		super();
		this.jaula = jaula;
		this.funcionario = funcionario;
		this.data = data;
		this.tipo = tipo;
		this.observacoes = observacoes;
	}

	public Jaula getJaula() {
		return jaula;
	}

	public void setJaula(Jaula jaula) {
		this.jaula = jaula;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public TipoManutencao getTipo() {
		return tipo;
	}

	public void setTipo(TipoManutencao tipo) {
		this.tipo = tipo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
}



