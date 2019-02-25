package br.com.fiap.entity;

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

@Entity()
@Table(name="T_MOTORISTA")
@SequenceGenerator(name="moto", sequenceName="SQ_T_MOTORISTA", initialValue=1)
public class Motorista {
	
	@Id
	@Column(name="NR_CARTEIRA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moto")
	private int carteira;
	
	@Column(name="NM_NOME")
	private String nome;
	
	@Column(name="DT_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Date nascimento;
	
	@Lob()
	@Column(name="FL_CARTEIRA")
	private byte[] carteiraFoto;
	
	@Column(name="DS_GENERO")
	@Enumerated(EnumType.STRING)
	private Genero genero;

	public int getCarteira() {
		return carteira;
	}

	public void setCarteira(int carteira) {
		this.carteira = carteira;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public byte[] getCarteiraFoto() {
		return carteiraFoto;
	}

	public void setCarteiraFoto(byte[] carteiraFoto) {
		this.carteiraFoto = carteiraFoto;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	
	
	
	public Motorista() {
		super();
	}

	public Motorista(int carteira, String nome, Date nascimento, byte[] carteiraFoto, Genero genero) {
		super();
		this.carteira = carteira;
		this.nome = nome;
		this.nascimento = nascimento;
		this.carteiraFoto = carteiraFoto;
		this.genero = genero;
	}

	public Motorista(String nome, Date nascimento, byte[] carteiraFoto, Genero genero) {
		super();
		this.nome = nome;
		this.nascimento = nascimento;
		this.carteiraFoto = carteiraFoto;
		this.genero = genero;
	}
	
	

}
