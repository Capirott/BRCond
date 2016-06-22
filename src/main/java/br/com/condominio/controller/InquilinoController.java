package br.com.condominio.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.condominio.enums.TipoPessoaEnum;
import br.com.condominio.model.Inquilino;
import br.com.condominio.service.InquilinoService;
import br.com.condominio.util.FacesMessages;

@Named
@ViewScoped
public class InquilinoController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private InquilinoService inquilinoService;
	
	@Inject
	private FacesMessages messages;
	
	private List<Inquilino> inquilinoList;
	
	private Inquilino inquilinoEdicao = new Inquilino(TipoPessoaEnum.PF);
	
	private Inquilino inquilinoSelecionado;
	
	public void consultar(){
		inquilinoList = inquilinoService.listarTodos();
	}
	
	public void preparaNovoInquilino(){
		inquilinoEdicao = new Inquilino(TipoPessoaEnum.PF);
	}
	
	public void save(){
		inquilinoService.save(inquilinoEdicao);
		
		consultar();
		
		messages.info("Inquilino salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(Arrays.asList("form:msgs", "form:inquilinos-table"));
	}
	
	public void excluir(){
		inquilinoService.excluir(inquilinoSelecionado);
		inquilinoSelecionado = null;
		
		consultar();
		
		messages.info("Inquilino excluido com sucesso!");
	}
	
	public TipoPessoaEnum[] tiposPessoa(){
		return TipoPessoaEnum.values();
	}

	public InquilinoService getInquilinoService() {
		return inquilinoService;
	}

	public void setInquilinoService(InquilinoService inquilinoService) {
		this.inquilinoService = inquilinoService;
	}

	public FacesMessages getMessages() {
		return messages;
	}

	public void setMessages(FacesMessages messages) {
		this.messages = messages;
	}

	public List<Inquilino> getInquilinoList() {
		return inquilinoList;
	}

	public void setInquilinoList(List<Inquilino> inquilinoList) {
		this.inquilinoList = inquilinoList;
	}

	public Inquilino getInquilinoEdicao() {
		return inquilinoEdicao;
	}

	public void setInquilinoEdicao(Inquilino inquilinoEdicao) {
		this.inquilinoEdicao = inquilinoEdicao;
	}

	public Inquilino getInquilinoSelecionado() {
		return inquilinoSelecionado;
	}

	public void setInquilinoSelecionado(Inquilino inquilinoSelecionado) {
		this.inquilinoSelecionado = inquilinoSelecionado;
	}
}
