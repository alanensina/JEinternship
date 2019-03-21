package com.example.jexperts.domain;

public enum Cargo {

	DIR("Diretor"), GER("Gerente"), CON("Consultor");

	private String descricao;

	private Cargo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}