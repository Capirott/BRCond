package br.com.condominio.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.condominio.dao.InquilinoDAO;
import br.com.condominio.model.Inquilino;
import br.com.condominio.util.Transacional;

public class InquilinoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private InquilinoDAO inquilinoDAO;
	
	@Transacional
	public void save(Inquilino inquilino){
		inquilinoDAO.save(inquilino);
	}
	
	public List<Inquilino> listarTodos(){
		return inquilinoDAO.listar(Inquilino.class);
	}

	@Transacional
	public void excluir(Inquilino inquilino){
		inquilinoDAO.excluir(inquilino);
	}
	
	public Inquilino consultarPorId(Long id){
		return inquilinoDAO.consultar(Inquilino.class, id);
	}
	
	public List<Inquilino> listAllByNome(String nome){
		return inquilinoDAO.listAllByNome(nome);
	}
}
