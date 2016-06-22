package br.com.condominio.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "APARTAMENTO")
public class Apartamento implements Entidade {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ap_codi")
	private Long id;
	
	@NotNull
	@Column(name = "ap_andar")
	private Long andar;

	@Column(name = "ap_observacoes")
	private String observacoes;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "apartamento")
	private Set<Inquilino> inquilinos;

	@NotEmpty
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pr_codi")
	private Proprietario proprietario;

	@NotEmpty
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_codi")
	private Condominio condominio;

	public Apartamento() {
	}
	
	public Long getAndar() {
		return andar;
	}

	public void setAndar(Long andar) {
		this.andar = andar;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Set<Inquilino> getInquilinos() {
		return inquilinos;
	}

	public void setInquilinos(Set<Inquilino> inquilinos) {
		this.inquilinos = inquilinos;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public Long getId() {
		return id;
	}
}
