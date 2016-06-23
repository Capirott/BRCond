package br.com.condominio.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import br.com.condominio.enums.TipoPessoaEnum;

@Entity
@Table(name = "INQUILINO")
public class Inquilino implements Entidade{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "in_codi")
	private Long id;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inquilino", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Apartamento> apartamentos;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "in_tipo", nullable = false)
	private TipoPessoaEnum tipoPessoa;
	
	@CPF
	@Column(name = "in_cpf", unique = true)
	private String cpf;
	
	@CNPJ
	@Column(name = "in_cnpj", unique = true)
	private String cnpj;
	
	@NotEmpty
	@Column(name = "in_nome", nullable = false)
	private String nome;
			
	
	@NotEmpty
	@Column(name = "in_fone")
	private String fone;
	
	@NotEmpty
	@Email
	@Column(name = "in_email")
	private String email;
	
	@Column(name = "in_observacoes")
	private String observacoes;
	
	public Inquilino() {}
	
	public Inquilino(TipoPessoaEnum tipoPessoa){
		this.tipoPessoa = tipoPessoa;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	public TipoPessoaEnum getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoaEnum tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getIdentificador(){
		if(tipoPessoa == null)
			return null;
		
		if(tipoPessoa.equals(TipoPessoaEnum.PF))
			return cpf;
		
		if(tipoPessoa.equals(TipoPessoaEnum.PJ))
			return cnpj;
		
		return null;
	}

}
