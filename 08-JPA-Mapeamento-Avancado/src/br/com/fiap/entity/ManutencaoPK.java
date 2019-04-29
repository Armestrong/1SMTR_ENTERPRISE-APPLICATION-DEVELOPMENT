package br.com.fiap.entity;

import java.io.Serializable;

public class ManutencaoPK implements Serializable {

	private int codigo;
	
	private int jaula;
	
	private int funcionario;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getJaula() {
		return jaula;
	}

	public void setJaula(int jaula) {
		this.jaula = jaula;
	}

	public int getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(int funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + funcionario;
		result = prime * result + jaula;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManutencaoPK other = (ManutencaoPK) obj;
		if (codigo != other.codigo)
			return false;
		if (funcionario != other.funcionario)
			return false;
		if (jaula != other.jaula)
			return false;
		return true;
	}
	
}
