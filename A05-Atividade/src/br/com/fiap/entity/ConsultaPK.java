package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Calendar;

public class ConsultaPK implements Serializable {
	
	private int crm;
	private int codigoPaciente;
	private Calendar datConsulta;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoPaciente;
		result = prime * result + crm;
		result = prime * result + ((datConsulta == null) ? 0 : datConsulta.hashCode());
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
		ConsultaPK other = (ConsultaPK) obj;
		if (codigoPaciente != other.codigoPaciente)
			return false;
		if (crm != other.crm)
			return false;
		if (datConsulta == null) {
			if (other.datConsulta != null)
				return false;
		} else if (!datConsulta.equals(other.datConsulta))
			return false;
		return true;
	}


	public int getCrm() {
		return crm;
	}


	public void setCrm(int crm) {
		this.crm = crm;
	}


	public int getCodigoPaciente() {
		return codigoPaciente;
	}


	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}


	public Calendar getDatConsulta() {
		return datConsulta;
	}


	public void setDatConsulta(Calendar datConsulta) {
		this.datConsulta = datConsulta;
	}
	
	
	
	
}
