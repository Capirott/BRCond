package br.com.condominio.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.condominio.enums.TipoPessoaEnum;
import br.com.condominio.model.Proprietario;
import br.com.condominio.service.ProprietarioService;
import br.com.condominio.util.FacesMessages;

@Named
@ViewScoped
public class ProprietarioController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProprietarioService proprietarioService;
	
	@Inject
	private FacesMessages messages;
	
	private List<Proprietario> proprietarioList;
	
	private Proprietario proprietarioEdicao = new Proprietario(TipoPessoaEnum.PF);
	
	private Proprietario proprietarioSelecionado;
	
	public void consultar(){
		proprietarioList = proprietarioService.listarTodos();
	}
	
	public void preparaNovoProprietario(){
		proprietarioEdicao = new Proprietario(TipoPessoaEnum.PF);
	}
	
	public void save(){
		proprietarioService.save(proprietarioEdicao);
		
		consultar();
		
		messages.info("Proprietario salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(Arrays.asList("form:msgs", "form:proprietarios-table"));
	}
	
	public void excluir(){
		proprietarioService.excluir(proprietarioSelecionado);
		proprietarioSelecionado = null;
		
		consultar();
		
		messages.info("Proprietario excluido com sucesso!");
	}
	
	public TipoPessoaEnum[] tiposPessoa(){
		return TipoPessoaEnum.values();
	}

	public ProprietarioService getProprietarioService() {
		return proprietarioService;
	}

	public void setProprietarioService(ProprietarioService proprietarioService) {
		this.proprietarioService = proprietarioService;
	}

	public FacesMessages getMessages() {
		return messages;
	}

	public void setMessages(FacesMessages messages) {
		this.messages = messages;
	}

	public List<Proprietario> getProprietarioList() {
		return proprietarioList;
	}

	public void setProprietarioList(List<Proprietario> proprietarioList) {
		this.proprietarioList = proprietarioList;
	}

	public Proprietario getProprietarioEdicao() {
		return proprietarioEdicao;
	}

	public void setProprietarioEdicao(Proprietario proprietarioEdicao) {
		this.proprietarioEdicao = proprietarioEdicao;
	}

	public Proprietario getProprietarioSelecionado() {
		return proprietarioSelecionado;
	}

	public void setProprietarioSelecionado(Proprietario proprietarioSelecionado) {
		this.proprietarioSelecionado = proprietarioSelecionado;
	}
	
	public List<Proprietario> completarProprietario(String nome){
		return proprietarioService.listAllByNome(nome);
	}
	
}
