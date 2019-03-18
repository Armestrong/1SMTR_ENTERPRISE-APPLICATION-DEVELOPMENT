package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_TECNICO")
@SequenceGenerator(name="tec", allocationSize=1,sequenceName="T_SQ_TECNICO")
public class Tecnico {
	
	@Id
	@Column(name="CD_CODIGO")
	@GeneratedValue(generator="tec",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@OneToOne
	@JoinColumn(name="cd_time")
	private Time time;
	
	@Column(name="NM_NOME",nullable=false, length=100)
	private String nome;
	
	@Column(name="DT_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

}
