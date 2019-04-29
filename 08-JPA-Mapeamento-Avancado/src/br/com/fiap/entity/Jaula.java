package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_JAULA")
@SequenceGenerator(name = "jaula", sequenceName = "SQ_T_JAULA", allocationSize = 1)
public class Jaula {

	@Id
	@Column(name = "cd_jaula")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jaula")
	private int codigo;

	@Column(name = "ds_jaula", nullable = false)
	private String descricao;

	@Column(name = "nr_metros")
	private float metros;
	
	public Jaula() {
		super();
	}

	public Jaula(String descricao, float metros) {
		super();
		this.descricao = descricao;
		this.metros = metros;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getMetros() {
		return metros;
	}

	public void setMetros(float metros) {
		this.metros = metros;
	}

}
