package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.dao.generic.GenericDAO;
import br.com.fiap.entity.Corrida;
import br.com.fiap.entity.Motorista;
import br.com.fiap.entity.Passageiro;

public interface CorridaDAO extends GenericDAO<Corrida, Integer> {

	List<Corrida>BuscarCorridaProData(Calendar ini,Calendar fim);
	
	List<Corrida>todasAsCorridas(Motorista motorista);
	
	long qtdCorridasPassageiro(int codpasg);
	
	List<Corrida>BuscarAllCorriByPartNome(String nome);
	
	long qtdCorridasDeMotoByData(int codigoMoto,Calendar ini, Calendar fim);
	
	List<Corrida> max10ValorDeCorrida(int codPassag);
	
	List<Corrida>CorridasRealizadasByPassaEoMoto(int CodPassa,int CodMoto);
}
