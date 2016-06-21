package br.com.condomino.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.condominio.dao.ApartamentoDAO;
import br.com.condominio.model.Apartamento;
import br.com.condominio.util.Transacional;

public class ApartamentoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ApartamentoDAO apartamentoDAO;
	
	@Transacional
	public void save(Apartamento apartamento){
		apartamentoDAO.save(apartamento);
	}
	
	public List<Apartamento> listarTodos(){
		return apartamentoDAO.listar(Apartamento.class);
	}

	@Transacional
	public void excluir(Apartamento apartamento){
		apartamentoDAO.excluir(apartamento);
	}
}
