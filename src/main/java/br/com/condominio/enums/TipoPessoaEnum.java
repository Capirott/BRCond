package br.com.condominio.enums;

public enum TipoPessoaEnum {
	PF("Pessoa Fisica"),
	PJ("Pessoa Juridica");

	private String descricao;

	TipoPessoaEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
