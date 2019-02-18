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
@Table(name="T_ZOOLOGICO")
@SequenceGenerator(name="zoo",sequenceName="SQ_T_ZOOLOGICO",allocationSize=1)
public class Zoologico {
	
	@Id
	@Column(name="cd_zoologico")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="zoo")
	private int codigo;
	
	@Column(name="nm_zoologico",nullable=false,length=20)
	private String nome;
	
	@Column(name="qt_animais")
	private int quantidadeAnimais;

	@Column(name="ds_tipo")
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@Temporal(TemporalType.TIME)
	@Column(name="hr_abertura")
	private Date horaAbertura;
	
	@Temporal(TemporalType.TIME)
	@Column(name="hr_fechamento")
	private Date horaFechamento;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_inauguracao")
	private Calendar dataInauguracao;
	
	@Column(name="st_emergencia")
	private boolean emergencia;
	
	@Lob
	@Column(name="fl_logo")
	private byte[] logo;
	
	@Transient
	private boolean aberto;

	public Zoologico() {
		super();
	}
	
	public Zoologico(int codigo, String nome, int quantidadeAnimais, Tipo tipo, Date horaAbertura, Date horaFechamento,
			Calendar dataInauguracao, boolean emergencia, byte[] logo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.quantidadeAnimais = quantidadeAnimais;
		this.tipo = tipo;
		this.horaAbertura = horaAbertura;
		this.horaFechamento = horaFechamento;
		this.dataInauguracao = dataInauguracao;
		this.emergencia = emergencia;
		this.logo = logo;
	}

	public Zoologico(String nome, int quantidadeAnimais, Tipo tipo, Date horaAbertura, Date horaFechamento,
			Calendar dataInauguracao, boolean emergencia, byte[] logo) {
		super();
		this.nome = nome;
		this.quantidadeAnimais = quantidadeAnimais;
		this.tipo = tipo;
		this.horaAbertura = horaAbertura;
		this.horaFechamento = horaFechamento;
		this.dataInauguracao = dataInauguracao;
		this.emergencia = emergencia;
		this.logo = logo;
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

	public Date getHoraAbertura() {
		return horaAbertura;
	}

	public void setHoraAbertura(Date horaAbertura) {
		this.horaAbertura = horaAbertura;
	}

	public Date getHoraFechamento() {
		return horaFechamento;
	}

	public void setHoraFechamento(Date horaFechamento) {
		this.horaFechamento = horaFechamento;
	}

	public Calendar getDataInauguracao() {
		return dataInauguracao;
	}

	public void setDataInauguracao(Calendar dataInauguracao) {
		this.dataInauguracao = dataInauguracao;
	}

	public boolean isEmergencia() {
		return emergencia;
	}

	public void setEmergencia(boolean emergencia) {
		this.emergencia = emergencia;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public boolean isAberto() {
		return aberto;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}
	
}









