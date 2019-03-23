package com.example.jexperts.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
	@Size(min = 2, max = 255)
	@Column(nullable = false)
	private String nome;
	
	@NotBlank
	@Column(nullable = false)
	private String email;

	@NotNull
	@Column(nullable = false)
	@Size(min = 14 , max = 14, message = "{Size.pessoa.cpf}")
	private String cpf;
	
	@Column
	private String telefone;
	
	@NotNull
	@NotBlank
	@Column(nullable = false)
	private String login;
	
	@NotNull
	@NotBlank
	@Column(nullable = false)
	private String senha;
	
	@NotNull(message = "{Size.pessoa.cargo}")
	@Column(nullable = false)
	private String cargo;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk")
	private Endereco endereco;
	
	@JoinColumn(name = "id_superior")
	private long superior;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public long getSuperior() {
		return superior;
	}

	public void setSuperior(long superior) {
		this.superior = superior;
	}
}