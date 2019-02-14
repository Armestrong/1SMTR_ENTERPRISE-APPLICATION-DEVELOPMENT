package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_CARRO")
@SequenceGenerator(name="carro",sequenceName="SQ_TB_CARRO",allocationSize=1)
public class Carro {
	
	@Id
	@GeneratedValue(generator="carro",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	private String nome;
	
	private String marca;
	
	private String placa;
	
	private int ano;
	
	private Transmissao cambio;
	
	private Calendar dataFbricacao;

	
}
