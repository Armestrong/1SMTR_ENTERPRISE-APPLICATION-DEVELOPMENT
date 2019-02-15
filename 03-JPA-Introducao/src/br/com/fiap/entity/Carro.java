package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="TB_CARRO")
@SequenceGenerator(name="carro",sequenceName="SQ_TB_CARRO",allocationSize=1)
public class Carro {
	
	@Id // Chave primaria 
	@Column(name="CD_CARRO")
	@GeneratedValue(generator="carro",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="NM_CARRO", nullable = false, length = 50)
	private String nome;
	
	@Column(name="DS_MARCA", length = 50)
	private String marca;
	
	@Column(name="DS_PLACA", nullable = false)
	private String placa;
	
	@Column(name="NR_ANO")
	private int ano;
	
	@Column(name="DS_CAMBIO")
	@Enumerated(EnumType.STRING) // Grava a String da constante
	private Transmissao cambio;
	
	@Column(name="DT_FABRICACAO", updatable = false)
	@Temporal(TemporalType.DATE) // Grava somente a data no banco 
	private Calendar dataFbricacao;

	@Transient // Não será uma coluna no banco de dados
	private boolean ligado;
	
	
	@Lob // Grava arquivo no banco de dados
	private byte[] documento;

	

	public Carro(int codigo, String nome, String marca, String placa, int ano, Transmissao cambio,
			Calendar dataFbricacao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.marca = marca;
		this.placa = placa;
		this.ano = ano;
		this.cambio = cambio;
		this.dataFbricacao = dataFbricacao;
	}


	public Carro(String nome, String marca, String placa, int ano, Transmissao cambio, Calendar dataFbricacao,
			boolean ligado, byte[] documento) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.placa = placa;
		this.ano = ano;
		this.cambio = cambio;
		this.dataFbricacao = dataFbricacao;
		this.ligado = ligado;
		this.documento = documento;
	}


	public Carro() {
		super();
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


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}


	public Transmissao getCambio() {
		return cambio;
	}


	public void setCambio(Transmissao cambio) {
		this.cambio = cambio;
	}


	public Calendar getDataFbricacao() {
		return dataFbricacao;
	}


	public void setDataFbricacao(Calendar dataFbricacao) {
		this.dataFbricacao = dataFbricacao;
	}


	public boolean isLigado() {
		return ligado;
	}


	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}


	public byte[] getDocumento() {
		return documento;
	}


	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}
	
	
	
}
