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
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name="TB_ZOOLOGICO")
@SequenceGenerator(name="zoo",sequenceName="TB_ZOOLOGICO",initialValue=1)
public class Zoologico {
	@Id
	@Column(name="CD_CODIGO")
	@GeneratedValue(generator="zoo",strategy=GenerationType.SEQUENCE)		
	private int codigo;
	
	@Column(name="NM_NOME",nullable = false, length = 20)
	private String nome;
	
	@Column(name="QTD_ANIMAIS")
	private int quantidadeAnimais;
	
	@Column(name="DS_TIPO" , nullable = false, length = 15)
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@Column(name="HR_ABERTURA")
	@Temporal(TemporalType.TIME)
	private Date abertura;
	
	@Column(name="HR_FECHAMENTO")
	@Temporal(TemporalType.TIME)
	private Date fechamento;
	
	@Column(name="DT_INAUGURACAO")
	@Temporal(TemporalType.DATE)
	private Date inauguracao;
	
	@Column(name="ST_EMERGENCIA")
	private boolean emergencia;
	
	@Transient
	private boolean aberto;
	
	@Lob
	private byte[] logo;
	

	public Zoologico(String nome, int quantidadeAnimais, Tipo tipo, Date abertura, boolean emergencia, byte[] logo) {
		super();
		this.nome = nome;
		this.quantidadeAnimais = quantidadeAnimais;
		this.tipo = tipo;
		this.abertura = abertura;
		this.emergencia = emergencia;
		this.logo = logo;
	}



	public Zoologico(String nome, int quantidadeAnimais, Tipo tipo, Date abertura, Date fechamento, Date inauguracao,
			boolean emergencia, byte[] logo) {
		super();
		this.nome = nome;
		this.quantidadeAnimais = quantidadeAnimais;
		this.tipo = tipo;
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.inauguracao = inauguracao;
		this.emergencia = emergencia;
		this.logo = logo;
	}



	public Zoologico() {
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

	public int getQuantidadeAnimais() {
		return quantidadeAnimais;
	}

	public void setQuantidadeAnimais(int quantidadeAnimais) {
		this.quantidadeAnimais = quantidadeAnimais;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Date getAbertura() {
		return abertura;
	}

	public void setAbertura(Date abertura) {
		this.abertura = abertura;
	}

	public Date getFechamento() {
		return fechamento;
	}

	public void setFechamento(Date fechamento) {
		this.fechamento = fechamento;
	}

	public Date getInauguracao() {
		return inauguracao;
	}

	public void setInauguracao(Date inauguracao) {
		this.inauguracao = inauguracao;
	}

	public boolean isEmergencia() {
		return emergencia;
	}

	public void setEmergencia(boolean emergencia) {
		this.emergencia = emergencia;
	}

	public boolean isAberto() {
		return aberto;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	//********************************************************************
	
	
	
	
}
