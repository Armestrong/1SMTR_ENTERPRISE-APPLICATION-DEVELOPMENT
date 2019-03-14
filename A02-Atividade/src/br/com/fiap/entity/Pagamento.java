package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "pay", sequenceName = "SQ_T_PAGAMENTO", initialValue = 1)
@Table(name = "T_PAGAMENTO")
public class Pagamento {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pay")
	@Column(name="CD_PAGAMENTO")
	private int pagamento;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_PAGAMENTO",nullable=false)
	private Calendar dataPagamento;
	
	@Column(name="VL_PAGAMENTO",nullable=false)
	private Float valorPagamento;
	
	@Enumerated
	@Column(name="DS_FORMA_PAGAMENTO",nullable=false)
	private FormaPagamento formaPagamento;

	
	
	public Pagamento(Calendar dataPagamento, Float valorPagamento, FormaPagamento formaPagamento) {
		super();
		this.dataPagamento = dataPagamento;
		this.valorPagamento = valorPagamento;
		this.formaPagamento = formaPagamento;
	}

	public Pagamento() {
		super();
	}

	public Pagamento(int pagamento, Calendar dataPagamento, Float valorPagamento, FormaPagamento formaPagamento) {
		super();
		this.pagamento = pagamento;
		this.dataPagamento = dataPagamento;
		this.valorPagamento = valorPagamento;
		this.formaPagamento = formaPagamento;
	}

	public int getPagamento() {
		return pagamento;
	}

	public void setPagamento(int pagamento) {
		this.pagamento = pagamento;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Float getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(Float valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	
	
	
	
}
