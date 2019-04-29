package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_CONSULTA")
@IdClass(ConsultaPK.class)
public class Consulta  {
	
	@Id
	@SequenceGenerator(name="med",allocationSize=1,sequenceName="SQ_T_CONSULTA")
	@GeneratedValue(generator="med", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="cd_crm")
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Medico crm;
	
	@Column(name="cd_paciente")
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Paciente codigoPaciente;
	
	@Column(name="dt_consulta")
	@Temporal(TemporalType.DATE)
	private Calendar datConsulta;
	
	@Column(name="vl_consulta")
	private double valorConsulta;
	
	@Column(name="st_convenio")
	private boolean convenio;
	
}
