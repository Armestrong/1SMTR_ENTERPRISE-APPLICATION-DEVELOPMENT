package br.com.fiap.entity;

import java.io.Serializable;

public class Predio implements Serializable {
	
	private static final long serialVersionUID = -4868823954166753591L;
	private int andar;
	private boolean elevador;
	private double altura;

	public Predio() {
		super();
	}

	public Predio(int andar, boolean elevador, double altura) {
		super();
		this.andar = andar;
		this.elevador = elevador;
		this.altura = altura;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public boolean isElevador() {
		return elevador;
	}

	public void setElevador(boolean elevador) {
		this.elevador = elevador;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

}
