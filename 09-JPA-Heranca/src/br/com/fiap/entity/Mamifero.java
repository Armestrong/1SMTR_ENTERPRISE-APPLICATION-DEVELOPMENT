package br.com.fiap.entity;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@DiscriminatorValue("M")

@Entity
@Table(name="T_MAMIFERO")
public class Mamifero extends Animal {

	@Column(name="ds_gestacao")
	private int tempoGestacao;
	
	@Column(name="st_pelos")
	private boolean pelos;
	
	public Mamifero(String cor, String nome, int tempoGestacao, boolean pelos) {
		super(cor, nome);
		this.tempoGestacao = tempoGestacao;
		this.pelos = pelos;
	}
	
	

	public Mamifero() {}

	public int getTempoGestacao() {
		return tempoGestacao;
	}

	public void setTempoGestacao(int tempoGestacao) {
		this.tempoGestacao = tempoGestacao;
	}

	public boolean isPelos() {
		return pelos;
	}

	public void setPelos(boolean pelos) {
		this.pelos = pelos;
	}
	
}
