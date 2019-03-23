package com.example.jexperts.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.jexperts.domain.Pessoa;

@Repository
public class PessoaDAO extends AbstractDAO<Pessoa, Long> implements PessoaDAOInterface{

	@Override
	public List<Pessoa> findBySuperior(Long id) {
		return createQuery("select f from Pessoa f where f.superior = ?1", id);
	}
	
	

}
