package br.com.condominio.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import br.com.condominio.model.Condominio;
import br.com.condominio.service.CondominioService;
import br.com.condominio.util.FacesMessages;

@Named
@ViewScoped
public class CondominioController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CondominioService condominioService;
	
	@Inject
	private FacesMessages messages;
	
	private List<Condominio> condominioList;
	
	private Condominio condominioEdicao = new Condominio();
	
	private Condominio condominioSelecionado;
	
	public void consultar(){
		condominioList = condominioService.listarTodos();
	}
	
	public void preparaNovoCondominio(){
		condominioEdicao = new Condominio();
	}
	
	public void save(){
		condominioService.save(condominioEdicao);
		
		consultar();
		
		messages.info("Condominio salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(Arrays.asList("form:msgs", "form:condominios-table"));
	}
	
	public void excluir(){
		condominioService.excluir(condominioSelecionado);
		condominioSelecionado = null;
		
		consultar();
		
		messages.info("Condominio excluido com sucesso!");
	}

	public CondominioService getCondominioService() {
		return condominioService;
	}

	public void setCondominioService(CondominioService condominioService) {
		this.condominioService = condominioService;
	}

	public FacesMessages getMessages() {
		return messages;
	}

	public void setMessages(FacesMessages messages) {
		this.messages = messages;
	}

	public List<Condominio> getCondominioList() {
		return condominioList;
	}

	public void setCondominioList(List<Condominio> condominioList) {
		this.condominioList = condominioList;
	}

	public Condominio getCondominioEdicao() {
		return condominioEdicao;
	}

	public void setCondominioEdicao(Condominio condominioEdicao) {
		this.condominioEdicao = condominioEdicao;
	}

	public Condominio getCondominioSelecionado() {
		return condominioSelecionado;
	}

	public void setCondominioSelecionado(Condominio condominioSelecionado) {
		this.condominioSelecionado = condominioSelecionado;
	}
}
