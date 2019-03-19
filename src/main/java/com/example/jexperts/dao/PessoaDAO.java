package com.example.jexperts.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.jexperts.domain.Pessoa;

@Repository
public class PessoaDAO extends AbstractDAO<Pessoa, Long> implements PessoaDAOInterface{

	@Override
	public List<Pessoa> findByNome(String nome) {
		return createQuery("select p from Pessoa p where p.nome like concat('%', ?1, '%')", nome);
	}
	
	

}
