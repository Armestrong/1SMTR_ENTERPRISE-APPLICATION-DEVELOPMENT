package br.com.fiap.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity()
@Table(name="T_VEICULO")
public class Veiculo {

	@Id
	@Column(name="CD_CODIGO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vei")
	private int codigo;
	
	@Column(name="DS_PLACA", nullable=false, length=9)
	private String placa ;
	
	@Column(name="DS_COR" ,  nullable=false )
	@Enumerated(EnumType.STRING)
	private Cor cor;
	
	@Column(name="NR_ANO")
	@Temporal(TemporalType.DATE)
	private int ano;
  
	
	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getPlaca() {
		return placa;
	}



	public void setPlaca(String placa) {
		this.placa = placa;
	}



	public Cor getCor() {
		return cor;
	}



	public void setCor(Cor cor) {
		this.cor = cor;
	}



	public int getAno() {
		return ano;
	}



	public void setAno(int ano) {
		this.ano = ano;
	}


	

	public Veiculo() {
		super();
	}



	public Veiculo(String placa, Cor cor, int ano) {
		super();
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
	}



	public Veiculo(int codigo, String placa, Cor cor, int ano) {
		super();
		this.codigo = codigo;
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
	}

	
	
}
