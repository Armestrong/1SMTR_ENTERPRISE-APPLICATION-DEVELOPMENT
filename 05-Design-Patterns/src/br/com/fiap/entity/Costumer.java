package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_COSTUMER")
@SequenceGenerator(name="cli",sequenceName="SQ_T_COSTUMER",initialValue=1)
public class Costumer {
	
	@Id
	@Column(name="CD_CLIENTE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="cli")
	private int id;
	
	@Column(name="NM_NOME", nullable=false)
	private String name;
	
	@Column(name="DT_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Calendar BirthDia;
	
	@Column(name="DS_GENERO")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name="FL_PERFIL")
	@Lob
	private byte[] Perfilphoto;

	
	
	public Costumer(String name, Calendar birthDia, Gender gender, byte[] perfilphoto) {
		super();
		this.name = name;
		BirthDia = birthDia;
		this.gender = gender;
		Perfilphoto = perfilphoto;
	}

	public Costumer(int id, String name, Calendar birthDia, Gender gender, byte[] perfilphoto) {
		super();
		this.id = id;
		this.name = name;
		BirthDia = birthDia;
		this.gender = gender;
		Perfilphoto = perfilphoto;
	}

	public Costumer() {
		super();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getBirthDia() {
		return BirthDia;
	}

	public void setBirthDia(Calendar birthDia) {
		BirthDia = birthDia;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public byte[] getPerfilphoto() {
		return Perfilphoto;
	}

	public void setPerfilphoto(byte[] perfilphoto) {
		Perfilphoto = perfilphoto;
	}

	
	
}
