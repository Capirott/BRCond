package br.com.condomino.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.condominio.dao.CondominioDAO;
import br.com.condominio.model.Condominio;
import br.com.condominio.util.Transacional;

public class CondominioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CondominioDAO condominioDAO;
	
	@Transacional
	public void save(Condominio condominio){
		condominioDAO.save(condominio);
	}
	
	public List<Condominio> listarTodos(){
		return condominioDAO.listar(Condominio.class);
	}

	@Transacional
	public void excluir(Condominio condominio){
		condominioDAO.excluir(condominio);
	}
}
