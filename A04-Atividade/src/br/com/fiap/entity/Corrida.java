package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "T_CORRIDA")
@SequenceGenerator(name = "run", sequenceName = "SQ_T_CORRIDA", allocationSize = 1)
public class Corrida {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "run")
	@Column(name = "CD_CORRIDA")
	private int corrida;
	
	@Column(name="DS_ORIGEM", length=150)
	private String origem;
	
	@Column(name="DS_DESTINO", length=150)
	private String destino;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_CORRIDA")
	private Calendar dataCorrida;

	@Column(name="VL_CORRIDA",nullable=false)
	private Float valorCorrida;

	@ManyToOne()
	private Motorista motorista;
	
	@ManyToOne()
	private Passageiro passageiro;
	
	
	@OneToOne(mappedBy="corrida")
	private Pagamento pagamento;


	
	
	public Corrida() {
		super();
	}


	public Corrida(String origem, String destino, Calendar dataCorrida, Float valorCorrida) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.dataCorrida = dataCorrida;
		this.valorCorrida = valorCorrida;
	}


	public Corrida(int corrida, String origem, String destino, Calendar dataCorrida, Float valorCorrida,
			Motorista motorista, Passageiro passageiro, Pagamento pagamento) {
		super();
		this.corrida = corrida;
		this.origem = origem;
		this.destino = destino;
		this.dataCorrida = dataCorrida;
		this.valorCorrida = valorCorrida;
		this.motorista = motorista;
		this.passageiro = passageiro;
		this.pagamento = pagamento;
	}


	public int getCorrida() {
		return corrida;
	}


	public void setCorrida(int corrida) {
		this.corrida = corrida;
	}


	public String getOrigem() {
		return origem;
	}


	public void setOrigem(String origem) {
		this.origem = origem;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public Calendar getDataCorrida() {
		return dataCorrida;
	}


	public void setDataCorrida(Calendar dataCorrida) {
		this.dataCorrida = dataCorrida;
	}


	public Float getValorCorrida() {
		return valorCorrida;
	}


	public void setValorCorrida(Float valorCorrida) {
		this.valorCorrida = valorCorrida;
	}


	public Motorista getMotorista() {
		return motorista;
	}


	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}


	public Passageiro getPassageiro() {
		return passageiro;
	}


	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}


	public Pagamento getPagamento() {
		return pagamento;
	}


	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	


	
}
