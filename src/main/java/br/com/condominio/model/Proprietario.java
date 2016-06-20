package br.com.condominio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import br.com.condominio.enums.TipoPessoaEnum;

@Entity
@Table(name = "COND_PROPRIETARIO")
public class Proprietario implements Entidade{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "in_codi")
	private Long id;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "in_tipo", nullable = false)
	private TipoPessoaEnum tipoPessoa;
	
	@CPF
	@Column(name = "in_cpf")
	private String cpf;
	
	@CNPJ
	@Column(name = "in_cnpj")
	private String cnpj;
	
	@NotEmpty
	@Column(name = "in_nome", nullable = false)
	private String nome;
	
	@NotEmpty
	@Column(name = "in_endereco")
	private String endereco;
	
	@NotEmpty
	@Column(name = "in_numero")
	private String numero;
	
	@NotEmpty
	@Column(name = "in_cidade")
	private String cidade;
	
	@NotEmpty
	@Column(name = "in_bairro")
	private String bairro;
	
	@NotEmpty
	@Column(name = "in_uf")
	private String uf;
	
	@NotEmpty
	@Column(name = "in_cep")
	private String cep;	
	
	@NotEmpty
	@Column(name = "in_fone")
	private String fone;
	
	@NotEmpty
	@Email
	@Column(name = "in_email")
	private String email;
	
	@NotEmpty
	@Column(name = "in_observacoes")
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
