package com.example.jexperts.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.jexperts.domain.Pessoa;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

	@GetMapping("/cadastrar")
	public String cadastrar(Pessoa pessoa) {
		return "/pessoa/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(Pessoa pessoa) {
		return "/pessoa/lista"; 
	}
	
}
