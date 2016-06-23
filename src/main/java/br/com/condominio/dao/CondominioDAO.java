package br.com.condominio.dao;

import java.util.List;

import br.com.condominio.model.Condominio;

public class CondominioDAO  extends GenericDao {
	private static final long serialVersionUID = 1L;
	
	public List<Condominio> listAllByNome(String nome){
		return listarScript("from " + Condominio.class.getName() + " where cd_nome like '%" + nome +"%'", Condominio.class);
	}
}
