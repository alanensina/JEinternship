package com.example.jexperts.service;

import java.util.List;

import com.example.jexperts.domain.Pessoa;

public interface PessoaServiceInterface {
	
	void salvar(Pessoa pessoa);
	
	void editar(Pessoa pessoa);
	
	void excluir(Long id);
	
	Pessoa buscarPorId(Long id);
	
	List<Pessoa> buscarTodos();

	List<Pessoa> buscarPorNome(String nome);
	
}