package br.com.condominio.dao;

import java.util.List;

import br.com.condominio.model.Proprietario;

public class ProprietarioDAO extends GenericDao{

	private static final long serialVersionUID = 1L;
	
	public List<Proprietario> listAllByNome(String nome){
		return listarScript("from " + Proprietario.class.getName() + " where pr_nome like '%" + nome +"%'", Proprietario.class);
	}
}
