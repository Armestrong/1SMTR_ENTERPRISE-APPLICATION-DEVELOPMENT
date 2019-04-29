package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_PACIENTE")
@SequenceGenerator(name="pac", allocationSize=1,sequenceName="SQ_T_PACIENTE")
public class Paciente {
	
	@Id
	@GeneratedValue(generator="pac",strategy=GenerationType.SEQUENCE)
	@Column(name="cd_paciente")
	private int codigoPaciente;
	
	@Column(name="nm_paciente", nullable=false, length=20)
	private String nome;
	
	@Column(name="ds_endereco")
	private String endereco;
}
