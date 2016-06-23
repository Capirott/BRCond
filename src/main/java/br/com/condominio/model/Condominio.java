package br.com.condominio.model;

import java.util.Set;

import javax.persistence.CascadeType;
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
import org.hibernate.validator.constraints.br.CNPJ;


@Entity
@Table(name = "CONDOMINIO")
public class Condominio implements Entidade{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cd_codi")
	private Long id;

	@CNPJ
	@Column(name = "cd_insc", unique = true)
	private String cnpj;
	
	@NotEmpty
	@Column(name = "cd_nome", nullable = false)
	private String nome;
	
	@NotEmpty
	@Column(name = "cd_endereco")
	private String endereco;
	
	@NotEmpty
	@Column(name = "cd_numero")
	private String numero;
	
	@NotEmpty
	@Column(name = "cd_cidade")
	private String cidade;
	
	@NotEmpty
	@Column(name = "cd_bairro")
	private String bairro;
	
	@NotEmpty
	@Column(name = "cd_uf")
	private String uf;
	
	@NotEmpty
	@Column(name = "cd_cep")
	private String cep;	
	
	@NotEmpty
	@Column(name = "cd_fone")
	private String fone;	
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "pr_codi", nullable = false)
	private Proprietario proprietario;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "condominio", cascade={CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
	private Set<Apartamento> apartamentos;
	
	public Condominio() {}

	@Override
	public Long getId() {
		return id;
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
	public void setId(Long id) {
		this.id = id;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Set<Apartamento> getApartamentos() {
		return apartamentos;
	}

	public void setApartamentos(Set<Apartamento> apartamentos) {
		this.apartamentos = apartamentos;
	}

}
