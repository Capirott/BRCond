package br.com.condominio.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.PersistenceException;

import org.primefaces.context.RequestContext;
import br.com.condominio.model.Apartamento;
import br.com.condominio.service.ApartamentoService;
import br.com.condominio.util.FacesMessages;

@Named
@ViewScoped
public class ApartamentoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ApartamentoService apartamentoService;

	@Inject
	private FacesMessages messages;

	private List<Apartamento> apartamentoList;

	private Apartamento apartamentoEdicao = new Apartamento();

	private Apartamento apartamentoSelecionado;

	public void consultar() {
		apartamentoList = apartamentoService.listarTodos();
	}

	public void preparaNovoApartamento() {
		apartamentoEdicao = new Apartamento();
	}

	public void save() {

		try {
			apartamentoService.save(apartamentoEdicao);

			consultar();

			messages.info("Apartamento salvo com sucesso!");

			RequestContext.getCurrentInstance().update(Arrays.asList("form:msgs", "form:apartamentos-table"));
		} catch (PersistenceException e) {
			if (e.getCause().getMessage().contains("ConstraintViolation"))
				messages.error("Apartamento não pode ser adicionado!");
			else
				throw e;
		}
	}

	public void excluir() {
		apartamentoService.excluir(apartamentoSelecionado);
		apartamentoSelecionado = null;

		consultar();

		messages.info("Apartamento excluido com sucesso!");
	}

	public ApartamentoService getApartamentoService() {
		return apartamentoService;
	}

	public void setApartamentoService(ApartamentoService apartamentoService) {
		this.apartamentoService = apartamentoService;
	}

	public FacesMessages getMessages() {
		return messages;
	}

	public void setMessages(FacesMessages messages) {
		this.messages = messages;
	}

	public List<Apartamento> getApartamentoList() {
		return apartamentoList;
	}

	public void setApartamentoList(List<Apartamento> apartamentoList) {
		this.apartamentoList = apartamentoList;
	}

	public Apartamento getApartamentoEdicao() {
		return apartamentoEdicao;
	}

	public void setApartamentoEdicao(Apartamento apartamentoEdicao) {
		this.apartamentoEdicao = apartamentoEdicao;
	}

	public Apartamento getApartamentoSelecionado() {
		return apartamentoSelecionado;
	}

	public void setApartamentoSelecionado(Apartamento apartamentoSelecionado) {
		this.apartamentoSelecionado = apartamentoSelecionado;
	}
}
