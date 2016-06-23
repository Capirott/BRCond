package br.com.condominio.dao;

import java.util.List;

import br.com.condominio.model.Inquilino;

public class InquilinoDAO extends GenericDao{

	private static final long serialVersionUID = 1L;
	public List<Inquilino> listAllByNome(String nome){
		return listarScript("from " + Inquilino.class.getName() + " where in_nome like '%" + nome +"%'", Inquilino.class);
	}
}
