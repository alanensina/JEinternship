package com.example.jexperts.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table
public class Pessoa extends AbstractEntity<Long>{
	
	@NotBlank
	@NotNull
	@Size(max = 255, min = 3)
	@Column(unique = true)
	private String nome;
	
	@NotBlank
	@NotNull
	@Column
	private String email;
	
	@Column
	private String telefone;
	
	@NotNull(message = "{NotNull.pessoa.cargo}")
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Cargo cargo;
	
	@NotBlank
	@NotNull
	@Size(max = 15, min = 4)
	@Column(unique = true)
	private String login;
	
	@NotBlank
	@NotNull
	@Size(max = 15, min = 4)
	@Column
	private String senha;
	
	@NotBlank
	@NotNull
	@Column(unique = true)
	private String cpf;
	
	@NotBlank
	@NotNull
	@ManyToOne
	@JoinColumn(name = "superior_id_fk")
	private Pessoa superior;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk")
	private Endereco endereço;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Pessoa getSuperior() {
		return superior;
	}

	public void setSuperior(Pessoa superior) {
		this.superior = superior;
	}

	public Endereco getEndereço() {
		return endereço;
	}

	public void setEndereço(Endereco endereço) {
		this.endereço = endereço;
	}
}