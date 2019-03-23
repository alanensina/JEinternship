package com.example.jexperts.dao;

import java.util.List;

import com.example.jexperts.domain.Pessoa;

public interface PessoaDAOInterface {

	void save(Pessoa pessoa);

	void update(Pessoa pessoa);

	void delete(Long id);

	Pessoa findById(Long id);

	List<Pessoa> findAll();

	List<Pessoa> findBySuperior(Long id);
}