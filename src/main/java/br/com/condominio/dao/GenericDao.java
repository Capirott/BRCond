package br.com.condominio.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.condominio.model.Entidade;

public abstract class GenericDao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public <T extends Entidade> T consultar(Class<T> clazz, Long id){
		return manager.find(clazz, id);
	}
	
	public <T extends Entidade> List<T> listar(Class<T> clazz){
		return manager.createQuery("from " + clazz.getName(), clazz).getResultList();
	}
	
	public <T extends Entidade> List<T> listarScript(String script,Class<T> clazz){
		return manager.createQuery(script, clazz).getResultList();
	}
	
	public <T extends Entidade> T save(T bean){
		return manager.merge(bean);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Entidade> void excluir(T bean){
		bean = (T) consultar(bean.getClass(), bean.getId());
		manager.remove(bean);
	}
	
	

}
