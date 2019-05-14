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

@Entity
@Table(name="T_MEDICO")
@SequenceGenerator(name="medi", allocationSize=1,sequenceName="SQ_T_MEDICO")
public class Medico {
	
	@Id
	@GeneratedValue(generator="medi",strategy=GenerationType.SEQUENCE)
	@Column(name="NR_CRM")
	private int crm;

	@Column(name="NM_MEDICO", nullable=false)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_especialidade" , nullable=false)
	private Especialidade especialidade;
	

	
	}
