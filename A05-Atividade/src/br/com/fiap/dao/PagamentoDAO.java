package br.com.fiap.dao;

import br.com.fiap.dao.generic.GenericDAO;
import br.com.fiap.entity.Pagamento;

public interface PagamentoDAO extends GenericDAO<Pagamento, Integer>{

		double AllPagamentos(int codPasg);
}
