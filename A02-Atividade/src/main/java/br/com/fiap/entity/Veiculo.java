package br.com.fiap.entity;



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

@Entity()
@Table(name="T_VEICULO")
@SequenceGenerator(name="vei", sequenceName="SQ_T_VEICULO", initialValue=1)
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vei")
	@Column(name="CD_CODIGO")
	private int codigo;
	
	@Column(name="DS_PLACA", nullable=false, length=9)
	private String placa ;
	
	@Column(name="DS_COR" ,  nullable=false, length=20)
	@Enumerated(EnumType.STRING)
	private Cor cor;
	
	@Column(name="NR_ANO")
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
