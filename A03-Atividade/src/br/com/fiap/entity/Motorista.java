package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity()
@Table(name = "T_MOTORISTA")
@SequenceGenerator(name = "run", sequenceName = "SQ_T_CORRIDA", allocationSize = 1)
public class Motorista {

	@Id()
	@Column(name = "NR_CARTEIRA", nullable = false)
	@GeneratedValue(generator = "run")
	private int carteira;

	@Column(name = "NM_NOME", nullable = false, length = 150)
	private String nome;

	@Column(name = "DT_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Calendar nascimento;

	@Lob()
	@Column(name = "FL_CARTEIRA")
	private byte[] carteiraFoto;

	@Column(name = "DS_GENERO")
	@Enumerated(EnumType.STRING)
	private Genero genero;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "T_VEICULO_MOTORISTA", joinColumns = @JoinColumn(name = ""), inverseJoinColumns = @JoinColumn(name = ""))
	private List<Veiculo> codigo;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cd_corrida")
	private Corrida corrida;

	public Motorista() {
		super();
	}
	
	
	Motorista(int carteira, String nome, Calendar nascimento, byte[] carteiraFoto, Genero genero) {
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

	public Motorista(int carteira, String nome, Calendar nascimento, byte[] carteiraFoto, Genero genero,
			List<Veiculo> codigo, Corrida corrida) {
		super();
		this.carteira = carteira;
		this.nome = nome;
		this.nascimento = nascimento;
		this.carteiraFoto = carteiraFoto;
		this.genero = genero;
		this.codigo = codigo;
		this.corrida = corrida;
	}

	public List<Veiculo> getCodigo() {
		return codigo;
	}

	public void setCodigo(List<Veiculo> codigo) {
		this.codigo = codigo;
	}

	public Corrida getCorrida() {
		return corrida;
	}

	public void setCorrida(Corrida corrida) {
		this.corrida = corrida;
	}

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



}
