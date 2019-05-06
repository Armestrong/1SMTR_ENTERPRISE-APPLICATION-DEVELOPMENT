package br.com.fiap.entity;

import java.io.Serializable;

public class Vingador implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3061023008085453967L;

	private String nome;
	
	private String poder;
	
	private boolean digno;


	
	public Vingador() {
		super();
	}

	public Vingador(String nome, String poder, boolean digno) {
		super();
		this.nome = nome;
		this.poder = poder;
		this.digno = digno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPoder() {
		return poder;
	}

	public void setPoder(String poder) {
		this.poder = poder;
	}

	public boolean isDigno() {
		return digno;
	}

	public void setDigno(boolean digno) {
		this.digno = digno;
	}
	
	
	
}
