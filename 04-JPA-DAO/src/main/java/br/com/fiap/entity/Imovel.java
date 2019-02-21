package br.com.fiap.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * T_IMOVEL *CD_IMOVEL(PK) *DS_TIPO(NUMBER) (ENUM) DS_AREA(NUMBER)
 * DT_CONSTRUCAO(DATE) *DS_LOGRADOURO(VARCHAR(100))
 */

@Entity
@Table(name = "T_IMOVEL")
@SequenceGenerator(name = "imoVEL", sequenceName = "SQ_T_IMOVEL", initialValue = 1)
public class Imovel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imoVEL")
	@Column(name = "CD_IMOVEL")
	private int codigo;

	@Column(name = "DS_TIPO")
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	@Column(name = "DS_AREA")
	private int area;

	@Column(name = "DT_CONSTRUCAO")
	@Temporal(TemporalType.DATE)
	private Calendar construcao;

	@Column(name = "DS_LOGRADOURO", nullable = false, length = 100)
	private String logradouro;

	public Imovel(int codigo, Tipo tipo, int area, Calendar construcao, String logradouro) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.area = area;
		this.construcao = construcao;
		this.logradouro = logradouro;
	}

	
	public Imovel(Tipo tipo, int area, Calendar construcao, String logradouro) {
		super();
		this.tipo = tipo;
		this.area = area;
		this.construcao = construcao;
		this.logradouro = logradouro;
	}


	public Imovel() {
		super();
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public Calendar getConstrucao() {
		return construcao;
	}

	public void setConstrucao(Calendar construcao) {
		this.construcao = construcao;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	
	
}
