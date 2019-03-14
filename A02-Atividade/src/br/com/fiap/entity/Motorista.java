package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity()
@Table(name="T_MOTORISTA")
public class Motorista {
	
	@Id
	@Column(name="NR_CARTEIRA")
	private int carteira;
	
	@Column(name="NM_NOME", nullable=false, length=150)
	private String nome;
	
	@Column(name="DT_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Calendar nascimento;
	
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

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
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

	public Motorista(int carteira, String nome, Calendar nascimento, byte[] carteiraFoto, Genero genero) {
		super();
		this.carteira = carteira;
		this.nome = nome;
		this.nascimento = nascimento;
		this.carteiraFoto = carteiraFoto;
		this.genero = genero;
	}

	public Motorista(String nome, Calendar nascimento, byte[] carteiraFoto, Genero genero) {
		super();
		this.nome = nome;
		this.nascimento = nascimento;
		this.carteiraFoto = carteiraFoto;
		this.genero = genero;
	}
	
	

}
