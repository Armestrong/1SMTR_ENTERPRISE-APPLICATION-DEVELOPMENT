package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_TIME")
@SequenceGenerator(name="team", allocationSize=1,sequenceName="T_SQ_TIME")
public class Time {
	@Id
	@Column(name="CD_CODIGO")
	@GeneratedValue(generator="team",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@OneToMany(mappedBy="time")
	private List<Jogador> joadores;
	

	@OneToOne(mappedBy="time")
	private Tecnico tecnico;
	
	@Column(name="NM_NOME",nullable=false, length=100)
	private String nome;
	
	@Column(name="QTD_MUNDIAL")
	private int mundiais;

	
	
	
}
