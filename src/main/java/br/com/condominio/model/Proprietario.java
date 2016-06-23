package br.com.condominio.model;

import java.util.Set;

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
@Table(name = "PROPRIETARIO")
public class Proprietario implements Entidade{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pr_codi")
	private Long id;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proprietario")
	private Set<Condominio> condominios;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proprietario")
	private Set<Apartamento> apartamentos;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "pr_tipo", nullable = false)
	private TipoPessoaEnum tipoPessoa;
	
	public Set<Condominio> getCondominios() {
		return condominios;
	}

	public void setCondominios(Set<Condominio> condominios) {
		this.condominios = condominios;
	}

	public Set<Apartamento> getApartamentos() {
		return apartamentos;
	}

	public void setApartamentos(Set<Apartamento> apartamentos) {
		this.apartamentos = apartamentos;
	}

	@CPF
	@Column(name = "pr_cpf", unique = true)
	private String cpf;
	
	@CNPJ
	@Column(name = "pr_cnpj", unique = true)
	private String cnpj;
	
	@NotEmpty
	@Column(name = "pr_nome", nullable = false)
	private String nome;
	
	@NotEmpty
	@Column(name = "pr_endereco")
	private String endereco;
	
	@NotEmpty
	@Column(name = "pr_numero")
	private String numero;
	
	@NotEmpty
	@Column(name = "pr_cidade")
	private String cidade;
	
	@NotEmpty
	@Column(name = "pr_bairro")
	private String bairro;
	
	@NotEmpty
	@Column(name = "pr_uf")
	private String uf;
	
	@NotEmpty
	@Column(name = "pr_cep")
	private String cep;	
	
	@NotEmpty
	@Column(name = "pr_fone")
	private String fone;
	
	@NotEmpty
	@Email
	@Column(name = "pr_email")
	private String email;
	
	@Column(name = "pr_observacoes")
	private String observacoes;
	
	public Proprietario() {}
	
	public Proprietario(TipoPessoaEnum tipoPessoa){
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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
